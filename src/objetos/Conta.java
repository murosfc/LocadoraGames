package objetos;

import java.util.Optional;

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
	public Object consultarDB()
	{
		return AtribRefDBConta.consultarDB(this, "conta");
	}
	
	public void excluirDB(String tipo)
	{
		Conta ObjTempConta = (Conta) AtribRefDBConta.consultarDB(this, tipo);
		AtribRefDBConta.excluirDB(ObjTempConta.getIdJogo(), tipo);
	}
	
	public void incluirDB(Object obj, String tipo) {
		AtribRefDBConta.incluirDB(obj, tipo);
	}
	
	
}
