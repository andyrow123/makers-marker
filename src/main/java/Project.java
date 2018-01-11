import java.util.List;

public class Project {

    private String name;
    private List<Integer> pulls;

    public Project(String name, List<Integer> pulls) {
        this.name = name;
        this.pulls = pulls;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getPulls() {
        return pulls;
    }

    public void setPulls(List<Integer> pulls) {
        this.pulls = pulls;
    }

    public void addPull(int pull) {
        this.pulls.add(pull);
    }
}
