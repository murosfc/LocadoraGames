package manipularDB;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import objetos.Funcionario;
import objetos.PasswordHash;

public class DBFuncionario extends Conexao {
	
	//método incluirDB tratado local e processado pela super classe
	public void incluirDB(Object Obj)
	{
		Funcionario ObjFunc = (Funcionario) Obj;
		try {
			String consultarSQL = "SELECT * FROM funcionario WHERE email='"+ObjFunc.getEmail()+"'";
			ResultSet result = super.consultarDB(consultarSQL);
			if (result.next()) {
				JOptionPane.showMessageDialog(null, "O e-mail "+ObjFunc.getEmail()+" já está cadastrado no banco de dados de funcionarios","Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			}
			else {
				String incluirSQL = "INSERT INTO funcionario (nickname, email, whatsapp, senha) VALUES ('"+ObjFunc.getNickname()+"','"+ObjFunc.getEmail()+"','"+ObjFunc.getWhatsapp()+
						"','"+PasswordHash.getHashMd5(ObjFunc.getSenha())+"')";
			  	super.inserirBD("funcionario", incluirSQL);}
			}
		catch (SQLException e) {
			System.err.println("Erro: "+e.getMessage());
		}	  	      	
	}
	
	public void preencherTabelaFuncionarios (DefaultTableModel tabela) {
		try
		{
			tabela.setNumRows(0);
			String consultaSQL = "SELECT * FROM funcionario";
			ResultSet result = super.consultarDB(consultaSQL);
			int matricula;
			String nick, email, zap;
			if (result.next()){
				result.beforeFirst();
				while (result.next()) {
					matricula = Integer.parseInt(result.getString("matricula"));
					nick = result.getString("nickname");
					email = result.getString("email");
					zap = result.getString("whatsapp");
					tabela.addRow(new Object[]{matricula, nick, email, zap});
				}				
			}
		} catch (SQLException e) {
			System.err.println("Erro: "+e.getMessage());
		}
	}
	
	public void excluirDB(int matricula) {
		String excluirSQL = "DELETE FROM funcionario WHERE matricula ='"+matricula+"'";
		super.excluirDB("funcionario", excluirSQL);		
	}
}
