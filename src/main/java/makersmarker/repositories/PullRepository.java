package makersmarker.repositories;

import makersmarker.entities.Pull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface PullRepository extends JpaRepository<Pull, Long> {
    Collection<Pull> findByProjectId(long id);
}
