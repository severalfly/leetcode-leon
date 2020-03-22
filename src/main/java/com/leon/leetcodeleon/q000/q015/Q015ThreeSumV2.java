package com.leon.leetcodeleon.q000.q015;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

import java.util.*;

public class Q015ThreeSumV2 extends BaseTest
{
	@Test
	public void test()
	{
		System.out.println(threeSum(new int[] { -4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6 }));
		System.out.println(threeSum(new int[] { 0, 0, 0 }));
		System.out.println(threeSum(new int[] { -2, -1, 1, 2 }));
		System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
		System.out.println(threeSum(new int[] { -4, -1, -1, 0, 1, 2 }));
		System.out.println(threeSum(new int[] {}));
	}

	public List<List<Integer>> threeSum(int[] nums)
	{
		if (nums == null || nums.length < 3)
		{
			return new ArrayList<>();
		}
		Set<List<Integer>> res = new HashSet<>();
		Arrays.sort(nums);
		// <数字，位置>

		for (int i = 0; i < nums.length; i++)
		{
			int v = nums[i];
			int index = i;
			int l = 0;
			int r = nums.length - 1;
			if (l == index || r == index)
			{
				continue;
			}
			while (l < r)
			{
				int s = nums[l] + nums[r];
				if (s + v == 0)
				{
					if (l == index)
					{
						l++;
						continue;
					}
					else if (r == index)
					{
						r--;
						continue;
					}
					// 就是这个了
					List<Integer> t = new ArrayList<>();
					t.add(nums[index]);
					t.add(nums[l]);
					t.add(nums[r]);
					Collections.sort(t);
					res.add(t);
					// break;
					r--;
					l++;
				}
				else if (s + v > 0)
				{
					r--;
				}
				else
				{
					l++;
				}
			}
		}
		return new ArrayList<>(res);
	}
}
