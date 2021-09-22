package locadora;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.UIManager;

public class Telaprincipal {

	private JFrame frmGerenciadorDeLocadora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Telaprincipal window = new Telaprincipal();
					window.frmGerenciadorDeLocadora.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Telaprincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGerenciadorDeLocadora = new JFrame();
		frmGerenciadorDeLocadora.setTitle("Gerenciador de Locadora de games digitais");
		frmGerenciadorDeLocadora.setBounds(100, 100, 600, 400);
		frmGerenciadorDeLocadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGerenciadorDeLocadora.getContentPane().setLayout(null);
		
		// Tela para cadastro de Jogos
		JInternalFrame cadastrojogos = new JInternalFrame("Cadastrar Jogos");
		cadastrojogos.setClosable(true);
		cadastrojogos.setBounds(10, 33, 564, 175);
		frmGerenciadorDeLocadora.getContentPane().add(cadastrojogos);
		cadastrojogos.getContentPane().setLayout(null);
		
		//Tela para adicionar Categoria
		JInternalFrame addcategoria = new JInternalFrame("Adicionar Categoria");
		addcategoria.setClosable(true);
		addcategoria.setBounds(10, 33, 564, 120);
		frmGerenciadorDeLocadora.getContentPane().add(addcategoria);
		addcategoria.getContentPane().setLayout(null);
		
		//Menu
		JMenuBar mainmenu = new JMenuBar();
		mainmenu.setBounds(0, 0, 137, 22);
		frmGerenciadorDeLocadora.getContentPane().add(mainmenu);
		
		JMenu iniciar = new JMenu("Iniciar");
		mainmenu.add(iniciar);
		
		JMenuItem jogos = new JMenuItem("Cadastrar jogos");
		iniciar.add(jogos);
		jogos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {						
				TelaCadastroJogo ObjTela = new TelaCadastroJogo(cadastrojogos);				
				
		}});	
		
		JMenuItem plataforma = new JMenuItem("Adicionar plataforma");
		iniciar.add(plataforma);
		
		JMenuItem categoria = new JMenuItem("Adicionar categoria");
		iniciar.add(categoria);
		categoria.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaAddCategoria ObjTela = new TelaAddCategoria(addcategoria);					
			}});

		JMenuItem conta = new JMenuItem("Cadastrar conta com jogos");
		iniciar.add(conta);
		
		JMenuItem funcionario = new JMenuItem("Cadastrar funcionário");
		iniciar.add(funcionario);
		
	
		
		
		
	}	
	public void CadastroJogos()	{
		
		JTextField sku;
		JTextField titulo;
		JTextField valor;
		sku = new JTextField();
		sku.setBounds(36, 31, 86, 20);
		frmGerenciadorDeLocadora.getContentPane().add(sku);
		sku.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("SKU:");
		lblNewLabel.setBounds(10, 34, 46, 14);
		frmGerenciadorDeLocadora.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EDtulo:");
		lblNewLabel_1.setBounds(140, 34, 37, 14);
		frmGerenciadorDeLocadora.getContentPane().add(lblNewLabel_1);
		
		titulo = new JTextField();
		titulo.setBounds(177, 31, 246, 20);
		frmGerenciadorDeLocadora.getContentPane().add(titulo);
		titulo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Valor:");
		lblNewLabel_2.setBounds(10, 72, 29, 14);
		frmGerenciadorDeLocadora.getContentPane().add(lblNewLabel_2);
		
		valor = new JTextField();
		valor.setBounds(49, 69, 76, 20);
		frmGerenciadorDeLocadora.getContentPane().add(valor);
		valor.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Plataforma:");
		lblNewLabel_3.setBounds(132, 72, 61, 14);
		frmGerenciadorDeLocadora.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Categoria:");
		lblNewLabel_4.setBounds(290, 72, 55, 14);
		frmGerenciadorDeLocadora.getContentPane().add(lblNewLabel_4);
		
		JList categoria = new JList();
		categoria.setBounds(344, 51, 1, 1);
		frmGerenciadorDeLocadora.getContentPane().add(categoria);
		
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cadastrar.setBounds(119, 107, 101, 23);
		frmGerenciadorDeLocadora.getContentPane().add(cadastrar);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.setBounds(230, 107, 101, 23);
		cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frmGerenciadorDeLocadora.dispose();				
			}			
		});
		
		frmGerenciadorDeLocadora.getContentPane().add(cancelar);
		
		JComboBox plataforma = new JComboBox();
		plataforma.setBounds(197, 68, 88, 22);
		frmGerenciadorDeLocadora.getContentPane().add(plataforma);
		
		JList list = new JList();
		list.setVisibleRowCount(4);
		list.setBounds(354, 85, 1, 1);
		frmGerenciadorDeLocadora.getContentPane().add(list);
		
		frmGerenciadorDeLocadora.setVisible(true);
	}
}
