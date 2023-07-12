class RomanToInteger {
    int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && s.charAt(i) == 'I' && s.charAt(i + 1) == 'V')
                result += 4;
            else if (i + 1 < s.length() && s.charAt(i) == 'I' && s.charAt(i + 1) == 'X')
                result += 9;
            else if (i + 1 < s.length() && s.charAt(i) == 'X' && s.charAt(i + 1) == 'L')
                result += 40;
            else if (i + 1 < s.length() && s.charAt(i) == 'X' && s.charAt(i + 1) == 'C')
                result += 90;
            else if (i + 1 < s.length() && s.charAt(i) == 'C' && s.charAt(i + 1) == 'D')
                result += 400;
            else if (i + 1 < s.length() && s.charAt(i) == 'C' && s.charAt(i + 1) == 'M')
                result += 900;
            else {
                result += convertor(s.charAt(i));
                i--;
            }
            i++;
        }    
        return result;
    }


    int convertor(char digit) {
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