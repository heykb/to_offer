package com.zhu;

public class 重建树 {


     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length==0){
            return null;
        }
        return constructCore(pre,0,pre.length-1,in,0,in.length-1);
    }
    public TreeNode constructCore(int[] pre,int start,int end,int[] in,int from,int to){


        TreeNode root = new TreeNode(pre[start]);
        int leftCount = 0;
        for(int i=from;i<=to;i++){
            if(pre[start] == in[i]){
                leftCount=i-from;
                break;
            }
        }
        if(leftCount!=0)
            root.left = constructCore(pre,start+1,start+leftCount,in,from,from+leftCount-1);
        if(leftCount!=end-start)
            root.right = constructCore(pre,start+leftCount+1,end,in,from+leftCount+1,to);
        return root;
    }
}
