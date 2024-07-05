"""
2241. Design an ATM Machine
Solved
Medium
Topics
Companies
Hint
There is an ATM machine that stores banknotes of 5 denominations: 20, 50, 100, 200, and 500 dollars. Initially the ATM is empty. The user can use the machine to deposit or withdraw any amount of money.

When withdrawing, the machine prioritizes using banknotes of larger values.

For example, if you want to withdraw $300 and there are 2 $50 banknotes, 1 $100 banknote, and 1 $200 banknote, then the machine will use the $100 and $200 banknotes.
However, if you try to withdraw $600 and there are 3 $200 banknotes and 1 $500 banknote, then the withdraw request will be rejected because the machine will first try to use the $500 banknote and then be unable to use banknotes to complete the remaining $100. Note that the machine is not allowed to use the $200 banknotes instead of the $500 banknote.
Implement the ATM class:

ATM() Initializes the ATM object.
void deposit(int[] banknotesCount) Deposits new banknotes in the order $20, $50, $100, $200, and $500.
int[] withdraw(int amount) Returns an array of length 5 of the number of banknotes that will be handed to the user in the order $20, $50, $100, $200, and $500, and update the number of banknotes in the ATM after withdrawing. Returns [-1] if it is not possible (do not withdraw any banknotes in this case).
"""

class ATM(object):

    def __init__(self):
        self.numNotes = [0] * 5
        self.val = [20, 50, 100, 200, 500]

    def deposit(self, banknotesCount):
        """
        :type banknotesCount: List[int]
        :rtype: None
        """
        self.numNotes = [a + b for a, b in zip(self.numNotes, banknotesCount)]
        

    def withdraw(self, amount):
        """
        :type amount: int
        :rtype: List[int]
        """
        take = [0] * 5
        # Calculate number of notes that can be withdrawn
        for i in range(4, -1, -1):
            take[i] = min(self.numNotes[i], amount // self.val[i])
            amount -= take[i] * self.val[i]
        # Update the number of notes in ATM
        if amount == 0:
            self.numNotes = [a - b for a, b in zip(self.numNotes, take)]

        return [-1] if amount else take


# Your ATM object will be instantiated and called as such:
# obj = ATM()
# obj.deposit(banknotesCount)
# param_2 = obj.withdraw(amount)