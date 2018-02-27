package com.feliz.dslrexpolib.utils;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.feliz.dslrexpolib.models.Aperture;
import com.feliz.dslrexpolib.models.Exposure;
import com.feliz.dslrexpolib.models.ISOFilm;
import com.feliz.dslrexpolib.models.ShutterSpeed;

public class ExpoUtilTest {

	@Ignore
	@Test
	public void testCalculateExposure_for_0() {
		
		Aperture aperture = new Aperture(1.0);
		
		// 1 sec
		ShutterSpeed shutterSpeed = new ShutterSpeed(1.0);
		ISOFilm isoFilm = new ISOFilm(100L);
		
		Long ev = ExpoUtil.calculateManualExposureValue(aperture, shutterSpeed, isoFilm);
		Assert.assertEquals(new Double(0), new Double(String.valueOf(ev)),0);
		
		
	}
	
	@Ignore
	@Test
	public void testCalculateExposure_for_1() {
		
		Aperture aperture = new Aperture(1.0);
		
		// 1/15
		ShutterSpeed shutterSpeed = new ShutterSpeed(1/2D);
		ISOFilm isoFilm = new ISOFilm(100L);
		
		Long ev = ExpoUtil.calculateManualExposureValue(aperture, shutterSpeed, isoFilm);
		Assert.assertEquals( new Double(1), new Double(String.valueOf(ev)),0);
		
		
	}
	
	@Ignore
	@Test
	public void testCalculateExposure_for_4() {
		
		Aperture aperture = new Aperture(1D);
		
		// 1/15
		ShutterSpeed shutterSpeed = new ShutterSpeed(new Double(1/15D));
		ISOFilm isoFilm = new ISOFilm(100L);
		
		Long ev = ExpoUtil.calculateManualExposureValue(aperture, shutterSpeed, isoFilm);
		Assert.assertEquals(new Double(4), new Double(String.valueOf(ev)), 0);
		
		
	}
	
	@Ignore
	@Test
	public void testCalculateExposure_for_2() {
		
		Aperture aperture = new Aperture(1.4D);
		
		// 1/2
		ShutterSpeed shutterSpeed = new ShutterSpeed(new Double(1/2D));
		ISOFilm isoFilm = new ISOFilm(100L);
		
		Long ev = ExpoUtil.calculateManualExposureValue(aperture, shutterSpeed, isoFilm);
		Assert.assertEquals(new Double(2), new Double(String.valueOf(ev)),0);
		
		
	}
	
	@Ignore
	@Test
	public void testCalculateExposure_for_11() {
		
		Aperture aperture = new Aperture(1.4D);
		
		// 1/2
		ShutterSpeed shutterSpeed = new ShutterSpeed(new Double(1/1000D));
		ISOFilm isoFilm = new ISOFilm(100L);
		
		Long ev = ExpoUtil.calculateManualExposureValue(aperture, shutterSpeed, isoFilm);
		Assert.assertEquals( new Double(11), new Double(String.valueOf(ev)), 0);
		
		
	}
	
	@Ignore
	@Test
	public void testCalculateExposure_for_18() {
		
		Aperture aperture = new Aperture(5.6D);
		
		// 1/2
		ShutterSpeed shutterSpeed = new ShutterSpeed(new Double(1/8000D));
		ISOFilm isoFilm = new ISOFilm(100L);
		
		Long ev = ExpoUtil.calculateManualExposureValue(aperture, shutterSpeed, isoFilm);
		Assert.assertEquals(new Double(18), new Double(String.valueOf(ev)), 0);
		
		
	}
	
	@Ignore
	@Test
	public void testCalculateExposure_for_minus5() {
		
		Aperture aperture = new Aperture(1.4D);
		
		// 1/2
		ShutterSpeed shutterSpeed = new ShutterSpeed(new Double(60D));
		ISOFilm isoFilm = new ISOFilm(100L);
		
		Long ev = ExpoUtil.calculateManualExposureValue(aperture, shutterSpeed, isoFilm);
		Assert.assertEquals(new Double(-5), new Double(String.valueOf(ev)), 0);
		
		
	}
	
	@Ignore
	@Test
	public void testCalculateExposure_for_21() {
		
		Aperture aperture = new Aperture(16D);
		
		ShutterSpeed shutterSpeed = new ShutterSpeed(new Double(1/8000D));
		ISOFilm isoFilm = new ISOFilm(100L);
		
		Long ev = ExpoUtil.calculateManualExposureValue(aperture, shutterSpeed, isoFilm);
		Assert.assertEquals(new Double(21), new Double(String.valueOf(ev)), 0);
		
		
	}
	
	@Test
	public void testGetAutoExposure()
	{
		Exposure exp = ExpoUtil.getExposureByTime();
	}

}
