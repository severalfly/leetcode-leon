package com.leon.leetcodeleon.q1500.q1593;

import org.junit.Test;

import java.util.HashSet;

/**
 * @Package com.leon.leetcodeleon.q1500.q1593
 * @author zhangyunfei
 * @date 2020-09-22 21:50
 * @version V1.0
 */
public class Q1593MaxUniqueSplit
{
	int n = 0;

	@Test
	public void test()
	{
		System.out.println(maxUniqueSplit("aa"));
	}

	public int maxUniqueSplit(String s)
	{
		HashSet<String> set = new HashSet<>();
		int start = 0;
		int end = 1;

		dfs(set, s, start, end);
		return n;
	}

	private void dfs(HashSet<String> set, String s, int start, int end)
	{
		if (end > s.length())
		{
			n = Math.max(n, set.size());
			return;
		}
		String curr = s.substring(start, end);
		if (set.contains(curr))
		{
			dfs(set, s, start, end + 1);
		}
		else
		{
			set.add(curr);
			dfs(set, s, end, end + 1);
			set.remove(curr);
			dfs(set, s, start, end + 1);
		}
	}
}
