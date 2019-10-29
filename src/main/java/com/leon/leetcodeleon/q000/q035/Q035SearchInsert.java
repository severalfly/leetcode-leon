package com.leon.leetcodeleon.q000.q035;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

public class Q035SearchInsert extends BaseTest
{

	@Test
	public void test()
	{
		assert searchInsert(new int[] { 1, 3, 5, 6 }, 5) == 2;
		assert searchInsert(new int[] { 1, 3, 5, 6 }, 2) == 1;
		assert searchInsert(new int[] { 1, 3, 5, 6 }, 7) == 4;
		assert searchInsert(new int[] { 1, 3, 5, 6 }, 0) == 0;
	}

	public int searchInsert(int[] nums, int target)
	{
		if (nums == null || nums.length == 0)
		{
			return 0;
		}
		int left = 0;
		int right = nums.length - 1;
		while (left <= right)
		{
			int mid = (left + right) / 2;
			if (nums[mid] == target)
			{
				return mid;
			}
			else if (nums[mid] > target)
			{
				right = mid - 1;
			}
			else
			{
				left = mid + 1;
			}
		}
		return left;
	}
}
