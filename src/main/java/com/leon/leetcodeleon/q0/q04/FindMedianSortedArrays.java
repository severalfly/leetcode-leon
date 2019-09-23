package com.leon.leetcodeleon.q0.q04;

import org.junit.Test;

public class FindMedianSortedArrays
{
	public double findMedianSortedArrays(int[] nums1, int[] nums2)
	{
		int l1 = nums1.length;
		int l2 = nums2.length;
		int[] res = new int[l1 + l2];
		int i1 = 0;
		int i2 = 0;
		int k = 0;
		while (i1 < l1 && i2 < l2)
		{
			if (nums1[i1] < nums2[i2])
			{
				res[k++] = nums1[i1++];
			}
			else
			{
				res[k++] = nums2[i2++];
			}
		}
		while (i1 < l1)
		{
			res[k++] = nums1[i1++];
		}

		while (i2 < l2)
		{
			res[k++] = nums2[i2++];
		}
		if (k % 2 != 0)
		{
			return res[k / 2];
		}
		return (res[k / 2] + res[k / 2 - 1]) / 2.0f;
	}

	@Test
	public void test()
	{
		int[] nums1 = new int[] { 1, 3 };
		int[] nums2 = new int[] { 2 };
				System.out.println(findMedianSortedArrays(nums1, nums2));

		nums1 = new int[] { 1, 2 };
		nums2 = new int[] { 3, 4 };
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
}
