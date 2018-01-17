package makersmarker.repositories

import makersmarker.Application
import makersmarker.entities.Project
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.*

@SpringBootTest(classes = Application)
@ContextConfiguration(classes = [ProjectRepository])
class ProjectRepositoryTest extends Specification {

    @Autowired
    ProjectRepository gitHubProjectRepository

    def gitHubProject = new Project()

    def setup() {
//        MockitoAnnotations.initMocks(this)
    }

    def "find GitHub Project by Id" () {

        gitHubProjectRepository.save(gitHubProject)

        when: "load Project entity"
        Project projectEntityFromDb = gitHubProjectRepository.findOne(gitHubProject.getId())

        then:"saved and retrieved entity by id must be equal"
        gitHubProject.getId() == projectEntityFromDb.getId()
    }

}
