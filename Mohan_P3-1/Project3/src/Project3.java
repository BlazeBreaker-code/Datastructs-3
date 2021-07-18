import java.util.Scanner;
class Project3 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        Tree T1 = new Tree();

        Node N55 = new Node();
        N55.setData(55);
        T1.setRoot(N55);

        Node N60 = new Node();
        N60.setData(60);

        Node N20 = new Node();
        N20.setData(20);

        N55.setLeft(N60);
        N55.setRight(N20);

        Node N85 = new Node();
        N85.setData(85);

        Node N70 = new Node();
        N70.setData(70);

        N60.setLeft(N85);
        N60.setRight(N70);

        Node N15 = new Node();
        N15.setData(15);
        Node N75 = new Node();
        N75.setData(75);

        N85.setLeft(N15);
        N85.setRight(N75);

        Node N50 = new Node();
        N50.setData(50);
        Node N65 = new Node();
        N65.setData(65);

        N70.setLeft(N50);
        N70.setRight(N65);

        Node N10 = new Node();
        N10.setData(10);

        Node N30 = new Node();
        N30.setData(30);

        N20.setLeft(N10);
        N20.setRight(N30);


        Node N25 = new Node();
        N25.setData(25);
        Node N80 = new Node();
        N80.setData(80);

        N10.setLeft(N25);
        N10.setRight(N80);

        Node N35 = new Node();
        N35.setData(35);
        Node N5 = new Node();
        N5.setData(5);

        N30.setLeft(N35);
        N30.setRight(N5);


        System.out.println("Checking function size()");
        System.out.println("------------------------");
        System.out.println("The size of the binary tree T1 is: " + T1.count());

        System.out.println("\nChecking function height()");
        System.out.println("------------------------");
        System.out.println("The height of the binary tree is: " + T1.height());

        System.out.println("\nChecking function leaves()");
        System.out.println("--------------------------");
        System.out.println("The leaves of the binary tree T1 are: ");
        T1.leaves();

        System.out.println("\nChecking function internal()");
        System.out.println("----------------------------");
        System.out.println("The internal nodes of the binary tree T1 are: ");
        T1.internal();

        System.out.println("\nChecking functions printLDR(), printDLR(), and printLRD()");
        System.out.println("---------------------------------------------------------");
        System.out.print("Enter 1 (in-order traversal of T1),\n" +
                "      2 (pre-order traversal of T1), or\n" +
                "      3 (post-order traversal of T1): ");
        int order = scan.nextInt();
        switch(order){
            case 1 :
                System.out.println("The nodes of the binary tree T1 in in-order traversal are: ");
                T1.printLDR();
                break;
            case 2 :
                System.out.println("The nodes of the binary tree T1 in pre-order traversal are: ");
                T1.printDLR();
                break;
            case 3 :
                System.out.println("The nodes of the binary tree T1 in post-order traversal are: ");
                T1.printLRD();
                break;
        }

        System.out.println("\nChecking function search()");
        System.out.println("--------------------------");
        System.out.print("Enter element to search: ");
        int search = scan.nextInt();
        System.out.println(search + (T1.search(search) ? " belongs " : " does not belong ") + "in the binary tree T1");

        System.out.println("\nChecking function path()");
        System.out.print("Enter element to find path for: ");
        int path = scan.nextInt();
        System.out.println("The path from the root of T1 to node " + path + " is:");
        T1.path(path);

        System.out.println("\nChecking the function descendants()");
        System.out.println("------------------------------------");
        System.out.print("Enter element to find descendents for: ");
        int descendents = scan.nextInt();
        System.out.println("The descendents of "+descendents+" in T1 are: ");
        T1.descendents(descendents);

        System.out.println("\nChecking function copy()");
        System.out.println("------------------------");
        System.out.println("Let T2 be a copy of T1\n" + "The nodes of binary tree T2 in in-order traversal are: ");
        Tree T2 = T1.copy();
        T2.printLDR();

        System.out.println("\nChecking function equal()");
        System.out.println("-------------------------");
        System.out.println("Let data part of node 80 be 90 in binary tree T1");
        N80.setData(90);
        System.out.println("Binary trees T1 and T2 are" + (T1.equal(T2) ? " " : " not ") + "equal");
        System.out.println("Let data part of node 80 be 80 in binary tree T1");
        N80.setData(80);
        System.out.println("Binary trees T1 and T2 are" + (T1.equal(T2) ? " " : " not ") + "equal");
    }
}
