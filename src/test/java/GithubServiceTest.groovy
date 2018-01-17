import makersmarker.GithubService
import spock.lang.Specification

class GithubServiceTest extends Specification{

    def "The requestRepo() method returns a HashMap response" () {
        given: "An instance of a GithubService"
        GithubService githubService = new GithubService()

        when: " A Get request for Repos is called"
        HashMap repository
        repository = githubService.requestRepo()

        then:"A HashMap object is returned"
        repository instanceof HashMap

    }

    def "The requestPulls() method returns a HashMap[] response" () {
        given:
        GithubService githubService = new GithubService()

        when:
        HashMap[] pulls
        pulls = githubService.requestPulls()

        then:
        pulls instanceof HashMap[]
    }
}


