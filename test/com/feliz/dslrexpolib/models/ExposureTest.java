package com.feliz.dslrexpolib.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExposureTest {

	private Exposure target = null;
	
	@Before
	public void setup()
	{
		target = new Exposure();
	}
	
	@Test
	public void exposureTest_null() {
		
		Integer ev = target.getExposure(1.2F, 0.4F, 3);
		Assert.assertNotNull(ev);
	}

}
