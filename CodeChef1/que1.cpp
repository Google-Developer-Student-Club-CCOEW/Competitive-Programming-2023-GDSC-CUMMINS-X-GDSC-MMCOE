//Smart Phone
//Problem Code:ZCO14003

#include <iostream>
#include <vector>
#include <algorithm>

int main() {
    int N;
    std::cin >> N;

    std::vector<long long> budgets(N);

    for (int i = 0; i < N; ++i) {
        std::cin >> budgets[i];
    }

    // Sort the customer budgets in non-decreasing order.
    std::sort(budgets.begin(), budgets.end());

    long long maxRevenue = 0;

    for (int i = 0; i < N; ++i) {
        // Calculate the revenue if the price is set to the current customer's budget.
        long long revenue = budgets[i] * (N - i);
        
        // Update the maximum revenue if the current revenue is greater.
        maxRevenue = std::max(maxRevenue, revenue);
    }

    std::cout << maxRevenue << std::endl;

    return 0;
}