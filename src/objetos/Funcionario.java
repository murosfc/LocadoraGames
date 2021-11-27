package objetos;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import manipularDB.DBFuncionario;

public class Funcionario {
	private String nickname, email, whatsapp, senha;
	private DBFuncionario AtribRefDBFuncionario;
	private int id = 0;

	public Funcionario() {
		AtribRefDBFuncionario = new DBFuncionario();
		AtribRefDBFuncionario.conectarDB();
	}
	
	public Funcionario (String nick, String mail, String zap, String pass)
	{
		this.nickname = nick;
		this.email=mail;
		this.whatsapp = zap;
		this.senha = pass;
		AtribRefDBFuncionario = new DBFuncionario();
		AtribRefDBFuncionario.conectarDB();		
	}
	
	public Funcionario (int id) {
		this.id = id;
		AtribRefDBFuncionario = new DBFuncionario();
		AtribRefDBFuncionario.conectarDB();	
		getFuncionarioFromId();
		this.senha="";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//Métodos de acesso
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	//demais métodos
	public void incluirDB() {
		AtribRefDBFuncionario.incluirDB(this);
	}

	public void preencherTabelaFuncionarios(DefaultTableModel tabela) {
		AtribRefDBFuncionario.preencherTabelaFuncionarios(tabela);
	}
	
	public void excluirDB(int matricula) {
		AtribRefDBFuncionario.excluirDB(matricula);
	}
	
	public void getFuncionarioFromId() {
		ResultSet result = AtribRefDBFuncionario.getFuncionarioFromId(this.id);
		try {
			result.next();
			this.email = result.getString("email");
			this.nickname = result.getString("nickname");
			this.whatsapp = result.getString("whatsapp");			
		} catch (SQLException e) {
			System.err.println("Não foi possível obter os dados do funcionário através da matricula informada. Erro: "+e.getMessage());
		}
	}
	
	public void atualizarFuncionario() {
		String StringSenha = "";
		if (!this.getSenha().equals("")) {
			StringSenha = ", senha = '"+this.getSenha()+"'";
		}
		String SQLQuery = "UPDATE funcionario SET nickname = '"+this.getNickname()+"', email = '"+this.getEmail()+"', whatsapp = '"+this.getWhatsapp()+"' "+StringSenha+" WHERE matricula="+this.getId();
		System.out.println("Atualizando funcionário: "+SQLQuery);
		AtribRefDBFuncionario.atualizarDB(SQLQuery);
	}
	
}
