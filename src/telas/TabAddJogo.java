package telas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import objetos.CatPlat;

import java.awt.Color;
import java.awt.Font;

public class TabAddJogo {
	private JTextField textField;
	private JTextField titulo;
	private JTextField sku;
	private JTextField valor;
	private JTextField imgurl;	
	
	public TabAddJogo(JTabbedPane tabbedPane)
	{		
		JPanel tabJogo = new JPanel();
		tabbedPane.addTab("Cadastrar Jogo", null, tabJogo, null);
		tabJogo.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("SKU");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(55, 33, 76, 14);
		tabJogo.add(lblNewLabel_1);
		
		sku = new JTextField();
		sku.setToolTipText("Informe o SKU do Jogo");
		sku.setBounds(141, 30, 86, 20);
		tabJogo.add(sku);
		sku.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("T\u00EDtulo do Jogo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(23, 58, 108, 14);
		tabJogo.add(lblNewLabel);
		
		titulo = new JTextField();
		titulo.setToolTipText("Informe o t\u00EDtulo do Jogo");
		titulo.setBounds(141, 55, 606, 20);
		tabJogo.add(titulo);
		titulo.setColumns(75);
		
		JLabel lblNewLabel_3 = new JLabel("URL da Imagem");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(10, 83, 121, 14);
		tabJogo.add(lblNewLabel_3);
		
		imgurl = new JTextField();
		imgurl.setToolTipText("Insira a URL da imagem do jogo");
		imgurl.setBounds(141, 80, 606, 20);
		tabJogo.add(imgurl);
		imgurl.setColumns(75);
		
		JLabel lblNewLabel_2 = new JLabel("Valor");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(45, 108, 86, 14);
		tabJogo.add(lblNewLabel_2);
		
		valor = new JTextField();
		valor.setToolTipText("Digite o valor do Jogo");
		valor.setBounds(141, 105, 86, 20);
		tabJogo.add(valor);
		valor.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Plataforma");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(45, 134, 86, 14);
		tabJogo.add(lblNewLabel_4);
		
		CatPlat ObjPlat = new CatPlat();
		JComboBox comboBox = new JComboBox(ObjPlat.listarDB("plataforma"));
		comboBox.setToolTipText("Selecione a plataforma");
		comboBox.setBounds(141, 130, 200, 20);
		comboBox.setMaximumRowCount(5);
		tabJogo.add(comboBox);
		
		JLabel add = new JLabel("Categorias");
		add.setFont(new Font("Tahoma", Font.BOLD, 12));
		add.setHorizontalAlignment(SwingConstants.RIGHT);
		add.setBounds(81, 351, 86, 14);
		tabJogo.add(add);
		
		JList catSelect = new JList();
		catSelect.setBounds(177, 306, 170, 100);
		catSelect.setBackground(new Color(255, 255, 255, 125));
		catSelect.setVisibleRowCount(4);
		tabJogo.add(catSelect);
		
		JList catAvailable = new JList();
		catAvailable.setBackground(new Color(255, 255, 255, 125));
		catAvailable.setBounds(400, 208, 170, 300);
		tabJogo.add(catAvailable);		
		
		JLabel lblNewLabel_6 = new JLabel("Selecionadas");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(177, 281, 170, 14);
		tabJogo.add(lblNewLabel_6);
				
		JLabel lblNewLabel_7 = new JLabel("Dispon\u00EDveis");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(400, 183, 170, 14);
		tabJogo.add(lblNewLabel_7);
		
		JButton addCat = new JButton("");
		addCat.setIcon(new ImageIcon(TabAddJogo.class.getResource("/imagens/add.png")));
		addCat.setBounds(357, 315, 33, 30);
		tabJogo.add(addCat);
		
		JButton removCat = new JButton("");
		removCat.setIcon(new ImageIcon(TabAddJogo.class.getResource("/imagens/remove.png")));
		removCat.setBounds(357, 355, 33, 30);
		tabJogo.add(removCat);
		
		JButton addBD = new JButton("");
		addBD.setIcon(new ImageIcon(TabAddJogo.class.getResource("/imagens/submitt.png")));
		addBD.setBounds(613, 466, 52, 42);
		tabJogo.add(addBD);
		
		JButton clear = new JButton("");
		clear.setIcon(new ImageIcon(TabAddJogo.class.getResource("/imagens/reset.png")));
		clear.setBounds(683, 466, 52, 42);
		tabJogo.add(clear);
		
		//imagem de fundo	
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(TabAddJogo.class.getResource("/imagens/background.png")));
		background.setBounds(0, 0, 779, 553);
		tabJogo.add(background);		
	
	}
}
