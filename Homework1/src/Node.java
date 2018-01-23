public class Node{
    Character value;
    Node left, right;

    Node(Character input) {
        value = input;
        left = null;
        right = null;
    }

    public String getValue(){
        return value.toString();
    }
}


