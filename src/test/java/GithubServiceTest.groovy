import makersmarker.GithubService
import spock.lang.Specification

class GithubServiceTest extends Specification{

    def "The GetPulls method returns a JSON response" () {
        given: "An instance of a GithubService"
        GithubService githubService = new GithubService()

        when: " A Get request for pulls is called"
        HashMap pulls
        pulls = githubService.requestRepo()

        then:"A HashMap object is returned"
        pulls instanceof HashMap

    }
}


