package com.leon.leetcodeleon.q800.q844.q845;

import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

/**
 * @Package com.leon.leetcodeleon.q800.q844.q845
 * @author zhangyunfei
 * @date 2020-10-25 19:26
 * @version V1.0
 */
public class Q845LongestMountain
{
	@Test
	public void test()
	{
		assert longestMountain(new int[] { 2, 3, 3, 2, 0, 2 }) == 0;
		assert longestMountain(new int[] { 2, 1, 4, 7, 3, 2, 5 }) == 5;
		assert longestMountain(new int[] { 2, 2, 2 }) == 0;
		assert longestMountain(new int[] { 1, 2, 1 }) == 3;
		assert longestMountain(new int[] { 1, 2, 1, 2, 3, 2 }) == 4;
	}

	public int longestMountain(int[] A)
	{
		if (A == null || A.length < 3)
		{
			return 0;
		}
		int tmp[] = new int[A.length];
		int k = 0;
		int i = 1;
		for (; i < A.length; i++)
		{
			// 舍弃前面的平峰与降峰
			if (A[i] > A[i - 1])
			{
				break;
			}
		}
		i = i > 1 ? i : 1;
		for (; i < A.length; i++)
		{
			if (A[i] > A[i - 1])
			{
				tmp[k++] = 1;
			}
			else if (A[i] == A[i - 1])
			{
				tmp[k++] = 0;
			}
			else
			{
				tmp[k++] = -1;
			}
		}

		print(tmp);
		int[] tmpV2 = new int[k];
		int l = 0;
		for (i = 0; i < tmp.length; i++)
		{
			int c = 0;
			if (tmp[i] == 1)
			{
				c = 1;
				int endZero = 0;
				while (i < tmp.length)
				{
					if (tmp[i + 1] != 1)
					{
						if (tmp[i + 1] == 0)
						{
							endZero = 1;
						}
						break;
					}
					c++;
					i++;
				}
				if (endZero == 0)
					tmpV2[l++] = c;
			}
			else if (tmp[i] == -1)
			{
				c = 1;
				while (i < tmp.length)
				{
					if (tmp[i + 1] != -1)
					{
						break;
					}
					c++;
					i++;
				}
				tmpV2[l++] = -c;
			}
		}

		print(tmpV2);
		// 最后把一正一负加起来即可
		int maxLen = 0;
		for (i = 1; i < tmpV2.length; i++)
		{
			if (tmpV2[i] < 0 && tmpV2[i - 1] > 0)
			{
				// 这是一个山脉，记录最大长度即可
				int len = tmpV2[i - 1] - tmpV2[i] + 1;
				if (len > maxLen)
				{
					maxLen = len;
				}
			}
		}
		System.out.println(maxLen);
		return maxLen;
	}

	private void print(int[] tmpV2)
	{
		ObjectUtils.print(tmpV2);
	}
}
