//Next Permutation
//Problem Code:NEXTPERM

#include <iostream>
#include <vector>
#include <algorithm>

int main() {
    int N, K;
    std::cin >> N >> K;

    for (int i = 0; i < K; i++) {
        std::vector<int> permutation(N);

        for (int j = 0; j < N; j++) {
            std::cin >> permutation[j];
        }

        if (std::next_permutation(permutation.begin(), permutation.end())) {
            for (int j = 0; j < N; j++) {
                std::cout << permutation[j] << " ";
            }
            std::cout << std::endl;
        } else {
            // If there is no next permutation, output the first permutation.
            std::sort(permutation.begin(), permutation.end());
            for (int j = 0; j < N; j++) {
                std::cout << permutation[j] << " ";
            }
            std::cout << std::endl;
        }
    }

    return 0;
}