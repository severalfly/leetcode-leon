package com.leon.leetcodeleon.q000.q096;

import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

public class Q096NumTrees
{
	@Test
	public void test()
	{
		assert numTrees(3) == 5;
	}

	public int numTrees(int n)
	{
		if (n <= 0)
		{
			return 0;
		}
		int[] g = new int[n + 1];
		g[0] = 1;
		g[1] = 1;
		for (int i = 2; i <= n; i++)
		{
			for (int j = 1; j <= i; j++)
			{
				g[i] += g[j - 1] * g[i - j];
			}
		}
		ObjectUtils.print(g);
		return g[n];
	}
}
