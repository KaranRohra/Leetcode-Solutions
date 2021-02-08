package LeetCode;


import java.util.*;
import java.io.*;

public class Testing {
    static int[][] dp;
    public static void main (String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret;
        String ans = null;
        while (T--> 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = MyMath.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = MyMath.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = MyMath.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        int[][] resInterval = new int[n+1][2];

        int i=0;
        while(i<n && intervals[i][0] <= newInterval[0]){
            resInterval[i][0]=intervals[i][0];
            resInterval[i][1]=intervals[i][1];
            i++;
        }
        resInterval[i][0]=newInterval[0];
        resInterval[i][1]=newInterval[1];
        while(i<n){
            resInterval[i+1][0]=intervals[i][0];
            resInterval[i+1][1]=intervals[i][1];
            i++;
        }
        //return resInterval;

        for(i=0;i<=n;){
            int startIndex=i;
            while(i<=n && resInterval[startIndex][0]==resInterval[i][0]){
                i++;
            }
            Arrays.sort(resInterval,startIndex,i,Comparator.comparingInt(o -> o[1]));
        }

        int newLength=0;
        for(i=0;i<=n;){
            int startValue=resInterval[i][0],endValue=resInterval[i][1];

            while(i<=n && endValue>=resInterval[i][0]){
                if(resInterval[i][1]>endValue){
                    endValue=resInterval[i][1];
                }
                resInterval[i][0]=-1;
                i++;
            }
            resInterval[newLength][0]=startValue;
            resInterval[newLength][0]=endValue;
            newLength++;
        }
        int[][] finalRes=new int[newLength][2];
        for(i=0;i<newLength;i++){
            finalRes[i][0]=resInterval[i][0];
            finalRes[i][1]=resInterval[i][0];
        }

        return finalRes;
    }

}










interface PerformOperation {
    boolean check(int a);
}
class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public PerformOperation isOdd() {
        return a -> a % 2 !=0;
    }

    public PerformOperation isPrime() {
        return a->{
            for(int i=2;i<a;i++){
                if(a%i==0)
                    return false;
            }
            return true;
        };
    }

    public PerformOperation isPalindrome() {
        return a -> {
            char[] str=String.valueOf(a).toCharArray();
            for(int i=0;i< str.length/2;i++){
                if(str[i]!=str[str.length-1-i])
                    return false;
            }
            return true;
        };
    }

   /*
   write code
    */
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }

    public TreeNode makeTree(Integer ...a){
        int n=a.length;
        if(n==0)
            return null;
        Integer[] treeInArray=new Integer[n+1];
        System.arraycopy(a,0,treeInArray,1,n);
        TreeNode root = new TreeNode(a[0]);
        getTree(treeInArray,1, root);
        return root;
    }

    private void getTree(Integer[] treeInArray,int curr,TreeNode root){
        int n=treeInArray.length;
        if(curr>=n || root==null)
            return;

        if(curr*2<n && treeInArray[curr*2]!=null)
            root.left = new TreeNode(treeInArray[curr*2]);

        if(curr*2+1<n && treeInArray[curr*2+1]!=null)
            root.right = new TreeNode(treeInArray[curr*2+1]);

        getTree(treeInArray, 2*curr,root.left);
        getTree(treeInArray, 2*curr+1,root.right);
    }

    public void display(TreeNode root) {
        if(root==null)
            return;
        display(root.left);
        System.out.print(root.val+" ");
        display(root.right);
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
