package com.leon.leetcodeleon.q0.q06;

import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

public class ConvertToZStringV2
{

	@Test
	public void test()
	{
		// assert convert("LEETCODEISHIRING", 4).equalsIgnoreCase("LDREOEIIECIHNTSG");
		// assert convert("LEETCODEISHIRING", 3).equalsIgnoreCase("LCIRETOESIIGEDHN");
		assert convert("PAYPALISHIRING", 6).equalsIgnoreCase("PRAIIYHNPSGAIL");
		assert convert("AB", 1).equalsIgnoreCase("AB");
	}

	public String convert(String s, int numRows)
	{
		if (s == null || s.length() <= 1 || numRows <= 1)
		{
			return s;
		}
		int[][] direction = new int[][] { { 1, 0 }, { -1, 1 } };

		char[][] tmp = new char[numRows][s.length() + 1];
		int m = 0;
		int n = 0;
		int a = 0;
		int[] dir = direction[a];
		int i = 0;
		while (i < s.length())
		{
			tmp[m][n] = s.charAt(i);
			i++;
			if ((m == numRows - 1 && a == 0) || (m == 0) && a == 1)
			{
				a = (a + 1) % 2;
				dir = direction[a];
			}
			m += dir[0];
			n += dir[1];
		}
		ObjectUtils.print(tmp);
		StringBuilder sb = new StringBuilder();
		for (i = 0; i < tmp.length; i++)
		{
			for (int j = 0; j < tmp[0].length; j++)
			{
				if (tmp[i][j] != 0)
				{
					sb.append(tmp[i][j]);
				}
			}
		}
		return sb.toString();
	}

}
