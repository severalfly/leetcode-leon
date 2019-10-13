package com.leon.leetcodeleon.q000.q017;

import com.alibaba.fastjson.JSONObject;
import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

import java.util.*;

public class Q017LetterCombinations extends BaseTest
{
	@Test
	public void test()
	{
		assert letterCombinations("23").size() == 9;
	}

	public List<String> letterCombinations(String digits)
	{
		if (digits == null || digits.length() <= 0)
		{
			return new ArrayList<>(0);
		}
		Map<Character, List<Character>> map = new HashMap<>();
		map.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
		map.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
		map.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
		map.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
		map.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
		map.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
		map.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
		map.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));

		List<String> per = new ArrayList<>();

		for (Character character : map.get(digits.charAt(0)))
		{
			per.add(character + "");
		}
		for (int i = 1; i < digits.length(); i++)
		{
			List<String> tmp = new ArrayList<>();
			for (Character character : map.get(digits.charAt(i)))
			{
				for (String s : per)
				{
					tmp.add(s + character);
				}
			}
			per = tmp;
		}
		System.out.println(JSONObject.toJSONString(per));
		return per;
	}
}
