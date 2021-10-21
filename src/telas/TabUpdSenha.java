package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import objetos.Conta;
import objetos.Jogo;

import javax.swing.JList;
import javax.swing.JOptionPane;

import telas.TabAddConta;

public class TabUpdSenha {

	public TabUpdSenha(JTabbedPane tabbedPane) {
		JPanel panel = new JPanel();
		tabbedPane.addTab("Atualizar senha", null, panel, null);
		panel.setLayout(null);
		
		JTextField email = new JTextField();
		email.setToolTipText("Digite o e-mail");
		email.setBounds(214, 30, 250, 20);
		panel.add(email);
		email.setColumns(50);
		
		JLabel lblNewLabel = new JLabel("Nova senha");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(113, 251, 91, 14);
		panel.add(lblNewLabel);
		
		JTextField novaSenha = new JTextField();
		novaSenha.setToolTipText("Verifique se est\u00E1 correto antes de cadastrar");
		novaSenha.setBounds(214, 249, 250, 20);
		panel.add(novaSenha);
		novaSenha.setColumns(50);
		
		JLabel lblNewLabel_2 = new JLabel("Procurar conta por e-mail");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(46, 32, 221, 14);
		panel.add(lblNewLabel_2);		

		JLabel notFound = new JLabel("Nenhum resultado encontrado!");
		notFound.setHorizontalAlignment(SwingConstants.CENTER);
		notFound.setForeground(Color.RED);
		notFound.setFont(new Font("Tahoma", Font.BOLD, 12));
		notFound.setBounds(224, 50, 220, 14);
		notFound.setVisible(false);
		panel.add(notFound);		
				
		//tabela de pesquisa de contas		
		DefaultTableModel table = new DefaultTableModel(new String[]{"id", "e-mail", "senha", "jogo", "plataforma"}, 0);
		JTable tabela = new JTable (table);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(180);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(240);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(120);
		JScrollPane ScroolTable = new JScrollPane(tabela);
		ScroolTable.setBounds(56, 96, 670, 131);		
		panel.add(ScroolTable);
		
		//tabela prioridade
		DefaultTableModel ModeloTabelaPrioridade = new DefaultTableModel(new String[]{"id", "e-mail","jogo", "plataforma", "prioridade"}, 0);
		JTable tabelaPrioridade = new JTable (ModeloTabelaPrioridade);
		tabelaPrioridade.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabelaPrioridade.getColumnModel().getColumn(1).setPreferredWidth(150);
		tabelaPrioridade.getColumnModel().getColumn(2).setPreferredWidth(300);
		tabelaPrioridade.getColumnModel().getColumn(3).setPreferredWidth(120);
		tabelaPrioridade.getColumnModel().getColumn(4).setPreferredWidth(70);	
		JScrollPane ScroolTabelaPrioridade = new JScrollPane(tabelaPrioridade);
		ScroolTabelaPrioridade.setBounds(56, 318, 670, 189);
		Conta objConta = new Conta(); //preenche tabela de prioridades
		objConta.preecheTabelaPrioridades(ModeloTabelaPrioridade);
		panel.add(ScroolTabelaPrioridade);
		
		JLabel found = new JLabel("Selecione a conta abaixo e cadastre a nova senha");
		found.setHorizontalAlignment(SwingConstants.CENTER);
		found.setForeground(Color.BLUE);
		found.setFont(new Font("Tahoma", Font.BOLD, 12));
		found.setVisible(false);
		found.setBounds(56, 71, 670, 14);		
		panel.add(found);

		JLabel lblNewLabel_1 = new JLabel("Contas que precisam ter a senha atualizada com prioridade!");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(56, 297, 670, 14);
		panel.add(lblNewLabel_1);
		
		JButton procurarConta = new JButton("");
		procurarConta.setIcon(new ImageIcon(TabAddConta.class.getResource("/imagens/busca.png")));
		procurarConta.setBounds(487, 22, 52, 42);
		procurarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				notFound.setVisible(false);				
				Conta ObjConta = new Conta();
				if (! ObjConta.preencheTabelaContaTrocarSenha(email.getText(), table)) //preenche a tabela de conta buscada	
				{
					notFound.setVisible(true);					
				}											
			}});
		panel.add(procurarConta);
		
		JButton salvarNovaSenha = new JButton("");
		salvarNovaSenha.setIcon(new ImageIcon(TabAddConta.class.getResource("/imagens/submitt.png")));
		salvarNovaSenha.setBounds(487, 238, 52, 42);
		salvarNovaSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (novaSenha.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Digite a nova senha para continuar","Mensagem de erro",JOptionPane.ERROR_MESSAGE);					
				}
				else {
					try
					{
						int idConta = Integer.parseInt(tabela.getModel().getValueAt(tabela.getSelectedRow(), 0).toString());						
						Conta ObjConta = new Conta();
						ObjConta.AtualizarSenhaConta(idConta, novaSenha.getText());
						email.setText("");
						novaSenha.setText("");						
						objConta.preecheTabelaPrioridades(ModeloTabelaPrioridade);
						table.setRowCount(0);
					}
					catch (Exception erro) {
						JOptionPane.showMessageDialog(null, "Selecione uma conta na tabela para atualizar a senha","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
						System.err.println("Erro: "+erro.getMessage());
					}
				}
			}});
		panel.add(salvarNovaSenha);
		
		JButton limparCampos = new JButton("");
		limparCampos.setIcon(new ImageIcon(TabAddConta.class.getResource("/imagens/reset.png")));
		limparCampos.setBounds(560, 238, 52, 42);
		limparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				email.setText("");
				novaSenha.setText("");
				table.setRowCount(0);
			}});
		panel.add(limparCampos);
		
		JButton enviaContaAtualizar = new JButton("");
		enviaContaAtualizar.setIcon(new ImageIcon(TabUpdSenha.class.getResource("/imagens/up.png")));
		enviaContaAtualizar.setBounds(664, 251, 42, 52);
		enviaContaAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String mail = tabelaPrioridade.getValueAt(tabelaPrioridade.getSelectedRow(), 1).toString();
					Conta ObjConta = new Conta();
					ObjConta.preencheTabelaContaTrocarSenha(mail, table);
				}
				catch (Exception erro)
				{
					System.err.println("Erro "+erro.getMessage());
				}
			}});
		panel.add(enviaContaAtualizar);
		
		//imagem de fundo
		JLabel background = new JLabel("");
		background.setToolTipText("Seleciona conta para atualização");
		background.setIcon(new ImageIcon(TabAddCatPlat.class.getResource("/imagens/background.png")));
		background.setBounds(0, 0, 779, 553);
		panel.add(background);		
	}
	
	private boolean consultarConta(JLabel notFound, JTextField email, JTextField senha, DefaultTableModel table)
	{
		notFound.setVisible(false);
		if (email.getText().equals(""))
		{
			JOptionPane.showInternalMessageDialog(null, "Digite um e-mail para prosseguir");			
		}
		else {
			Conta ObjConta = new Conta (email.getText(), senha.getText());		
			if (ObjConta.consultarDB(ObjConta) == null)
			{
				notFound.setVisible(true);				
			}
			else
			{
			email.setText(ObjConta.getEmail());
			senha.setText(ObjConta.getSenha());	
			table.setRowCount(0);
			Jogo ObjJogo = new Jogo();
			ObjJogo.listarDB("jogo", table, ObjConta.getIdJogo());
			return true;
			}
		}
		return false;
	}
}


