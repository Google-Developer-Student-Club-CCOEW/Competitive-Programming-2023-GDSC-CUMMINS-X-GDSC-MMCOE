import java.util.*;

public class comman {
    static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data= data;
            this.left= null;
            this.right= null;

        }
    }
    public static boolean getPath(Node root, int n, ArrayList<Node>path){
        if (root==null) {
            return false;
        }
        path.add(root);
        if (root.data==n) {
            return true;
        }
        boolean foundLeft= getPath(root.left, n, path);
        boolean foundRight= getPath(root.right, n, path);

        if (foundLeft||foundRight) {
            return true;
        }
        path.remove(path.size()-1);
        return false;  
    }

    public static Node lca(Node root, int p, int q){
        ArrayList<Node>path1= new ArrayList<>();
        ArrayList<Node>path2= new ArrayList<>();

        getPath(root, p, path1);
        getPath(root, q, path2);
        int i=0;
        for(; i<path1.size()&&i<path2.size(); i++ ){
            if (path1.get(i)!=path2.get(i)) {
                break;
            }
        }
        Node lca=path1.get(i-1);
        return lca;

    }
    public static void main(String[] args) {
        Node root= new Node(6);
        root.left= new Node(2);
        root.right= new Node(8);
        root.left.left= new Node(0);
        root.left.right= new Node(4);
        root.right.left= new Node(7);
        root.right.right= new Node(9);
        root.left.right.left= new Node(3);
        root.left.right.right= new Node(5);

        int p=2,q=8;
        System.out.println(lca(root, p, q).data);
    }
}
