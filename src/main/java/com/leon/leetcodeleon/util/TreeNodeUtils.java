package com.leon.leetcodeleon.util;

import com.leon.leetcodeleon.common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeUtils
{
	public static TreeNode generateTree(Integer[] array, int index)
	{
		if (array == null || array.length <= 0)
		{
			return null;
		}
		TreeNode res = null;
		if (index < array.length)
		{
			if (array[index] == null)
			{
				return res;
			}
			res = new TreeNode(array[index]);
			res.left = generateTree(array, 2 * index + 1);
			res.right = generateTree(array, 2 * index + 2);
		}

		return res;
	}

	public void printInOrder(TreeNode root)
	{
		List<Integer> res = new ArrayList<>();
		helper(root, res);
		ObjectUtils.print(res);
	}

	public void helper(TreeNode root, List<Integer> res)
	{
		if (root != null)
		{
			if (root.left != null)
			{
				helper(root.left, res);
			}
			res.add(root.val);
			if (root.right != null)
			{
				helper(root.right, res);
			}
		}
	}

	@Test
	public void test()
	{
		// printInOrder(generateTree(new Integer[] { 1, null, 2, 3 }, 0));
		printInOrder(generateTree(new Integer[] { 1, 2, 3, 4, 5, 6 }, 0));
	}
}
