package telas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JFormattedTextField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.toedter.calendar.JDateChooser;

import manipularDB.DBAluguel;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Toolkit;

public class JanelaFaturamento {

	private JFrame frmRelatrioDeVendas;	
	private JTable table;
	private JTextField TextBoxTotalVendas;

	public JanelaFaturamento() {
		frmRelatrioDeVendas = new JFrame();
		frmRelatrioDeVendas.setIconImage(Toolkit.getDefaultToolkit().getImage(JanelaFaturamento.class.getResource("/imagens/logo.png")));
		frmRelatrioDeVendas.setTitle("Relatório de vendas");
		frmRelatrioDeVendas.setBounds(100, 100, 719, 297);
		frmRelatrioDeVendas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel painel = new JPanel();
		painel.setLayout(null);	
		frmRelatrioDeVendas.getContentPane().add(painel);		
		
		JDateChooser dtFinal = new JDateChooser("yyyy/MM/dd", "##/##/####", '_');		
		dtFinal.setDate(new Date());
		dtFinal.setBounds(189, 17, 100, 20);				
		painel.add(dtFinal);
		
		JLabel lblNewLabel = new JLabel("De");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 23, 29, 14);
		painel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("at\u00E9");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(147, 23, 43, 14);
		painel.add(lblNewLabel_1);
		
		JDateChooser dtInicial = new JDateChooser("yyyy/MM/dd", "##/##/####", '_');		
		dtInicial.setDate(new Date());
		dtInicial.setBounds(49, 17, 100, 20);					
		painel.add(dtInicial);		
		
		DefaultTableModel DefTab = new DefaultTableModel(new String[]{"pedido", "cliente", "conta", "data inicio", "data fim", "funcionário", "valor" },0);
		table = new JTable(DefTab);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(10, 61, 683, 186);
		scroll.getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);
		painel.add(scroll);
		scroll.setVisible(false);
		
		JLabel LabelTotalVendas = new JLabel("Total de vendas no período");
		LabelTotalVendas.setFont(new Font("Tahoma", Font.BOLD, 11));
		LabelTotalVendas.setBounds(414, 23, 168, 14);
		LabelTotalVendas.setVisible(false);
		painel.add(LabelTotalVendas);
		
		TextBoxTotalVendas = new JTextField();
		TextBoxTotalVendas.setBounds(573, 17, 120, 20);
		painel.add(TextBoxTotalVendas);
		TextBoxTotalVendas.setVisible(false);
		TextBoxTotalVendas.setColumns(10);
		
		JButton gerarRelatorio = new JButton("Gerar Relatório");
		gerarRelatorio.setBounds(299, 17, 105, 23);
		gerarRelatorio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				if (dtFinal.getDate().compareTo(dtInicial.getDate()) >=0 )
				{
					DefTab.setNumRows(0);
					String fim = df.format(dtFinal.getDate());
					String inicio = df.format(dtInicial.getDate());
					DBAluguel OjbAluguel = new DBAluguel();
					TextBoxTotalVendas.setText("R$ "+ String.format("%.2f",OjbAluguel.relatorioVendas(inicio, fim, DefTab)));
					scroll.setVisible(true);
					LabelTotalVendas.setVisible(true);
					TextBoxTotalVendas.setVisible(true);
				}
			}});
		painel.add(gerarRelatorio);		
		
		frmRelatrioDeVendas.setVisible(true);
		frmRelatrioDeVendas.repaint();		
	}
}
