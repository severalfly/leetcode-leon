package com.leon.leetcodeleon.q000.q012;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class Q012IntToRome
{
	@Test
	public void test()
	{
		assert intToRoman(3).equalsIgnoreCase("III");
		assert intToRoman(4).equalsIgnoreCase("IV");
		assert intToRoman(9).equalsIgnoreCase("IX");
		assert intToRoman(58).equalsIgnoreCase("LVIII");
		assert intToRoman(1994).equalsIgnoreCase("MCMXCIV");

	}

	public String intToRoman(int num)
	{
		Map<Integer, String> map = new LinkedHashMap<>();
		map.put(1000, "M");
		map.put(900, "CM");
		map.put(500, "D");
		map.put(400, "CD");
		map.put(100, "C");
		map.put(90, "XC");
		map.put(50, "L");
		map.put(40, "XL");
		map.put(10, "X");
		map.put(9, "IX");
		map.put(5, "V");
		map.put(4, "IV");
		map.put(1, "I");
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Integer, String> me : map.entrySet())
		{
			while (num >= me.getKey())
			{
				sb.append(me.getValue());
				num -= me.getKey();
			}
		}
		return sb.toString();

	}
}
