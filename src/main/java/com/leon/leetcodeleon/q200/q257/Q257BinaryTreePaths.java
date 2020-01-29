package com.leon.leetcodeleon.q200.q257;

import com.alibaba.fastjson.JSONObject;
import com.leon.leetcodeleon.common.TreeNode;
import com.leon.leetcodeleon.util.TreeNodeUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Q257BinaryTreePaths
{
	@Test
	public void test()
	{
		System.out.println(JSONObject.toJSONString(binaryTreePaths(TreeNodeUtils.generateTreeV2(new Integer[] { 1, 2, 3, null, 5 }))));
	}

	public List<String> binaryTreePaths(TreeNode root)
	{

		List<List<Integer>> r = new ArrayList<>();
		depth(root, new ArrayList<>(), r);
		List<String> res = new ArrayList<>();
		for (List<Integer> list : r)
		{
			StringBuilder sb = new StringBuilder();
			for (Integer integer : list)
			{
				sb.append(integer);
				sb.append("->");
			}
			if (sb.length() >= 2)
			{
				sb.delete(sb.length() - 2, sb.length());
			}
			res.add(sb.toString());
		}
		return res;
	}

	/**
	 *
	 * @param root
	 * @param res 至当前节点时，已经经过的路径
	 * @return
	 */
	private void depth(TreeNode root, List<Integer> res, List<List<Integer>> r)
	{

		if (root == null)
		{
			return;
		}

		if (root.left == null && root.right == null)
		{
			ArrayList<Integer> integers = new ArrayList<>(res);
			integers.add(root.val);
			// res.add(root.val);
			r.add(integers);
			return;
		}
		res.add(root.val);
		depth(root.left, res, r);

		depth(root.right, res, r);
		res.remove(res.size() - 1);

	}
}
