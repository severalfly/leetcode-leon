package com.leon.leetcodeleon.q500.q501;

import com.alibaba.fastjson.JSONObject;
import com.leon.leetcodeleon.common.TreeNode;
import com.leon.leetcodeleon.util.TreeNodeUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.leon.leetcodeleon.q500.q501
 * @author zhangyunfei
 * @date 2020-09-24 23:03
 * @version V1.0
 */
public class Q501FindMode
{

	@Test
	public void test()
	{
		// findMode(TreeNodeUtils.generateTreeV2(new Integer[] { 1, null, 2, 2 }));
		// res = new ArrayList<>();
		// findMode(TreeNodeUtils.generateTreeV2(new Integer[] { 1, 0, 2, -1, 0, 2 }));
		// res = new ArrayList<>();
		System.out.println(JSONObject.toJSONString(findMode(TreeNodeUtils.generateTreeV2(new Integer[] { 1,1,2 }))));
		// res = new ArrayList<>();
		// System.out.println(JSONObject.toJSONString(findMode(TreeNodeUtils.generateTreeV2(new Integer[] { 1 }))));
	}

	int base = 0;
	int maxCnt = 0;
	int maxCnt1 = 0;
	int max = 0;
	List<Integer> res = new ArrayList<>();

	public int[] findMode(TreeNode root)
	{
		base = Integer.MIN_VALUE;
		helper(root);
		System.out.println(base);
		System.out.println(maxCnt);
		base = Integer.MIN_VALUE;
		helper1(root);
		// System.out.println(JSONObject.toJSONString(res));
		int[] r = new int[res.size()];
		int k = 0;
		for (Integer re : res)
		{
			r[k++] = re;

		}
		return r;
	}

	private void helper(TreeNode root)
	{
		if (root == null)
		{
			return;
		}
		helper(root.left);

		if (root.val == base)
		{
			maxCnt++;
		}
		else
		{
			maxCnt = 1;
			base = root.val;
		}
		if(maxCnt > max)
		{
			max = maxCnt;
		}
		helper(root.right);
	}

	private void helper1(TreeNode root)
	{
		if (root == null)
		{
			return;
		}
		helper1(root.left);

		if (root.val == base)
		{
			maxCnt1++;
			if (maxCnt1 == max)
			{
				res.add(base);
			}
		}
		else
		{
			maxCnt1 = 1;
			base = root.val;
			if (maxCnt1 == max)
			{
				res.add(base);
			}
		}
		helper1(root.right);
	}
}
