package com.leon.leetcodeleon.q100.q139;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q139WordBreak extends BaseTest
{
	@Test
	public void test()
	{
		assert wordBreak("leetcode", Arrays.asList(new String[] { "leet", "code" }));
		assert wordBreak("applepenapple", Arrays.asList(new String[] { "apple", "pen" }));
		assert !wordBreak("catsandog", Arrays.asList(new String[] { "cats", "dog", "sand", "and", "cat" }));
	}

	public boolean wordBreak(String s, List<String> wordDict)
	{
		Set<String> set = new HashSet<>(wordDict);
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++)
		{
			for (int j = 0; j < i; j++)
			{
				if (dp[j] && set.contains(s.substring(j, i)))
				{
					dp[i] = true;
					break;
				}
			}
		}

		return dp[s.length()];
	}
}
