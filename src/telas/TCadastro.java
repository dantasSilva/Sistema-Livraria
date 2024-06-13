package telas;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

// Importa as classes de entidades
import entidades.Livros;
import entidades.Produto;
import entidades.Revistas;

/*
  Esta classe representa a tela de cadastro de produtos. 
  Ela permite o usuário informar os dados do produto e cadastra-lo em uma lista.
 */

public class TCadastro extends JFrame {

    private JPanel dadosPanel;
    private JComboBox tipoProdutoComboBox;
    private JTextField tituloField, autorField, isbnField, anoPublicacaoField, precoField, volumeField, generoField, qtdField;
    private JButton btnVerificarLista;
    private JButton btnSair;
    public static List<Produto> listaProdutos = new ArrayList<>();
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TCadastro frame = new TCadastro();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /*
     *Construtor da classe TCadastro.
     *Inicializa os componentes da tela de cadastro e configura seus layouts.
     */
    
    public TCadastro() {
        super("Cadastro de Produtos");
        
        // Criação dos componentes
        dadosPanel = new JPanel();
        tipoProdutoComboBox = new JComboBox(new String[]{"Livro", "Revista"});
        tipoProdutoComboBox.setFont(new Font("Times New Roman", Font.BOLD, 12));
        tipoProdutoComboBox.setBounds(295, 1, 290, 38);
        tituloField = new JTextField();
        tituloField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        tituloField.setBounds(295, 44, 290, 38);
        autorField = new JTextField();
        autorField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        autorField.setBounds(295, 87, 290, 38);
        isbnField = new JTextField();
        isbnField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        isbnField.setBounds(295, 130, 290, 38);
        anoPublicacaoField = new JTextField();
        anoPublicacaoField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        anoPublicacaoField.setBounds(295, 173, 290, 38);
        precoField = new JTextField();
        precoField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        precoField.setBounds(295, 216, 290, 38);
        volumeField = new JTextField();
        volumeField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        volumeField.setBounds(295, 259, 290, 38);
        generoField = new JTextField();
        generoField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        generoField.setBounds(295, 302, 290, 38);
        dadosPanel.setLayout(null);
        JLabel label = new JLabel("Tipo de Produto:");
        label.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        label.setBounds(10, 1, 165, 38);
        dadosPanel.add(label);
        dadosPanel.add(tipoProdutoComboBox);
        JLabel label_1 = new JLabel("Título:");
        label_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        label_1.setBounds(10, 44, 165, 38);
        dadosPanel.add(label_1);
        dadosPanel.add(tituloField);
        JLabel label_2 = new JLabel("Autor:");
        label_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        label_2.setBounds(10, 87, 165, 38);
        dadosPanel.add(label_2);
        dadosPanel.add(autorField);
        JLabel lblIsbn = new JLabel("ISBN-13:");
        lblIsbn.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        lblIsbn.setBounds(10, 130, 165, 38);
        dadosPanel.add(lblIsbn);
        dadosPanel.add(isbnField);
        JLabel label_4 = new JLabel("Ano de Publicação:");
        label_4.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        label_4.setBounds(10, 173, 165, 38);
        dadosPanel.add(label_4);
        dadosPanel.add(anoPublicacaoField);
        JLabel label_5 = new JLabel("Preço:");
        label_5.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        label_5.setBounds(10, 216, 165, 38);
        dadosPanel.add(label_5);
        dadosPanel.add(precoField);
        JLabel label_6 = new JLabel("Volume (apenas para revistas):");
        label_6.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        label_6.setBounds(10, 259, 165, 38);
        dadosPanel.add(label_6);
        dadosPanel.add(volumeField);
        JLabel label_7 = new JLabel("Gênero (apenas para livros):");
        label_7.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        label_7.setBounds(10, 302, 165, 38);
        dadosPanel.add(label_7);
        dadosPanel.add(generoField);

        JButton btnCadastrar = new JButton("CADASTRAR");
        btnCadastrar.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnCadastrar.setBounds(171, 451, 239, 21);
        dadosPanel.add(btnCadastrar);
        
        btnSair = new JButton("SAIR");
        btnSair.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnSair.setBounds(240, 516, 100, 21);
        dadosPanel.add(btnSair);
        
        btnVerificarLista = new JButton("VERIFICAR ESTOQUE");
        btnVerificarLista.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnVerificarLista.setBounds(205, 482, 171, 21);
        dadosPanel.add(btnVerificarLista);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(dadosPanel, BorderLayout.CENTER);
        
        JLabel lblNewLabel = new JLabel("Quantidade de cópias adquiridas:");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        lblNewLabel.setBounds(10, 345, 178, 38);
        dadosPanel.add(lblNewLabel);
        
        qtdField = new JTextField();
        qtdField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        qtdField.setBounds(295, 345, 290, 38);
        dadosPanel.add(qtdField);
        qtdField.setColumns(10);
        
        /*
         *Quando o botão é pressionado, a tela atual é ocultada e a tela TLista é exibida, 
         *passando a lista de produtos cadastrados como parâmetro.
         */
        btnVerificarLista.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		TCadastro.this.setVisible(false);
        		TLista tLista = new TLista(listaProdutos);
				tLista.setVisible(true);
        	}
        });    
        /*Quando o botão é pressionado,
        o método registrarProduto() é chamado para cadastrar o produto.*/
        btnCadastrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		registrarProduto();
        	}
        });
        
        /*Quando o botão é pressionado, a tela atual é ocultada e 
          a tela TPrincipal é aberta.*/
    	btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TPrincipal tPrincipal = new TPrincipal();
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        		TCadastro.this.setVisible(false);
				tPrincipal.setLocationRelativeTo(null);
				tPrincipal.setVisible(true);
			}
		});

        // Configurações da janela
        setSize(595, 584);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    /*
     *Realiza o cadastro de um novo produto.
     *Recupera os dados informados pelo usuário nos campos de texto.
     *Valida os dados informados (preenchimento, tipo numérico, ano de publicação, ISBN).
     *Cria uma instância de Produto (Livro ou Revista) de acordo com o tipo selecionado.
     *Adiciona o novo produto à lista de produtos cadastrados.
     *Limpa os campos de texto após o cadastro bem-sucedido.
     *Exibe mensagens de erro caso algum dado esteja inválido ou obrigatório esteja faltando.
     */
    
    public void registrarProduto() {
    	
    	String tipoProduto = (String) tipoProdutoComboBox.getSelectedItem();
        String titulo = tituloField.getText();
        String autor = autorField.getText();
        String isbn = isbnField.getText();
        String anoPublicacao = anoPublicacaoField.getText();
        double preco = 0;
        int volume = 0, anoTeste = 0;
        long isbnTeste = 0;
        String genero = generoField.getText();
        int qtd = 0;
        try {
            qtd = Integer.parseInt(qtdField.getText());
        } catch (NumberFormatException ex) {
        }
        try {
            preco = Double.parseDouble(precoField.getText());
        } catch (NumberFormatException ex) {
        	try {
        	preco = Double.parseDouble(precoField.getText().replace(',', '.'));}
        	catch(NumberFormatException ez){JOptionPane.showMessageDialog(null, "Informe o valor do produto!", "Atenção", JOptionPane.WARNING_MESSAGE);
        	precoField.setText("");
        	precoField.requestFocus();
        	}
        }
        try {
        	anoTeste = Integer.parseInt(anoPublicacao);
        	if(anoTeste>=2025||anoTeste<0) {JOptionPane.showMessageDialog(null, "Informe um ano válido!", "Atenção", JOptionPane.WARNING_MESSAGE);
        	anoPublicacaoField.setText("");
        	anoPublicacaoField.requestFocus();
        	}
        }catch (NumberFormatException ex){
        	JOptionPane.showMessageDialog(null, "Informe um ano válido!", "Atenção", JOptionPane.WARNING_MESSAGE);
        	anoPublicacaoField.setText("");
        	anoPublicacaoField.requestFocus();}
       
        try {
        	 isbnTeste = Long.parseLong(isbn);
        	 if(isbnTeste<1e12||isbnTeste>=1e13) {
        	 JOptionPane.showMessageDialog(null, "Informe um ISBN válido!", "Atenção", JOptionPane.WARNING_MESSAGE);
         	 isbnField.setText("");
         	 isbnField.requestFocus();}
        }
        catch (NumberFormatException ex){
        	JOptionPane.showMessageDialog(null, "Informe um ISBN válido!", "Atenção", JOptionPane.WARNING_MESSAGE);
        	isbnField.setText("");
        	isbnField.requestFocus();
        }
        
        if (tipoProduto.equals("Revista")) {
            try {
                volume = Integer.parseInt(volumeField.getText());
            } catch (NumberFormatException ex) {
            }
        }

        if(!tituloField.getText().isEmpty()&&!autorField.getText().isEmpty()&&!isbnField.getText().isEmpty()&&!anoPublicacaoField.getText().isEmpty()&&
        		!qtdField.getText().isEmpty()&&!precoField.getText().isEmpty() &&(!volumeField.getText().isEmpty()||!generoField.getText().isEmpty())) {
			JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso",null, JOptionPane.PLAIN_MESSAGE);
			//Lista
			Produto produto = null;
			if (tipoProduto.equals("Livro")) {
                produto = new Livros(tipoProduto, titulo, autor, isbn, anoPublicacao, preco, qtd ,genero);
            } else {
                produto = new Revistas(tipoProduto, titulo, autor, isbn, anoPublicacao, preco, qtd ,volume);
            }
            listaProdutos.add(produto);
        
           	//Apagador
		tituloField.setText("");
		autorField.setText("");
		isbnField.setText("");
		anoPublicacaoField.setText("");
		precoField.setText("");
		volumeField.setText("");
		generoField.setText("");
		qtdField.setText("");
		tituloField.requestFocus();

		}
		else {JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios","TENTE NOVAMENTE", JOptionPane.WARNING_MESSAGE);}
    }
}