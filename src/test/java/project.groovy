import spock.lang.Specification

class ProjectSpec extends Specification {

    Project project = new Project("Test")

    def "should have a name when set" () {
        when: "Project name is set"
        project.setName("Airport")

        then: "Project name should be Airport"
        project.getName() == "Airport"

    }

}

