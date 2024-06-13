package entidades;

//Classe base
public class Produto {
	// Declaração de atributos
	 	private String tipo;
	 	private String titulo;
	 	private String autor;
	 	private String isbn;
	 	private String anoPublicacao;
	 	private double preco;
	 	private int qtd;
		
	 // Construtor padrão	
		public Produto() {}
			
	// Construtor que recebe detalhes do produto como argumento
		public Produto(String tipo, String titulo, String autor, String isbn, String anoPublicacao, double preco, int qtd) {
			this.tipo = tipo;
			this.titulo = titulo;
			this.autor = autor;
			this.isbn = isbn;
			this.anoPublicacao = anoPublicacao;
			this.preco = preco;
			this.qtd=qtd;
		}
		
	// Métodos getter e setter 	
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		public String getTitulo() {
			return titulo;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public String getAutor() {
			return autor;
		}
		public void setAutor(String autor) {
			this.autor = autor;
		}
		public String getIsbn() {
			return isbn;
		}
		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}
		public String getAnoPublicacao() {
			return anoPublicacao;
		}
		public void setAnoPublicacao(String anoPublicacao) {
			this.anoPublicacao = anoPublicacao;
		}
		public double getPreco() {
			return preco;
		}
		public void setPreco(double preco) {
			this.preco = preco;
		}
		public int getQtd() {
			return qtd;
		}
		public void setQtd(int qtd) {
			this.qtd = qtd;
		}
}