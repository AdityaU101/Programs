class MaxNestingDepth{
    public int maxDepth(String s) {
        int c=0,res=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') c++;
            if(s.charAt(i)==')')c--;
            res=Math.max(res,c);
        }
        return res;
    }
}