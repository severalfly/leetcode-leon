package com.leon.leetcodeleon.q100.q140;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

import java.util.*;

public class Q140WordBreak extends BaseTest
{
	@Test
	public void test()
	{
		System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaa", Arrays.asList(new String[] { "a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa" })));
		// System.out.println(wordBreak("catsanddog", Arrays.asList(new String[] { "cat", "cats", "and", "sand", "dog" })));
		// System.out.println(wordBreak("pineapplepenapple", Arrays.asList(new String[] { "apple", "pen", "applepen", "pine", "pineapple" })));
		// System.out.println(wordBreak("catsandog", Arrays.asList(new String[] { "cats", "dog", "sand", "and", "cat" })));
	}

	public List<String> wordBreak(String s, List<String> wordDict)
	{
		Set<String> set = new HashSet<>(wordDict);
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (String s1 : wordDict)
		{
			max = s1.length() > max ? s1.length() : max;
			min = s1.length() < min ? s1.length() : min;
		}
		List<List<String>> dpData = new ArrayList<>();
		LinkedList<String> initial = new LinkedList<>();
		initial.add("");

		dpData.add(initial);
		for (int i = 1; i <= s.length(); i++)
		{
			long t = System.currentTimeMillis();
			List<String> list = new ArrayList<>();
			for (int j = 0; j < i; j++)
			{
				String tmp = s.substring(j, i);
				if (dpData.get(j).size() > 0 && set.contains(tmp))
				{
					for (String strings : dpData.get(j))
					{
						list.add(strings.equalsIgnoreCase("") ? tmp : (strings + " " + tmp));
					}
					// break;
				}
			}
			dpData.add(list);
			t -= System.currentTimeMillis();
			t *= -1;
			System.out.println(i + " " + t);
		}

		return dpData.get(s.length());
	}

	public List<String> wordBreakFrom(String s, List<String> wordDict)
	{
		LinkedList<String>[] dp = new LinkedList[s.length() + 1];
		LinkedList<String> initial = new LinkedList<>();
		initial.add("");
		dp[0] = initial;
		for (int i = 1; i <= s.length(); i++)
		{
			LinkedList<String> list = new LinkedList<>();
			for (int j = 0; j < i; j++)
			{
				if (dp[j].size() > 0 && wordDict.contains(s.substring(j, i)))
				{
					for (String l : dp[j])
					{
						list.add(l + (l.equals("") ? "" : " ") + s.substring(j, i));
					}
				}
			}
			dp[i] = list;
		}
		return dp[s.length()];

	}

}
