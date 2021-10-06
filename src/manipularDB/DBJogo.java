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
			System.out.println(mySQLQuery);
			
			if (result.next())
			{
				System.out.println("Entrou 3");
				String id, titulo, plataforma;
				result.beforeFirst(); //retorna para o inicial do result
				while (result.next())
				{
					System.out.println("Entrou 4");
					id = result.getString("id");
					titulo = result.getString("titulo");
					plataforma = result.getString("plataforma");
					tabela.addRow(new Object[]{id,titulo, plataforma});
				}
				return true;
			}			
		}
		catch (SQLException e) {
			System.out.println ("Erro ao buscar no BD: "+e);				
			}
		return false;			
		}	
	
	public void excluirDB(int id, String tipo) {
		
		
	}
	
	//método não utilizado nesta classe
	public String[] listarDB(String tipo) {		
		return null;
	}

}
