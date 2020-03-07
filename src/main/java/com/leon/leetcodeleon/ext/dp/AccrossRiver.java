package com.leon.leetcodeleon.ext.dp;

import org.junit.Test;

import java.util.Arrays;

public class AccrossRiver
{
	@Test
	public void test()
	{
		assert nightReiver(new int[] { 1, 2, 5, 10 }) == 17;
	}

	/**
	 * 注意需要排序
	 * @param a
	 * @return
	 */
	public int nightReiver(int[] a)
	{
		Arrays.sort(a);
		int[] opt = new int[a.length];
		opt[0] = a[0];
		opt[1] = a[1];
		for (int i = 2; i < a.length; i++)
		{
			int a1 = a[i] + a[0] + opt[i - 1];
			int a2 = 2 * a[1] + a[i] + a[0] + opt[i - 2];
			opt[i] = Math.min(a1, a2);
		}
		return opt[a.length - 1];
	}
}
