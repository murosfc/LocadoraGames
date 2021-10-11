package manipularDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import objetos.CatPlat;

public class DBCatPlat extends Conexao {	

	//método incluirDB tratado local e processado pela super classe
	public void incluirDB(String nomeObjeto, String tipo)
	{
		try {
			String consultarSQL = "SELECT * FROM " +tipo+ " WHERE nome='"+nomeObjeto+"'";
			ResultSet result = super.consultarDB(consultarSQL);
			if (result.next()) {
				JOptionPane.showMessageDialog(null, nomeObjeto+" já está cadastrado no banco de dados de "+tipo,"Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			}
			else {
				String incluirSQL = "INSERT INTO " + tipo + " (nome) VALUES ('"+nomeObjeto+"')";
			  	super.inserirBD(tipo, incluirSQL);}
			}
		catch (SQLException e) {
			System.err.println("Erro: "+e.getMessage());
		}
	  	      	
	}
	
	//método exculirDB tratado local e processado pela super classe
	public void excluirDB(int id, String tipo)
	{
		String catplat = tipo;		
		try
		{			
			String mysqlQuery = "SELECT * FROM "+ tipo + " WHERE id="+id;			
			ResultSet result = super.consultarDB(mysqlQuery);			
			if(result.next())
			{
				catplat = result.getString("nome");				
				mysqlQuery = "DELETE FROM " + tipo + " WHERE id="+id;								
				super.excluirDB(catplat, mysqlQuery);				
			}						
		}
		catch (SQLException e)
		{
			System.out.println("Erro tentar excluir "+ catplat +" do banco de dados. Erro: "+e);
		}
	}		
	
	public void preecheTabelaCatPlat(DefaultTableModel tabela, String tipo)
	{
		tabela.setNumRows(0);
		String mysqlQuery = "SELECT * FROM "+ tipo;
		int id;
		String catPlat;
		try
		{			
			ResultSet result = super.consultarDB(mysqlQuery);
			
			while (result.next())
			{
				id = Integer.parseInt(result.getString("id"));
				catPlat = result.getString("nome");
				tabela.addRow(new Object[] {id, catPlat});				
			}
		}catch (SQLException e) {
			System.err.println("Erro: "+e.getMessage());
		}
	}
	
	//método eclusivo da classe listar conteúdo do DB dentro da lista para um JList
	public String[] listarDB(String tipo)	{		
		try
		{			
			String mysqlQuery = "SELECT * FROM "+ tipo;
			
			 ResultSet result = super.consultarDB(mysqlQuery);
			 result.last(); //move para última linha do resultado
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
}
            
        
		
	



