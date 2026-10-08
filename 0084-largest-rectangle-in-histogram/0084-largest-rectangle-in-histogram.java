import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {

            while (!stack.isEmpty() &&
                   heights[i] < heights[stack.peek()]) {

                int popped = stack.pop();

                int height = heights[popped];

                int left = stack.isEmpty() ? -1 : stack.peek();

                int width = i - left - 1;

                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        // Process remaining bars
        while (!stack.isEmpty()) {

            int popped = stack.pop();

            int height = heights[popped];

            int left = stack.isEmpty() ? -1 : stack.peek();

            int width = heights.length - left - 1;

            int area = height * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}