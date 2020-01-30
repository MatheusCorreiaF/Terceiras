package com.redfield.terceiras.maincompany.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Endereco
{
	@NotNull(message = "Rua é obrigatório")
	private String rua;
	@NotNull(message = "Bairro é obrigatório")
	private String bairro;
	@NotNull(message = "Número é obrigatório")
	private String numero;
	private String cep;
	@NotNull(message = "Cidade é obrigatório")
	private String cidade;
	@NotNull(message = "Estado é obrigatório")
	private String estado;
		
	public Endereco() {
		super();
	}

	public Endereco(String rua, String bairro, String numero, String cep, String cidade, String estado) {
		super();
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
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

	public final String getCep() {
		return cep;
	}

	public final void setCep(String cep) {
		this.cep = cep;
	}
	
}