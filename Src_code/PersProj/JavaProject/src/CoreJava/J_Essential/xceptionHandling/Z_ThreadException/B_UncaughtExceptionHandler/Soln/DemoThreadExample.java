package CoreJava.J_Essential.xceptionHandling.Z_ThreadException.B_UncaughtExceptionHandler.Soln;

public class DemoThreadExample
{
   public static void main(String[] args) {
      Task task = new Task();
      Thread thread = new Thread(task);
      thread.start();
   }
}
