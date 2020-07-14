package com.projeto.contact.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Contact {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String channel;
	
	@NotNull
	private String value;
	
	private String obs;
	
	public Contact() {
		
	}
	
	public Contact(Integer id, @NotNull String name, @NotNull String channel, @NotNull String value, String obs) {
		this.id = id;
		this.name = name;
		this.channel = channel;
		this.value = value;
		this.obs = obs;
	}
	
	public Contact(@NotNull String name, @NotNull String channel, @NotNull String value, String obs) {
		this.name = name;
		this.channel = channel;
		this.value = value;
		this.obs = obs;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
