package makersmarker.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Map;

//@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Pull {

    @JsonIgnore
    @ManyToOne
    private Project project;

    @Id
    @GeneratedValue
    private long id;
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
    private String userApiUrl;
    private String userHtmlUrl;

    @SuppressWarnings("unchecked")
    @JsonProperty("user")
    private void unpackNested(Map<String,Object> user) {
        this.userLogin = (String)user.get("login");
        this.userId = (int)user.get("id");
        this.userAvatarUrl = (String)user.get("avatar_url");
        this.userApiUrl = (String)user.get("url");
        this.userHtmlUrl = (String)user.get("html_url");
    }

    public Pull() {

    }

    public Pull(Project project, String htmlUrl, String diffUrl, int number, String state, String title, String userLogin, int userId, String userAvatarUrl, String userApiUrl, String userHtmlUrl) {
        this.project = project;
        this.htmlUrl = htmlUrl;
        this.diffUrl = diffUrl;
        this.number = number;
        this.state = state;
        this.title = title;
        this.userLogin = userLogin;
        this.userId = userId;
        this.userAvatarUrl = userAvatarUrl;
        this.userApiUrl = userApiUrl;
        this.userHtmlUrl = userHtmlUrl;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public long getId() {
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

    public String getUserApiUrl() {
        return userApiUrl;
    }

    public String getUserHtmlUrl() {
        return userHtmlUrl;
    }

    @Override
    public String toString() {
        return "Pull{" +
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
