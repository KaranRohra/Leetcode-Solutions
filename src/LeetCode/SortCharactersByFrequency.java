package LeetCode;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        System.out.println(new Solution451().frequencySort("Aabb"));
    }
}
//https://leetcode.com/problems/sort-characters-by-frequency/
class Solution451 {
    public String frequencySort(String s) {
        char[] str=s.toCharArray();
        int[] cnt=new int[128];
        char[] character=new char[128];
        for (char value : str) {
            cnt[value]++;
            character[value] = value;
        }
        sort(cnt,character);
        int i=0,k=0;
        while(cnt[i]!=0){
            char c=character[i];
            while(cnt[i]-->0){
                str[k++]=c;
            }
            i++;
        }
        return String.valueOf(str);
    }
    public void sort(int[] a,char[] c){// Insertion Sort
        for(int i=1;i<128;i++){
            int key=a[i];
            char cKey=c[i];
            int j=i-1;
            while(j>=0 && a[j]<key){
                a[j+1]=a[j];
                c[j+1]=c[j];
                j--;
            }
            a[j+1]=key;
            c[j+1]=cKey;
        }
    }
}