package questao1;
import java.util.ArrayList;

public class Container {
	private ArrayList<Software> softwares = new ArrayList<>();
	private Boolean state;
	
	public ArrayList<Software> getSoftwares() {
		return softwares;
	}
	public void addSoftware(Software software) {
		this.softwares.add(software);
	}
	
	public Boolean getState() {
		return state;
	}
	public void run() {
		if(!this.getState()) {
			this.state = true;
		}
	}
	public void stop() {
		if(!this.getState()) {
			this.state = false;
		}
	}
	
	public Container() {
		this.state = false;
	}
	
	
	
}
