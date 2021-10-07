package telas;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;

public class TabAddFuncionario {	
	private JTextField nick;
	private JTextField email;
	private JTextField textField;
	private JPasswordField senha;
	private JTable tabela;
	
	public TabAddFuncionario(JTabbedPane tabbedPane) {
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Adicionar Funcionário", null, panel, null);
		panel.setLayout(null);
		
		
		nick = new JTextField();
		nick.setToolTipText("Digite o nickname do funcion\u00E1rio");
		nick.setBounds(108, 30, 200, 20);
		panel.add(nick);
		nick.setColumns(50);
		
		JLabel lblNewLabel = new JLabel("Nickname");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(26, 32, 76, 14);
		panel.add(lblNewLabel);
		
		email = new JTextField();
		email.setToolTipText("Digite o e-mail do funcionario");
		email.setBounds(457, 30, 200, 20);
		panel.add(email);
		email.setColumns(50);
		
		JLabel lblNewLabel_1 = new JLabel("e-mail");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(371, 32, 76, 14);
		panel.add(lblNewLabel_1);
		
		JLabel whatsapp = new JLabel("Whatsapp");
		whatsapp.setFont(new Font("Tahoma", Font.BOLD, 12));
		whatsapp.setHorizontalAlignment(SwingConstants.RIGHT);
		whatsapp.setBounds(14, 85, 88, 14);
		panel.add(whatsapp);
		
		textField = new JTextField();
		textField.setBounds(108, 83, 200, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("senha");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(401, 86, 46, 14);
		panel.add(lblNewLabel_3);		
		
		senha = new JPasswordField();
		senha.setToolTipText("Digite a Senha inicial do funcion\u00E1rio");
		senha.setBounds(457, 83, 200, 20);
		panel.add(senha);		
		
		tabela = new JTable();
		tabela.setBackground(new Color(255, 255, 255, 125));
		tabela.setBounds(101, 228, 556, 298);
		panel.add(tabela);		
		
		JButton add = new JButton("");
		add.setIcon(new ImageIcon(TabAddFuncionario.class.getResource("/imagens/submitt.png")));
		add.setBounds(532, 137, 52, 42);
		panel.add(add);
		
		JButton clear = new JButton("");
		clear.setIcon(new ImageIcon(TabAddFuncionario.class.getResource("/imagens/reset.png")));
		clear.setBounds(605, 137, 52, 42);
		panel.add(clear);	
		
		JLabel lblNewLabel_2 = new JLabel("Funcion\u00E1rios j\u00E1 cadastrados");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(108, 196, 549, 14);
		panel.add(lblNewLabel_2);
		
		//imagem de fundo
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(TabAddCatPlat.class.getResource("/imagens/background.png")));
		background.setBounds(0, 0, 779, 553);
		panel.add(background);
	
	}
}
