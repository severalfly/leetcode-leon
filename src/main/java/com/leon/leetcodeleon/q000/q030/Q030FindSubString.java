package com.leon.leetcodeleon.q000.q030;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q030FindSubString
{
	@Test
	public void test()
	{
//		assert findSubstring("barfoofoobarthefoobarman", new String[] { "bar", "foo", "the" }).size() == 3;
		assert findSubstring("barfoothefoobarman", new String[] { "foo", "bar" }).size() == 2;
		assert findSubstring("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "word" }).size() == 0;
	}

	public List<Integer> findSubstring(String s, String[] words)
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
