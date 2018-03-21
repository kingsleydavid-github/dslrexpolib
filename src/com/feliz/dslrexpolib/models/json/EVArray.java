package com.feliz.dslrexpolib.models.json;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;

import com.feliz.dslrexpolib.models.ExpConstants;
import com.feliz.dslrexpolib.models.Exposure;
import com.feliz.dslrexpolib.models.Exposure.ManualPriority;

public class EVArray implements Serializable, Iterable<EVElement> {

	private static final long serialVersionUID = 2923820185247467912L;

	private EVElement[] evElements;
	
	
	public EVArray(EVElement[] evElements)
	{
		this.evElements = evElements;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(evElements);
		return result;
	}
	
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
	
	public Exposure getExpoForEV(Long ev)
	{
		return getExposureByExposureValue(ev);
	}

	private Exposure getExposureByExposureValue(Long ev) {

		Exposure exp = null;
		Iterator<EVElement> it = this.iterator();
		while(it.hasNext())
		{
			EVElement elem = it.next();
			
			if(ev.equals(elem.getEv()))
			{
				Exposure.ManualPriority priority = new ManualPriority();
				priority.aperture(elem.getAperture()).shutterSpeed(elem.getShutterspeed()).isoFilm(ExpConstants.DEFAULT_ISO_VALUE);
				exp = new Exposure(priority);
			}
		}
		return exp;
	}

	public Iterator<EVElement> iterator() {
		
		return new Iterator<EVElement>() {

			private int currentIndex = 0;
			private int elemLength = evElements.length;
			public boolean hasNext() {
				return currentIndex < elemLength && evElements[currentIndex] != null;
			}
			public EVElement next() {
				return evElements[currentIndex++];
			}
		};
	}

}
