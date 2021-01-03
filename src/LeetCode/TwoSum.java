package LeetCode;

public class TwoSum {
    public static void main(String[] args) {
        Solution1 s=new Solution1();
        int[] result=s.twoSum(new int[]{2,7,11,5},9);
        System.out.println(result[0]+" "+result[1]);
    }
}
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        int[] index=new int[n+1];
        int[] a=new int[n+1];
        for(int i=1;i<=n;i++){
            index[i]=i-1;
            a[i]=nums[i-1];
        }

        sort(a,index);

        int i=1,j=n;
        while(i<j) {
            if(a[j]+a[i]>target)
                j--;
            else if(a[j]+a[i]<target)
                i++;
            else
                break;
        }
        return new int[]{index[i],index[j]};
    }

    private static void sort(int[] arr,int[] index){
        int length=arr.length;
        makeMaxHeap(arr, index,length-1);
        for(int i=length-1;i>=2;i--){
            int temp=arr[1];
            arr[1]=arr[i];
            arr[i]=temp;

            temp=index[i];
            index[i]=index[1];
            index[1]=temp;
            adjustTree(arr,index,1,i-1);// regain max heap tree
        }
    }

    private static void makeMaxHeap(int[] arr, int[] index,int length) {
        for(int i=length/2;i>=1;i--){
            adjustTree(arr,index,i,length);
        }
    }

    private static void adjustTree(int[] arr, int[] index, int parentIndex, int numberOfElements) {
        int j=parentIndex*2;
        int item=arr[parentIndex];
        int item1=index[parentIndex];
        while (j<=numberOfElements){
            if(j<numberOfElements && arr[j]<arr[j+1])
                j++;
            if(item>arr[j])
                break;
            arr[j/2]=arr[j];
            index[j/2]=index[j];
            j=j*2;
        }
        arr[j/2]=item;
        index[j/2]=item1;
    }
}




