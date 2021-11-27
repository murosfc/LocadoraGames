package objetos;

import javax.swing.table.DefaultTableModel;

import manipularDB.DBJogo;

public class Jogo {
	private String sku, titulo, imgurl;
	private float valor;
	private int idJogo, idPlat;
	private DBJogo AtribRefDBJogo;
	
	public Jogo(int idJogo, String sku, String titulo, String url, float valor, int idPlat)
	{
		this.idJogo = idJogo;
		this.sku = sku;
		this.titulo = titulo;
		this.imgurl = url;
		this.valor = valor;
		this.idPlat = idPlat;		
		
		AtribRefDBJogo = new DBJogo();	
		AtribRefDBJogo.conectarDB();
	}	

	//métodos de construção
	public Jogo()
	{
		AtribRefDBJogo = new DBJogo();
		AtribRefDBJogo.conectarDB();
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public String getSku() {
		return sku;
	}
	
	//métodos de acesso
	public int getIdJogo() {
		return idJogo;
	}

	public void setIdJogo(int idJogo) {
		this.idJogo = idJogo;
	}
	
	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public int getIdPlat() {
		return idPlat;
	}

	public void setIdPlat(int idPlat) {
		this.idPlat = idPlat;
	}
	
	//outros métodos
	public boolean listarBD(String tipo, DefaultTableModel tabela, String busca) {		
		return AtribRefDBJogo.listarBD(tipo, tabela, busca);
	
	}
	
	public void listarDB(String tipo, DefaultTableModel tabela, int id)
	{
		AtribRefDBJogo.listarBD(tipo, tabela, id);
	}
	
	public void incluirDB() {
		AtribRefDBJogo.incluirDB(this);
	}
	
	public void atualizarDB() {
		AtribRefDBJogo.atualizarDB(this);
	}
	
	public int getId() {
		return AtribRefDBJogo.getId(this);
	}
	
	public void getJogoFromDB(int id) {
		this.idJogo = id;
		AtribRefDBJogo.getJogoFromDB(this);		
	}

}

