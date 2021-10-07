package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import objetos.Conta;
import objetos.Jogo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;

public class TabAddConta {

	public TabAddConta(JTabbedPane tabbedPane) {
		JPanel panel = new JPanel();
		tabbedPane.addTab("Cadastrar Conta", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("e-mail");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(51, 32, 62, 14);
		panel.add(lblNewLabel_1);		
		
		JTextField email = new JTextField();
		email.setToolTipText("Digite o e-mail");
		email.setBounds(123, 30, 250, 20);
		panel.add(email);
		email.setColumns(50);
		
		JLabel lblNewLabel = new JLabel("Senha");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(408, 32, 62, 14);
		panel.add(lblNewLabel);
		
		JTextField senha = new JTextField();
		senha.setToolTipText("Verifique se est\u00E1 correto antes de cadastrar");
		senha.setBounds(480, 30, 250, 20);
		panel.add(senha);
		senha.setColumns(50);
		
		JLabel lblNewLabel_2 = new JLabel("Busca do jogo pertencente \u00E0 conta");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(283, 93, 221, 14);
		panel.add(lblNewLabel_2);
		
		JTextField jogoProcurado = new JTextField();
		jogoProcurado.setToolTipText("Busque pelo t\u00EDtulo. Ou deixe em branco para retornar todos os resultados");
		jogoProcurado.setBounds(284, 118, 220, 20);
		panel.add(jogoProcurado);
		jogoProcurado.setColumns(50);		
		
		JLabel notFound = new JLabel("Nenhum resultado encontrado!");
		notFound.setHorizontalAlignment(SwingConstants.CENTER);
		notFound.setForeground(Color.RED);
		notFound.setFont(new Font("Tahoma", Font.BOLD, 12));
		notFound.setBounds(284, 149, 220, 14);
		notFound.setVisible(false);
		panel.add(notFound);		
				
		DefaultTableModel table = new DefaultTableModel(new String[]{"id", "Título", "Plataforma"}, 0);		
		JTable tabela = new JTable (table);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(60);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(400);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(200);		
		JScrollPane ScroolTable = new JScrollPane(tabela);
		ScroolTable.setBounds(69, 174, 660, 266);
		//tabela.setBackground(new Color(255, 255, 255, 125));
		panel.add(ScroolTable);
		
		JButton buscarJogo = new JButton("");
		buscarJogo.setIcon(new ImageIcon(TabAddConta.class.getResource("/imagens/busca.png")));
		buscarJogo.setBounds(514, 107, 52, 42);
		buscarJogo.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				table.setRowCount(0);
				String busca = jogoProcurado.getText();
				Jogo ObjJogo = new Jogo();
				if (ObjJogo.listarBD("jogo", table, busca))
				{
					notFound.setVisible(false);
				}
				else notFound.setVisible(true);
			}});
		panel.add(buscarJogo);
		
		JButton add = new JButton("");
		add.setToolTipText("Incluir conta");
		add.setIcon(new ImageIcon(TabAddConta.class.getResource("/imagens/submitt.png")));
		add.setBounds(492, 467, 52, 42);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(tabela.getModel().getValueAt(tabela.getSelectedRow(), 0).toString());
				try {
					if (!email.getText().equals("") && !senha.getText().equals("") && !tabela.getModel().getValueAt(tabela.getSelectedRow(), 0).toString().equals(""))
					{
						
						Conta ObjConta = new Conta(email.getText(), senha.getText(), Integer.parseInt(tabela.getModel().getValueAt(tabela.getSelectedRow(), 0).toString()));
						ObjConta.incluirDB(ObjConta, "conta");
					}
				}
				catch (Exception erro)
				{
					JOptionPane.showMessageDialog(null, "Selecione um jogo para adicionar à conta","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
					System.err.println("Erro: "+erro.getMessage());
				}
			}});
		panel.add(add);
		
		JButton clear = new JButton("");
		clear.setToolTipText("Limpar Campos");
		clear.setIcon(new ImageIcon(TabAddConta.class.getResource("/imagens/reset.png")));
		clear.setBounds(554, 467, 52, 42);
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setRowCount(0);
				senha.setText("");
				email.setText("");
				jogoProcurado.setText("");
			}});
		panel.add(clear);		
		
		JButton excluir = new JButton("");
		excluir.setToolTipText("Excluir conta");
		excluir.setIcon(new ImageIcon(TabAddConta.class.getResource("/imagens/del.png")));
		excluir.setBounds(678, 467, 52, 42);
		excluir.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				if (consultarConta(notFound, email, senha, table))
				{
					int opcaoSelecionada = JOptionPane.showConfirmDialog (null, "Tem certeza que quer excluir a conta com e-mail: "+email.getText()+"?","Warning",JOptionPane.YES_NO_OPTION);
					if(opcaoSelecionada == JOptionPane.YES_OPTION)
					{
					  Conta ObjConta = new Conta(email.getText(), senha.getText());
					  ObjConta.excluirDB("conta");
					  table.setRowCount(0);
					  senha.setText("");
					  email.setText("");
					  jogoProcurado.setText("");
					}
				}				
			}});
		panel.add(excluir);	
		
		JButton buscarConta = new JButton("");
		buscarConta.setIcon(new ImageIcon(TabAddConta.class.getResource("/imagens/busca.png")));
		buscarConta.setToolTipText("Buscar Conta");
		buscarConta.setBounds(616, 467, 52, 42);
		buscarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarConta(notFound, email, senha, table);
				}});
		panel.add(buscarConta);
		
		//imagem de fundo
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(TabAddCatPlat.class.getResource("/imagens/background.png")));
		background.setBounds(0, 0, 779, 553);
		panel.add(background);
	}
	
	//método para buscar conta já cadastrada
	private boolean consultarConta(JLabel notFound, JTextField email, JTextField senha, DefaultTableModel table)
	{
		notFound.setVisible(false);
		if (email.getText().equals(""))
		{
			JOptionPane.showInternalMessageDialog(null, "Digite um e-mail para prosseguir");			
		}
		else {
			Conta ObjConta = new Conta (email.getText(), senha.getText());		
			if (ObjConta.consultarDB() == null)
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

