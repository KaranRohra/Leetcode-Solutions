package leetCode;

import java.util.Scanner;

public class RearrangeWordsInASentence {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution1451 s = new Solution1451();
        System.out.println(s.arrangeWords(sc.nextLine()));
    }
}
class Solution1451 {
    public String arrangeWords(String text) {
        text=text.toLowerCase();
        String []words=text.split(" ");
        int n=words.length;
        String temp;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(words[j].length() > words[j+1].length()){
                    temp=words[j];
                    words[j]=words[j+1];
                    words[j+1]=temp;
                }
            }
        }
        words[0]=words[0].substring(0,1).toUpperCase()+words[0].substring(1);
        StringBuilder textBuilder = new StringBuilder();
        for(int i=0;i<n;i++){
            textBuilder.append(words[i]);
            if(i!=n-1)
                textBuilder.append(" ");
        }
        return textBuilder.toString();
    }
}
