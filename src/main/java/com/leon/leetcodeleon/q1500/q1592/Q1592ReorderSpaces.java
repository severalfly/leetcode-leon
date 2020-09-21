package com.leon.leetcodeleon.q1500.q1592;

import org.junit.Test;

/**
 * @Package com.leon.leetcodeleon.q1500.q1592
 * @author zhangyunfei
 * @date 2020-09-21 23:50
 * @version V1.0
 */
public class Q1592ReorderSpaces
{
	@Test
	public void test()
	{
		assert reorderSpaces("  this   is  a sentence ").equals("this   is   a   sentence");
		assert reorderSpaces(" practice   makes   perfect").equals("practice   makes   perfect ");
		assert reorderSpaces("hello   world").equals("hello   world");
		assert reorderSpaces("  walks  udp package   into  bar a").equals("walks  udp  package  into  bar  a ");
		assert reorderSpaces("a").equals("a");
	}

	public String reorderSpaces(String text)
	{
		int spaceCnt = 0;
		int wordCnt = 0;
		boolean bSpace = true;
		for (int i = 0; i < text.length(); i++)
		{
			if (text.charAt(i) == ' ')
			{
				spaceCnt++;
				bSpace = true;
			}
			else if (bSpace)
			{
				wordCnt++;
				bSpace = false;
			}
		}
		// System.out.println(spaceCnt + " " + wordCnt);
		int k = spaceCnt;
		if (wordCnt > 1)
		{
			k = spaceCnt / (wordCnt - 1);
		}
		StringBuilder sb = new StringBuilder();
		bSpace = true;
		for (int i = 0; i < text.length(); i++)
		{
			if (text.charAt(i) == ' ')
			{
				if (!bSpace)
				{
					for (int j = 0; j < k; j++)
					{
						if (spaceCnt > 0)
						{
							sb.append(' ');
							spaceCnt--;
						}
					}
				}
				bSpace = true;
			}
			else
			{
				bSpace = false;
				sb.append(text.charAt(i));
			}
		}

		for (int j = 0; j < spaceCnt; j++)
		{
			sb.append(' ');
		}
		// System.out.println(sb.toString());
		return sb.toString();
	}
}
