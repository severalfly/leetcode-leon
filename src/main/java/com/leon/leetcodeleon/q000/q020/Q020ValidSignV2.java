package com.leon.leetcodeleon.q000.q020;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

import java.util.Stack;

public class Q020ValidSignV2 extends BaseTest
{
	@Test
	public void test()
	{
		assert isValid("()");
		assert isValid("()[]{}");
		assert !isValid("(]");
		assert !isValid("([)]");
		assert isValid("{[]}");
		assert !isValid("]");
		assert !isValid("[");

	}

	public boolean isValid(String s)
	{
		if (s == null)
		{
			return false;
		}
		if (s.length() <= 0)
		{
			return true;
		}
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++)
		{
			Character c = s.charAt(i);
			if (c == '(' || c == '[' || c == '{')
			{
				stack.push(c);
			}
			else if (c == ')')
			{
				if (stack.size() <= 0 || stack.pop() != '(')
				{
					return false;
				}
			}
			else if (c == ']')
			{
				if (stack.size() <= 0 || stack.pop() != '[')
				{
					return false;
				}
			}
			else if (c == '}')
			{
				if (stack.size() <= 0 || stack.pop() != '{')
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		return stack.size() <= 0;
	}
}
