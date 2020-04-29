package com.leon.leetcodeleon.q1000.q1095;

import org.junit.Test;

/**
 * @Package com.leon.leetcodeleon.q1000.q1095
 * @author zhangyunfei
 * @date 2020-04-29 10:14
 * @version V1.0
 */
public class Q1095FindInMountainArray
{

	@Test
	public void test()
	{
		MountainArray mountainArray = new MountainArray(new int[] { 1, 2, 3, 4, 5, 3, 1 });
		assert findInMountainArray(3, mountainArray) == 2;
		System.out.println(mountainArray.getCount());

		mountainArray = new MountainArray(new int[] { 0, 1, 2, 4, 2, 1 });
		assert findInMountainArray(3, mountainArray) == -1;
		System.out.println(mountainArray.getCount());

		mountainArray = new MountainArray(new int[] { 0, 1, 2, 4 });
		assert findInMountainArray(4, mountainArray) == 3;
		System.out.println(mountainArray.getCount());

		mountainArray = new MountainArray(new int[] { 0, 5, 3, 1 });
		assert findInMountainArray(1, mountainArray) == 3;
		System.out.println(mountainArray.getCount());
	}

	public int findInMountainArray(int target, MountainArray mountainArr)
	{
		int l = 0;
		int r = mountainArr.length() - 1;

		while (l <= r)
		{
			int mid = (l + r) / 2;
			if (mid + 1 == mountainArr.length())
			{
				l = mountainArr.length() - 1;
				break;
			}
			if (mountainArr.get(mid) < mountainArr.get(mid + 1))
			{
				l = mid + 1;
			}
			else
			{
				r = mid - 1;
			}
		}
		System.out.println(l);
		int index = binarySearch(target, mountainArr, 0, l, true);
		if (index < 0)
		{
			index = binarySearch(target, mountainArr, l + 1, mountainArr.length() - 1, false);
		}
		return index;
	}

	private int binarySearch(int target, MountainArray mountainArr, int s, int e, boolean dir)
	{
		int l = s;
		int r = e;
		while (l <= r)
		{
			int mid = (l + r) / 2;
			int i = mountainArr.get(mid);
			if (i == target)
			{
				return mid;
			}
			else if (i > target)
			{
				if (dir)
					r = mid - 1;
				else
					l = mid + 1;
			}
			else
			{
				if (dir)
					l = mid + 1;
				else
					r = mid - 1;
			}

		}
		return -1;
	}

	class MountainArray
	{
		private int[] data;
		public int count = 0;

		MountainArray(int[] data)
		{
			this.data = data;
		}

		public int get(int index)
		{
			count++;
			return data[index];
		}

		public int length()
		{
			return data.length;
		}

		public int getCount()
		{
			return this.count;
		}

		public void setCount(int count)
		{
			this.count = count;
		}
	}
}
