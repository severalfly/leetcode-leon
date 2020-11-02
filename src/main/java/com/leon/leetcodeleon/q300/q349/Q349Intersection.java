package com.leon.leetcodeleon.q300.q349;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Package com.leon.leetcodeleon.q300.q349
 * @author zhangyunfei
 * @date 2020-11-02 22:10
 * @version V1.0
 */
public class Q349Intersection
{
	@Test
	public void test()
	{
		System.out.println(JSONObject.toJSONString(intersection(new int[] {  }, new int[] { 2, 2 })));
		System.out.println(JSONObject.toJSONString(intersection(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 })));
		System.out.println(JSONObject.toJSONString(intersection(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 })));
	}

	public int[] intersection(int[] nums1, int[] nums2)
	{
		Set<Integer> set = new HashSet<>();
		for (int i : nums1)
		{
			set.add(i);
		}
		List<Integer> r = new ArrayList<>();
		int k = 0;
		for (int i : nums2)
		{
			if (set.contains(i))
			{
				// res[k++] = i;
				r.add(i);
				set.remove(i);
			}
		}
		int[] res = new int[r.size()];
		for (Integer integer : r)
		{
			res[k++] = integer;
		}
		return res;
	}
}
