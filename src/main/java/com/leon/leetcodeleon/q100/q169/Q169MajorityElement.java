package com.leon.leetcodeleon.q100.q169;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Q169MajorityElement
{
	@Test
	public void test()
	{
		assert majorityElement(new int[] { 3, 2, 3 }) == 3;
		assert majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }) == 2;
	}

	public int majorityElement(int[] nums)
	{
		// 元素，出现次数
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums)
		{
			if (map.containsKey(num))
			{
				map.put(num, map.get(num) + 1);
			}
			else
			{
				map.put(num, 1);
			}
		}
		int len = nums.length;
		int mid = len / 2;
		for (Map.Entry<Integer, Integer> me : map.entrySet())
		{
			if (me.getValue() > mid)
			{
				return me.getKey();
			}
		}
		// 题目中保证了结果必须存在，这里肯定不会走到
		return -1;
	}
}
