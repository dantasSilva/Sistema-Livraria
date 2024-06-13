package aplicacao;

import java.awt.EventQueue;
import telas.TPrincipal;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// Classe principal
public class Programa extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtSenha;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Programa frame = new Programa();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Construtor da classe Programa
	public Programa() {
		
		// Configuração da interface
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 317);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(49, 62, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(130, 18, 286, 238);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel.setBounds(110, 10, 66, 26);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuário");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(42, 59, 53, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(42, 121, 45, 13);
		panel.add(lblNewLabel_2);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtUser.setBounds(42, 74, 172, 19);
		panel.add(txtUser);
		txtUser.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtSenha.setBounds(42, 134, 172, 19);
		panel.add(txtSenha);
		
		
		// Configuração do botão "ENTRAR"
		JButton btnNewButton = new JButton("ENTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Verifica se o usuário e senhas informados estão corretos
				if(checkLogin(txtUser.getText(), new String(txtSenha.getPassword()))) {
					
					//Abre a janela principal
					JOptionPane.showMessageDialog(null, "Bem Vindo ao Sistema ");
					dispose();
					TPrincipal tPrincipal = new TPrincipal();
					tPrincipal.setLocationRelativeTo(null);
					tPrincipal.setVisible(true);
				}
				else {
					//Exibe mensagem de erro e limpa campos
					JOptionPane.showMessageDialog(null, "Informações Incorretas", null,JOptionPane.WARNING_MESSAGE );	
					txtUser.setText("");
					txtSenha.setText("");
					txtUser.requestFocus();
				}	
					}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 10));
		btnNewButton.setBounds(100, 207, 85, 21);
		panel.add(btnNewButton);
	}
	
		// Arrays com credenciais de usuários pré-cadastrados
		String [] user = {"adrian", "artur", "admin"};
		String [] password = {"2020", "1234", "0000"};
		
		// Método que verifica se o usuário e senha informados correspondem a um cadastro válido
		public boolean checkLogin(String usuario, String senha) {
			return usuario.equals(user[0]) && senha.equals(password [0])||
				usuario.equals(user[1]) && senha.equals(password [1])||
				usuario.equals(user[2]) && senha.equals(password[2]);  
		}
}
