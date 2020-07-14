package com.projeto.contact.service.dto;

import com.sun.istack.NotNull;

public class ContactUpdateDTO {

	@NotNull
	private String name;
	
	@NotNull
	private String channel;
	
	@NotNull
	private String value;
	
	private String obs;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}
	
}
