import java.util.*;
public class Longest_Increasing_Subsequence {
    static int m,max,res,max_end;
    static Scanner s=new Scanner(System.in);
     
    public static void main(String[] args) {
        List<Integer> list =new ArrayList<>();
        List<Integer> list2 =new ArrayList<>();
        List<Integer> list1=new ArrayList<>();
        int n;char c;boolean b;
     do{
        
        System.out.print("Total Number of elements that you want to add:");
        n=s.nextInt();
        
        while(n>100)
         {
            System.out.print("Please enter number under 100.:");
            n=s.nextInt();
         }
     
        addelements(list,n);
        Viewelements(list,n);
        m=0;
        m=lis1(list,n);
        System.out.println("Longest Increasing Length : " + m);
        
        for(int i=0;i<n-2;i++)
         {   
          max=list.get(i);
          max_end=list.get(i+1);

          if(i==0)
            list1.add(max);
            if(max < max_end)
            list1.add(max_end);
           
         }

        if(list1.get(list1.size()-2) < list.get(list.size()-1) )
         list1.add(list.get(list.size()-1));
       
        list2=new ArrayList<>(new TreeSet<>(list1));

        System.out.print("Longest Increasing ");
        Viewelements(list2,list2.size());
        
        System.out.print("\n\t Do you want to continue: ? Y/N ");
        c=s.next().charAt(0);
        list.clear();
        list1.clear();
        list2.clear();
    }while(c=='Y' || c=='y');
}
    private static int lis1(List<Integer> list, int n) {
        max=1;
        lis2(list,n);
        return max;
    }

    private static int lis2(List<Integer> list, int n) {
       
        if(n==1)
          return 1;
          max_end=1;
        for(int i=1;i<n;i++)
         {
            res=lis2(list,i) ;
            if(list.get(i-1) < list.get(n-1) && res+1 >max_end ){
                max_end=res+1;}
         }
         if (max < max_end)
            max=max_end;
        
        
       return max_end;
    }

    private static void Viewelements(List<Integer> list,int n) {
        Iterator<Integer> itr=list.iterator();
        m=0;
        System.out.print("Elements are: { ");
        while(itr.hasNext())
        {
            m++;
            if(m!=n)
                       System.out.print(itr.next() + ", ");
            else
                System.out.print(itr.next());
        }
        System.out.println("}");
    }

    private static void addelements(List<Integer> list,int n) {
        System.out.println("Please Enter Elements:");
        for(int i=0;i<n;i++)
        {
            System.out.print((i+1) + ":");
            list.add(s.nextInt());
        }
    }
}