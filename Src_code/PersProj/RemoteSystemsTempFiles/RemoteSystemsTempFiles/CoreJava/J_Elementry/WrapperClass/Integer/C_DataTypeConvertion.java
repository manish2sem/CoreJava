package CoreJava.J_Elementry.WrapperClass.Integer;

/**
 * Convert Integer to other datatype using casting.
 * @author sinhama
 *
 */
public class C_DataTypeConvertion {
	
	public static void main(String[] args) {
        
        Integer intData = 1000;
        
        byte byteData = intData.byteValue();
        short shortData = intData.shortValue();
        Integer inttegerData = intData.intValue();
        long longData = intData.longValue();
        float floatData = intData.floatValue();        
        double doubleData = intData.doubleValue();        
        String strData = intData.toString();
        
        System.out.println("byteData is : " +byteData );
        System.out.println("shortData is : " +shortData );
        System.out.println("inttegerData is : " + inttegerData);
        System.out.println("longData is : " + longData);
        System.out.println("floatData is : " + floatData);
        System.out.println("doubleData is : " + doubleData);  
        System.out.println("strData is : " + strData);          
    }
}

/**
 * 
 *  public byte byteValue() 
    {
		return (byte)value;
    }
    
 *
 *  public String toString() 
 *  {
		return String.valueOf(value);
    }
 *
 */
