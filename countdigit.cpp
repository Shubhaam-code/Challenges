#include <cmath>

class Solution {
public:
    int countDigits(int n) {
        if (n == 0)
            return 1;

        return floor(log10(n)) + 1;
    }
};