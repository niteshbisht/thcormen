package app.algo.easy;

public class RemoveElements {
    public static void main(String[] args) {
        RemoveElements rel = new RemoveElements();
        System.out.println(rel.solution(new int[]{3, 2, 2, 3}, 3));
    }

    int solution(int[] arr, int k) {
        int i = 0, j = 0;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] != k) {
                arr[j] = arr[i];
                j++;
            }
        }
        return j;
    }
}
