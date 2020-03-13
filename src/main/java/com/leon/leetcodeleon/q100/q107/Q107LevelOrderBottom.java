package com.leon.leetcodeleon.q100.q107;

import com.alibaba.fastjson.JSONObject;
import com.leon.leetcodeleon.common.TreeNode;
import com.leon.leetcodeleon.util.TreeNodeUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q107LevelOrderBottom
{
	@Test
	public void test()
	{
		System.out.println(JSONObject.toJSONString(levelOrderBottom(TreeNodeUtils.generateTreeV2(new Integer[] { 3, 9, 20, null, null, 15, 7 }))));
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root)
	{
		if (root == null)
		{
			return new ArrayList<>();
		}
		List<List<Integer>> res = new ArrayList<>();
		List<TreeNode> tmp = new ArrayList<>();
		tmp.add(root);
		List<Integer> l = new ArrayList<>();
		l.add(root.val);
		res.add(l);

		while (true)
		{
			l = new ArrayList<>();
			List<TreeNode> t = new ArrayList<>();
			for (TreeNode treeNode : tmp)
			{
				if (treeNode.left != null)
				{
					l.add(treeNode.left.val);
					t.add(treeNode.left);
				}
				if (treeNode.right != null)
				{
					l.add(treeNode.right.val);
					t.add(treeNode.right);
				}
			}
			tmp = t;
			if (t.size() <= 0)
			{
				break;
			}
			res.add(l);
		}
		Collections.reverse(res);
		return res;
	}
}
