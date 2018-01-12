package makersmarker.entities

import spock.lang.*

class GitHubPullTest extends Specification {
    GitHubPull gitHubPull = new GitHubPull()

    def "test to String"() {
        when:
        String result = gitHubPull.toString()

        then:
        result == "GitHubPull{id=0, htmlUrl='null', diffUrl='null', number=0, state='null', title='null', userLogin='null', userId=0, userAvatarUrl='null'}"
        println(result)
    }
}
