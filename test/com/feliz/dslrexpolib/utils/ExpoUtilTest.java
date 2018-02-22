package com.feliz.dslrexpolib.utils;

import org.junit.Assert;
import org.junit.Test;

import com.feliz.dslrexpolib.models.Aperture;
import com.feliz.dslrexpolib.models.ISOFilm;
import com.feliz.dslrexpolib.models.ShutterSpeed;

public class ExpoUtilTest {

	@Test
	public void testCalculateExposure_for_0() {
		
		Aperture aperture = new Aperture(1.0);
		
		// 1 sec
		ShutterSpeed shutterSpeed = new ShutterSpeed(1.0);
		ISOFilm isoFilm = new ISOFilm(100L);
		
		Long ev = ExpoUtil.calculateExposure(aperture, shutterSpeed, isoFilm);
		
		Assert.assertEquals(new Double(0), new Double(String.valueOf(ev)));
		
		
	}
	
	
	@Test
	public void testCalculateExposure_for_1() {
		
		Aperture aperture = new Aperture(1.0);
		
		// 1/15
		ShutterSpeed shutterSpeed = new ShutterSpeed(1/2D);
		ISOFilm isoFilm = new ISOFilm(100L);
		
		Long ev = ExpoUtil.calculateExposure(aperture, shutterSpeed, isoFilm);
		
		Assert.assertEquals(new Double(1), new Double(String.valueOf(ev)));
		
		
	}
	
	
	@Test
	public void testCalculateExposure_for_4() {
		
		Aperture aperture = new Aperture(1D);
		
		// 1/15
		ShutterSpeed shutterSpeed = new ShutterSpeed(new Double(1/15D));
		ISOFilm isoFilm = new ISOFilm(100L);
		
		Long ev = ExpoUtil.calculateExposure(aperture, shutterSpeed, isoFilm);
		
		Assert.assertEquals(new Double(4), new Double(String.valueOf(ev)));
		
		
	}
	
	
	@Test
	public void testCalculateExposure_for_2() {
		
		Aperture aperture = new Aperture(1.4D);
		
		// 1/2
		ShutterSpeed shutterSpeed = new ShutterSpeed(new Double(1/2D));
		ISOFilm isoFilm = new ISOFilm(100L);
		
		Long ev = ExpoUtil.calculateExposure(aperture, shutterSpeed, isoFilm);
		
		Assert.assertEquals(new Double(2), new Double(String.valueOf(ev)));
		
		
	}

}
