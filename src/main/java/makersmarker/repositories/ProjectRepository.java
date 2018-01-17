package makersmarker.repositories;

import makersmarker.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Optional<Project> findByAccountUsername(String username);
    Collection<Project> getByAccountUsername(String username);

    Optional<Project> findById(long id);

    Collection<Project> findByAccountId(long id);
}
