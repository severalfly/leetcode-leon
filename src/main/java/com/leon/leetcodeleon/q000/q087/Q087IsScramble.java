package com.leon.leetcodeleon.q000.q087;

import org.junit.Test;

public class Q087IsScramble
{
	@Test
	public void test()
	{
		assert isScramble("great","rgeat");
	}
	public boolean isScramble(String s1, String s2)
	{
		if (s1.length() != s2.length())
		{
			return false;
		}
		if (s1.equals(s2))
		{
			return true;
		}

		//判断两个字符串每个字母出现的次数是否一致
		int[] letters = new int[26];
		for (int i = 0; i < s1.length(); i++)
		{
			letters[s1.charAt(i) - 'a']++;
			letters[s2.charAt(i) - 'a']--;
		}
		//如果两个字符串的字母出现不一致直接返回 false
		for (int i = 0; i < 26; i++)
		{
			if (letters[i] != 0)
			{
				return false;
			}
		}

		//遍历每个切割位置
		for (int i = 1; i < s1.length(); i++)
		{
			//对应情况 1 ，判断 S1 的子树能否变为 S2 相应部分
			if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
			{
				return true;
			}
			//对应情况 2 ，S1 两个子树先进行了交换，然后判断 S1 的子树能否变为 S2 相应部分
			if (isScramble(s1.substring(i), s2.substring(0, s2.length() - i)) && isScramble(s1.substring(0, i), s2.substring(s2.length() - i)))
			{
				return true;
			}
		}
		return false;

	}
}
