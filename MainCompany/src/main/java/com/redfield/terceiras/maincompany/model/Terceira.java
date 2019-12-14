package com.redfield.terceiras.maincompany.model;

public class Terceira
{
	private String cnpj;
	private String razaoSocial;
	
	public Terceira() {
		super();
	}

	public Terceira(String cnpj, String razaoSocial) {
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
