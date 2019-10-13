```
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
示例 1:

输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"


示例 2:

输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:

L     D     R
E   O E   I I
E C   I H   N
T     S     G

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zigzag-conversion
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
```

思路，可以看到这是一个Z 字转换，从numRows =4 可以明显看出题目想让我们做什么
1. 暴力法，建一个数组保存结果；
2. 不知是否可行，观察这个数组，第一行为原数组的 (numRows-1)*2的一个等差数列。
    * numRows = 3 时，0/4/8/12 位分别为L/C/I/R
    * numRows = 4时，0/6/12 位分别为L/D/R
3. 第二行  
    * numRows:4 (0+1)/ (6-1) / (6+1) / (12-1) / (12+1) 即: 1/5/7/11/13
4. 第三行
    * numRows:4 (0+2) / (6-2) / (6+2) / (12 -2) / (12 + 2) 即：2/4/8/10/14
5. 第四行
    * numRows:4 (0+3) / (6-3) / (6+3) / (12 -3) / (12 + 3) 3/3/9/9/15存在重复的情况
    * 另一个考虑方式：(numRows-1)*3 的一个等差数列
    
总结规律，第一行与最后一行特殊些，中间是固定的套路，可以给他写一个 for 循环做了。  
第一行与最后一行，使用另一个for 循环做

> 可以把第一行与最后一行一起做，添加一个临时变量，保存上次的位置即可

总结
=
这个很大的一个坑是：numRows =1 的情况，没有所谓的最后一行，用到的等差数列，第一次计算时为0了，导致内存超了

这实际上是一个等差数列，控制好结束条件就很简单了，
比如结束条件不能为 `i<s.length`，必须是 `i-k< s.length`