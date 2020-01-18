package com.redfield.terceiras.centralterceirasservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Terceira
{
	@Id
	private String cnpj;
	@NotNull
	private String razaoSocial;
	
	public Terceira() {
		super();
	}

	public Terceira(String cnpj, @NotNull String razaoSocial) {
		super();
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
	}

	public final String getCnpj() {
		return cnpj;
	}

	public final void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public final String getRazaoSocial() {
		return razaoSocial;
	}

	public final void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
}
