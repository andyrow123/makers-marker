package makersmarker.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pull {
    @Id
    @GeneratedValue
    private long id;

    public long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getGitUsername() {
        return gitUsername;
    }

    private String url;
    private String gitUsername;

    public Pull(String gitUsername, String url) {
        this.gitUsername = gitUsername;
        this.url = url;
    }

    Pull() { // jpa only
    }
}
