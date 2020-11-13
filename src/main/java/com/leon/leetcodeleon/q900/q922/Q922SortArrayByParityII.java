package com.leon.leetcodeleon.q900.q922;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.leon.leetcodeleon.q900.q922
 * @author zhangyunfei
 * @date 2020-11-12 22:02
 * @version V1.0
 */
public class Q922SortArrayByParityII
{
	@Test
	public void test()
	{
		System.out.println(JSONObject.toJSONString(sortArrayByParityII(new int[] { 4, 2, 5, 7 })));
		System.out.println(JSONObject.toJSONString(sortArrayByParityII(new int[] {})));
	}

	public int[] sortArrayByParityII(int[] A)
	{
		List<Integer> even = new ArrayList<>(A.length / 2 + 1); // 偶数
		List<Integer> odd = new ArrayList<>(A.length / 2 + 1); // 奇数
		for (int i = 0; i < A.length; i++)
		{
			if (A[i] % 2 == 0)
			{
				even.add(A[i]);
			}
			else
			{
				odd.add(A[i]);
			}
		}
		int[] res = new int[A.length];
		for (int i = 0; i < even.size(); i++)
		{
			res[2 * i] = even.get(i);
		}
		for (int i = 0; i < odd.size(); i++)
		{
			res[2 * i + 1] = odd.get(i);
		}
		return res;
	}
}
