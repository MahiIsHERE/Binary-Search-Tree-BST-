import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BST bst = new BST();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Insert");
            System.out.println("2. Delete All");
            System.out.println("3. Display");
            System.out.println("4. In-order traversal");
            System.out.println("5. Pre-order traversal");
            System.out.println("6. Post-order traversal");
            System.out.println("7. Level-order traversal");
            System.out.println("8. Count nodes");
            System.out.println("9. Count leaves");
            System.out.println("10. isFull");
            System.out.println("11. Print Odds");
            System.out.println("12. Print Evens");
            System.out.println("13. Search");
            System.out.println("14. Print Max");
            System.out.println("15. Print Min");
            System.out.println("16. Tree Height");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            int num;

            switch (choice) {
                case 1 : {
                    System.out.print("Enter the number to be inserted: ");
                    num = sc.nextInt();
                    bst.insert(num);
                    break;
                }
                case 2 : {
                    bst.deleteAll();
                    break;
                }
                case 3 : {
                    System.out.println(bst);
                    break;
                }
                case 4 : {
                    System.out.print("In-order traversal: ");
                    bst.inOrder(bst.getRoot());
                    System.out.println();
                    break;
                }
                case 5 : {
                    System.out.print("Pre-order traversal: ");
                    bst.preOrder(bst.getRoot());
                    System.out.println();
                    break;
                }
                case 6 : {
                    System.out.print("Post-order traversal: ");
                    bst.postOrder(bst.getRoot());
                    System.out.println();
                    break;
                }
                case 7 : {
                    System.out.print("Level-order traversal: ");
                    bst.levelOrder(bst.getRoot());
                    System.out.println();
                    break;
                }
                case 8 : {
                    System.out.println("Number of nodes: " + bst.countNodes(bst.getRoot()));
                    break;
                }
                case 9 : {
                    System.out.println("Number of leaves: " + bst.leafCount(bst.getRoot()));
                    break;
                }
                case 10 : {
                    System.out.println("isFull: " + bst.isFull(bst.getRoot()));
                    break;
                }
                case 11 : {
                    System.out.print("Print Odds: ");
                    bst.printOddNodes(bst.getRoot());
                    System.out.println();
                    break;
                }
                case 12 : {
                    System.out.print("Print Evens: ");
                    bst.printEvenNodes(bst.getRoot());
                    System.out.println();
                    break;
                }
                case 13 : {
                    System.out.print("Enter the number to be searched: ");
                    num = sc.nextInt();
                    System.out.println("Search: " + bst.search(num));
                    break;
                }
                case 14 : {
                    System.out.println("Print Max: " + bst.maximum(bst.getRoot()));
                    break;
                }
                case 15 : {
                    System.out.println("Print Min: " + bst.minimum(bst.getRoot()));
                    break;
                }
                case 16 : {
                    System.out.println("Tree Height: " + bst.height(bst.getRoot()));
                    break;
                }
                case 0 : {
                    System.out.println("Exiting...");
                    break;
                }
                default : {
                    System.out.println("Invalid choice!");
                }
            }
        } while (choice != 0);

    }
}
