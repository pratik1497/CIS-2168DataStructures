
package sort;

import java.util.Scanner;


/**
 *
 * @author pratik patel
 */
public class SortTest {
   public static void main(String[] args) {
    Scanner keyboard=new Scanner(System.in);
    System.out.print("How many runs of each sort do you want: ");
    int k=keyboard.nextInt();
    System.out.format("\n\nInsertion Sort\n  Size\t\tMin\t\t Max\t\tAverage");
    for(int i=1;i<=8;i=i*2)
    {
       insertionTable(k,2048*i);
    }
    System.out.format("\n\nMerge Sort\n  Size\t\tMin\t\t Max\t\tAverage");
    for(int i=1;i<=8;i=i*2)
    {
     mergeTable(k,2048*i);
    }
    System.out.format("\n\nQuick Sort\n  Size\t\tMin\t\t Max\t\tAverage");
    for(int i=1;i<=8;i=i*2)
    {
     quickTable(k,2048*i);
    }
    System.out.println("");   
   }
   public static void insertionTable(int k,int size)
   {
       int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE,i;
       Sort test=new Sort();
       double average=0.0;
       
       for(i=0;i<k;i++)
       {
          int hold=test.InsertionSortTest(size);
          if(hold<min)
              min=hold;
          if(hold>max)
              max=hold;
          average=average+hold;
       }
       average=average/k;
       System.out.format("\n%,7d%,15d %,15d\t%,15.2f",size,min,max,average);
       
   }
   
   public static void mergeTable(int k,int size)
   {
       int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE,i;
       Sort test=new Sort();
       double average=0.0;
       
       for(i=0;i<k;i++)
       {
          int hold=test.MergeSortTest(size);
          if(hold<min)
              min=hold;
          if(hold>max)
              max=hold;
          average=average+hold;
       }
       average=average/k;
       System.out.format("\n%,7d%,15d %,15d\t%,15.2f",size,min,max,average);
       
   }
   public static void quickTable(int k,int size)
   {
       int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE,i;
       Sort test=new Sort();
       double average=0.0;
       
       for(i=0;i<k;i++)
       {
          int hold=test.QuickSortTest(size);
          if(hold<min)
              min=hold;
          if(hold>max)
              max=hold;
          average=average+hold;
       }
       average=average/k;
       System.out.format("\n%,7d%,15d %,15d\t%,15.2f",size,min,max,average);
       
   }
   
    
}
