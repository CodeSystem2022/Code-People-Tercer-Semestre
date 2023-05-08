
package test;

public class TestAutoboxingUnboxing {
    public static void main(String[] args) {
        //Clases envolventes o Wrapper
        /*
             Clases envolventes de tipos  primitivos
             int = la clase envolvente es Integer
             long = la clase envolvente es Double
             boolean = la clase envolvente es Boolean
             bye = la clase envolvente es Byte
             char = la clase envolvente es Character
             short = la clase envolvente es Short
        */
        
         int enteroPrim = 10; //Tipo primitivo
         System.out.println("enteroPrim = " + enteroPrim);
         Integer entero = 10; //Tipo object en la clase integer
         System.out.println("entero = " + entero.doubleValue()); //Autoboxing
    
         int entero2 = entero; //Unboxing
         System.out.println("entero2 = " + entero2);
    
    }
}
