package com.leon.leetcodeleon.q000.q088;

import com.alibaba.fastjson.JSONObject;
import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

public class Q088Merge
{
	@Test
	public void test()
	{
		merge(new int[] { 1, 0, 0, 0 }, 1, new int[] { 2, 5, 6 }, 0);
		merge(new int[] { 1, 2, 3, 0, 0, 0 }, 3, new int[] { 2, 5, 6 }, 3);
	}

	public void merge(int[] nums1, int m, int[] nums2, int n)
	{
		if (nums1 == null || nums2 == null || nums1.length <= 0 || nums2.length <= 0 || m < 0 || n < 0)
		{
			return;
		}

		int l = m + n - 1;
		m--;
		n--;
		while (l >= 0)
		{
			int tmp;
			if (m >= 0 && n >= 0)
			{
				tmp = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
			}
			else if (m >= 0)
			{
				tmp = nums1[m--];
			}
			else
			{
				tmp = nums2[n--];
			}
			nums1[l--] = tmp;
		}
		System.out.println(JSONObject.toJSONString(nums1));
	}
}
