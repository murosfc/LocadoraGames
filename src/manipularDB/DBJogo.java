package manipularDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import objetos.Jogo;

public class DBJogo extends Conexao{
	
	public void incluirDB(Jogo ObjJogo) {
		String incluirSQLQuery = "INSERT into jogo (sku, titulo, valor, imgurl, idPlataforma) VALUES ('"+ObjJogo.getSku()+"','"+ObjJogo.getTitulo()+"','"+ObjJogo.getValor()+
				"','"+ObjJogo.getImgurl()+"','"+ObjJogo.getIdPlat()+"')";
		super.inserirBD("jogo", incluirSQLQuery);
	}
	
	public Object consultarDB(Object obj, String tipo) {
		
		return null;
	}
	
	public boolean listarBD(String tipo, DefaultTableModel tabela, String busca) {
		try
		{
			Statement statement = getConnection().createStatement();
			String mySQLQuery = "SELECT j.id, j.titulo, p.nome as 'plataforma' FROM jogo j LEFT JOIN plataforma p on j.idPlataforma=p.id WHERE j.titulo LIKE '%"+busca+"%'";
			ResultSet result = statement.executeQuery(mySQLQuery);			
			
			if (result.next())
			{				
				int id;
				String titulo, plataforma;
				result.beforeFirst(); //retorna para o inicial do result
				while (result.next())
				{
					id = Integer.parseInt(result.getString("id"));
					titulo = result.getString("titulo");
					plataforma = result.getString("plataforma");
					tabela.addRow(new Object[]{id,titulo, plataforma});
				}
				return true;
			}			
		}
		catch (SQLException e) {
			System.err.println ("Erro ao buscar no BD: "+e.getMessage());				
			}
		return false;			
		}	
	
	public void listarBD(String tipo, DefaultTableModel tabela, int id) {
		try
		{
			Statement statement = getConnection().createStatement();
			String mySQLQuery = "SELECT j.id, j.titulo, p.nome as 'plataforma', j.sku, j.valor, j.imgurl FROM jogo j LEFT JOIN plataforma p on j.idPlataforma=p.id WHERE j.id="+id+"";
			ResultSet result = statement.executeQuery(mySQLQuery);			
			if (result.next())
			{				
				int idJogo;
				String titulo, plataforma;
				result.beforeFirst(); //retorna para o inicial do result
				while (result.next())
				{
					idJogo = Integer.parseInt(result.getString("id"));
					titulo = result.getString("titulo");
					plataforma = result.getString("plataforma");				
					tabela.addRow(new Object[]{id,titulo, plataforma});
				}				
			}			
		}
		catch (SQLException e) {
			System.err.println ("Erro ao buscar no BD: "+e.getMessage());				
			}				
		}	
	
	public void excluirDB(int id, String tipo) {
		
		
	}
	
	public int getId(Jogo ObjJogo) {
		String consultaSQLQuery = "SELECT id from jogo where titulo = '"+ObjJogo.getTitulo()+"' AND sku = '"+ObjJogo.getSku()+"'";		
		int id =0;
		try
		{
			ResultSet result = super.consultarDB(consultaSQLQuery);
			if (result.next()) {				
				id = Integer.parseInt(result.getString("id"));
				return id;
			}			
		} catch (SQLException e) {
			System.err.println("Erro: "+e.getMessage());
		}
		return id;
	}
	
	public void getJogoFromDB(Jogo ObjJogo)
	{
		String consultaSQLQuery = "SELECT * from jogo where id = "+ObjJogo.getIdJogo()+"";
		try
		{
			ResultSet result = super.consultarDB(consultaSQLQuery);
			if (result.next()) {
				ObjJogo.setIdJogo(Integer.parseInt(result.getString("id")));
				ObjJogo.setSku(result.getString("sku"));
				ObjJogo.setTitulo(result.getString("titulo"));
				ObjJogo.setValor(Float.parseFloat(result.getString("valor")));
				ObjJogo.setImgurl(result.getString("imgurl"));
				ObjJogo.setIdPlat(Integer.parseInt(result.getString("idPlataforma")));				
			}	
		}
		catch (SQLException e) {
			System.err.println("Erro: "+e.getMessage());
		}
	}
	public void atualizarDB(Jogo ObjJogo) {
		String atualizarSQLQuery = "UPDATE IGNORE jogo SET sku='"+ObjJogo.getSku()+"', titulo='"+ObjJogo.getTitulo()+"', valor="+ObjJogo.getValor()+", imgurl='"+ObjJogo.getImgurl()+"', idplataforma="+ObjJogo.getIdPlat()+" WHERE id="+ObjJogo.getIdJogo();
		super.atualizarDB(atualizarSQLQuery);		
	}
}
