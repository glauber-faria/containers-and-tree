package questao1;
import java.util.ArrayList;


public class Compose {

	private ArrayList<Container> containers = new ArrayList<>();
	
	public ArrayList<Container> getContainers() {
		return containers;
	}
	
	public void addContainer(Container container) {
		this.containers.add(container);
	}
	public void run() {
		for (int i = 0; i < this.getContainers().size(); i++) {
			this.getContainers().get(i).run();
		}
	}
	public int getTamanhoTempoReal() {
		int total = 0;
		for (int i = 0; i < this.getContainers().size(); i++) {
			
			if(this.getContainers().get(i).getState() == true) {
				for(int j = 0; j < this.getContainers().get(i).getSoftwares().size(); j++) {
					total +=  this.getContainers().get(i).getSoftwares().get(j).getTamanho();
					//System.out.println(this.getContainers().get(i).getSoftwares().get(j).getNome()+"-"+this.getContainers().get(i).getSoftwares().get(j).getTamanho());
				}
			}
				
			else {
				continue;
			}
		}
		return total;
	}
}
