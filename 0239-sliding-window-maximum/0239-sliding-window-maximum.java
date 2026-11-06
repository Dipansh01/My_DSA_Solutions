import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();

        for (int right = 0; right < n; right++) {

            // Remove elements outside the window
            while (!dq.isEmpty() && dq.peekFirst() <= right - k) {
                dq.pollFirst();
            }

            // Remove smaller elements
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[right]) {
                dq.pollLast();
            }

            // Add current index
            dq.offerLast(right);

            // Front contains maximum
            if (right >= k - 1) {
                result[right - k + 1] = nums[dq.peekFirst()];
            }
        }

        return result;
    }
}