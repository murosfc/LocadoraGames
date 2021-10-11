package objetos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import manipularDB.DBConta;

public class Conta {
	private String email;
	private String senha;
	private int idJogo;
	private boolean disponivel;
	private DBConta AtribRefDBConta;
	
	//métodos de acesso	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public int getIdJogo() {
		return idJogo;
	}

	public void setIdJogo(int idJogo) {
		this.idJogo = idJogo;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	//métodos construtores
	public Conta(String mail, String pass, int idJogo)
	{
		email=mail;
		senha=pass;
		this.idJogo=idJogo;
		disponivel=true;
		AtribRefDBConta = new DBConta();
	}
	
	public Conta(String mail, String pass)
	{
		email=mail;
		senha=pass;		
		disponivel=true;
		AtribRefDBConta = new DBConta();
	}

	public Conta() {
		AtribRefDBConta = new DBConta();
	}
	
	//demais métodos	
	public void excluirDB()
	{
		AtribRefDBConta.excluirDB(this.getEmail());
	}	

	public void incluirDB(Object obj, String tipo) {
		AtribRefDBConta.incluirDB(obj);
	}	
	
	public boolean preencheTabelaContaTrocarSenha (String emailProcurado, DefaultTableModel tabela)
	{
		return AtribRefDBConta.preencheTabelaContaTrocarSenha (emailProcurado, tabela);
	}
	
	public void AtualizarSenhaConta(int idConta, String senha) 
	{
		AtribRefDBConta.AtualizarSenhaConta(idConta, senha);
	}
	
	public Object consultarDB(Object obj) {
		return AtribRefDBConta.consultarDB(this);
	}
	
	public void preecheTabelaPrioridades (DefaultTableModel tabela)
	{
		AtribRefDBConta.preecheTabelaPrioridades(tabela);
	}
	
	//Esta função é diferente de conslutar DB pois ela preenche na tela os campos conforme a conta procurada
 	public boolean procurarConta(JLabel notFound, JTextField email, JTextField senha, DefaultTableModel table)
	{
		notFound.setVisible(false);
		if (email.getText().equals(""))
		{
			JOptionPane.showInternalMessageDialog(null, "Digite um e-mail para prosseguir");			
		}
		else if (AtribRefDBConta.consultarDB(this) == null)
			{
				notFound.setVisible(true);
				table.setRowCount(0);
			}
			else
			{
			email.setText(this.getEmail());
			senha.setText(this.getSenha());	
			table.setRowCount(0);
			Jogo ObjJogo = new Jogo();
			ObjJogo.listarDB("jogo", table, this.getIdJogo());
			return true;
			}		
		return false;
	}
	
}
