package com.leon.leetcodeleon.util;

import com.leon.leetcodeleon.common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNodeUtils
{
	public static TreeNode generateTreeV2(Integer[] nums)
	{

		if (nums.length == 0)
			return new TreeNode(0);
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		// 创建一个根节点
		TreeNode root = new TreeNode(nums[0]);
		nodeQueue.offer(root);
		TreeNode cur;
		// 记录当前行节点的数量（注意不一定是2的幂，而是上一行中非空节点的数量乘2）
		int lineNodeNum = 2;
		// 记录当前行中数字在数组中的开始位置
		int startIndex = 1;
		// 记录数组中剩余的元素的数量
		int restLength = nums.length - 1;

		while (restLength > 0)
		{
			// 只有最后一行可以不满，其余行必须是满的
			//            // 若输入的数组的数量是错误的，直接跳出程序
			//            if (restLength < lineNodeNum) {
			//                System.out.println("Wrong Input!");
			//                return new TreeNode(0);
			//            }
			for (int i = startIndex; i < startIndex + lineNodeNum; i = i + 2)
			{
				// 说明已经将nums中的数字用完，此时应停止遍历，并可以直接返回root
				if (i == nums.length)
					return root;
				cur = nodeQueue.poll();
				if (nums[i] != null)
				{
					cur.left = new TreeNode(nums[i]);
					nodeQueue.offer(cur.left);
				}
				// 同上，说明已经将nums中的数字用完，此时应停止遍历，并可以直接返回root
				if (i + 1 == nums.length)
					return root;
				if (nums[i + 1] != null)
				{
					cur.right = new TreeNode(nums[i + 1]);
					nodeQueue.offer(cur.right);
				}
			}
			startIndex += lineNodeNum;
			restLength -= lineNodeNum;
			lineNodeNum = nodeQueue.size() * 2;
		}

		return root;
	}

	public static TreeNode generateTree(Integer[] array, int index)
	{
		if (array == null || array.length <= 0)
		{
			return null;
		}
		TreeNode res = null;
		if (index < array.length)
		{
			if (array[index] == null)
			{
				return res;
			}
			res = new TreeNode(array[index]);
			res.left = generateTree(array, 2 * index + 1);
			res.right = generateTree(array, 2 * index + 2);
		}

		return res;
	}

	public static void printInOrder(TreeNode root)
	{
		List<Integer> res = new ArrayList<>();
		helper(root, res);
		ObjectUtils.print(res);
	}

	private static void helper(TreeNode root, List<Integer> res)
	{
		if (root != null)
		{
			if (root.left != null)
			{
				helper(root.left, res);
			}
			res.add(root.val);
			if (root.right != null)
			{
				helper(root.right, res);
			}
		}
	}

	@Test
	public void test()
	{
		// printInOrder(generateTree(new Integer[] { 1, null, 2, 3 }, 0));
		// printInOrder(generateTree(new Integer[] { 1, 2, 3, 4 }, 0));
		// printInOrder(generateTree(new Integer[] { 1, 2, 3, 4, 5 }, 0));
		printInOrder(generateTreeV2(new Integer[] { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1 }));
	}
}
