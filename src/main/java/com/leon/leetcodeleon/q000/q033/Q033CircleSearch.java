package com.leon.leetcodeleon.q000.q033;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

public class Q033CircleSearch extends BaseTest
{
	@Test
	public void test()
	{
		assert search(new int[] { 3, 4, 5, 6, 7, 1, 2 }, 4) == 1;
		assert search(new int[] { 3, 5, 1 }, 3) == 0;
		assert search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0) == 4;
		assert search(new int[] { 1, 3 }, 3) == 1;
		assert search(new int[] { 1, 3 }, 1) == 0;
		assert search(new int[] { 4, 0 }, 3) == -1;
		assert search(new int[] { 5, 1, 3 }, 0) == -1;
		assert search(new int[] { 1, 3, 5 }, 0) == -1;
		assert search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3) == -1;
	}

	public int search(int[] nums, int target)
	{
		if (nums.length <= 0)
		{
			return -1;
		}
		else if (nums.length == 1)
		{
			return nums[0] == target ? 0 : -1;
		}
		int len = nums.length;
		int k = findPartation(nums, 0, nums.length - 1);
		int res = -1;
		if (k < 0)
		{
			System.out.println("获取到非法输出");
		}
		else if (nums[len - 1] == target)
		{
			return len - 1;
		}
		else if (nums[len - 1] < target)
		{
			// 在前半部分
			res = dosearch(nums, 0, k, target);
		}
		else
		{
			// 在后半部分
			res = dosearch(nums, k, nums.length - 1, target);
		}
		//		System.out.println(res);
		return res;
	}

	/**
	 * 二分搜索法搜索
	 * @param nums
	 * @param i
	 * @param k
	 * @param target
	 * @return
	 */
	private int dosearch(int[] nums, int i, int k, int target)
	{
		if (i >= k)
		{
			if (nums[i] == target)
			{
				return i;
			}
			else
			{
				return -1;
			}
		}
		int mid = (i + k) / 2;
		if (nums[mid] == target)
		{
			return mid;
		}
		else if (nums[mid] > target)
		{
			return dosearch(nums, i, mid, target);
		}
		else
		{
			return dosearch(nums, mid + 1, k, target);
		}
	}

	/**
	 * 找到旋转的位置
	 * @param nums
	 * @return
	 */
	private int findPartation(int[] nums, int min, int max)
	{
		if (max == min)
		{
			return min;
		}
		else if (max - min == 1)
		{
			return min;
		}
		int k = (min + max) / 2;
		int first = nums[min];
		int end = nums[max];
		if (nums[k] >= first && nums[k] >= end)
		{
			// 说明  k  处于前半部分
			if (nums[k] < nums[k + 1])
			{
				return findPartation(nums, k + 1, max);
			}
			else
			{
				return k;
			}
		}
		else if (nums[k] <= first && nums[k] <= end)
		{
			// 处于后半部分
			if (nums[k - 1] > nums[k])
			{
				return k - 1;
			}
			else
			{
				return findPartation(nums, min, k - 1);
			}
		}
		return 0;
	}
}
