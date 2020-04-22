package com.leon.leetcodeleon.q100.q199;

import com.alibaba.fastjson.JSONObject;
import com.leon.leetcodeleon.common.TreeNode;
import com.leon.leetcodeleon.util.TreeNodeUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q199RightSideView
{
	@Test
	public void test()
	{
		System.out.println(JSONObject.toJSONString(rightSideView(TreeNodeUtils.generateTreeV2(new Integer[] { 1, 2, 3, null, 5, null, 4 }))));
	}

	public List<Integer> rightSideView(TreeNode root)
	{
		if (root == null)
		{
			return new ArrayList<>(0);
		}
		List<Integer> res = new ArrayList<>();
		LinkedList<TreeNode> stack = new LinkedList<>();
		stack.add(root);
		while (stack.size() > 0)
		{
			LinkedList<TreeNode> tmp = new LinkedList<>();
			boolean first = true;
			while (stack.size() > 0)
			{
				TreeNode pop = stack.poll();
				if (first)
				{
					res.add(pop.val);
					first = false;
				}
				if (pop.right != null)
				{
					tmp.add(pop.right);
				}
				if (pop.left != null)
				{
					tmp.add(pop.left);
				}

			}
			stack = tmp;

		}
		return res;
	}

}
