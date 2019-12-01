package com.leon.leetcodeleon.q000.q049;

import com.alibaba.fastjson.JSONObject;
import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

import java.util.*;

public class Q049GroupAnagrams extends BaseTest
{
	@Test
	public void test()
	{
			groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
	}

	public List<List<String>> groupAnagrams(String[] strs)
	{
		if(strs==null || strs.length == 0)
		{
			return new ArrayList<>();
		}
		Map<String, List<String>> res = new HashMap<>();
		for (String str : strs)
		{
			String s = getStr(str);

			if(!res.containsKey(s))
			{
				res.put(s, new ArrayList<>());
			}
			res.get(s).add(str);
		}

		List<List<String>> ss = new ArrayList<>(res.values());
		System.out.println(JSONObject.toJSONString(ss));
		return ss;

	}

	private String getStr(String str)
	{
		List<Character> list = new ArrayList<>();
		str.chars().forEach(x -> list.add((char) x));
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for (Character c : list)
		{
			sb.append(c);
		}
		return sb.toString();
	}

}
