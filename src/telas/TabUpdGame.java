package telas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import javax.swing.table.DefaultTableModel;

import objetos.CatPlat;
import objetos.CategoriaJogo;
import objetos.Jogo;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.Color;

public class TabUpdGame {
	private int idJogoAtualizar = 0;
	private Jogo ObjJogo = new Jogo();
	CatPlat ObjTempCatPlat = new CatPlat();
	private List<CategoriaJogo> ObjCategoriaJogo = new ArrayList<CategoriaJogo>();
	int quantidadeCategoriaJogo = 0;

	public TabUpdGame(JTabbedPane tabbedPane) {
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Atualizar Jogo", null, panel, null);
		panel.setBounds(0, 0, 790, 561);		
		panel.setLayout(null);		
		
		//labels
		JLabel lblNewLabel = new JLabel("Procurar jogo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 25, 110, 14);
		panel.add(lblNewLabel);			
		
		JLabel lblNewLabel_1 = new JLabel("Título");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(74, 233, 46, 14);
		panel.add(lblNewLabel_1);			
		
		JLabel lblNewLabel_2 = new JLabel("SKU");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(74, 203, 46, 14);
		panel.add(lblNewLabel_2);		
		
		JLabel lblNewLabel_3 = new JLabel("Valor");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(74, 264, 46, 14);
		panel.add(lblNewLabel_3);			
		
		JLabel lblNewLabel_4 = new JLabel("URL Imagem");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(27, 295, 93, 14);
		panel.add(lblNewLabel_4);	
		
		JLabel lblNewLabel_5 = new JLabel("Plataforma");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(27, 326, 89, 14);
		panel.add(lblNewLabel_5);	
		
		JLabel lblNewLabel_6 = new JLabel("Plataformas cadastradas");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_6.setBounds(41, 356, 180, 14);
		panel.add(lblNewLabel_6);
				
		JLabel lblNewLabel_7 = new JLabel("Categorias do jogo");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_7.setBounds(310, 341, 145, 14);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Categorias disponíveis");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8.setBounds(514, 341, 134, 14);
		panel.add(lblNewLabel_8);
		
		JLabel notFoundGames = new JLabel("Nenhum resultado encontrado!");				
		notFoundGames.setFont(new Font("Times New Roman", Font.BOLD, 12));
		notFoundGames.setHorizontalAlignment(SwingConstants.CENTER);
		notFoundGames.setBounds(131, 11, 421, 14);
		notFoundGames.setForeground(Color.RED);
		notFoundGames.setVisible(false);
		panel.add(notFoundGames);
		
		
		//Tabelas
		DefaultTableModel DefaultabelaJogos = new DefaultTableModel (new String[]{"id","titulo","plataforma"},0);
		JTable tabelaJogos = new JTable(DefaultabelaJogos);	
		tabelaJogos.getColumnModel().getColumn(0).setPreferredWidth(60);
		tabelaJogos.getColumnModel().getColumn(1).setPreferredWidth(420);
		tabelaJogos.getColumnModel().getColumn(2).setPreferredWidth(220);				
		JScrollPane ScrollTabelaJogos = new JScrollPane (tabelaJogos);
		ScrollTabelaJogos.setBounds(41, 62, 700, 112);
		panel.add(ScrollTabelaJogos);
		
		DefaultTableModel DefTabelaCatCadastradas = new DefaultTableModel (new String[] {"id","Categoria"},0);
		JTable tabelaCatCadastradas = new JTable(DefTabelaCatCadastradas);
		tabelaCatCadastradas.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabelaCatCadastradas.getColumnModel().getColumn(1).setPreferredWidth(115);
		JScrollPane ScrollTabelaCat = new JScrollPane (tabelaCatCadastradas);
		ScrollTabelaCat.setBounds(514, 355, 145, 167);
		CatPlat ObjCatPlat = new CatPlat();
		ObjCatPlat.preecheTabelaCatPlat(DefTabelaCatCadastradas, "categoria");
		panel.add(ScrollTabelaCat);
		
		DefaultTableModel DefTabelaCatdoJogo = new DefaultTableModel (new String[] {"id","Categoria"},0);
		JTable tabelaCatdoJogo = new JTable(DefTabelaCatdoJogo);
		tabelaCatdoJogo.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabelaCatdoJogo.getColumnModel().getColumn(1).setPreferredWidth(115);
		JScrollPane ScrollTabCatdoJogo = new JScrollPane (tabelaCatdoJogo);
		ScrollTabCatdoJogo.setBounds(310, 355, 145, 167);
		panel.add(ScrollTabCatdoJogo);	
		
		DefaultTableModel DeftabelaPlataformas = new DefaultTableModel (new String[] {"id","Plataforma"},0);;
		JTable tabelaPlataformas = new JTable(DeftabelaPlataformas);
		tabelaPlataformas.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabelaPlataformas.getColumnModel().getColumn(1).setPreferredWidth(150);
		JScrollPane ScrollTabelaPlataformas = new JScrollPane (tabelaPlataformas);
		ScrollTabelaPlataformas.setBounds(41, 370, 180, 152);		
		ObjCatPlat.preecheTabelaCatPlat(DeftabelaPlataformas, "plataforma");
		panel.add(ScrollTabelaPlataformas);	
		
		//Caixas de texto
		JTextField tituloValue = new JTextField();
		tituloValue.setBounds(131, 231, 609, 20);
		panel.add(tituloValue);
		tituloValue.setColumns(10);
		
		JTextField jogoProcuradoValue = new JTextField();
		jogoProcuradoValue.setBounds(131, 23, 421, 20);
		panel.add(jogoProcuradoValue);
		jogoProcuradoValue.setColumns(10);
		
		JTextField skuValue = new JTextField();
		skuValue.setBounds(131, 200, 250, 20);
		panel.add(skuValue);
		skuValue.setColumns(10);
		
		JTextField valorValue = new JTextField();
		valorValue.setBounds(131, 262, 110, 20);
		panel.add(valorValue);
		valorValue.setColumns(10);		
		
		JTextField imgUrlValue = new JTextField();
		imgUrlValue.setBounds(131, 293, 609, 20);
		panel.add(imgUrlValue);
		imgUrlValue.setColumns(10);		

		JTextField plataformaValue = new JTextField();
		plataformaValue.setEditable(false);
		plataformaValue.setBounds(131, 324, 139, 20);
		panel.add(plataformaValue);
		plataformaValue.setColumns(10);	
		
		//Botões
		JButton btnProcurar = new JButton("");
		btnProcurar.setIcon(new ImageIcon(TabUpdGame.class.getResource("/imagens/busca.png")));
		btnProcurar.setBounds(562, 11, 52, 42);
		btnProcurar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultabelaJogos.setRowCount(0);
				String busca = jogoProcuradoValue.getText();
				Jogo ObjJogo = new Jogo();
				if (ObjJogo.listarBD("jogo", DefaultabelaJogos, busca))
				{
					notFoundGames.setVisible(false);
				}
				else notFoundGames.setVisible(true);				
			}});
		panel.add(btnProcurar);	
		
		JButton SelecionarJogoUpd = new JButton("");
		SelecionarJogoUpd.setToolTipText("Clique para enviar jogo para atualizar");
		SelecionarJogoUpd.setIcon(new ImageIcon(TabUpdGame.class.getResource("/imagens/down.png")));
		SelecionarJogoUpd.setBounds(409, 178, 37, 42);
		SelecionarJogoUpd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					idJogoAtualizar = Integer.parseInt((tabelaJogos.getModel().getValueAt(tabelaJogos.getSelectedRow(), 0).toString()));					
					ObjJogo.getJogoFromDB(idJogoAtualizar);					
					tituloValue.setText(ObjJogo.getTitulo());					
					skuValue.setText(ObjJogo.getSku());					
					valorValue.setText(Float.toString(ObjJogo.getValor()));
					imgUrlValue.setText(ObjJogo.getImgurl());
					plataformaValue.setText(tabelaJogos.getModel().getValueAt(tabelaJogos.getSelectedRow(), 2).toString());
					CategoriaJogo ObjCatJogo = new CategoriaJogo();
					ObjCatJogo.preecheTabelaCatdoJogo(DefTabelaCatdoJogo, ObjJogo.getIdJogo());					
				}
				catch (Exception GameNotSelected) {
					JOptionPane.showMessageDialog(null, "Selecione um jogo antes","Alerta", JOptionPane.WARNING_MESSAGE);					
				}			
			}});
		panel.add(SelecionarJogoUpd);		
		
		JButton btnAddPlat = new JButton("");
		btnAddPlat.setToolTipText("Atualizar Plataforma");		
		btnAddPlat.setIcon(new ImageIcon(TabUpdGame.class.getResource("/imagens/up.png")));
		btnAddPlat.setBounds(231, 370, 37, 42);
		btnAddPlat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					plataformaValue.setText(tabelaPlataformas.getModel().getValueAt(tabelaPlataformas.getSelectedRow(), 1).toString());
					ObjJogo.setIdPlat(Integer.parseInt(tabelaPlataformas.getModel().getValueAt(tabelaPlataformas.getSelectedRow(), 0).toString()));										
				}
				catch (Exception PlatNotSelected) {
					JOptionPane.showMessageDialog(null, "Selecione uma plataforma antes");					
				}	
			}
		});
		panel.add(btnAddPlat);	
		
		JButton btnDeleteCat = new JButton("");
		btnDeleteCat.setToolTipText("Remover categoria");
		btnDeleteCat.setIcon(new ImageIcon(TabUpdGame.class.getResource("/imagens/x.png")));
		btnDeleteCat.setBounds(462, 446, 42, 42);
		btnDeleteCat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (tabelaCatdoJogo.getModel().getValueAt(tabelaCatdoJogo.getSelectedRow(), 0).toString().equals("X")) {
						CategoriaJogo ObjCatJogo = new CategoriaJogo(Integer.parseInt(tabelaCatCadastradas.getModel().getValueAt(tabelaCatCadastradas.getSelectedRow(), 0).toString()),idJogoAtualizar);
						ObjCategoriaJogo.remove(ObjCatJogo);
						DefTabelaCatdoJogo.removeRow(tabelaCatdoJogo.getSelectedRow());												
					}
					else {
					int idCategoria = Integer.parseInt(tabelaCatdoJogo.getModel().getValueAt(tabelaCatdoJogo.getSelectedRow(), 0).toString());
					CategoriaJogo ObjCatJogo = new CategoriaJogo(idCategoria, ObjJogo.getId());
					ObjCatJogo.excluirCategoriaDoJogo(ObjJogo, DefTabelaCatdoJogo);
					}
				}
				catch (Exception erro)
				{
					JOptionPane.showMessageDialog(null, "Selecione uma categoria antes","Alerta",JOptionPane.WARNING_MESSAGE);
					System.err.println("Erro: "+ erro.getMessage());
				}
				
			}});
		panel.add(btnDeleteCat);	
		
		JButton btnLimpar = new JButton("");
		btnLimpar.setIcon(new ImageIcon(TabUpdGame.class.getResource("/imagens/reset.png")));
		btnLimpar.setBounds(690, 423, 50, 42);
		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			notFoundGames.setVisible(false);
			tituloValue.setText("");	
			jogoProcuradoValue.setText("");
			skuValue.setText("");
			valorValue.setText("");
			imgUrlValue.setText("");
			plataformaValue.setText("");
			DefaultabelaJogos.setRowCount(0);
			DefTabelaCatdoJogo.setRowCount(0);
			ObjCatPlat.preecheTabelaCatPlat(DefTabelaCatCadastradas, "categoria");
			ObjCatPlat.preecheTabelaCatPlat(DeftabelaPlataformas, "plataforma");
			idJogoAtualizar = 0;
			quantidadeCategoriaJogo = 0;
			ObjJogo = new Jogo();
			ObjCategoriaJogo.clear();			
			}
			
		});
		panel.add(btnLimpar);			
		
		JButton btnAddCat = new JButton("");
		btnAddCat.setToolTipText("Atualizar categoria");
		btnAddCat.setIcon(new ImageIcon(TabUpdGame.class.getResource("/imagens/add.png")));
		btnAddCat.setBounds(462, 398, 42, 37);
		panel.add(btnAddCat);
		btnAddCat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int idCategoria = Integer.parseInt(tabelaCatCadastradas.getModel().getValueAt(tabelaCatCadastradas.getSelectedRow(), 0).toString());									
					CategoriaJogo ObjCatJogo = new CategoriaJogo(idCategoria,idJogoAtualizar);
					ObjCatJogo.inserirVariosDB(ObjJogo);
					ObjCatJogo.preecheTabelaCatdoJogo(DefTabelaCatdoJogo, ObjJogo.getIdJogo());	
				}
				catch (Exception erro) {
					JOptionPane.showMessageDialog(null,"Selecione uma categoria para adicionar","Alerta",JOptionPane.WARNING_MESSAGE);
					System.err.println("Erro: "+erro.getMessage());
				}				
			}});		
		
		
		JButton btnAtualizar = new JButton("");
		btnAtualizar.setIcon(new ImageIcon(TabUpdGame.class.getResource("/imagens/submitt.png")));
		btnAtualizar.setBounds(690, 476, 50, 42);
		panel.add(btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ObjJogo.setSku(skuValue.getText());
					ObjJogo.setTitulo(tituloValue.getText());
					ObjJogo.setValor(Float.parseFloat(valorValue.getText()));
					ObjJogo.setImgurl(imgUrlValue.getText());
					CatPlat ObjPlat = new CatPlat (plataformaValue.getText());
					ObjJogo.setIdPlat(ObjPlat.getId("plataforma"));
					ObjJogo.atualizarDB();	
					btnLimpar.doClick();
					}				
				catch (Exception erro) {
					JOptionPane.showMessageDialog(null,"Selecione uma categoria para adicionar","Alerta",JOptionPane.WARNING_MESSAGE);
					System.err.println("Erro: "+erro.getMessage());
				}
			}});		
		
		//imagem de fundo
		JLabel background = new JLabel("");
		background.setToolTipText("Selecione a conta e clique para iniciar atualiza\u00E7\u00E3o");
		background.setIcon(new ImageIcon(TabAddCatPlat.class.getResource("/imagens/background.png")));
		background.setBounds(0, 0, 779, 553);
		panel.add(background);	
	}
}

