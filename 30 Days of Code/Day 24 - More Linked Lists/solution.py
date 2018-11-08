"""
This challenge only asks you to remove consecutive duplicates. A more
interesting task is to remove all duplicates from a list, regardless of order.
There, brute force would be O(n^2), while a hash set yields O(n) time.
"""

################################################################################
#----------------------------- begin locked code ------------------------------#
class Node:
    def __init__(self,data):
        self.data = data
        self.next = None
class Solution:
    def insert(self,head,data):
            p = Node(data)
            if head==None:
                head=p
            elif head.next==None:
                head.next=p
            else:
                start=head
                while(start.next!=None):
                    start=start.next
                start.next=p
            return head
    def display(self,head):
        current = head
        while current:
            print(current.data,end=' ')
            current = current.next
#------------------------------ end locked code -------------------------------#
################################################################################

    @staticmethod
    def removeDuplicates(head):
        """Remove consecutive duplicate elements from a list."""
        if not head:
            return head

        current = head
        while current.next:
            if current.data == current.next.data:
                current.next = current.next.next
            else:
                current = current.next
        return head

################################################################################
#----------------------------- begin locked code ------------------------------#
mylist= Solution()
T=int(input())
head=None
for i in range(T):
    data=int(input())
    head=mylist.insert(head,data)
head=mylist.removeDuplicates(head)
mylist.display(head);
#------------------------------ end locked code -------------------------------#
################################################################################
