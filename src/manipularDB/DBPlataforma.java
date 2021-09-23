package manipularDB;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import objetos.Plataforma;

public class DBPlataforma extends Conexao
{
	
	public void incluirDB(Object obj)
	{
		Plataforma ObjPlat = (Plataforma) obj;
		
		try
        {   Statement statement = getConnection().createStatement();
            
        	//montagem da String SQL de inclusão na tabela
        	String incluirSQL = "INSERT INTO Plataforma (nome) VALUES "+ObjPlat.getNome()+"";
            
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
}


