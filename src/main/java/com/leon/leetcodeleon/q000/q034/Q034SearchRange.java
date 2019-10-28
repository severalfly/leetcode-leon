package com.leon.leetcodeleon.q000.q034;

import com.alibaba.fastjson.JSONObject;
import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

public class Q034SearchRange extends BaseTest
{
	@Test
	public void test()
	{
//		assert searchRange(new int[] { 1 }, 1).length == 2;
		assert searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6).length == 2;
		//		assert searchRange(new int[] { 8, 8, 8, 8, 8, 10 }, 8).length == 2;
	}

	public int[] searchRange(int[] nums, int target)
	{
		if (nums == null || nums.length <= 0)
		{
			int[] res = new int[2];
			res[0] = -1;
			res[1] = -1;
			return res;
		}
		int left = 0;
		int right = nums.length - 1;
		int k = -1;
		while (left <= right)
		{
			int mid = (left + right) / 2;
			if (nums[mid] == target)
			{
				k = mid;
				break;
			}
			else if (nums[mid] > target)
			{
				right = mid-1;
			}
			else
			{
				left = mid + 1;
			}
		}
		int[] res = new int[2];
		if (k == -1)
		{
			// 说明没找到这样一个数，直接返回即可
			res[0] = -1;
			res[1] = -1;
			return res;
		}

		int l = -1;
		int r = -1;
		// 向左搜索
		left = 0;
		right = k - 1;
		while (left <= right)
		{
			int mid = (left + right) / 2;
			if (nums[mid] == target)
			{
				right = mid - 1;
				continue;
			}
			else
			{
				// 此时，永远不会存在 nums[mid] > target，因为左侧永远小于等于 target
				left = mid + 1;
			}
		}
		l = left;

		// 向右搜索
		left = k;
		right = nums.length - 1;
		while (left <= right)
		{
			int mid = (left + right) / 2;
			if (nums[mid] == target)
			{
				left = mid + 1;
			}
			else
			{
				// 同理，此时，只能是 nums[mid] > target
				right = mid - 1;
			}
		}
		r = right;

		res[0] = l;
		res[1] = r;

		System.out.println(JSONObject.toJSONString(res));
		return res;
	}
}
