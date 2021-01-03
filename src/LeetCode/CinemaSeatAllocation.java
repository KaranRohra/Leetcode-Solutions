package LeetCode;

import java.util.Scanner;

public class CinemaSeatAllocation {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        Solution1386 s = new Solution1386();
        int row = sc.nextInt();
        int[][] a = new int[row][2];
        for(int i=0;i<row;i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }
        System.out.println(s.maxNumberOfFamilies(sc.nextInt(),a));
    }
}
class Solution1386 {
    public int maxNumberOfFamilies(int n, int[][] r) {
        int groups=0,row=r.length,x,count=0;
        sort(r,0,row-1);
        for(int i=0;i<row;i++){
            x=r[i][0];
            int[] a = new int[11];
            while(i<row && r[i][0]==x)
                a[r[i++][1]] = 1;
            count++;
            if(a[2]==0 && a[3]==0 && a[4]==0 && a[5]==0 && a[6]==0 && a[7]==0 && a[8]==0 && a[9]==0)
                groups+=2;
            else if(a[2]==0 && a[3]==0 && a[4]==0 && a[5]==0)
                groups++;
            else if(a[6]==0 && a[7]==0 && a[8]==0 && a[9]==0)
                groups++;
            else if(a[4]==0 && a[5]==0 && a[6]==0 && a[7]==0)
                groups++;
            if(i!=row)
                i--;
        }
        return groups+(n-count)*2;
    }
    public void sort(int[][] a,int lb,int ub){
        if(lb<ub){
            int pivot=a[lb][0],i=lb,j=ub,temp;
            while(i<j){
                i++;
                while(i<=ub && a[i][0]<pivot)
                    i++;
                while(j>=lb && a[j][0]>pivot)
                    j--;
                if(i<j){
                    temp=a[i][0];
                    a[i][0]=a[j][0];
                    a[j][0]=temp;

                    temp=a[i][1];
                    a[i][1]=a[j][1];
                    a[j][1]=temp;
                }
            }
            temp=a[lb][0];
            a[lb][0]=a[j][0];
            a[j][0]=temp;

            temp=a[lb][1];
            a[lb][1]=a[j][1];
            a[j][1]=temp;

            sort(a,lb,j-1);
            sort(a,j+1,ub);
        }
    }
}