package com.coolweather.app.model;

public class Province {
	private int id;
	private String provinceName;
	private String provinceCode;
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	
	public String getProvinceName(){
		return provinceName;
	}
	public void setProvinceName(String ProvinceName){
		this.provinceName=ProvinceName;
	}
	
	public String getProvinceCode(){
		return provinceCode;
	}
	public void setProvinceCode(String ProvinceCode){
		this.provinceCode=ProvinceCode;
	}	
}
