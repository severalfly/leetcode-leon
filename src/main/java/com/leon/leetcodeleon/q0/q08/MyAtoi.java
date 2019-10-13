package com.leon.leetcodeleon.q0.q08;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class MyAtoi
{
	@Test
	public void test()
	{
		assert myAtoi("42") == 42;
		assert myAtoi("   -42") == -42;
		assert myAtoi("4193 with words") == 4193;
		assert myAtoi("words and 987") == 0;
		assert myAtoi("-91283472332") == -2147483648;
		assert myAtoi("-6147483648") == -2147483648;
	}

	public int myAtoi(String str)
	{
		int res = 0;
		if (str == null || str.length() <= 0 || str.trim().length() <= 0)
		{
			return 0;
		}
		str = str.trim();
		boolean negtive = str.startsWith("-");// 是否为负数 后面处理时，就可以只处理数字
		if (negtive || str.startsWith("+"))
		{
			str = str.substring(1);
		}
		Set<Character> set = new HashSet<>();
		set.add('0');
		set.add('1');
		set.add('2');
		set.add('3');
		set.add('4');
		set.add('5');
		set.add('6');
		set.add('7');
		set.add('8');
		set.add('9');
		for (int i = 0; i < str.length(); i++)
		{
			if (!set.contains(str.charAt(i)))
			{
				if (res == 0)
				{
					// 如果此时的 res 为0，肯定是第一次出现非数字
					return 0;
				}
				break;
			}
			if (res > Integer.MAX_VALUE / 10)
			{
				// 溢出了
				return negtive ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}
			res *= 10;
			int digit = Character.digit(str.charAt(i), 10);
			if (res > Integer.MAX_VALUE - digit)
			{
				// 溢出了
				return negtive ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}
			res += digit;
		}
		int r = negtive ? res * -1 : res;
		System.out.println(r);
		return r;
	}
}
