
package JSHOP2;

import java.util.LinkedList;
import java.util.Vector;
import java.util.Hashtable;
import java.util.Iterator;

/**The time constraint list encode the time constraint of the subtasks of the task network
 * the time constraint is sorted according to the index of the task in the subtasks;
 *  
 * @author Tang Pan
 *
 */
  class Element
  {    
	    /** the index of tpi is i, and the index of tpj is j;
	     *  We defined that i<j
	     */
	    int i; 
        int k;
        int j;
  
       /** initialize the Element;
        * 
        * @param iIn

        * @param kIn
        * 
        * @param jIn
        * 
        */
        public Element (int iIn, int kIn, int jIn)
        {
	      i = iIn;
	      k = kIn;
	      j = jIn;
        }
   }
  
  class TimeConstraintandValues 
  {
	  TimeConstraint tc;
	  double first;
	  double second;
	  
	  public TimeConstraintandValues (TimeConstraint tcIn, double firstIn, double secondIn)
	  {
		  tc = tcIn;
		  first = firstIn;
		  second = secondIn;
	  }
	  
  }
  
  class HalfTimeConstraint
  {
	  TimePoint pre;
	  TimePoint post;
	  double value;
	  
	  public HalfTimeConstraint(TimePoint pre, TimePoint post, double value)
	  {
		  this.pre = pre;
		  this.post = post;
		  this.value = value;
	  }  
  }
  
  class TimeConstraintList
  {
	  /** the time point;
	   */
	  TimePoint tp;
	  
	  /** the time constraint list, the post time point of it is this time point
	   */
	  Vector<HalfTimeConstraint> postTimeCons;

	  
	  /** initialize the time constraint list defined on this time point
	   */
	  public TimeConstraintList(TimePoint tp)
	  {
		  this.tp = tp;
		  
		  postTimeCons = new Vector<HalfTimeConstraint>();
	  }	  
	  
  }

public class TimePointNet {
	
	/**the number of the time point variable; the first variable of it is TR, which is the
	 * reference time of the plan process; the rest time variable is sorted  according to 
	 * the sequence of the subtasks;
	 */
	private int numberOfPoints;
	
	//-- a set of the time point of the task atom
	private Vector<TimePoint> knownPoints = new Vector<TimePoint>();
	
	//-- the set of the time constraints defined on these time points
	private Vector<TimeConstraintList> tcSet = new Vector<TimeConstraintList>();
	
	/** Constructs an empty time point network
	 * the time point net contain only a time point representing the start time of the 
	 * planning process; 
     */
    public TimePointNet() {
    	//--create a time point representing the start time of planning process
    	TimePoint tp = new TimePoint();

    	//-- add the time point to the head of time points set;
    	addTimePoint(tp, 0);
    	numberOfPoints = 1;
    	 
    	
    }	
    
    
    public Vector<TimeConstraintList> getTimeConstraintMatrix()
    {
    	return tcSet;
    }
    
    public void setTimeConstraintMatrix(Vector<TimeConstraintList> tcSetIn)
    {
    	tcSet = tcSetIn;
    }
    
    /**get the number of the time point
     * 
     * @return
     */
    public int getNumberOfPoints()
    {
    	return numberOfPoints;
    }
 
    public Vector<TimePoint> getKnownPoints ()
    {
    	return knownPoints;
    }
    
