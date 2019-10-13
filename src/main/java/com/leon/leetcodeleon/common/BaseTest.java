package com.leon.leetcodeleon.common;

import org.junit.After;
import org.junit.Before;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest
{
	private long time;

	@Before
	public void befor()
	{
		time = System.currentTimeMillis();
		System.out.println("test start time: " + getTimestamp(new Date(time)));
	}

	@After
	public void after()
	{
		long l = System.currentTimeMillis() - this.time;
		System.out.println("test end time: " + getTimestamp(new Date(System.currentTimeMillis())) + " 持续时间(毫秒)：" + l);
	}

	private String getTimestamp(Date time)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		return sdf.format(time);
	}
}
