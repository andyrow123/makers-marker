package makersmarker.entities

import spock.lang.*

class PullTest extends Specification {
    private Pull pull

    def setup() {
        pull = new Pull()
    }

    def "should be an instance of Project"() {
        expect:
        pull instanceof Pull

    }
}
