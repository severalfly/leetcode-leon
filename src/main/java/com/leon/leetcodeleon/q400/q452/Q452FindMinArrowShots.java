package com.leon.leetcodeleon.q400.q452;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Package com.leon.leetcodeleon.q400.q452
 * @author zhangyunfei
 * @date 2020-11-23 21:55
 * @version V1.0
 */
public class Q452FindMinArrowShots
{
	@Test
	public void test()
	{
		assert findMinArrowShots(new int[][] { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } }) == 2;
		assert findMinArrowShots(new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 } }) == 4;
		assert findMinArrowShots(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } }) == 2;
		assert findMinArrowShots(new int[][] { { 1, 2 } }) == 1;
		assert findMinArrowShots(new int[][] { { 2, 3 }, { 2, 3 } }) == 1;
		assert findMinArrowShots(new int[][] { { -2147483646, -2147483645 }, { 2147483646, 2147483647 } }) == 2;
		assert findMinArrowShots(new int[][] { { 3, 9 }, { 7, 12 }, { 3, 8 }, { 6, 8 }, { 9, 10 }, { 2, 9 }, { 0, 9 }, { 3, 9 }, { 0, 6 }, { 2, 8 } }) == 2;
		assert findMinArrowShots(new int[][] { { 9, 12 }, { 1, 10 }, { 4, 11 }, { 8, 12 }, { 3, 9 }, { 6, 9 }, { 6, 7 } }) == 2;
	}

	public int findMinArrowShots(int[][] points)
	{
		if (points.length <= 1)
		{
			return points.length;
		}
		Arrays.sort(points, new Comparator<int[]>()
		{
			@Override
			public int compare(int[] o1, int[] o2)
			{
				if (o1[0] > 0 && o2[0] < 0)
				{
					return 1;
				}
				if (o1[0] != o2[0])
					return o1[0] - o2[0];
				else
					return o1[1] - o2[1];
			}
		});
		System.out.println(JSONObject.toJSONString(points));
		int res = 0;
		int l = 0;
		int r = 0;
		while (l < points.length)
		{
			int min = points[l][1];
			while (r < points.length && min >= points[r][0])
			{
				if (points[r][1] < min)
				{
					min = points[r][1];
				}
				r++;
			}
			res++;
			l = r;
			r++;
		}
		System.out.println(res);
		return res;
	}
}
