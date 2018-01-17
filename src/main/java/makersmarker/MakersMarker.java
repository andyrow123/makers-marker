package makersmarker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;


public class MakersMarker {

    private static final Logger log = LoggerFactory.getLogger(MakersMarker.class);

    public static void main(String[] args) {
        GithubService githubService = new GithubService();
    }
}
