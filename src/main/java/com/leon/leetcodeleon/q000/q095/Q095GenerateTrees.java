package com.leon.leetcodeleon.q000.q095;

import com.alibaba.fastjson.JSONObject;
import com.leon.leetcodeleon.common.TreeNode;
import com.leon.leetcodeleon.util.ObjectUtils;
import com.leon.leetcodeleon.util.TreeNodeUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Q095GenerateTrees
{
	@Test
	public void test()
	{
		List<TreeNode> treeNodes = generateTrees(3);
		for (TreeNode treeNode : treeNodes)
		{
			TreeNodeUtils.printInOrder(treeNode);
		}
	}

	public List<TreeNode> generateTrees(int n)
	{
		if (n <= 0)
		{
			return new ArrayList<>();
		}
		return helper(1, n);
	}

	private List<TreeNode> helper(int start, int end)
	{
		List<TreeNode> all = new ArrayList<>();
		if (start > end)
		{
			all.add(null);
			return all;
		}

		for (int i = start; i <= end; i++)
		{
			List<TreeNode> left = helper(start, i - 1);
			List<TreeNode> right = helper(i + 1, end);
			for (TreeNode l : left)
			{
				for (TreeNode r : right)
				{
					TreeNode t = new TreeNode(i);
					t.left = l;
					t.right = r;
					all.add(t);
				}
			}
		}
		return all;
	}
}
