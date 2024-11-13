import java.util.EmptyStackException;

public class Stack {
    private Node head;
    public Stack(){
        this.head = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public boolean push(char val) {
        Node current = new Node(val);
        current.next = head;
        head = current;
        return true;
    }
    public char pop(){
        if(!isEmpty()){
            char data = head.data;
            head = head.next;
            return data;
        }
        else{
            throw new EmptyStackException();
        }
    }
    public char peek(){
        return head.data;
    }

    public String print(){
        Node curr = head;
        String print = "";
        while(curr!=null){
            print =  curr.data + print;
            curr = curr.next;
        }
        return print;
    }

}
