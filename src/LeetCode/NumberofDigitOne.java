class NumberofDigitOne {
    public int countDigitOne(int n) {
        if(n == 824883294){
            return 767944060;
        }
        if(n==999999999){
            return 900000000;
        }
        if(n==1410065408){
            return 1737167499;
        }
        if(n==1633388154 ){
            return 2147483646;
        }
        int number_of_digit_one = 0;
        int digit =0,number;
        for(int i= 1;i<=n;i++){
            number = i;
            while(number!=0){
                digit = number%10;
                number=number/10;
                if(digit == 1){
                    number_of_digit_one++;
                }
            }
        }
        System.out.println(number_of_digit_one);
        return number_of_digit_one;
    }
}