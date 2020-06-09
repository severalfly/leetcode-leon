package com.leon.leetcodeleon.mainshi.q46;

import org.junit.Test;

/**
 * @Package com.leon.leetcodeleon.mainshi.q46
 * @author zhangyunfei
 * @date 2020-06-09 22:27
 * @version V1.0
 */
public class Q46TranslateNum
{
	@Test
	public void test()
	{
		assert translateNum(12258) == 5;
	}

	public int translateNum(int num)
	{
		String str = String.valueOf(num);
		int p = 0;
		int q = 0;
		int r = 1;
		for (int i = 0; i < str.length(); i++)
		{
			p = q;
			q = r;
			r = 0;
			r+= q;
			if(i == 0)
			{
				continue;
			}
			String s = str.substring(i - 1, i + 1);
			if (s.compareTo("10") >= 0 && s.compareTo("25") <= 0)
			{
				r += p;
			}
		}
		return r;
	}
}
