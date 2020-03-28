package com.leon.leetcodeleon.q800.q820;

import org.junit.Test;

import java.util.*;

public class Q820MinimumLengthEncoding
{
	@Test
	public void test()
	{
		assert minimumLengthEncoding(new String[] { "time", "me", "bell" }) == 10;
		assert minimumLengthEncoding(new String[] { "me", "time", "bell" }) == 10;
		assert minimumLengthEncoding(new String[] { "time", "ime", "bell", "abell" }) == 11;
	}

	/**
	 * 2020-03-28 10:14:05 还未理解此解法的含义～
	 * @param words
	 * @return
	 */
	public int minimumLengthEncoding(String[] words)
	{
		Node trie = new Node();
		Map<Node, Integer> nodes = new HashMap<>();

		for (int i = 0; i < words.length; ++i)
		{
			String word = words[i];
			Node cur = trie;
			for (int j = word.length() - 1; j >= 0; --j)
				cur = cur.get(word.charAt(j));
			nodes.put(cur, i);
		}

		int ans = 0;
		for (Node node : nodes.keySet())
		{
			if (node.count == 0)
				ans += words[nodes.get(node)].length() + 1;
		}
		return ans;

	}

	class Node
	{
		Node[] children;
		int count;

		Node()
		{
			this.children = new Node[26];
			this.count = 0;
		}

		public Node get(char c)
		{
			if (this.children[c - 'a'] == null)
			{
				this.children[c - 'a'] = new Node();
				count++;
			}
			return this.children[c - 'a'];
		}
	}

	/**
	 * AC 的解法，使用 set 保存已经出现的单词
	 * 此解法效率极低，生产环境不可使用
	 * @param words
	 * @return
	 */
	public int minimumLengthEncoding_solution(String[] words)
	{
		Set<String> set = new HashSet<>();
		int res = 0;
		for (String word : words)
		{
			boolean find = false;
			for (String s : set)
			{
				if (s.length() >= word.length() && s.endsWith(word))
				{
					find = true;
					break;
				}
				else if (word.endsWith(s))
				{
					set.remove(s);
					set.add(word);
					res -= s.length();
					res += word.length();
					find = true;
				}
			}
			if (!find)
			{
				set.add(word);
				res += word.length() + 1;
			}
		}
		return res;
	}

	/**
	 * 此搞法有问题，对
	 * "time", "ime", "bell", "abell"
	 * 的结果适用错误
	 * @param words
	 * @return
	 */
	public int minimumLengthEncoding_bak(String[] words)
	{
		Arrays.sort(words, new Comparator<String>()
		{
			@Override
			public int compare(String o1, String o2)
			{
				return 0 - o1.compareTo(o2);
			}
		});
		// StringBuilder sb = new StringBuilder();
		int res = 0;
		String per = words[0];
		res += per.length() + 1;
		// sb.append(per);
		// sb.append('#');
		for (int i = 1; i < words.length; i++)
		{
			String word = words[i];
			if (word.length() > per.length())
			{
				// 当前词的长度大于之前的词长度，可以提前结束
				res += word.length() + 1;
				per = word;
				// sb.append(per);
				// sb.append('#');
				continue;
			}
			boolean equal = true;
			int perLen = per.length();
			for (int j = word.length() - 1; j >= 0; j--)
			{
				if (per.charAt(j + (perLen - word.length())) != word.charAt(j))
				{
					equal = false;
					break;
				}
			}
			if (!equal)
			{
				res += word.length() + 1;
				per = word;
				// sb.append(per);
				// sb.append('#');
				continue;
			}
		}
		// System.out.println(sb);
		return res;
	}
}
