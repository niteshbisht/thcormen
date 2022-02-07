package app.algo.easy;

import java.util.Stack;

public class QueueUsingTwoStacks {

    public static class Queue {
        Stack<Integer> s1;
        Stack<Integer> s2;

        public Queue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            s1.push(x);
        }

        public int pop() {
            if (empty()) {
                return -1;
            }
            arrange();
            return s2.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (empty()) {
                return -1;
            }
            arrange();
            return s2.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }

        public void arrange() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
        }
    }
}
