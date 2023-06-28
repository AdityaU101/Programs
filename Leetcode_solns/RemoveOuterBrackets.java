import java.util.Stack;

class RemoveOuterBrackets {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
		Stack<Character> stk = new Stack<>();
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(c=='(') {
				if(stk.size()>0) {
					sb.append(c);
				}
				stk.push(c);
			}
			else {
				stk.pop();
				if(stk.size()>0) {
					sb.append(c);
				}
			}
		}
		return sb.toString();
    }
}