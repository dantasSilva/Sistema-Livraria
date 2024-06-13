package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

// Importa as classes de entidades
import aplicacao.Programa;
import entidades.Livros;
import entidades.Revistas;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//Classe principal da tela principal do sistema
public class TPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TPrincipal frame = new TPrincipal();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// Construtor da classe TPrincipal
	public TPrincipal() {
	    // Verificação se a lista de produtos está vazia, caso esteja vazia adiciona sete objetos
		if(TCadastro.listaProdutos.isEmpty()) {
            TCadastro.listaProdutos.add(new Livros("Livro","O Alquimista", "Paulo Coelho", "9788584390670", "1988", 29.90, 2,"Romance"));
            TCadastro.listaProdutos.add(new Livros("Livro","Java®: Como Programar", "Paul Deitel, Harvey Deitel", "9788543004792", "2016", 365.25, 3,"Programação"));
            TCadastro.listaProdutos.add(new Revistas("Revista","Dragon Ball", "Akira Toryama", "9786555124644", "1985", 66.98, 4,1));
            TCadastro.listaProdutos.add(new Revistas("Revista","Berserk", "Kentaro Miura", "9781593070205", "2003", 41.99, 5,1));
            TCadastro.listaProdutos.add(new Livros("Livro","Nada pode me ferir", "David Goggins", "9786555646139", "2023", 42.92, 6,"Livro de autoajuda"));
            TCadastro.listaProdutos.add(new Livros("Livro","Memórias póstumas de Brás Cubas", "Machado de Assis", "9788594318619", "2019", 13.93, 7,"Romançe"));
            TCadastro.listaProdutos.add(new Livros("Livro","Engenharia de Software", "Robert C. MartinRoger S. Pressman, Bruce R. Maxim", "9786558040101", "2008", 232.36, 7,"Programação"));}
		
        // Criação dos componentes
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 386);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(49, 62, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sistema da Livraria ");
		lblNewLabel.setBounds(164, 10, 151, 37);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		contentPane.add(lblNewLabel);
		
        // Ação do botão "CADASTRAR PRODUTOS, oculta a tela atual e exibe a tela de cadastrar produtos
		JButton btnNewButton_2 = new JButton("CADASTRAR PRODUTOS");
		btnNewButton_2.setBounds(120, 88, 239, 21);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TPrincipal.this.setVisible(false);
				TCadastro tCadastro = new TCadastro();
				tCadastro.setLocationRelativeTo(null);
				tCadastro.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(29, 5, 421, 339);
		contentPane.add(panel);
		panel.setLayout(null);
		
        // Ação do botão "SAIR, oculta a tela atual e exibe a tela de login
		JButton btnNewButton_3 = new JButton("SAIR");
		btnNewButton_3.setBounds(149, 308, 122, 21);
		panel.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				dispose();
				Programa tLogin = new Programa();
				tLogin.setLocationRelativeTo(null);
				tLogin.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 10));
		
        // Ação do botão "ESTOQUE", oculta a tela atual e exibe a tela com o estoque
		JButton btnNewButton = new JButton("ESTOQUE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TPrincipal.this.setVisible(false);
				TLista tLista = new TLista(TCadastro.listaProdutos);
				tLista.setLocationRelativeTo(null);
				tLista.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(91, 184, 239, 21);
		panel.add(btnNewButton);
	}
}
