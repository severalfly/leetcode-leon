package com.leon.leetcodeleon.q000.q056;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.*;

public class Q056Merge
{
	@Test
	public void test()
	{
		System.out.println(JSONObject.toJSONString(merge(new int[][] { { 1, 4 }, { 2, 3 } })));
		System.out.println(JSONObject.toJSONString(merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } })));
		System.out.println(JSONObject.toJSONString(merge(new int[][] { { 1, 4 }, { 4, 5 } })));
	}

	public int[][] merge(int[][] intervals)
	{
		if (intervals == null || intervals.length <= 0 || intervals[0].length < 2)
		{
			return new int[][] {};
		}
		TreeMap<Integer, int[]> map = new TreeMap<>();
		for (int[] interval : intervals)
		{
			if (map.containsKey(interval[0]))
			{
				int[] ints = map.get(interval[0]);
				if (ints[1] < interval[1])
				{
					map.put(interval[0], interval);
				}
			}
			else
			{
				map.put(interval[0], interval);
			}
		}
		// int[][] result = new int[intervals.length][2];
		List<int[]> result = new ArrayList<>();
		Map.Entry<Integer, int[]> integerEntry = map.firstEntry();
		int[] tmp = integerEntry.getValue();

		for (Map.Entry<Integer, int[]> me : map.entrySet())
		{
			if (me.getKey() > tmp[1])
			{
				// 需要生成新的对，并返回
				result.add(tmp);
				tmp = me.getValue();
			}
			else
			{
				tmp[1] = Math.max(me.getValue()[1], tmp[1]);
			}
		}
		result.add(tmp);
		return result.toArray(new int[][] {});
	}
}
