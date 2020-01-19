package com.leon.leetcodeleon.q000.q089;

import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Q089GrayCode
{
	@Test
	public void test()
	{
		ObjectUtils.print(grayCode(2));
	}

	public List<Integer> grayCode(int n)
	{
		List<Integer> res = new ArrayList<>();
		res.add(0);
		int head = 1;
		for (int i = 1; i <= n; i++)
		{
			for (int j = res.size() - 1; j >= 0; j--)
			{
				res.add(head + res.get(j));
			}
			head <<= 1;
		}
		return res;
	}
}
