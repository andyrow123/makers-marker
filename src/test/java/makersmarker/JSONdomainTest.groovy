package makersmarker

import spock.lang.*

class JSONdomainTest extends Specification {
    JSONdomain jSONdomain = new JSONdomain()

    def "test to String"() {
        when:
        String result = jSONdomain.toString()

        println(result)

        then:
        result == "JSONdomain{userId=0, id=0, title='null', body='null'}"
    }
}
