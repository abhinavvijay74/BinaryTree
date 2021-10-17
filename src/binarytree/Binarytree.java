//binary search tree with duplicate value
package binarytree;
public class Binarytree {
     static class Node
     {
         int data;
         Node left,right;
         int count;
     };
     static Node newNode(int key)
             
     {
         Node temp=new Node();
         temp.data=key;
         temp.left=null;
         temp.right=null;
         temp.count=1;
         return temp;
     }
     static Node insert(Node node,int key)
     {
         if(node==null)
         {
             return newNode(key);
         }
         else if(node.data==key)
         {
             node.count++;
             return node;
         }
         else if(key<node.data)
         {
             node.left=insert(node.left, key);
         }
         else
         {
             node.right=insert(node.right, key);
         }
         return node;
             
                 
     }
     static void inorder(Node node)
     {
         if(node!=null)
         {
             inorder(node.left);
             System.out.println(node.data+"("+node.count+")");
             inorder(node.right);
         }
     }
     static Node minvaluenode(Node node)
     {
         Node current=node;
         while(current.left!=null)
         {
             current=current.left;
         }
         return current;
     }
     static Node deletenode(Node node,int key)
     {
         if(node==null)
         {
             return node;
         }
         else if(node.data>key)
         {
             node.left=deletenode(node.left, key);
         }
         else if(node.data<key)
         {
             node.right=deletenode(node.right, key);
         }
         else
         {
             if(node.count>1)
             {
                 node.count--;
                 return node;
             }
             else if(node.left==null)
             {
                 Node temp=node.right;
                 node=null;
                 return temp;
                 
             }
             else if(node.right==null)
             {
                 Node temp=node.left;
                 node=null;
                 return temp;
             }
             else
             {
                 Node temp=minvaluenode(node.right);
                 node.data=temp.data;
                 node.right=deletenode(node.right, key);
             }
                     
          
         }
         return node;    
     }
         
     
    
    public static void main(String[] args) {
      Node root = null; 
    root = insert(root, 12); 
    root = insert(root, 10); 
    root = insert(root, 20); 
    root = insert(root, 9);
     root = insert(root, 11); 
    root = insert(root, 10); 
    root = insert(root, 12); 
    root = insert(root, 12); 
       
        System.out.print("Inorder traversal of " +  
                     "the given tree " + "\n"); 
    inorder(root); 
  
    System.out.print("\nDelete 20\n"); 
    root = deletenode(root, 20); 
    System.out.print("Inorder traversal of " +  
                     "the modified tree \n"); 
    inorder(root); 
  
    System.out.print("\nDelete 12\n"); 
    root = deletenode(root, 12); 
    System.out.print("Inorder traversal of " +  
                     "the modified tree \n"); 
    inorder(root); 
  
    System.out.print("\nDelete 9\n"); 
    root = deletenode(root, 9); 
    System.out.print("Inorder traversal of " +  
                     "the modified tree \n"); 
    inorder(root); 
    }
    
}
