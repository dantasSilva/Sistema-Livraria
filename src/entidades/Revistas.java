package entidades;

// Classe herda da classe 'Produto'
public class Revistas extends Produto{
	// Declaração de atributo
	private int volume;
	
	// Construtor que recebe os detalhes da revista como argumento 
	public Revistas(String tipo, String titulo, String autor, String isbn, String anoPublicacao, double preco,int qtd,  int volume) {
		
        // Chama o construtor da classe base (`Produto`)
		super(tipo, titulo, autor, isbn, anoPublicacao, preco, qtd);
		
		//Define o tipo do produto como "Revista"
		super.setTipo("Revista");
		this.volume = volume;
	}
	
	//Métodos getter e setter
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
}
