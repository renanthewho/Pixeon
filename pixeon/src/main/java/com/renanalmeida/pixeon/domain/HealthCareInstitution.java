package com.renanalmeida.pixeon.domain;

import java.util.HashMap;
import java.util.Map;

public class HealthCareInstitution {
	
	private String cnpj;
	private String name;
	private static int pixeonCoins;
	
	public HealthCareInstitution(String cnpj, String name) {
		this.setCnpj(cnpj);
		this.setName(name);
	}
	
	public HealthCareInstitution() {}
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPixeonCoins() {
		return pixeonCoins;
	}
	public void setPixeonCoins(int pixeonCoins) {
		this.pixeonCoins = pixeonCoins;
	}
	
	
	public void atribuirPixeonCoins(){
		setPixeonCoins(20);
//		coins.put(cnpj, pixeonCoins);
	}
	
	public void debitarPixeonCoins() {
		if(pixeonCoins > 0) {
			pixeonCoins = getPixeonCoins() -1;
		}else {
			String saldo = "Saldo insuficiente.";
		}
	}
	
		public int consultarPixeonCoins(String cnpj) {
			
			return pixeonCoins;
		}
	
}
