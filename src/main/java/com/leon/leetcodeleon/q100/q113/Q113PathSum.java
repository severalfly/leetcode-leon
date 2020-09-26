package com.leon.leetcodeleon.q100.q113;

import com.alibaba.fastjson.JSONObject;
import com.leon.leetcodeleon.common.BaseTest;
import com.leon.leetcodeleon.common.TreeNode;
import com.leon.leetcodeleon.util.TreeNodeUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Q113PathSum extends BaseTest
{
	@Test
	public void test()
	{
		System.out.println(JSONObject.toJSONString(pathSum(TreeNodeUtils.generateTreeV2(new Integer[] { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1 }), 22)));
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum)
	{
		List<List<Integer>> res = new ArrayList<>();
		depthV2(root, sum, new ArrayList<>(), res);
		return res;
	}

	/**
	 *
	 * @param root
	 * @param sum
	 * @param res 至当前节点时，已经经过的路径
	 * @return
	 */
	private void depthV2(TreeNode root, int sum, List<Integer> res, List<List<Integer>> r)
	{
		if (root == null)
		{
			return;
		}
		int tmp = sum - root.val;
		if (tmp == 0 && root.left == null && root.right == null)
		{
			ArrayList<Integer> integers = new ArrayList<>(res);
			integers.add(root.val);
			r.add(integers);
			return;
		}
		res.add(root.val);
		depthV2(root.left, tmp, res, r);
		depthV2(root.right, tmp, res, r);
		res.remove(res.size() - 1);

	}

	/**
	 *
	 * @param root
	 * @param sum
	 * @param res 至当前节点时，已经经过的路径
	 * @return
	 */
	private void depth(TreeNode root, int sum, List<Integer> res, List<List<Integer>> r)
	{

		if (root == null)
		{
			return;
		}

		int tmp = sum - root.val;
		if (root.left == null && root.right == null && tmp == 0)
		{
			ArrayList<Integer> integers = new ArrayList<>(res);
			integers.add(root.val);
			// res.add(root.val);
			r.add(integers);
			return;
		}
		res.add(root.val);
		depth(root.left, tmp, res, r);

		depth(root.right, tmp, res, r);
		res.remove(res.size() - 1);

	}
}
