package com.leon.leetcodeleon.q1300.q1300.q1341;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class Q1341kWeakestRows
{
	@Test
	public void test()
	{
		System.out.println(JSONObject.toJSONString(kWeakestRows(new int[][] { { 1, 0 }, { 1, 2 }, { 1, 0 }, { 1, 1 } }, 4)));
		System.out.println(JSONObject.toJSONString(kWeakestRows(new int[][] { { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 1 } }, 3)));
	}

	public int[] kWeakestRows(int[][] mat, int k)
	{
		int[][] res = new int[k][2];
		for (int i = 0; i < k; i++)
		{
			res[i][0] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < mat.length; i++)
		{
			int tmp = 0;
			for (int j = 0; j < mat[i].length && mat[i][j] == 1; j++)
			{
				tmp++;
			}
			for (int m = 0; m < k; m++)
			{
				if (tmp < res[m][0])
				{
					for (int n = k - 1; n > m; n--)
					{
						res[n][0] = res[n - 1][0];
						res[n][1] = res[n - 1][1];
					}
					res[m][0] = tmp;
					res[m][1] = i;
					break;
				}

			}
		}
		int[] r = new int[k];
		for (int i = 0; i < k; i++)
		{
			r[i] = res[i][1];
		}
		return r;
	}
}
