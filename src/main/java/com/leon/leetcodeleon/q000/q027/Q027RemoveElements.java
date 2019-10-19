package com.leon.leetcodeleon.q000.q027;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

import java.util.Random;

public class Q027RemoveElements extends BaseTest
{

	@Test
	public void test()
	{
		int[] array = new int[100000000];
		for (int i = 0; i < array.length; i++)
		{
			array[i] = new Random().nextInt(1000000);
		}
		long time = System.currentTimeMillis();
		removeElementV2(array, 2);
		System.out.println("time1: " + (System.currentTimeMillis() - time));
		time = System.currentTimeMillis();
		removeElementV2(array, 2);
		System.out.println("time2: " + (System.currentTimeMillis() - time));
	}

	public int removeElement(int[] nums, int val)
	{
		if (nums.length <= 0)
		{
			return 0;
		}
		int i = 0;
		for (int k = 0; k < nums.length; k++)
		{
			if (nums[k] != val)
			{
				nums[i++] = nums[k];
			}
		}
		//		System.out.println(JSONObject.toJSONString(nums));
		return i;

	}

	public int removeElementV2(int[] nums, int val)
	{
		if (nums.length <= 0)
		{
			return 0;
		}
		int i = nums.length - 1;
		for (int k = i; k >= 0; k--)
		{
			if (nums[k] == val)
			{
				int tmp = nums[i];
				nums[i] = nums[k];
				nums[k] = tmp;
				i--;
			}
		}
		int res = i + 1;
		return res;

	}
}
