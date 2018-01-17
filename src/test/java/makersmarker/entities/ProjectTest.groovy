package makersmarker.entities

import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import spock.lang.Specification

import static org.hamcrest.Matchers.*
import static org.hamcrest.MatcherAssert.assertThat

class GitHubProjectTest extends Specification {
        Account account = new Account()
        GitHubProject gitHubProject

    def setup() {
        gitHubProject = new GitHubProject()
        gitHubProject.setAccount(account)
    }

    def "should be an instance of GitHubProject"() {
        expect:
        gitHubProject instanceof GitHubProject

    }

    def "should have a name when set" () {
        when: "makersmarker.entities.GitHubProject name is set"
        gitHubProject.setName("Airport")

        then: "makersmarker.entities.GitHubProject name should be Airport"
        gitHubProject.getName() == "Airport"

    }

    def "should return list of pull requests"() {
        expect:
        assertThat(gitHubProject.getGitHubPulls(), hasSize(0))
    }

//    def "#addPull() adds a pull to pulls array"() {
//        when:
//        gitHubProject.addGitHubPull(4)
//
//        then:
//        assertThat(gitHubProject.getGitHubPulls(), hasItem(4))
//    }

}

