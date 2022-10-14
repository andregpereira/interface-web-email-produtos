package com.bios.sprint03.interfacewebemailprodutos.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class Email implements Serializable {

	private static final long serialVersionUID = 1593341441885625168L;

	/**
	 * {"chave":"TCHAU2", "remetente":"noreply@meudominio.com.br",
	 * "destinatarios":["king.kong.2000.test@gmail.com"],
	 * "destinatariosCopia":["king.kong.2000.test@gmail.com"],
	 * "dados":{"ADEUS":"Adeus","NOME":"King"}, "id":"63374792b359626cf4dab5c9",
	 * "assuntoEmail":"Adeus", "corpoEmail":"
	 * <p>
	 * Adeus, King!
	 * </p>
	 * ", "dataEnvio":"2022-09-30T16:46:23.935", "enviadoComSucesso":true}
	 */

	private String id;
	private String chave;
	private String remetente;
	private List<String> destinatarios;
	private List<String> destinatariosCopia;
	private HashMap<String, String> dados;
	private String assuntoEmail;
	private String corpoEmail;
	private String dataEnvio;
	private boolean enviadoComSucesso;

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	public List<String> getDestinatarios() {
		return destinatarios;
	}

	public void setDestinatarios(List<String> destinatarios) {
		this.destinatarios = destinatarios;
	}

	public List<String> getDestinatariosCopia() {
		return destinatariosCopia;
	}

	public void setDestinatariosCopia(List<String> destinatariosCopia) {
		this.destinatariosCopia = destinatariosCopia;
	}

	public HashMap<String, String> getDados() {
		return dados;
	}

	public void setDados(HashMap<String, String> dados) {
		this.dados = dados;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAssuntoEmail() {
		return assuntoEmail;
	}

	public void setAssuntoEmail(String assuntoEmail) {
		this.assuntoEmail = assuntoEmail;
	}

	public String getCorpoEmail() {
		return corpoEmail;
	}

	public void setCorpoEmail(String corpoEmail) {
		this.corpoEmail = corpoEmail;
	}

	public String getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(String dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public boolean isEnviadoComSucesso() {
		return enviadoComSucesso;
	}

	public void setEnviadoComSucesso(boolean enviadoComSucesso) {
		this.enviadoComSucesso = enviadoComSucesso;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
