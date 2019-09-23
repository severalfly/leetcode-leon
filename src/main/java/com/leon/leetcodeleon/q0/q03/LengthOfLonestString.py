# def lengthOfLongestSubstring(self, s):
#         """
#         :type s: str
#         :rtype: int
#         """
#         ans = 0
#         start = 0
#         end = 0
#         StrSet = set()
#         while start < len(s) and end < len(s):
#             StrLen = len(StrSet)
#             StrSet.add(s[end])
#             if not StrLen == len(StrSet):
#                 end += 1
#                 ans = max(ans, end - start)
#             else:
#                 StrSet.remove(s[start])
#                 start += 1
#         return ans

# lengthOfLongestSubstring("asjrgapa")

s = "asjrgapa"
ans = 0
start = 0
end = 0
StrSet = set()
while start < len(s) and end < len(s):
    StrLen = len(StrSet)
    StrSet.add(s[end])
    if not StrLen == len(StrSet):
        end += 1
        ans = max(ans, end - start)
    else:
        StrSet.remove(s[start])
        start += 1
print(ans)
