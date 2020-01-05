package com.leon.leetcodeleon.q000.q067;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Q067AddBinary
{
	@Test
	public void test()
	{
		assert addBinary("11", "1").equalsIgnoreCase("100");
		assert addBinary("1010", "1011").equalsIgnoreCase("10101");
	}

	public String addBinary(String a, String b)
	{
		List<Integer> f = new ArrayList<>(a.length());
		List<Integer> s = new ArrayList<>(b.length());
		for (int i = a.length() - 1; i >= 0; i--)
		{
			f.add(Character.digit(a.charAt(i), 2));
		}
		for (int i = b.length() - 1; i >= 0; i--)
		{
			s.add(Character.digit(b.charAt(i), 2));
		}
		int carray = 0;
		int i = 0;
		int j = 0;
		List<Integer> rs = new ArrayList<>();
		while (i < f.size() && j < s.size())
		{
			int r = carray + f.get(i) + s.get(j);
			if (r >= 2)
			{
				carray = 1;
				r -= 2;
			}
			else
			{
				carray = 0;
			}
			rs.add(r);
			i++;
			j++;
		}

		while (i < f.size())
		{
			int r = carray + f.get(i);
			if (r >= 2)
			{
				carray = 1;
				r -= 2;
			}
			else
			{
				carray = 0;
			}
			rs.add(r);
			i++;
		}
		while (j < s.size())
		{
			int r = carray + s.get(j);
			if (r >= 2)
			{
				carray = 1;
				r -= 2;
			}
			else
			{
				carray = 0;
			}
			rs.add(r);
			j++;
		}
		if (carray > 0)
		{
			rs.add(1);
		}
		StringBuilder sb = new StringBuilder();
		for (int i1 = rs.size() - 1; i1 >= 0; i1--)
		{
			sb.append(rs.get(i1));
		}
		return sb.toString();
	}
}
