package app.algo.basic.bintree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}
