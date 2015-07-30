package JSHOP2;

import java.util.Vector;

public class TimeConstraint
{
	/**the first time point variable;
     * the second time point variable;
	 * The index of pre time point is j, and the index of post time point
	 * Usually, we defined 1<=i<j<=|X|; 
	 */
	private TimePoint pre;
	
	private TimePoint post;
		
	/**pre-post=t[j]-t[i]<=max
	 */
	private double max;
	
	/**min<=pre=post=t[j]-t[i]
	 */
	private double min;
	
	/** create a null time constraint;
	 * 
	 */
	public TimeConstraint()
	{
		
	}
		
	/** @param 
	 *          pre
	 *  @param 
	 *          post
	 *  @param 
	 *          max
	 */
	public TimeConstraint(TimePoint pre, TimePoint post, double min, double max) 
	{
	    this.pre = pre;
	    this.post = post;
	    this.min= min;
	    this.max = max;
	}

	public TimePoint getPrePoint() {
	    return pre;
	}

	public TimePoint getPostPoint() {
	    return post;
	}
	
	public void setPrePoint(TimePoint tp)
	{
		pre = tp;
	}
	
	public void setPostPoint (TimePoint tp)
	{
		post = tp;
	}

	public double getMax() {
	    return max;
	}
	
	public void setMax(double maxIn) {
		max=maxIn;
	}

	public double getMin(){
		return min;
	}
	
	public void setMin(double minIn) {
		min=minIn;
	}
	
	public String toString() {
	    return "TimeConstraint[" + pre + post + "]";
	}
	
	/** This function produces Java code to create this time constraint.
	 * 
	 * @param what
	 *        the variable representing the time constraint
	 * @return
	 *        a string of code;
	 */
	public String toCode() {
	
		String s;
		
		s = "new\t" + "TimeConstraint(";
		
		s += pre.toCode() + ",";
		
		s += post.toCode() + ",";
		
		s += min + "," + max + ")";
		
		return s;	
	}
	
	
	/** This function produces Java code to create a list of time constraint 
	 * 
	 * @return
	 */
	public static String tclToCode(Vector<TimeConstraint> tclIn, String retVal)
	{
		String s;
		s = "";
		
		for(int i=0;i<tclIn.size();i++)
		{
			s += "\t\t" + retVal + ".add" ;
			s += "(" + tclIn.get(i).toCode() + ");";
			s += "\r\n";			
		}
		
		return s;
	}

    

}
