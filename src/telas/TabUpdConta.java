package telas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import objetos.Conta;
import objetos.Jogo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

import javax.swing.JTable;
import java.awt.Component;
import javax.swing.table.TableModel;

public class TabUpdConta {
	private JTextField buscaJogo;
	private int idParaAtualizar = 0;

	public TabUpdConta(JTabbedPane tabbedPane) {
		JPanel panel = new JPanel();
		tabbedPane.addTab("Atualizar Conta", null, panel, null);
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
		
		JLabel lblNewLabel_2 = new JLabel("Busca de contas por e-mail");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(283, 61, 221, 14);
		panel.add(lblNewLabel_2);
		
		JTextField contaProcurada = new JTextField();
		contaProcurada.setToolTipText("Busque pelo t\u00EDtulo. Ou deixe em branco para retornar todos os resultados");
		contaProcurada.setBounds(283, 84, 220, 20);
		panel.add(contaProcurada);
		contaProcurada.setColumns(50);		
		
		JLabel notFound = new JLabel("Nenhum resultado encontrado!");
		notFound.setHorizontalAlignment(SwingConstants.CENTER);
		notFound.setForeground(Color.RED);
		notFound.setFont(new Font("Tahoma", Font.BOLD, 12));
		notFound.setBounds(284, 115, 220, 14);
		notFound.setVisible(false);
		panel.add(notFound);
		
		
		JLabel NotFoundGames = new JLabel("Nenhum resultado encontrado!");
		NotFoundGames.setHorizontalAlignment(SwingConstants.CENTER);
		NotFoundGames.setForeground(Color.RED);
		NotFoundGames.setFont(new Font("Tahoma", Font.BOLD, 12));
		NotFoundGames.setBounds(283, 340, 221, 14);
		NotFoundGames.setVisible(false);
		panel.add(NotFoundGames);		

		buscaJogo = new JTextField();
		buscaJogo.setBounds(283, 309, 221, 20);
		panel.add(buscaJogo);
		buscaJogo.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Busca de jogo por título");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(283, 285, 221, 14);
		panel.add(lblNewLabel_3);

		//tabela de pesquisa de contas		
		DefaultTableModel tableContas = new DefaultTableModel(new String[]{"id", "e-mail", "senha", "jogo", "plataforma"}, 0);
		JTable tabelaContas = new JTable (tableContas);		
		tabelaContas.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabelaContas.getColumnModel().getColumn(1).setPreferredWidth(180);
		tabelaContas.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabelaContas.getColumnModel().getColumn(3).setPreferredWidth(240);
		tabelaContas.getColumnModel().getColumn(4).setPreferredWidth(120);
		JScrollPane ScroolTableContas = new JScrollPane(tabelaContas);
		ScroolTableContas.setBounds(60, 143, 670, 131);		
		panel.add(ScroolTableContas);
				
		DefaultTableModel table = new DefaultTableModel(new String[]{"id", "Título", "Plataforma"}, 0);		
		JTable tabela = new JTable (table);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(60);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(400);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(200);		
		JScrollPane ScroolTable = new JScrollPane(tabela);
		ScroolTable.setToolTipText("Selecione o jogo para atualizar");
		ScroolTable.setBounds(60, 370, 670, 102);		
		panel.add(ScroolTable);			

		JButton selecionaContaUpdate = new JButton("");
		selecionaContaUpdate.setToolTipText("Secione uma conta e clique para editar");
		selecionaContaUpdate.setIcon(new ImageIcon(TabUpdConta.class.getResource("/imagens/up.png")));
		selecionaContaUpdate.setBounds(693, 84, 37, 42);
		selecionaContaUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					idParaAtualizar = Integer.parseInt(tabelaContas.getModel().getValueAt(tabelaContas.getSelectedRow(), 0).toString());
					if (idParaAtualizar <=0) {
						JOptionPane.showMessageDialog(null, "Você precisa selecionar uma conta para seguir com a atualização","Alerta",JOptionPane.WARNING_MESSAGE);
					} else {
						email.setText(tabelaContas.getModel().getValueAt(tabelaContas.getSelectedRow(), 1).toString());
						senha.setText(tabelaContas.getModel().getValueAt(tabelaContas.getSelectedRow(), 2).toString());
						System.out.println("id de conta selecionada para atualizar: "+ idParaAtualizar);
					}
				} catch (Exception erro) {
					System.err.println("Erro: "+erro.getMessage());
				}				
			}});
		panel.add(selecionaContaUpdate);		
		
		JButton btnBuscaConta = new JButton("");
		btnBuscaConta.setIcon(new ImageIcon(TabAddConta.class.getResource("/imagens/busca.png")));
		btnBuscaConta.setBounds(514, 61, 52, 42);
		btnBuscaConta.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				notFound.setVisible(false);
				tableContas.setRowCount(0);
				Conta ObjConta = new Conta();
				if (! ObjConta.preencheTabelaContaTrocarSenha(contaProcurada.getText(), tableContas)) //preenche a tabela de conta buscada	
				{
					notFound.setVisible(true);			
				}				
			}});
		panel.add(btnBuscaConta);
		
		JButton btnBuscarJogo = new JButton("");
		btnBuscarJogo.setIcon(new ImageIcon(TabUpdConta.class.getResource("/imagens/busca.png")));
		btnBuscarJogo.setBounds(514, 285, 52, 42);
		btnBuscarJogo.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				table.setRowCount(0);
				String busca = buscaJogo.getText();
				Jogo ObjJogo = new Jogo();
				if (ObjJogo.listarBD("jogo", table, busca))
				{
					NotFoundGames.setVisible(false);
				}
				else NotFoundGames.setVisible(true);
			}});		
		panel.add(btnBuscarJogo);
		
		JButton UpdConta = new JButton("");
		UpdConta.setToolTipText("Atualizar conta");
		UpdConta.setIcon(new ImageIcon(TabAddConta.class.getResource("/imagens/submitt.png")));
		UpdConta.setBounds(554, 483, 52, 42);
		UpdConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idJogo = 0;				
				try { //verifica se será atualizado também um jogo
					idJogo = Integer.parseInt(tabela.getModel().getValueAt(tabela.getSelectedRow(), 0).toString());					
				}
				catch (Exception erro) {
					System.err.println("Nenhum jogo selecionado para atualização");
				}
				try {
					if (!email.getText().equals("") && !senha.getText().equals(""))
					{						
						Conta ObjConta = new Conta(email.getText(), senha.getText(), idJogo);																		
						ObjConta.atualizarDB(ObjConta, idParaAtualizar);						
					}
				}
				catch (Exception erro)
				{
					JOptionPane.showMessageDialog(null, "Você precisa selecionar uma conta para atualizar","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
					System.err.println("Erro: "+erro.getMessage());
				}
				tabelaContas.setFocusable(false);
			}});
		panel.add(UpdConta);
		
		JButton clear = new JButton("");
		clear.setToolTipText("Limpar Campos");
		clear.setIcon(new ImageIcon(TabAddConta.class.getResource("/imagens/reset.png")));
		clear.setBounds(616, 483, 52, 42);
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setRowCount(0);
				tableContas.setRowCount(0);
				senha.setText("");
				email.setText("");
				contaProcurada.setText("");
				idParaAtualizar = 0;				
			}});
		panel.add(clear);		
		
		JButton excluir = new JButton("");
		excluir.setToolTipText("Excluir conta");
		excluir.setIcon(new ImageIcon(TabAddConta.class.getResource("/imagens/del.png")));
		excluir.setBounds(678, 483, 52, 42);
		excluir.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				Conta ObjConta = new Conta(email.getText(), senha.getText());
				if (ObjConta.procurarConta(notFound, email, senha, table))
				{
					int opcaoSelecionada = JOptionPane.showConfirmDialog (null, "Tem certeza que quer excluir a conta com e-mail: "+email.getText()+"?","Aviso",JOptionPane.YES_NO_OPTION);
					if(opcaoSelecionada == JOptionPane.YES_OPTION)
					{					  
					  ObjConta.excluirDB();
					  table.setRowCount(0);
					  senha.setText("");
					  email.setText("");
					  contaProcurada.setText("");
					  buscaJogo.setText("");
					}
				}				
			}});
		panel.add(excluir);
		
		
		
		//imagem de fundo
		JLabel background = new JLabel("");
		background.setToolTipText("Selecione a conta e clique para iniciar atualiza\u00E7\u00E3o");
		background.setIcon(new ImageIcon(TabAddCatPlat.class.getResource("/imagens/background.png")));
		background.setBounds(0, 0, 779, 553);
		panel.add(background);
	
	}	
}