    /**Add a time point to the simple time network
     * the time point is the key of the hash map, and the value is a boolean value;
     * 
     * @param  tpIn    
     *         the time point to be added
     * @param  index
     *         the position to insert the time point for the knownPoints, tcSet;
     *        
     * @return
     *         <true>
     *          the time point set doesn't contain the time point; 
     *         <false>
     *         the time point set contains the time point;
     */    
    public boolean addTimePoint(TimePoint tpIn, int index) 
    {	
    	//-- if the time point set does not contain the given time point tpIn
        if(!(knownPoints.contains(tpIn)))
        {
        	if (index <= knownPoints.size())
        	   knownPoints.add(index, tpIn);
        	
        	numberOfPoints += 1;
        	
        	HalfTimeConstraint preTc, postTc; 
        	TimePoint tpIndexPre, tpIndexPost;
        	
        	//-- create the time constraint list coding the time constraint associate to it;
        	TimeConstraintList tlPost = new TimeConstraintList(tpIn);
        	//-- add the time constraint list to the specified position;
        	tcSet.add(index, tlPost);
        	
        	//-- add the time constraint to the time constraint matrix for this time point; 
        	for(int i=0; i<numberOfPoints; i++)
        	{
        		//-- create the half time constraint;
        		tpIndexPre = knownPoints.get(i);
        		if (tpIndexPre.equals(tpIn))
        			postTc = new HalfTimeConstraint(tpIndexPre,tpIn, 0);
        		else
        			postTc = new HalfTimeConstraint(tpIndexPre, tpIn, Double.MAX_VALUE);  
        		
        		//-- add the time constraint (tpIndexPre - tpIn < max) for the time point tpIn in the
        		//-- specified position;
        		tlPost.postTimeCons.add(i, postTc);               
        	}

        	
        	//-- add the time constraint to the time constraint matrix for this time point;
        	for(int j=0; j<numberOfPoints; j++)
        	{
        		tpIndexPost = knownPoints.get(j);
        		
        		//-- for each time point in the time point list except the tpIn;
        		if(!(tpIndexPost.equals(tpIn)))
        		{
            	   preTc = new HalfTimeConstraint(tpIn, tpIndexPost, Double.MAX_VALUE);
            		
            	   //-- add the half time constraint for the time point tpIn;
          		   for(int m=0; m<tcSet.size();m++)
        		   {          			   
        			   if (tcSet.get(m).tp.equals(tpIndexPost))
        				  //-- add the half time constraint to the specified position of the half time constraint list 
        			 	  tcSet.get(m).postTimeCons.add(index, preTc);
        		   }
        		}
        	}
            return true;
        }//-- if
        //-- else if the time point set contain the given time point tpIn
        else 
        	return false;
	}

    
    /**delete a time point from the simple time network 
     * @param t
     *          the time point to be added;
     * @return
     *       <true>
     *             if the time point set contains the given time point, and it is deleted successfully;
     *       <false>
     *             else
     */ 
    public boolean deleteTimePoint(TimePoint tpIn) 
    {    	
		//-- remove the time point from the time point set;
    	if(knownPoints.remove(tpIn))
    	{	
    		//-- remove the time constraint list for tpIn
    		for(int i = 0; i< tcSet.size(); i++)
    		{
    			if (tcSet.get(i).tp.equals(tpIn))
    				tcSet.remove(i);    			    
    		}
    
    		TimeConstraintList tl;
    		Vector<HalfTimeConstraint> postCons;
    		
    		for(int m=0; m<tcSet.size(); m++)
    		{
    			tl = tcSet.get(m);
    			if(!(tl.tp.equals(tpIn)))
    			{
    				postCons = tl.postTimeCons;
    				for(int n=0; n<postCons.size();n++)
    				{
    					if (postCons.get(n).pre.equals(tpIn))
    						postCons.remove(n);
    				}
    			}
    		}

    		//-- the number of the time point is decreased by one;
        	-- numberOfPoints;
        	return true;    		
    	}
    	else 
    		return false;
    }
        

