package com.kratonsolution.dummy.wortel.data;

import java.util.UUID;
import java.util.Vector;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.1
 */
public class ProfesionalData {
	
	private String id = UUID.randomUUID().toString();
	
	private String name;
	
	private String sport;
	
	private boolean hasTag;
	
	private Vector<String> pictures = new Vector<>();
	
	private Vector<String> vidios = new Vector<String>();
	
	public ProfesionalData() {
		// TODO Auto-generated constructor stub
	}
	
	public ProfesionalData(String name, String sport) {
		
		this.name = name;
		this.sport = sport;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isHasTag() {
		return hasTag;
	}

	public void setHasTag(boolean hasTag) {
		this.hasTag = hasTag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public Vector<String> getPictures() {
		return pictures;
	}

	public void setPictures(Vector<String> pictures) {
		this.pictures = pictures;
	}

	public Vector<String> getVidios() {
		return vidios;
	}

	public void setVidios(Vector<String> vidios) {
		this.vidios = vidios;
	}
}
