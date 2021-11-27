package objetos;

import javax.swing.JOptionPane;

import manipularDB.DBPlataforma;

public class Plataforma {
	private String nome;
	
	//atributo de referencia para DBPlataforma
	private DBPlataforma AtribRefDBPlat;
	
	public Plataforma(String name)
	{
		this.nome=name;
		AtribRefDBPlat = new DBPlataforma();		
		AtribRefDBPlat.conectarDB();
	}
	
	public Plataforma()
	{	
		AtribRefDBPlat = new DBPlataforma();		
		AtribRefDBPlat.conectarDB();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void incluirDB()
	{
		System.out.println("A Plataforma "+nome+" será incluida no BD");
		if (nome.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Digite o nome da plataforma antes de submeter");
		}
		else if (AtribRefDBPlat.consultarDB(this) != null)
		{
			JOptionPane.showMessageDialog(null, "A Plataforma "+nome+" já está cadastrada");
			System.out.println("A Plataforma "+nome+" já está cadastrada");
		}
		else {
			AtribRefDBPlat.incluirDB(this);
		}
	}
	public String[] listarDB()
	{
		String[] lista = AtribRefDBPlat.listarDB();
		return lista;
	}
	
	public void exluirDB(int id)
	{
		if (id >=1)
		{
			AtribRefDBPlat.excluirDB(id);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Selecione um item para exluir do DB");
		}
	}
	
}
