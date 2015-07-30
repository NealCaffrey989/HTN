package JSHOP2;

 import java.io.IOException;
import java.net.URI;

import javax.tools.SimpleJavaFileObject;
//自定义类，非jshop2类
public class StringObject extends SimpleJavaFileObject{
     private String contents = null;
     public StringObject(String className, String contents) throws Exception{
         super(new URI(className), Kind.SOURCE);
         this.contents = contents;
     }

     public CharSequence getCharContent(boolean ignoreEncodingErrors) 
             throws IOException {
         return contents;
     }
}

 class Calculator {
    public int multiply(int multiplicand, int multiplier) {
         return multiplicand * multiplier;
     }
 }