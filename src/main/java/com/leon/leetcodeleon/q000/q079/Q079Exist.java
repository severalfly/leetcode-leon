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

	public boolean exist(char[][] board, String word)
	{
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

	@Getter
	@Setter
	class Pair
	{
		int l;
		int r;
	}
}
