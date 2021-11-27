package manipularDB;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import objetos.CategoriaJogo;
import objetos.Jogo;

public class DBCategoriaJogo extends Conexao {	
	
	public void inserirDB(CategoriaJogo ObjCatJogo) {
		String inserirSQLQuery = "INSERT INTO categoriajogo (idJogo, idCategoria) VALUES ("+ObjCatJogo.getIdJogo()+","+ObjCatJogo.getIdCategoria()+")";		
		super.inserirBD("categoriajogo", inserirSQLQuery);
	}
	
	public void inserirVariosDB(CategoriaJogo ObjCatJogo, Jogo ObjJogo) {
		String consultaSQLQuery = "SELECT id FROM jogo WHERE titulo='"+ObjJogo.getTitulo()+"'";
		try {
			ResultSet result = super.consultarDB(consultaSQLQuery);
			int idJogo = 0;
			while (result.next())
			{
				idJogo = Integer.parseInt(result.getString("id"));				
				String inserirSQLQuery = "INSERT INTO categoriajogo (idJogo, idCategoria) VALUES ("+idJogo+","+ObjCatJogo.getIdCategoria()+")";				
				super.inserirBD("categoriajogo", inserirSQLQuery);
			}
		}
		catch (SQLException e) {
			System.err.println("Erro: "+e.getMessage());
		}
		
	}
	
	public void preecheTabelaCatdoJogo (DefaultTableModel tabela, int idJogo) {
		tabela.setNumRows(0);
		String mysqlQuery = "SELECT cj.idCategoria as id, c.nome as categoria FROM categoriajogo cj JOIN categoria c ON cj.idCategoria = c.id WHERE cj.idJogo = "+idJogo;
		int id;
		String categoria;
		try
		{			
			ResultSet result = super.consultarDB(mysqlQuery);
			
			while (result.next())
			{
				id = Integer.parseInt(result.getString("id"));
				categoria = result.getString("categoria");
				tabela.addRow(new Object[] {id, categoria});				
			}
		}catch (SQLException e) {
			System.err.println("Erro: "+e.getMessage());
		}
	}
	
	public void excluirCategoriaDoJogo (Jogo ObjJogo, CategoriaJogo ObjCatJogo) {		
		String mysqlQuery = "SELECT id FROM jogo WHERE titulo ='"+ObjJogo.getTitulo()+"'";
		try
		{
			ResultSet result = super.consultarDB(mysqlQuery);
			result.last(); //move para última linha do resultado
			int quantidade = result.getRow();		
			result.beforeFirst(); //retorna para o primeiro item do result
			
			while (result.next())
			{
				String apagarSQLQuery = "DELETE FROM categoriajogo WHERE idJogo ="+Integer.parseInt(result.getString("id"))+" AND idCategoria="+ObjCatJogo.getIdCategoria();
				if (result.getRow()==quantidade) {					
					super.excluirDB("jogocategoria", apagarSQLQuery);
				}
				else super.excluirDB("none", apagarSQLQuery);
			}
		}
			catch (SQLException e) {
				System.err.println("Erro: "+e.getMessage());
			}
		}	
}
