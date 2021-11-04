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
		
		JLabel versao = new JLabel("Versão "+versionAndDate[0]);
		versao.setFont(new Font("Tahoma", Font.PLAIN, 10));
		versao.setBounds(10, 517, 166, 14);
		panel.add(versao);		
		
		JLabel lastUpdade = new JLabel("Última atualização "+versionAndDate[1]);
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
		addRemov.add(Jogos);
		
		JMenuItem addRemovJogos = new JMenuItem("Adicionar/Remover");
		addRemovJogos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.removeAll();
				panel.setVisible(false);
				new TabAddJogo(tabbedPane);				
			}});
		Jogos.add(addRemovJogos);
		
		JMenuItem UpdJogos = new JMenuItem("Atualizar");
		Jogos.add(UpdJogos);
		
		JMenu CatPlat = new JMenu("Categorias e Plataformas");		
		addRemov.add(CatPlat);
		
		JMenuItem AddRemovCatPlat = new JMenuItem("Adicionar/Remover");
		AddRemovCatPlat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.removeAll();
				panel.setVisible(false);				
				new TabAddCatPlat(tabbedPane);
			}});
		CatPlat.add(AddRemovCatPlat);
		
		JMenuItem UpdCatPlat = new JMenuItem("Atualizar");
		CatPlat.add(UpdCatPlat);
		
		JMenu Funcionarios = new JMenu("Fucionários");
		addRemov.add(Funcionarios);
		
		JMenuItem AddRemovFunc = new JMenuItem("Adicionar/Remover");
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
		Funcionarios.add(UpdFunc);
		
		JMenu Contas = new JMenu("Contas");
		addRemov.add(Contas);
		
		JMenuItem AddRemovContas = new JMenuItem("Adicionar/Remover");
		AddRemovContas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.removeAll();
				panel.setVisible(false);
				new TabAddConta (tabbedPane);				
			}});
		Contas.add(AddRemovContas);
		
		JMenuItem UpdContas = new JMenuItem("Atualizar");		
		UpdContas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.removeAll();
				panel.setVisible(false);
				new TabUpdConta (tabbedPane);				
			}});
		Contas.add(UpdContas);
		
		JMenuItem UpdSenhas = new JMenuItem("Atualizar Senha");
		UpdSenhas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.removeAll();
				panel.setVisible(false);				
				new TabUpdSenha (tabbedPane);
			}});		
		Contas.add(UpdSenhas);
		
		JMenuItem showAll = new JMenuItem("Mostrar todos");
		showAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.removeAll();
				panel.setVisible(false);
				new TabAddJogo(tabbedPane);	
				new TabAddCatPlat (tabbedPane);
				new TabAddFuncionario (tabbedPane);
				new TabAddConta (tabbedPane);
				new TabUpdSenha (tabbedPane);
				new TabUpdConta (tabbedPane);
			}});
		addRemov.add(showAll);
		
		JMenu Relatorios = new JMenu("Relatórios");
		menuBar.add(Relatorios);
		
		JMenuItem receita = new JMenuItem("Aluguéis por período");
		receita.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JanelaFaturamento ObjFat = new JanelaFaturamento();				
			}});
		Relatorios.add(receita);
	}
	
}
