package com.tds171a.soboru.models.medida;

import java.util.Date;

/**
 * Classe de ValueObject da Medida
 * @author Diogo
 *
 */
public class Medida {

	/**
	 * Par�metro id da Medida
	 */
	private int id;

	/**
	 * Par�metro nome da Medida
	 */
	private String nome;

	/**
	 * Par�metro abreviacao da Medida
	 */
	private String abreviacao;

	private Date CreatedAt;
	private Date UpdatedAt;
	private Date DeletedAt;

	/**
	 * Construtor da classe de Medida
	 */
	public Medida() {
	    id = -1;
	    nome = "";
	    abreviacao = "";
	}

	/**
	 * Construtor da classe de Medida que recebe o nome e a abreviacao
	 * @param nome
	 * @param abreviacao
	 */
	public Medida(String nome, String abreviacao) {
		this.nome = nome;
		this.abreviacao = abreviacao;
	}

	/**
	 * Construtor da classe de Medida que recebe o id, nome e abreviacao
	 * @param id
	 * @param nome
	 * @param abreviacao
	 */
	public Medida(int id, String nome, String abreviacao) {
		this.id = id;
		this.nome = nome;
		this.abreviacao = abreviacao;
	}

	/**
	 * @return o id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id o id para setar
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return o nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome o nome para setar
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return o abreviacao
	 */
	public String getAbreviacao() {
		return abreviacao;
	}

	/**
	 * @param abreviacao a abreviacao para setar
	 */
	public void setAbreviacao(String abreviacao) {
		this.abreviacao = abreviacao;
	}

	public Date getCreatedAt() {
		return CreatedAt;
	}

	public void setCreatedAt(Date createdAt) {
		CreatedAt = createdAt;
	}

	public Date getUpdatedAt() {
		return UpdatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		UpdatedAt = updatedAt;
	}

	public Date getDeletedAt() {
		return DeletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		DeletedAt = deletedAt;
	}
}
