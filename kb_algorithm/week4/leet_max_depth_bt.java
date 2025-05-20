package kb_algorithm.week4;

public class leet_max_depth_bt {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int result = DFS(root);
        return result;

    }

    private int DFS(TreeNode root) {
        if(root == null) return 0;
        // 반환 조건
        return Math.max(DFS(root.left), DFS(root.right)) + 1;
        // 왼쪽, 오른쪽 노드 중 깊이가 깊은 곳 +1 반환
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
