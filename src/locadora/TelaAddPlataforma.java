package locadora;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaAddPlataforma {

	private JFrame frmAdicionarPlataforma;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAddPlataforma window = new TelaAddPlataforma();
					window.frmAdicionarPlataforma.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaAddPlataforma() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdicionarPlataforma = new JFrame();
		frmAdicionarPlataforma.setTitle("Adicionar Plataforma");
		frmAdicionarPlataforma.setBounds(100, 100, 450, 90);
		frmAdicionarPlataforma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdicionarPlataforma.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Plataforma");
		lblNewLabel.setBounds(10, 11, 62, 14);
		frmAdicionarPlataforma.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(68, 8, 158, 20);
		frmAdicionarPlataforma.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton add = new JButton("Adicionar");
		add.setBounds(236, 7, 89, 23);
		frmAdicionarPlataforma.getContentPane().add(add);
		
		JButton limpar = new JButton("Cancelar");
		limpar.setBounds(335, 7, 89, 23);
		frmAdicionarPlataforma.getContentPane().add(limpar);
	}
}
