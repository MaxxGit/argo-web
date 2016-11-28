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

package com.stm.argo.service;

import com.stm.argo.domain.City;
import com.stm.argo.domain.Csc;
import com.stm.argo.domain.HotelSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CscService {

	Page<Csc> findAllCsc();

	Page<Csc> findCscByCriteria(CscSearchCriteria criteria, Pageable pageable);

}
