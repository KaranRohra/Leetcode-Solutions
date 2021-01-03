package leetCode;

import java.util.Scanner;

public class PathCrossing {
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        Solution1496 s=new Solution1496();
        System.out.print(s.isPathCrossing(sc.next()));

    }
}
class Solution1496 {
    public boolean isPathCrossing(String s) {
        int i,x=0,y=0,n=s.length();
        for(i=0;i<n;i++){
            if(s.charAt(i)=='N')
                y++;
            else if(s.charAt(i)=='S')
                y--;
            else if(s.charAt(i)=='W')
                x++;
            else if(s.charAt(i)=='E')
                x--;
            if(i!=0){
                if(s.charAt(i)=='S' && s.charAt(i-1)=='N')
                    return true;
                if(s.charAt(i)=='N' && s.charAt(i-1)=='S')
                    return true;
                if(s.charAt(i)=='E' && s.charAt(i-1)=='W')
                    return true;
                if(s.charAt(i)=='W' && s.charAt(i-1)=='E')
                    return true;
            }
            if(x==0 && y==0)
                return true;
        }
        return false;
    }
}