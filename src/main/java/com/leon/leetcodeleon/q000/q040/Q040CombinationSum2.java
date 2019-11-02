package com.leon.leetcodeleon.q000.q040;

import com.alibaba.fastjson.JSONObject;
import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

import java.util.*;

public class Q040CombinationSum2 extends BaseTest
{
	@Test
	public void test()
	{
		combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8);
		//		combinationSum2(new int[] { 2, 5, 2, 1, 2 }, 5);
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target)
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
					//					Set<Integer> tmpList = new HashSet<>();
					tmpList.add(j);
					map.get(i).add(tmpList);
				}
				else if (i > candidates[j])
				{
					int key = i - candidates[j];
					for (List<Integer> integers : map.get(key))
					{
						List<Integer> tmpList = new ArrayList<>();
						//						Set<Integer> tmpList = new HashSet<>();
						tmpList.addAll(integers);
						tmpList.add(j);
						Collections.sort(tmpList);
						map.get(i).add(tmpList);
					}
				}
			}
		}

		Set<List<Integer>> tt = new HashSet<>();
		for (List<Integer> integers : map.get(target))
		{
			Set<Integer> set = new HashSet<>();
			set.addAll(integers);
			if (set.size() != integers.size())
			{
				continue;
			}
			List<Integer> tmp = new ArrayList<>();
			for (Integer integer : integers)
			{
				tmp.add(candidates[integer]);
			}
			tt.add(tmp);

		}
		result.addAll(tt);
		System.out.println(JSONObject.toJSONString(result));
		return result;
	}
}