    /**add a time constraint to the simple time network;
     * Given that the time points of the time constraint is added to the simple time net already. 
     * If the simple time net is consistent, add the time constraint;
     * else, add the 
     * 
     * @param tcIn
     *        the time constraint to be added;
     * @return
     *        <true>
     *         the time constraint can be added, and the stn is consistent;
     *         first stores the value (pre - post < value);
     *         second stores the value (post - pre < value);
     */
    public boolean addTimeConstraint(TimeConstraint tcIn, double[] value) 
    {
    	//-- add the time constraint to the time point net
    	TimePoint pre, post;
    	double min, max;
    	
    	//-- get the pre and post time point of the time constraint
    	pre = tcIn.getPrePoint();
    	post = tcIn.getPostPoint();
    	min = tcIn.getMin();
    	max = tcIn.getMax();
    	
	    //-- get the index of the pre and post time points in the time point list for the task net;
	    int iIndex,jIndex;
	    iIndex = knownPoints.indexOf(post);
	    jIndex = knownPoints.indexOf(pre);

	    //-- keep the index of pre time point is more than the index of post time point; 
	    //-- change the time constaint
	    if (iIndex >= jIndex)
	    {
	    	tcIn.setPostPoint(pre);
	    	tcIn.setPrePoint(post);
	    	tcIn.setMin((0 - max));
	    	tcIn.setMax((0- min));
	    }
	    
	    //-- use this data structure to store the beforehand time constraint matrix;
	    double[][] tcMatrix;
	    tcMatrix = new double[numberOfPoints][numberOfPoints];
        getTcMatrix(tcMatrix);
	    
    	//-- refresh the time constraint to the time constraint list for the post time point
    	//-- used to undo the change
	    double left, right;
	    left = 0 - Double.MAX_VALUE;  right = Double.MAX_VALUE;
    	
    	Vector<HalfTimeConstraint> postTcs;
    	
    	for(int i=0; i<tcSet.size();i++)
    	{
    		if(tcSet.get(i).tp.equals(tcIn.getPostPoint()))
    		{
    			postTcs = tcSet.get(i).postTimeCons;
    			for(int j=0; j< postTcs.size(); j++)
    			{
    				//-- find the time constraint ( pre - post < value )
    				if(postTcs.get(j).pre.equals(tcIn.getPrePoint()))
    				{
    					//-- record the value of the first time constraint;
    					value[0] = postTcs.get(j).value;

    					//-- refresh max value of the time constraint by the less value
    					if (postTcs.get(j).value > tcIn.getMax())
    					{
    						right = tcIn.getMax();
    						postTcs.get(j).value = tcIn.getMax();
    					}
    					else
    						//-- the value is not changed;
    						right = postTcs.get(j).value;
    					break;
    				}
    			}

    		    break;
    		}
    	}
    	
    	//-- refresh the time constraint to the time constraint list for the pre time point
   	
    	Vector<HalfTimeConstraint> preTcs;
    	
    	for(int m=0; m<tcSet.size(); m++)
    	{
    		if(tcSet.get(m).tp.equals(tcIn.getPrePoint()))
    		{
    			preTcs = tcSet.get(m).postTimeCons;
    			for(int n=0; n< preTcs.size();n++)
    			{
    				//-- find the ( post - pre < value)
    				if(preTcs.get(n).pre.equals(tcIn.getPostPoint()))
    				{				
    					//-- record the second time constraint 
    					value[1] = preTcs.get(n).value;
    					
    					//-- refresh min value of the second time constraint by the bigger value
    					if ((0 - preTcs.get(n).value) < tcIn.getMin())
    					{
    						left = tcIn.getMin(); 
    						preTcs.get(n).value = 0 - left;
    					}
    					else 
    						left = 0- preTcs.get(n).value;   						
    					//-- the value is not changed;
    					break;
    				}
    			}
    			break;
    		}
    	}
    	 
    	//-- add the time constraint;
    	tcIn.setMin(left);
    	tcIn.setMax(right);
    	
    	//-- if the added time constraint is invalid, the time constraint cannot be added
    	if (left > right)
    	{
    		//-- undo the change for the added time constraint;
    		//-- the first and second store the min and max value, which are changed,
    		deleteTimeConstraint(tcIn, value);
    		return false;
    	}
    	
        //-- if the time constraint is consistent with the current simple time net, and 
    	//-- the time constraint is refreshed;
        if (propagateAfterAdding(tcIn))           	
        	return true;
        
        //-- delete the added time constraint, and refresh to the matrix before it is revised;
        else 
        {
        	//--  refresh the stored time constraint matrix;
        	setTcMatrix(tcMatrix);
        	
            return false;	
        }
    }
    
