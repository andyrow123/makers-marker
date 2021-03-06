package makersmarker

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import spock.lang.*

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.equalTo


class MakersMarkerTest extends Specification {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<JSONDomain> response = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts/1", JSONDomain.class);
    //    JSONdomain jsoNdomain = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/1", JSONDomain.class);

    def "Returns 200 response"() {
        expect:
        println(response)
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK))
    }
}