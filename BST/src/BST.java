import java.util.LinkedList;
import java.util.Queue;

public class BST {
    // binary search tree
    private Node root;

    public BST() {
        root = null;
    }

    public void insert(int data) {
        // insert a new node into the tree
        Node newNode = new Node(data);
        if (root == null)
            root = newNode;
        else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (data < current.getData()) {
                    current = current.getLeft();
                    if (current == null) {
                        parent.setLeft(newNode);
                        return;
                    }
                } else {
                    current = current.getRight();
                    if (current == null) {
                        parent.setRight(newNode);
                        return;
                    }
                }
            }
        }
    }

    public void inOrder(Node localRoot) {
        // in-order traversal
        if (localRoot != null) {
            inOrder(localRoot.getLeft());
            System.out.print(localRoot.getData() + " ");
            inOrder(localRoot.getRight());
        }
    }

    public void preOrder(Node localRoot) {
        // pre-order traversal
        if (localRoot != null) {
            System.out.print(localRoot.getData() + " ");
            preOrder(localRoot.getLeft());
            preOrder(localRoot.getRight());
        }
    }

    public void postOrder(Node localRoot) {
        // post-order traversal
        if (localRoot != null) {
            postOrder(localRoot.getLeft());
            postOrder(localRoot.getRight());
            System.out.print(localRoot.getData() + " ");
        }
    }

    public void levelOrder(Node localRoot) {
        // level-order traversal
        Queue<Node> queue = new LinkedList<>();
        queue.add(localRoot);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.getData() + " ");
            if (tempNode.getLeft() != null)
                queue.add(tempNode.getLeft());
            if (tempNode.getRight() != null)
                queue.add(tempNode.getRight());
        }
    }

    public int height(Node localRoot) {
        // height of the tree
        if (localRoot == null)
            return 0;
        else {
            int leftHeight = height(localRoot.getLeft());
            int rightHeight = height(localRoot.getRight());
            if (leftHeight > rightHeight)
                return leftHeight + 1;
            else
                return rightHeight + 1;
        }
    }

    public int leafCount(Node localRoot) {
        // count the number of leaves in the tree
        if (localRoot == null)
            return 0;
        else if (localRoot.getLeft() == null && localRoot.getRight() == null)
            return 1;
        else
            return leafCount(localRoot.getLeft()) + leafCount(localRoot.getRight());
    }

    public void deleteAll() {
        // delete all nodes in the tree
        root = null;
    }

    public Node minimum(Node localRoot) {
        // find the minimum value in the tree
        if (localRoot == null)
            return null;
        else if (localRoot.getLeft() == null)
            return localRoot;
        else
            return minimum(localRoot.getLeft());
    }

    public Node maximum(Node localRoot) {
        // find the maximum value in the tree
        if (localRoot == null)
            return null;
        else if (localRoot.getRight() == null)
            return localRoot;
        else
            return maximum(localRoot.getRight());
    }

    public boolean isFull(Node localRoot) {
        // check if the tree is full
        if (localRoot == null)
            return true;
        if (localRoot.getLeft() == null && localRoot.getRight() == null)
            return true;
        if (localRoot.getLeft() != null && localRoot.getRight() != null)
            return isFull(localRoot.getLeft()) && isFull(localRoot.getRight());
        return false;
    }

    public boolean isIdentical(Node root1, Node root2) {
        // check if two trees are identical
        if (root1 == null && root2 == null)
            return true;
        if (root1 != null && root2 != null)
            return (root1.getData() == root2.getData() && isIdentical(root1.getLeft(), root2.getLeft()) && isIdentical(root1.getRight(), root2.getRight()));
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        // check if two trees are identical
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        final BST other = (BST) obj;
        return isIdentical(this.root, other.root);
    }

    public boolean search(int data) {
        // search for a node in the tree
        Node current = root;
        while (current != null) {
            if (current.getData() == data)
                return true;
            else if (current.getData() > data)
                current = current.getLeft();
            else
                current = current.getRight();
        }
        return false;
    }

    public void printOddNodes(Node localRoot) {
        // print all odd nodes in the tree
        if (localRoot != null) {
            if (localRoot.getData() % 2 != 0)
                System.out.print(localRoot.getData() + " ");
            printOddNodes(localRoot.getLeft());
            printOddNodes(localRoot.getRight());
        }
    }

    public void printEvenNodes(Node localRoot) {
        // print all even nodes in the tree
        if (localRoot != null) {
            if (localRoot.getData() % 2 == 0)
                System.out.print(localRoot.getData() + " ");
            printEvenNodes(localRoot.getLeft());
            printEvenNodes(localRoot.getRight());
        }
    }

    @Override
    public String toString() {
        // print the tree in level-order
        String s = "";
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            s += tempNode.getData() + " ";
            if (tempNode.getLeft() != null)
                queue.add(tempNode.getLeft());
            if (tempNode.getRight() != null)
                queue.add(tempNode.getRight());
        }
        return s;
    }

    public int countNodes(Node localRoot) {
        // count the number of nodes in the tree
        if (localRoot == null)
            return 0;
        else
            return 1 + countNodes(localRoot.getLeft()) + countNodes(localRoot.getRight());
    }

    public Node getRoot() {
        return root;
    }
}