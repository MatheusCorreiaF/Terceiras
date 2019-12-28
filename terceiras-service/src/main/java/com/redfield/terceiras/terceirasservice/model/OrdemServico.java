package com.redfield.terceiras.terceirasservice.model;

public class OrdemServico {

	private Long id;
	private String servico;
	private Long uc;//unidade consumidora
	private Terceira terceira;//cnpj
	private String status;
	private String obs;
	
	public OrdemServico() {
		super();
	}

	public OrdemServico(long id, String servico, Long uc, Terceira terceira, String status, String obs) {
		super();
		this.id = id;
		this.servico = servico;
		this.uc = uc;
		this.terceira = terceira;
		this.status = status;
		this.obs = obs;
	}

	public final long getId() {
		return id;
	}

	public final void setId(long id) {
		this.id = id;
	}

	public final String getServico() {
		return servico;
	}

	public final void setServico(String servico) {
		this.servico = servico;
	}

	public final Long getUc() {
		return uc;
	}

	public final void setUc(Long uc) {
		this.uc = uc;
	}

	public final Terceira getTerceira() {
		return terceira;
	}

	public final void setTerceira(Terceira terceira) {
		this.terceira = terceira;
	}

	public final String getStatus() {
		return status;
	}

	public final void setStatus(String status) {
		this.status = status;
	}

	public final String getObs() {
		return obs;
	}

	public final void setObs(String obs) {
		this.obs = obs;
	}
}
