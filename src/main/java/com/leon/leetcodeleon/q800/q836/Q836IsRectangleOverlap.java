package com.leon.leetcodeleon.q800.q836;

import org.junit.Test;

public class Q836IsRectangleOverlap
{
	@Test
	public void tset()
	{
		assert isRectangleOverlap(new int[] { 0, 0, 2, 2 }, new int[] { 1, 1, 3, 3 });
		assert !isRectangleOverlap(new int[] { 0, 0, 1, 1 }, new int[] { 1, 0, 2, 1 });
		assert isRectangleOverlap(new int[] { 0, 0, 2, 2 }, new int[] { 0, 0, 2, 2 });
	}

	public boolean isRectangleOverlap(int[] rec1, int[] rec2)
	{
		if (rec1[0] > rec2[0])
		{
			int[] tmp = rec1;
			rec1 = rec2;
			rec2 = tmp;
		}
		if (rec1[2] > rec2[0] && rec1[0] <= rec2[3] && rec1[1] <= rec2[3] && rec1[3] > rec2[1])
		{
			return true;
		}
		return false;
	}
}
