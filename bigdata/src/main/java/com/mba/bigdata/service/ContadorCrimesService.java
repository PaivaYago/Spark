package com.mba.bigdata.service;

import java.util.Collection;


import com.mba.bigdata.entity.ArquivoCrime;


public interface ContadorCrimesService {
    
    public Collection<ArquivoCrime> getByMunicipio(String municipio);
	
    public Collection<ArquivoCrime> getByAnoMaxHomDoloso(Integer ano);
    
}
