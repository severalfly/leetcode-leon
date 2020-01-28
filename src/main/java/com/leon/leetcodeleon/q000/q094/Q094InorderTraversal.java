package com.leon.leetcodeleon.q000.q094;

import com.leon.leetcodeleon.common.BaseTest;
import com.leon.leetcodeleon.common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Q094InorderTraversal extends BaseTest
{
	@Test
	public void test()
	{

	}

	public List<Integer> inorderTraversal(TreeNode root)
	{
		List<Integer> res = new ArrayList<>();
		helper(root, res);
		return res;
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
}
