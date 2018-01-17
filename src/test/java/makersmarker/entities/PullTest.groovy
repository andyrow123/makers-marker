package makersmarker.entities

import spock.lang.*

class GitHubPullTest extends Specification {
    private GitHubPull pull

    def setup() {
        pull = new GitHubPull()
    }

    def "should be an instance of Project"() {
        expect:
        pull instanceof GitHubPull

    }
}
