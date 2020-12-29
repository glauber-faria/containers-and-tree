package questao1;

public class Software {
	private String nome;
	private int tamanho;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	public Software(String nome, int tamanho) {
		this.setNome(nome);
		this.setTamanho(tamanho);
	}
}
