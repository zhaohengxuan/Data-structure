package com.company.algorithm;


public class Main {
      public static void main(String[] args) {
          Array<Integer> array=new Array();
          for (int i = 0; i <10 ; i++) {
              array.addFirst(i);
          }
          System.out.println(array);
            array.addFirst(10);
            array.addFirst(11);
          System.out.println(array);
          array.remove(1);
          array.remove(2);
          System.out.println(array);
          array.remove(1);
          System.out.println(array);

      }
}

