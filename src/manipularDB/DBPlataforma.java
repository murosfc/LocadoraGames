package manipularDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import objetos.Plataforma;

public class DBPlataforma extends Conexao
{
	
	//método de inclusão no DB
	public void incluirDB(Object obj)
	{
		Plataforma ObjPlat = (Plataforma) obj;
		
		try
        {   Statement statement = getConnection().createStatement();
            
        	//montagem da String SQL de inclusão na tabela
        	String incluirSQL = "INSERT INTO Plataforma (nome) VALUES ('"+ObjPlat.getNome()+"')";
            
        	System.out.println("Enviando código SQL: " + getConnection().nativeSQL(incluirSQL) + "\n");
            
        	int result = statement.executeUpdate(incluirSQL);
            
        	if (result == 1)
            {   JOptionPane.showMessageDialog(null,"Plataforma adicionada corretamente!","Mensagem de Informação",JOptionPane.INFORMATION_MESSAGE);}
            else
            {   JOptionPane.showMessageDialog(null,"Erro ao adicionar plataforma","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
            }
            statement.close();
        }
        catch (SQLException e)
        { System.out.println("Problemas com o SQL de inclusão de Pataforma!"); }
    }
	
	//método de consulta ao BD
	public Plataforma consultarDB(Object obj)
	{
		Plataforma ObjPlat = (Plataforma) obj;
		try
        {   
			Statement statement = getConnection().createStatement();
        
            String mysqlQuery = "SELECT nome FROM Plataforma where nome = '"+ObjPlat.getNome()+"'";
            System.out.println("Enviando código SQL: " + getConnection().nativeSQL(mysqlQuery));
            
            ResultSet result = statement.executeQuery(mysqlQuery);
            if (result.next())
            {
            	System.out.println("A Plataforma "+ObjPlat.getNome()+" já está cadastrada");
            	
            	ObjPlat.setNome(result.getString("nome"));
            }
            else 
            {
            	System.out.println("Plataforma "+ObjPlat.getNome()+" não enontrada");
            	ObjPlat = null;
            }
            statement.close();
        }
		catch (SQLException e)
		{ System.out.println("Há um problema com a consulta de plataforma no Banco de dados SQL"); }
		return ObjPlat;
	}   
            
        
		
	
}


