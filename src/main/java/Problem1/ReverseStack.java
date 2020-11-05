package Problem1;

import java.util.Stack;

public class ReverseStack {
    public static void reverseStack(Stack<Integer> stack) {
        // homework
        if (!stack.empty()) {
            int popped = stack.pop();
            reverseStack(stack);
            stackHelper(stack, popped);
        }
    }

    private static void stackHelper(Stack<Integer> stack, int pop) {
        if (stack.empty()) {
            stack.push(pop);
        } else {
            int popped_squared = stack.pop();
            stackHelper(stack, pop);
            stack.push(popped_squared);
        }

    }
}