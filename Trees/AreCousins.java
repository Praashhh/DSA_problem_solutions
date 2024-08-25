/*
Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.

Two nodes of a binary tree are cousins if they have the same depth with different parents.

Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.

Example 1:
Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Example 2:
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true

Example 3:
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 */

//Solution:

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        return isSameLevel(root, x, y) && !areSiblings(root, x, y);
    }

    private boolean isSameLevel(TreeNode root, int x, int y) {
        int xLevel = getLevel(root, x, 0);
        int yLevel = getLevel(root, y, 0);
        return xLevel == yLevel;
    }

    private int getLevel(TreeNode root, int value, int level) {
        if (root == null) return -1;
        if (root.val == value) return level;

        int leftLevel = getLevel(root.left, value, level + 1);
        return (leftLevel != -1) ? leftLevel : getLevel(root.right, value, level + 1);
    }

    private boolean areSiblings(TreeNode root, int x, int y) {
        if (root == null) return false;

        if (root.left != null && root.right != null) {
            if ((root.left.val == x && root.right.val == y) ||
                    (root.left.val == y && root.right.val == x)) {
                return true;
            }
        }

        return areSiblings(root.left, x, y) || areSiblings(root.right, x, y);
    }
}
