import java.util.Random;

public class Main {
      public static void main(String[] args) {
          int opt=100000;
         LoopQueue<Integer> queue =new LoopQueue<>();
          System.out.println(testQueue(queue, opt));
          ArrayQueue<Integer> queue1=new ArrayQueue<>();
          System.out.println(testQueue(queue1, opt));
      }
      private static double testQueue(Queue<Integer> q,int optCount){
          long startTime=System.nanoTime();
          Random random=new Random();
          for (int i = 0; i < optCount; i++) {
              q.enqueue(random.nextInt(Integer.MAX_VALUE));
          }
          for (int i = 0; i < optCount; i++) {
              q.dequeue();
          }
          long endTime=System.nanoTime();
          return (endTime-startTime)/1000000000.0;
      }
}
