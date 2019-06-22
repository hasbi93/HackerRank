"""
This is the first of many challenges where HackerRank's locked code forces you
to use unconventional naming schemes. Functions names should be snake_case.
"""

class Person:
    # Inclusive limits for the defined age ranges.
    YOUNG_MAX = 12
    TEEN_MIN = 13
    TEEN_MAX = 17 # Interesting definition of "teen"...

    def __init__(self, initialAge):
        if initialAge < 0:
            print("Age is not valid, setting age to 0.")
            self.age = 0
        else:
            self.age = initialAge

    def amIOld(self):
        answer = ""
        if self.age in range(Person.YOUNG_MAX + 1):
            answer = "You are young."
        elif self.age in range(Person.TEEN_MIN, Person.TEEN_MAX + 1):
            answer = "You are a teenager."
        else:
            answer = "You are old."
        print(answer)

    def yearPasses(self):
        self.age += 1

################################################################################
#----------------------------- begin locked code ------------------------------#
t = int(input())
for i in range(0, t):
    age = int(input())
    p = Person(age)
    p.amIOld()
    for j in range(0, 3):
        p.yearPasses()
    p.amIOld()
    print("")
#------------------------------ end locked code -------------------------------#
################################################################################
