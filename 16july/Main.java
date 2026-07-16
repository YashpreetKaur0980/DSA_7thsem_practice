import java.util.Arrays;

public class Main {

    static class Solution {

        public int closestTripletSum(int[] arr, int target) {

            Arrays.sort(arr);

            int closestSum = arr[0] + arr[1] + arr[2];

            for (int i = 0; i < arr.length - 2; i++) {
                int left = i + 1;
                int right = arr.length - 1;

                while (left < right) {
                    int sum = arr[i] + arr[left] + arr[right];

                    if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                        closestSum = sum;
                    } else if (Math.abs(sum - target) == Math.abs(closestSum - target)
                            && sum > closestSum) {
                        closestSum = sum;
                    }

                    if (sum < target)
                        left++;
                    else if (sum > target)
                        right--;
                    else
                        return sum;
                }
            }

            return closestSum;
        }
    }

    public static void main(String[] args) {

        Solution obj = new Solution();

        int[] arr = {-1, 2, 1, -4};
        int target = 1;

        System.out.println(obj.closestTripletSum(arr, target));
    }
}