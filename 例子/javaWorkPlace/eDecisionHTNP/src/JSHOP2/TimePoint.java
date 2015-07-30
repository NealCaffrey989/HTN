package JSHOP2;
/**
 * store all the time points of the task net;
 * @author Administrator
 *
 */
import java.util.Vector;

public class TimePoint  implements Cloneable 
{
		
	/** the number of the time points, which is relevant to the index of the task 
     */
	private TaskAtom task;
	
	/**the variable representing the start time point or the end time point of the
	 * task atom
	 */
    private boolean startOrEnd;
	
	/**the time point representing the start time of the planning process
	 */
	public static TimePoint referenceTimePoint = new TimePoint();
	
	/** the index for the hash code of the time point;
	 * 
	 */
	
    /**Construct a time point which represent the reference time 
     * of the planning process;
     * The index of time point is 0; 
     */
    public TimePoint() {
    	task=null;
    	startOrEnd=true;
    }

    public TimePoint(TaskAtom taskIn, boolean startOrEndIn) {
    	task=taskIn;
    	startOrEnd=startOrEndIn;
     }
    
    public TimePoint(TimePoint tpIn) {
    	task = tpIn.getTask();
    	startOrEnd = tpIn.getStartOrEnd();
    }

    /** whether the input time point is equal to this time point 
     * 
     * @param tpIn
     * @return
     */
    public boolean equals(Object obj)
    {
    	if(task != null)
    	{
        	if ((obj instanceof TimePoint)&&(task.equals(((TimePoint)obj).getTask()))
            	&&(startOrEnd == ((TimePoint)obj).getStartOrEnd()))
            	return true;
    	}
    	else
    	{
    		if((obj instanceof TimePoint)&&(task == ((TimePoint)obj).getTask())
    		   &&(startOrEnd == ((TimePoint)obj).getStartOrEnd()))
    		return true;
    	}
    	   return false;
    }
       
    /** replace the hash code;
     * 
     */
    public int hashCode()
    {
    	
    	int i;
    	//-- the task is real task atom
    	if(task != null)
    	{
    		if (startOrEnd ==true)
    			i = task.hashCode() + 1;
    		else 
    			i = task.hashCode() - 1;
    	}
    	//-- the time point is TR
    	else 
    	{
    		i = 0;
    	}
    	return i;  	
    	
    }

 
    /**get the task atom, which the time point representing 
     * 
     * @return
     *    the task atom
     */
    public TaskAtom getTask()
    {
    	return task;
    }
    
    public void setTask(TaskAtom tIn)
    {
    	task = tIn;
    }
    
   
    /**get the startOrEnd
     * 
     * @return
     */
    public boolean getStartOrEnd()
    {
    	return startOrEnd;
    }
       

    
	/** This function produces Java code to create this task point. 
	 * 
	 * @param what
	 *        the variable representing the time point;
	 * @return
	 *        a string of code;
	 */
	public String toCode() {
	
		String s;
		

		
		//-- if the task atom is reference time point;
		if(task == null)
		{
			s = "new\t" + "TimePoint ()";
			
		}
		//-- else it is a ordinary time point;
		else
		{
			s = "new\t" + "TimePoint (";
			s += task.toCode()+ "," + startOrEnd;
			s += ")" ;
		}

		
		return s;	
	}
    
}
