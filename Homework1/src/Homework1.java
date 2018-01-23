import java.util.*;

public class Homework1 {

    public static Stack<Character> st = new Stack<Character>();
    public static Node TravTree;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your infix: ");
        String ans = scanner.nextLine();

        String infix0 = ans;
        for (int i = 0; i < infix0.length(); i++) {
            st.add(infix0.charAt(i));                //add infix to stack
        }
        TravTree = new Node(st.pop());

        infix(TravTree);
        inorder(TravTree);
        System.out.println("=" + calculate(TravTree));

        //for running via bash
        if (args.length > 0) {
            String input = args[0];
//            if(input.equalsIgnoreCase("251-*32*+")){
//                System.out.println("(2*(5-1))+(3*2)=14");
//        }
            String infix = input;
            for (int i = 0; i < infix.length(); i++) {
                st.add(infix.charAt(i));                //add infix to stack
            }
            TravTree = new Node(st.pop());

            infix(TravTree);
            inorder(TravTree);
            System.out.println("=" + calculate(TravTree));

        }
    }

    public boolean isOperator(char op) {
        if (op == '+' || op == '-' || op == '*' || op == '/') {
            return true;
        }
        return false;
    }

    public static int calculate(Node n) {
        if (n.value == '+') {
            return calculate(n.left) + calculate(n.right);
        }
        if (n.value == '-') {
            return calculate(n.left) - calculate(n.right);
        }
        if (n.value == '*') {
            return calculate(n.left) * calculate(n.right);
        }
        if (n.value == '/') {
            return calculate(n.left) / calculate(n.right);
        } else return Integer.parseInt(n.value.toString());
    }

    public static void infix(Node n) {
        if (n.value == '*' || n.value == '/' || n.value == '+' || n.value == '-'  ) {   //Check Operator
            //pop 2 top stacks
            n.right = new Node(st.pop());
            infix(n.right);
            n.left = new Node(st.pop());
            infix(n.left);

        }
    }


    public static void inorder(Node n) {
        if (n.value == '*' || n.value == '/' || n.value == '+' || n.value == '-'  ) {
            if (n != TravTree) {
                System.out.print("(");
            }
            inorder(n.left);
            System.out.print(n.value);
            inorder(n.right);

            if (n != TravTree) {
                System.out.print(")");
            } else {
                if ((n != TravTree)) {
                    System.out.print(n.value);
                }
            }
        }
        else {
            System.out.print(n.value);
        }
    }
}

