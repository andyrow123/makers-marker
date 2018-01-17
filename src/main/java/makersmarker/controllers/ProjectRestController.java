package makersmarker.controllers;

import makersmarker.entities.Project;
import makersmarker.exceptions.UserNotFoundException;
import makersmarker.repositories.AccountRepository;
import makersmarker.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/{username}/projects")
class ProjectRestController {

    private final ProjectRepository projectRepository;

    private final AccountRepository accountRepository;

    @Autowired
    ProjectRestController(ProjectRepository projectRepository,
                          AccountRepository accountRepository) {
        this.projectRepository = projectRepository;
        this.accountRepository = accountRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    Collection<Project> readProjects(@PathVariable String username) {
        this.validateUser(username);
        return this.projectRepository.getByAccountUsername(username);
        // return this.projectRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> add(@PathVariable String username, @RequestBody Project input) {
        this.validateUser(username);

        return this.accountRepository
                .findByUsername(username)
                .map(account -> {
                    Project newProject = new Project();
                    newProject.setAccount(account);
                    Project result = projectRepository.save(newProject);

                    URI location = ServletUriComponentsBuilder
                            .fromCurrentRequest().path("/{id}")
                            .buildAndExpand(result.getId()).toUri();

                    return ResponseEntity.created(location).build();
                })
                .orElse(ResponseEntity.noContent().build());

    }

    @RequestMapping(method = RequestMethod.GET, value = "/{projectId}")
    Project readProject(@PathVariable String username, @PathVariable Long projectId) {
        this.validateUser(username);
        return this.projectRepository.findOne(projectId);
    }

    private void validateUser(String username) {
        this.accountRepository.findByUsername(username).orElseThrow(
                () -> new UserNotFoundException(username));
    }
}
