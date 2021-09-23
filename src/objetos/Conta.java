package objetos;

public class Conta {
	private String email;
	private String senha;
	private Jogo AtribRefJogo;
	
	public Conta(String mail, String pass, Jogo objJogo)
	{
		email=mail;
		senha=pass;
		AtribRefJogo=objJogo;
	}
}
