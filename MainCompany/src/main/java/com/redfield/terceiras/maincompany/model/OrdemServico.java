package com.redfield.terceiras.maincompany.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class OrdemServico {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull(message = "Serviço é obrigatório")
	@Length(min=10, message = "O tamanho deve ter 15 caracteres no mínimo")
	private String servico;
	@Column(name = "unidade_consumidora")
	@NotNull(message = "Unidade Consumidora é obrigatória")
	private Long uc;//unidade consumidora
	private String terceira;//cnpj
	private String status;
	private String obs;
	
	public OrdemServico() {
		super();
	}

	public OrdemServico(long id,
			@Length(min = 10, message = "O tamanho deve ter 15 caracteres no mínimo") String servico, Long uc,
			String terceira, String status, String obs) {
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

	public final String getTerceira() {
		return terceira;
	}

	public final void setTerceira(String terceira) {
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
