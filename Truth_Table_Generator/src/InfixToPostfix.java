public class InfixToPostfix {
    Stack output = new Stack();
    Stack operator = new Stack();
    private String booleanExpression;
    private int length;
    String print = "";

    public void setLength(int length) {
        this.length = length;
    }

    public void setBooleanExpression(String booleanExpression) {
        this.booleanExpression = booleanExpression;
    }

    public String getBooleanExpression() {
        return booleanExpression;
    }


    public boolean checkIfNumOrLetter(char val){
        if(Character.isLetterOrDigit(val)){
            return true;
        }
        else
            return false;
    }
    public int checkPrecedence(char val){
        if(val == '-' || val == '+'){
            return 1;
        }
        else if(val == '*' || val == '/'){
            return 2;
        }
        else if(val == '!'){
            return 3;
        }
        else
            return 0;
    }
    public boolean isLeft(char val){
        if(val == '+' || val == '-' || val == '/' || val == '*'){
            return true;
        }
        else
            return false;
    }
    public void printOutput(Stack s){
        if(s.isEmpty())
            return;
        //char curr = s.peek();
        //s.pop();
        print = print + output.pop()/*curr*/;
        printOutput(s);
        //s.push(curr);
    }
    public String convertToPostfix() {
        for (int i = 0; i < length; i++){
            char curr = booleanExpression.charAt(i);
            if(checkIfNumOrLetter(curr)){
                output.push(curr);
            }
            else if(curr == '(')
                operator.push(curr);
            else if(curr == ')'){
                while(!operator.isEmpty() && operator.peek() != '(') {
                    output.push(output.pop());
                }
                operator.pop();
            }

            else{
                while(!operator.isEmpty() && checkPrecedence(curr) <= checkPrecedence(operator.peek()) && isLeft(curr)){
                    output.push(operator.pop());
                }
             operator.push(curr);
            }
        }
        while(!operator.isEmpty()) {
            if (operator.peek() == '(') {
                return "this expression is invalid";
            }
            output.push(operator.pop());
        }

        return output.print();
    }

}
