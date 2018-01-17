package makersmarker;

import makersmarker.entities.Account;
import makersmarker.entities.Pull;
import makersmarker.entities.Project;
import makersmarker.repositories.AccountRepository;
import makersmarker.repositories.ProjectRepository;
import makersmarker.repositories.PullRepository;
import makersmarker.services.GitHubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    @Transactional
    CommandLineRunner init(AccountRepository accountRepository,
                           ProjectRepository projectRepository,
                           PullRepository pullRepository) {
        return (evt) -> Arrays.asList(
                "testuser".split(","))
                .forEach(
                        a -> {
                            Account account = accountRepository.save(new Account(a,
                                    "password"));

                            GitHubService service = new GitHubService();
                            ResponseEntity<HashMap> projectResponse = service.getGitHubProject("makersacademy", "bowling-challenge");
                            HashMap projectResponseBody = projectResponse.getBody();
                            HashMap owner = (HashMap) projectResponseBody.get("owner");

                            Project project = new Project(
                                    account,
                                    (String) projectResponseBody.get("name"),
                                    (String) projectResponseBody.get("full_name"),
                                    (String) owner.get("login"),
                                    (int) owner.get("id"),
                                    (String) owner.get("avatar_url"),
                                    (String) owner.get("url"),
                                    (String) owner.get("html_url")
                            );
                            Project project1 = projectRepository.save(project);

                            ResponseEntity<HashMap[]> pullsResponse = service.getGitHubProjectPulls("makersacademy", "bowling-challenge");
                            HashMap[] pullsResponseBody = pullsResponse.getBody();
                            for(HashMap pullResponseBody : pullsResponseBody) {
                                HashMap user = (HashMap) pullResponseBody.get("user");
                                Pull pull = new Pull(
                                        project1,
                                        (String) pullResponseBody.get("html_url"),
                                        (String) pullResponseBody.get("diff_url"),
                                        (int) pullResponseBody.get("number"),
                                        (String) pullResponseBody.get("state"),
                                        (String) pullResponseBody.get("title"),
                                        (String) user.get("login"),
                                        (int) user.get("id"),
                                        (String) user.get("avatar_url"),
                                        (String) user.get("url"),
                                        (String) user.get("html_url")
                                );
                                pullRepository.save(pull);
                            }
                        });
    }

//    @Bean
//    public CommandLineRunner run() throws Exception {
//        return args -> {
//
//        };
//    }
}
