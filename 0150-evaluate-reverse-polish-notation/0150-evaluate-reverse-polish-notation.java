class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> s = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {
            String t = tokens[i];
            if (t.equals("+") || t.equals("-") || t.equals("*") ||t.equals("/")) {
                int b = s.pop();
                int a = s.pop();
                int result = 0;
                switch(t) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;                    
                    case "*":
                        result = a * b;
                        break;                    
                    case "/":
                        result = a / b;
                        break;
                }
                s.push(result);
            } else {
                s.push(Integer.parseInt(t));
            }
        }

        return s.pop();
    }
}
