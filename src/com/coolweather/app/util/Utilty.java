package com.coolweather.app.util;

import android.text.TextUtils;

import com.coolweather.app.db.CoolWeatherDB;
import com.coolweather.app.model.City;
import com.coolweather.app.model.County;
import com.coolweather.app.model.Province;

public class Utilty {
	/**
	 * �����ʹ�����������ص�ʡ������
	 */
	public synchronized static boolean headleProvincesResponse(CoolWeatherDB coolWeatherDB,String responce){
		if(!TextUtils.isEmpty(responce)){
			String[] allProvinces=responce.split(",");
			if(allProvinces!=null&&allProvinces.length>0){
				for(String p:allProvinces){
					String[] array=p.split("\\|");
					Province province=new Province();
					province.setProvinceCode(array[0]);
					province.setProvinceName(array[1]);
					//���������������ݴ洢����
					coolWeatherDB.saveProvince(province);
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * �����ʹ�����������ص��м�����
	 */
	public synchronized static boolean headleCitiesResponse(CoolWeatherDB coolWeatherDB,String responce,int provinceId){
		if(!TextUtils.isEmpty(responce)){
			String[] allCities=responce.split(",");
			if(allCities!=null&&allCities.length>0){
				for(String c:allCities){
					String[] array=c.split("\\|");
					City city=new City();
					city.setCityCode(array[0]);
					city.setCityName(array[1]);
					city.setProvinceId(provinceId);
					
					//���������������ݴ洢����
					coolWeatherDB.saveCity(city);
				}
				return true;
			}
		}
		return false;
	}	
	
	/**
	 * �����ʹ�����������ص��ؼ�����
	 */
	public synchronized static boolean headleCountiesResponse(CoolWeatherDB coolWeatherDB,String responce,int cityId){
		if(!TextUtils.isEmpty(responce)){
			String[] allCounties=responce.split(",");
			if(allCounties!=null&&allCounties.length>0){
				for(String c:allCounties){
					String[] array=c.split("\\|");
					County county=new County();
					county.setCountyCode(array[0]);
					county.setCountyName(array[1]);
					county.setCityId(cityId);
					
					//���������������ݴ洢����
					coolWeatherDB.saveCounty(county);
				}
				return true;
			}
		}
		return false;
	}		
	
}
