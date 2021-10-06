package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JList;

public class TabUpdSenha {

	public TabUpdSenha(JTabbedPane tabbedPane) {
		JPanel panel = new JPanel();
		tabbedPane.addTab("Atualizar senha", null, panel, null);
		panel.setLayout(null);
		
		JTextField lblNewLabel_3 = new JTextField();
		lblNewLabel_3.setToolTipText("Digite o e-mail");
		lblNewLabel_3.setBounds(214, 30, 250, 20);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setColumns(50);
		
		JLabel lblNewLabel = new JLabel("Nova senha");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(113, 215, 91, 14);
		panel.add(lblNewLabel);
		
		JTextField textField = new JTextField();
		textField.setToolTipText("Verifique se est\u00E1 correto antes de cadastrar");
		textField.setBounds(214, 213, 250, 20);
		panel.add(textField);
		textField.setColumns(50);
		
		JLabel lblNewLabel_2 = new JLabel("Procurar conta por e-mail");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(46, 32, 221, 14);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(TabAddConta.class.getResource("/imagens/busca.png")));
		btnNewButton.setBounds(487, 22, 52, 42);
		panel.add(btnNewButton);
		
		JLabel notFound = new JLabel("Nenhum resultado encontrado!");
		notFound.setHorizontalAlignment(SwingConstants.CENTER);
		notFound.setForeground(Color.RED);
		notFound.setFont(new Font("Tahoma", Font.BOLD, 12));
		notFound.setBounds(244, 61, 220, 14);
		notFound.setVisible(false);
		panel.add(notFound);
		
		JButton add = new JButton("");
		add.setIcon(new ImageIcon(TabAddConta.class.getResource("/imagens/submitt.png")));
		add.setBounds(344, 265, 52, 42);
		panel.add(add);
		
		JButton clear = new JButton("");
		clear.setIcon(new ImageIcon(TabAddConta.class.getResource("/imagens/reset.png")));
		clear.setBounds(406, 265, 52, 42);
		panel.add(clear);		
		
		JList list = new JList();
		list.setBounds(46, 109, 698, 77);
		panel.add(list);
		list.setBackground(new Color(255, 255, 255, 125));
		
		JLabel found = new JLabel("Selecione a conta abaixo e cadastre a nova senha");
		found.setHorizontalAlignment(SwingConstants.CENTER);
		found.setForeground(Color.BLUE);
		found.setFont(new Font("Tahoma", Font.BOLD, 12));
		found.setVisible(false);
		found.setBounds(46, 86, 698, 14);
		
		panel.add(found);
		
		//imagem de fundo
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(TabAddCatPlat.class.getResource("/imagens/background.png")));
		background.setBounds(0, 0, 779, 553);
		panel.add(background);
	}
}


