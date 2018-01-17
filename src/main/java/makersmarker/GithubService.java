package makersmarker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

public class GithubService {

    private static final Logger log = LoggerFactory.getLogger(GithubService.class);

    public static HashMap requestRepo()  {
        RestTemplate restTemplate = new RestTemplate();
        HashMap response = restTemplate.getForObject( "https://api.github.com/repos/makersacademy/news-summary-challenge", HashMap.class);
        log.info(response.toString());
        return response;
    }

    public static HashMap[] requestPulls()  {
        RestTemplate restTemplate = new RestTemplate();
        HashMap[] response = restTemplate.getForObject( "https://api.github.com/repos/makersacademy/news-summary-challenge/pulls", HashMap[].class);
        log.info(response[0].get("issue_url").toString());
        return response;
    }
}
