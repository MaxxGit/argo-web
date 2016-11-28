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
@Table(name = "objects_actions")
public class Activity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
    @Column(name = "IDACTIVITY")
	private Long idActivity;

	@ManyToOne
	@JoinColumn(name = "IDPROCESS")
	private Job job;

	@Column(name = "DAYOFWEEK")
	private Long dayOfWeek = 0L;

	@Column(name = "STARTHOUR")
	private Long startHour = 0L;

	@Column(name = "ENDHOUR")
	private Long endHour = 0L;

	public Long getIdActivity() {
		return idActivity;
	}

	public Long getDayOfWeek() {
		return dayOfWeek;
	}

	public Long getStartHour() {
		return startHour;
	}

	public Long getEndHour() {
		return endHour;
	}

	public Job getJob() {
		return job;
	}
}
