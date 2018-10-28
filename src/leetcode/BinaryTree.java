package leetcode;

public class BinaryTree {

    Node root;

    class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

//    public Node addNode(int data){
//
//        Node newNode =  new Node(data);
//
//        if(root == null)
//            return root = newNode;
//
//        if(data <= root.data){
//            return addNode(root.left);
//        }
//
//    }

    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
      //  tree.addNode(5);
    }

}
