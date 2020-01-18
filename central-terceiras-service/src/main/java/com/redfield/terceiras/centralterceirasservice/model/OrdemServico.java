package com.redfield.terceiras.centralterceirasservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class OrdemServico {

	@Id
	private Long id;
	@NotNull(message = "Serviço é obrigatório")
	@Length(min = 10, message = "O tamanho deve ter 10 caracteres no mínimo")
	private String servico;
	@Column(name = "unidade_consumidora")
	@NotNull(message = "Unidade Consumidora é obrigatória")
	private Long uc;// unidade consumidora
	@ManyToOne
	private Terceira terceira;// cnpj
	private String status;
	private String obs;

	public OrdemServico() {
		super();
	}

	public OrdemServico(Long id,
			@NotNull(message = "Serviço é obrigatório") @Length(min = 10, message = "O tamanho deve ter 10 caracteres no mínimo") String servico,
			@NotNull(message = "Unidade Consumidora é obrigatória") Long uc, Terceira terceira, String status,
			String obs) {
		super();
		this.id = id;
		this.servico = servico;
		this.uc = uc;
		this.terceira = terceira;
		this.status = status;
		this.obs = obs;
	}

	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
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
