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

package com.stm.argo.web;

import com.stm.argo.service.CityService;

import com.stm.argo.service.ArgoCscService;
import com.stm.argo.service.ArgoJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArgoController {

	@Autowired
	private CityService cityService;

	@Autowired
	private ArgoCscService cscService;

	@Autowired
	private ArgoJobService jobService;

	@GetMapping("/")
	@ResponseBody
	@Transactional(readOnly = true)
	public String helloWorld() {
		return this.cityService.getCity("Bath", "UK").getName();
	}

	@RequestMapping("/city")
	public String city(@RequestParam(value="name", required=false, defaultValue="Bath") String name, @RequestParam(value="country", required=false, defaultValue="UK") String country, Model model) {
		model.addAttribute("name", this.cityService.getCity(name, country).getName());
		return "city";
	}

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	@RequestMapping("/csc")
	public String csc(@RequestParam(value="name", required=false) String name, Model model) {
		model.addAttribute("csclist", cscService.findAllCsc());
		return "csc";
	}

	@RequestMapping("/job")
	public String job(@RequestParam(value="id", required=false) Long id, Model model) {
		if (null != id) {
			model.addAttribute("jobs", jobService.findById(id));
		} else {
			model.addAttribute("jobs", jobService.findAllJobs());
		}
		return "job";
	}

}
