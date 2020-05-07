package com.leon.leetcodeleon.q500.q572;

import com.leon.leetcodeleon.common.TreeNode;
import com.leon.leetcodeleon.util.TreeNodeUtils;
import org.junit.Test;

/**
 * @Package com.leon.leetcodeleon.q500.q572
 * @author zhangyunfei
 * @date 2020-05-07 07:11
 * @version V1.0
 */
public class Q572IsSubTree
{
	@Test
	public void test()
	{
		assert !isSubtree(TreeNodeUtils.generateTreeV2(new Integer[] { 3, 4, 5, 1, 2, null, null, 0 }), TreeNodeUtils.generateTreeV2(new Integer[] { 4, 1, 2 }));
		assert isSubtree(TreeNodeUtils.generateTreeV2(new Integer[] { 3, 4, 5, 1, 2 }), TreeNodeUtils.generateTreeV2(new Integer[] { 4, 1, 2 }));
		assert !isSubtree(TreeNodeUtils.generateTreeV2(new Integer[] { 3, 4, 5,1,2, null, null, null, null, 0 }), TreeNodeUtils.generateTreeV2(new Integer[] { 4, 1, 2 }));
	}

	public boolean isSubtree(TreeNode s, TreeNode t)
	{
		TreeNodeUtils.printInOrder(s);
		TreeNodeUtils.printInOrder(t);

		String h1 = help(s);
		String h2 = help(t);
		System.out.println(h1);
		System.out.println(h2);
		return h1.contains(h2);
	}

	private String help(TreeNode t)
	{
		if (t == null)
		{
			return "Null,";
		}
		StringBuilder sb = new StringBuilder();
		if (t.left != null)
		{
			sb.append(help(t.left));
		}
		else
		{
			sb.append("lNull");
		}
		sb.append(t.val);
		sb.append(",");
		if (t.right != null)
		{
			sb.append(help(t.right));
		}
		else
		{
			sb.append("rNull");
		}
		return sb.toString();
	}
}
