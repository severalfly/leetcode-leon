package com.leon.leetcodeleon.q1200.q1248;

import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

public class Q1248NumberOfSubarrays
{
	@Test
	public void test()
	{
		assert numberOfSubarrays(new int[] { 1, 1, 2, 1, 1 }, 3) == 2;
		assert numberOfSubarrays(new int[] { 2, 4, 6 }, 1) == 0;
		assert numberOfSubarrays(new int[] { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 }, 2) == 16;
	}

	public int numberOfSubarrays(int[] nums, int k)
	{
		int n = nums.length;
		int[] odd = new int[n + 2];
		int ans = 0;
		int cnt = 0;
		for (int i = 0; i < n; ++i)
		{
			if (nums[i] % 2 == 1)
				odd[++cnt] = i;
		}
		odd[0] = -1;
		odd[++cnt] = n;
		for (int i = 1; i + k <= cnt; ++i)
		{
			ans += (odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]);
		}
		return ans;

	}

	/**
	 * 可以解决，但是超时
	 * @param nums
	 * @param k
	 * @return
	 */
	public int numberOfSubarrays_1(int[] nums, int k)
	{
		int len = nums.length;
		if (len <= 0 || k <= 0)
		{
			return 0;
		}
		int res = 0;
		for (int i = 0; i < len; i++)
		{
			int c = 0;
			for (int j = i; j < len; j++)
			{
				if (j == i)
				{
					c = nums[j] % 2;
				}
				else
				{
					c += nums[j] % 2;
				}
				if (c == k)
				{
					res++;
				}
				else if (c > k)
				{
					break;
				}
			}
		}
		return res;
	}

	private void print(int[][] tmp)
	{
		ObjectUtils.print(tmp);
	}
}
