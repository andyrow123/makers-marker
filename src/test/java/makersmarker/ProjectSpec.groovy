package makersmarker

import makersmarker.Project
import spock.lang.Specification

import static org.hamcrest.Matchers.*
import static org.hamcrest.MatcherAssert.assertThat

class ProjectSpec extends Specification {

    Project project

    def setup() {
        project = new Project("Test", [1])
    }

    def "should be an instance of Project"() {
        expect:
        project instanceof Project

    }

    def "should have a name when set" () {
        when: "makersmarker.Project name is set"
        project.setName("Airport")

        then: "makersmarker.Project name should be Airport"
        project.getName() == "Airport"

    }

    def "should return list of pull requests"() {
        when:
        project.setPulls([1, 2, 3] as List<Integer>)

        then:
        assertThat(project.getPulls(), hasSize(3))
    }

    def "#addPull() adds a pull to pulls array"() {
        when:
        project.addPull(4)

        then:
        assertThat(project.getPulls(), hasItem(4))
    }

}

