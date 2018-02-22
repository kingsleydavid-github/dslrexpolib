package com.feliz.dslrexpolib.models;

import com.feliz.dslrexpolib.models.priority.Priorotizable;
import com.feliz.dslrexpolib.utils.ExpoUtil;

public class Exposure {
	
	private final Long eValue;
	private final Aperture aperture;
	private final ShutterSpeed shutterSpeed;
	private final ISOFilm isoFilm;

	public static class ManualPriority implements Priorotizable
	{
		private Long eValue;
		private Aperture aperture;
		private ShutterSpeed shutterSpeed;
		private ISOFilm isoFilm;
		
		public ManualPriority aperture(Double value)
		{
			this.aperture = new Aperture(value);
			return this;
		}
		public ManualPriority shutterSpeed(Double value)
		{
			this.shutterSpeed = new ShutterSpeed(value);
			return this;
		}
		public ManualPriority isoFilm(Long value)
		{
			this.isoFilm = new ISOFilm(value);
			return this;
		}
		public ManualPriority eValue(Long value)
		{
			this.eValue = new Long(value);
			return this;
		}
		
		public Exposure setExposure()
		{
			return new Exposure(this);
		}
		
		@Override
		public Long getExposureValue(Exposure evalues) {
			return ExpoUtil.calculateExposure(evalues.getAperture(), evalues.getShutterSpeed(), evalues.getIsoFilm());

		}
		
	}
	
	public Long geteValue() {
		return eValue;
	}

	public Aperture getAperture() {
		return aperture;
	}

	public ShutterSpeed getShutterSpeed() {
		return shutterSpeed;
	}

	public ISOFilm getIsoFilm() {
		return isoFilm;
	}

	public Exposure(ManualPriority priority)
	{
		this.eValue = priority.eValue;
		this.aperture = priority.aperture;
		this.shutterSpeed = priority.shutterSpeed;
		this.isoFilm = priority.isoFilm;
	}

	public Long getExposure(Double aperture, Double ss, Integer iso) {
		return eValue;
	}
}
