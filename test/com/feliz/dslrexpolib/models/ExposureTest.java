package com.feliz.dslrexpolib.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.feliz.dslrexpolib.models.Exposure.ManualPriority;

public class ExposureTest {
	
	private Exposure target;
	private Exposure.ManualPriority targetParam;
	
	@Before
	public void setUp()
	{
		targetParam = new ManualPriority();
	}
	
	@Ignore
	@Test
	public void setExposure15()
	{
		targetParam.aperture(2.0D).shutterSpeed(1/8000D).isoFilm(100L);
		target = new Exposure(targetParam);
		Assert.assertEquals(new Double(15),  new Double(String.valueOf(target.getValue())), 0);
	}
	
	@Ignore
	@Test
	public void setExposure16()
	{
		targetParam.aperture(2.0D).shutterSpeed(1/4000D).isoFilm(200L);
		target = new Exposure(targetParam);
		Assert.assertEquals(new Double(15),  new Double(String.valueOf(target.getValue())), 0);
	}
	
	@Test
	public void getExposureByEVTestForEV7()
	{
		Exposure exp = new Exposure(targetParam);
		exp = exp.getExposureByEV(7L);
		Assert.assertEquals(new Double(exp.getAperture().getValue()),  new Double(String.valueOf("1.0")), 0);
		Assert.assertEquals(new Double(exp.getShutterSpeed().getValue()),  new Double(String.valueOf("0.008")), 0);
		Assert.assertEquals(new Long(exp.getIsoFilm().getValue()),  new Long(String.valueOf("100")), 0L);
	}
	
	@Test
	public void getExposureByEVTestForEVminus6()
	{
		Exposure exp = new Exposure(targetParam);
		exp = exp.getExposureByEV(-6L);
		Assert.assertEquals(new Double(exp.getAperture().getValue()),  new Double(String.valueOf("1.0")), 0);
		Assert.assertEquals(new Double(exp.getShutterSpeed().getValue()),  new Double(String.valueOf("60")), 0);
		Assert.assertEquals(new Long(exp.getIsoFilm().getValue()),  new Long(String.valueOf("100")), 0L);
	}
}
