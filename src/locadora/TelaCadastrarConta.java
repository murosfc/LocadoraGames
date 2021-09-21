package locadora;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaCadastrarConta {

	private JFrame frmCadastrarNovaConta;
	private JTextField email;
	private JTextField senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarConta window = new TelaCadastrarConta();
					window.frmCadastrarNovaConta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastrarConta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastrarNovaConta = new JFrame();
		frmCadastrarNovaConta.setTitle("Cadastrar nova conta de aluguel");
		frmCadastrarNovaConta.setBounds(100, 100, 450, 130);
		frmCadastrarNovaConta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastrarNovaConta.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("e-mail:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		frmCadastrarNovaConta.getContentPane().add(lblNewLabel);
		
		email = new JTextField();
		email.setToolTipText("Digite o e-mail da conta");
		email.setBounds(49, 8, 146, 20);
		frmCadastrarNovaConta.getContentPane().add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("senha:");
		lblNewLabel_1.setBounds(217, 11, 46, 14);
		frmCadastrarNovaConta.getContentPane().add(lblNewLabel_1);
		
		senha = new JTextField();
		senha.setToolTipText("Digite a senha da conta");
		senha.setBounds(256, 8, 151, 20);
		frmCadastrarNovaConta.getContentPane().add(senha);
		senha.setColumns(10);
		
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.setBounds(106, 46, 89, 23);
		frmCadastrarNovaConta.getContentPane().add(cadastrar);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.setBounds(227, 46, 89, 23);
		frmCadastrarNovaConta.getContentPane().add(cancelar);
	}
}
