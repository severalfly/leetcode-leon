package com.leon.leetcodeleon.q0.q6;

import org.junit.Test;

public class ConvertToZString
{
	private String str1 = "LEETCODEISHIRING";
	private String res3 = "LCIRETOESIIGEDHN";
	private String res4 = "LDREOEIIECIHNTSG";

	@Test
	public void test()
	{
		assert convert(str1, 4).equalsIgnoreCase(res4);
		assert convert(str1, 3).equalsIgnoreCase(res3);
		assert convert("AB", 1).equalsIgnoreCase("AB");
	}

	public String convert(String s, int numRows)
	{
		if (s == null || s.length() <= 1 || numRows <= 1)
		{
			return s;
		}
		StringBuilder res = new StringBuilder();
		int l = (numRows - 1) * 2;
		//		for (int i = 0; i < s.length(); i += l)
		//		{
		//			res.append(s.charAt(i));
		//		}
		for (int k = 0; k < numRows; k++)
		{
			int per = -1;
			for (int i = 0; i - k < s.length(); i += l)
			{
				if (i - k > 0 && i - k != per)
				{
					res.append(s.charAt(i - k));
					per = i - k;
				}
				if (i + k < s.length() && i + k != per)
				{
					res.append(s.charAt(i + k));
					per = i + k;
				}
			}
		}
//		for (int i = numRows - 1; numRows > 1 && i < s.length(); i += l)
//		{
//			res.append(s.charAt(i));
//		}
		System.out.println(res);
		return res.toString();
	}

}
