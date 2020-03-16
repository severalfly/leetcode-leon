package com.leon.leetcodeleon.q1100.q1160;

import org.junit.Test;

public class Q1160CountCharacters
{
	@Test
	public void test()
	{
		assert countCharacters(new String[] { "cat", "bt", "hat", "tree" }, "atach") == 6;
		assert countCharacters(new String[] { "hello", "world", "leetcode" }, "welldonehoneyr") == 10;
	}

	public int countCharacters(String[] words, String chars)
	{
		int[] data = new int[26];
		for (int i = 0; i < chars.length(); i++)
		{
			data[chars.charAt(i) - 'a']++;
		}
		int res = 0;

		for (String word : words)
		{
			int[] d = new int[26];
			// for (int i = 0; i < word.length(); i++)
			// {
			// 	int index = word.charAt(i) - 'a';
			// 	d[index]++;
			// }
			boolean in = true;
			for (int i = 0; i < word.length(); i++)
			{
				int index = word.charAt(i) - 'a';
				if (d[index] == data[index])
				{
					in = false;
					break;
				}
				d[index]++;
			}
			if (in)
			{
				res += word.length();
			}

		}
		return res;
	}
}
