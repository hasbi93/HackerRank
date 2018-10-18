import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;

class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        in.close();
        
        /* Push characters onto a stack (reversed) and queue (original order) */
        Deque<Character> stack = new ArrayDeque<Character>();
        Deque<Character> queue = new ArrayDeque<Character>();
        for (Character ch : str.toCharArray()) {
            stack.push(ch);
            queue.add(ch);
        }
        
        /* If queue and stack elements are unequal, string isn't a palindrome */
        while (stack.isEmpty() == false) {
            if (!stack.pop().equals(queue.remove())) {
                System.out.println("No");
                System.exit(0);
            }
        }
                
        System.out.println("Yes");
    }
    
}