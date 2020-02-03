package com.leon.leetcodeleon.q100.q102;

import com.leon.leetcodeleon.common.BaseTest;
import com.leon.leetcodeleon.common.TreeNode;
import com.leon.leetcodeleon.util.TreeNodeUtils;
import org.junit.Test;

import java.util.*;

public class Q102LevelOrder extends BaseTest
{
	@Test
	public void test()
	{
		System.out.println(levelOrder(TreeNodeUtils.generateTreeV2(new Integer[] { 3, 9, 20, null, null, 15, 7 })));
	}

	public List<List<Integer>> levelOrder(TreeNode root)
	{
		if (root == null)
		{
			return new ArrayList<>();
		}
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> stack = new LinkedList<>();
		stack.add(root);
		while (stack.size() > 0)
		{
			List<Integer> list = new ArrayList<>();
			Queue<TreeNode> tmp = new LinkedList<>();
			for (TreeNode treeNode : stack)
			{
				list.add(treeNode.val);
				if (treeNode.left != null)
				{
					tmp.add(treeNode.left);
				}
				if (treeNode.right != null)
				{
					tmp.add(treeNode.right);
				}

			}
			res.add(list);
			stack = tmp;
		}
		return res;
	}
}
