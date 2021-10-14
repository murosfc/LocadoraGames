package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaUpdGame {

	private JFrame frame;
	private JTextField jogoProcurado;
	private JTable table;
	private JTextField resultTitulo;

	public TelaUpdGame(JTabbedPane tabbedPane) {
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 779, 533);		
		panel.setLayout(null);
		
		jogoProcurado = new JTextField();
		jogoProcurado.setBounds(131, 23, 421, 20);
		panel.add(jogoProcurado);
		jogoProcurado.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Procurar jogo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(31, 25, 110, 14);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(TelaUpdGame.class.getResource("/imagens/busca.png")));
		btnNewButton.setBounds(562, 11, 52, 42);
		panel.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(41, 62, 699, 112);
		panel.add(table);
		
		resultTitulo = new JTextField();
		resultTitulo.setBounds(87, 189, 653, 20);
		panel.add(resultTitulo);
		resultTitulo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EDtulo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(31, 191, 46, 14);
		panel.add(lblNewLabel_1);	
		
		
		JButton retornar = new JButton("Retornar");
		retornar.setBounds(651, 499, 89, 23);
		panel.add(retornar);
		retornar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		
				
			}
			
		});
		frame.setVisible(true);
		
		JLabel backgroung = new JLabel("");
		backgroung.setIcon(new ImageIcon(TelaUpdGame.class.getResource("/imagens/background.png")));
		backgroung.setBounds(0, 0, 779, 533);
		panel.add(backgroung);
		
		frame.repaint();
		panel.setVisible(false);
	}
}
