package com.feliz.dslrexpolib.utils;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;

import com.feliz.dslrexpolib.models.Aperture;
import com.feliz.dslrexpolib.models.ExpConstants;
import com.feliz.dslrexpolib.models.Exposure;
import com.feliz.dslrexpolib.models.ISOFilm;
import com.feliz.dslrexpolib.models.ShutterSpeed;
import com.feliz.dslrexpolib.models.json.EVArray;
import com.feliz.dslrexpolib.models.json.EVElement;

public class ExpoUtil {
	
	private static final String EV_VALUES_JSON_FILE_LOCATION = "json/ev_values.json";

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
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm aa");
		Calendar calendar = sdf.getCalendar();
		int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
		int am_pm = calendar.get(Calendar.AM_PM);
		
		if(Calendar.AM_PM == am_pm)
		{
			System.out.println("AM");
		}
		else
		{
			System.out.println("PM");
		}
		
		return exp;
	}
	
	public static EVArray getExpoValues()
	{
		return getExpoJSON();
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
	
	private static EVArray getExpoJSON()
	{
		EVArray evArray = null;
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			EVElement[] evValues = mapper.readValue(new FileReader(EV_VALUES_JSON_FILE_LOCATION), EVElement[].class);
			evArray = new EVArray(evValues);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		} 
		return evArray;
	}
}
