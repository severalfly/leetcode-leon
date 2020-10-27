package com.leon.leetcodeleon.q100.q144;

import com.leon.leetcodeleon.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.leon.leetcodeleon.q100.q144
 * @author zhangyunfei
 * @date 2020-10-27 22:06
 * @version V1.0
 */
public class Q144PreorderTraversal
{
	private List<Integer> res = new ArrayList<>();

	public List<Integer> preorderTraversal(TreeNode root)
	{
		help(root);
		return res;
	}

	private void help(TreeNode root)
	{
		if (root == null)
		{
			return;
		}
		res.add(root.val);
		help(root.left);
		help(root.right);
	}
}
