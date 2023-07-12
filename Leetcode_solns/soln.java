

class soln {
    public int romanToInt(String s) {
        int sum=convert(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) - '0'>s.charAt(i+1) - '0'){
                sum+=convert(s.charAt(i+1));
            }
            else{
                sum-=convert(s.charAt(i+1));
            }
        }
        return sum;
    }

    public int convert(char digit) {
        if (digit == 'I')
            return 1;
        else if (digit == 'V')
            return 5;
        else if (digit == 'X')
            return 10;
        else if (digit == 'L')
            return 50;
        else if (digit == 'C')
            return 100;
        else if (digit == 'D')
            return 500;
        else 
            return 1000;
    }
}