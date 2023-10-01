"""Import the 'deque' class from the 'collections' module.
deque (double-ended queue) is a data structure that supports adding and 
removing elements from both ends efficiently."""
from collections import deque

# Function to return a list that contains all the letter combinations

def letter_combinations_util(number, _n, table):
    """
    Generate all possible letter combinations for a given sequence of digits.

    Args:
    - number (list of int): The sequence of digits for which letter combinations are 
    to be generated.
    - n (int): The length of the 'number' list.
    - table (list of str): A mapping of digits to corresponding letters on a phone keypad.

    Returns:
    - list2 of str: A list containing all possible letter combinations.
    """
    list2 = []
    _q = deque()
    _q.append("")

    while len(_q) != 0:
        _s = _q.pop()

        # If complete word is generated
        # push it in the list
        if len(_s) == _n:
            list2.append(_s)
        else:

            # Try all possible letters for the current digit
            # in the number[]
            for letter in table[number[len(_s)]]:
                _q.append(_s + letter)

    # Return the generated list
    return list2


# Function that creates the mapping and
# calls letter_combinationsUtil
def letter_combinations(num, n_1):
    """
    Generate and print all possible letter combinations for a given sequence of digits.

    Args:
    - number (list of int): The sequence of digits for which letter combinations 
    are to be generated.
    - n_1 (int): The length of the 'number' list.

    Returns:
    - None

    This function takes a sequence of digits and generates all possible combinations of letters
    corresponding to those digits on a phone keypad. It then prints the resulting combinations.
    """

    # table[i] stores all characters that
    # correspond to the ith digit in the phone
    table = ["0", "1", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"]

    list1 = letter_combinations_util(num, n_1, table)

    _s = ""
    for word in list1:
        _s += word + " "

    print(_s)
    return

# Driver code
number = [2, 3]
N = len(number)

# Function call
letter_combinations(number, N)
