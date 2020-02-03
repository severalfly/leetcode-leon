package com.leon.leetcodeleon.q100.q103;

import com.leon.leetcodeleon.common.BaseTest;
import com.leon.leetcodeleon.common.TreeNode;
import com.leon.leetcodeleon.util.TreeNodeUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q103zigzagLevelOrder extends BaseTest
{
	@Test
	public void test()
	{
		System.out.println(zigzagLevelOrder(TreeNodeUtils.generateTreeV2(new Integer[] { 1, 2, 3, 4, null, null, 5 })));
		// System.out.println(zigzagLevelOrder(TreeNodeUtils.generateTreeV2(new Integer[] { 3, 9, 20, null, null, 15, 7 })));
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root)
	{
		if (root == null)
		{
			return new ArrayList<>();
		}
		List<List<Integer>> res = new ArrayList<>();
		LinkedList<TreeNode> stack = new LinkedList<>();
		boolean direction = true;// 前向
		stack.add(root);
		while (stack.size() > 0)
		{
			List<Integer> list = new ArrayList<>();
			LinkedList<TreeNode> tmp = new LinkedList<>();
			if (direction)
			{
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
			}
			else
			{
				LinkedList<TreeNode> tmp1 = new LinkedList<>();
				while (stack.size() > 0)
				{
					TreeNode treeNode = stack.pollLast();
					list.add(treeNode.val);

					if (treeNode.right != null)
					{
						tmp1.add(treeNode.right);
					}
					if (treeNode.left != null)
					{
						tmp1.add(treeNode.left);
					}
				}
				while (tmp1.size() > 0)
				{
					TreeNode treeNode = tmp1.pollLast();
					tmp.add(treeNode);

				}
			}
			direction = !direction;
			res.add(list);
			stack = tmp;
		}
		return res;
	}
}
