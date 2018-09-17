
package maze;

/**
 *
 * @author pratik
 */
import java.util.*;
import java.io.*;

public class Intcoll
{
   private int howmany;
   private btNode c;
   
//Makes collection empty with capacity 500
   public Intcoll()
   {
      c = null;
      howmany = 0;
   }
   
//Makes collection empty with capacity i
   public Intcoll(int i)
   {
      c = null;
      howmany = 0;
   }

   private static btNode copytree(btNode t)
   {
      btNode root=null;
      if (t!=null)
      {
         root=new btNode();
         root.info=t.info; 
         root.left=copytree(t.left);
         root.right=copytree(t.right);
      }
      return root;
   }
//Makes collection have the same capacity and the same integers 
// of another collection
   public void copy(Intcoll obj)
   {
      if (this!=obj)
      {
          howmany=obj.howmany;
          c=copytree(obj.c);  
      }
   }
 //If i is positive and not already in collection then it is added 
   public void insert(int i)
   {
      if (i>0)
      {
         btNode pred=null, p=c;

         while ((p!=null)&&(p.info!=i))
         {
             pred=p;
	     if (p.info>i) p=p.left;
	     else p=p.right;
         }
         if (p==null)
         {
            howmany++; p=new btNode(i, null, null);
            if (pred!=null)
            {
	       if (pred.info>i) pred.left=p;
               else pred.right=p;
	    }
	    else c=p;
         }
      }
   }
//If i is in the collection and positive then it is removed
   public void omit(int i)
   {
       if(i>0)
       {
         btNode pred=null, p=c;
         while ((p!=null)&&(p.info!=i))
         {
             pred=p;
	     if (p.info>i) p=p.left;
	     else p=p.right;
         }
         if(p!=null)
         {
             howmany--;
             if((p.left==null)&&(p.right==null))
             { 
                 if(pred!=null)
                 {
                     if(pred.info>i)pred.left=null;
                     else pred.right=null;
                 }
                 else c=null;
             }
             else if((p.left==null)&& (p.right!=null))
             {
                 if(pred!=null)
                 {
                     if(pred.info>i)pred.left=p.right;
                     else pred.right=p.right;
                 }
                 else c=p.right;
             }
             else if((p.left!=null)&& (p.right==null))
             {
                 if(pred!=null)
                 {
                     if(pred.info>i)pred.left=p.left;
                     else pred.right=p.left;
                 }
                 else c=p.left;
             }
             else
             {
                 
                    btNode predq=null,q=p.left;
                    while(q!=null)
                    {
                        predq=q;
                        q=q.right;
                    }
                    int hold=predq.info;
                    predq=null;
                    q=p.left;
                    while(q.info!=hold)
                    {
                        predq=q;
                        q=q.right;
                    } 
                    if(predq!=null)
                    {
                        if(q.left==null)
                        {
                         predq.right=null;
                        }
                        else
                        {
                         predq.right=q.left;
                        }    
                         q.left=p.left;
                         q.right=p.right;
                         p.left=null;p.right=null;//makes omited node point to nothing
                        if(pred!=null)
                        {
                          if(pred.info>q.info) pred.left=q;
                          else pred.right=q;  
                        }
                        else
                          c=q; 
                    }
                    else
                    {
                        p.left=null;
                        q.right=p.right;
                        if(pred!=null)
                        {
                         if(pred.info>q.info)pred.left=q;
                         else pred.right=q; 
                        }
                        else
                            c=q;
                        
                        p.right=null;//makes the omited node point to nothing
                    }    
             }
         }
         
       }

   }
   
//Returns true if i is postivie and in collection and false otherwise
   public boolean belongs(int i)
   {
      btNode p=c;
      while ((p!=null)&&(p.info!=i)) 
      {
         if (p.info>i) p=p.left;
         else p=p.right;
      }
      return (p!=null); 
   }
//Returns the number of integers in the collection 
   public int get_howmany() {return howmany;}

//Prints outs the integers in the collection 
   public void print()
   {
      printtree(c);
   }

//Checks to see if this collection has the same integers as another collection
//and no unique values 
   public boolean equals(Intcoll obj)
   {
      boolean result  = (howmany==obj.howmany);
      if (result)
      {
          int a[]= new int[howmany];
          int b[]= new int[howmany];
          int i=toarray(c,a,0);
          i=toarray(obj.c,b,0);
          int j=0;
          while(j<i && result)
          {
              if(a[j]!=b[j])
                  result=false;
              j++;
          }
      }
   
      return result;
   }

   private static void printtree(btNode t)
   {
      if (t!=null)
      {
          printtree(t.left);
          System.out.println(t.info);
          printtree(t.right);
      }
   }

   private static int toarray(btNode t, int[] a, int i)
   {
      int num_nodes=0;
      if (t!=null)
      {
         num_nodes=toarray(t.left, a, i);
         a[num_nodes+i]=t.info;   
         num_nodes=num_nodes+1+toarray(t.right, a, num_nodes+i+1);
      }
      return num_nodes;
   } 

   private static class btNode
   {
       int info; btNode left; btNode right;

       private btNode(int s, btNode lt, btNode rt)
       {
          info=s; left=lt; right=rt;  
       }

       private btNode()
       {
          info=0; left=null; right=null;
       }
   }
}
