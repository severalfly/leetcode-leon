package com.leon.leetcodeleon.q000.q020;

import org.junit.Test;

import java.util.Stack;

public class Q020ValidSign
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
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++)
		{
			Character c = s.charAt(i);
			if (c == '(' || c == '[' || c == '{')
			{
				stack.push(c);
			}
			else if (c == ')' || c == ']' || c == '}')
			{
				if (stack.size() <= 0)
				{
					return false;
				}
				Character pop = stack.pop();
				if (c == ')' && pop != '(')
				{
					return false;
				}
				else if (c == ']' && pop != '[')
				{
					return false;
				}
				else if (c == '}' && pop != '{')
				{
					return false;
				}
			}
			else
			{
				continue;
			}
		}
		if(stack.size() > 0)
		{
			return false;
		}
		return true;
	}
}
