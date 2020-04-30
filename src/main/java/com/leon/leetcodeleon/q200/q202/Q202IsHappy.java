package com.leon.leetcodeleon.q200.q202;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @Package com.leon.leetcodeleon.q200.q202
 * @author zhangyunfei
 * @date 2020-04-30 09:44
 * @version V1.0
 */
public class Q202IsHappy
{
	@Test
	public void test()
	{
		assert isHappy(19);
	}

	public boolean isHappy(int n)
	{
		Set<Integer> seen = new HashSet<>();
		while (n != 1 && !seen.contains(n))
		{
			seen.add(n);
			n = getNext(n);
		}
		return n == 1;

	}

	private int getNext(int n)
	{
		int r = 0;
		while (n > 0)
		{
			int t = n % 10;
			r += t * t;
			n /= 10;
		}
		System.out.println(n + ", " + r);
		return r;
	}
}
