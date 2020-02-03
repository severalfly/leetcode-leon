package com.leon.leetcodeleon.q100.q100;

import com.leon.leetcodeleon.common.TreeNode;
import com.leon.leetcodeleon.util.TreeNodeUtils;
import org.junit.Test;

import java.util.Stack;

public class Q100IsSameTree
{
	@Test
	public void test()
	{
		assert isSameTree(TreeNodeUtils.generateTreeV2(new Integer[] { 0 }), TreeNodeUtils.generateTreeV2(new Integer[] { 0 }));
		assert isSameTree(TreeNodeUtils.generateTreeV2(new Integer[] { 1, 2, 3 }), TreeNodeUtils.generateTreeV2(new Integer[] { 1, 2, 3 }));
		assert !isSameTree(TreeNodeUtils.generateTreeV2(new Integer[] { 1, 2 }), TreeNodeUtils.generateTreeV2(new Integer[] { 1, null, 2 }));
		assert !isSameTree(TreeNodeUtils.generateTreeV2(new Integer[] { 1, 2, 2 }), TreeNodeUtils.generateTreeV2(new Integer[] { 1, 1, 2 }));
		assert !isSameTree(TreeNodeUtils.generateTreeV2(new Integer[] { 2, null, 4 }), TreeNodeUtils.generateTreeV2(new Integer[] { 2, 3, 4 }));
	}

	public boolean isSameTree(TreeNode p, TreeNode q)
	{

		if (p == null)
		{
			return q == null;
		}
		if (q == null)
		{
			return false;
		}
		if (p.val != q.val)
		{
			return false;
		}
		Stack<TreeNode> sp = new Stack<>();
		// sp.add(p);
		Stack<TreeNode> sq = new Stack<>();
		// sq.add(q);
		TreeNode cur = p;
		TreeNode curq = q;
		while (cur != null || sp.size() > 0)
		{
			while (cur != null)
			{
				if (curq == null)
				{
					return false;
				}
				if (cur.val != curq.val)
				{
					return false;
				}
				sp.push(cur);
				sq.push(curq);
				cur = cur.left;
				curq = curq.left;
				if (cur == null && curq != null)
				{
					return false;
				}
				else if (cur != null && curq == null)
				{
					return false;
				}
			}
			TreeNode pop = sp.pop();
			TreeNode pop1 = sq.pop();
			if (pop.val != pop1.val)
			{
				return false;
			}
			cur = pop.right;
			curq = pop1.right;
			if (cur == null && curq != null)
			{
				return false;
			}
			else if (cur != null && curq == null)
			{
				return false;
			}
		}

		return true;
	}
}
