package app.algo.basic.bintree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}
