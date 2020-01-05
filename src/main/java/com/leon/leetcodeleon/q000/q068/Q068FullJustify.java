package com.leon.leetcodeleon.q000.q068;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Q068FullJustify
{
	@Test
	public void test()
	{
		// fullJustify(new String[] { "everything", "else", "we", "do" }, 20);
		fullJustify(new String[] { "This", "is", "an", "example", "of", "text", "justification." }, 16);
		fullJustify(new String[] { "What", "must", "be", "acknowledgment", "shall", "be" }, 16);
		fullJustify(new String[] { "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do" }, 20);
	}

	public List<String> fullJustify(String[] words, int maxWidth)
	{
		List<List<String>> rs = new ArrayList<>();
		List<String> tmp = new ArrayList<>();
		int tLen = 0;
		for (String word : words)
		{
			tLen += word.length() + 1;
			if (tLen <= maxWidth + 1)
			{
				tmp.add(word);
				continue;
			}
			rs.add(tmp);
			tLen = word.length() + 1;
			tmp = new ArrayList<>();
			tmp.add(word);
		}
		if (tmp.size() > 0)
		{
			rs.add(tmp);
		}
		// System.out.println(JSONObject.toJSONString(rs));
		// 开始分配 空格
		List<String> result = new ArrayList<>();

		for (int k = 0; k < rs.size(); k++)
		{
			List<String> list = rs.get(k);
			StringBuilder sb = new StringBuilder();
			int aLen = 0;
			for (String s : list)
			{
				aLen += s.length();
			}
			// 这一行的空格数
			int sCnt = maxWidth - aLen;
			// 需要减1，因为单词需要两边对齐
			// 普通空格数
			int b = list.size() > 1 ? (sCnt / (list.size() - 1)) : sCnt;
			// 空格数可能分配不均，左侧多的空格数
			int c = list.size() > 1 ? (sCnt % (list.size() - 1)) : 0;
			sb.append(list.get(0));
			for (int i = 1; i < list.size(); i++)
			{
				if (k < rs.size() - 1)
				{
					for (int j = 0; j < b; j++)
					{
						sb.append(' ');
					}
					if (c > 0)
					{
						sb.append(' ');
						c--;
					}
				}
				else
				{
					sb.append(' ');
				}
				sb.append(list.get(i));
			}
			for (int i = sb.length(); i < maxWidth; i++)
			{
				sb.append(' ');
			}
			result.add(sb.toString());
		}
		// System.out.println(JSONObject.toJSONString(result));
		return result;
	}
}
