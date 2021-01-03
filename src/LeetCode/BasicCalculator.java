package LeetCode;

import java.util.*;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution224 s = new Solution224();
        System.out.println(s.calculate(sc.next()));
    }
}
class Solution224 {
    public int calculate(String s) {
        char[] postfix=infixToPostfix(s.replace(" ","")).toCharArray();
        System.out.println(postfix);
        Stack<Integer> opeStack=new Stack<>();
        int n=postfix.length;
        for(int i=0;i<n && postfix[i]!='#';i++){
            if(postfix[i]==' ')
                continue;
            if(postfix[i]>='0' && postfix[i]<='9'){
                int m=0;
                while (i<n && postfix[i]>='0' && postfix[i]<='9'){
                    m=m*10+(postfix[i]-'0');
                    i++;
                }
                opeStack.push(m);
                i--;
            }
            else{
                int a=opeStack.pop();
                int b=opeStack.pop();
                switch (postfix[i]){
                    case '+':opeStack.push(b+a);break;
                    case '-':opeStack.push(b-a);break;
                    case '*':opeStack.push(b*a);break;
                    case '/':opeStack.push(b/a);break;
                }
            }
        }
        return opeStack.pop();
    }
    private String infixToPostfix(String input){
        Stack<Character> opStack=new Stack<>();
        char[] infix=input.toCharArray();
        int n=infix.length,k=0;
        char[] postfix=new char[n*2];
        for(int i=0;i<n;i++){
            if(infix[i]>='0' && infix[i]<='9'){
                while(i<n && infix[i]>='0' && infix[i]<='9')
                    postfix[k++]=infix[i++];
                postfix[k++]=' ';
                i--;
            }
            else if(infix[i]=='(')
                opStack.push('(');
            else{
                while (!opStack.isEmpty() && priority(opStack.peek())>=priority(infix[i])){
                    char c=opStack.pop();
                    if(c!='(') {
                        postfix[k++] = c;
                        if(k<n*2)
                            postfix[k++] = ' ';
                    }
                    else
                        break;
                }
                if(infix[i] != ')')
                    opStack.push(infix[i]);
            }
        }
        while (!opStack.isEmpty()) {
            postfix[k++] = opStack.pop();
            if(k<n*2)
                postfix[k++] = ' ';
        }
        if(k<n*2)
            postfix[k]='#';
        return String.valueOf(postfix);
    }
    private int priority(char c){
        switch (c){
            case '+':
            case '-':return 1;
            case '*':
            case '/':return 2;
            default:return 0;
        }
    }
}