/** **************************************************************************
 *                     The  generic Binary Search Tree class.
 *
 * V.S.Adamchik 2010
 *****************************************************************************/

import java.util.*;

public class BST
{
   public static void main(String[] args)
   {

      BST bst = new BST();
      bst.insert(11);
      bst.insert(6);
      bst.insert(8);
      bst.insert(19);
      bst.insert(4);
      bst.insert(10);
      bst.insert(5);
      bst.insert(17);
      bst.insert(43);
      bst.insert(49);
      bst.insert(31);
      bst.delete(6);



      bst.preOrderTraversal();
      System.out.println();


   }


   private Node root;

   private class Node {
      Node left;
      Node right;
      int data;
      Node(int newData) {
        left = null;
        right = null;
        data = newData;
     }
   }

   public BST()
   {
      root = null;

   }





/*****************************************************
*
*            INSERT
*
******************************************************/
   public void insert(int data)
   {
      root = insert(root, data);
   }
   private Node insert(Node p, int key)
   {
      if (p == null)
         return new Node(key);

      if (key == p.data)
      	return p;

      if (key <= p.data)
         p.left = insert(p.left, key);
      else
         p.right = insert(p.right, key);

      return p;
   }

/*****************************************************
*
*            SEARCH
*
******************************************************/
   public boolean search(int key)
   {
      return search(root, key);
   }
   private boolean search(Node p, int key)
   {
      if (p == null)
         return false;
      else
      if (key == p.data)
      	return true;
      else
      if (key <= p.data)
         return search(p.left, key);
      else
         return search(p.right, key);
   }

/*****************************************************
*
*            DELETE
*
******************************************************/

   public void delete(int key)
   {
      root = delete(root, key);
   }
   private Node delete(Node p, int key)
   {
      if (p == null)  throw new RuntimeException("No Node to delete");
      else
      if (key < p.data)
      p.left = delete (p.left, key);
      else if (key > p.data)
      p.right = delete (p.right, key);
      else
      {
         if (p.left == null) return p.right;
         else
         if (p.right == null) return p.left;
         else
         {
         // get data from the rightmost node in the left subtree
            p.data = retrieveData(p.right);
         // delete the rightmost node in the left subtree
            p.right =  delete(p.right, p.data) ;
         }
      }
      return p;
   }
   private int retrieveData(Node p)
   {
      while (p.left != null) p = p.left;

      return p.data;
   }



/*************************************************
 *
 *            TRAVERSAL
 *
 **************************************************/

   public void preOrderTraversal()
   {
      preOrderHelper(root);
   }
   private void preOrderHelper(Node r)
   {
      if (r != null)
      {
         System.out.print(r.data + " ");
         preOrderHelper(r.left);
         preOrderHelper(r.right);
      }
   }

   public void inOrderTraversal()
   {
      inOrderHelper(root);
   }
   private void inOrderHelper(Node r)
   {
      if (r != null)
      {
         inOrderHelper(r.left);
         System.out.print(r.data + " ");
         inOrderHelper(r.right);
      }
   }
}
