package com.leon.leetcodeleon.q00.q013;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class Q013RomeToInt
{
	@Test
	public void test()
	{
		assert romanToInt("III") == 3;
		assert romanToInt("IV") == 4;
		assert romanToInt("IX") == 9;
		assert romanToInt("LVIII") == 58;
		assert romanToInt("MCMXCIV") == 1994;
	}

	public int romanToInt(String s)
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
		int res = 0;
		for (Map.Entry<Integer, String> me : map.entrySet())
		{
			while(s.startsWith(me.getValue()))
			{
				res += me.getKey();
				s = s.substring(me.getValue().length());
			}
		}
		return res;
	}
}
