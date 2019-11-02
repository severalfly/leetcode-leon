package com.leon.leetcodeleon.q000.q039;

import com.alibaba.fastjson.JSONObject;
import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

import java.util.*;

public class Q039CombinationSum extends BaseTest
{
	@Test
	public void test()
	{
		combinationSum(new int[] { 2, 3, 6, 7 }, 7);
		combinationSum(new int[] { 2, 3, 5 }, 8);
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target)
	{
		List<List<Integer>> result = new ArrayList<>();

		// target 对应的set，每个set 对应的是 candidates 的位置
		Map<Integer, Set<List<Integer>>> map = new HashMap<>();

		Arrays.sort(candidates);
		for (int i = 1; i < target + 1; i++)
		{
			map.put(i, new HashSet<>());
			for (int j = 0; j < candidates.length && candidates[j] <= target; j++)
			{
				if (i == candidates[j])
				{
					List<Integer> tmpList = new ArrayList<>();
					tmpList.add(i);
					map.get(i).add(tmpList);
				}
				else if (i > candidates[j])
				{
					int key = i - candidates[j];
					for (List<Integer> integers : map.get(key))
					{
						List<Integer> tmpList = new ArrayList<>();
						tmpList.addAll(integers);
						tmpList.add(candidates[j]);
						Collections.sort(tmpList);
						map.get(i).add(tmpList);
					}
				}
			}
		}
		result.addAll(map.get(target));
		System.out.println(JSONObject.toJSONString(result));
		return result;

	}
}
