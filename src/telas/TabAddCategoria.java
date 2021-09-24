package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.UIManager;

public class TabAddCategoria {
	private JTextField textField;
	private final JLabel background = new JLabel("");

	public TabAddCategoria(JTabbedPane tabbedPane) {
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Adicionar Categoria", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Categoria");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(62, 33, 75, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setBounds(142, 30, 203, 20);
		panel.add(textField);
		textField.setColumns(50);
		
		JButton add = new JButton("");
		add.setForeground(Color.LIGHT_GRAY);
		add.setIcon(new ImageIcon(TabAddCategoria.class.getResource("/imagens/submitt.png")));
		add.setBounds(172, 61, 52, 42);
		panel.add(add);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.setIcon(new ImageIcon(TabAddCategoria.class.getResource("/imagens/reset.png")));
		btnNewButton.setBounds(271, 61, 52, 42);
		panel.add(btnNewButton);
		
		JList list = new JList();
		list.setBackground(new Color(255, 255, 255, 125));
		list.setBounds(142, 145, 227, 362);
		panel.add(list);
		
		JLabel lblNewLabel_1 = new JLabel("Categorias cadastradas");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(142, 120, 227, 14);
		panel.add(lblNewLabel_1);
		
		//imagem de fundo
		background.setIcon(new ImageIcon(TabAddCategoria.class.getResource("/imagens/background.png")));
		background.setBounds(0, 0, 779, 553);
		panel.add(background);
		
	}

	
}
