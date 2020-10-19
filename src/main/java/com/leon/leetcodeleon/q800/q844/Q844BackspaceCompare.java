package com.leon.leetcodeleon.q800.q844;

import org.junit.Test;

/**
 * @Package com.leon.leetcodeleon.q800.q844
 * @author zhangyunfei
 * @date 2020-10-19 22:04
 * @version V1.0
 */
public class Q844BackspaceCompare
{

	@Test
	public void test()
	{
		assert !backspaceCompare("bbbextm", "bbb#extm");
		assert !backspaceCompare("a", "b");
		assert backspaceCompare("ab#c", "ad#c");
		assert backspaceCompare("ab##", "c#d#");
		assert backspaceCompare("a##c", "#a#c");
		assert !backspaceCompare("a#c", "b");
		assert backspaceCompare("b", "b");
	}

	int l1;
	int l2;

	public boolean backspaceCompare(String S, String T)
	{
		l1 = S.length() - 1;
		l2 = T.length() - 1;

		char c1 = ' ';
		char c2 = ' ';

		// c1 = S.charAt(getPre(S, l1));
		// c2 = S.charAt(getPre(T, l2));
		while (l1 >= 0 && l2 >= 0)
		{
			l1 = getPre(S, l1);
			l2 = getPre(T, l2);

			if (l1 < 0 && l2 < 0)
			{
				return true;
			}
			else if (l1 < 0)
			{
				return false;
			}
			else if (l2 < 0)
			{
				return false;
			}

			c1 = S.charAt(l1);
			c2 = T.charAt(l2);
			if (c1 != c2)
			{
				return false;
			}
			l1--;
			l2--;
		}
		if (l1 != l2)
		{
			return false;
		}
		return true;

	}

	@Test
	public void testGetPre()
	{
		System.out.println(getPre("##c", 1));

	}

	private int getPre(String t, int l)
	{
		int c = 0;
		while (l >= 0)
		{
			if (t.charAt(l) == '#')
			{
				c++;
				l--;
				continue;
			}
			else if (c > 0)
			{
				l--;
				c--;
			}
			else
			{
				return l;
				// return t.charAt(l);
			}
		}
		return -1;
	}
}
