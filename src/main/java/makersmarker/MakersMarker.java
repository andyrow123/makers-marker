package makersmarker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;


public class MakersMarker {

    private static final Logger log = LoggerFactory.getLogger(MakersMarker.class);

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        JSONDomain jsonDomain = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/1", JSONDomain.class);
        log.info(jsonDomain.toString());
    }
}
