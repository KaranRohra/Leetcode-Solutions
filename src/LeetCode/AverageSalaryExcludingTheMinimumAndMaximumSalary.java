package LeetCode;

import java.util.Scanner;

public class AverageSalaryExcludingTheMinimumAndMaximumSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution1491 s = new Solution1491();
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.print(s.average(a));
    }
}
class Solution1491 {
    public double average(int[] salary) {
        int n=salary.length,max=salary[0],min=salary[0];
        for (int value : salary) {
            if (value > max)
                max = value;
            if (value < min)
                min = value;
        }
        double avg=0;
        for(int i=0;i<n;i++){
            if(salary[i]!=min && salary[i]!=max){
                avg+=salary[i];
            }
        }
        return avg/(n-2);
    }
}