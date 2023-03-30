package com.halodoc.interview;
/*

Tesco has around 3200 stores and more than 10% of the stores have around 800 colleagues each.

In a store, a colleague can work for multiple departments. Here are shifts of a colleague in various departments:

In Bakery department: From 8 to 10
In Checkout department: From 10 to 12
In Diary department: From 14 to 19

 Given the above split of shifts, provide an API/method to return the different shifts of a colleague
  for the day after merging shifts. This will be exposed to the colleague in different UI
   and help them plan their day accordingly.

His shift timings in this case are 8 to 12 and 14 to 19.


 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FixShifting {

    public  List<Interval> mergeShifts(Interval arr[] ) {
/*
        Arrays.sort(arr, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
return o1.start - o2.start ;         }
        }); //o(nlogn)
*/
        if (arr.length ==0) {
            return null;
        }
            Stack<Interval> st = new Stack<>();
            st.push(arr[0]);

            for (int i = 1; i < arr.length; i++) { //O(n)

                Interval top = st.peek();

                if (top.end < arr[i].start) {
                    st.push(arr[i]);
                } else if (top.end < arr[i].end) {
                    top.end = arr[i].end;
                    st.pop();
                    st.push(top);
                }
            }
            List<Interval> output = new ArrayList<>();
            while (!st.isEmpty()) { //O(k)


                output.add(st.pop());
           /* Interval current = ;
            System.out.println(current.start +"," + current.end);*/
            }
            return output;
        }
    //time complexity = o(nlogn)+o(n) +O(k) = o(nlogn)



    public static void main(String[] args) {
//{1, 9}, {2, 5}, {19, 20}, {10, 11}, {12, 20}, {0, 3}, {0, 1}, {0, 2}
        Interval arr[] = new Interval[8];
        arr[0]= new Interval(1,9);
        arr[1]= new Interval(2,5);
        arr[2]= new Interval(19,20);
        arr[3]= new Interval(10,11);
        arr[4]= new Interval(12,20);
        arr[5]= new Interval(0,3);
        arr[6]= new Interval(0,1);
        arr[7]= new Interval(0,2);

      //  mergeShifts(arr);
    }
}
/*
arr[0] = start- 1 end -9

 */
class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
