package pck_conexao;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



@SuppressWarnings("serial")
public class TelaCadastro extends JFrame {

	public TelaCadastro()
	{ this.setTitle("Tela Cadastro");
	  this.setSize(400, 200);
	  this.setResizable(true);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = this.getContentPane();
				
		JPanel painel = new JPanel();
		c.add(painel);
			
		JLabel lbcpf = new JLabel("CPF............:");
		JLabel lbnome = new JLabel("Nome Completo..:");
	    JLabel lbemail = new JLabel("E-mail.........: ");
		
		JTextField tfcpf = new JTextField(25);
		JTextField tfnome = new JTextField(20);
		JTextField tfemail = new JTextField(25);
			
		painel.add(lbcpf);
		painel.add(tfcpf);		
		painel.add(lbnome);
		painel.add(tfnome);		
		painel.add(lbemail);
		painel.add(tfemail);	
		
		JButton botao1 = new JButton("Salvar");
		JButton botao2 = new JButton("Consultar");
		JButton botao3 = new JButton("Atualizar");
		JButton botao4 = new JButton("Deletar");
		JButton botao5 = new JButton("Limpar");
		JButton botao6 = new JButton("Fechar");
		painel.add(botao1);
		painel.add(botao2);
		painel.add(botao3);
		painel.add(botao4);
		painel.add(botao5);
		painel.add(botao6);
		
		// INCLUIR
		botao1.addActionListener(new ActionListener()
		{ public void actionPerformed(ActionEvent e)
			{ PFisica objFisica = new PFisica(tfcpf.getText(), tfnome.getText(), tfemail.getText() );
		      objFisica.incluir(objFisica); 	
			}
		});
		
		// CONSULTAR
		botao2.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent e)
			{ 
				PFisica objfisica = new PFisica(tfcpf.getText(), tfnome.getText(), tfemail.getText() );
				objfisica.consultar(objfisica);
				
	            System.out.println("Classe TelaCadastro - botão Consultar!" );
                System.out.println("Cpf.........: "+ objfisica.getCpf());
                System.out.println("Nome........: "+ objfisica.getNome());
                
				tfnome.setText(objfisica.getNome());
				tfemail.setText(objfisica.getEmail());
				
			}
		});
			
		// ATUALIZAR
		botao3.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent e)
			{ 
				PFisica objfisica = new PFisica(tfcpf.getText(), tfnome.getText(), tfemail.getText() );
				objfisica.atualizar(objfisica);
				
	            System.out.println("Classe TelaCadastro - botão Atualizar!" );
                System.out.println("Cpf.........: "+ objfisica.getCpf());
                System.out.println("Nome........: "+ objfisica.getNome());                					
			}
		});

		// EXCLUIR
		botao4.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent e)
			{ 
			    int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Exclusão", JOptionPane.YES_NO_OPTION);
				
			    if (resposta == JOptionPane.YES_OPTION) 
			    {	PFisica objfisica = new PFisica(tfcpf.getText(), tfnome.getText(), tfemail.getText() );
					objfisica.excluir(objfisica);
			    }
			    else 
			    {   if (resposta == JOptionPane.NO_OPTION) 
				        JOptionPane.showMessageDialog(null,"Exclusão cancelada!","Exclusão",JOptionPane.INFORMATION_MESSAGE);
				}	
			    							                            					
			}
		});

		// LIMPAR
		botao5.addActionListener(new ActionListener()
		{ public void actionPerformed(ActionEvent e)
		{ tfnome.setText("");
 		  tfcpf.setText(""); 
 		  tfemail.setText("");  	 		  
		}});
		
		// FECHAR
		botao6.addActionListener(new ActionListener()
		{ public void actionPerformed(ActionEvent e)
		{ System.exit(0); }
		});
		
		
		painel.repaint();	
		this.setVisible(true);		
		this.repaint();	
		
	}
}

