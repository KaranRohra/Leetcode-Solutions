package LeetCode;

public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println(new Solution71().simplifyPath("/home/"));
    }
}
//https://leetcode.com/problems/simplify-path/submissions/
class Solution71 {// 4 ms and 1 incorrect submission
    public String simplifyPath(String path) {
        String[] stack=new String[2001];

        char[] str=path.toCharArray();
        int n=str.length,top=-1;

        for(int i=0;i<n;){
            while(i<n && str[i]=='/'){
                i++;
            }
            if(i==n)
                break;
            int start=i;

            while(i<n && str[i]!='/'){
                i++;
            }
            String p = path.substring(start,i);
            //System.out.println(p);

            if(p.equals("..") && top!=-1){
                top--;
            }else if(!p.equals(".") && !p.equals("..")){
                stack[++top]=p;
            }
        }

        if(top==-1)
            return "/";

        String res="";

        while(top!=-1){
            res="/".concat(stack[top--]).concat(res);
        }

        return res;
    }
}



