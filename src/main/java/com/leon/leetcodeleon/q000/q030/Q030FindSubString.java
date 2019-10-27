package com.leon.leetcodeleon.q000.q030;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.*;

public class Q030FindSubString
{
	@Test
	public void test()
	{
		assert findSubstring("barfoofoobarthefoobarman", new String[] { "bar", "foo", "the" }).size() == 3;
		assert findSubstring("barfoothefoobarman", new String[] { "foo", "bar" }).size() == 2;
		assert findSubstring("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "word" }).size() == 0;
		assert findSubstring("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "good" }).size() == 1;
	}

	public List<Integer> findSubstring(String s, String[] words)
	{
		List<Integer> res = new ArrayList<>();
		if (s == null || s.length() == 0 || words == null || words.length == 0)
			return res;
		Map<String, Integer> map = new HashMap<>();
		for (String word : words)
		{
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		int oneLen = words[0].length();
		int wordNum = words.length;
		for (int i = 0; i < oneLen; i++)
		{
			int left = i;
			int right = i;
			int count = 0;
			Map<String, Integer> tempMap = new HashMap<>();
			while (right + oneLen <= s.length())
			{
				String w = s.substring(right, right + oneLen);

				right += oneLen;
				count++;
				tempMap.put(w, tempMap.getOrDefault(w, 0) + 1);
				while (tempMap.getOrDefault(w, 0) > map.getOrDefault(w, 0))
				{
					String tmpW = s.substring(left, left + oneLen);
					count--;
					tempMap.put(tmpW, tempMap.getOrDefault(tmpW, 0) - 1);
					left += oneLen;
				}
				if (count == wordNum)
				{
					res.add(left);
				}
			}
		}
		return res;
	}

	/**
	 * 可以解决大部分问题，leetcode 的测试用例，过了242 / 273个
	 * 不能解决 循环的问题，
	 * 即 assert findSubstring("barfoofoobarthefoobarman", new String[] { "bar", "foo", "the" }).size() == 3; 解决不了
	 * @param s
	 * @param words
	 * @return
	 */
	public List<Integer> findSubstringV2(String s, String[] words)
	{
		if (s == null || s.length() <= 0 || words.length <= 0)
		{
			return new ArrayList<>();
		}
		Set<Integer> per = new HashSet<>();
		int start = 0;
		while (true)
		{
			int index = s.indexOf(words[0], start);
			if (index < 0)
			{
				break;
			}
			per.add(index);
			start = index + words[0].length();
		}
		if (words.length <= 1)
		{
			return new ArrayList<>(per);
		}
		for (int i = 1; i < words.length; i++)
		{
			Set<Integer> tmp = new HashSet<>();
			String word = words[i];

			for (Integer integer : per)
			{
				if (integer >= word.length())
				{
					boolean b = s.startsWith(word, integer - word.length());
					if (b)
					{
						tmp.add(integer - word.length());
					}
					b = s.startsWith(word, integer + i * word.length());
					if (b)
					{
						tmp.add(integer);
					}
				}
				else
				{
					boolean b = s.startsWith(word, integer + i * word.length());
					if (b)
					{
						tmp.add(integer);
					}

				}

			}

			per = tmp;
		}
		System.out.println(JSONObject.toJSONString(per));
		return new ArrayList<>(per);
	}
}
