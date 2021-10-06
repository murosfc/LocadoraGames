package obsoletos;

public class Categoria {
	private String nome;
	
	private DBCategoria AtribRefCateg;	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria()
	{
		AtribRefCateg = new DBCategoria();
		AtribRefCateg.conectarDB();
	}
	
	public Categoria (String name)
	{
		nome = name;
		AtribRefCateg = new DBCategoria();
		AtribRefCateg.conectarDB();
	}
}
	
