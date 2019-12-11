package com.redfield.terceiras.maincompany.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long uc;//unidade consumidora
	private String cpf;
	private String nome;
	private String rua;
	private String bairro;
	private String numero;
	private String cidade;
	private String estado;
	private String telefone;
	private String email;
	private String status;//ativado/desativado
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(long uc, String cpf, String nome, String rua, String bairro, String numero, String cidade,
			String estado, String telefone, String email, String status) {
		super();
		this.uc = uc;
		this.cpf = cpf;
		this.nome = nome;
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.telefone = telefone;
		this.email = email;
		this.status = status;
	}
	public final long getUc() {
		return uc;
	}
	public final void setUc(long uc) {
		this.uc = uc;
	}
	public final String getCpf() {
		return cpf;
	}
	public final void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public final String getNome() {
		return nome;
	}
	public final void setNome(String nome) {
		this.nome = nome;
	}
	public final String getRua() {
		return rua;
	}
	public final void setRua(String rua) {
		this.rua = rua;
	}
	public final String getBairro() {
		return bairro;
	}
	public final void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public final String getNumero() {
		return numero;
	}
	public final void setNumero(String numero) {
		this.numero = numero;
	}
	public final String getCidade() {
		return cidade;
	}
	public final void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public final String getEstado() {
		return estado;
	}
	public final void setEstado(String estado) {
		this.estado = estado;
	}
	public final String getTelefone() {
		return telefone;
	}
	public final void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public final String getEmail() {
		return email;
	}
	public final void setEmail(String email) {
		this.email = email;
	}

	public final String getStatus() {
		return status;
	}

	public final void setStatus(String status) {
		this.status = status;
	}

	public final void setUc(Long uc) {
		this.uc = uc;
	}
	
	
}
