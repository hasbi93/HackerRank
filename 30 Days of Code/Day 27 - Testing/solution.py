"""
It's interesting that HackerRank's introduction to unit testing only has you
hard-code test inputs and their results. (Of course, you could randomly generate
the requested lists and use library functions for the result. This also does
little to give you actual practice with assertions.)

If you've never been exposed to unit testing before, you may want to seek out
learning resources besides this challenge.
"""

################################################################################
#----------------------------- begin locked code ------------------------------#
def minimum_index(seq):
    if len(seq) == 0:
        raise ValueError("Cannot get the minimum value index from an empty sequence")
    min_idx = 0
    for i in range(1, len(seq)):
        if seq[i] < seq[min_idx]:
            min_idx = i
    return min_idx
#------------------------------ end locked code -------------------------------#
################################################################################


class TestDataEmptyArray():

    @staticmethod
    def get_array():
        return list()


class TestDataUniqueValues():

    @staticmethod
    def get_array():
        return [5, 2, 8, 3, 1, -6, 9]

    @staticmethod
    def get_expected_result():
        return 5


class TestDataExactlyTwoDifferentMinimums():

    @staticmethod
    def get_array():
        return [5, 2, 8, 3, 1, -6, 9, -6, 10]

    @staticmethod
    def get_expected_result():
        return 5

################################################################################
#----------------------------- begin locked code ------------------------------#

def TestWithEmptyArray():
    try:
        seq = TestDataEmptyArray.get_array()
        result = minimum_index(seq)
    except ValueError as e:
        pass
    else:
        assert False


def TestWithUniqueValues():
    seq = TestDataUniqueValues.get_array()
    assert len(seq) >= 2

    assert len(list(set(seq))) == len(seq)

    expected_result = TestDataUniqueValues.get_expected_result()
    result = minimum_index(seq)
    assert result == expected_result


def TestiWithExactyTwoDifferentMinimums():
    seq = TestDataExactlyTwoDifferentMinimums.get_array()
    assert len(seq) >= 2
    tmp = sorted(seq)
    assert tmp[0] == tmp[1] and (len(tmp) == 2 or tmp[1] < tmp[2])

    expected_result = TestDataExactlyTwoDifferentMinimums.get_expected_result()
    result = minimum_index(seq)
    assert result == expected_result

TestWithEmptyArray()
TestWithUniqueValues()
TestiWithExactyTwoDifferentMinimums()
print("OK")
#------------------------------ end locked code -------------------------------#
################################################################################
