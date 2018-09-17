
package sort;

import java.util.Random;

/**
 *
 * @author pratik patel
 */
public class Sort {
static int qcount=0;
static int mcount=0;
static int icount=0;
  public void insertionSort(int[] a,int b,int c)
  {
      int i,j,hold;
      boolean result;
      for(i=b;i<=c;i++)
      {
          j=i;
          hold=a[i];
          result=true;
          while(j>0 && result)
          {
            icount++;   
            if(a[j-1]>hold)
            {
             a[j]=a[j-1];
             j--;  
            }
            else
                result=false;      
          }
          a[j]=hold;
      }
      
  }
  public int InsertionSortTest(int size)
  {
      int count;
      int a[]=new int[size];
      Random gen=new Random();
      
      for(int i=0;i<a.length;i++)
        a[i]=gen.nextInt(100)+1;
      insertionSort(a,1,a.length-1);
      count=icount;
      icount=0;
      return count;
  }
  public int MergeSortTest(int size)
  {
    int count;
    int a[]=new int[size];
    Random gen=new Random();
    for(int i=0;i<a.length;i++)
      a[i]=gen.nextInt(100)+1;
     
    mergesort(a,0,a.length-1);
    count=mcount;
    mcount=0;
    return count;
  }
  public void mergesort(int[] a, int top, int bottom)
   { 	  
      if (top!=bottom)
      {
         int middle=(top+bottom)/2;
         mergesort(a, top, middle);
         mergesort(a, middle+1, bottom);
         merge(a, top, bottom);
      }
    
   }

  public void merge(int[] a, int top, int bottom)
   {
      int t=top; int middle=(top+bottom)/2; int b=middle+1; int i=0;
      int[] s=new int[bottom-top+1];
      while ((t<=middle)&&(b<=bottom))
      {
         if (a[t]<a[b])
         {
            s[i]=a[t]; t++;
         }
         else
         {
            s[i]=a[b]; b++;
         }
         i++;mcount++;
      }
      int last=middle;
      if (b<=bottom) {t=b; last=bottom;}
      while (t<=last)
      {
         s[i]=a[t]; t++; i++; mcount++;
      }
      for (i=0; i<s.length; i++) {a[i+top]=s[i]; mcount++;}
     
   }
  public int QuickSortTest(int size)
  {
      int count;
      int a[]=new int[size];
      Random gen=new Random();
      for(int i=0;i<a.length;i++)
         a[i]=gen.nextInt(100)+1;     
     quicksort(a,0,a.length-1);
     count=qcount;
     count=count-2;
     qcount=0;
      return count;
  }
  public void quicksort(int[] a, int i, int j)
  {
     int p;
     if(i<j)
     {
         p=partition(a,i,j);
         quicksort(a,i,p-1);
         quicksort(a,p+1,j);
     }
  }
  public int partition (int[] a, int i, int j)
  {
    int upper, lower, save;
    boolean b,c;
    upper = i; lower = j; save=a[i];
    while(upper != lower)
   {
    b=true;c=true;  
    while((upper < lower) && b)
    {
      
    if(save <= a[lower])
       {
         lower--;qcount++;
       }
    else
        {
           b=false;qcount++;
        }
    }           
    if(upper != lower) 
        a[upper]=a[lower];
    while((upper < lower) && c)
    {
      
      if(save >=a[upper])
      {
            upper++;qcount++;
      }
      else
      {
          c=false;qcount++;
      }
    }
    if(upper != lower) 
        a[lower]=a[upper];
  
   }
   a[upper]=save;
   return(upper);
 }

}
