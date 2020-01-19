package com.leon.leetcodeleon.q000.q090;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

import java.util.*;

public class Q090SubSetsWithDup extends BaseTest
{
	@Test
	public void test()
	{
		// System.out.println(JSONObject.toJSONString(subsetsWithDup(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 10, 0 }), SerializerFeature.DisableCircularReferenceDetect));
		System.out.println(JSONObject.toJSONString(subsetsWithDup(new int[] { 1, 2, 2 }), SerializerFeature.DisableCircularReferenceDetect));
		System.out.println(JSONObject.toJSONString(subsetsWithDup(new int[] { 1, 2, 3 }), SerializerFeature.DisableCircularReferenceDetect));
	}

	public List<List<Integer>> subsetsWithDup(int[] nums)
	{
		List<List<List<Integer>>> res = new ArrayList<>();
		for (int num : nums)
		{
			List<List<Integer>> tmp = new ArrayList<>();
			List<Integer> t = new ArrayList<>();
			t.add(num);
			tmp.add(t);
			for (List<List<Integer>> re : res)
			{
				for (List<Integer> list : re)
				{
					tmp.add(list);
					t = new ArrayList<>();
					t.add(num);
					t.addAll(list);
					tmp.add(t);
					// for (int i = 1; i < list.size(); i++)
					// {
					// 	t = new ArrayList<>();
					// 	t.addAll(list.subList(0, i));
					// 	t.add(num);
					// 	t.addAll(list.subList(i, list.size() - 1));
					// 	tmp.add(t);
					// }
					// t = new ArrayList<>();
					// t.addAll(list);
					// t.add(num);
					// tmp.add(t);
				}
			}
			res.add(tmp);
		}
		// return res.get(res.size() - 1);
		List<List<Integer>> lists = res.get(res.size() - 1);
		for (List<Integer> list : lists)
		{
			Collections.sort(list, new Comparator<Integer>()
			{
				@Override
				public int compare(Integer o1, Integer o2)
				{
					return o1 - o2;
				}
			});
		}

		Set<List<Integer>> r = new HashSet<>();
		r.addAll(lists);
		r.add(new ArrayList<>());
		return new ArrayList<>(r);

	}
}
