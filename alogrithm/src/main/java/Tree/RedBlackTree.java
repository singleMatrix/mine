package Tree;

/**
 * @author single
 * @date 2018/4/4.
 */
public class RedBlackTree {
    private Node root = null;


    public void insert(int k) {
        Node node = new Node(k);
        insert(node);
    }

    private void insert(Node node) {
        //查找插入节点
        Node current = this.root;
        while (current != null) {
            if (node.key <= current.key) {
                current = node.lnode;
            } else {
                current = node.rnode;
            }
        }

        //将节点插入树种
        if (current.pnode != null) {
            if (node.key <= current.key) {
                current.lnode = node;
            } else {
                current.rnode = node;
            }
            node.pnode = current;
        } else {
            this.root = node;
        }
        //修正红黑树
        insertFixUp(node);
    }

    private void insertFixUp(Node node) {
        Node pnode = node.pnode;

        if (pnode == null) {
            node.color = true;
            return;
        }
        //如果父节点颜色为黑色
        if (pnode.color) {
            return;
        }

        Node gpnode = pnode.pnode;

        //父节点为红色父节点为左节点
        if (pnode.key == gpnode.lnode.key) {
            Node uncle = gpnode.rnode;
            //如果叔叔节点为红色
            if (!uncle.color) {
                pnode.color = true;
                uncle.color = true;
                gpnode.color = false;
                insertFixUp(gpnode);
            } else {
                //叔叔节点为黑节点
                pnode.color = true;
                gpnode.color = false;
                rightRotate(gpnode);
            }
        } else {
            Node uncle = gpnode.lnode;
            if (uncle.color) {
                //父节点为红色 父节点为右节,叔叔节点为黑色
                pnode.color = true;
                gpnode.color = false;
                leftRotate(gpnode);
            } else {
                //父节点为红色右节点,叔叔节点为红色
                pnode.color = true;
                uncle.color = true;
                gpnode.color = false;
                insertFixUp(gpnode);
            }
        }
    }

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        Node node10 = tree.new Node(10);
        Node node8 = tree.new Node(8);
        Node node20 = tree.new Node(20);
        Node node6 = tree.new Node(6);
        Node node30 = tree.new Node(30);
        Node node1 = tree.new Node(1);
        Node node26 = tree.new Node(26);

        node6.lnode = node1;
        node6.rnode = node8;

        node26.rnode = node30;
        node26.lnode = node20;

        node10.lnode = node6;
        node10.rnode = node26;

        tree.firstView(node10);
    }

    public void firstView(Node node) {
        if (node != null) {
            System.out.println(node.key + " ");
            firstView(node.lnode);
            firstView(node.rnode);
        }
    }

    private void leftRotate(Node y) {
        Node x = y.lnode;
        Node rx = x.rnode;

        x.pnode = y.pnode;
        y.pnode = x;
        y.lnode = rx;
    }

    private void rightRotate(Node x) {
        Node y = x.rnode;
        Node ly = y.lnode;

        y.pnode = x.pnode;
        x.pnode = y;
        x.rnode = ly;
    }

    private class Node {
        int key;
        boolean color;//true 黑  false 红
        Node lnode;
        Node rnode;
        Node pnode;

        public Node(int key) {
            this.key = key;
            this.color = false;
        }
    }
}
