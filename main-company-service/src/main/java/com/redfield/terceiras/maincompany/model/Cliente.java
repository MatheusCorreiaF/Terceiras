package com.redfield.terceiras.maincompany.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "unidade_consumidora")
	private Long uc;//unidade consumidora
	@Embedded
	@NotNull(message = "Endereço é obrigatório")
	private Endereco endereco;
	@NotNull(message = "CPF é obrigatório")
	private String cpf;
	@NotNull(message = "Nomeé obrigatório")
	private String nome;
	private String telefone;
	private String email;
	
	public Cliente() {
		super();
	}

	public Cliente(Long uc, Endereco endereco, String cpf, String nome, String telefone, String email) {
		super();
		this.uc = uc;
		this.endereco = endereco;
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}

	public final Long getUc() {
		return uc;
	}

	public final void setUc(Long uc) {
		this.uc = uc;
	}

	public final Endereco getEndereco() {
		return endereco;
	}

	public final void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
}
