package manipularDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public abstract class Conexao 
{
	protected static Connection con;
	protected static String user ="root";
	protected static String DBUrl = "jdbc:mysql://localhost/db_locadora?serverTimezone=UTC";
	protected static String pass = "abric�";
	
	public static Connection getConnection()
	{	return con;	}
	
	public void conectarDB()
	{
		try
		{	//carrega o driver especificado (driver do mysql)
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//ap�s o carregamento do driver, deve-se abrir uma conex�o com o BD
			//usando o m�todo est�tico getConnection da classe DriverManager
		   	con = DriverManager.getConnection(DBUrl,user,pass);
			System.out.println("Conexao ao banco de dados feita com sucesso!");
		} 
		catch (ClassNotFoundException cnfex)
		{	//driver n�o encontrado
			System.err.println("Falha ao abrir o driver JDBC/ODBC");
			cnfex.printStackTrace();
			System.exit(1);
		}
		catch (SQLException sqlex)
		{	System.err.println("N�o foi poss�vel conectar ao Banco de Dados");
			sqlex.printStackTrace();
		}
	}
	
	//opera��o para desconectar do BD	
	public void shutDown()
		{	try
			{	con.close();	}
			catch (SQLException sqlex)
			{	System.err.println("Imposs�vel desconectar");
			  	sqlex.printStackTrace();
			}
		}
		
	//opera��o de inclus�o, comum a todas as classes filhas
	public void inserirBD (String nomeObjeto, String incluirSQL)
	{
		try
        {   
			Statement statement = getConnection().createStatement();        
            
        	int result = statement.executeUpdate(incluirSQL);
            if (!nomeObjeto.equals("categoriajogo")){
	        	if (result == 1)
	            {   JOptionPane.showMessageDialog(null,"Entrada de dados na tabela " + nomeObjeto + " adicionada corretamente!","Mensagem de Informa��o",JOptionPane.INFORMATION_MESSAGE);}
	            else
	            {   JOptionPane.showMessageDialog(null,"Erro ao adicionar " + nomeObjeto,"Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
	            }
	            statement.close();
            }
        }
        catch (SQLException e)
        { System.out.println("Erro "+e.getMessage()); }
	}
	
	//opera��o de exclus�o, comum a todas as classes filhas
	public void excluirDB (String nomeObjeto, String excluirSQL)
	{
		try
		{										
			Statement statement = getConnection().createStatement();			
			statement.executeUpdate(excluirSQL);
			JOptionPane.showMessageDialog(null, "A entrada na tabela "+nomeObjeto+" foi exclu�da com sucesso");
		}		
		catch (SQLException e)
		{
			System.out.println("Erro: "+e.getMessage());
		}
	}
	
	//consulta simples para classes filhas retornando ResultSet
	public ResultSet consultarDB (String consultaSQL) {
		try
		{
			Statement statement = getConnection().createStatement();
			ResultSet result = statement.executeQuery(consultaSQL);
			return result;
		}
		catch (SQLException e)
		{
			System.out.println("Erro na cunsulta ao BD: "+e.getMessage());
		}
		return null;
	}	
	
}
