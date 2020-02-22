package com.leon.leetcodeleon.q000.q079;

import com.alibaba.fastjson.JSONObject;
import com.leon.leetcodeleon.common.BaseTest;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Q079Exist extends BaseTest
{
	private int[][] direction = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
	boolean[][] marked = null;

	@Test
	public void test()
	{
		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		marked = new boolean[board.length][board[0].length];
		// System.out.println(dfs(0, 0, board, 0, "B"));
		assert exist(board, "ABCCED");
		assert exist(board, "SEE");
		assert !exist(board, "ABCB");
	}

	@Test
	public void test1()
	{
		char[][] board = new char[][] { { 'A' } };
		marked = new boolean[board.length][board[0].length];
		// System.out.println(dfs(0, 0, board, 0, "A"));
		assert exist(board, "A");
		assert !exist(board, "AB");
		assert !exist(board, "C");
	}

	public boolean exist(char[][] board, String word)
	{
		if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() <= 0)
		{
			return false;
		}
		marked = new boolean[board.length][board[0].length];
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (dfs(i, j, board, 0, word))
				{
					return true;
				}
			}
		}
		return false;
	}

	/**
	 *
	 * @param i 当前开始步骤
	 * @param j 当前开始步骤
	 * @param data 原始数据，在这个二维表中搜索
	 */
	private boolean dfs(int i, int j, char[][] data, int start, String word)
	{

		if (start == word.length())
		{
			return true;
		}

		// Pair pair = new Pair();
		// pair.l = i;
		// pair.r = j;
		// res.add(pair);
		if (word.charAt(start) != data[i][j])
		{
			return false;
		}
		if (start + 1 == word.length())
		{
			return true;
		}
		marked[i][j] = true;
		for (int k = 0; k < 4; k++)
		{
			int ni = i + direction[k][0];
			int nj = j + direction[k][1];
			if (inArea(ni, nj, data) && !marked[ni][nj])
			{
				boolean dfs = dfs(ni, nj, data, start + 1, word);
				if (dfs)
				{
					return true;
				}
			}
		}
		marked[i][j] = false;
		return false;
	}

	@Test
	public void testDfs()
	{
		int[][] data = new int[][] { { 1, 1, 1 }, { 0, 0, 1 }, { 0, 0, 2 } };
		boolean[][] marked = new boolean[data.length][data[0].length];
		List<Pair> res = new ArrayList<>();
		tDfs(0, 0, 2, data, res, marked);
		System.out.println(JSONObject.toJSONString(res));
	}

	/**
	 *
	 * @param i 当前开始步骤
	 * @param j 当前开始步骤
	 * @param value 需要搜索的值，第一次找到这个值，即结束
	 * @param data 原始数据，在这个二维表中搜索
	 * @param res 结果，成对出现的坐标
	 */
	private void tDfs(int i, int j, int value, int[][] data, List<Pair> res, boolean[][] marked)
	{
		if (data[i][j] == value)
		{
			Pair pair = new Pair();
			pair.l = i;
			pair.r = j;
			res.add(pair);
			marked[i][j] = true;
			return;
		}
		if (data[i][j] == 0)
		{
			return;
		}

		Pair pair = new Pair();
		pair.l = i;
		pair.r = j;
		res.add(pair);
		marked[i][j] = true;
		for (int k = 0; k < 4; k++)
		{
			int ni = i + direction[k][0];
			int nj = j + direction[k][1];
			if (inArea(ni, nj, data) && !marked[ni][nj])
			{
				tDfs(ni, nj, value, data, res, marked);
			}
		}
		marked[i][j] = false;
	}

	private boolean inArea(int x, int y, int[][] data)
	{
		return x >= 0 && x < data.length && y >= 0 && y < data[0].length;
	}

	private boolean inArea(int x, int y, char[][] data)
	{
		return x >= 0 && x < data.length && y >= 0 && y < data[0].length;
	}

	@Getter
	@Setter
	class Pair
	{
		int l;
		int r;
	}
}
