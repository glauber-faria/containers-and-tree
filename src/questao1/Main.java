package questao1;

public class Main {

	public static void main(String[] args) {
				
		Software tomcat = new Software("Tomcat", 300);
		Software java = new Software("Java", 1000);
		Software Debian = new Software("Debian", 2000);
		Software sqlServer = new Software("SQL Server", 400);
		Software net = new Software(".NET", 1000);
		Software ubuntu = new Software("Ubuntu", 2500);
		Software staticBinary = new Software("Static Binary", 200);
		Software alpine = new Software("Alpine", 800);
		
		Container c1 = new Container();
		c1.addSoftware(tomcat);
		c1.addSoftware(java);
		c1.addSoftware(Debian);
		
		Container c2 = new Container();
		c2.addSoftware(sqlServer);
		c2.addSoftware(net);
		c2.addSoftware(ubuntu);
		
		Container c3 = new Container();
		c3.addSoftware(staticBinary);
		c3.addSoftware(alpine);

		
		Compose kernel = new Compose();
		kernel.addContainer(c1);
		kernel.addContainer(c2);
		kernel.addContainer(c3);

		kernel.run();
		//c1.stop();

		System.out.println("Tamanho total: "+ kernel.getTamanhoTempoReal());
		
	}

}
