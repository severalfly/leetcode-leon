package com.leon.leetcodeleon.q000.q060;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Q060GetPermutation
{
	@Test
	public void test()
	{
		assert getPermutation(3, 5).equalsIgnoreCase("312");
		assert getPermutation(3, 2).equalsIgnoreCase("132");
		assert getPermutation(3, 1).equalsIgnoreCase("123");
		assert getPermutation(3, 3).equalsIgnoreCase("213");
		assert getPermutation(4, 9).equalsIgnoreCase("2314");
		assert getPermutation(4, 2).equalsIgnoreCase("1243");
	}

	public String getPermutation(int n, int k)
	{
		List<Integer> list = new ArrayList<>(n);
		for (int i = 1; i <= n; i++)
		{
			list.add(i);
		}
		StringBuilder sb = new StringBuilder();
		k -= 1;
		n -= 1;
		while (k > 0 && n > 0)
		{
			int permutation = permutation(n);
			int c = (k) / permutation;
			sb.append(list.get(c));

			k %= permutation;

			list.remove(c);
			n--;
		}

		for (Integer integer : list)
		{
			sb.append(integer);
		}
		return sb.toString();
	}

	private int permutation(int n)
	{
		if (n <= 1)
		{
			return 1;
		}
		return permutation(n - 1) * n;
	}

	@Test
	public void testPermutation()
	{
		System.out.println(permutation(0));
		System.out.println(permutation(1));
		System.out.println(permutation(2));
		System.out.println(permutation(3));
		System.out.println(permutation(4));
	}
}
