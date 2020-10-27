package com.leon.leetcodeleon.q1000.q1024;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.*;

/**
 * @Package com.leon.leetcodeleon.q1000.q1024
 * @author zhangyunfei
 * @date 2020-10-25 20:44
 * @version V1.0
 */
public class Q1024VideoStitching
{
	@Test
	public void test()
	{
		assert videoStitching(new int[][] { { 0, 2 }, { 3, 6 }, { 7, 10 } }, 10) == -1;
		// assert videoStitching(new int[][] { { 0, 2 }, { 4, 6 }, { 8, 10 }, { 1, 9 }, { 1, 5 }, { 5, 9 } }, 10) == 3;
		// assert videoStitching(new int[][] { { 0, 1 }, { 1, 2 } }, 5) == -1;
		// assert videoStitching(new int[][] { { 0, 1 }, { 6, 8 }, { 0, 2 }, { 5, 6 }, { 0, 4 }, { 0, 3 }, { 6, 7 }, { 1, 3 }, { 4, 7 }, { 1, 4 }, { 2, 5 }, { 2, 6 }, { 3, 4 }, { 4, 5 }, { 5, 7 }, { 6, 9 } }, 9) == 3;
		// assert videoStitching(new int[][] { { 0, 4 }, { 2, 8 } }, 5) == 2;
	}

	public int videoStitching(int[][] clips, int T)
	{
		if (clips == null || clips.length <= 0)
		{
			return -1;
		}
		// ?? 难道要我自己写个排序方法，那就太麻烦啦。综合想来，还是使用已有的排序
		List<int[]> tmp = new ArrayList<>();
		for (int[] clip : clips)
		{
			tmp.add(clip);
		}
		Collections.sort(tmp, new Comparator<int[]>()
		{
			@Override
			public int compare(int[] o1, int[] o2)
			{
				// 迷之排序 ~
				if (o1[1] < o2[1])
				{
					return -1;
				}
				else if (o1[1] > o2[1])
				{
					return 1;
				}

				if (o1[0] < o2[0])
				{
					return -1;
				}
				else if (o1[0] > o2[0])
				{
					return 1;
				}
				return 0;
			}
		});
		if (tmp.get(0)[0] > 0)
		{
			// 最开始的点，大于0，这也美法子剪切
			return -1;
		}
		int[] end = tmp.get(tmp.size() - 1);
		if (end[1] < T)
		{
			// 前面已经排序的基础上，最后一个还不能到达结束点，可以提前停止计算了
			// 要注意一个问题，题目中给的列表，结束的值，并不一定是tmp 的最后一个，
			return -1;
		}
		System.out.println(JSONObject.toJSONString(tmp));

		int k = tmp.size() - 1;
		// for (; k >= 0; k--)
		// {
		// 	if (tmp.get(k)[1] < T)
		// 	{
		// 		break;
		// 	}
		// }

		// 到这里时，只要中间能衔接上，就有路子可以通，那么我们来找到这个路子
		int res = 1;
		int i = k;
		for (; i >= 0; i--)
		{
			int[] cl = tmp.get(i);
			if (cl[0] == 0)
			{
				System.out.println(res + 1);
				return res + 1;
			}
			i--;
			while (i >= 0 && cl[0] <= tmp.get(i)[1])
			{
				if (tmp.get(i)[0] == 0)
				{
					return res + 1;
				}
				i--;
			}
			res++;
		}

		return -1;
	}
}
