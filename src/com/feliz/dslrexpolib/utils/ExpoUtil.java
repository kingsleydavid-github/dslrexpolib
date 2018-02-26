package com.feliz.dslrexpolib.utils;

import com.feliz.dslrexpolib.models.Aperture;
import com.feliz.dslrexpolib.models.ExpConstants;
import com.feliz.dslrexpolib.models.Exposure;
import com.feliz.dslrexpolib.models.ISOFilm;
import com.feliz.dslrexpolib.models.ShutterSpeed;

public class ExpoUtil {
	
	private ExpoUtil() {
	    throw new IllegalStateException("This is Exposure utility class.");
	  }
	
	public static Long calculateManualExposureValue(Aperture aperture, ShutterSpeed shutterSpeed, ISOFilm isoFilm)
	{
		Double finalEv = 0.0D;
		if(isoFilm == null)
		{
			isoFilm = new ISOFilm(ExpConstants.DEFAULT_ISO_VALUE);
		}
		
		if(isoFilm.getValue() > ExpConstants.DEFAULT_ISO_VALUE)
		{
			// Calculate custom ev
			finalEv = deriveCustomISO(aperture, shutterSpeed, isoFilm);
		}
		else
		{
			// Calculate ev100
			finalEv = deriveISOForHundred(aperture, shutterSpeed);
		}
		return finalEv.longValue();
	}
	
	public static Exposure getExposureByTime()
	{
		Exposure exp = null;
		
		// Auto Calculate Exposure
		// 1. Read System Time
		// 2. Compare to Exposure chart,
		// 3. get exposure values and return as Exposure
		
		return exp;
	}
	

	private static Double deriveCustomISO(Aperture aperture, ShutterSpeed shutterSpeed, ISOFilm isoFilm) 
	{
		Double finalEv;
		Double x = (double) isoFilm.getValue() / 100;
		Double logForCustomISO = log(x, getLogBase2());
		
		finalEv = deriveISOForHundred(aperture, shutterSpeed) + getCeilOrFloorEV(logForCustomISO);
		
		return finalEv;
	}

	private static Double deriveISOForHundred(Aperture aperture, ShutterSpeed shutterSpeed) 
	{
		double n = Math.pow(aperture.getValue(), 2);
		
		Double x = n / shutterSpeed.getValue();
		Double calculatedEv = log(x, getLogBase2());

		return getCeilOrFloorEV(calculatedEv);
	}

	private static double getCeilOrFloorEV(Double calculatedEv) {
		return calculatedEv > 0 ? Math.ceil(calculatedEv) : Math.floor(calculatedEv);
	}

	private static double getLogBase2() {
		return Double.parseDouble(String.valueOf(ExpConstants.DEFAULT_LOG_BASE));
	}
	
	private static Double log(Double x, Double base)
	{
	    return (Math.log(x) / Math.log(base));
	}
}
