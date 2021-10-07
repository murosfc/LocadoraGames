package manipularDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import objetos.CatPlat;
import objetos.Conta;

public class DBConta extends Conexao{

	public void incluirDB(Object obj, String tipo)
	{
		Conta ObjConta = (Conta) obj;  	
		
		try
        {   Statement statement = getConnection().createStatement();
        
        	//montagem da String SQL de inclusão na tabela
      		String incluirSQL = "INSERT INTO " + tipo + " (email, senha, idJogo) VALUES ('"+ObjConta.getEmail()+"','"+ObjConta.getSenha()+"','"+ObjConta.getIdJogo()+"')";
            System.out.println (incluirSQL);
        	int result = statement.executeUpdate(incluirSQL);
            
        	if (result == 1)
            {   JOptionPane.showMessageDialog(null,"A " + tipo + " foi adicionada corretamente!","Mensagem de Informação",JOptionPane.INFORMATION_MESSAGE);}
            else
            {   JOptionPane.showMessageDialog(null,"Erro ao adicionar " + tipo,"Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
            }
            statement.close();
        }
        catch (SQLException e)
        { System.out.println("Erro: "+e.getMessage()); }
    }
	
	public Object consultarDB(Object obj, String tipo) {
		Conta ObjConta = (Conta) obj;
		
		try
        {   
			Statement statement = getConnection().createStatement();
			
			//montagem da String SQL de consulta na tabela	
			String mysqlQuery = "SELECT * FROM "+ tipo +" where email = '"+ObjConta.getEmail()+"'";
			
            ResultSet result = statement.executeQuery(mysqlQuery);         
            
            if (result.next())
            {            	            	
            	ObjConta.setEmail(result.getString("email"));
            	ObjConta.setSenha(result.getString("senha"));
            	ObjConta.setIdJogo(Integer.parseInt(result.getString("idJogo")));
            	if (result.getString("disponivel").equals("0"))
            	{
            		ObjConta.setDisponivel(false);
            	}
            }
            else 
            {
            	System.out.println("A " + tipo + " " + ObjConta.getEmail() + " não foi encontrada");
            	ObjConta=null;
            }
            statement.close();
        }
		catch (SQLException e)
		{ System.out.println("Erro: "+e.getMessage()); }		
		return ObjConta;
	} 

	@Override
	public String[] listarDB(String tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	public void excluirDB(int id, String tipo)
	{
		String conta ="";
		
		try
		{
			Statement statement = getConnection().createStatement();
			String mysqlQuery = "SELECT * FROM "+ tipo + " WHERE id="+id;			
			ResultSet result = statement.executeQuery(mysqlQuery);
			
			if(result.next())
			{
				conta = result.getString("email");				
				mysqlQuery = "DELETE FROM " + tipo + " WHERE id="+id;								
				statement.executeUpdate(mysqlQuery);
				JOptionPane.showMessageDialog(null, "A "+ tipo + " " + conta +" foi excluída com sucesso");
			}
			else JOptionPane.showMessageDialog(null, "Não foi possível excluir a " + tipo + " selecionada");
			
		}
		catch (SQLException e)
		{
			System.out.println("Erro: "+e.getMessage());
		}
	}

	@Override
	public boolean listarBD(String tipo, DefaultTableModel tabela, String busca) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
