package makersmarker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

public class GithubService {

    private static final Logger log = LoggerFactory.getLogger(GithubService.class);

    public static HashMap requestRepo()  {
        RestTemplate restTemplate = new RestTemplate();
        HashMap response = restTemplate.getForObject( "https://api.github.com/repos/makersacademy/airport_challenge", HashMap.class);
        log.info(response.toString());
        return response;
    }
}
