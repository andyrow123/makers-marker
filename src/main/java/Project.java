import java.util.ArrayList;

public class Project {

    private String name;
    private ArrayList<Integer> pulls;

    public Project(String name, ArrayList<Integer> pulls) {
        this.name = name;
        this.pulls = pulls;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getPulls() {
        return pulls;
    }

    public void setPulls(ArrayList<Integer> pulls) {
        this.pulls = pulls;
    }
}
