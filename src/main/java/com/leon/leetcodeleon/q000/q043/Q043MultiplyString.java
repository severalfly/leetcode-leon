package com.leon.leetcodeleon.q000.q043;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Q043MultiplyString extends BaseTest
{

	@Test
	public void test()
	{
		assert multiply("9", "9").equalsIgnoreCase("81");
		// assert multiply("2", "3").equalsIgnoreCase("6");
		// assert multiply("123", "456").equalsIgnoreCase("56088");
	}

	public String multiply(String num1, String num2)
	{
		if (num1 == null || num2 == null || num1.equalsIgnoreCase("0") || num2.equalsIgnoreCase("0"))
		{
			return "0";
		}
		List<Integer> l1 = new ArrayList<>(num1.length());
		List<Integer> l2 = new ArrayList<>(num2.length());
		for (int i = num1.length() - 1; i >= 0; i--)
		{
			l1.add(Character.digit(num1.charAt(i), 10));
		}
		for (int i = num2.length() - 1; i >= 0; i--)
		{
			l2.add(Character.digit(num2.charAt(i), 10));
		}
		List<Integer> res = new ArrayList<>(num1.length() + num2.length());
		for (int i = 0; i < num1.length() + num2.length(); i++)
		{
			res.add(0);
		}

		for (int i = 0; i < l2.size(); i++)
		{
			int b = l2.get(i);
			int carry = 0;
			// int k = i;
			for (int j = 0; j < l1.size(); j++)
			{
				int a = l1.get(j);
				int sum = a * b + carry + res.get(i + j);
				res.set(i + j, sum % 10);
				carry = sum / 10;
			}
			if (carry > 0)
			{
				res.set(i + l1.size(), carry);
			}
		}
		StringBuilder sb = new StringBuilder();
		boolean start = true;
		for (int i = res.size() - 1; i >= 0; i--)
		{
			if (start && res.get(i) == 0)
			{
				continue;
			}
			start = false;
			sb.append(res.get(i));
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
}
