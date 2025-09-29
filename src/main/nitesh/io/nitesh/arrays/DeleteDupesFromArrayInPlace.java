package io.nitesh.arrays;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DeleteDupesFromArrayInPlace {

    public int[] solve(int[] input) {
        int i, j=1;
        for(i = 1; i < input.length; i++) {
            if(input[i] != input[i-1]) {
               input[j++] = input[i];
            }
        }
        return input;
    }

    public static void main(String[] args) {
        final var deleteDupes = new DeleteDupesFromArrayInPlace();
        final var solved = deleteDupes.solve(new int[]{1,1,3,4,5,6,6,7,8});
        System.out.println(Arrays.toString(solved));
    }
}
