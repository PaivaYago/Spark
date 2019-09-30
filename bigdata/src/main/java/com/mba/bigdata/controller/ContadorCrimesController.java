package com.mba.bigdata.controller;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mba.bigdata.entity.ArquivoCrime;
import com.mba.bigdata.service.ContadorCrimesService;

@RestController
@RequestMapping(value="/")
public class ContadorCrimesController {

	@Autowired
	private ContadorCrimesService service;

	@RequestMapping(value = "byMunicipio", method = RequestMethod.GET)
	public Collection<ArquivoCrime> byMunicipio(@RequestParam("municipio") String municipio) {

		return service.getByMunicipio(municipio);

	}
	
	@RequestMapping(value = "byAnoMaxHomDoloso", method = RequestMethod.GET)
	public Collection<ArquivoCrime> byAnoMaxHomDoloso(@RequestParam("ano") Integer ano) {

		return service.getByAnoMaxHomDoloso(ano);

	}

}
