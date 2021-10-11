package telas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import objetos.CatPlat;
import objetos.CategoriaJogo;
import objetos.Jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;

public class TabAddJogo {
	private JTextField textField;
	private JTextField titulo;
	private JTextField sku;
	private JTextField valor;
	private JTextField imgurl;	
	private JTextField textField_1;
	private JDesktopPane desktopPane;
	
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
		comboBox.setSelectedItem(null);
		tabJogo.add(comboBox);
		
		JLabel add = new JLabel("Categorias");
		add.setFont(new Font("Tahoma", Font.BOLD, 12));
		add.setHorizontalAlignment(SwingConstants.RIGHT);
		add.setBounds(81, 351, 86, 14);
		tabJogo.add(add);
		
		DefaultTableModel TabelaDefaultSelecionada = new DefaultTableModel(new String[] {"id","categoria"},0);
		JTable tabelaCatSelecionada = new JTable (TabelaDefaultSelecionada);
		tabelaCatSelecionada.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabelaCatSelecionada.getColumnModel().getColumn(1).setPreferredWidth(140);		
		JScrollPane scrollSelecionada = new JScrollPane (tabelaCatSelecionada);
		scrollSelecionada.setBounds(177, 306, 170, 100);		
		tabJogo.add(scrollSelecionada);
		
		DefaultTableModel TabelaDefaultDisponivel = new DefaultTableModel(new String[] {"id","categoria"},0);
		JTable tabelaCatDisponivel = new JTable (TabelaDefaultDisponivel);
		tabelaCatDisponivel.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabelaCatDisponivel.getColumnModel().getColumn(1).setPreferredWidth(140);
		JScrollPane scrollDisponivel = new JScrollPane (tabelaCatDisponivel);
		scrollDisponivel.setBounds(400, 208, 170, 300);
		CatPlat ObjCat = new CatPlat();
		ObjCat.preecheTabelaCatPlat(TabelaDefaultDisponivel, "categoria");
		tabJogo.add(scrollDisponivel);		
		
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
		addCat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(tabelaCatDisponivel.getValueAt(tabelaCatDisponivel.getSelectedRow(), 0).toString());
					String categoria = tabelaCatDisponivel.getValueAt(tabelaCatDisponivel.getSelectedRow(), 1).toString();
					TabelaDefaultSelecionada.addRow(new Object[] {id, categoria});
					TabelaDefaultDisponivel.removeRow(tabelaCatDisponivel.getSelectedRow());
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "Selecione a categoria a adicionar antes de clicar","Aviso",JOptionPane.WARNING_MESSAGE);
				}				
			}});
		tabJogo.add(addCat);
		
		JButton removCat = new JButton("");
		removCat.setIcon(new ImageIcon(TabAddJogo.class.getResource("/imagens/remove.png")));
		removCat.setBounds(357, 355, 33, 30);
		removCat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(tabelaCatSelecionada.getValueAt(tabelaCatSelecionada.getSelectedRow(), 0).toString());
					String categoria = tabelaCatSelecionada.getValueAt(tabelaCatSelecionada.getSelectedRow(), 1).toString();
					TabelaDefaultDisponivel.addRow(new Object[] {id, categoria});
					TabelaDefaultSelecionada.removeRow(tabelaCatSelecionada.getSelectedRow());
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "Selecione a categoria a remover antes de clicar","Alerta",JOptionPane.WARNING_MESSAGE);
				}				
			}});
		tabJogo.add(removCat);
		
		JButton clear = new JButton("");
		clear.setIcon(new ImageIcon(TabAddJogo.class.getResource("/imagens/reset.png")));
		clear.setBounds(679, 404, 52, 42);
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sku.setText("");
				titulo.setText("");
				imgurl.setText("");
				valor.setText("");
				comboBox.setSelectedItem(null);	
				TabelaDefaultSelecionada.setNumRows(0);
				CatPlat ObjCat = new CatPlat();
				ObjCat.preecheTabelaCatPlat(TabelaDefaultDisponivel, "categoria");
			}});
		tabJogo.add(clear);
		
		JButton addJogo = new JButton("");
		addJogo.setIcon(new ImageIcon(TabAddJogo.class.getResource("/imagens/submitt.png")));
		addJogo.setBounds(610, 404, 52, 42);
		addJogo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!sku.getText().equals("") && !sku.getText().equals("") && !imgurl.getText().equals("") && !valor.getText().equals("") && comboBox.getSelectedItem() != null) {
					int qtCatSelec = tabelaCatSelecionada.getRowCount();
					if (qtCatSelec == 0) {
						JOptionPane.showMessageDialog(null,"Selecione ao menos uma categoria para continuar","Alerta",JOptionPane.WARNING_MESSAGE);
					} else {
						String idTexto = comboBox.getSelectedItem().toString();
						int idPlataforma = Integer.parseInt(idTexto.substring(0,1));						
						Jogo ObjJogo = new Jogo (sku.getText(), titulo.getText(), imgurl.getText(), Float.parseFloat(valor.getText()), idPlataforma);
						ObjJogo.incluirDB();						
						CategoriaJogo ObjCatJogo = new CategoriaJogo(0,ObjJogo.getId());
						for (int i=0; i<qtCatSelec; i++) {							
							ObjCatJogo.setIdCategoria(Integer.parseInt(tabelaCatSelecionada.getModel().getValueAt(i, 0).toString()));
							ObjCatJogo.inserirDB();							
						}
						clear.doClick();
					}				
				}
				else {
					JOptionPane.showMessageDialog(null, "Todos os campos devem estar preenchidos","Alerta",JOptionPane.WARNING_MESSAGE);
				}
			}});
		tabJogo.add(addJogo);		
			
		JButton atualizaJogo = new JButton("Atualizar um jogo");
		atualizaJogo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		atualizaJogo.setBounds(610, 457, 121, 51);
		atualizaJogo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
			
		});
		tabJogo.add(atualizaJogo);			
		
		//imagem de fundo	
				JLabel background = new JLabel("");
				background.setIcon(new ImageIcon(TabAddJogo.class.getResource("/imagens/background.png")));
				background.setBounds(0, 0, 779, 553);
				tabJogo.add(background);	
	
	}
	
	

}
