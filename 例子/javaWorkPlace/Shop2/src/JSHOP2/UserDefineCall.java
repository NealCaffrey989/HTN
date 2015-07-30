package JSHOP2;

import JSHOP2.*;
public class UserDefineCall {
	public static Max max = new Max();
	public static Min min = new Min();
}

class Max implements Calculate
{
  /**自定义，求输入最大值.
  */ 
  public Term call(List l)      
  {
    double res = ((TermNumber)l.getHead()).getNumber();
    l = l.getRest();

    while (l != null)
    {
      if(res < ((TermNumber)l.getHead()).getNumber())
    	res = ((TermNumber)l.getHead()).getNumber();
      l = l.getRest();
    }

    return new TermNumber(res);
  }
}

class Min implements Calculate
{
  /**自定义，求输入最大值.
  */ 
  public Term call(List l)      
  {
    double res = ((TermNumber)l.getHead()).getNumber();
    l = l.getRest();

    while (l != null)
    {
      if(res > ((TermNumber)l.getHead()).getNumber())
    	res = ((TermNumber)l.getHead()).getNumber();
      l = l.getRest();
    }

    return new TermNumber(res);
  }
}
