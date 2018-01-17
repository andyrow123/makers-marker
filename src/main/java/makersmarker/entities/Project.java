package makersmarker.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
public class Project {

    @OneToMany(mappedBy = "project")
    private Set<Pull> pulls = new HashSet<>();

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
    private String ownerLogin;
    private int ownerId;
    private String ownerAvatarUrl;
    private String ownerApiUrl;
    private String ownerHtmlUrl;

    @SuppressWarnings("unchecked")
    @JsonProperty("owner")
    private void unpackNested(Map<String,Object> owner) {
        this.ownerLogin = (String)owner.get("login");
        this.ownerId = (int)owner.get("id");
        this.ownerAvatarUrl = (String)owner.get("avatar_url");
        this.ownerApiUrl = (String)owner.get("url");
        this.ownerHtmlUrl = (String)owner.get("html_url");

    }

    public Project() { // jpa only
    }

    public Project(Account account, String name, String fullName, String ownerLogin, int ownerId, String ownerAvatarUrl, String ownerApiUrl, String ownerHtmlUrl) {
        this.account = account;
        this.name = name;
        this.fullName = fullName;
        this.ownerLogin = ownerLogin;
        this.ownerId = ownerId;
        this.ownerAvatarUrl = ownerAvatarUrl;
        this.ownerApiUrl = ownerApiUrl;
        this.ownerHtmlUrl = ownerHtmlUrl;
    }

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

    public Set<Pull> getPulls() {
        return pulls;
    }

    public void addPull(Pull pull) {
        this.pulls.add(pull);
    }

    public String getOwnerLogin() {
        return ownerLogin;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public String getOwnerAvatarUrl() {
        return ownerAvatarUrl;
    }

    public String getOwnerApiUrl() {
        return ownerApiUrl;
    }

    public String getOwnerHtmlUrl() {
        return ownerHtmlUrl;
    }
}
