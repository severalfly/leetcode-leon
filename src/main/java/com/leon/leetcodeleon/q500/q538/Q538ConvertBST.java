package com.leon.leetcodeleon.q500.q538;

import com.leon.leetcodeleon.common.TreeNode;
import com.leon.leetcodeleon.util.TreeNodeUtils;
import org.junit.Test;

/**
 * @Package com.leon.leetcodeleon.q500.q538
 * @author zhangyunfei
 * @date 2020-09-21 22:47
 * @version V1.0
 */
public class Q538ConvertBST
{
	private int m = 0;

	@Test
	public void test()
	{
		TreeNode treeNode = convertBST(TreeNodeUtils.generateTreeV2(new Integer[] { 2, 0, 3, -4, 1 }));
		TreeNodeUtils.printInOrder(treeNode);
		System.out.println(m);
	}

	public TreeNode convertBST(TreeNode root)
	{
		if (root == null)
		{
			return null;
		}
		convertBST(root.right);
		m += root.val;
		root.val = m;
		convertBST(root.left);
		return root;
	}

}
