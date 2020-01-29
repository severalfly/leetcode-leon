package com.leon.leetcodeleon.q400.q437;

import com.alibaba.fastjson.JSONObject;
import com.leon.leetcodeleon.common.TreeNode;
import com.leon.leetcodeleon.util.TreeNodeUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Q437pathSum
{
	@Test
	public void test()
	{
		System.out.println(JSONObject.toJSONString(pathSum(TreeNodeUtils.generateTreeV2(new Integer[] { 10, 5, -3, 3, 2, null, 11, 3, -2, null, 1 }), 8)));
	}

	public int pathSum(TreeNode root, int sum)
	{
		return depth(root, sum, new ArrayList<>(), 0);
	}

	/**
	 *
	 * @param root
	 * @param sum
	 * @param res 至当前节点时，已经经过的路径
	 * @return
	 */
	private int depth(TreeNode root, int sum, List<Integer> res, int p)
	{

		if (root == null)
		{
			return 0;
		}
		int tmp = root.val;
		int n = root.val == sum ? 1 : 0;
		for (int i = p - 1; i >= 0; i--)
		{
			tmp += res.get(i);
			if (tmp == sum)
			{
				n++;
			}
		}

		res.add(root.val);
		int n1 = depth(root.left, sum, res, p + 1);

		int n2 = depth(root.right, sum, res, p + 1);
		res.remove(res.size() - 1);
		return n + n1 + n2;
	}
}
