package manipularDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import objetos.Plataforma;

public class DBPlataforma extends Conexao
{
	
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
            	System.out.println("Plataforma "+ObjPlat.getNome()+" n�o enontrada");
            	ObjPlat = null;
            }
            statement.close();
        }
		catch (SQLException e)
		{ System.out.println("H� um problema com a consulta de plataforma no Banco de dados SQL"); }
		return ObjPlat;
	}   
            
        
		
	
}


