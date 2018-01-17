package makersmarker.services;

import makersmarker.entities.Project;
import makersmarker.entities.Pull;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GitHubService {

    private static final String apiUrl = "https://api.github.com/";

    public ResponseEntity<HashMap> getGitHubProject(String repositoryAccount, String repositoryName) {
        RestTemplate restTemplate = new RestTemplate();
        ParameterizedTypeReference<HashMap> listOfStrings = new ParameterizedTypeReference<HashMap>() {};
        ResponseEntity<HashMap> response = restTemplate.exchange(apiUrl + "repos/" + repositoryAccount + "/" + repositoryName, HttpMethod.GET, null, listOfStrings);
        return response;
    }

//    public Project getGitHubProject(String repositoryAccount, String repositoryName) {
//        RestTemplate restTemplate = new RestTemplate();
//        Project project = restTemplate.getForObject(apiUrl + "repos/" + repositoryAccount + "/" + repositoryName, Project.class);
//        return project;
//    }

    public ResponseEntity<HashMap[]> getGitHubProjectPulls(String repositoryAccount, String repositoryName) {
        RestTemplate restTemplate = new RestTemplate();
        ParameterizedTypeReference<HashMap[]> listOfStrings = new ParameterizedTypeReference<HashMap[]>() {};
        ResponseEntity<HashMap[]> response = restTemplate.exchange(apiUrl + "repos/" + repositoryAccount + "/" + repositoryName + "/pulls", HttpMethod.GET, null, listOfStrings);
//        Pull[] pulls = restTemplate.getForObject(apiUrl + "repos/" + repositoryAccount + "/" + repositoryName + "/pulls", Pull[].class);
        return response;
    }

//    public Pull[] getGitHubProjectPulls(String repositoryAccount, String repositoryName) {
//        RestTemplate restTemplate = new RestTemplate();
//        Pull[] pulls = restTemplate.getForObject(apiUrl + "repos/" + repositoryAccount + "/" + repositoryName + "/pulls", Pull[].class);
//        return pulls;
//    }
}
