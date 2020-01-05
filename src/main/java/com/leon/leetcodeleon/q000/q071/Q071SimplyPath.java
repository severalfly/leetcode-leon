package com.leon.leetcodeleon.q000.q071;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q071SimplyPath
{
	@Test
	public void test()
	{
		assert simplifyPath("/home/").equalsIgnoreCase("/home");
		assert simplifyPath("/../").equalsIgnoreCase("/");
		assert simplifyPath("/home//foo/").equalsIgnoreCase("/home/foo");
		assert simplifyPath("/a/./b/../../c/").equalsIgnoreCase("/c");
		assert simplifyPath("/a/../../b/../c//.//").equalsIgnoreCase("/c");
		assert simplifyPath("/a//b////c/d//././/..").equalsIgnoreCase("/a/b/c");
	}

	public String simplifyPath(String path)
	{
		if (path == null || path.length() <= 0)
		{
			return "/";
		}
		Stack<String> stack = new Stack<>();
		String[] split = path.split("/");
		for (int i = split.length - 1; i >= 0; i--)
		{
			stack.push(split[i]);
		}

		List<String> list = new ArrayList<>();
		for (int i = 0; i < split.length; i++)
		{
			list.add("");
		}
		int cnt = 0;
		while (stack.size() > 0)
		{
			String pop = stack.pop();
			if (pop.equalsIgnoreCase("") || pop.equalsIgnoreCase("."))
			{
				continue;
			}
			if (pop.equalsIgnoreCase(".."))
			{
				if (cnt > 0)
				{
					cnt--;
				}
				continue;
			}
			list.set(cnt++, pop);
		}
		StringBuilder sb = new StringBuilder();
		System.out.println(JSONObject.toJSONString(list));
		for (int i = 0; i < cnt; i++)
		{
			sb.append("/");
			sb.append(list.get(i));
		}
		if(sb.length()<=0)
		{
			sb.append("/");
		}
		System.out.println(sb);
		return sb.toString();
	}
}
