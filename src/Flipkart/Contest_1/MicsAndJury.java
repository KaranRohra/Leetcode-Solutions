package Flipkart.Contest_1;

public class MicsAndJury {
    public static void main(String[] args) {

    }
}
class Solution_2{
    static int micsandjury(int N,int m,int[] teams){
        //code here

        int max=0,k=0;
        int[] a=new int[N];
        for(int i=m-1;i>=0;i--){
            if(teams[i]%2==0)
                a[k++]=teams[i]/2;
        }
        return 1;
    }
}


