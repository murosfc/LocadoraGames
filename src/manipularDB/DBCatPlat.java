package manipularDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import objetos.CatPlat;

public class DBCatPlat extends Conexao {	

	//m�todo de inclus�o no DB
	public void incluirDB(Object obj, String tipo)
	{
		CatPlat ObjPlat = (CatPlat) obj;  	
		
		try
        {   Statement statement = getConnection().createStatement();
        
        	//montagem da String SQL de inclus�o na tabela
      		String incluirSQL = "INSERT INTO " + tipo + " (nome) VALUES ('"+ObjPlat.getNome()+"')";
            
        	int result = statement.executeUpdate(incluirSQL);
            
        	if (result == 1)
            {   JOptionPane.showMessageDialog(null,"A " + tipo + " foi adicionada corretamente!","Mensagem de Informa��o",JOptionPane.INFORMATION_MESSAGE);}
            else
            {   JOptionPane.showMessageDialog(null,"Erro ao adicionar " + tipo,"Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
            }
            statement.close();
        }
        catch (SQLException e)
        { System.out.println("Problemas com o SQL de inclus�o de " + tipo + "! Erro "+e); }
    }
	
	//m�todo de consulta ao BD
	public CatPlat consultarDB(Object obj, String tipo)
	{
		CatPlat ObjPlat = (CatPlat) obj;
		
		try
        {   
			Statement statement = getConnection().createStatement();
			
			//montagem da String SQL de consulta na tabela	
			String mysqlQuery = "SELECT nome FROM "+ tipo +" where nome = '"+ObjPlat.getNome()+"'";
			
            ResultSet result = statement.executeQuery(mysqlQuery);         
            
            if (result.next())
            {
            	System.out.println("A " + tipo + " " + ObjPlat.getNome() + " j� est� cadastrada");            	
            	ObjPlat.setNome(result.getString("nome"));
            }
            else 
            {
            	System.out.println("A " + tipo + " " + ObjPlat.getNome() + " n�o encontrada");
            	ObjPlat=null;
            }
            statement.close();
        }
		catch (SQLException e)
		{ System.out.println("H� um problema com a consulta ao Banco de dados SQL. Erro"+e); }		
		return ObjPlat;
	} 	
	
	//m�todo listar conte�do da DB
	public String[] listarDB(String tipo)	{		
		try
		{
			Statement statement = getConnection().createStatement();
			String mysqlQuery = "SELECT * FROM "+ tipo;
			
			 ResultSet result = statement.executeQuery(mysqlQuery);
			 result.last(); //move para �ltima linha do resultado
			 String [] lista = new String[result.getRow()]; //cria array de string do tamanho do result			
			 result.beforeFirst(); //retorna para o primeiro item do result
			 int i=0;
			 
			 while (result.next())
			 {
				 lista[i] = result.getString("id")+"- "+result.getString("nome");
				 i++;
			 }
			 return lista;
		}
		 catch (SQLException e)	 
		 {
			 System.out.println("Erro ao obter dados de "+tipo+" do banco de dados. Erro: "+e);
		 }		 
		 return null;	
	} 
	//m�todo excluir item DB
	public void excluirDB(int id, String tipo)
	{
		String catplat ="";
		
		try
		{
			Statement statement = getConnection().createStatement();
			String mysqlQuery = "SELECT * FROM "+ tipo + " WHERE id="+id;			
			ResultSet result = statement.executeQuery(mysqlQuery);
			
			if(result.next())
			{
				catplat = result.getString("nome");				
				mysqlQuery = "DELETE FROM " + tipo + " WHERE id="+id;								
				statement.executeUpdate(mysqlQuery);
				JOptionPane.showMessageDialog(null, "A "+ tipo + " " + catplat +" foi exclu�da com sucesso");
			}
			else JOptionPane.showMessageDialog(null, "N�o foi poss�vel excluir a " + tipo + " selecionada");
			
		}
		catch (SQLException e)
		{
			System.out.println("Erro tentar excluir "+ catplat +" do banco de dados. Erro: "+e);
		}
	}
	
	public boolean listarBD(String tipo, DefaultTableModel tabela, String busca) {
		// TODO Auto-generated method stub
		return false;
	}

}
            
        
		
	



