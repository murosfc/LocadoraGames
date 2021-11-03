package manipularDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import objetos.CatPlat;
import objetos.Conta;

public class DBConta extends Conexao{
	
	//método incluirDB tratado local e processado pela super classe
	public void incluirDB(Object obj)
	{
		Conta ObjConta = (Conta) obj;
		try {
			String consultaSQL = "SELECT * FROM conta WHERE email='"+ObjConta.getEmail()+"'";
			ResultSet result = super.consultarDB(consultaSQL);
			if (result.next())
			{
				JOptionPane.showMessageDialog(null, "A conta com email "+ObjConta.getEmail()+" já está cadastrada");
			}
			else {
				String incluirSQL = "INSERT INTO conta (email, senha, idJogo) VALUES ('"+ObjConta.getEmail()+"','"+ObjConta.getSenha()+"','"+ObjConta.getIdJogo()+"')";
				super.inserirBD("conta", incluirSQL);
		    }
		} catch (SQLException e)
		{
			System.err.println("Erro: "+e.getMessage());
		}
	}	
	
	public Object consultarDB(Object obj) {
		Conta ObjConta = (Conta) obj;	
		try
        {   				
			String mysqlQuery = "SELECT * FROM conta where email = '"+ObjConta.getEmail()+"'";			
            ResultSet result = super.consultarDB(mysqlQuery);            
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
            	System.out.println("A conta com e-mail " + ObjConta.getEmail() + " não foi encontrada");
            	ObjConta=null;
            }            
        }
		catch (SQLException e)
		{ System.out.println("Erro: "+e.getMessage()); }		
		return ObjConta;
	} 

	public void excluirDB(String email)
	{
		try
		{			
			String consultaSQL = "SELECT * FROM conta WHERE email='"+email+"'";			
			ResultSet result = super.consultarDB(consultaSQL);
			
			if(result.next())
			{								
				String exluirSQL = "DELETE FROM conta WHERE email='"+email+"'";	
				super.excluirDB("conta", exluirSQL);
				JOptionPane.showMessageDialog(null, "A conta com e-mail " + email +" foi excluída com sucesso");
			}
			else JOptionPane.showMessageDialog(null, "Não foi possível excluir a conta selecionada");			
		}
		catch (SQLException e)
		{
			System.out.println("Erro: "+e.getMessage());
		}
	}
	
	public boolean preencheTabelaContaTrocarSenha (String emailProcurado, DefaultTableModel tabela)	{
		tabela.setRowCount(0);
		try
        {   
			Statement statement = getConnection().createStatement();	
			
			String mysqlQuery = "SELECT c.id, c.email, c.senha, j.titulo, p.nome as plataforma FROM conta c JOIN jogo j ON c.idJogo = j.id JOIN plataforma p ON j.idPlataforma = p.id WHERE c.email LIKE '%"+emailProcurado+"%'";			
            ResultSet result = statement.executeQuery(mysqlQuery);            
            if (!result.next())
            {
           		return false;
            }
            else 
            {
            	result.beforeFirst();
				int idConta;
				String email, senha, tituloJogo, plataforma;			
				while (result.next())
				{
					idConta = Integer.parseInt(result.getString("id"));
					email = result.getString("email");
					senha = result.getString("senha");				
					tituloJogo = result.getString("titulo");
					plataforma = result.getString("plataforma");
					tabela.addRow(new Object[]{idConta,email,senha,tituloJogo,plataforma});
				}	
            }
            statement.close();
        }
		catch (SQLException e)
		{ System.out.println("Erro: "+e.getMessage());}
		return true;
	}	
	
	public void AtualizarSenhaConta(int idConta, String senha) 
	{
		try
        {   
			Statement statement = getConnection().createStatement();
				
			String mysqlQuery = "UPDATE conta SET senha = '"+senha+"' WHERE id="+idConta+""; 
			
            int result = statement.executeUpdate(mysqlQuery); 
            
            if (result == 1)
            {
            	statement.executeUpdate("UPDATE conta SET disponivel = 1 WHERE id="+idConta+"");
            	JOptionPane.showMessageDialog(null, "Senha atualizada com sucesso! ","Mensagem de confirmação", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
            	JOptionPane.showMessageDialog(null, "Ocorreu um erro desconhecido na atualização da senha.\nContate o administrador ","Mensagem de erro", JOptionPane.ERROR_MESSAGE);
            }            
            statement.close();
        }
		catch (SQLException e)
		{ System.out.println("Erro: "+e.getMessage());}
	}

	public void preecheTabelaPrioridades (DefaultTableModel tabela)
	{
		tabela.setRowCount(0);
		try {
			String consultaSQL = "select c.id, c.email, j.titulo, p.nome as plataforma, sum(CURDATE()- a.datafim) as prioridade from conta c JOIN jogo j ON c.idJogo = j.id JOIN plataforma p on j.idPlataforma = p.id JOIN aluguel a on c.id=a.idConta WHERE CURDATE()- a.datafim > 0 AND c.disponivel = 0 group by a.pedido order by prioridade desc";
			ResultSet result = super.consultarDB(consultaSQL);
			int id, prioridade;
			String email, jogo, plataforma; 
			while (result.next())
			{
				id = Integer.parseInt(result.getString("id"));
				email = result.getString("email");
				jogo = result.getString("titulo");
				plataforma = result.getString("plataforma");
				prioridade = Integer.parseInt(result.getString("prioridade"));
				tabela.addRow(new Object[]{id,email,jogo,plataforma,prioridade});
			}
		} catch (SQLException e)
		{
			System.err.println("Erro: "+e.getMessage());
		}
	}
	
	public int quantidadePrioridadesAtualizarSenha() {
		try {
			String consultaSQL = "select c.id, c.email, j.titulo, p.nome as plataforma, sum(CURDATE()- a.datafim) as prioridade from conta c JOIN jogo j ON c.idJogo = j.id JOIN plataforma p on j.idPlataforma = p.id JOIN aluguel a on c.id=a.idConta WHERE CURDATE()- a.datafim > 0 AND c.disponivel = 0 group by a.pedido order by prioridade desc";
			ResultSet result = super.consultarDB(consultaSQL);
			if (result != null) {
				result.last();				
				return result.getRow();
			}
			
		}catch (SQLException e) {
			System.err.println("Erro: "+e.getMessage());
		}
		return 0;
	}
	
}
