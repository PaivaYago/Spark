package com.mba.bigdata.service;

import java.util.Collection;


import com.mba.bigdata.entity.ArquivoCrime;


public interface ContadorCrimesService {
	
//    public Map<String, Long> getCount(List<String> wordList);
    
    public Collection<ArquivoCrime> getByMunicipio(String municipio);
    
}
