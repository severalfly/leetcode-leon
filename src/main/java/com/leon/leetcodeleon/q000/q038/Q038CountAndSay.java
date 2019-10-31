package com.leon.leetcodeleon.q000.q038;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Q038CountAndSay extends BaseTest
{
	@Test
	public void test()
	{
		//		assert countAndSay(1).equalsIgnoreCase("1");
		//		assert countAndSay(2).equalsIgnoreCase("11");
//		assert countAndSay(3).equalsIgnoreCase("21");
		assert countAndSay(4).equalsIgnoreCase("1211");

	}

	public String countAndSay(int n)
	{
		List<Character> list = new ArrayList<>();
		List<Character> per = new ArrayList<>();
		list.add('1');
		per = list;
		for (int i = 2; i <= n; i++)
		{
			list = new ArrayList<>();
			int left = 0;
			int right = 0;
			while (left < per.size())
			{
				if (right >= per.size())
				{
					list.add((char) ('0' + (right - left)));
					list.add(per.get(left));
					break;
				}
				else if (per.get(right) != per.get(left))
				{
					list.add((char) ('0' + (right - left)));
					list.add(per.get(left));
					left = right;
					right++;
				}
				else
				{
					right++;
				}

			}
			per = list;
		}
		StringBuilder res = new StringBuilder();
		for (Character character : list)
		{
			res.append(character);
		}
		System.out.println(res.toString());
		return res.toString();
	}
}
