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
		helper(arr, k, 0, arr.length - 1);
		return Arrays.copyOf(arr, k);
	}

	public void helper(int[] arr, int k, int s, int e)
	{
		if (s >= e)
		{
			return;
		}
		int patition = partition(arr, s, e);
		int num = patition - s + 1;
		if (num == k)
		{
			return;
		}
		if (num > k)
		{
			helper(arr, k, s, patition - 1);
		}
		else
		{
			helper(arr, k - num, patition + 1, e);
		}
	}

	int partition(int[] nums, int l, int r)
	{
		int pivot = nums[r];
		int i = l - 1;
		for (int j = l; j <= r - 1; ++j)
		{
			if (nums[j] <= pivot)
			{
				i = i + 1;
				swap(nums, i, j);
			}
		}
		swap(nums, i + 1, r);
		return i + 1;
	}

	private void swap(int[] arr, int i, int j)
	{
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	public int[] getLeastNumbersV1(int[] arr, int k)
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
