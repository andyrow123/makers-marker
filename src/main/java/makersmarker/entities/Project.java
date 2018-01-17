package makersmarker.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class GitHubProject {

    @OneToMany(mappedBy = "gitHubProject")
    private Set<GitHubPull> gitHubPulls = new HashSet<>();

    @JsonIgnore
    @ManyToOne
    private Account account;

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    private String name;
    @JsonProperty("full_name")
    private String fullName;

    public GitHubProject() { // jpa only
    }

//    public GitHubProject(Account account, String name) {
//        this.name = name;
//        this.gitHubPulls = gitHubPulls;
//        this.account = account;
//    }


    public Long getId() {
        return id;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public Set<GitHubPull> getGitHubPulls() {
        return gitHubPulls;
    }

    public void addGitHubPull(GitHubPull gitHubPull) {
        this.gitHubPulls.add(gitHubPull);
    }
}
