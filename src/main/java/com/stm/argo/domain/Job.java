/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.stm.argo.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "objects")
public class Job implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(name = "descr", length = 500)
	private String description;

	@Column
	@Enumerated(EnumType.STRING)
	private Tipo tipo;

	@Column
	@Enumerated(EnumType.STRING)
	private Categoria categoria;

	@Column
	private Long csc;

	@Column
	private Long idp;

	@Column
	private Long polling;

	@Column
	private Long working;

	@Column(name = "calctype")
	private CalcType calcType;

	@Column
	private String menu;

	@Column
	private String icon;

	@Column(name = "paramstring", length = 1000)
	private String parameters;

	@Column(name = "PROXYDISPATCH")
	private String proxyDispatch;

	@Column
	private String dispatch;

	@Column
	private Long report;

	@Column
	private String status;

	@Column
	private Long pd;


	protected Job() {
	}

	public enum Tipo {
		container,
		controller;
	}

	public enum Categoria {
		container,
		application,
		device,
		service;
	}

	public enum CalcType {
		best,
		worse,
		compound;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescription() {
		return description;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Long getCsc() {
		return csc;
	}

	public Long getIdp() {
		return idp;
	}

	public Long getPolling() {
		return polling;
	}

	public Long getWorking() {
		return working;
	}

	public CalcType getCalcType() {
		return calcType;
	}

	public String getMenu() {
		return menu;
	}

	public String getIcon() {
		return icon;
	}

	public String getParameters() {
		return parameters;
	}

	public String getProxyDispatch() {
		return proxyDispatch;
	}

	public String getDispatch() {
		return dispatch;
	}

	public Long getReport() {
		return report;
	}

	public String getStatus() {
		return status;
	}

	public Long getPd() {
		return pd;
	}



	@Override
	public String toString() {
		return nome + "," + categoria + "," + tipo;
	}
}