    /**add a set of time constraints to the current simple time net 
     *
     * @param
     *       tcsIn
     *         the time constraint to be added to the task net;         
     * @return
     *        <true>
     *             if the time constraint can be added to the simple time net, and it is consistent;
     *        <false>
     *             else,
     */
    public boolean addTimeConstraintSet(Vector<TimeConstraint> tcsIn, Vector delAdd )
    {
    	TimeConstraint tc;

    	    	
    	if (tcsIn != null)
    	{
        	for(int i=0;i<tcsIn.size();i++)
        	{
        		tc=tcsIn.get(i);
        		
            	double[] value;
        		value = new double[2];
        		//--once a time constraint cann't be added to the time piont net 
        		if(addTimeConstraint(tc, value))
        		   delAdd.add(new TimeConstraintandValues(tc, value[0], value[1]));
        		else
        			return false;
        	}	
    	}

    	return true;
    }
    

    
    
    
    /** Removes the constraint from its pre- and post-points and given the values for first and second to
     * the deleted time constraint; 
     */
    public void deleteTimeConstraint(TimeConstraint tcIn, double value[])
    {
        Vector<HalfTimeConstraint> tcListofPre = new  Vector<HalfTimeConstraint>();
        Vector<HalfTimeConstraint> tcListofPost = new  Vector<HalfTimeConstraint>();
                
        TimePoint pre;
        TimePoint post;
        
    	pre = tcIn.getPrePoint();
    	post = tcIn.getPostPoint();
    	
    	//-- get the time constraint list for pre time point and post time point;
    	for(int i=0; i<tcSet.size();i++)
    	{
    		if(tcSet.get(i).tp.equals(pre))
    			tcListofPre = tcSet.get(i).postTimeCons;
    		if(tcSet.get(i).tp.equals(post))
    			tcListofPost = tcSet.get(i).postTimeCons;
    	}
    	
    	HalfTimeConstraint tc;
    	
    	if (tcListofPost.size()!= 0)
    	{
    		for(int m=0; m<tcListofPost.size(); m++)
    		{
    			tc = tcListofPost.get(m);
    			if (tc.pre.equals(pre))
        			tc.value= value[0];
    		}
    	}
    			
       if (tcListofPre.size() != 0)   			
       {
    	   for(int n =0; n<tcListofPre.size();n++)
    	   {
    		   tc = tcListofPre.get(n);
    		   if(tc.pre.equals(post))
    			   tc.value = value[1];
    	   }
       }
    }  
    
 	
	/**
	 * compute the new time constraint
	 * r[i][j]=(a[i][j],b[i][j])
	 * b[i][j]=d[i][j];
	 * a[i][j]=-d[j][i];
	 * @param 
	 *        
	 * @return 
	 *        <true>
	 *             if the r[i][j] is revised, and change the time constraint matrix;
	 *        <false>
	 *             if the r[i][j] is not revised;
	 *             
	 *        r[i,j]=r[i,j]^(r[i,k].r[k,j])
	 */
	public int revise (Element e)
	{
		int i,k,j;
		i=e.i;
		k=e.k;
		j=e.j;
		
		//--compute the result of r[i,k].r[k,j]=(t1,t2)
		//--get the time constraint tc[i,k] and tc[k,j]
		TimePoint tpi,tpk,tpj;
		TimeConstraint ikTc, kjTc;
		
		tpi = knownPoints.get(i);
		tpk = knownPoints.get(k);
		tpj = knownPoints.get(j);
		
		ikTc = getTimeConstraint(tpi,tpk);
		kjTc = getTimeConstraint(tpk,tpj);
		
		double t1,t2;
		
		t1=ikTc.getMin() + kjTc.getMin();
		t2=ikTc.getMax() + kjTc.getMax();	
		
		//--compute the result of r[i,j]^(r[i,k].r[k,j])
		double maxLeft;
		double minRight;		
		
		TimeConstraint ijTc;
		ijTc = getTimeConstraint(tpi,tpj);

		if (ijTc.getMin() > t1)
		    maxLeft = ijTc.getMin();
	    else 
		    maxLeft = t1;
		
	    if (ijTc.getMax() > t2)
		    minRight=t2;
	    else
		    minRight = ijTc.getMax();
		
		//-- the time constraint doesn't exit, and it is not consistent;
		if (maxLeft > minRight)		
			return 1;	
		  
		//-- it is not revised;
		if((maxLeft == ijTc.getMin())&&(minRight == ijTc.getMax()))
			return 2;
		
		//-- If it is revised then give the new value and return true;
		else 
		{
			Vector<HalfTimeConstraint> tcl;

			//-- revise the time constraint tc[i,j] in the time constraint matrix by maxLeft and minRight;
			for(int m=0; m<tcSet.size(); m++)
			   if(tcSet.get(m).equals(tpi))
			   {
				   //-- the half time constraint list for the post time point;
				   tcl = tcSet.get(m).postTimeCons;
				   for(int n=0; n<tcl.size(); n++)
				   {
					   if (tcl.get(n).pre.equals(tpj))
					   {
						   tcl.get(n).value = minRight;
						   break;
					   }

				   }
				   break;
			   }
			
			for(int m=0; m<tcSet.size();m++)
		       if(tcSet.get(m).equals(tpj))
		       {
		    	   //-- the half time constraint list for the pre time point;
		    	   tcl = tcSet.get(m).postTimeCons;
		    	   for(int n=0; n<tcl.size(); n++)
		    	   {
		    		   if(tcl.get(n).pre.equals(tpi))
		    		   {
		    			  tcl.get(n).value = 0- maxLeft;
		    			  break;
		    		   }   
		    	   }   		    	   
		    	   break;
		       }
            
			//-- the time constraint is revised;
			return 3;
		}
	}

	/**get the time constraint, the pre time point and the post time point of which is given; 
	 * 
	 * @param tcsIn
	 * @return
	 *         the time constraint, if it exits;
	 *         
	 *         null, else;
	 */
	
