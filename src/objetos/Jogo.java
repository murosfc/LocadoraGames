package objetos;

import javax.swing.table.DefaultTableModel;

import manipularDB.DBJogo;

public class Jogo {
	private String sku, titulo, imgurl;
	private int idPlat;
	
	private DBJogo AtribRefDBJogo;
	
	public Jogo(String sku, String titulo, String url, int idPlat)
	{
		this.sku = sku;
		this.titulo = titulo;
		this.imgurl = url;
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

	public String getSku() {
		return sku;
	}
	
	//métodos de acesso
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
	

}

