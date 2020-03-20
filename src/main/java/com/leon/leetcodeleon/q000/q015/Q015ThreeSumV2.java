package com.leon.leetcodeleon.q000.q015;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

import java.util.*;

public class Q015ThreeSumV2 extends BaseTest
{
	@Test
	public void test()
	{
		int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
		System.out.println(threeSum(nums));
		System.out.println(threeSum(new int[] {}));
	}

	public List<List<Integer>> threeSum(int[] nums)
	{
		if (nums == null || nums.length < 3)
		{
			return new ArrayList<>();
		}
		return null;
	}
}
