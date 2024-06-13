package telas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

// Importa as classes de entidades
import entidades.Livros;
import entidades.Produto;
import entidades.Revistas;

public class TLista extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTable table;
    public static DefaultTableModel tableModel;
    private List<Produto> produtos; 
    private JTextField txtBusca;
    private JTextField txtPercentual;
    private JTextField txtEdit;

    // Construtor da classe TLista
    public TLista(List<Produto> produtos) {
        super("Lista de Produtos Cadastrados");
        this.produtos = produtos;
        
        // Criação e configuração da tabela
        tableModel = new DefaultTableModel(new String[] { "Tipo", "Título", "Autor","Ano Publicação","Gênero ou volume","Preço", "Quantidade", "ISBN"}, 0);
        table = new JTable(tableModel);
        table.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 28, 1166, 365);

        JLabel tituloPrincipal = new JLabel("LISTA DE PRODUTOS CADASTRADOS");
        tituloPrincipal.setFont(new Font("Times New Roman", Font.BOLD, 13));
        tituloPrincipal.setBounds(466, 10, 230, 13);
        TableColumnModel columnModel = table.getColumnModel();
        
        columnModel.getColumn(0).setPreferredWidth(5); // Coluna Tipo
        columnModel.getColumn(1).setPreferredWidth(180); // Coluna Título
        columnModel.getColumn(2).setPreferredWidth(230); // Coluna Autor
        columnModel.getColumn(3).setPreferredWidth(10); // Coluna Ano publicação    
        columnModel.getColumn(4).setPreferredWidth(30); //Coluna Gênero/tipo
        columnModel.getColumn(5).setPreferredWidth(40); // Coluna Preço
        columnModel.getColumn(6).setPreferredWidth(5);//Coluna Qtd
        columnModel.getColumn(7).setPreferredWidth(30);//Coluna ISBN
        
        // Preenche a tabela com os dados da lista de produtos
        atualizarTabela(produtos);
        
        // Criação de componentes da interface
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(tituloPrincipal);
        panel.add(scrollPane);
    
        getContentPane().add(panel, BorderLayout.CENTER);
        
        txtBusca = new JTextField();
        txtBusca.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        txtBusca.setBounds(138, 403, 462, 35);
        panel.add(txtBusca);
        txtBusca.setColumns(10);
        
        JTextField txtQuantidade = new JTextField();
        txtQuantidade.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        txtQuantidade.setBounds(438, 458, 40, 35);
        panel.add(txtQuantidade);
        txtQuantidade.setColumns(10);
        
        
        JLabel lblNewLabel = new JLabel("Selecione uma linha e informe a quantidade de cópias compradas ou vendidas:");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel.setBounds(10, 463, 420, 27);
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Selecione uma linha e informe o percentual do reajuste:");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1.setBounds(10, 549, 306, 27);
        panel.add(lblNewLabel_1);
        
        txtPercentual = new JTextField();
        txtPercentual.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        txtPercentual.setColumns(10);
        txtPercentual.setBounds(322, 544, 40, 35);
        panel.add(txtPercentual);
        
        txtEdit = new JTextField();
        txtEdit.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        txtEdit.setColumns(10);
        txtEdit.setBounds(253, 635, 222, 35);
        panel.add(txtEdit);
        
        JLabel lblNewLabel_1_1 = new JLabel("Selecione uma celula e edite sua informação:");
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_1.setBounds(10, 640, 247, 27);
        panel.add(lblNewLabel_1_1);
        
        // Botões:
        JButton btnBuscar = new JButton("BUSCAR");
        btnBuscar.setFont(new Font("Times New Roman", Font.BOLD, 13));
        btnBuscar.setBounds(0, 403, 139, 35);
        panel.add(btnBuscar);
        
        JButton btnVoltar = new JButton("VOLTAR PARA A TELA DE CADASTRO");
        btnVoltar.setFont(new Font("Times New Roman", Font.BOLD, 13));
        btnVoltar.setBounds(895, 630, 265, 35);
        panel.add(btnVoltar);

        JButton btnSair = new JButton("SAIR");
        btnSair.setFont(new Font("Times New Roman", Font.BOLD, 13));
        btnSair.setBounds(991, 667, 98, 35);
        panel.add(btnSair);
        
        JButton btnCompra = new JButton("COMPRA");
        btnCompra.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnCompra.setBounds(10, 500, 200, 21);
        panel.add(btnCompra);
        
        JButton btnVenda = new JButton("VENDA");
        btnVenda.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnVenda.setBounds(225, 500, 200, 21);
        panel.add(btnVenda);
        
        JButton btnReajusteNegativo = new JButton("REAJUSTE NEGATIVO");
        btnReajusteNegativo.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnReajusteNegativo.setBounds(10, 594, 168, 21);
        panel.add(btnReajusteNegativo);         
        
        JButton btnExcluir = new JButton(" EXCLUIR PRODUTO");
        btnExcluir.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnExcluir.setEnabled(false);
        btnExcluir.setBounds(912, 403, 240, 35);
        panel.add(btnExcluir);
        
        JButton btnEditar = new JButton("EDITAR");
        btnEditar.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnEditar.setBounds(20, 674, 359, 21);
        panel.add(btnEditar);
        
        JButton btnReajustePositivo = new JButton("REAJUSTE POSITIVO");
        btnReajustePositivo.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnReajustePositivo.setBounds(194, 594, 168, 21);
        panel.add(btnReajustePositivo);
        
        // Botão com funcionalidade de busca
        btnBuscar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	                String termoBusca = txtBusca.getText().toLowerCase();
        	                tableModel.setRowCount(0); 
        	 
        	                // Procura por produtos na lista de acordo com o termo de busca
        	                for (Produto produto : getProdutos()) {
        	                	if (produto.getTitulo().toLowerCase().contains(termoBusca) ||
        	                			produto.getAutor().toLowerCase().contains(termoBusca)||
        	                			produto.getTipo().toLowerCase().contains(termoBusca)||
        	                			produto.getAnoPublicacao().toLowerCase().contains(termoBusca)||
        	                			produto.getIsbn().toLowerCase().contains(termoBusca)) {
        	                		String tipo = produto instanceof Livros ? ((Livros) produto).getGenero() : ((Revistas) produto).getVolume() + "";
        	                		tableModel.addRow(new Object[]{produto.getTipo(), produto.getTitulo(), produto.getAutor(),produto.getAnoPublicacao(), tipo,"R$ " + produto.getPreco(), produto.getQtd(), produto.getIsbn()});
        	                	}
        	                }
        	                txtBusca.setText("");
        	            }
        		 });
        
        // Ação do botão voltar, oculta a tela atual e exibe a tela de cadastro
        btnVoltar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		TLista.this.setVisible(false);
        		TCadastro tCadastro = new TCadastro();
        		tCadastro.setVisible(true);
        	}
        });
        
        // Retorna para a tela principal
        btnSair.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		TLista.this.setVisible(false);
        		TPrincipal tPrincipal = new TPrincipal();
        		tPrincipal.setLocationRelativeTo(null);
        		tPrincipal.setVisible(true);
        		}
        });
        
        // Ação do botão reajuste negativo (aplica reajuste de preço baseado em porcentagem)
        btnReajusteNegativo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// Verifica se há uma linha selecionada na tabela
        		if (table.getSelectedRow() != -1) {
        			// Obtém a linha selecionada na tabela
        			int linhaSelecionada = table.getSelectedRow();
        			try {
        				// Converte o valor digitado no campo de texto para um número inteiro
        				int percentual = Integer.parseInt(txtPercentual.getText());
        				
        				// Converte o valor percentual para um valor decimal
        				double Percentual = Double.valueOf(percentual);
        				
        				/* Calcula o valor do reajuste a ser aplicado e
        				 *o novo preço do produto após o reajuste*/
        				double reajuste = (Percentual/100) * produtos.get(linhaSelecionada).getPreco();
        				double reajusteF = produtos.get(linhaSelecionada).getPreco()-reajuste;
        				
        				// Formata o novo preço com duas casas decimais e substitui vírgulas por pontos
        		        DecimalFormat df = new DecimalFormat ("#.##");
        				String valorFormatado = df.format(reajusteF);
        				String valorFormatadoF = valorFormatado.replace(',', '.');
        				
        				// Converte o valor formatado para um valor double
        				double valorFinal = Double.parseDouble(valorFormatadoF);
        				
        				// Atualiza o preço do produto selecionado na lista
        				produtos.get(linhaSelecionada).setPreco(valorFinal);
        				
        				// Atualiza a tabela com os novos dados do produto
        				atualizarTabela(produtos);
        				
        				// Limpa o campo de texto do percentual
        				txtPercentual.setText("");
        			} catch (NumberFormatException ex) {
        				// Exibe uma mensagem de erro caso o valor digitado não seja um número inteiro
        				JOptionPane.showMessageDialog(null, "Informe um número!", "Atenção", JOptionPane.WARNING_MESSAGE);
        			txtPercentual.setText("");
        			}
        		} else {
        			// Exibe uma mensagem de erro caso nenhum produto esteja selecionado
        			JOptionPane.showMessageDialog(null, "Selecione um produto para alterar o valor!", "Atenção", JOptionPane.WARNING_MESSAGE);
        		}
        		
        	}
        });
        
     // Ação do botão reajuste positivo (aplica reajuste de preço baseado em porcentagem)
        btnReajustePositivo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// Verifica se há uma linha selecionada na tabela
        		if (table.getSelectedRow() != -1) {
        			// Obtém a linha selecionada na tabela
        			int linhaSelecionada = table.getSelectedRow();
        			try {
        				// Converte o valor digitado no campo de texto para um número inteiro
        				int percentual = Integer.parseInt(txtPercentual.getText());
        				
        				// Converte o valor percentual para um valor decimal
        				double Percentual = Double.valueOf(percentual);
        				
        				/* Calcula o valor do reajuste a ser aplicado e
        				 *o novo preço do produto após o reajuste*/
        				double reajuste = (Percentual/100) * produtos.get(linhaSelecionada).getPreco();
        				double reajusteF = produtos.get(linhaSelecionada).getPreco()+reajuste;
        				
        				// Formata o novo preço com duas casas decimais e substitui vírgulas por pontos
        		        DecimalFormat df = new DecimalFormat ("#.##");
        				String valorFormatado = df.format(reajusteF);
        				String valorFormatadoF = valorFormatado.replace(',', '.');
        				
        				// Converte o valor formatado para um valor double
        				double valorFinal = Double.parseDouble(valorFormatadoF);
        				
        				// Atualiza o preço do produto selecionado na lista
        				produtos.get(linhaSelecionada).setPreco(valorFinal);
        				
        				// Atualiza a tabela com os novos dados do produto
        				atualizarTabela(produtos);
        				
        				// Limpa o campo de texto do percentual
        				txtPercentual.setText("");
        			} catch (NumberFormatException ex) {
        				// Exibe uma mensagem de erro caso o valor digitado não seja um número inteiro
        				JOptionPane.showMessageDialog(null, "Informe um número!", "Atenção", JOptionPane.WARNING_MESSAGE);
        			txtPercentual.setText("");
        			}
        		} else {
        			// Exibe uma mensagem de erro caso nenhum produto esteja selecionado
        			JOptionPane.showMessageDialog(null, "Selecione um produto para alterar o valor!", "Atenção", JOptionPane.WARNING_MESSAGE);
        		}
        		
        	}
        });
        

        // Ação do botão excluir
        btnExcluir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                // Verifica se há uma linha selecionada na tabela
        		if (table.getSelectedRow() != -1) {
                    // Obtém a linha selecionada na tabela
                    int selectedRow = table.getSelectedRow();
                    
                    // Exibe uma mensagem de confirmação para o usuário
                    int choice = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir este produto?", "Excluir Produto", JOptionPane.YES_NO_OPTION);
                    
                    // Se o usuário confirma a exclusão
                    if (choice == JOptionPane.YES_OPTION) {
                        // Remove o produto selecionado da lista de produtos
                        produtos.remove(selectedRow);
                        // Atualiza a tabela com os dados atualizados da lista
                        atualizarTabela(produtos);
                        txtBusca.setText("");
                    }
                } else {
                    // Exibe uma mensagem de erro caso nenhum produto esteja selecionado
                    JOptionPane.showMessageDialog(null, "Selecione um produto para excluir!", "Atenção", JOptionPane.WARNING_MESSAGE);
                }
        	}
        });
        table.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                btnExcluir.setEnabled(table.getSelectedRow() != -1);
            }
        });
        panel.setLayout(null);
        
        

        // Ação do botão compra (aumenta a quantidade do produto selecionado)
        btnCompra.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                // Verifica se há uma linha selecionada na tabela
        		if (table.getSelectedRow() != -1) {
                    // Obtém a linha selecionada na tabela
        			int linhaSelecionada = table.getSelectedRow();        			
        			try {
                        // Converte o valor digitado no campo de texto para um número inteiro (quantidade a ser comprada)
        				int quantidade = Integer.parseInt(txtQuantidade.getText());
        				
                        // Verifica se a quantidade digitada é negativa
        				if(quantidade<0) {
                            // Exibe uma mensagem de erro caso a quantidade seja negativa	
        					JOptionPane.showMessageDialog(null, "Informe uma compra possível!", "Atenção", JOptionPane.WARNING_MESSAGE);}
        				else {
                         // Obtém a quantidade atual do produto selecionado e calcula a nova quantidade após a compra
        				 int soma = produtos.get(linhaSelecionada).getQtd() + quantidade;
        				 
                         // Atualiza a quantidade do produto selecionado na lista
        				 produtos.get(linhaSelecionada).setQtd(soma);      
        				 
                         // Atualiza a tabela com os dados atualizados da lista e limpa o campo de texto da quantidade
        				 atualizarTabela(produtos);
        				 txtQuantidade.setText("");}
        			} catch (NumberFormatException ex) {
                        // Exibe uma mensagem de erro caso o valor digitado não seja um número inteiro
        				JOptionPane.showMessageDialog(null, "Informe um número inteiro!", "Atenção", JOptionPane.WARNING_MESSAGE);
        				txtQuantidade.setText("");
        			}
        		} else {
                    // Exibe uma mensagem de erro caso nenhum produto esteja selecionado
        			JOptionPane.showMessageDialog(null, "Selecione um produto para alterar a quantidade!", "Atenção", JOptionPane.WARNING_MESSAGE);
        		}
        	}
        });

        // Ação do botão venda (diminui a quantidade do produto selecionado)
        btnVenda.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// Verifica se há uma linha selecionada na tabela
        		if (table.getSelectedRow() != -1) {
        			// Obtém a linha selecionada na tabela
        			int linhaSelecionada = table.getSelectedRow();
        			try {
        				// Converte o valor digitado no campo de texto para um número inteiro (quantidade a ser vendida)
        				int quantidade = Integer.parseInt(txtQuantidade.getText());

        				// Valida a quantidade a ser vendida
        				if(quantidade > produtos.get(linhaSelecionada).getQtd() || quantidade<0) {
        					// Exibe uma mensagem de erro caso a quantidade seja inválida
        					JOptionPane.showMessageDialog(null, "Informe uma venda possível!", "Atenção", JOptionPane.WARNING_MESSAGE);
        				}
        				else {
        					// Calcula a nova quantidade após a venda
        					int subtracao = produtos.get(linhaSelecionada).getQtd() - quantidade;
        					
                            // Atualiza a quantidade do produto selecionado na lista
        					produtos.get(linhaSelecionada).setQtd(subtracao);
        					
                            // Atualiza a tabela com os dados atualizados da lista e limpa o campo de texto da quantidade
        					atualizarTabela(produtos);
        					txtQuantidade.setText("");}
        			} catch (NumberFormatException ex) {
                        // Exibe uma mensagem de erro caso o valor digitado não seja um número inteiro
        				JOptionPane.showMessageDialog(null, "Informe um número inteiro!", "Atenção", JOptionPane.WARNING_MESSAGE);
        				txtQuantidade.setText("");
        			}
        		} else {
                    // Exibe uma mensagem de erro caso nenhum produto esteja selecionado
        			JOptionPane.showMessageDialog(null, "Selecione um produto para alterar a quantidade!", "Atenção", JOptionPane.WARNING_MESSAGE);
        		}
        	}
        });
        
        // Ação do botaão editar
        btnEditar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// Obtém a linha e coluna selecionadas da tabela
        		int linhaSelecionada = table.getSelectedRow();
        		int colunaSelecionada = table.getSelectedColumn();
        		
        		// Verifica se uma linha e coluna estão selecionadas na tabela
        		if(linhaSelecionada !=-1 && colunaSelecionada != -1) {
        			
        			// Variáveis ​​para armazenar valores editados
        			String edit; double editPreco = 0; int editQtd;
        			
        			// Obtém o valor editado do campo de texto
        			edit = txtEdit.getText();
        			
        			//Edita o atributo do produto selecionado com base na coluna selecionada
        			switch (colunaSelecionada) 
        			{
        				case (0): // Tipo (Livro ou Revista)
        					//Verifica se há tipos de produtos válidos
        					if(edit.equals("Livro")||edit.equals("livro")) {
        						produtos.get(linhaSelecionada).setTipo("Livro");
        					}else if(edit.equals("Revista")||edit.equals("revista")) {
        						produtos.get(linhaSelecionada).setTipo("Revista");
        					}else {
        	                    // Exibe uma mensagem de erro caso o tipo seja inválido
        						JOptionPane.showMessageDialog(null, "Informe um tipo de produto aceitável!", "Atenção", JOptionPane.WARNING_MESSAGE);}
        					break;
        				case (1): // Titulo
        					produtos.get(linhaSelecionada).setTitulo(edit);
        					break;
        				case (2): // Autor
        					produtos.get(linhaSelecionada).setAutor(edit);
        					break;
        				case (3): // AnoPublicacao
        					try {
        						// Tenta converter o valor editado para um valor inteiro, afim de verificar se o ano é válido
        						int editAno = Integer.parseInt(edit);
        						if(editAno>=2025 || editAno<=0) {
            	                // Exibe uma mensagem de erro caso o ano seja inválido
        						JOptionPane.showMessageDialog(null, "Informe um ano válido!", "Atenção", JOptionPane.WARNING_MESSAGE);
        						txtEdit.requestFocus();
        						}else {
        						produtos.get(linhaSelecionada).setAnoPublicacao(edit);}
        					}catch (NumberFormatException ex) {
            	                // Exibe uma mensagem de erro caso o ano seja inválido
        						JOptionPane.showMessageDialog(null, "Informe um ano válido!", "Atenção", JOptionPane.WARNING_MESSAGE);
        					}
        					break;
        				case (5): // Preco	
        					try {
        						// Tenta converter o valor editado para um valor double
        			            editPreco = Double.parseDouble(txtEdit.getText());
        			            produtos.get(linhaSelecionada).setPreco(editPreco);
        			        } catch (NumberFormatException ex) {
        			        	// Caso a conversão falhe, tenta converter novamente substituindo a vírgula por ponto
        			        	try {
        			        	editPreco = Double.parseDouble(txtEdit.getText().replace(',', '.'));
        			            produtos.get(linhaSelecionada).setPreco(editPreco);        			        	
        			        	}
        	                    // Exibe uma mensagem de erro caso o formato do preço seja inválido
        			        	catch(NumberFormatException ez){JOptionPane.showMessageDialog(null, "Informe o valor do produto!", "Atenção", JOptionPane.WARNING_MESSAGE);
        			        	txtEdit.setText("");
        			        	txtEdit.requestFocus();
        			        	}
        			        }
        					break;
        				case(6): // Qtd
        					try {
        						//Tenta converter o valor editado para um inteiro
        						editQtd = Integer.parseInt(txtEdit.getText());
        						produtos.get(linhaSelecionada).setQtd(editQtd);
        					}
        				catch(NumberFormatException ez){
    	                    // Exibe uma mensagem de erro caso a quantidade do produto seja inválida
        					JOptionPane.showMessageDialog(null, "Informe a quantidade do produto!", "Atenção", JOptionPane.WARNING_MESSAGE);}
        					break;
        				case (7): // Isbn
        					try {
        						// Tenta converter o valor editado para um valor long
        			        	long editIsbn = Long.parseLong(edit);
        			        	// Verifica se o ISBN tem 13 dígitos
        			        	 if(editIsbn<1e12 || editIsbn>=1e13) {
        	    	             // Exibe uma mensagem de erro caso o ISBN do produto seja inválido
        			        	 JOptionPane.showMessageDialog(null, "Informe um ISBN válido!", "Atenção", JOptionPane.WARNING_MESSAGE);
        			         	 txtEdit.requestFocus();}
        			        	 else {
        			        		 produtos.get(linhaSelecionada).setIsbn(edit);
        			        	 }
        			        }
        			        catch (NumberFormatException ex){
       	    	             // Exibe uma mensagem de erro caso o ISBN do produto seja inválido
        			        	JOptionPane.showMessageDialog(null, "Informe um ISBN válido!", "Atenção", JOptionPane.WARNING_MESSAGE);
        			        	txtEdit.requestFocus();}
        					break;
        			}
        			
                    // Atualiza a tabela com os dados atualizados da lista e limpa o campo de texto da quantidade
					atualizarTabela(produtos);
					txtEdit.setText("");
        		}
        		else {
                    // Exibe uma mensagem de erro caso nenhum produto esteja selecionado
        			JOptionPane.showMessageDialog(null, "Selecione um produto para editar seu atributo!", "Atenção", JOptionPane.WARNING_MESSAGE);
        		}
        	}
        });
        setSize(1176, 752);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //Método para obter a lista de produtos
    public List<Produto> getProdutos() {
        return produtos;
    }

    // Método para definir a lista de produtos
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
        atualizarTabela(produtos);
    }

    // Método para atualizar a tabela com base na lista de produtos
    public void atualizarTabela(List<Produto> produtos) {
        tableModel.setRowCount(0);
        for (Produto produto : produtos) {
            String tipo = produto instanceof Livros ? ((Livros) produto).getGenero() : ((Revistas) produto).getVolume() + "";
            tableModel.addRow(new Object[]{produto.getTipo(), produto.getTitulo(),produto.getAutor(), produto.getAnoPublicacao(), tipo ,"R$ " + produto.getPreco(), produto.getQtd(), produto.getIsbn()});
        }
    }
}