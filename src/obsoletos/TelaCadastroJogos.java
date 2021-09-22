package obsoletos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class TelaCadastroJogos{

	private JFrame frmCadastroDeJogos;
	private JTextField sku;
	private JTextField titulo;
	private JTextField valor;

	
	 // Launch the application.	 	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroJogos window = new TelaCadastroJogos();
					window.frmCadastroDeJogos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} 

	/**
	 * Create the application.
	 */
	public TelaCadastroJogos() {
		initialize();
	}


	 /* Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeJogos = new JFrame();
		frmCadastroDeJogos.setTitle("Cadastro de Jogos");
		frmCadastroDeJogos.setResizable(false);
		frmCadastroDeJogos.setBounds(100, 100, 508, 160);
		frmCadastroDeJogos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroDeJogos.getContentPane().setLayout(null);
		
		sku = new JTextField();
		sku.setBounds(44, 11, 86, 20);
		frmCadastroDeJogos.getContentPane().add(sku);
		sku.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("SKU:");
		lblNewLabel.setBounds(10, 14, 46, 14);
		frmCadastroDeJogos.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EDtulo:");
		lblNewLabel_1.setBounds(156, 14, 55, 14);
		frmCadastroDeJogos.getContentPane().add(lblNewLabel_1);
		
		titulo = new JTextField();
		titulo.setBounds(205, 11, 246, 20);
		frmCadastroDeJogos.getContentPane().add(titulo);
		titulo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Valor:");
		lblNewLabel_2.setBounds(10, 52, 46, 14);
		frmCadastroDeJogos.getContentPane().add(lblNewLabel_2);
		
		valor = new JTextField();
		valor.setBounds(54, 49, 76, 20);
		frmCadastroDeJogos.getContentPane().add(valor);
		valor.setColumns(10);
		
		String[] myStringArray;
		myStringArray = new String[]{"jogo","tela","luta","Aventura"};
		
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cadastrar.setBounds(166, 48, 101, 23);
		frmCadastroDeJogos.getContentPane().add(cadastrar);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.setBounds(299, 48, 101, 23);
		cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frmCadastroDeJogos.dispose();				
			}			
		});
		
		frmCadastroDeJogos.getContentPane().add(cancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		
		frmCadastroDeJogos.setVisible(true);
	}
}
