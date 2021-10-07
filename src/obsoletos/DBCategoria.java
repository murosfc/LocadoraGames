package obsoletos;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import manipularDB.Conexao;


public class DBCategoria extends Conexao {
	
	//método de inclusão no DB
		public void incluirDB(Object obj)
		{
			Categoria ObjCat = (Categoria) obj;
			
			try
	        {   Statement statement = getConnection().createStatement();
	            
	        	//montagem da String SQL de inclusão na tabela
	        	String incluirSQL = "INSERT INTO cagorias (nome) VALUES ('"+ObjCat.getNome()+"')";  
	        	
	            int result = statement.executeUpdate(incluirSQL);
	            
	        	if (result == 1)
	            {   JOptionPane.showMessageDialog(null,"Categoria adicionada corretamente!","Mensagem de Informação",JOptionPane.INFORMATION_MESSAGE);}
	            else
	            {   JOptionPane.showMessageDialog(null,"Erro ao adicionar categoria","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
	            }
	            statement.close();
	        }
	        catch (SQLException e)
	        { System.out.println("Problemas com o SQL de inclusão de Categoria!\nErro: "+ e);
	        }
	    }

}
