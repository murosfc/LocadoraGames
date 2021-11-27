package telas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import objetos.Funcionario;
import objetos.PasswordHash;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class TabUpdFuncionario {	
	private JTextField nick;
	private JTextField email;
	private JTextField whatsapp;
	private JPasswordField senha;
	private JTable tabela;
	
	private Funcionario ObjFuncUpd = new Funcionario();
	
	public TabUpdFuncionario(JTabbedPane tabbedPane) {
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Adicionar Funcionário", null, panel, null);
		panel.setLayout(null);
		
		
		nick = new JTextField();
		nick.setToolTipText("Digite o nickname do funcion\u00E1rio");
		nick.setBounds(137, 403, 200, 20);
		panel.add(nick);
		nick.setColumns(50);
		
		JLabel lblNewLabel = new JLabel("Nickname");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(41, 405, 76, 14);
		panel.add(lblNewLabel);
		
		email = new JTextField();
		email.setToolTipText("Digite o e-mail do funcionario");
		email.setBounds(451, 403, 200, 20);
		panel.add(email);
		email.setColumns(50);
		
		JLabel lblNewLabel_1 = new JLabel("e-mail");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(365, 405, 76, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_W = new JLabel("Whatsapp");
		lblNewLabel_W.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_W.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_W.setBounds(29, 448, 88, 14);
		panel.add(lblNewLabel_W);
		
		whatsapp = new JTextField();
		whatsapp.setBounds(137, 446, 200, 20);
		panel.add(whatsapp);
		whatsapp.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("senha");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(395, 448, 46, 14);
		panel.add(lblNewLabel_3);		

		JLabel lblNewLabel_2 = new JLabel("Funcion\u00E1rios j\u00E1 cadastrados");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(102, 11, 549, 14);
		panel.add(lblNewLabel_2);	
		
		senha = new JPasswordField();
		senha.setToolTipText("Digite a Senha inicial do funcion\u00E1rio. A atualiza\u00E7\u00E3o \u00E9 feita pelo site");
		senha.setBounds(451, 446, 200, 20);
		panel.add(senha);		
		
		DefaultTableModel TabelaDefault = new DefaultTableModel(new String[]{"Matricula","Nickname", "e-mail", "whatsapp"},0);
		tabela = new JTable(TabelaDefault);	
		tabela.getColumnModel().getColumn(0).setPreferredWidth(70);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(210);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(180);
		JScrollPane scroll = new JScrollPane(tabela);
		scroll.setBounds(91, 36, 560, 298);
		ObjFuncUpd.preencherTabelaFuncionarios(TabelaDefault);
		panel.add(scroll);	
		
		JButton clear = new JButton("");
		clear.setIcon(new ImageIcon(TabUpdFuncionario.class.getResource("/imagens/reset.png")));
		clear.setBounds(527, 477, 52, 42);
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nick.setText("");
				email.setText("");
				whatsapp.setText("");
				senha.setText("");
				ObjFuncUpd = new Funcionario();
				TabelaDefault.setNumRows(0);
				ObjFuncUpd.preencherTabelaFuncionarios(TabelaDefault);
			}});
		panel.add(clear);	
		
		JButton updFuncionario = new JButton("");
		updFuncionario.setIcon(new ImageIcon(TabUpdFuncionario.class.getResource("/imagens/submitt.png")));
		updFuncionario.setBounds(451, 477, 52, 42);
		updFuncionario.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ObjFuncUpd.getId()<=0) {
					JOptionPane.showMessageDialog(null,"Você precisa selecionar um funciário para poder atualizar os dados","Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
				}
				else if (email.getText().equals("") || nick.getText().equals("") || whatsapp.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Os campos (nickname, e-mail e whatsapp) precisam estar preechidos pra atualizar os dados do funcionário","Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
				}
				else {
					if (senha.getPassword().length != 0) {
						ObjFuncUpd.setSenha((senha.getPassword().toString()));
						System.out.println("Senha = "+senha.getPassword().toString());
					}
					ObjFuncUpd.setNickname(nick.getText());
					ObjFuncUpd.setEmail(email.getText());
					ObjFuncUpd.setWhatsapp(whatsapp.getText());
					ObjFuncUpd.atualizarFuncionario();
					clear.doClick();
				}				
			}});
		panel.add(updFuncionario);			
		
		JButton removerFuncionario = new JButton("");
		removerFuncionario.setIcon(new ImageIcon(TabUpdFuncionario.class.getResource("/imagens/del.png")));
		removerFuncionario.setBounds(599, 477, 52, 42);
		removerFuncionario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int matricula = ObjFuncUpd.getId();
					if (matricula >= 0)
					{
						int opcaoSelecionada = JOptionPane.showConfirmDialog(null, "Tem certeza que quer excluir o funcionario "+tabela.getValueAt(tabela.getSelectedRow(), 1).toString()+"?","Aviso",JOptionPane.YES_NO_OPTION);
						if (opcaoSelecionada == JOptionPane.YES_OPTION) {
							Funcionario ObjFunc = new Funcionario();
							ObjFunc.excluirDB(matricula);
							ObjFunc.preencherTabelaFuncionarios(TabelaDefault);
						}						
					}
				}catch (Exception erro)
				{
					JOptionPane.showMessageDialog(null,"Selecione um funcionário antes de excluir","Mensagem de aviso",JOptionPane.WARNING_MESSAGE);
				}			
			}			
		});
		panel.add(removerFuncionario);
		
		
		JButton btnSelctFunc = new JButton("");
		btnSelctFunc.setIcon(new ImageIcon(TabUpdFuncionario.class.getResource("/imagens/down.png")));
		btnSelctFunc.setToolTipText("Seleciona o funcion\u00E1rio que ter\u00E1 os dados atualizados");
		btnSelctFunc.setBounds(344, 345, 40, 42);
		panel.add(btnSelctFunc);
		btnSelctFunc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try
				{					
					ObjFuncUpd = new Funcionario(Integer.parseInt(tabela.getModel().getValueAt(tabela.getSelectedRow(), 0).toString()));
					nick.setText(ObjFuncUpd.getNickname());
					whatsapp.setText(ObjFuncUpd.getWhatsapp());
					email.setText(ObjFuncUpd.getEmail());
					
				}catch (Exception erro) {
					JOptionPane.showMessageDialog(null,"Selecione um funcionário na tabela acima antes de tentar atualizar","Mensagem de aviso",JOptionPane.WARNING_MESSAGE);
					System.err.println("Erro "+erro.getMessage());
				}
				
			}
			
		});
		

		//imagem de fundo
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(TabAddCatPlat.class.getResource("/imagens/background.png")));
		background.setBounds(0, 0, 779, 553);
		panel.add(background);	
	
	}
}
