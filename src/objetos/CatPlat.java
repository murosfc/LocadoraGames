package objetos;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import manipularDB.DBCatPlat;

public class CatPlat {
	private int id =0;
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
	
	public int getId(String tipo)
	{
		this.id = AtribRefDBCatPlat.getId(this, tipo);
		return this.id;
	}
	
	public void incluirDB(String tipo)
	{
		System.out.println("A "+ tipo + " " + nome + " será incluida no BD");
		if (nome.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Digite o nome da "+tipo+" antes de submeter");
		}		
		else {
			AtribRefDBCatPlat.incluirDB(this.getNome(), tipo);
		}
	}
	
	public void preecheTabelaCatPlat(DefaultTableModel tabela, String tipo)
	{
		AtribRefDBCatPlat.preecheTabelaCatPlat(tabela, tipo);
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
	
	public int quantidadeCatPlatCadastrada(String tipo) {
		return AtribRefDBCatPlat.quantidadeCatPlatCadastrada(tipo);
	}
	
	public void atualizarCatPlat(String tipo)
	{
		AtribRefDBCatPlat.atualizarCatPlat(this.id, this.nome, tipo);
	}
	
}
