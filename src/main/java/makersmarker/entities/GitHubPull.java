package makersmarker.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.util.JSONPObject;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Map;

//@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class GitHubPull {
    @Id
    private int id;
    @JsonProperty("html_url")
    private String htmlUrl;
    @JsonProperty("diff_url")
    private String diffUrl;
    private int number;
    private String state;
    private String title;
    private String userLogin;
    private int userId;
    private String userAvatarUrl;

    @SuppressWarnings("unchecked")
    @JsonProperty("user")
    private void unpackNested(Map<String,Object> user) {
        this.userLogin = (String)user.get("login");
        this.userId = (int)user.get("id");
        this.userAvatarUrl = (String)user.get("avatar_url");
    }

    public GitHubPull() {

    }

    public int getId() {
        return id;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public String getDiffUrl() {
        return diffUrl;
    }

    public int getNumber() {
        return number;
    }

    public String getState() {
        return state;
    }

    public String getTitle() {
        return title;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserAvatarUrl() {
        return userAvatarUrl;
    }

    @Override
    public String toString() {
        return "GitHubPull{" +
                "id=" + id +
                ", htmlUrl='" + htmlUrl + '\'' +
                ", diffUrl='" + diffUrl + '\'' +
                ", number=" + number +
                ", state='" + state + '\'' +
                ", title='" + title + '\'' +
                ", userLogin='" + userLogin + '\'' +
                ", userId=" + userId +
                ", userAvatarUrl='" + userAvatarUrl + '\'' +
                '}';
    }
}
