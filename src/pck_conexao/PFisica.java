package pck_conexao;

import javax.swing.JOptionPane;

import pck_conexao.PFisica;
import pck_persistencia.DMPFisica;

public class PFisica {

	private String cpf;
	private String nome;
	private String email;
	
	//atributo de refer�ncia para conex�o com banco de dados
	private DMPFisica dm_pfisica;

	
	//m�todo construtor 1
	public PFisica()
	{	}
	
	//m�todo construtor2
	public PFisica(String cpf, String nome, String email)
	{ 	this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		dm_pfisica = new DMPFisica();
		
		//Fazer a Conexao com o BD
		dm_pfisica.conectaDataBase("db_agenda","root","mysql");
	   	
	   	System.out.println("Conex�o feita � tabela Pfisicas com sucesso!");
	
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

	//m�todo incluir
    public void incluir(PFisica objPF)
    {   if (objPF.getCpf().equals(""))
        {   JOptionPane.showMessageDialog(null,"O cpf da Pessoa F�sica � obrigat�rio!","Mensagem de alerta",JOptionPane.WARNING_MESSAGE);
            System.out.println("O cpf da Pessoa F�sica � obrigat�rio!");
        }
        else
        {   if (dm_pfisica.consultar(this)!= null)
            {   JOptionPane.showMessageDialog(null,"Cadastro de Pessoa F�sica n�o realizado!\n J� existe uma Pessoa F�sica com este cpf!","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
                System.out.println("Cadastro de Pessoa F�sica n�o realizado! J� existe uma Pessoa F�sica com este cpf!"); 
            }
            else
            { dm_pfisica.incluir(this); }
        }
    }   

	//m�todo consultar
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
            {   JOptionPane.showMessageDialog(null,"CPF n�o localizado!","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
                System.out.println("CPF n�o localizado!");            
            }
        }    
    }   

	//m�todo atualizar
    public void atualizar(PFisica objPF)
    {   if (objPF.getCpf().equals(""))
        {   JOptionPane.showMessageDialog(null,"CPF deve ser informado!","Mensagem de alerta",JOptionPane.WARNING_MESSAGE);
            System.out.println("M�todo Atualizar - CPF deve ser informado!");
        }
        else        	        	
        {   objPF = (PFisica) dm_pfisica.buscar(objPF.getCpf());
        	if (objPF != null)
            {   dm_pfisica.alterar(this);
        		JOptionPane.showMessageDialog(null,"Atualiza��o conclu�da!","Mensagem de Erro",JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Atualiza��o conclu�da!"); 
            }
            else
            {   JOptionPane.showMessageDialog(null,"CPF n�o localizado!","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
                System.out.println("CPF n�o localizado!");            
            }
        }    
    }

	//m�todo atualizar
    public void excluir(PFisica objPF)
    {   if (objPF.getCpf().equals(""))
        {   JOptionPane.showMessageDialog(null,"CPF deve ser informado!","Mensagem de alerta",JOptionPane.WARNING_MESSAGE);
            System.out.println("M�todo Excluir - CPF deve ser informado!");
        }
        else        	        	
        {   objPF = (PFisica) dm_pfisica.buscar(objPF.getCpf());
        	if (objPF != null)
            {   
        		dm_pfisica.excluir(this);
        		JOptionPane.showMessageDialog(null,"Exclus�o conclu�da!","Mensagem de Erro",JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Exclus�o conclu�da!"); 
            }
            else
            {   JOptionPane.showMessageDialog(null,"CPF n�o localizado!","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
                System.out.println("CPF n�o localizado!");            
            }
        }    
    }
        
}
