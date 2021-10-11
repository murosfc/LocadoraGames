package manipularDB;

import objetos.CategoriaJogo;

public class DBCategoriaJogo extends Conexao {	
	
	public void inserirDB(CategoriaJogo ObjCatJogo) {
		String inserirSQLQuery = "INSERT INTO categoriajogo (idJogo, idCategoria) VALUES ("+ObjCatJogo.getIdJogo()+","+ObjCatJogo.getIdCategoria()+")";
		System.out.println(inserirSQLQuery);
		super.inserirBD("categoriajogo", inserirSQLQuery);
	}
	

}
