package kb_algorithm.week4;


public class leet_LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root ==p || root == q) return root;
        // 현재 노드가 null → 말단까지 내려간 것
        // 현재 노드가 p 또는 q → 그 노드를 위로 반환
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //좌우 서브트리에서 LCA 탐색
        //각각 p 또는 q가 있는 쪽에서 값이 올라옴
        if (left != null && right != null) {
            return root;
            //양쪽에서 각각 하나(p,q)씩 찾았으면, 현재 노드가 최초의 공통 조상(LCA)
        } else if (right == null) {
            return left;
        } else {
            return right;
        } // 둘 중 하나라도 null이 아니면 그쪽 값 반환 (둘 중 한 노드만 찾은 상태)
    }



    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

