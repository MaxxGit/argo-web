/*
 * Copyright 2012-2016 the original author or authors.
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

package com.stm.argo.service;

import com.stm.argo.domain.ArgoCsc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

@Component("cscService")
@Transactional
class CscServiceImpl implements CscService {

	private final CscRepository cscRepository;


	public CscServiceImpl(CscRepository cscRepository) {
		this.cscRepository = cscRepository;
	}

	@Override
	public Page<ArgoCsc> findCscByCriteria(CscSearchCriteria criteria, Pageable pageable) {

		Assert.notNull(criteria, "Criteria must not be null");
		String name = criteria.getName();

		if (!StringUtils.hasLength(name)) {
			return this.cscRepository.findAll(null);
		}

		return this.cscRepository
				.findByNick( name, pageable);
	}

	@Override
	public Page<ArgoCsc> findAllCsc() {

		return this.cscRepository.findAll(null);
	}

}
