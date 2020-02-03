package com.leon.leetcodeleon.q1300.q1300.q1342;

import com.alibaba.fastjson.JSONObject;
import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

import java.util.*;

public class Q1342minSetSize extends BaseTest
{
	@Test
	public void test()
	{
		assert minSetSize(new int[] { 3, 3, 3, 3, 5, 5, 5, 2, 2, 7 }) == 2;
		assert minSetSize(new int[] { 7, 7, 7, 7, 7, 7 }) == 1;
		assert minSetSize(new int[] { 1, 9 }) == 1;
		assert minSetSize(new int[] { 1000, 1000, 3, 7 }) == 1;
		assert minSetSize(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }) == 5;
	}

	public int minSetSize(int[] arr)
	{
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i : arr)
		{
			Integer orDefault = map.getOrDefault(i, 0);
			map.put(i, orDefault + 1);
		}

		List<Integer> list = new ArrayList<>(map.values().size());
		list.addAll(map.values());
		Collections.sort(list, new Comparator<Integer>()
		{
			@Override
			public int compare(Integer o1, Integer o2)
			{
				return o2 - o1;
			}
		});
		int res = 0;
		int tmp = 0;
		for (int i : list)
		{
			tmp += i;
			res++;
			if (tmp >= arr.length / 2)
			{
				break;
			}
		}
		return res;
	}
}
