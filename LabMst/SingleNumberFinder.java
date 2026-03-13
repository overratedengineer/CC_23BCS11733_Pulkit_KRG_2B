public class SingleNumberFinder {
    public static int findUniqueByBitCounting(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bitSum = 0;
            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    bitSum++;
                }
            }
            if (bitSum % 3 != 0) {
                result |= (1 << i);
            }
        }
        return result;
    }
    public static int findUniqueOptimized(int[] nums) {
        int ones = 0, twos = 0;
        for (int x : nums) {
            ones = (ones ^ x) & ~twos;
            twos = (twos ^ x) & ~ones;
        }
        return ones;
    }

    public static void main(String[] args) {
        int[] numbers = {5, 5, 8, 5};
        int result1 = findUniqueByBitCounting(numbers);
        int result2 = findUniqueOptimized(numbers);
        int[] numbers2 = {12, 1, 12, 3, 12, 1, 1};

    }
}