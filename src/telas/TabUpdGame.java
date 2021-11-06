package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import objetos.CatPlat;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabUpdGame {

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
		
		JLabel lblNewLabel_8 = new JLabel("Categorias dispon\u00EDveis");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8.setBounds(514, 341, 134, 14);
		panel.add(lblNewLabel_8);
		
		//Tabelas
		DefaultTableModel DefaultabelaJogos = new DefaultTableModel (new String[]{"id","SKU","titulo","valor","plataforma"},0);
		JTable tabelaJogos = new JTable(DefaultabelaJogos);	
		tabelaJogos.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabelaJogos.getColumnModel().getColumn(1).setPreferredWidth(150);
		tabelaJogos.getColumnModel().getColumn(2).setPreferredWidth(300);
		tabelaJogos.getColumnModel().getColumn(3).setPreferredWidth(70);
		tabelaJogos.getColumnModel().getColumn(4).setPreferredWidth(150);		
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
		
		JTextField ImgUrlValue = new JTextField();
		ImgUrlValue.setBounds(131, 293, 609, 20);
		panel.add(ImgUrlValue);
		ImgUrlValue.setColumns(10);		

		JTextField PlataformaValue = new JTextField();
		PlataformaValue.setEditable(false);
		PlataformaValue.setBounds(131, 324, 139, 20);
		panel.add(PlataformaValue);
		PlataformaValue.setColumns(10);	
		
		//Botões
		JButton btnProcurar = new JButton("");
		btnProcurar.setIcon(new ImageIcon(TabUpdGame.class.getResource("/imagens/busca.png")));
		btnProcurar.setBounds(562, 11, 52, 42);
		panel.add(btnProcurar);	
		
		JButton SelecionarJogoUpd = new JButton("");
		SelecionarJogoUpd.setToolTipText("Clique para enviar jogo para atualiza\u00E7\u00E3o");
		SelecionarJogoUpd.setIcon(new ImageIcon(TabUpdGame.class.getResource("/imagens/down.png")));
		SelecionarJogoUpd.setBounds(409, 178, 37, 42);
		panel.add(SelecionarJogoUpd);		
		
		JButton btnAddPlat = new JButton("");
		btnAddPlat.setToolTipText("Atualizar Plataforma");
		btnAddPlat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddPlat.setIcon(new ImageIcon(TabUpdGame.class.getResource("/imagens/up.png")));
		btnAddPlat.setBounds(231, 370, 37, 42);
		panel.add(btnAddPlat);
		
		JButton btnAtualizar = new JButton("");
		btnAtualizar.setIcon(new ImageIcon(TabUpdGame.class.getResource("/imagens/submitt.png")));
		btnAtualizar.setBounds(690, 476, 50, 42);
		panel.add(btnAtualizar);	
		
		JButton btnAddCat = new JButton("");
		btnAddCat.setIcon(new ImageIcon(TabUpdGame.class.getResource("/imagens/add.png")));
		btnAddCat.setBounds(462, 398, 42, 37);
		panel.add(btnAddCat);
		
		JButton btnDeleteCat = new JButton("");
		btnDeleteCat.setIcon(new ImageIcon(TabUpdGame.class.getResource("/imagens/x.png")));
		btnDeleteCat.setBounds(462, 446, 42, 42);
		panel.add(btnDeleteCat);	
		
		JButton btnLimpar = new JButton("");
		btnLimpar.setIcon(new ImageIcon(TabUpdGame.class.getResource("/imagens/reset.png")));
		btnLimpar.setBounds(690, 423, 50, 42);
		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			tituloValue.setText("");	
			jogoProcuradoValue.setText("");
			skuValue.setText("");
			valorValue.setText("");
			ImgUrlValue.setText("");
			PlataformaValue.setText("");
			DefaultabelaJogos.setRowCount(0);
			DefTabelaCatdoJogo.setRowCount(0);
			ObjCatPlat.preecheTabelaCatPlat(DefTabelaCatCadastradas, "categoria");
			ObjCatPlat.preecheTabelaCatPlat(DeftabelaPlataformas, "plataforma");
			}
			
		});
		panel.add(btnLimpar);
		
		//imagem de fundo
		JLabel background = new JLabel("");
		background.setToolTipText("Selecione a conta e clique para iniciar atualiza\u00E7\u00E3o");
		background.setIcon(new ImageIcon(TabAddCatPlat.class.getResource("/imagens/background.png")));
		background.setBounds(0, 0, 779, 553);
		panel.add(background);
		
	}
}
