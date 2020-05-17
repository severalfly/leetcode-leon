package com.leon.leetcodeleon.q200.q210;

import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.leon.leetcodeleon.q200.q210
 * @author zhangyunfei
 * @date 2020-05-17 20:52
 * @version V1.0
 */
public class Q210FindOrder
{
	private List<List<Integer>> edgs;
	private int[] visited;
	private boolean invalid = false;
	private int[] res;
	private int index;

	@Test
	public void test()
	{
		ObjectUtils.print(findOrder(2, new int[][] { { 1, 0 } }));
		ObjectUtils.print(findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } }));
	}

	public int[] findOrder(int numCourses, int[][] prerequisites)
	{
		this.edgs = new ArrayList<>();
		for (int i = 0; i < numCourses; i++)
		{
			this.edgs.add(new ArrayList<>());
		}
		for (int[] prerequisite : prerequisites)
		{
			this.edgs.get(prerequisite[1]).add(prerequisite[0]);
		}

		res = new int[numCourses];
		index = numCourses - 1;
		visited = new int[numCourses];

		for (int i = 0; i < this.edgs.size(); i++)
		{
			if (visited[i] == 0)
			{
				dfs(i);
			}
		}

		if (invalid)
		{
			return new int[0];
		}
		return res;
	}

	private void dfs(int u)
	{
		visited[u] = 1;
		for (int v : this.edgs.get(u))
		{
			if (this.visited[v] == 0)
			{
				dfs(v);
				if (invalid)
				{
					return;
				}
			}
			else if (this.visited[v] == 1)
			{
				this.invalid = true;
			}
		}
		visited[u] = 2;
		res[index--] = u;
	}
}
