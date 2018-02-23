package com.feliz.dslrexpolib.utils;

import com.feliz.dslrexpolib.models.Aperture;
import com.feliz.dslrexpolib.models.ExpConstants;
import com.feliz.dslrexpolib.models.ISOFilm;
import com.feliz.dslrexpolib.models.ShutterSpeed;

public class ExpoUtil {
	
	public static Long calculateExposure(Aperture aperture, ShutterSpeed shutterSpeed, ISOFilm isoFilm)
	{
		Long ev = null;
	
		if(isoFilm == null && isoFilm.getValue() == null)
		{
			isoFilm = new ISOFilm(ExpConstants.DEFAULT_ISO_VALUE);
		}
		
		double logBase = Double.parseDouble(String.valueOf(ExpConstants.DEFAULT_LOG_BASE));
		double n = Math.pow(aperture.getValue(), 2);
		Double x = n / shutterSpeed.getValue();
		Double calculatedEv = log(x, logBase);
		Double finalEV = calculatedEv > 0 ? Math.ceil(calculatedEv) : Math.floor(calculatedEv);
		return finalEV.longValue();
	}
	
	private static Double log(Double x, Double base)
	{
	    return (Math.log(x) / Math.log(base));
	}
}
