package makersmarker

import org.springframework.web.client.RestTemplate
import spock.lang.*

class JSONdomainTest extends Specification {
    JSONDomain jsonDomain = new JSONDomain()
    RestTemplate restTemplate = new RestTemplate()

    def "test to String"() {
        when:
        String result = jsonDomain.toString()

        println(result)

        then:
        result == "JSONDomain{userId=0, id=0, title='null', body='null'}"
    }

    def "test getUserID returns UserID"() {
        when:
        jsonDomain = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/1", JSONDomain.class)

        then:
        jsonDomain.getUserId() == 1
    }
}
