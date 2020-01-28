package com.leon.leetcodeleon.q000.q094;

import com.leon.leetcodeleon.common.BaseTest;
import com.leon.leetcodeleon.common.TreeNode;
import com.leon.leetcodeleon.util.ObjectUtils;
import com.leon.leetcodeleon.util.TreeNodeUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q094InorderTraversal extends BaseTest
{
	@Test
	public void test()
	{
		ObjectUtils.print(inorderTraversalNoneRepeat(TreeNodeUtils.generateTreeV2(new Integer[] { 1, null, 2, 3 })));
	}

	public List<Integer> inorderTraversalNoneRepeat(TreeNode root)
	{
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (cur != null || stack.size() > 0)
		{
			while (cur != null)
			{
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			res.add(cur.val);
			cur = cur.right;
		}
		return res;
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
