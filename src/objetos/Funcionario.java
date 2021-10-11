package objetos;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import manipularDB.DBFuncionario;

public class Funcionario {
	private String nickname, email, whatsapp, senha;
	private DBFuncionario AtribRefDBFuncionario;

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
	
}
