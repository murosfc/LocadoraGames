package locadora;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaAddCategoria {

	private JFrame frmAdicionarCategoria;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAddCategoria window = new TelaAddCategoria();
					window.frmAdicionarCategoria.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaAddCategoria() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdicionarCategoria = new JFrame();
		frmAdicionarCategoria.setTitle("Adicionar Categoria");
		frmAdicionarCategoria.setBounds(100, 100, 450, 90);
		frmAdicionarCategoria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdicionarCategoria.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Categoria:");
		lblNewLabel.setToolTipText("Digite a categoria para adicionar ao Banco de Dados");
		lblNewLabel.setBounds(10, 11, 55, 14);
		frmAdicionarCategoria.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(63, 8, 163, 20);
		frmAdicionarCategoria.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton add = new JButton("Adicionar");
		add.setBounds(236, 7, 89, 23);
		frmAdicionarCategoria.getContentPane().add(add);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.setBounds(335, 7, 89, 23);
		frmAdicionarCategoria.getContentPane().add(cancelar);
	}

}
