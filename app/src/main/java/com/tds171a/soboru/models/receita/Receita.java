package com.tds171a.soboru.models.receita;

import com.tds171a.soboru.models.categoria.Categoria;
import com.tds171a.soboru.models.comentario.Comentario;
import com.tds171a.soboru.models.pontuacao.Pontuacao;
import com.tds171a.soboru.models.receitaIngrediente.ReceitaIngrediente;
import com.tds171a.soboru.models.utensilio.Utensilio;
import com.tds171a.soboru.models.usuario.Usuario;

import java.util.List;

public class Receita {


	private int id;
	private String nome;
	private int categoriaId;
	private int usuarioId;
	private Integer porcao;
	private Double tempoPreparo;
	private String modoPreparo;
	private String imgPath;
	private double pontuacaoMedia;
	private int views;
	private int favs;
	private String slug;
	private boolean aprovado;
	private boolean pontuou;
	
	/**
	 * 
	 */
	private Categoria categoria;
	
	/**
	 * 
	 */
	private Usuario usuario;
	
	/**
	 * 
	 */
	private List<Utensilio> utensilios;

	/**
	 * 
	 */
	private List<ReceitaIngrediente> receitaIngredientes;
	
	/**
	 * 
	 */
	private List<Comentario> comentarios;

	/**
	 * 
	 */
	private List<Pontuacao> pontuacoes;
	
	/**
	 * 
	 */
	private List<Usuario> usuariosFavoritaram;
	
	private int numComentarios;
	
	public Receita() {
		this.id = -1;
		this.nome = "";
		this.categoriaId = -1;
		this.usuarioId = -1;
		this.porcao = null;
		this.tempoPreparo = null;
		this.modoPreparo = "";
		this.imgPath = "";
		this.pontuacaoMedia = 0;
		this.views = 0;
		this.favs = 0;
		this.slug = "";
		this.aprovado = false;

		this.setPontuou(false);
		
		this.categoria = null;
		this.usuario = null;
		
		this.utensilios = null;
		this.receitaIngredientes = null;
		this.comentarios = null;
		this.pontuacoes = null;
		this.usuariosFavoritaram = null;
		
		this.numComentarios = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(int categoriaId) {
		this.categoriaId = categoriaId;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Integer getPorcao() {
		return porcao;
	}

	public void setPorcao(Integer porcao) {
		this.porcao = porcao;
	}

	public Double getTempoPreparo() {
		return tempoPreparo;
	}

	public void setTempoPreparo(Double tempoPreparo) {
		this.tempoPreparo = tempoPreparo;
	}

	public String getModoPreparo() {
		return modoPreparo;
	}

	public void setModoPreparo(String modoPreparo) {
		this.modoPreparo = modoPreparo;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public double getPontuacaoMedia() {
		return pontuacaoMedia;
	}

	public void setPontuacaoMedia(double pontuacaoMedia) {
		this.pontuacaoMedia = pontuacaoMedia;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getFavs() {
		return favs;
	}

	public void setFavs(int favs) {
		this.favs = favs;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public boolean isAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	public boolean isPontuou() {
		return pontuou;
	}

	public void setPontuou(boolean pontuou) {
		this.pontuou = pontuou;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Utensilio> getUtensilios() {
		return utensilios;
	}

	public void setUtensilios(List<Utensilio> utensilios) {
		this.utensilios = utensilios;
	}

	public List<ReceitaIngrediente> getReceitaIngredientes() {
		return receitaIngredientes;
	}

	public void setReceitaIngredientes(List<ReceitaIngrediente> receitaIngredientes) {
		this.receitaIngredientes = receitaIngredientes;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public List<Pontuacao> getPontuacoes() {
		return pontuacoes;
	}

	public void setPontuacoes(List<Pontuacao> pontuacoes) {
		this.pontuacoes = pontuacoes;
	}

	public List<Usuario> getUsuariosFavoritaram() {
		return usuariosFavoritaram;
	}

	public void setUsuariosFavoritaram(List<Usuario> usuariosFavoritaram) {
		this.usuariosFavoritaram = usuariosFavoritaram;
	}

	public int getNumComentarios() {
		return numComentarios;
	}

	public void setNumComentarios(int numComentarios) {
		this.numComentarios = numComentarios;
	}
}
