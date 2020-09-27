package com.leon.leetcodeleon.q200.q235;

import com.leon.leetcodeleon.common.TreeNode;
import com.leon.leetcodeleon.util.TreeNodeUtils;
import org.junit.Test;

/**
 * @Package com.leon.leetcodeleon.q200.q235
 * @author zhangyunfei
 * @date 2020-09-27 23:12
 * @version V1.0
 */
public class Q235LowestCommonAcestor
{
	@Test
	public void test()
	{
		TreeNode root = TreeNodeUtils.generateTreeV2(new Integer[] { 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5 });
		TreeNode p = TreeNodeUtils.generateTreeV2(new Integer[] { 2 });
		TreeNode q = TreeNodeUtils.generateTreeV2(new Integer[] { 4 });
		TreeNode treeNode = lowestCommonAncestor(root, p, q);
		System.out.println(treeNode.val);
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
	{
		TreeNode anc = root;
		while (true)
		{
			if (anc.val > p.val && anc.val > q.val)
			{
				anc = anc.left;
			}
			else if (anc.val < p.val && anc.val < q.val)
			{
				anc = anc.right;
			}
			else
			{
				break;
			}
		}
		return anc;
	}
}
