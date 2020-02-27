import java.util.ArrayList;

public class ProjectTest {

	public static void main(String[] args) {
		ArrayList<Project> projects = new ArrayList<>();
		projects.add(new Project("Alpha", "Este es el proyecto alpha", 225.3));
		projects.add(new Project("Beta", "Este es el proyecto beta", 123.2));
		projects.add(new Project("Gamma", "Este es el proyecto gamma", 200));

		Portfolio pf = new Portfolio(projects);
		pf.showPortfolio();
	}

}
