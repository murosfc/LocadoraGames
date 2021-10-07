package manipularDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class DBJogo extends Conexao{
	
	public void incluirDB(Object obj, String tipo) {
				
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
			String mySQLQuery = "SELECT j.id, j.titulo, p.nome as 'plataforma' FROM jogo j LEFT JOIN plataforma p on j.idPlataforma=p.id WHERE j.id="+id+"";
			ResultSet result = statement.executeQuery(mySQLQuery);
			System.out.println(mySQLQuery);
			
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
	
	//m�todo n�o utilizado nesta classe
	public String[] listarDB(String tipo) {		
		return null;
	}

}
