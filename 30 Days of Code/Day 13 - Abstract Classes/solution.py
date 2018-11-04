################################################################################
#----------------------------- begin locked code ------------------------------#
from abc import ABCMeta, abstractmethod
class Book(object, metaclass=ABCMeta):
    def __init__(self,title,author):
        self.title=title
        self.author=author
    @abstractmethod
    def display(): pass
#------------------------------ end locked code -------------------------------#
################################################################################

class MyBook(Book):
    def __init__(self, title, author, price):
        Book.__init__(self, title, author)
        self.price = price

    def display(self):
        print("Title: " + title)
        print("Author: " + author)
        print("Price: " + str(price))

################################################################################
#----------------------------- begin locked code ------------------------------#
title=input()
author=input()
price=int(input())
new_novel=MyBook(title,author,price)
new_novel.display()
#------------------------------ end locked code -------------------------------#
################################################################################