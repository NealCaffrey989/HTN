package JSHOP2;

import java.util.*;

public class InfoStore {
	private Vector<String> compoundTasks;
	
	private Vector<String> constants;
	
	private Vector<String> primitiveTasks;
	
	private Hashtable<String,String[]> varmap;
	
	public static InfoStore DomainInstance;
	
	public static InfoStore VarInstance;
	
	public static void putdomaininfo(Vector<String> compoundTasks,Vector<String> constants,Vector<String> primitiveTasks)
	{
		DomainInstance=new InfoStore();
		DomainInstance.setCompoundTasks(compoundTasks);
		DomainInstance.setConstants(constants);
		DomainInstance.setPrimitiveTasks(primitiveTasks);
	}
	
	public static void putvarinfo(String varhead,String[] vars)
	{
		if(VarInstance==null)
			VarInstance=new InfoStore();
		if(VarInstance.varmap==null)
			VarInstance.varmap=new Hashtable<String,String[]>();
		//if(!varname.startsWith("VAR"))
			//return;
		if(VarInstance.varmap.containsKey(varhead)){
			if(!VarInstance.getvars(varhead).equals(VarInstance.getString(vars))){
				//System.out.println("------------------------------");
				//System.out.println("varhead:"+varhead+";oldvars:"+VarInstance.getvars(varhead)
					//	+";newvars:"+VarInstance.getString(vars));
				VarInstance.varmap.remove(varhead);
			}
		}
		VarInstance.varmap.put(varhead,vars);
	}
	
	public String getvars(String varhead)
	{
		if(VarInstance==null||VarInstance.varmap==null)
			return null;
		if(VarInstance.varmap.containsKey(varhead)){
			String[] vars=VarInstance.varmap.get(varhead);
			return getString(vars);
		}
		else{
			System.out.println(varhead+ "can not found!");
			return null;
		}
	}

	public String getString(String[] strs)
	{
		String result="";
		for(String s :strs)
			result=result+s+" ";
		result=result.substring(0, result.length()-2);
		return result;
	}

	public String VarMaptoString()
	{
		StringBuilder sb=new StringBuilder();
		for(String varhead :VarInstance.VarInstance.varmap.keySet())
		{
			sb.append(varhead+";"+VarInstance.getString(VarInstance.varmap.get(varhead))+"\n");
		}
		return sb.toString();
	}
		
	public void setCompoundTasks(Vector<String> compoundTasks) {
		this.compoundTasks = compoundTasks;
	}

	public Vector<String> getCompoundTasks() {
		return compoundTasks;
	}

	public void setConstants(Vector<String> constants) {
		this.constants = constants;
	}

	public Vector<String> getConstants() {
		return constants;
	}

	public void setPrimitiveTasks(Vector<String> primitiveTasks) {
		this.primitiveTasks = primitiveTasks;
	}

	Hashtable<String,String[]> getVarMap()
	{
		return varmap;
	}
	
	public Vector<String> getPrimitiveTasks() {
		return primitiveTasks;
	}




}
