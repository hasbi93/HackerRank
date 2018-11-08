"""
This challenge seems to encourage the use of a list as a queue, which is
inefficient. I imported the deque class regardless.
"""

################################################################################
#----------------------------- begin locked code ------------------------------#
import sys

class Node:
    def __init__(self,data):
        self.right=self.left=None
        self.data = data
class Solution:
    def insert(self,root,data):
        if root==None:
            return Node(data)
        else:
            if data<=root.data:
                cur=self.insert(root.left,data)
                root.left=cur
            else:
                cur=self.insert(root.right,data)
                root.right=cur
        return root
#------------------------------ end locked code -------------------------------#
################################################################################

    def levelOrder(self, root):
        """Traverse and print the tree's nodes in level-order."""
        if not root:
            return None

        queue = collections.deque()
        queue.append(root)

        while queue:
            current = queue.popleft()
            print(current.data, end=" ")
            if current.left:
                queue.append(current.left)
            if current.right:
                queue.append(current.right)

import collections # Normally, imports should go at the top of the file.

################################################################################
#----------------------------- begin locked code ------------------------------#
T=int(input())
myTree=Solution()
root=None
for i in range(T):
    data=int(input())
    root=myTree.insert(root,data)
myTree.levelOrder(root)
#------------------------------ end locked code -------------------------------#
################################################################################
