package com.ibm.telefone.model;

public enum EnumTipoTelefone {
	
	CELULAR("Celular"), 
	FIXO("Fixo"), 
	EMPRESARIAL("Empresarial"), 
	FAX("Fax"); 
	
	public String tipo;
	
	private EnumTipoTelefone(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
		
	}
	
}
