package app.algo.basic.bintree;

import app.algo.util.AlgoUtils;
import app.algo.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Slf4j
public class LevelOrderTraversal {

    static List<List<Integer>> levelOrderUsingQueue(TreeNode treeNode) {
        List<List<Integer>> result = new ArrayList<>();
        if (treeNode == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        int level = 0;
        while (!queue.isEmpty()) {
            result.add(new ArrayList<>());
            int qlen = queue.size();
            for (int i = 0; i < qlen; i++) {
                TreeNode node = queue.remove();
                result.get(level).add(node.getVal());
                if (node.getLeft() != null) queue.add(node.getLeft());
                if (node.getRight() != null) queue.add(node.getRight());
            }
            // go to next level
            level++;
        }

        return result;
    }

    static List<List<Integer>> solve(TreeNode treeNode) {
        List<List<Integer>> result = new ArrayList<>();
        helper(treeNode, 0, result);
        return result;
    }

    static void helper(TreeNode node, int level, List<List<Integer>> result) {
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.getVal());
        if (null != node.getLeft()) helper(node.getLeft(), level + 1, result);
        if (null != node.getRight()) helper(node.getRight(), level + 1, result);
    }

    public static void main(String[] args) {
        List<List<Integer>> result = solve(AlgoUtils.createTree());
        log.info("Response  => {}", result);
    }
}
