package manipularDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.table.DefaultTableModel;

public class DBAluguel extends Conexao{
	
	public DBAluguel() {
		super.conectarDB();
	}
	
	public float relatorioVendas(String dataInicio, String dataFim, DefaultTableModel tabela) {		
		String consultarSQLQuery = "SELECT a.pedido, c.email as cliente, ct.email as conta, a.datainicio as inicio, a.datafim as fim, f.nickname as funcionario, "
				+ "(DATEDIFF(a.datafim,a.datainicio)/7*j.valor) as valor FROM aluguel a JOIN cliente c ON a.cpf = c.cpf JOIN conta ct ON a.idConta = ct.id "
				+ "JOIN funcionario f on a.matricula = f.matricula JOIN jogo j ON j.id=ct.idJogo WHERE a.datainicio >= '"+dataInicio+"' AND a.datainicio <= '"+dataFim+"'";
		String pedido, cliente, conta, inicio, fim, funcionario;
		float valor, total = 0;		
		try{
			ResultSet result = super.consultarDB(consultarSQLQuery);			
			while (result.next()) {
				pedido = result.getString("pedido");
				cliente = result.getString("cliente");
				conta = result.getString("conta");
				inicio = result.getString("inicio");
				fim = result.getString("fim");
				funcionario = result.getString("funcionario");
				valor = Float.parseFloat(result.getString("valor"));
				tabela.addRow(new Object[] {pedido, cliente, conta, inicio, fim, funcionario, String.format("%.2f",valor)});
				total = total +valor;				
			}
			return total;
		}catch (SQLException e) {
			System.err.println("Erro: "+e.getMessage());
		}
		return total;
	}

}
