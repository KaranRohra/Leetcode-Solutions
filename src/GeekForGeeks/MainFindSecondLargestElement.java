package GeekForGeeks;

public class MainFindSecondLargestElement {
    public static void main(String[] args) {
        System.out.println(FindSecondLargestElement.print2largest(new int[]{ 7, 8, 2, 1, 4, 3 },7));
    }
}
class FindSecondLargestElement {
    public static int print2largest(int[] A, int N) {
        //CODE HERE
        int firstMax=-1,secondMax=-1;
        for(int i=0;i<N;i++){
            if(A[i]>secondMax && firstMax!=A[i]){
                secondMax=A[i];
            }
            if(A[i]>firstMax){
                secondMax=firstMax;
                firstMax=A[i];
            }
        }
        return secondMax;
    }
}

