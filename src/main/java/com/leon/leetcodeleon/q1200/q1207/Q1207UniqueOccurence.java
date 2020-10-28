package com.leon.leetcodeleon.q1200.q1207;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Package com.leon.leetcodeleon.q1200.q1207
 * @author zhangyunfei
 * @date 2020-10-28 21:54
 * @version V1.0
 */
public class Q1207UniqueOccurence
{
	@Test
	public void test()
	{
		assert uniqueOccurrences(new int[] { 1, 2, 2, 1, 1, 3 });
		assert !uniqueOccurrences(new int[] { 1, 2 });
		assert uniqueOccurrences(new int[] { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 });
	}

	public boolean uniqueOccurrences(int[] arr)
	{
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : arr)
		{
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		Set<Integer> set = new HashSet<>();
		for (Map.Entry<Integer, Integer> me : map.entrySet())
		{
			set.add(me.getValue());
		}
		return map.size() == set.size();
	}

}
