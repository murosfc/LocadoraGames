package pck_conexao;

import javax.swing.JOptionPane;

import pck_conexao.PFisica;
import pck_persistencia.DMPFisica;

public class PFisica {

	private String cpf;
	private String nome;
	private String email;
	
	//atributo de referência para conexão com banco de dados
	private DMPFisica dm_pfisica;

	
	//método construtor 1
	public PFisica()
	{	}
	
	//método construtor2
	public PFisica(String cpf, String nome, String email)
	{ 	this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		dm_pfisica = new DMPFisica();
		
		//Fazer a Conexao com o BD
		dm_pfisica.conectaDataBase("db_agenda","root","mysql");
	   	
	   	System.out.println("Conexão feita à tabela Pfisicas com sucesso!");
	
	}

	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	//método incluir
    public void incluir(PFisica objPF)
    {   if (objPF.getCpf().equals(""))
        {   JOptionPane.showMessageDialog(null,"O cpf da Pessoa Física é obrigatório!","Mensagem de alerta",JOptionPane.WARNING_MESSAGE);
            System.out.println("O cpf da Pessoa Física é obrigatório!");
        }
        else
        {   if (dm_pfisica.consultar(this)!= null)
            {   JOptionPane.showMessageDialog(null,"Cadastro de Pessoa Física não realizado!\n Já existe uma Pessoa Física com este cpf!","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
                System.out.println("Cadastro de Pessoa Física não realizado! Já existe uma Pessoa Física com este cpf!"); 
            }
            else
            { dm_pfisica.incluir(this); }
        }
    }   

	//método consultar
    public void consultar(PFisica objPF)
    {   if (objPF.getCpf().equals(""))
        {   JOptionPane.showMessageDialog(null,"CPF deve ser informado!","Mensagem de alerta",JOptionPane.WARNING_MESSAGE);
            System.out.println("CPF deve ser informado!");
        }
        else        	        	
        {   objPF = (PFisica) dm_pfisica.consultar(this);
        	if (objPF != null)
            {   JOptionPane.showMessageDialog(null,"CPF localizado!","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
                System.out.println("CPF localizado!"); 
            }
            else
            {   JOptionPane.showMessageDialog(null,"CPF não localizado!","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
                System.out.println("CPF não localizado!");            
            }
        }    
    }   

	//método atualizar
    public void atualizar(PFisica objPF)
    {   if (objPF.getCpf().equals(""))
        {   JOptionPane.showMessageDialog(null,"CPF deve ser informado!","Mensagem de alerta",JOptionPane.WARNING_MESSAGE);
            System.out.println("Método Atualizar - CPF deve ser informado!");
        }
        else        	        	
        {   objPF = (PFisica) dm_pfisica.buscar(objPF.getCpf());
        	if (objPF != null)
            {   dm_pfisica.alterar(this);
        		JOptionPane.showMessageDialog(null,"Atualização concluída!","Mensagem de Erro",JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Atualização concluída!"); 
            }
            else
            {   JOptionPane.showMessageDialog(null,"CPF não localizado!","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
                System.out.println("CPF não localizado!");            
            }
        }    
    }

	//método atualizar
    public void excluir(PFisica objPF)
    {   if (objPF.getCpf().equals(""))
        {   JOptionPane.showMessageDialog(null,"CPF deve ser informado!","Mensagem de alerta",JOptionPane.WARNING_MESSAGE);
            System.out.println("Método Excluir - CPF deve ser informado!");
        }
        else        	        	
        {   objPF = (PFisica) dm_pfisica.buscar(objPF.getCpf());
        	if (objPF != null)
            {   
        		dm_pfisica.excluir(this);
        		JOptionPane.showMessageDialog(null,"Exclusão concluída!","Mensagem de Erro",JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Exclusão concluída!"); 
            }
            else
            {   JOptionPane.showMessageDialog(null,"CPF não localizado!","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
                System.out.println("CPF não localizado!");            
            }
        }    
    }
        
}
