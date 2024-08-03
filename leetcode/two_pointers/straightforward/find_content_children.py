"""
455. Assign Cookies
Solved
Easy
Topics
Companies
Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.

Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.
"""


class FindContentChildren:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort()
        s.sort()
        ptr_g, ptr_s = 0, 0
        num_content = 0

        while ptr_g < len(g) and ptr_s < len(s):
            if s[ptr_s] >= g[ptr_g]:
                num_content += 1
                ptr_g += 1
            ptr_s += 1
        return num_content
