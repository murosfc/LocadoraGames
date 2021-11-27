package telas;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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

import objetos.Conta;
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
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;


public class TelaInicial extends JFrame{
	private static final String[] versionAndDate = {"1.0","20-Out-2021"};
	
	private static final long serialVersionUID = 5786835960596750539L;

	private JFrame frmGerenciadorDeLocadora;	
	private  JTabbedPane tabbedPane;
	
	private boolean mudaFonte =true;
	
	public TelaInicial(boolean setVisible) {
		this.tabbedPane.setVisible(setVisible);		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial window = new TelaInicial();
					window.frmGerenciadorDeLocadora.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TelaInicial(){
		initialize();
	}
	
	private void initialize() {
		frmGerenciadorDeLocadora = new JFrame();
		frmGerenciadorDeLocadora.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaInicial.class.getResource("/imagens/logo.png")));
		frmGerenciadorDeLocadora.setTitle("Gerenciador de Locadora de games digitais");
		frmGerenciadorDeLocadora.setBounds(100, 100, 795, 630);
		frmGerenciadorDeLocadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGerenciadorDeLocadora.getContentPane().setLayout(null);
		frmGerenciadorDeLocadora.setResizable(false);
		
		//Tela inicial
		JPanel panel = new JPanel();
		panel.setBounds(0, 26, 784, 575);
		frmGerenciadorDeLocadora.getContentPane().add(panel);
		panel.setLayout(null);		
		
