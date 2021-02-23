import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How Password you want generate?");
        int t= sc.nextInt();
        while (t-->0) {
//            System.out.println("How much long password you want up to 100");
//            System.out.print("Enter length:");
            int n = 20;
            System.out.println(getPassword(n));
        }
    }

    private static String getPassword(int n){
        String lower="abcdefghijklmnopqrstuvwxyz";
        String upper=lower.toUpperCase();
        String number="0123456789";
        String otherSymbols="!@#$%^&*";

        StringBuilder password=new StringBuilder();
        Random r=new Random();
        for(int i=0;i<n;i++){
            int choice=r.nextInt(4);
            switch (choice){
                case 0:
                    int index=r.nextInt(26);
                    password.append(lower.charAt(index));
                    break;
                case 1:
                    index=r.nextInt(26);
                    password.append(upper.charAt(index));
                    break;
                case 2:
                    index=r.nextInt(number.length());
                    password.append(number.charAt(index));
                    break;
                case 3:
                    index=r.nextInt(otherSymbols.length());
                    password.append(otherSymbols.charAt(index));
                    break;
            }
        }
        return new String(password);
    }
}
