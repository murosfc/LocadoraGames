package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
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
		
		JTextField lblNewLabel_3 = new JTextField();
		lblNewLabel_3.setToolTipText("Digite o e-mail");
		lblNewLabel_3.setBounds(123, 30, 250, 20);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setColumns(50);
		
		JLabel lblNewLabel = new JLabel("Senha");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(408, 32, 62, 14);
		panel.add(lblNewLabel);
		
		JTextField textField = new JTextField();
		textField.setToolTipText("Verifique se est\u00E1 correto antes de cadastrar");
		textField.setBounds(480, 30, 250, 20);
		panel.add(textField);
		textField.setColumns(50);
		
		JLabel lblNewLabel_2 = new JLabel("Busca do jogo pertencente \u00E0 conta");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(283, 79, 221, 14);
		panel.add(lblNewLabel_2);
		
		JTextField textField_1 = new JTextField();
		textField_1.setToolTipText("Busque pelo t\u00EDtulo");
		textField_1.setBounds(283, 101, 220, 20);
		panel.add(textField_1);
		textField_1.setColumns(50);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(TabAddConta.class.getResource("/imagens/busca.png")));
		btnNewButton.setBounds(514, 79, 52, 42);
		panel.add(btnNewButton);
		
		JLabel notFound = new JLabel("Nenhum resultado encontrado!");
		notFound.setHorizontalAlignment(SwingConstants.CENTER);
		notFound.setForeground(Color.RED);
		notFound.setFont(new Font("Tahoma", Font.BOLD, 12));
		notFound.setBounds(283, 132, 220, 14);
		notFound.setVisible(false);
		panel.add(notFound);
		
		JTable table = new JTable();
		table.setBounds(69, 174, 661, 266);
		table.setBackground(new Color(255, 255, 255, 125));
		panel.add(table);
		
		JButton add = new JButton("");
		add.setIcon(new ImageIcon(TabAddConta.class.getResource("/imagens/submitt.png")));
		add.setBounds(616, 467, 52, 42);
		panel.add(add);
		
		JButton clear = new JButton("");
		clear.setIcon(new ImageIcon(TabAddConta.class.getResource("/imagens/reset.png")));
		clear.setBounds(678, 467, 52, 42);
		panel.add(clear);
		
		//imagem de fundo
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(TabAddCatPlat.class.getResource("/imagens/background.png")));
		background.setBounds(0, 0, 779, 553);
		panel.add(background);
	}

}
