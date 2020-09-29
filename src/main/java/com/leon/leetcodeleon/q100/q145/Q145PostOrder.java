package com.leon.leetcodeleon.q100.q145;

import com.alibaba.fastjson.JSONObject;
import com.leon.leetcodeleon.common.TreeNode;
import com.leon.leetcodeleon.util.TreeNodeUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.leon.leetcodeleon.q100.q145
 * @author zhangyunfei
 * @date 2020-09-29 21:35
 * @version V1.0
 */
public class Q145PostOrder
{
	@Test
	public void test()
	{
		List<Integer> list = postorderTraversal(TreeNodeUtils.generateTreeV2(new Integer[] { 1, null, 2, 3 }));
		System.out.println(JSONObject.toJSONString(list));
	}

	private List<Integer> res = new ArrayList<>();

	public List<Integer> postorderTraversal(TreeNode root)
	{
		help(root);
		return res;
	}

	private void help(TreeNode root)
	{
		if (root == null)
			return;
		help(root.left);
		help(root.right);
		res.add(root.val);
	}
}
