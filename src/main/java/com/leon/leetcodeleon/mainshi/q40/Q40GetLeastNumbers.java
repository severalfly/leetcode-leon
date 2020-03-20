package com.leon.leetcodeleon.mainshi.q40;

import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

import java.util.Arrays;

public class Q40GetLeastNumbers
{
	@Test
	public void test()
	{
		ObjectUtils.print(getLeastNumbers(new int[] { 3, 2, 1 }, 2));
		ObjectUtils.print(getLeastNumbers(new int[] { 4, 5, 1, 6, 2, 7, 3, 8 }, 4));
	}

	public int[] getLeastNumbers(int[] arr, int k)
	{
		int[] res = new int[k];
		for (int i = 0; i < k; i++)
		{
			res[i] = arr[i];
		}

		Arrays.sort(res);

		for (int i = k; i < arr.length; i++)
		{
			int t = arr[i];
			int j = 0;
			while (j < k)
			{
				if (res[j] > t)
				{
					break;
				}
				j++;
			}
			if (j >= k)
			{
				continue;
			}
			for (int m = k - 1; m > j; m--)
			{
				res[m] = res[m - 1];
			}
			res[j] = t;
		}
		return res;
	}
}
