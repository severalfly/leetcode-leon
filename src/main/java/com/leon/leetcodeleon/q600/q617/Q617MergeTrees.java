package com.leon.leetcodeleon.q600.q617;

import com.leon.leetcodeleon.common.TreeNode;
import com.leon.leetcodeleon.util.TreeNodeUtils;
import org.junit.Test;

/**
 * @Package com.leon.leetcodeleon.q600.q617
 * @author zhangyunfei
 * @date 2020-09-23 22:52
 * @version V1.0
 */
public class Q617MergeTrees
{
	@Test
	public void test()
	{
		TreeNode t1 = TreeNodeUtils.generateTreeV2(new Integer[] { 1, 3, 2, 5 });
		TreeNode t2 = TreeNodeUtils.generateTreeV2(new Integer[] { 2, 1, 3, null, 4, null, 7 });
		TreeNode treeNode = mergeTrees(t1, t2);
		TreeNodeUtils.printInOrder(treeNode);
	}

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2)
	{
		TreeNode helper = helper(t1, t2);
		return helper;
	}

	private TreeNode helper(TreeNode t1, TreeNode t2)
	{
		if (t2 == null)
		{
			return t1;
		}
		if (t1 == null)
		{
			return t2;
		}
		t1.val += t2.val;
		t1.left = helper(t1.left, t2.left);
		t1.right = helper(t1.right, t2.right);
		return t1;
	}
}
