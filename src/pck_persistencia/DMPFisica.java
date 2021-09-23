package pck_persistencia;

import pck_conexao.PFisica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

//classe DMPessoaFisica é subclasse de DMGeral
public class DMPFisica extends DMGeral
{
    String cpf = null;
    
    //implementação da operação abstrata incluir herdada de DMGeral
    public void incluir(Object obj)
    {   PFisica objPF = (PFisica) obj;
        try
        {   Statement statement = getConnection().createStatement();
            
        	//montagem da String SQL de inclusão na tabela
        	String incluirSQL = "INSERT INTO pfisicas (" +
                                "cpf,nome,email " +
                                ") VALUES ('" +
                                objPF.getCpf() + "', '" +
                                objPF.getNome() + "', '" +
                                objPF.getEmail() + "')";
            
        	System.out.println("Enviando código SQL: " + getConnection().nativeSQL(incluirSQL) + "\n");
            
        	int result = statement.executeUpdate(incluirSQL);
            
        	if (result == 1)
            {   JOptionPane.showMessageDialog(null,"Pessoa Fisica cadastrada corretamente !","Mensagem de Informação",JOptionPane.INFORMATION_MESSAGE);}
            else
            {   JOptionPane.showMessageDialog(null,"Erro ao cadastrar pessoa física !","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
            }
            statement.close();
        }
        catch (SQLException e)
        { System.out.println("Problemas com o SQL de inclusão de pessoa física!"); }
    }

    //implementação da operação abstrata consultar herdada de DMGeral
    public Object consultar(Object obj)
    {   
    	PFisica objPF = (PFisica) obj;
        try
        {   Statement statement = getConnection().createStatement();
            
        	//montagem da String SQL de consulta na tabela
        	String consultarSQL = "SELECT * FROM pfisicas WHERE (cpf = '"+objPF.getCpf()+"')";
            System.out.println("Enviando código SQL: " + getConnection().nativeSQL(consultarSQL));
            
            ResultSet result = statement.executeQuery(consultarSQL);
            if (result.next())
            {   System.out.println("Pessoa Física existente !" );
                System.out.println("Cpf.........: "+ result.getString("cpf"));
                System.out.println("Nome........: "+ result.getString("nome"));
                System.out.println("Email.......: "+ result.getString("email"));
                
                objPF.setCpf(result.getString("cpf"));
                objPF.setNome(result.getString("nome"));
                objPF.setEmail(result.getString("email"));
                                        
                result.close();
            }
            else
            {   System.out.println( "Pessoa Física não encontrada !\n" );
                objPF = null;
            }
            statement.close();
        }
        catch (SQLException e)
        { System.out.println("Problemas com o SQL de consulta de Pessoa Física !"); }
        return objPF;
    }
        
    
    //operação buscar
    public PFisica buscar(String cpf)
    {   
    	PFisica objPF = new PFisica();
    	try
        {   Statement statement = getConnection().createStatement();
            
    		//montagem da String SQL de consulta na tabela        	
        	String consultarSQL = "SELECT * FROM pfisicas WHERE (cpf = '"+cpf+"')";
            System.out.println("Enviando código SQL: " + getConnection().nativeSQL(consultarSQL));
            ResultSet result = statement.executeQuery(consultarSQL);
            if (result.next())
            {   System.out.println("DMPFisica - Metodo Buscar" );
                System.out.println("Pessoa Física existente");
                System.out.println("Cpf.............: "+ result.getString("cpf"));
                System.out.println("Nome...............: "+ result.getString("nome"));
                objPF.setCpf(cpf);
                objPF.setNome(result.getString("nome"));
                JOptionPane.showMessageDialog(null,objPF.getNome());
                result.close();
            }
            else
            {   System.out.println( "Pessoa Física não encontrada !\n" );
                objPF = null;
            }
            statement.close();
        }
        catch (SQLException e)
        { System.out.println("Problemas com o SQL de consulta de Pessoa Física !"); }
        return objPF;
    }
       
    
    //implementação da operação abstrata excluir herdada de DMGeral
    public void excluir(Object obj)
    {   PFisica objPF = (PFisica) obj;
	    try
		 {      Statement statement = getConnection().createStatement();
		        //montagem da String SQL de alteração
		    	String excluirSQL = "DELETE FROM pfisicas " +
		                            "WHERE cpf = '" + objPF.getCpf() + "'";
		        
		    	System.out.println("Enviando código SQL: " + getConnection().nativeSQL(excluirSQL) + "\n");
		        
		    	int result = statement.executeUpdate(excluirSQL);
		        
		    	if (result == 1)
		        {   JOptionPane.showMessageDialog(null,"Exclusão efetuada!","Mensagem de Informação",JOptionPane.INFORMATION_MESSAGE);}
		        else
		        {   JOptionPane.showMessageDialog(null,"Erro na exclusão da pessoa física !","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
		        }
		        statement.close();
		 }
		 catch (SQLException e)
		 { System.out.println("Problemas com o SQL de exclusão de pessoa física!"); }	     	    
   }
    
  //implementação da operação abstrata alterar herdada de DMGeral
    public void alterar(Object obj)
    {   PFisica objPF = (PFisica) obj;
        try
        {   Statement statement = getConnection().createStatement();
            
        	//montagem da String SQL de alteração
        	String alterarSQL = "UPDATE pfisicas SET " +
                                "nome = '" + objPF.getNome() + "'," +
        			            "email = '" + objPF.getEmail() + "' " +
                                "where cpf = '" + objPF.getCpf() + "'";
            
        	System.out.println("Enviando código SQL: " + getConnection().nativeSQL(alterarSQL) + "\n");
            
        	int result = statement.executeUpdate(alterarSQL);
            
        	if (result == 1)
            {   JOptionPane.showMessageDialog(null,"Dados atualizados corretamente !","Mensagem de Informação",JOptionPane.INFORMATION_MESSAGE);}
            else
            {   JOptionPane.showMessageDialog(null,"Erro na atualização dos dados de pessoa física !","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
            	objPF.setCpf("");    
            	objPF.setNome("");
            	objPF.setEmail("");
            }
            statement.close();
        }
        catch (SQLException e)
        { System.out.println("Problemas com o SQL de alteração de pessoa física!"); }
    }
}