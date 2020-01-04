package com.leon.leetcodeleon.q000.q057;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Q057Insert
{
	@Test
	public void test()
	{
		System.out.println(JSONObject.toJSONString(insert(new int[][] { { 1, 5 }, { 7, 9 } }, new int[] { 6, 9 })));
		System.out.println(JSONObject.toJSONString(insert(new int[][] { { 1, 5 }, { 6, 8 } }, new int[] { 5, 6 })));
		System.out.println(JSONObject.toJSONString(insert(new int[][] { { 1, 5 } }, new int[] { 6, 8 })));
		System.out.println(JSONObject.toJSONString(insert(new int[][] { { 1, 5 } }, new int[] { 5, 7 })));
		System.out.println(JSONObject.toJSONString(insert(new int[][] {}, new int[] { 2, 5 })));
		System.out.println(JSONObject.toJSONString(insert(new int[][] { { 1, 3 }, { 6, 9 } }, new int[] { 2, 5 })));
		System.out.println(JSONObject.toJSONString(insert(new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } }, new int[] { 4, 8 })));
	}

	public int[][] insert(int[][] intervals, int[] newInterval)
	{
		if (intervals == null || newInterval == null || newInterval.length < 2)
		{
			return new int[][] {};
		}
		List<int[]> result = new ArrayList<>();
		if (intervals.length < 1 || intervals[0].length < 2)
		{
			result.add(newInterval);
			return result.toArray(new int[][] {});
		}

		int[] tmp = new int[2];
		tmp[0] = intervals[0][0];
		int i = 0;
		for (; i < intervals.length; i++)
		{
			if (intervals[i][1] > newInterval[0])
			{
				tmp[0] = Math.min(Math.min(intervals[i][0], tmp[0]), newInterval[0]);
				break;
			}
			else if (intervals[i][1] == newInterval[0])
			{
				tmp[0] = Math.min(intervals[i][0], newInterval[0]);
				tmp[1] = newInterval[1];
			}
			else
			{
				tmp[0] = newInterval[0];
				// 这是前端不交叉的
				result.add(intervals[i]);
			}

		}
		if (i == intervals.length)
		{
			tmp[1] = Math.max(intervals[i - 1][1], newInterval[1]);
		}
		for (; i < intervals.length; i++)
		{
			if (intervals[i][0] > newInterval[1])
			{
				tmp[1] = Math.max(tmp[1], newInterval[1]);
				break;
			}
			else
			{
				tmp[1] = Math.max(intervals[i][1], newInterval[1]);
			}
		}

		result.add(tmp);
		for (; i < intervals.length; i++)
		{
			result.add(intervals[i]);
		}
		return result.toArray(new int[][] {});
	}
}
