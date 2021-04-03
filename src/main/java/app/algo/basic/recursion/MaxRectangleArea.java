package app.algo.basic.recursion;

public class MaxRectangleArea {
    public static void main(String[] args) {
        MaxRectangleArea mra = new MaxRectangleArea();
        System.out.println(mra.largestRectangleArea(new int[]{4, 3, 5, 6, 8}));
    }

    public int calculateArea(int[] heights, int start, int end) {
        if (start > end) return 0;
        int minIndex = start;
        for (int i = start; i <= end; i++) if (heights[minIndex] > heights[i]) minIndex = i;
        return Math.max(
                heights[minIndex] * (end - start + 1),
                Math.max(
                        calculateArea(heights, start, minIndex - 1),
                        calculateArea(heights, minIndex + 1, end)));
    }

    public int largestRectangleArea(int[] heights) {
        return calculateArea(heights, 0, heights.length - 1);
    }
}
