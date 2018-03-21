package com.feliz.dslrexpolib.models.json;

import java.io.Serializable;
import java.util.Iterator;

import org.json.simple.JSONObject;

public class EVElement implements Serializable{

	private static final long serialVersionUID = 8991308900647206574L;
	
	private long ev;
	private String condition;
	private Double aperture;
	private Double shutterspeed;
	private JSONObject lightingCategory;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aperture == null) ? 0 : aperture.hashCode());
		result = prime * result + (int) (ev ^ (ev >>> 32));
		result = prime * result + ((shutterspeed == null) ? 0 : shutterspeed.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EVElement other = (EVElement) obj;
		if (aperture == null) {
			if (other.aperture != null)
				return false;
		} else if (!aperture.equals(other.aperture))
			return false;
		if (ev != other.ev)
			return false;
		if (shutterspeed == null) {
			if (other.shutterspeed != null)
				return false;
		} else if (!shutterspeed.equals(other.shutterspeed))
			return false;
		return true;
	}
	
	public String getCondition() {
		return condition;
	}

	public long getEv() {
		return ev;
	}

	public Double getAperture() {
		return aperture;
	}

	public Double getShutterspeed() {
		return shutterspeed;
	}

	public JSONObject getLightingCategory() {
		return lightingCategory;
	}
}
