package com.feliz.dslrexpolib.models;

import org.junit.Assert;
import org.junit.Before;
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
	
	@Test
	public void setExposure15()
	{
		targetParam.aperture(2.0D).shutterSpeed(1/8000D).isoFilm(100L);
		target = new Exposure(targetParam);
		Assert.assertEquals(new Double(15),  new Double(String.valueOf(target.getValue())), 0);
	}

	@Test
	public void setExposure16()
	{
		targetParam.aperture(2.0D).shutterSpeed(1/4000D).isoFilm(200L);
		target = new Exposure(targetParam);
		Assert.assertEquals(new Double(15),  new Double(String.valueOf(target.getValue())), 0);
	}
}
