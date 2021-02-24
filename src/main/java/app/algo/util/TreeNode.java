package app.algo.util;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PUBLIC)
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
}
