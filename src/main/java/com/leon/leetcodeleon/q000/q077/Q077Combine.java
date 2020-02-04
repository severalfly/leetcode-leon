package com.leon.leetcodeleon.q000.q077;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q077Combine
{
	@Test
	public void testCombine()
	{
		List<List<Integer>> combine = combine(4, 2);
		System.out.println(JSONObject.toJSONString(combine, SerializerFeature.DisableCircularReferenceDetect));
	}

	private List<List<Integer>> list = new ArrayList<>();

	public List<List<Integer>> combine(int n, int k)
	{
		// aaa
		LinkedList<Integer> cur = new LinkedList<>();
		backtrack(1, cur, n, k);
		return list;
	}

	private void backtrack(int first, LinkedList<Integer> cur, int n, int k)
	{
		if (cur.size() == k)
		{
			List<Integer> tmp = new ArrayList<>(cur);
			list.add(tmp);
		}
		for (int i = first; i <= n; i++)
		{
			cur.offer(i);
			backtrack(i + 1, cur, n, k);
			cur.pollLast();
		}
	}

}
