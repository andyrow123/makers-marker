import spock.lang.Specification

class ProjectSpec extends Specification {

    Project project;

    def setup() {
        project = new Project("Test", [1])
    }

    def "should have a name when set" () {
        when: "Project name is set"
        project.setName("Airport")

        then: "Project name should be Airport"
        project.getName() == "Airport"

    }

    def "should return list of pull requests"() {
        when:
//        int[] testArray = Arrays.asList(1,2)
        project.setPulls([1,2,3])

        then:
//        println project.getPulls().size()
        project.getPulls().size() == 3


    }

}

