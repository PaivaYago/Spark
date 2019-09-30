package com.mba.bigdata.entity;

public class ArquivoCrime {
	
	
	private Integer fmun_cod;
	private String fmun;
	private Integer vano;
	private Integer mes;
	private String mes_ano;
	private String regiao;
	private Integer hom_doloso;
	private Integer tentat_hom;
	private Integer hom_culposo;
	

	public ArquivoCrime() {
		
	}


	public ArquivoCrime(Integer fmun_cod, String fmun, Integer vano, Integer mes, String mes_ano, String regiao,
			Integer hom_doloso, Integer tentat_hom, Integer hom_culposo) {
		super();
		this.fmun_cod = fmun_cod;
		this.fmun = fmun;
		this.vano = vano;
		this.mes = mes;
		this.mes_ano = mes_ano;
		this.regiao = regiao;
		this.hom_doloso = hom_doloso;
		this.tentat_hom = tentat_hom;
		this.hom_culposo = hom_culposo;
	}


	public Integer getFmun_cod() {
		return fmun_cod;
	}


	public void setFmun_cod(Integer fmun_cod) {
		this.fmun_cod = fmun_cod;
	}


	public String getFmun() {
		return fmun;
	}


	public void setFmun(String fmun) {
		this.fmun = fmun;
	}


	public Integer getVano() {
		return vano;
	}


	public void setVano(Integer vano) {
		this.vano = vano;
	}


	public Integer getMes() {
		return mes;
	}


	public void setMes(Integer mes) {
		this.mes = mes;
	}


	public String getMes_ano() {
		return mes_ano;
	}


	public void setMes_ano(String mes_ano) {
		this.mes_ano = mes_ano;
	}


	public String getRegiao() {
		return regiao;
	}


	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}


	public Integer getHom_doloso() {
		return hom_doloso;
	}


	public void setHom_doloso(Integer hom_doloso) {
		this.hom_doloso = hom_doloso;
	}


	public Integer getTentat_hom() {
		return tentat_hom;
	}


	public void setTentat_hom(Integer tentat_hom) {
		this.tentat_hom = tentat_hom;
	}


	public Integer getHom_culposo() {
		return hom_culposo;
	}


	public void setHom_culposo(Integer hom_culposo) {
		this.hom_culposo = hom_culposo;
	}

	

}
