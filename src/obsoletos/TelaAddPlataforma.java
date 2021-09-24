package obsoletos;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import objetos.Plataforma;

import javax.swing.JButton;

public class TelaAddPlataforma {	
	
	public TelaAddPlataforma(JInternalFrame frmAdicionarPlataforma) {		
		
		JLabel lblNewLabel = new JLabel("Plataforma");
		lblNewLabel.setBounds(10, 11, 70, 14);
		frmAdicionarPlataforma.getContentPane().add(lblNewLabel);
		
		JTextField textField = new JTextField();
		textField.setBounds(80, 8, 158, 20);
		frmAdicionarPlataforma.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton add = new JButton("Adicionar");
		add.setBounds(250, 7, 89, 23);
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Plataforma ObjPlat = new Plataforma(textField.getText());
				System.out.println("Conteúdo da caixa "+textField.getText());
				ObjPlat.incluirDB();
			}
		});
		
		frmAdicionarPlataforma.getContentPane().add(add);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.setBounds(350, 7, 89, 23);
		cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmAdicionarPlataforma.dispose();
				
			}			
		});
		frmAdicionarPlataforma.getContentPane().add(cancelar);
		
		frmAdicionarPlataforma.setVisible(true);
		frmAdicionarPlataforma.repaint();	
	}
}
