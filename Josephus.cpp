// C++ code to Implement Josephus Problem

#include <iostream>
using namespace std;

int Josephus(int N, int k)
{

	// Initialize variables i and ans with 1 and 0
	// respectively.

	int i = 1, ans = 0;

	// Run a while loop till i <= N

	while (i <= N) {

		// Update the Value of ans and Increment i by 1
		ans = (ans + k) % i;
		i++;
	}

	// Return required answer
	return ans + 1;
}

// main function
int main()
{

	int N = 14, k = 2;
	cout << Josephus(N, k) << endl;
	return 0;
}

// This code is presented by Akash Mangal
