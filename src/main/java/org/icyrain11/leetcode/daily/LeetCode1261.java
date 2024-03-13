package org.icyrain11.leetcode.daily;

import org.icyrain11.leetcode.treenode.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author icyrain11
 * @version 17
 */
public class LeetCode1261 {

    class FindElements {

        Set<Integer> set = new HashSet<>();

        public FindElements(TreeNode root) {
            dfs(root, 0);
        }

        public void dfs(TreeNode root, int val) {
            if (root == null) {
                return;
            }
            set.add(val);
            dfs(root.left, 2 * val + 1);
            dfs(root.right, 2 * val + 2);
        }

        public boolean find(int target) {
            return set.contains(target);
        }
    }

}
