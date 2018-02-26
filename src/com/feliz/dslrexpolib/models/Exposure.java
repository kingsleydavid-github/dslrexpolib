package com.feliz.dslrexpolib.models;

import com.feliz.dslrexpolib.utils.ExpoUtil;

/**
 * @author Kingsley.Davidj
 *
 *	This is a library to Calculate Exposure Value and to determine Exposure.
 *	This library can be used to calculate Photographic Exposure.
 *
 */
public class Exposure {
	
	private final Long eValue;
	private final Aperture aperture;
	private final ShutterSpeed shutterSpeed;
	private final ISOFilm isoFilm;

	public static class ManualPriority
	{
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

		public Exposure setExposure()
		{
			return new Exposure(this);
		}
	}
	
	public static class AutoPriority
	{
		// TODO: code for auto priority
	}
	
	public Long getValue() {
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

	/**
	 * This constructor expects a Manual Priority to calculate Exposure Value. 
	 * @param priority the type of priority (Manual / Auto / Aperture / Shutter) to calculate Exposure.
	 */
	public Exposure(ManualPriority priority)
	{
		this.aperture = priority.aperture;
		this.shutterSpeed = priority.shutterSpeed;
		this.isoFilm = priority.isoFilm;
		this.eValue = getExposure();
	}

	private Long getExposure() {
		return ExpoUtil.calculateManualExposureValue(this.aperture, this.shutterSpeed, this.isoFilm);
	}
}
