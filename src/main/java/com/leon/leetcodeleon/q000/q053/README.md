给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。


进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路
===
典型的问题，题目中没有提到是否至少包含一个正数，我们只处理至少包含一个正数的情况，全部为负数时，可以使用一次循环，找出最大数，即是结果。

至少包含一个正数时，加的过程中，只要还是大于0，后面就有可能加回来。

比如这个解法，-5的出现，并没有把前面减成负数，也就是说，一旦加了最后一个2，最大值，就会变成7