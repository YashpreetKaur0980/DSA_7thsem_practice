import java.util.Arrays;

public class candies{

    public static int candy(int[] nums) {
        int n = nums.length;
        int[] candies = new int[n];

        Arrays.fill(candies, 1);

        // Left to Right
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right to Left
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int total = 0;
        for (int c : candies) {
            total += c;
        }

        return total;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 2};
        System.out.println("Minimum candies = " + candy(nums));
    }
}