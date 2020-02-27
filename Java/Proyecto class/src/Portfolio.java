import java.util.ArrayList;

public class Portfolio {

	//Atributo
	private ArrayList<Project> projects = new ArrayList<Project>();

	//Getters y Setters
	public ArrayList<Project> getProjects() {
		return projects;
	}

	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}

	//Constructor
	public Portfolio(ArrayList<?> projects) {
		for (Object object : projects) {
			if(object instanceof Project)
				this.projects.add((Project)object);
		}
	}

	//Métodos	
	public double getPortfolioCost(){
		double total=0;
		for (Project project : projects) {
			total+=project.getInitialCost();
		}
		return total;
	}

	public void showPortfolio() {
		for (Project project : this.projects) {
			System.out.println(project.elevatorPitch());
		}
		System.out.println("El costo total es: " + this.getPortfolioCost());
	}
}
