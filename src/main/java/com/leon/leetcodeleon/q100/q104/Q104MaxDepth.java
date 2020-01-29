package com.leon.leetcodeleon.q100.q104;

import com.leon.leetcodeleon.common.TreeNode;
import com.leon.leetcodeleon.util.TreeNodeUtils;
import javafx.util.Pair;
import org.junit.Test;

import java.util.*;

public class Q104MaxDepth
{
	@Test
	public void test()
	{
		assert maxDepth(TreeNodeUtils.generateTreeV2(new Integer[] { 3, 9, 20, null, null, 15, 7 })) == 3;
		assert maxDepth(TreeNodeUtils.generateTreeV2(new Integer[] { 0 })) == 1;
	}

	public int maxDepth(TreeNode root)
	{
		Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
		if (root != null)
		{
			stack.add(new Pair<>(root, 1));
		}
		int depth = 0;
		while (!stack.isEmpty())
		{
			Pair<TreeNode, Integer> poll = stack.poll();
			TreeNode key = poll.getKey();
			Integer value = poll.getValue();
			if (key != null)
			{
				depth = Math.max(value, depth);
				stack.add(new Pair<>(key.left, value + 1));
				stack.add(new Pair<>(key.right, value + 1));
			}
		}
		return depth;
	}
}
