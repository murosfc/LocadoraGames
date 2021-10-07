package objetos;

import javax.swing.JOptionPane;

import manipularDB.DBCatPlat;

public class CatPlat {
	private String nome;
	
	//atributo de referencia para DBCatPlat
	private DBCatPlat AtribRefDBCatPlat;
	
	public CatPlat(String name)
	{
		this.nome=name;
		AtribRefDBCatPlat = new DBCatPlat();		
		AtribRefDBCatPlat.conectarDB();
	}
	
	public CatPlat()
	{	
		AtribRefDBCatPlat = new DBCatPlat();		
		AtribRefDBCatPlat.conectarDB();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void incluirDB(String tipo)
	{
		System.out.println("A "+ tipo + " " + nome + " será incluida no BD");
		if (nome.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Digite o nome da "+tipo+" antes de submeter");
		}
		else if (AtribRefDBCatPlat.consultarDB(this, tipo) != null)
		{
			JOptionPane.showMessageDialog(null, "A " + tipo + " " + nome + " já está cadastrada");			
		}
		else {
			AtribRefDBCatPlat.incluirDB(this, tipo);
		}
	}
	public String[] listarDB(String tipo)
	{
		String[] lista = AtribRefDBCatPlat.listarDB(tipo);
		return lista;
	}
	
	public void exluirDB(int id, String tipo)
	{
		if (id >=1)
		{
			AtribRefDBCatPlat.excluirDB(id, tipo);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Selecione a " + tipo + " para exluir do BD");
		}
	}
	
}
