package telas;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
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

import objetos.PasswordHash;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JSlider;
import javax.swing.JToolBar;


public class Telaprincipal extends JFrame{
	
	private static final long serialVersionUID = 5786835960596750539L;

	private JFrame frmGerenciadorDeLocadora;
	private static String imgLink ="D:\\Documentos\\Escola\\Sistemas de Informa\u00E7\u00E3o\\Quarto per\u00EDodo\\Programa\u00E7\u00E3o Orientada a Objetos\\Locadora\\imagens\\wallpaper.jpg";
	private JTextField textField;
	private static JTabbedPane tabbedPane;
	
	public Telaprincipal(boolean setVisible) {
		this.tabbedPane.setVisible(setVisible);		
	}
	
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
		frmGerenciadorDeLocadora.setBounds(100, 100, 800, 600);
		frmGerenciadorDeLocadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGerenciadorDeLocadora.getContentPane().setLayout(null);
		frmGerenciadorDeLocadora.setResizable(false);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 784, 561);
		frmGerenciadorDeLocadora.getContentPane().add(tabbedPane);
		
		new TabAddJogo(tabbedPane);
		new TabAddCatPlat (tabbedPane);
		new TabAddFuncionario (tabbedPane);	
		new TabAddConta (tabbedPane);
		new TabUpdSenha (tabbedPane);	
		

	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public static void setTabbedPane(boolean status) {
		tabbedPane.setVisible(status);
	}	
}