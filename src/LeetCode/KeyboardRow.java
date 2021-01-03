package leetCode;

import java.util.Scanner;

public class KeyboardRow {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution500 s = new Solution500();
        int n=sc.nextInt();
        String []str=new String[n];
        for(int i=0;i<n;i++)
            str[i]=sc.next();
        String []result=s.findWords(str);
        for(String i:result)
            System.out.println(i);
    }
}
class Solution500{
    public String[] findWords(String[] words) {
        int n=words.length,i,count=0;
        boolean []hai=new boolean[n];
        String []copy=new String[n];
        for(i=0;i<n;i++)
            copy[i]=words[i];
        for(i=0;i<n;i++)
            words[i]=words[i].toLowerCase();
        char [][]str= {
                {'q','w','e','r','t','y','u','i','o','p'},
                {'a','s','d','f','g','h','j','k','l'},
                {'z','x','c','v','b','n','m'},
        };
        for(i=0;i<n;i++){
            if(search(str[0],words[i],10) || search(str[1],words[i],9) || search(str[2],words[i],7)) {
                count++;
                hai[i]=true;
            }
        }
        String []result=new String[count];
        count=0;
        for(i=0;i<n;i++){
            if(hai[i]){
                result[count++]=copy[i];
            }
        }
        return result;
    }
    public boolean search(char []str,String s,int m){
        int n=s.length(),count=0,i,j;
        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                if(str[j]==s.charAt(i))
                    count++;
            }
        }
        return count == n;
    }
}