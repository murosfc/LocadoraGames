package manipularDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import objetos.Plataforma;

public class DBPlataforma extends Conexao
{
	
	private String[] nomes;

	//m�todo de inclus�o no DB
	public void incluirDB(Object obj)
	{
		Plataforma ObjPlat = (Plataforma) obj;
		
		try
        {   Statement statement = getConnection().createStatement();
            
        	//montagem da String SQL de inclus�o na tabela
        	String incluirSQL = "INSERT INTO Plataforma (nome) VALUES ('"+ObjPlat.getNome()+"')";
            
        	System.out.println("Enviando c�digo SQL: " + getConnection().nativeSQL(incluirSQL) + "\n");
            
        	int result = statement.executeUpdate(incluirSQL);
            
        	if (result == 1)
            {   JOptionPane.showMessageDialog(null,"Plataforma adicionada corretamente!","Mensagem de Informa��o",JOptionPane.INFORMATION_MESSAGE);}
            else
            {   JOptionPane.showMessageDialog(null,"Erro ao adicionar plataforma","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
            }
            statement.close();
        }
        catch (SQLException e)
        { System.out.println("Problemas com o SQL de inclus�o de Pataforma!"); }
    }
	
	//m�todo de consulta ao BD
	public Plataforma consultarDB(Object obj)
	{
		Plataforma ObjPlat = (Plataforma) obj;		
		try
        {   
			Statement statement = getConnection().createStatement();
        
            String mysqlQuery = "SELECT nome FROM Plataforma where nome = '"+ObjPlat.getNome()+"'";
            System.out.println("Enviando c�digo SQL: " + getConnection().nativeSQL(mysqlQuery));
            
            ResultSet result = statement.executeQuery(mysqlQuery);         
            
            if (result.next())
            {
            	System.out.println("A Plataforma "+ObjPlat.getNome()+" j� est� cadastrada");            	
            	ObjPlat.setNome(result.getString("nome"));
            }
            else 
            {
            	System.out.println("Plataforma "+ObjPlat.getNome()+" n�o encontrada");
            	ObjPlat=null;
            }
            statement.close();
        }
		catch (SQLException e)
		{ System.out.println("H� um problema com a consulta de plataforma no Banco de dados SQL"); }	
		System.out.println("Nomes: "+nomes);
		return ObjPlat;
	} 	
	
	public String[] listarDB()	{		
		try
		{
			Statement statement = getConnection().createStatement();
			String mysqlQuery = "SELECT * FROM Plataforma";
			
			 ResultSet result = statement.executeQuery(mysqlQuery);
			 result.last(); //move para �ltima linha do resultado
			 String [] lista = new String[result.getRow()]; //cria array de string do tamanho do result
			 System.out.println("Numero de plataformas cadastradas = "+result.getRow());
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
			 System.out.println("Erro ao obter dados de plataformas do banco de dados");
		 }		 
		 return null;	
	} 
	public void excluirDB(int id)
	{
		try
		{
			Statement statement = getConnection().createStatement();
			String mysqlQuery = "SELECT * FROM plataforma WHERE id="+id;			
			ResultSet result = statement.executeQuery(mysqlQuery);
			
			if(result.next())
			{
				String plataforma = result.getString("nome");				
				mysqlQuery = "DELETE FROM plataforma WHERE id="+id;								
				statement.executeUpdate(mysqlQuery);
				JOptionPane.showMessageDialog(null, "Plataforma "+plataforma+" exclu�da com sucesso");
			}
			else JOptionPane.showMessageDialog(null, "N�o foi poss�vel excluir a plataforma selecionada");
			
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}
}
            
        
		
	



