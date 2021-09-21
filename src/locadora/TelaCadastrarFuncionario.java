package locadora;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaCadastrarFuncionario {

	private JFrame frmCadastroDeFuncionrio;
	private JTextField nick;
	private JTextField email;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarFuncionario window = new TelaCadastrarFuncionario();
					window.frmCadastroDeFuncionrio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastrarFuncionario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeFuncionrio = new JFrame();
		frmCadastroDeFuncionrio.setTitle("Cadastro de Funcion\u00E1rio");
		frmCadastroDeFuncionrio.setBounds(100, 100, 450, 120);
		frmCadastroDeFuncionrio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeFuncionrio.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nick:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		frmCadastroDeFuncionrio.getContentPane().add(lblNewLabel);
		
		nick = new JTextField();
		nick.setToolTipText("Digite o nick do funcion\u00E1rio");
		nick.setBounds(40, 8, 139, 20);
		frmCadastroDeFuncionrio.getContentPane().add(nick);
		nick.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("e-mail:");
		lblNewLabel_1.setBounds(189, 11, 46, 14);
		frmCadastroDeFuncionrio.getContentPane().add(lblNewLabel_1);
		
		email = new JTextField();
		email.setToolTipText("Digite o e-mail do funcion\u00E1rio");
		email.setBounds(230, 8, 194, 20);
		frmCadastroDeFuncionrio.getContentPane().add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Whatsapp:");
		lblNewLabel_2.setBounds(10, 50, 60, 14);
		frmCadastroDeFuncionrio.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setToolTipText("Digite o n\u00FAmero do Whatsapp do funcion\u00E1rio");
		textField.setBounds(66, 47, 113, 20);
		frmCadastroDeFuncionrio.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.setBounds(199, 46, 89, 23);
		frmCadastroDeFuncionrio.getContentPane().add(cadastrar);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.setBounds(298, 46, 89, 23);
		frmCadastroDeFuncionrio.getContentPane().add(cancelar);
	}

}
