package com.feliz.dslrexpolib.models.json;

import java.io.Serializable;
import java.util.Map;

import org.json.simple.JSONObject;

public class EVLightingCategoryMap implements Serializable {

	private static final long serialVersionUID = 9086801224544487789L;

	private JSONObject lightingCategory;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lightingCategory == null) ? 0 : lightingCategory.hashCode());
		return result;
	}

	public JSONObject getLightingCategory() {
		return lightingCategory;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EVLightingCategoryMap other = (EVLightingCategoryMap) obj;
		if (lightingCategory == null) {
			if (other.lightingCategory != null)
				return false;
		} else if (!lightingCategory.equals(other.lightingCategory))
			return false;
		return true;
	}

}
