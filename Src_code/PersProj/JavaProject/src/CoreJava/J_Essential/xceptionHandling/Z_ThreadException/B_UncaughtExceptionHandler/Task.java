package CoreJava.J_Essential.xceptionHandling.Z_ThreadException.B_UncaughtExceptionHandler;

class Task implements Runnable
{
   @Override
   public void run() {
      System.out.println(Integer.parseInt("123"));
      System.out.println(Integer.parseInt("234"));
      System.out.println(Integer.parseInt("345"));
      System.out.println(Integer.parseInt("XYZ")); //This will cause NumberFormatException
      System.out.println(Integer.parseInt("456"));
   }
}