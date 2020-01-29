package com.leon.leetcodeleon.q100.q111;

import com.leon.leetcodeleon.common.TreeNode;
import com.leon.leetcodeleon.util.TreeNodeUtils;
import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q111MinDepth
{
	@Test
	public void test()
	{
		assert minDepth(TreeNodeUtils.generateTreeV2(new Integer[] { 3, 9, 20, null, null, 15, 7 })) == 2;
	}

	public int minDepth(TreeNode root)
	{

		List<Pair<TreeNode, Integer>> list = new ArrayList<>();
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
				// depth = Math.max(value, depth);
				stack.add(new Pair<>(key.left, value + 1));
				stack.add(new Pair<>(key.right, value + 1));
				if (key.left == null && key.right == null)
				{
					list.add(poll);
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (Pair<TreeNode, Integer> pair : list)
		{
			if (pair.getValue() < min)
			{
				min = pair.getValue();
			}
		}
		if (min == Integer.MAX_VALUE)
		{
			return 0;
		}
		return min;
	}
}
