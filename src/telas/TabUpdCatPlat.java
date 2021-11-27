package telas;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JViewport;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import objetos.CatPlat;

import javax.swing.JSeparator;
import javax.swing.JScrollPane;

public class TabUpdCatPlat {
	private JTextField categoria;
	private final JLabel background = new JLabel("");
	private JTextField plataforma;
	private CatPlat ObjCatUpd = new CatPlat();
	private CatPlat ObjPlatUpd = new CatPlat();

	public TabUpdCatPlat(JTabbedPane tabbedPane) {
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Categoria/Plataforma", null, panel, null);
		panel.setLayout(null);
		
		//Categoria
		JLabel lblNewLabel = new JLabel("Categoria");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 442, 75, 18);
		panel.add(lblNewLabel);
		
		categoria = new JTextField();
		categoria.setToolTipText("Digite a categoria");
		categoria.setBackground(Color.WHITE);
		categoria.setBounds(95, 440, 217, 20);
		panel.add(categoria);
		categoria.setColumns(50);		
		
		DefaultTableModel defaultTableCat = new DefaultTableModel(new String[]{"id", "categoria"},0);
		JTable TableCat = new JTable(defaultTableCat);
		TableCat.getColumnModel().getColumn(0).setPreferredWidth(30);
		TableCat.getColumnModel().getColumn(1).setPreferredWidth(195);
		JScrollPane scrollCat = new JScrollPane(TableCat);
		scrollCat.setBounds(87, 36, 225, 340);
		scrollCat.getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE); //resolve bug da falta do repaint do scroll
		CatPlat ObjCat = new CatPlat();
		ObjCat.preecheTabelaCatPlat(defaultTableCat, "categoria");
		panel.add(scrollCat);
		
		JButton clearCat = new JButton("");
		clearCat.setToolTipText("Limpa a informação digitada");
		clearCat.setForeground(Color.LIGHT_GRAY);
		clearCat.setIcon(new ImageIcon(TabUpdCatPlat.class.getResource("/imagens/reset.png")));
		clearCat.setBounds(95, 480, 52, 42);
		clearCat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				categoria.setText("");
				ObjCatUpd = new CatPlat();
				defaultTableCat.setNumRows(0);
				ObjCatUpd.preecheTabelaCatPlat(defaultTableCat, "categoria");
			}});
		panel.add(clearCat);
		
		JButton UpdCat = new JButton("");
		UpdCat.setToolTipText("Cadastra Categoria");
		UpdCat.setForeground(Color.LIGHT_GRAY);
		UpdCat.setIcon(new ImageIcon(TabUpdCatPlat.class.getResource("/imagens/submitt.png")));
		UpdCat.setBounds(260, 480, 52, 42);
		panel.add(UpdCat);
		UpdCat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		
				if (ObjCatUpd.getId("categoria")<=0) {
					JOptionPane.showMessageDialog(null, "Selecione uma categoria na lista acima antes de clicar no botão para atualizá-la","Aviso", JOptionPane.WARNING_MESSAGE);
				} else {
					ObjCatUpd.setNome(categoria.getText());
					ObjCatUpd.atualizarCatPlat("categoria");
					clearCat.doClick();
				}
			}});
		
		JButton removCat = new JButton("");
		removCat.setToolTipText("Apaga Categoria selecionada");
		removCat.setIcon(new ImageIcon(TabUpdCatPlat.class.getResource("/imagens/del.png")));
		removCat.setBounds(180, 480, 52, 42);
		removCat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
					if (ObjCatUpd.getId("categoria")<=0) {
						JOptionPane.showMessageDialog(null, "Nenhuma categoria selecionada para exclusão","Alerta",JOptionPane.WARNING_MESSAGE);
					}else {
					CatPlat ObjCat = new CatPlat();
					int id = Integer.parseInt(TableCat.getModel().getValueAt(TableCat.getSelectedRow(), 0).toString());
					ObjCat.exluirDB(id, "categoria");
					ObjCat.preecheTabelaCatPlat(defaultTableCat, "categoria");				
					tabbedPane.repaint();	
					}
			}});
		panel.add(removCat);		
		
		
		JButton btnSelectCat = new JButton("");
		btnSelectCat.setToolTipText("Seleciona uma categoria para edi\u00E7\u00E3o");
		btnSelectCat.setIcon(new ImageIcon(TabUpdCatPlat.class.getResource("/imagens/down.png")));
		btnSelectCat.setBounds(180, 387, 40, 42);
		panel.add(btnSelectCat);
		btnSelectCat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					categoria.setText(TableCat.getModel().getValueAt(TableCat.getSelectedRow(), 1).toString());
					ObjCatUpd = new CatPlat(TableCat.getModel().getValueAt(TableCat.getSelectedRow(), 1).toString());
					int id = ObjCatUpd.getId("categoria");					
				} catch(Exception erro) {
					JOptionPane.showMessageDialog(null, "Selecione uma categoria na lista acima antes de clicar no botão para atualizá-la","Aviso", JOptionPane.WARNING_MESSAGE);
				}				
			}});
				
		JLabel lblNewLabel_1 = new JLabel("Categorias cadastradas");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(87, 11, 225, 14);
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
		lblNewLabel_2.setBounds(393, 443, 85, 16);
		panel.add(lblNewLabel_2);
		
		plataforma = new JTextField();
		plataforma.setToolTipText("Digite a Plataforma");
		plataforma.setBounds(488, 442, 200, 20);
		panel.add(plataforma);
		plataforma.setColumns(50);		
				
		DefaultTableModel defaultTablePlat = new DefaultTableModel(new String[]{"id", "plataforma"},0);
		JTable TablePlat = new JTable(defaultTablePlat);
		TablePlat.getColumnModel().getColumn(0).setPreferredWidth(30);
		TablePlat.getColumnModel().getColumn(1).setPreferredWidth(195);
		JScrollPane scrollPlat = new JScrollPane(TablePlat);
		scrollPlat.setBounds(463, 36, 225, 340);
		scrollPlat.getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE); //resolve bug da falta do repaint do scroll
		CatPlat ObjPlat = new CatPlat();
		ObjPlat.preecheTabelaCatPlat(defaultTablePlat, "plataforma");
		panel.add(scrollPlat);
		
		JButton clearPlat = new JButton("");
		clearPlat.setToolTipText("Limpa a informa\u00E7\u00E3o digitada");
		clearPlat.setIcon(new ImageIcon(TabUpdCatPlat.class.getResource("/imagens/reset.png")));
		clearPlat.setForeground(Color.LIGHT_GRAY);
		clearPlat.setBounds(488, 480, 52, 42);
		clearPlat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				plataforma.setText("");	
				ObjPlatUpd = new CatPlat();				
				defaultTablePlat.setNumRows(0);
				ObjPlatUpd.preecheTabelaCatPlat(defaultTablePlat, "plataforma");
			}
		});
		panel.add(clearPlat);	
		
		JButton UpdPlat = new JButton("");
		UpdPlat.setToolTipText("Cadastra Pataforma ");
		UpdPlat.setIcon(new ImageIcon(TabUpdCatPlat.class.getResource("/imagens/submitt.png")));
		UpdPlat.setForeground(Color.LIGHT_GRAY);
		UpdPlat.setBounds(636, 480, 52, 42);
		UpdPlat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ObjPlatUpd.getId("plataforma")<=0) {
					JOptionPane.showMessageDialog(null, "Selecione uma plataforma na lista acima antes de clicar no botão para atualizá-la","Aviso", JOptionPane.WARNING_MESSAGE);
				} else {
					ObjPlatUpd.setNome(plataforma.getText());
					ObjPlatUpd.atualizarCatPlat("plataforma");
					clearPlat.doClick();
				}
			}
		});
		panel.add(UpdPlat);		
		
		//excluir item DB
		JButton removPlat = new JButton("");
		removPlat.setToolTipText("Apaga Plataforma selecionada");
		removPlat.setIcon(new ImageIcon(TabUpdCatPlat.class.getResource("/imagens/del.png")));
		removPlat.setForeground(Color.LIGHT_GRAY);
		removPlat.setBounds(563, 480, 52, 42);
		removPlat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ObjPlatUpd.getId("plataforma")<=0) {
					JOptionPane.showMessageDialog(null, "Nenhuma pataforma selecionada para exclusão","Alerta",JOptionPane.WARNING_MESSAGE);
				}else {
					CatPlat ObjPlat = new CatPlat ();
					int id = Integer.parseInt(TablePlat.getValueAt(TablePlat.getSelectedRow(), 0).toString());
					ObjPlat.exluirDB(id, "plataforma");
					ObjPlat.preecheTabelaCatPlat(defaultTablePlat, "plataforma");
					tabbedPane.repaint();
				}
			}
			
		});
		panel.add(removPlat);
		
		JButton btnSelectPLat = new JButton("");
		btnSelectPLat.setToolTipText("Seleciona uma plataforma para edi\u00E7\u00E3o");
		btnSelectPLat.setIcon(new ImageIcon(TabUpdCatPlat.class.getResource("/imagens/down.png")));
		btnSelectPLat.setBounds(563, 389, 40, 42);
		panel.add(btnSelectPLat);
		btnSelectPLat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					plataforma.setText(TablePlat.getModel().getValueAt(TablePlat.getSelectedRow(), 1).toString());
					ObjPlatUpd = new CatPlat(TablePlat.getModel().getValueAt(TablePlat.getSelectedRow(), 1).toString());
					int id = ObjPlatUpd.getId("plataforma");					
				} catch(Exception erro) {
					JOptionPane.showMessageDialog(null, "Selecione uma plataforma na lista acima antes de clicar no botão para atualizá-la","Aviso", JOptionPane.WARNING_MESSAGE);
				}				
			}});				
		
		JLabel lblNewLabel_1_1 = new JLabel("Plataformas cadastradas");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(469, 11, 225, 14);
		panel.add(lblNewLabel_1_1);	
				
		
		
		//imagem de fundo
		background.setIcon(new ImageIcon(TabUpdCatPlat.class.getResource("/imagens/background.png")));
		background.setBounds(0, 0, 779, 553);
		panel.add(background);	
		
		
	}
}
