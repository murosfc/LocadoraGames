package telas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaAddCategoria {
	
	public TelaAddCategoria(JInternalFrame frmAdicionarCategoria) {
		
		JLabel lblNewLabel = new JLabel("Categoria:");
		lblNewLabel.setToolTipText("Digite a categoria para adicionar ao Banco de Dados");
		lblNewLabel.setBounds(10, 11, 55, 14);
		frmAdicionarCategoria.getContentPane().add(lblNewLabel);
		
		JTextField textField = new JTextField();
		textField.setBounds(63, 8, 163, 20);
		frmAdicionarCategoria.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton add = new JButton("Adicionar");
		add.setBounds(236, 7, 89, 23);
		frmAdicionarCategoria.getContentPane().add(add);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmAdicionarCategoria.dispose();
				
			}});
		
		cancelar.setBounds(335, 7, 89, 23);
		frmAdicionarCategoria.getContentPane().add(cancelar);
		
		frmAdicionarCategoria.setVisible(true);
		frmAdicionarCategoria.repaint();	
	}

}
