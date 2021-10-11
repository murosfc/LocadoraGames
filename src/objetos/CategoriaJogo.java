package objetos;

import manipularDB.DBCategoriaJogo;

public class CategoriaJogo {
	private int idCategoria, idJogo;
	
	private DBCategoriaJogo AtribRefBDCategoriaJogo;

	public CategoriaJogo(int idCategoria, int idJogo) {
		super();
		this.idCategoria = idCategoria;
		this.idJogo = idJogo;
		AtribRefBDCategoriaJogo = new DBCategoriaJogo();
		AtribRefBDCategoriaJogo.conectarDB();
	}
	
	public CategoriaJogo() {
		AtribRefBDCategoriaJogo = new DBCategoriaJogo();
		AtribRefBDCategoriaJogo.conectarDB();
	}
	
	public void inserirDB() {
		AtribRefBDCategoriaJogo.inserirDB(this);
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public int getIdJogo() {
		return idJogo;
	}

	public void setIdJogo(int idJogo) {
		this.idJogo = idJogo;
	}

}
