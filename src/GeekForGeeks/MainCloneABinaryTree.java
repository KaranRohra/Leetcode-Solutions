package GeekForGeeks;

import java.util.HashMap;

public class MainCloneABinaryTree {//VVV IMP
    public static void main(String[] args) {
        Tree root=CloneABinaryTree.cloneTree(new Tree(1));
    }
}
//https://practice.geeksforgeeks.org/problems/clone-a-binary-tree/1/?company[]=Amazon&company[]=Amazon&problemStatus=unsolved&difficulty[]=1&page=1&query=company[]AmazonproblemStatusunsolveddifficulty[]1page1company[]Amazon
class CloneABinaryTree{
    static HashMap<Tree,Tree> map;
    public static Tree cloneTree(Tree tree){
        map=new HashMap<>();
        travel(tree);
        makeTree(tree);
        return map.get(tree);
    }
    private static void travel(Tree p){
        if(p==null)
            return;
        travel(p.left);
        map.put(p,new Tree(p.data));
        travel(p.right);
    }
    private static void makeTree(Tree p){
        if(p==null)
            return;
        makeTree(p.left);

        map.get(p).left=map.get(p.left);
        map.get(p).right=map.get(p.right);
        map.get(p).random=map.get(p.random);

        makeTree(p.right);
    }

}
class Tree {
    Tree left;
    Tree right;
    Tree random;
    int data;
    Tree(int data){
        this.data=data;
    }
}

