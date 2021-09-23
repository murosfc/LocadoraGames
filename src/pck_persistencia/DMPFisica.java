package pck_persistencia;

import pck_conexao.PFisica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

//classe DMPessoaFisica � subclasse de DMGeral
public class DMPFisica extends DMGeral
{
    String cpf = null;
    
    //implementa��o da opera��o abstrata incluir herdada de DMGeral
    public void incluir(Object obj)
    {   PFisica objPF = (PFisica) obj;
        try
        {   Statement statement = getConnection().createStatement();
            
        	//montagem da String SQL de inclus�o na tabela
        	String incluirSQL = "INSERT INTO pfisicas (" +
                                "cpf,nome,email " +
                                ") VALUES ('" +
                                objPF.getCpf() + "', '" +
                                objPF.getNome() + "', '" +
                                objPF.getEmail() + "')";
            
        	System.out.println("Enviando c�digo SQL: " + getConnection().nativeSQL(incluirSQL) + "\n");
            
        	int result = statement.executeUpdate(incluirSQL);
            
        	if (result == 1)
            {   JOptionPane.showMessageDialog(null,"Pessoa Fisica cadastrada corretamente !","Mensagem de Informa��o",JOptionPane.INFORMATION_MESSAGE);}
            else
            {   JOptionPane.showMessageDialog(null,"Erro ao cadastrar pessoa f�sica !","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
            }
            statement.close();
        }
        catch (SQLException e)
        { System.out.println("Problemas com o SQL de inclus�o de pessoa f�sica!"); }
    }

    //implementa��o da opera��o abstrata consultar herdada de DMGeral
    public Object consultar(Object obj)
    {   
    	PFisica objPF = (PFisica) obj;
        try
        {   Statement statement = getConnection().createStatement();
            
        	//montagem da String SQL de consulta na tabela
        	String consultarSQL = "SELECT * FROM pfisicas WHERE (cpf = '"+objPF.getCpf()+"')";
            System.out.println("Enviando c�digo SQL: " + getConnection().nativeSQL(consultarSQL));
            
            ResultSet result = statement.executeQuery(consultarSQL);
            if (result.next())
            {   System.out.println("Pessoa F�sica existente !" );
                System.out.println("Cpf.........: "+ result.getString("cpf"));
                System.out.println("Nome........: "+ result.getString("nome"));
                System.out.println("Email.......: "+ result.getString("email"));
                
                objPF.setCpf(result.getString("cpf"));
                objPF.setNome(result.getString("nome"));
                objPF.setEmail(result.getString("email"));
                                        
                result.close();
            }
            else
            {   System.out.println( "Pessoa F�sica n�o encontrada !\n" );
                objPF = null;
            }
            statement.close();
        }
        catch (SQLException e)
        { System.out.println("Problemas com o SQL de consulta de Pessoa F�sica !"); }
        return objPF;
    }
        
    
    //opera��o buscar
    public PFisica buscar(String cpf)
    {   
    	PFisica objPF = new PFisica();
    	try
        {   Statement statement = getConnection().createStatement();
            
    		//montagem da String SQL de consulta na tabela        	
        	String consultarSQL = "SELECT * FROM pfisicas WHERE (cpf = '"+cpf+"')";
            System.out.println("Enviando c�digo SQL: " + getConnection().nativeSQL(consultarSQL));
            ResultSet result = statement.executeQuery(consultarSQL);
            if (result.next())
            {   System.out.println("DMPFisica - Metodo Buscar" );
                System.out.println("Pessoa F�sica existente");
                System.out.println("Cpf.............: "+ result.getString("cpf"));
                System.out.println("Nome...............: "+ result.getString("nome"));
                objPF.setCpf(cpf);
                objPF.setNome(result.getString("nome"));
                JOptionPane.showMessageDialog(null,objPF.getNome());
                result.close();
            }
            else
            {   System.out.println( "Pessoa F�sica n�o encontrada !\n" );
                objPF = null;
            }
            statement.close();
        }
        catch (SQLException e)
        { System.out.println("Problemas com o SQL de consulta de Pessoa F�sica !"); }
        return objPF;
    }
       
    
    //implementa��o da opera��o abstrata excluir herdada de DMGeral
    public void excluir(Object obj)
    {   PFisica objPF = (PFisica) obj;
	    try
		 {      Statement statement = getConnection().createStatement();
		        //montagem da String SQL de altera��o
		    	String excluirSQL = "DELETE FROM pfisicas " +
		                            "WHERE cpf = '" + objPF.getCpf() + "'";
		        
		    	System.out.println("Enviando c�digo SQL: " + getConnection().nativeSQL(excluirSQL) + "\n");
		        
		    	int result = statement.executeUpdate(excluirSQL);
		        
		    	if (result == 1)
		        {   JOptionPane.showMessageDialog(null,"Exclus�o efetuada!","Mensagem de Informa��o",JOptionPane.INFORMATION_MESSAGE);}
		        else
		        {   JOptionPane.showMessageDialog(null,"Erro na exclus�o da pessoa f�sica !","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
		        }
		        statement.close();
		 }
		 catch (SQLException e)
		 { System.out.println("Problemas com o SQL de exclus�o de pessoa f�sica!"); }	     	    
   }
    
  //implementa��o da opera��o abstrata alterar herdada de DMGeral
    public void alterar(Object obj)
    {   PFisica objPF = (PFisica) obj;
        try
        {   Statement statement = getConnection().createStatement();
            
        	//montagem da String SQL de altera��o
        	String alterarSQL = "UPDATE pfisicas SET " +
                                "nome = '" + objPF.getNome() + "'," +
        			            "email = '" + objPF.getEmail() + "' " +
                                "where cpf = '" + objPF.getCpf() + "'";
            
        	System.out.println("Enviando c�digo SQL: " + getConnection().nativeSQL(alterarSQL) + "\n");
            
        	int result = statement.executeUpdate(alterarSQL);
            
        	if (result == 1)
            {   JOptionPane.showMessageDialog(null,"Dados atualizados corretamente !","Mensagem de Informa��o",JOptionPane.INFORMATION_MESSAGE);}
            else
            {   JOptionPane.showMessageDialog(null,"Erro na atualiza��o dos dados de pessoa f�sica !","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
            	objPF.setCpf("");    
            	objPF.setNome("");
            	objPF.setEmail("");
            }
            statement.close();
        }
        catch (SQLException e)
        { System.out.println("Problemas com o SQL de altera��o de pessoa f�sica!"); }
    }
}