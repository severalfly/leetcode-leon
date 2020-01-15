package com.leon.leetcodeleon.q000.q081;

import org.junit.Test;

public class Q081Search
{
	@Test
	public void test()
	{
		assert search(new int[] { 0, 0, 1, 1, 2, 0 }, 2);
		assert search(new int[] { 3, 1, 2, 2, 2 }, 1);
		assert search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 5);
		assert search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0);
		assert search(new int[] { 1, 1, 3, 1 }, 3);
		assert search(new int[] { 1, 3, 1, 1, 1 }, 3);
		assert search(new int[] { 3, 5, 1 }, 3);
		assert search(new int[] { 3, 1 }, 1);
		assert search(new int[] { 1, 3 }, 3);
		assert !search(new int[] { 1, 1 }, 0);
		assert search(new int[] { 1 }, 1);
		assert !search(new int[] { 1 }, 0);
		assert search(new int[] { 2, 5, 6, 0, 0, 1, 2 }, 0);
		assert !search(new int[] { 2, 5, 6, 0, 0, 1, 2 }, 3);
	}

	public boolean search(int[] nums, int target)
	{
		if (nums == null || nums.length <= 0)
		{
			return false;
		}
		int start = 0;
		int end = nums.length - 1;
		int mid;
		while (start <= end)
		{
			mid = start + (end - start) / 2;
			if (nums[mid] == target || nums[start] == target || nums[end] == target)
			{
				return true;
			}
			if (nums[start] == nums[mid])
			{
				start++;
				continue;
			}
			if (nums[start] < nums[mid])
			{
				if (target < nums[mid] && nums[start] <= target)
				{
					end = mid - 1;
				}
				else
				{
					start = mid + 1;
				}
			}
			else
			{
				if (nums[mid] < target && nums[end] >= target)
				{
					start = mid + 1;
				}
				else
				{
					end = mid - 1;
				}
			}
		}
		return false;
	}
}
