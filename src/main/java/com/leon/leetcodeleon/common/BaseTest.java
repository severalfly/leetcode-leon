package com.leon.leetcodeleon.common;

import org.junit.After;
import org.junit.Before;

public class BaseTest
{
	private long time;

	@Before
	public void befor()
	{
		System.out.println(System.currentTimeMillis());
		time = System.currentTimeMillis();
	}

	@After
	public void after()
	{
		long l = System.currentTimeMillis() - this.time;
		System.out.println(l);
	}
}
