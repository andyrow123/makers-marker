package makersmarker.entities

import spock.lang.Specification

import static org.hamcrest.Matchers.*
import static org.hamcrest.MatcherAssert.assertThat

class ProjectTest extends Specification {
        Account account = new Account()
        Project gitHubProject

    def setup() {
        gitHubProject = new Project()
        gitHubProject.setAccount(account)
    }

    def "should be an instance of GitHubProject"() {
        expect:
        gitHubProject instanceof Project

    }

    def "should have a name when set" () {
        when: "makersmarker.entities.Project name is set"
        gitHubProject.setName("Airport")

        then: "makersmarker.entities.Project name should be Airport"
        gitHubProject.getName() == "Airport"

    }

    def "should return list of pull requests"() {
        expect:
        assertThat(gitHubProject.getPulls(), hasSize(0))
    }

//    def "#addPull() adds a pull to pulls array"() {
//        when:
//        project.addGitHubPull(4)
//
//        then:
//        assertThat(project.getPulls(), hasItem(4))
//    }

}

