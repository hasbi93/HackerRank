class Calculator():

    @staticmethod
    def power(n, p):
        """Return n to the power p."""
        if n < 0 or p < 0:
            raise Exception("n and p should be non-negative")
        else:
            return n ** p

################################################################################
#----------------------------- begin locked code ------------------------------#
myCalculator=Calculator()
T=int(input())
for i in range(T):
    n,p = map(int, input().split())
    try:
        ans=myCalculator.power(n,p)
        print(ans)
    except Exception as e:
        print(e)
#------------------------------ end locked code -------------------------------#
################################################################################
