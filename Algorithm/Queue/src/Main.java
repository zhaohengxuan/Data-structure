public class Main {
      public static void main(String[] args) {
         ArrayQueue<Integer> queue =new ArrayQueue<>(20);
          for (int i = 0; i < 10; i++) {
              queue.enqueue(i);
              System.out.println(queue);
              if(i%3==2){
                  queue.dequeue();
                  System.out.println(queue);
              }
          }
          System.out.println(queue);
          //queue.dequeue();
          System.out.println(queue.getSize());
          System.out.println(queue);
          System.out.println(queue.isEmpty());
          System.out.println(queue.getSize());
          queue.dequeue();
          System.out.println(queue.getFront());
          System.out.println(queue);
          System.out.println(queue.getSize());
          System.out.println(queue.getCapacity());
      }
}
