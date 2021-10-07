package manipularDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public abstract class Conexao 
{
	protected static Connection con;
	protected static String user ="root";
	protected static String DBUrl = "jdbc:mysql://localhost/db_locadora?serverTimezone=UTC";
	protected static String pass = "abricó";
	
	public static Connection getConnection()
	{	return con;	}
	
	public void conectarDB()
	{
		try
		{	//carrega o driver especificado (driver do mysql)
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//após o carregamento do driver, deve-se abrir uma conexão com o BD
			//usando o método estático getConnection da classe DriverManager
		   	con = DriverManager.getConnection(DBUrl,user,pass);
			System.out.println("Conexao ao banco de dados feita com sucesso!");
		} 
		catch (ClassNotFoundException cnfex)
		{	//driver não encontrado
			System.err.println("Falha ao abrir o driver JDBC/ODBC");
			cnfex.printStackTrace();
			System.exit(1);
		}
		catch (SQLException sqlex)
		{	System.err.println("Não foi possível conectar ao Banco de Dados");
			sqlex.printStackTrace();
		}
	}
	
	//operação para desconectar do BD	
		public void shutDown()
		{	try
			{	con.close();	}
			catch (SQLException sqlex)
			{	System.err.println("Impossível desconectar");
			  	sqlex.printStackTrace();
			}
		}
		
		
		
		//operações abstratas para inclusão,consulta,exclusão e alteração no BD
		//devem ser implementadas nas subclasses de Conexao
		public abstract void incluirDB(Object obj, String tipo);
		public abstract Object consultarDB(Object obj, String tipo );
		public abstract String[] listarDB(String tipo);
		public abstract void excluirDB(int id, String tipo);
		public abstract boolean listarBD(String tipo, DefaultTableModel tabela, String busca); //para busca de tabela de jogos
}
