package com.leon.leetcodeleon.q000.q065;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Q065IsNumber extends BaseTest
{
	@Test
	public void test()
	{
		assert isNumber("+42e+76125");
		assert !isNumber(".");
		assert !isNumber("-");
		assert !isNumber("+");
		assert isNumber("0");
		assert !isNumber("459277e38+");
		assert !isNumber("4e+");
		assert !isNumber(".e1");
		assert isNumber("3.");
		assert isNumber(".3");
		assert isNumber(" 0.1 ");
		assert !isNumber("abc");
		assert !isNumber("1 a");
		assert isNumber("2e10");
		assert isNumber(" -90e3   ");
		assert !isNumber(" 1e");
		assert !isNumber("e3");
		assert isNumber(" 6e-1");
		assert !isNumber(" 99e2.5 ");
		assert isNumber("53.5e93");
		assert !isNumber(" --6 ");
		assert !isNumber("-+3");
		assert !isNumber("95a54e53");
	}

	private String trim(String str)
	{
		if (str == null || str.equals(""))
		{
			return str;
		}
		int l = 0;
		int r = str.length() - 1;
		while (l <= r)
		{
			char c = str.charAt(l);
			if (!(c == ' ' || c == ' '))
				break;
			l++;
		}
		while (l <= r)
		{
			char c = str.charAt(r);
			if (!(c == ' ' || c == ' '))
				break;
			r--;
		}
		str = str.substring(l, r + 1);
		return str;
	}

	public boolean isNumber(String s)
	{
		if (s == null || "".equals(s.trim()))
		{
			return false;
		}
		// s = s.trim(); // 首先去除首尾空格
		s = trim(s);

		Set<Character> setOnce = new HashSet<>(); // 允许出现一次的字符
		for (int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			if (c >= 'a' && c <= 'z')
			{
				if (c == 'e')
				{
					if (setOnce.contains(c))
					{
						return false;
					}
					setOnce.add(c);
				}
				else
				{
					// 非法字符
					return false;
				}
			}
			else if (c >= '0' && c <= '9')
			{

			}
			else if (c == '.')
			{
				if (setOnce.contains(c))
				{
					return false;
				}
				setOnce.add(c);
			}
			else if (c == '+')
			{
				if (setOnce.contains('e'))
				{
					c = 'a';
				}
				if (setOnce.contains(c))
				{
					return false;
				}
				setOnce.add(c);
			}
			else if (c == '-')
			{
				if (setOnce.contains('e'))
				{
					c = 'b';
				}
				if (setOnce.contains(c))
				{
					return false;
				}
				setOnce.add(c);
			}
			else
			{
				return false;
			}
		}

		if (s.startsWith("-") || s.startsWith("+"))
		{
			// 由于只做正确性校验，直接去除 正负号即可
			s = s.substring(1);
		}
		if (s.equals(""))
		{
			return false;
		}
		// 执行到此处时，只剩 +-.e 和数字的组和了，
		if (s.contains("e"))
		{
			String[] tmp = s.split("e");
			if (tmp.length < 2 || tmp[0].length() <= 0 || tmp[1].length() <= 0)
			{
				return false;
			}
			if (tmp[0].contains(".") && tmp[0].length() == 1)
			{
				return false;
			}
			if (tmp[0].contains("-") || tmp[0].contains("+"))
			{
				return false;
			}
			if (tmp[1].contains("."))
			{
				return false;
			}
			if (tmp[1].startsWith("-") || tmp[1].startsWith("+"))
			{
				tmp[1] = tmp[1].substring(1);
			}
			if (tmp[1].equals("") || tmp[1].contains("-") || tmp[1].contains("+"))
			{
				return false;
			}
			return true;
		}
		else if (s.contains("-") || s.contains("+"))
		{
			// 前面已经尝试去除首位的 - 了，如果
			return false;
		}
		else if (s.contains("."))
		{
			return s.length() > 1;
		}
		else
		{
			return true;
		}
	}
}