		JLabel lblNewLabel_1 = new JLabel("BEM-VINDO");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 40));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 46, 784, 63);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("GERENCIADOR LOCADORA ONGAMES.COM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(7, 361, 753, 50);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Selecione uma opção no menu superior para continuar");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(462, 529, 298, 14);
		panel.add(lblNewLabel_2);
		
		Conta ObjConta = new Conta();
		int qtcontas = ObjConta.quantidadePrioridadesAtualizarSenha();			
		if (qtcontas > 0) {
			String frase ="";
			if (qtcontas==1) {
				frase = "Atenção! Existe "+qtcontas+" conta que precisa ter a senha atualizada!";				
			} else {frase = "Atenção! Existem "+qtcontas+" contas que precisam ter a senha atualizada!";}		
			JLabel warning = new JLabel(frase);
			warning.setHorizontalAlignment(SwingConstants.CENTER);
			warning.setForeground(Color.RED);
			warning.setFont(new Font("Times New Roman", Font.BOLD, 16));
			warning.setBounds(10, 412, 753, 24);
			panel.add(warning);			
			final Runnable updater = new Runnable() {
		        @Override
		        public void run() {
		        	if (mudaFonte) {
		        		warning.setForeground(Color.GRAY);
		        	} else warning.setForeground(Color.RED);		        	
		        	mudaFonte = !mudaFonte;	
		        }
		    };
		    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
		    executorService.scheduleAtFixedRate(new Runnable() {
		        @Override
		        public void run() {
		            SwingUtilities.invokeLater(updater);
		        }
		    }, 1000, 1000, TimeUnit.MILLISECONDS);
		}	
		
		JLabel icone = new JLabel("");
		icone.setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/logo.png")));
		icone.setBounds(347, 100, 84, 115);
		panel.add(icone);
		
		JLabel versao = new JLabel("Vers\u00E3o 1.0.1");
		versao.setFont(new Font("Tahoma", Font.PLAIN, 10));
		versao.setBounds(10, 517, 166, 14);
		panel.add(versao);		
		
		JLabel lastUpdade = new JLabel("\u00DAltima atualiza\u00E7\u00E3o 26-Nov-2021");
		lastUpdade.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lastUpdade.setBounds(10, 539, 166, 14);
		panel.add(lastUpdade);
		
		JLabel backgroundInicial = new JLabel("");
		backgroundInicial.setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/background.png")));
		backgroundInicial.setBounds(0, 0, 800, 575);
		panel.add(backgroundInicial);	
		
		//Abas
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 26, 784, 575);
		frmGerenciadorDeLocadora.getContentPane().add(tabbedPane);
						
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 784, 28);
		frmGerenciadorDeLocadora.getContentPane().add(menuBar);
		
		JMenu addRemov = new JMenu("Ações");
		menuBar.add(addRemov);
		
		JMenu Jogos = new JMenu("Jogos");
		Jogos.setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/MenuGame10x10.png")));
		addRemov.add(Jogos);
		
		JMenuItem addRemovJogos = new JMenuItem("Adicionar");
		addRemovJogos.setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/AddMenu10x10.png")));
		addRemovJogos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.removeAll();
				panel.setVisible(false);
				new TabAddJogo(tabbedPane);				
			}});
		Jogos.add(addRemovJogos);
		
		JMenuItem UpdGame = new JMenuItem("Atualizar");
		UpdGame.setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/MenuUpd10x10.png")));
		UpdGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.removeAll();
				panel.setVisible(false);
				new TabUpdGame(tabbedPane);				
			}});
		Jogos.add(UpdGame);
		
		JMenu CatPlat = new JMenu("Categorias e Plataformas");		
		CatPlat.setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/MenuConsole10x10.png")));
		addRemov.add(CatPlat);
		
		JMenuItem AddRemovCatPlat = new JMenuItem("Adicionar");
		AddRemovCatPlat.setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/AddMenu10x10.png")));
		AddRemovCatPlat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.removeAll();
				panel.setVisible(false);				
				new TabAddCatPlat(tabbedPane);
			}});
		CatPlat.add(AddRemovCatPlat);
		
		JMenuItem UpdCatPlat = new JMenuItem("Atualizar");
		UpdCatPlat.setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/MenuUpd10x10.png")));
		CatPlat.add(UpdCatPlat);
		UpdCatPlat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.removeAll();
				panel.setVisible(false);				
				new TabUpdCatPlat(tabbedPane);				
			}});
		
		JMenu Funcionarios = new JMenu("Fucionários");
		Funcionarios.setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/MenuUser10x10.png")));
		addRemov.add(Funcionarios);
		
		JMenuItem AddRemovFunc = new JMenuItem("Adicionar");
		AddRemovFunc.setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/AddMenu10x10.png")));
		AddRemovFunc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.removeAll();
				panel.setVisible(false);
				new TabAddFuncionario (tabbedPane);
			}
			
		});
		Funcionarios.add(AddRemovFunc);
		
		JMenuItem UpdFunc = new JMenuItem("Atualizar");
		UpdFunc.setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/MenuUpd10x10.png")));
		Funcionarios.add(UpdFunc);
		UpdFunc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.removeAll();
				panel.setVisible(false);
				new TabUpdFuncionario (tabbedPane);				
			}			
		});
		
		JMenu Contas = new JMenu("Contas");
		Contas.setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/ManuMail10x10.png")));
		addRemov.add(Contas);
		
		JMenuItem AddRemovContas = new JMenuItem("Adicionar");
		AddRemovContas.setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/AddMenu10x10.png")));
		AddRemovContas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.removeAll();
				panel.setVisible(false);
				new TabAddConta (tabbedPane);				
			}});
		Contas.add(AddRemovContas);
		
		JMenuItem UpdContas = new JMenuItem("Atualizar");		
		UpdContas.setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/MenuUpd10x10.png")));
		UpdContas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.removeAll();
				panel.setVisible(false);
				new TabUpdConta (tabbedPane);				
			}});
		Contas.add(UpdContas);
		
		JMenuItem UpdSenhas = new JMenuItem("Atualizar Senha");
		UpdSenhas.setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/MenuPassword10x10.png")));
		UpdSenhas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.removeAll();
				panel.setVisible(false);				
				new TabUpdSenha (tabbedPane);
			}});		
		Contas.add(UpdSenhas);
		
		JMenu Relatorios = new JMenu("Relatórios");
		menuBar.add(Relatorios);
		
		JMenuItem receita = new JMenuItem("Aluguéis por período");
		receita.setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/MenuRelatorio10x10.png")));
		receita.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JanelaFaturamento ObjFat = new JanelaFaturamento();				
			}});
		Relatorios.add(receita);
	}
	
}
