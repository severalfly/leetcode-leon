package com.leon.leetcodeleon.q100.q155;

import org.junit.Test;

import java.util.Stack;

/**
 * @Package com.leon.leetcodeleon.q100.q155
 * @author zhangyunfei
 * @date 2020-05-12 23:00
 * @version V1.0
 */
public class Q155MinStack
{

	@Test
	public void test()
	{
		Q155MinStack minStack = new Q155MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		assert minStack.getMin() == -3;//   --> 返回 -3.
		minStack.pop();
		assert minStack.top() == 0;//      --> 返回 0.
		assert minStack.getMin() == -2;//   --> 返回 -2.
	}

	Stack<Integer> stack;
	Stack<Integer> minStack;

	/** initialize your data structure here. */
	public Q155MinStack()
	{
		this.stack = new Stack<>();
		this.minStack = new Stack<>();
	}

	public void push(int x)
	{
		this.stack.push(x);
		if (this.minStack.size() > 0)
		{
			Integer peek = this.minStack.peek();
			this.minStack.push(peek < x ? peek : x);
		}
		else
		{
			this.minStack.push(x);
		}
	}

	public void pop()
	{
		this.stack.pop();
		this.minStack.pop();
	}

	public int top()
	{
		return this.stack.peek();
	}

	public int getMin()
	{
		return this.minStack.peek();
	}
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */