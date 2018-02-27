package com.feliz.dslrexpolib.models.json;

import java.io.Serializable;
import java.util.Arrays;

public class EVArray implements Serializable {

	private static final long serialVersionUID = 2923820185247467912L;

	private EVElement[] evElements;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(evElements);
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
		EVArray other = (EVArray) obj;
		if (!Arrays.equals(evElements, other.evElements))
			return false;
		return true;
	}

	public EVElement[] getEvElements() {
		return evElements;
	}

}
