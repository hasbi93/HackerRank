################################################################################
#----------------------------- begin locked code ------------------------------#
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

    def getHeight(self, root):
        """Recursively get the height of the tree (empty tree has height -1)."""
        if not root:
            return -1

        left_height = self.getHeight(root.left)
        right_height = self.getHeight(root.right)
        return 1 + max(left_height, right_height)

################################################################################
#----------------------------- begin locked code ------------------------------#
T=int(input())
myTree=Solution()
root=None
for i in range(T):
    data=int(input())
    root=myTree.insert(root,data)
height=myTree.getHeight(root)
print(height)
#------------------------------ end locked code -------------------------------#
################################################################################
