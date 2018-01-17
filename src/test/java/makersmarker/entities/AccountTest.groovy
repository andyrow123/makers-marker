package makersmarker.entities

import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class AccountTest extends Specification {
    @Mock
    Set<Project> projects
    @InjectMocks
    Account account

    def setup() {
        MockitoAnnotations.initMocks(this)
    }
}
