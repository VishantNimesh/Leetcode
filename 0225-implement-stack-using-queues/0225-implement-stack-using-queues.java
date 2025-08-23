import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    int topElement;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        if (!q1.isEmpty()) {
            q1.add(x);
        } else {
            q2.add(x);
        }
        topElement = x; 
    }

    public int pop() {
        if (empty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        int top = -1;

        if (!q1.isEmpty()) {
            while (q1.size() > 1) {
                topElement = q1.remove();
                q2.add(topElement);
            }
            top = q1.remove(); // last element
        } else {
            while (q2.size() > 1) {
                topElement = q2.remove();
                q1.add(topElement); 
            }
            top = q2.remove(); // last element
        }

        return top;
    }

    public int top() {
        if (empty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return topElement;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */