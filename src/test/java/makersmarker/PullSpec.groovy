package makersmarker

import spock.lang.Specification

class PullSpec extends Specification {

    def "getTitle Method produces a summary of data from the Pulls"() {

        given: "A new pull object is created"
        GithubService githubService = Stub(GithubService)
        githubService.requestPulls() >>> [{title: "text"}]
        def pull

        when: "A series of pull requests are extracted"
        int index = 0
        HashMap[] pulls = githubService.requestPulls()
        pull = new Pull(pulls[index].get("title").toString())

        then: "A summary of the project is produced"
        pull.getTitle() == pulls[0].get("title")
    }

}
