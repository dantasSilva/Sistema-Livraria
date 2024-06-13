package entidades;

// Classe herda da classe 'Produto'
public class Livros extends Produto {
	// Declaração de atributo
	private String genero;
	
	// Construtor que recebe os detalhes do livro como argumento 
	public Livros(String tipo, String titulo, String autor, String isbn, String anoPublicacao, double preco, int qtd, String genero) {
		
        // Chama o construtor da classe base (`Produto`)
		super(tipo, titulo, autor, isbn, anoPublicacao, preco, qtd);
		
		// Define o tipo do produto como "Livro" 
		super.setTipo("Livro");
		this.genero = genero;		
	}
	
	//Métodos getter e setter
	public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }    
	
}
