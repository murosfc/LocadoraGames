package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.ListModel;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.UIManager;

import manipularDB.DBPlataforma;
import objetos.Plataforma;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;

public class TabAddCatPlat {
	private JTextField categoria;
	private final JLabel background = new JLabel("");
	private JTextField plataforma;

	public TabAddCatPlat(JTabbedPane tabbedPane) {
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Categoria/PLataforma", null, panel, null);
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
		
		JButton addCat = new JButton("");
		addCat.setForeground(Color.LIGHT_GRAY);
		addCat.setIcon(new ImageIcon(TabAddCatPlat.class.getResource("/imagens/submitt.png")));
		addCat.setBounds(155, 61, 52, 42);
		panel.add(addCat);
		addCat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		
				//Plataforma ObjPlat = new Plataforma ();
			}			
		});
		
		JButton clearCat = new JButton("");
		clearCat.setForeground(Color.LIGHT_GRAY);
		clearCat.setIcon(new ImageIcon(TabAddCatPlat.class.getResource("/imagens/reset.png")));
		clearCat.setBounds(229, 61, 52, 42);
		panel.add(clearCat);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(294, 151, 17, 362);
		panel.add(scrollBar);
		
		JList listCat = new JList();
		listCat.setBackground(new Color(255, 255, 255, 125));
		listCat.setBounds(82, 151, 227, 362);
		panel.add(listCat);		
				
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
		
		
		
		JButton addPlat = new JButton("");
		addPlat.setIcon(new ImageIcon(TabAddCatPlat.class.getResource("/imagens/submitt.png")));
		addPlat.setForeground(Color.LIGHT_GRAY);
		addPlat.setBounds(538, 61, 52, 42);
		addPlat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Plataforma ObjPlat = new Plataforma (plataforma.getText());
				ObjPlat.incluirDB();
				plataforma.setText("");				
			}
			
		});
		panel.add(addPlat);
		
		JButton clearPlat = new JButton("");
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
		
		JList listPlat = new JList();
		listPlat.setBackground(new Color(255, 255, 255, 125));
		listPlat.setBounds(480, 151, 227, 362);
		panel.add(listPlat);	
		
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
}