	public TimeConstraint getTimeConstraint(TimePoint tpiIn, TimePoint tpjIn)
	{
        TimeConstraint retVal = new TimeConstraint();
		
		TimePoint tpPost = tpiIn;
		TimePoint tpPre = tpjIn;
		
		retVal.setPrePoint(tpPre);
		retVal.setPostPoint(tpPost);
		
		double min, max;
		min = 0; max =0;
		
		Vector<HalfTimeConstraint> tcListofPost = new Vector<HalfTimeConstraint>();
		Vector<HalfTimeConstraint> tcListofPre = new Vector<HalfTimeConstraint>();
		
		TimeConstraintList tl;
		for(int i =0; i<tcSet.size(); i++)
		{
			tl = tcSet.get(i);
			if(tl.tp.equals(tpPost))
			   tcListofPost = tl.postTimeCons;
			if(tl.tp.equals(tpPre))
				tcListofPre = tl.postTimeCons;
		}
	
		if((tcListofPost.size() == 0)||(tcListofPre.size() == 0))
			return null;
		
		for(int i=0; i< tcListofPost.size();i++)
		{			
			if(tcListofPost.get(i).pre.equals(tpPre))
			   max = tcListofPost.get(i).value;
		}
		
		for(int j=0; j<tcListofPre.size();j++)
		{
			if(tcListofPre.get(j).pre.equals(tpPost))
			   min = 0- tcListofPre.get(j).value; 
		}
		
		retVal.setMax(max);
		retVal.setMin(min);
		
		return retVal;
	}
	
	
	/**
	 * get the related paths of the element (i,k,j)
	 * @param e
	 *         the element to find the 
	 * @return
	 */
	public Vector<Element> relatedPaths (Element e)
	{
		int i = e.i;
		int k = e.k;
		int j = e.j;
		
		Vector<Element> eQueue=new Vector<Element>();	
		int m;

        for (m=i+1; m < numberOfPoints; m++)
           	if(m != j)
          	   eQueue.add(new Element(i,j,m));
		
		for(m=0; m<j; m++)
			if(m != i)
			   eQueue.add(new Element(m,i,j));
		
		for(m=j+1; m < numberOfPoints; m++)
			eQueue.add(new Element(j,i,m));
		
		for(m=0; m<i; m++)
			eQueue.add(new Element(m,j,i));			
		
		return eQueue;
	}

	
	/** After adding two time points to the current simple time net.Then, propagate the added time constraint 
	 *  in the simple time network, then check whether it is consistent with current simple time net
	 * @param  tcIn
	 *         the time constraint to be checked;
	 * @return
	 *         <true> 
	 *              if the time constraint is consistent with the simple time network
	 *         <false>
	 *              else
	 */             
    public boolean propagateAfterAdding(TimeConstraint tcIn)	
    {
    	//-- the time constraint can be translated to a time constraint, the index of the pre time point
    	//-- is bigger than the index of the post time point
        //-- the (tpi,tpj) are the time points affected by the last posted constraint
    	//-- tpj-tpi
	    TimePoint tpi=tcIn.getPostPoint();
	    TimePoint tpj=tcIn.getPrePoint();
	    
	    //-- get the index of the pre and post time points in the time point list;
	    int i,j;
	    i = knownPoints.indexOf(tpi);
	    j = knownPoints.indexOf(tpj);
	    
	    Vector<Element> eQueue=new Vector<Element>();
	    
	    //-- construct the list of the elements  
        for(int k=0;k<knownPoints.size();k++)
        {
        	if((k!=i)&&(k!=j))
        		eQueue.add(new Element(i,k,j));
        }
                      	 
        Element e;
        int flag;
        while (eQueue.size() > 0)
        {
            e = (Element)eQueue.remove(0);
           
            flag = revise(e);
            
            //-- if the r[i,j] is changed;
            if(flag == 3)
            {
        	    Vector<Element> relatedQueue;
        	    relatedQueue = relatedPaths(e);
            	
            	for(int index=0; index < relatedQueue.size(); index++)
            		eQueue.add(relatedQueue.get(index));
            	
            	relatedQueue.clear();
            } 
            //-- the time constraint is not consistent;
            if(flag == 1)
            	return false;
        }

        return true;     
    }    
    
    public void getTcMatrix(double v[][])
    {
    	TimeConstraintList tl;
    	
    	for(int i=0; i< tcSet.size(); i++)
    	{
    		tl = tcSet.get(i);  		
    		for(int j=0; j< tl.postTimeCons.size(); j++)
    			v[i][j] = tl.postTimeCons.get(j).value;   		    		
    	}
    }
    
    public void setTcMatrix(double vIn[][])
    {
    	TimeConstraintList tl;
    	
    	for(int i=0; i< tcSet.size(); i++)
    	{
    		tl = tcSet.get(i);  		
    		for (int j=0; j< tl.postTimeCons.size(); j++)
                tl.postTimeCons.get(j).value = vIn[i][j];
    	}
    	
    }
    
    
    
    
    
}
