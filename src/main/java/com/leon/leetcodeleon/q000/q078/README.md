```
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subsets
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
```
思路
=
典型的回溯法解决，下面详细与一下回溯法的基本解决方案。

要把大象装冰箱，总共分几步，一，冰箱门打开；二，把大象放进去；三，把冰箱门关上。

我们的回溯法，基本思路也是按这个来的。

基本思路也是可分为三步：
一，（冰箱门打开）循环把当前数字（或其他）加入到临时list 中；
二，（把大象放进去）进行下一步递归；
三，（把冰箱门关上）删除第一步中添加的数字（或其他）。

直接拿代码来解释，下面是[乐扣-子集](https://leetcode-cn.com/problems/subsets/)的AC 代码，本题是要求解"给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）"。直接看代码中的注释，本例子由 java 实现，其他编程语言类似可解

```
// 主方法入口
public List<List<Integer>> subsets(int[] nums)
{
    // 保存结果
    List<List<Integer>> res = new ArrayList<>();
    // 开始递归
    backtrace(0, nums, new ArrayList<>(), res);
    // 最后需要把空列单独加进来
    res.add(new ArrayList<>());
    return res;
}

// 回溯递归的主方式
public void backtrace(int start, int[] nums, List<Integer> tmp, List<List<Integer>> res)
{
    // 这就是一个简单的循环，由于需要取子集，我们这里把 start 
    // 从0开始增，保证后面的循环可以取到元数列的最后的值
    // 
    for (int i = start; i < nums.length; i++)
    {
    
        // 循环内部，就是回溯方法的主体了，可以看到代码非常简洁
        
        // 添加当前元素
        tmp.add(nums[i]);
        // 需要new 出来结果，否则会覆盖原来已经添加到 res 中的list
        List<Integer> t = new ArrayList<>(tmp);
        res.add(t);
        
        // 这里就是关键的递归了
        backtrace(i + 1, nums, tmp, res);
        
        // 递归完，把当前值从临时列表中删除，进行下一次循环
        tmp.remove(tmp.size() - 1);
    }
}
```

总结
=
可以看到，回溯的基础，是非常简洁的，变化也是非常的多，需要理解之后才能解除更多的问题。

一时不理解也没关系，这个方式还是比较绕的。

对于实在看不懂的问题，一个通常都会有效的解决方法是，先看一遍，这个时候回非常痛苦，一定要坚持下去；过几天，或者过几个月，想起来时，再回来看一遍，此时可能就有那么一点感觉了，如果还是不行，就在等几天或者几个月。第三遍时，都是可以看懂理解的。

祝君好运！