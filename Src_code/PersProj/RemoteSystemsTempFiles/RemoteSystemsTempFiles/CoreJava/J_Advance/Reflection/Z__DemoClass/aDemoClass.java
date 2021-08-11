package CoreJava.J_Advance.Reflection.Z__DemoClass;


public class aDemoClass {
    public String demoMethod(String demoParam) {
        System.out.println("Parameter passed: " + demoParam);
         
        return DemoClass.class.getName();
    }
}