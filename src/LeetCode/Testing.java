package LeetCode;


import java.util.*;

public class Testing {
    static int[][] dp;
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        //System.out.println(new Solution().canPartitionKSubsets(new int[]{2,2,2,2,3,4,5},4));
//        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
//
//        graph.add(new ArrayList<>(Arrays.asList(4,5)));// 0 is connected to 1,2,3
//        graph.add(new ArrayList<>(Arrays.asList(2,0)));
//        graph.add(new ArrayList<>(Arrays.asList(0,1)));
//        graph.add(new ArrayList<>(Arrays.asList(1,3)));
//        graph.add(new ArrayList<>(Arrays.asList(3,1)));
//        graph.add(new ArrayList<>(Arrays.asList(1,0)));

        //System.out.println(new Solution().allPathsSourceTarget(5, graph));
        System.out.println(new Solution().reverseBits(-3));
    }
}
class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int[] binary = decimalToBinary(n);

        if(binary[31]==0){
            return binaryToDecimal(binary);
        }
        else{
            return ~binaryToDecimal(binary);
        }

    }

    private int[] decimalToBinary(int n) {
        int[] binary = new int[32];
        int i = 31;
        int res = n;
        n = n < 0 ? -n : n;
        while (n != 0) {
            binary[i--] = n % 2;
            n /= 2;
        }
        if (res >= 0)
            return binary;

        //2's Complement
        i = 31;
        while (i >= 0 && binary[i] == 0)
            i--;
        i--;
        while (i >= 0) {
            binary[i] = binary[i] == 0 ? 1 : 0;
            i--;
        }
        return binary;
    }
    private int binaryToDecimal(int[] binary){
        int n=0;
        for(int i=0;i<32;i++){
            if(binary[i]==1)
                n+=Math.pow(2,i);
        }
        return n;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public TreeNode makeTree(Integer ...a){
        return new TreeNode(1);
    }

    public void display() {

    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
