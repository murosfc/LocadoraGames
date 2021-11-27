package pck_persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DMGeral
{
	protected static Connection connection;

	public static Connection getConnection()
	{	return connection;	}

	//operação criada para conectar com o BD
	public void conectaDataBase(String dataBase, String userName, String password)
	{	
		//string de conexão JDBC, indica o BD ao qual deseja conectar	
		String url = "jdbc:mysql://localhost/"+dataBase+"?serverTimezone=UTC";
		
		try
		{	//carrega o driver especificado (driver do mysql)
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//após o carregamento do driver, deve-se abrir uma conexão com o BD
			//usando o método estático getConnection da classe DriverManager
		   	connection = DriverManager.getConnection(url,userName,password);
			System.out.println("Conexao ao banco de dados feita com sucesso!");
		} 
		catch (ClassNotFoundException cnfex)
		{	//driver não encontrado
			System.err.println("Falha ao abrir o driver JDBC/ODBC");
			cnfex.printStackTrace();
			System.exit(1);
		}
		catch (SQLException sqlex)
		{	System.err.println("Impossível conectar");
			sqlex.printStackTrace();
		}
	}

	//operação para desconectar do BD	
	public void shutDown()
	{	try
		{	connection.close();	}
		catch (SQLException sqlex)
		{	System.err.println("Impossível desconectar");
		  	sqlex.printStackTrace();
		}
	}
	
	//operações abstratas para inclusão,consulta,exclusão e alteração no BD
	//devem ser implementadas nas subclasses de DMGeral
	public abstract void incluir(Object obj); 
	public abstract Object consultar(Object obj);
	public abstract void excluir(Object obj);
	public abstract void alterar(Object obj);
}