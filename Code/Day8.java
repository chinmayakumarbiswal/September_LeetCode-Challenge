// Sum of Root To Leaf Binary Numbers
// Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.

// For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.

// Return the sum of these numbers.

 

// Example 1:



// Input: [1,0,1,0,1,0,1]
// Output: 22
// Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 

// Note:

// The number of nodes in the tree is between 1 and 1000.
// node.val is 0 or 1.
// The answer will not exceed 2^31 - 1.
//  Hint #1  
// Find each path, then transform that path to an integer in base 10.
// Java	

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

    public int sumRootToLeaf(TreeNode root) {

        int rootToLeaf = 0, currNumber = 0;

        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque();

        stack.push(new Pair(root, 0));

​

        while (!stack.isEmpty()) {

          Pair<TreeNode, Integer> p = stack.pop();

     root = p.getKey();

          currNumber = p.getValue();

​

          if (root != null) {

            currNumber = (currNumber << 1) | root.val;

            // if it's a leaf, update root-to-leaf sum

            if (root.left == null && root.right == null) {

              rootToLeaf += currNumber;

            } else {
            stack.push(new Pair(root.right, currNumber));

              stack.push(new Pair(root.left, currNumber));

            }

          }

        }

        return rootToLeaf;

    }
}
