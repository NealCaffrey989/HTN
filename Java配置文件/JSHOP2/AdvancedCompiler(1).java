package JSHOP2;
import javax.tools.*;
import JSHOP2.*;

import java.lang.reflect.Method;
import java.util.Arrays;
//自定义类，非jshop2类
public class AdvancedCompiler 
{
   public static void complie(String code,String name ) throws Exception{

     // Steps used to compile Calculator
     // Steps used to compile StringObject

     // construct CalculatorTest in memory
     JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();     
     StandardJavaFileManager fileManager  =
           compiler.getStandardFileManager(null, null, null);
         JavaFileObject file = constructTestor(code,name);
         Iterable<? extends JavaFileObject> files = Arrays.asList(file);

         JavaCompiler.CompilationTask task = compiler.getTask (
                 null, fileManager, null, null, null, files);

         Boolean result = task.call();
         if( result == true ) {
        	//Class clazz=Class.forName("math.CalculatorTest");
     		//Object obj = clazz.newInstance();
     		//Method method = clazz.getMethod("testMultiply", new Class[0]);
     		//method.invoke(obj);
           System.out.println(name+" Succeeded");
         }
   }
   
   
  private static SimpleJavaFileObject constructTestor(String code,String name) {
     StringObject so = null;
      try {
        so = new StringObject(name, code);
      } catch(Exception exception) {
        exception.printStackTrace();
      }
      return so;
    }
 }