package com.tds171a.soboru.models.utensilio;

import java.util.Date;

/**
 * Classe de ValueObject do Utensilio
 * @author Diogo
 *
 */
public class Utensilio {

	/**
	 * Par�metro de id do Utensilio
	 */
	private int id;

	/**
	 * Par�metro de nome do Utensilio
	 */
	private String nome;
	private Date CreatedAt;
	private Date UpdatedAt;
	private Date DeletedAt;

	/**
	 * Construtor da classe de Utensilio
	 */
	public Utensilio() {

	    id = -1;
        nome = "";
	}

	/**
	 * Construtor da classe de Utensilio que recebe o nome
	 * @param nome
	 */
	public Utensilio(String nome) {
		this.nome = nome;
	}

	/**
	 * Construtor da classe de Utensilio que recebe a id e o nome
	 * @param id
	 * @param nome
	 */
	public Utensilio(int id, String nome) {
		this.id = id;
		this.nome = nome;
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
