package com.leon.leetcodeleon.q100.q120;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q120MinimumTotal
{
	@Test
	public void test()
	{
		int[][] ints = { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } };
		List<List<Integer>> triangle = new ArrayList<>();
		for (int[] anInt : ints)
		{
			List<Integer> ints1 = new ArrayList<>();
			for (int i : anInt)
			{
				ints1.add(i);
			}
			triangle.add(ints1);
		}
		System.out.println(minimumTotal(triangle));
	}

	public int minimumTotal(List<List<Integer>> triangle)
	{
		if (triangle.size() <= 0 || triangle.get(0).size() <= 0)
		{
			return 0;
		}
		int rows = triangle.size();
		// 从后向前，保存每行的最小和
		int[] tmp = new int[triangle.get(rows - 1).size()];
		// 初始化 tmp 为最后一行内容，
		for (int i = triangle.get(rows - 1).size() - 1; i >= 0; i--)
		{
			tmp[i] = triangle.get(rows - 1).get(i);
		}

		for (int i = rows - 2; i >= 0; i--)
		{
			for (int j = 0; j < triangle.get(i).size(); j++)
			{
				tmp[j] = triangle.get(i).get(j) + Math.min(tmp[j], tmp[j + 1]);
			}
		}

		return tmp[0];
	}
}
