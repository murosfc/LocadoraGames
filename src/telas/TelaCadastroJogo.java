package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class TelaCadastroJogo {			
	
 public TelaCadastroJogo(JInternalFrame frmGerenciadorDeLocadora)	{		
		
	 	JTextField sku = new JTextField();
		sku.setBounds(40, 31, 86, 20);
		frmGerenciadorDeLocadora.getContentPane().add(sku);
		sku.setColumns(10);
		
		JLabel  lblNewLabel = new JLabel("SKU:");
		lblNewLabel.setBounds(10, 34, 46, 14);
		frmGerenciadorDeLocadora.getContentPane().add(lblNewLabel);
		
		JLabel  lblNewLabel_1 = new JLabel("T\u00EDtulo:");
		lblNewLabel_1.setBounds(140, 34, 37, 14);
		frmGerenciadorDeLocadora.getContentPane().add(lblNewLabel_1);
		
		JTextField titulo = new JTextField();
		titulo.setBounds(177, 31, 246, 20);
		frmGerenciadorDeLocadora.getContentPane().add(titulo);
		titulo.setColumns(10);
		
		JLabel  lblNewLabel_2 = new JLabel("Valor:");
		lblNewLabel_2.setBounds(10, 72, 46, 14);
		frmGerenciadorDeLocadora.getContentPane().add(lblNewLabel_2);
		
		JTextField valor = new JTextField();
		valor.setBounds(54, 69, 76, 20);
		frmGerenciadorDeLocadora.getContentPane().add(valor);
		valor.setColumns(10);	
		
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cadastrar.setBounds(166, 68, 101, 23);
		frmGerenciadorDeLocadora.getContentPane().add(cadastrar);
		
		JButton cancelar = new JButton("Cancelar");			
		cancelar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {				
				//RemoveContent(frmGerenciadorDeLocadora);
				frmGerenciadorDeLocadora.dispose();				
			}			
		});
		cancelar.setBounds(299, 68, 101, 23);
		frmGerenciadorDeLocadora.getContentPane().add(cancelar);		
		
		frmGerenciadorDeLocadora.setVisible(true);
		frmGerenciadorDeLocadora.repaint();	
	} 

}
