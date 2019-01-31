package com.demo.web.bean;

import java.io.Serializable;


public class Weather implements Serializable {

	private static final long serialVersionUID = 1L;


	private String siteid;
	private String humidity;
	private String temperature;
	private String windspeed;
	
	public Weather(String siteid, String humidity, String temperature,
			 String windspeed, String createdate) {
		super();
		this.siteid = siteid;
		this.humidity = humidity;
		this.temperature = temperature;
		this.windspeed = windspeed;
		this.createdate = createdate;
	}
	public Weather() {
		super();
		
	}


	
	private String createdate;
	

	public String getSiteid() {
		return siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getWindspeed() {
		return windspeed;
	}

	public void setWindspeed(String windspeed) {
		this.windspeed = windspeed;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	@Override
	public String toString() {
		return "Weather [siteid=" + siteid + ", humidity=" + humidity + ", temperature="
				+ temperature + "]";
	}
	
}
