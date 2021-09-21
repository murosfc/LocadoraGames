package locadora;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class TelaCadastroJogos{

	private JFrame frmCadastroDeJogos;
	private JTextField sku;
	private JTextField titulo;
	private JTextField valor;

	/**
	 * Launch the application.
	 * 	 
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
	} */

	/**
	 * Create the application.
	 */
	public TelaCadastroJogos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeJogos = new JFrame();
		frmCadastroDeJogos.setTitle("Cadastro de Jogos");
		frmCadastroDeJogos.setResizable(false);
		frmCadastroDeJogos.setBounds(100, 100, 450, 160);
		frmCadastroDeJogos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeJogos.getContentPane().setLayout(null);
		
		sku = new JTextField();
		sku.setBounds(36, 11, 86, 20);
		frmCadastroDeJogos.getContentPane().add(sku);
		sku.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("SKU:");
		lblNewLabel.setBounds(10, 14, 46, 14);
		frmCadastroDeJogos.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EDtulo:");
		lblNewLabel_1.setBounds(140, 14, 37, 14);
		frmCadastroDeJogos.getContentPane().add(lblNewLabel_1);
		
		titulo = new JTextField();
		titulo.setBounds(177, 11, 246, 20);
		frmCadastroDeJogos.getContentPane().add(titulo);
		titulo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Valor:");
		lblNewLabel_2.setBounds(10, 52, 29, 14);
		frmCadastroDeJogos.getContentPane().add(lblNewLabel_2);
		
		valor = new JTextField();
		valor.setBounds(46, 49, 76, 20);
		frmCadastroDeJogos.getContentPane().add(valor);
		valor.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Plataforma:");
		lblNewLabel_3.setBounds(132, 52, 61, 14);
		frmCadastroDeJogos.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Categoria:");
		lblNewLabel_4.setBounds(290, 52, 55, 14);
		frmCadastroDeJogos.getContentPane().add(lblNewLabel_4);
		
		JList categoria = new JList();
		categoria.setBounds(344, 51, 1, 1);
		frmCadastroDeJogos.getContentPane().add(categoria);
		
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cadastrar.setBounds(119, 87, 101, 23);
		frmCadastroDeJogos.getContentPane().add(cadastrar);
		
		JButton limpar = new JButton("Limpar dados");
		limpar.setBounds(230, 87, 101, 23);
		frmCadastroDeJogos.getContentPane().add(limpar);
		
		JComboBox plataforma = new JComboBox();
		plataforma.setBounds(197, 48, 88, 22);
		frmCadastroDeJogos.getContentPane().add(plataforma);
		
		JList list = new JList();
		list.setVisibleRowCount(4);
		list.setBounds(354, 65, 1, 1);
		frmCadastroDeJogos.getContentPane().add(list);
	}
}
