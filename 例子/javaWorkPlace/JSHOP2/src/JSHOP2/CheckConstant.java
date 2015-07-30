package JSHOP2;

import java.util.ArrayList;

public class CheckConstant {
	boolean VarisResource(String var)
	{
		return true;
	}
	
	ArrayList HeadhasVar(String var)
	{
		ArrayList result=new ArrayList();
		for(String varhead :InfoStore.VarInstance.VarInstance.getVarMap().keySet())
		{
			String[] vars=InfoStore.VarInstance.VarInstance.getVarMap().get(varhead);
			for(String v :vars){
				if(v==var){
					result.add(varhead);
					break;
				}
			}
		}
		return result;
	}
	
}
