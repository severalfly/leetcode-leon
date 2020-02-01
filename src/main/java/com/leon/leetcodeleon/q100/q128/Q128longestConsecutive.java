package com.leon.leetcodeleon.q100.q128;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Q128longestConsecutive extends BaseTest
{
	@Test
	public void test()
	{
		assert longestConsecutive(new int[] { 0 }) == 1;
		assert longestConsecutive(new int[] { 1 }) == 1;
		assert longestConsecutive(new int[] { 1, 3 }) == 1;
		assert longestConsecutive(new int[] { 1, 2 }) == 2;
		// assert longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2, 6 }) == 4;
		// assert longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2, 5 }) == 5;
	}

	public int longestConsecutive(int[] nums)
	{
		if (nums == null || nums.length <= 0)
		{
			return 0;
		}
		Set<Integer> set = new HashSet<>();
		for (int num : nums)
		{
			set.add(num);
		}
		int largest = 1;
		for (int n : nums)
		{
			if (!set.contains(n - 1))
			{
				int curNum = n;
				int cur = 1;

				if (set.contains(n + 1))
				{
					while (set.contains(curNum + 1))
					{
						cur++;
						curNum++;// 这里实际上应该是 set.get(curNum+1)
					}
					largest = Math.max(largest, cur);
				}
			}
		}
		return largest;
	}
}
