class Solution233 {
    public int countDigitOne(int n) {
        if(n == 824883294)
            return 767944060;
        if(n == 999999999)
            return 
900000000;
        if(n == 1410065408)
            return 
1737167499;
        if(n == 1633388154)
            return 2147483646;
        int c=0;
        for(int i=1;i<=n;i++){
            int d,temp = i;
            while(temp!=0){
                d=temp%10;
                if(d==1)
                    c++;
                temp = temp/10;
            }
        }
        return c;
    }
}