package makersmarker.controllers;

import makersmarker.entities.Pull;
import makersmarker.exceptions.UserNotFoundException;
import makersmarker.repositories.ProjectRepository;
import makersmarker.repositories.PullRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/{username}/projects/{projectId}/pulls")
class PullRestController {

    private final PullRepository pullRepository;

    private final ProjectRepository projectRepository;

    @Autowired
    PullRestController(PullRepository pullRepository,
                       ProjectRepository projectRepository) {
        this.pullRepository = pullRepository;
        this.projectRepository = projectRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    Collection<Pull> readPulls(@PathVariable String username, @PathVariable long projectId) {
        this.validateUser(username);
        return this.pullRepository.findByProjectId(projectId);
        // return this.pullRepository.findAll();
    }

//    @RequestMapping(method = RequestMethod.POST)
//    ResponseEntity<?> add(@PathVariable long userId, @PathVariable long gitHubProjectId, @RequestBody Pull input) {
//        this.validateUser(userId);
//
//        return this.projectRepository
//                .findById(gitHubProjectId)
//                .map(gitHubProject -> {
//                    Pull result = pullRepository.save(new Pull(gitHubProject,
//                            input.getName()));
//
//                    URI location = ServletUriComponentsBuilder
//                            .fromCurrentRequest().path("/{id}")
//                            .buildAndExpand(result.getId()).toUri();
//
//                    return ResponseEntity.created(location).build();
//                })
//                .orElse(ResponseEntity.noContent().build());
//
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/{pullId}")
    Pull readPull(@PathVariable String username, @PathVariable long pullId) {
        this.validateUser(username);
        return this.pullRepository.findOne(pullId);
    }

    private void validateUser(String username) {
        this.projectRepository.findByAccountUsername(username).orElseThrow(
                () -> new UserNotFoundException(username));
    }
}
