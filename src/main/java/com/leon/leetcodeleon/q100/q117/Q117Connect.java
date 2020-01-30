package com.leon.leetcodeleon.q100.q117;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Q117Connect extends BaseTest
{
	@Test
	public void test()
	{
		// Node connect = connect(generateTreeV2(new Integer[] { 1, 2, 3, 4, null, null, 5 }));// [1,#,2,3,#,4,5,#]
		Node connect1 = connect(generateTreeV2(new Integer[] { 0, 2, 4, 1, null, 3, -1, 5, 1, null, 6, null, 8 }));// [0,#,2,4,#,1,3,-1,#,5,1,6,8,#]
		Node connect2 = connect(generateTreeV2(new Integer[] { 1,2,3,4,5,null,6,7,null,null,null,null,8 }));// [1,#,2,3,#,4,5,6,#,7,8,#]
		System.out.println(1);
	}

	public Node connect(Node root)
	{
		if (root == null)
		{
			return null;
		}
		if (root.left == null)
		{
			return root;
		}
		Node left = root.left;
		Node right = root.right;
		if (right != null)
		{
			left.next = right;

			while (left.right != null || left.left != null)
			{

				if (left.right != null)
				{
					left.right.next = right.left != null ? right.left : right.right;
					left = left.right;
				}
				else
				{
					left.left.next = right.left != null ? right.left : right.right;
					left = left.left;
				}

				right = right.left != null ? right.left : right.right;

			}
		}
		connect(root.left);
		connect(root.right);
		return root;
	}

	// Definition for a Node.
	class Node
	{
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node()
		{
		}

		public Node(int _val)
		{
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next)
		{
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}

	private Node generateTreeV2(Integer[] nums)
	{

		if (nums.length == 0)
			return new Node(0);
		Queue<Node> nodeQueue = new LinkedList<>();
		// 创建一个根节点
		Node root = new Node(nums[0]);
		nodeQueue.offer(root);
		Node cur;
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
			//                return new Node(0);
			//            }
			for (int i = startIndex; i < startIndex + lineNodeNum; i = i + 2)
			{
				// 说明已经将nums中的数字用完，此时应停止遍历，并可以直接返回root
				if (i == nums.length)
					return root;
				cur = nodeQueue.poll();
				if (nums[i] != null)
				{
					cur.left = new Node(nums[i]);
					nodeQueue.offer(cur.left);
				}
				// 同上，说明已经将nums中的数字用完，此时应停止遍历，并可以直接返回root
				if (i + 1 == nums.length)
					return root;
				if (nums[i + 1] != null)
				{
					cur.right = new Node(nums[i + 1]);
					nodeQueue.offer(cur.right);
				}
			}
			startIndex += lineNodeNum;
			restLength -= lineNodeNum;
			lineNodeNum = nodeQueue.size() * 2;
		}

		return root;
	}

}
