package com.tds171a.soboru.DAO.usuario;

import java.util.Date;

public class Usuario {

    private int     id;
    private String  login;
    private String  senha;
    private String  nome;
    private Date    nasc;
    private int     sexo;
    private boolean notoficacao_email;

    private Usuario(){}

    public Usuario(String login, String senha){
        this.id    = id;
        this.login = login;
        this.senha = senha;
    }

    public Usuario(String login, String senha, String nome, Date nasc, int sexo, boolean notoficacao_email) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.nasc = nasc;
        this.sexo = sexo;
        this.notoficacao_email = notoficacao_email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNasc() {
        return nasc;
    }

    public void setNasc(Date nasc) {
        this.nasc = nasc;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public boolean isNotoficacao_email() {
        return notoficacao_email;
    }

    public void setNotoficacao_email(boolean notoficacao_email) {
        this.notoficacao_email = notoficacao_email;
    }
}
