package makersmarker

import spock.lang.*

class JSONdomainTest extends Specification {
    JSONDomain jsonDomain = new JSONDomain()

    def "test to String"() {
        when:
        String result = jsonDomain.toString()

        println(result)

        then:
        result == "JSONDomain{userId=0, id=0, title='null', body='null'}"
    }
}
