package com.leon.leetcodeleon.q1000.q1100.q1013;

import org.junit.Test;

public class Q1013CanThreePartsEqualSum
{
	@Test
	public void test()
	{
		assert canThreePartsEqualSum(new int[] { 12, -4, 16, -5, 9, -3, 3, 8, 0 });
		assert !canThreePartsEqualSum(new int[] { 0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1 });
		assert canThreePartsEqualSum(new int[] { 0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1 });
		assert !canThreePartsEqualSum(new int[] { 0, 2, 1, -6, 6, -7, 9, -1, 2, 0, 1 });
		assert canThreePartsEqualSum(new int[] { 3, 3, 6, 5, -2, 2, 5, 1, -9, 4 });
	}

	public boolean canThreePartsEqualSum(int[] A)
	{
		if (A == null || A.length == 0)
		{
			return false;
		}
		long sum = 0;
		for (int a : A)
		{
			sum += a;
		}
		if (sum % 3 != 0)
		{
			return false;
		}
		long tSum = sum / 3;
		int i = 0;
		for (int n = 0; n < 3; n++)
		{
			int s = 0;
			while (i < A.length)
			{
				s += A[i];
				i++;
				if (s == tSum)
				{
					break;
				}
			}
			if (n == 2)
			{
				while (i < A.length)
				{
					s += A[i];
					i++;
				}
				if (s != tSum)
				{
					return false;
				}
			}
			if (i == A.length)
			{
				return n == 2;
			}
		}

		return false;
	}

}
