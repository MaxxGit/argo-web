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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Csc implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String nick;

	@Column(nullable = false, name = "descr")
	private String description;

	@Column(name = "params", length = 500)
	private String parameters;

	protected Csc() {
	}

	public Long getId() {
		return id;
	}

	public String getNick() {
		return nick;
	}

	public String getDescription() {
		return description;
	}

	public String getParameters() {
		return parameters;
	}

	@Override
	public String toString() {
		return nick + "," + description + "," + parameters;
	}
}
