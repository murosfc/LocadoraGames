package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ListModel;

import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.UIManager;

import manipularDB.DBCatPlat;
import objetos.CatPlat;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class TabAddCatPlat {
	private JTextField categoria;
	private final JLabel background = new JLabel("");
	private JTextField plataforma;
	private String[] listaPlat;

	public TabAddCatPlat(JTabbedPane tabbedPane) {
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Categoria/Plataforma", null, panel, null);
		panel.setLayout(null);
		
		//Categoria
		JLabel lblNewLabel = new JLabel("Categoria");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(26, 32, 75, 14);
		panel.add(lblNewLabel);
		
		categoria = new JTextField();
		categoria.setToolTipText("Digite a categoria");
		categoria.setBackground(Color.WHITE);
		categoria.setBounds(111, 30, 200, 20);
		panel.add(categoria);
		categoria.setColumns(50);		
				
		CatPlat ObjCat = new CatPlat();
		JScrollPane scrollPaneL2 = new JScrollPane();
		JList listCat = new JList(ObjCat.listarDB("categoria"));
		scrollPaneL2.setBounds(82, 151, 225, 360);
		scrollPaneL2.setViewportView(listCat);
		scrollPaneL2.getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE); //resolve bug da falta do repaint do scroll			
		panel.add(scrollPaneL2);
		
		JButton addCat = new JButton("");
		addCat.setToolTipText("Cadastra Categoria");
		addCat.setForeground(Color.LIGHT_GRAY);
		addCat.setIcon(new ImageIcon(TabAddCatPlat.class.getResource("/imagens/submitt.png")));
		addCat.setBounds(155, 61, 52, 42);
		panel.add(addCat);
		addCat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		
				CatPlat ObjCat = new CatPlat(categoria.getText());
				ObjCat.incluirDB("categoria");
				listCat.setListData(ObjCat.listarDB("categoria"));
				categoria.setText("");
				tabbedPane.repaint();	
			}			
		});
		
		JButton removCat = new JButton("");
		removCat.setToolTipText("Apaga Categoria selecionada");
		removCat.setIcon(new ImageIcon(TabAddCatPlat.class.getResource("/imagens/del.png")));
		removCat.setBounds(319, 469, 52, 42);
		removCat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CatPlat ObjCat = new CatPlat();
				ObjCat.exluirDB(getId((String) listCat.getSelectedValue()), "categoria");
				listCat.setListData(ObjCat.listarDB("categoria"));
				tabbedPane.repaint();	
			}
			
		});
		panel.add(removCat);
		
		JButton clearCat = new JButton("");
		clearCat.setToolTipText("Limpa a informa\u00E7\u00E3o digitada");
		clearCat.setForeground(Color.LIGHT_GRAY);
		clearCat.setIcon(new ImageIcon(TabAddCatPlat.class.getResource("/imagens/reset.png")));
		clearCat.setBounds(229, 61, 52, 42);
		clearCat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				categoria.setText("");
				
			}
			
		});
		panel.add(clearCat);
				
		JLabel lblNewLabel_1 = new JLabel("Categorias cadastradas");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(82, 126, 227, 14);
		panel.add(lblNewLabel_1);
		
		//Separador
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(390, 0, 1, 553);
		panel.add(separator);
		
		//Plataforma
		JLabel lblNewLabel_2 = new JLabel("Plataforma");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(401, 32, 96, 14);
		panel.add(lblNewLabel_2);
		
		plataforma = new JTextField();
		plataforma.setToolTipText("Digite a Plataforma");
		plataforma.setBounds(507, 30, 200, 20);
		panel.add(plataforma);
		plataforma.setColumns(50);
		
		CatPlat ObjPlat=new CatPlat(); //Retorna cadastrados no BD
		JScrollPane scrollPaneL1 = new JScrollPane();
		JList listPlat = new JList(ObjPlat.listarDB("plataforma"));		
		scrollPaneL1.setBounds(480, 151, 225, 360);
		scrollPaneL1.setViewportView(listPlat);
		scrollPaneL1.getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE); //resolve bug da falta do repaint do scroll		
		//panel.add(listPlat);
		panel.add(scrollPaneL1);	
		
		JButton addPlat = new JButton("");
		addPlat.setToolTipText("Cadastra Pataforma ");
		addPlat.setIcon(new ImageIcon(TabAddCatPlat.class.getResource("/imagens/submitt.png")));
		addPlat.setForeground(Color.LIGHT_GRAY);
		addPlat.setBounds(538, 61, 52, 42);
		addPlat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CatPlat ObjPlat = new CatPlat (plataforma.getText());
				ObjPlat.incluirDB("plataforma");
				listPlat.setListData(ObjPlat.listarDB("plataforma"));
				plataforma.setText("");
				tabbedPane.repaint();
			}
			
		});
		panel.add(addPlat);
		
		JButton clearPlat = new JButton("");
		clearPlat.setToolTipText("Limpa a informa\u00E7\u00E3o digitada");
		clearPlat.setIcon(new ImageIcon(TabAddCatPlat.class.getResource("/imagens/reset.png")));
		clearPlat.setForeground(Color.LIGHT_GRAY);
		clearPlat.setBounds(614, 61, 52, 42);
		clearPlat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				plataforma.setText("");			
			}			
		});
		panel.add(clearPlat);	
		
		//excluir item DB
		JButton removPlat = new JButton("");
		removPlat.setToolTipText("Apaga Plataforma selecionada");
		removPlat.setIcon(new ImageIcon(TabAddCatPlat.class.getResource("/imagens/del.png")));
		removPlat.setForeground(Color.LIGHT_GRAY);
		removPlat.setBounds(717, 469, 52, 42);
		removPlat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CatPlat ObjPlat = new CatPlat ();						
				ObjPlat.exluirDB(getId((String) listPlat.getSelectedValue()), "plataforma");
				listPlat.setListData(ObjPlat.listarDB("plataforma"));
				tabbedPane.repaint();
			}
			
		});
		panel.add(removPlat);
		
		JLabel lblNewLabel_1_1 = new JLabel("Plataformas cadastradas");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(480, 126, 227, 14);
		panel.add(lblNewLabel_1_1);			
		
		//imagem de fundo
		background.setIcon(new ImageIcon(TabAddCatPlat.class.getResource("/imagens/background.png")));
		background.setBounds(0, 0, 779, 553);
		panel.add(background);	
		
		
	}
	//obtem a id o item a ser consultado no DB
	private int getId(String platCat)
	{
		if (platCat != null)
		{
			String[] texto = platCat.split("-");
			int id = Integer.parseInt(texto[0]);
			return id;
		}
		else return -1;
	}
}
