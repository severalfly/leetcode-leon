```
给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

示例:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true.
给定 word = "SEE", 返回 true.
给定 word = "ABCB", 返回 false.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-search
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
```

思路
=
典型的深度优先搜索匹配算法。下面简单总结下深度优先搜索算法的思想。

深度优先，为图搜索算法的一种，与广度优先组成两个重要搜索方法，这里仅介绍深度优先。顾名思义，深度优先即为一步步深入搜索。话不多说，来看个例子。

本例为搜索一个图中的2的位置，并输出搜索路径，此为一个简单示例。

```
@Test
	public void testDfs()
	{
		int[][] data = new int[][] { { 1, 1, 1 }, { 0, 0, 1 }, { 0, 0, 2 } };
		// 使用一个数组保存本次递归是否已经到达此位置
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
		// 已经搜索到 value ，可直接结束
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
			// 本搜索为顺着1，搜索2。所以一旦遇到0的，肯定就不是合适的值，也是直接返回
			return;
		}

		// 走到这里的，即为 data[i][j] ==1 的情况，把坐标记录下来，并标记为已经访问
		Pair pair = new Pair();
		pair.l = i;
		pair.r = j;
		res.add(pair);
		marked[i][j] = true;

		// 当前点确认为路径之后，向上下左右各进行一次搜索，
		for (int k = 0; k < 4; k++)
		{
			// 循环上下左右方向的点，进行递归，
			// 这里的 direction 是个神奇的作用，
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
```