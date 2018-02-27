package com.feliz.dslrexpolib.utils;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm aa");
		Calendar calendar = sdf.getCalendar();
		int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
		int am_pm = calendar.get(Calendar.AM_PM);
		
		JSONArray evJson = getExpoJSON();
		
		if(Calendar.AM_PM == am_pm)
		{
			System.out.println("AM");
		}
		else
		{
			System.out.println("PM");
		}
		
		
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
	
	private static JSONArray getExpoJSON()
	{
		
		JSONParser jsonParser = new JSONParser();
		JSONArray expoValues = null;
		try
		{
			Object obj = jsonParser.parse(new FileReader("json/ev_values.json"));
			expoValues = (JSONArray) obj;
			System.out.println(expoValues);
		}
		catch(ParseException | IOException e)
		{
			e.printStackTrace();
		} 
		
		return expoValues;
	}
}
