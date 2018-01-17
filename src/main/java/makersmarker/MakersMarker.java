package makersmarker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;


public class MakersMarker {

    private static final Logger log = LoggerFactory.getLogger(MakersMarker.class);

    public static void main(String[] args) {
        GithubService githubService = new GithubService();
        HashMap[] hashPulls = githubService.requestPulls();
        Pull[] pulls = hashMapToPulls(hashPulls);

    }

    public static Pull[] hashMapToPulls(HashMap[] hashPulls) {
        Pull[] pulls = new Pull[hashPulls.length];
        int count = 0;
        for(HashMap hashPull:hashPulls) {
            pulls[count] = new Pull(hashPull.get("title").toString());
            count++;
        }

        return pulls;
    }
}
