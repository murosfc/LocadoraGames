package telas;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import objetos.Funcionario;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;

public class TabAddFuncionario {	
	private JTextField nick;
	private JTextField email;
	private JTextField whatsapp;
	private JPasswordField senha;
	private JTable tabela;
	
	public TabAddFuncionario(JTabbedPane tabbedPane) {
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Adicionar Funcionário", null, panel, null);
		panel.setLayout(null);
		
		
		nick = new JTextField();
		nick.setToolTipText("Digite o nickname do funcion\u00E1rio");
		nick.setBounds(108, 30, 200, 20);
		panel.add(nick);
		nick.setColumns(50);
		
		JLabel lblNewLabel = new JLabel("Nickname");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(26, 32, 76, 14);
		panel.add(lblNewLabel);
		
		email = new JTextField();
		email.setToolTipText("Digite o e-mail do funcionario");
		email.setBounds(457, 30, 200, 20);
		panel.add(email);
		email.setColumns(50);
		
		JLabel lblNewLabel_1 = new JLabel("e-mail");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(371, 32, 76, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_W = new JLabel("Whatsapp");
		lblNewLabel_W.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_W.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_W.setBounds(14, 85, 88, 14);
		panel.add(lblNewLabel_W);
		
		whatsapp = new JTextField();
		whatsapp.setBounds(108, 83, 200, 20);
		panel.add(whatsapp);
		whatsapp.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("senha");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(401, 86, 46, 14);
		panel.add(lblNewLabel_3);		

		JLabel lblNewLabel_2 = new JLabel("Funcion\u00E1rios j\u00E1 cadastrados");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(108, 196, 549, 14);
		panel.add(lblNewLabel_2);	
		
		senha = new JPasswordField();
		senha.setToolTipText("Digite a Senha inicial do funcion\u00E1rio. A atualiza\u00E7\u00E3o \u00E9 feita pelo site");
		senha.setBounds(457, 83, 200, 20);
		panel.add(senha);		
		
		DefaultTableModel TabelaDefault = new DefaultTableModel(new String[]{"Matricula","Nickname", "e-mail", "whatsapp"},0);
		tabela = new JTable(TabelaDefault);	
		tabela.getColumnModel().getColumn(0).setPreferredWidth(70);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(210);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(180);
		JScrollPane scroll = new JScrollPane(tabela);
		scroll.setBounds(107, 221, 560, 298);
		Funcionario ObjFunc = new Funcionario();
		ObjFunc.preencherTabelaFuncionarios(TabelaDefault);
		panel.add(scroll);		
		
		JButton addFuncionario = new JButton("");
		addFuncionario.setIcon(new ImageIcon(TabAddFuncionario.class.getResource("/imagens/submitt.png")));
		addFuncionario.setBounds(532, 137, 52, 42);
		addFuncionario.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (email.getText().equals("") || nick.getText().equals("") || whatsapp.getText().equals("") || senha.getPassword().length == 0)
				{
					JOptionPane.showMessageDialog(null,"Todos os campos precisam estar preechidos pra cadastrar novo funcionário","Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
				}
				else {
					Funcionario ObjFunc = new Funcionario ( nick.getText(), email.getText(), whatsapp.getText(), senha.getPassword().toString());
					ObjFunc.incluirDB();
					ObjFunc.preencherTabelaFuncionarios(TabelaDefault);
				}
				
			}});
		panel.add(addFuncionario);
		
		JButton clear = new JButton("");
		clear.setIcon(new ImageIcon(TabAddFuncionario.class.getResource("/imagens/reset.png")));
		clear.setBounds(605, 137, 52, 42);
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nick.setText("");
				email.setText("");
				whatsapp.setText("");
				senha.setText("");				
			}});
		panel.add(clear);	
			
		
		JButton removerFuncionario = new JButton("");
		removerFuncionario.setIcon(new ImageIcon(TabAddFuncionario.class.getResource("/imagens/del.png")));
		removerFuncionario.setBounds(687, 476, 52, 42);
		removerFuncionario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int matricula = Integer.parseInt(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
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
		
		//imagem de fundo
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(TabAddCatPlat.class.getResource("/imagens/background.png")));
		background.setBounds(0, 0, 779, 553);
		panel.add(background);	
	
	}
}
