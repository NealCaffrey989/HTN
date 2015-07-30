package JSHOP2;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;
import java.util.LinkedList;

public class TaskNet {
	
	/** the set of subtasks for this task net 
	 */
	private Vector<TaskAtom> tasks = new Vector<TaskAtom>();
	
	/** the time constraints of the task net
	 */
	private TimePointNet stn = new TimePointNet();
	

	/**To initialize a task net by a task list and a time constraint list
	 * @param  tlIn
	 *         the task list of the task net representing the qualitative temporal constraints
	 * @param tcsIn
	 *         a list of time constraints defined on the task list;
	 */
	public TaskNet(TaskList tlIn, Vector<TimeConstraint> tcsIn)
	{
		//--get a set of tasks atoms from the task list;  
		Vector<TaskAtom> taskSet = getTasksFromTl(tlIn);
		
		//--get a set of time constraints from the task list
		Vector<TimeConstraint> tcSet = new Vector<TimeConstraint>();
		getTimeConstraintsFromTl(tlIn,tcSet);
		
		//--add the task atom to the tasks;
		int index = 0;
		TaskAtom t;
		TimeConstraint tc;
		for(int i=0;i<taskSet.size();i++)
		{
			//-- add the task atom
			t = taskSet.get(i);
			addTask(t, index);
		    
			//-- add the time constraint 0 < endTp - startTp < max
			double[] value;
			value = new double[2];
			tc = new TimeConstraint(new TimePoint(t, false), new TimePoint(t, true), 0, Double.MAX_VALUE);
			stn.addTimeConstraint(tc, value);
			
			index += 1;
		}
		
		
		
		
		double[] value;
		//--add the qualitative time constraint list to the simple time constraint for the task net
	    for(int j=0; j<tcSet.size();j++)
	    {
	    	value = new double[2];
	    	stn.addTimeConstraint(tcSet.get(j), value);
	    }

	    
	    //-- add the quantitative time constraint list to the simple time constraint for the task net  
	    for(int j=0; j<tcsIn.size(); j++)
	    {
	    	value = new double[2];
	    	stn.addTimeConstraint(tcsIn.get(j), value);
	    }

	}
	
    /**get the simple time net associated to the the task net;
     */
    public TimePointNet getStn()
    {
    	return stn;
    }
      
    public Vector<TaskAtom> getTasks()
    {
    	return tasks;
    }

	/** To get all the task atoms associated with this task list, if the task
     *  list is not an atomic task list.
     *  
     *  @return
     *       the task atom vector associated with this task list in case this is an
     *  atomic task list, <code>null</code> otherwise.
    */
    public static Vector<TaskAtom> getTasksFromTl(TaskList tl)
    {
  	  Vector<TaskAtom> subtaskSet=new Vector<TaskAtom>();
  	  
  	  //-- If this is an atomic task list,
  	  if (tl.subtasks == null)
  	     //-- Just bind the task atom.
  	     subtaskSet.add(tl.getAtomicTask());
  	  else
  	  {
  		  for (int i = 0; i < tl.subtasks.length; i++)
  		  {
  			  //--if the subtask of this task list is as a atomic task;
  			  if (tl.subtasks[i] == null)
  			     subtaskSet.add(tl.subtasks[i].getAtomicTask());
  			  else
  			     {
  				   Vector<TaskAtom> ts=new Vector<TaskAtom>();
  				   ts=getTasksFromTl(tl.subtasks[i]);
  				   for(int j=0;j<ts.size();j++)
  					   subtaskSet.add(ts.get(j));
  			 	 } 		  
  		  } 		  
  	  }  
  	  return subtaskSet;
     }
    
    /**Get the qualitative time constraints from the task list
     * @param tlIn
     *        the task list to be added to the task net
     */
    public  void  getTimeConstraintsFromTl(TaskList tlIn, Vector<TimeConstraint> res)
    {
    	
    	//--the task list is a non-atomic task atom;
    	if(tlIn.subtasks != null)
    	{
        	if(tlIn.isOrdered())
        	{
        		for (int i=0; i<tlIn.subtasks.length-1; i++)
        			if ((tlIn.subtasks[i] != null)&&(tlIn.subtasks[i+1] != null))
        			   getTimeConstraintHelper(getTasksFromTl(tlIn.subtasks[i]), getTasksFromTl(tlIn.subtasks[i+1]), res);
        	}
    	}
    	
    	if(tlIn.subtasks != null)
    		for (int j=0; j<tlIn.subtasks.length; j++)
    			getTimeConstraintsFromTl(tlIn.subtasks[j], res);
    }
    
    /**get the a set of time constraint from two set of task atoms, and then add it to the set of time constraint
     * 
     * @param preTasks
     * @param postTasks
     * @return
     */
    public void getTimeConstraintHelper(Vector<TaskAtom> preTasks, Vector<TaskAtom> postTasks, Vector<TimeConstraint> res)
    {     	
    	int i,j;
    	for(i=0; i<preTasks.size(); i++)
    		for(j=0; j<postTasks.size(); j++)
    			res.add(new TimeConstraint( new TimePoint(postTasks.get(j),true),
    					                    new TimePoint(preTasks.get(i),false),
    			                            0, Double.MAX_VALUE) 
    			       );
    }
    
    /**add a task atom to the task net.And at the meanwhile, the time point of the start time 
     * and the end time is added to the simple time net of the task net; 
     * 
     * @param tIn
     *           the task atom to be added to the task net;
     */
    public void addTask(TaskAtom tIn, int index)
    {
    	//--add the task atom to the set of the subtasks
    	tasks.add(index, tIn);
    	
    	//-- create the time points representing the start time and end time for this task atom;
    	TimePoint startTp, endTp;
    	startTp = new TimePoint(tIn, true);
    	endTp = new TimePoint(tIn, false);
    	
    	//-- add the time point representing the start time of the task atom, to the position;
    	stn.addTimePoint(startTp, 2*index + 1);
    	//-- add the time point representing the end time of the task atom, to the position;
    	stn.addTimePoint(endTp, 2*index + 2);
    	
    }
     

    /**delete the task atom from the task net 
     * At the meanwhile, delete the time points representing the start time and the end time 
     * of the task atom from the simple time net
     * 
     * @param tIn
     *          the task atom to be deleted;
     *          delAdd[8] store the start time point;
     *          delAdd[9] store the end time point;
     *          
     * @return
     *        <true>
     *          if the task atom can be deleted;
     *         
     */
    public boolean deleteTask(TaskAtom tIn)
    {
    	if(tasks.remove(tIn) == true)
    	{
    		//-- delete the time points representing the start time and the end time of this task atom; 
    		if((stn.deleteTimePoint(new TimePoint(tIn, true)))
    		   && (stn.deleteTimePoint(new TimePoint(tIn, false))))
    		   return true;
    	}
    	return false; 	   	
    }
    
    /** To return a <code>LinkedList</code> of the task atoms we have the option
     *  to achieve right now. 
     *  @param tasksIn
     *         the task atom list to check the task in them is the first task;
     * 
     */

    public LinkedList<TaskAtom> getFirst(Vector<TaskAtom> tasksIn)
    {
        //-- Make an empty list, which return the first task list.
        LinkedList<TaskAtom> retVal = new LinkedList<TaskAtom>();
        
        //-- iterate the task atom list;
        Iterator i= tasksIn.iterator();

        //-- the time point list for storing the start time point of each task atom;  
        Vector<TimePoint> tpSet = new Vector<TimePoint>();
        
        //--iterator through the set of tasks, to check whether the task has precedensor; 
        TaskAtom t;
        TimePoint tp;
        while(i.hasNext())
        {
        	t = (TaskAtom)(i.next());
        	tp = new TimePoint (t,true); 
        	tpSet.add(tp);
        }
        
    	//--if there is no time point preceding the time point, representing the start
    	//--time of the task atom 
        TimePoint preTp, postTp;
    	int m, n, size;

    	TimeConstraint tc;
    	size = tpSet.size();
    	
	    //-- use this array to store the beforehand time constraint matrix;
        double[][] tcMatrixStore;
        tcMatrixStore = new double[stn.getNumberOfPoints()][stn.getNumberOfPoints()];
        stn.getTcMatrix(tcMatrixStore);
    	
        for(m=0; m < size; m++)
        {
        	preTp = tpSet.get(m);
        	
        	for (n=0; n < size ; n++)
        	{ 

        		if (n != m)
        		{
            		//-- add the time constraint (min < preTp - postTp <0) to the STN
        			postTp = tpSet.get(n);
        			tc = new TimeConstraint(preTp,postTp,0 - Double.MAX_VALUE, 0 - Double.MIN_VALUE);

        			boolean flag;
        	    	double[] value; 
        	    	value = new double[2];
        	    	flag = stn.addTimeConstraint(tc, value);
        	    	
            		//-- refresh the time constraint matrix;
            		stn.setTcMatrix(tcMatrixStore);	
        	    	
        			//-- if the time constraint is not consistent with the STN
        	    	//-- the former task cannot be started before the later task;
             		if (flag == false)
             		   break;            		             			
        		}
        	}
        	
        	//-- the pre time point precedes all the other post time point;
        	if(n == size)
        		retVal.add(tasksIn.get(m));
        }
        //-- Return the result.
        return retVal;
    }
	
	
	/**  decomposed the given task atom by the task list and a set of time constraints defined 
	 *  in the branch of a method unifying with the task atom 
	 * @param  t
	 *           the composite task to be decomposed;
	 * @param  tlIn         
	 *           the task list of the method used to decompose this composite task;
	 * @param  tcsIn
	 *           the time constraint list defined on the time points of the task atoms for
	 *           the method 
	 * @param  delAdd
	 *           delAdd[0]:  the subtask to be added to the task net;
	 *           delAdd[1]:  the qualitative time constraints defined on subtasks to be added;
	 *           delAdd[2]:  the quantitative  time constraints defined on subtasks to be added;
	 *           
	 *           delAdd[5]:  the compound task to be decomposed and deleted;
	 *      
	 * @return
	 *         <true> 
	 *         if the compound can be decomposed
	 *         <false>
	 *         else wise 
	 */
	public boolean taskDecompose(TaskAtom t, TaskList tlIn, Vector<TimeConstraint> tcsIn, Term[] nextBindingIn, Vector[] delAdd)
	{
		Vector<TaskAtom> subtasks = getTasksFromTl(tlIn);
		
        TaskList tlBinded = tlIn.bind(nextBindingIn);
		Vector<TaskAtom> subtasksofBinded = getTasksFromTl(tlBinded);
		
		TimeConstraint tc;
		TaskAtom taskPre, taskPost;
		int indexOfPre, indexOfPost;
		
		if (tcsIn != null)
		{
			for(int i=0; i<tcsIn.size(); i++)
			{
				tc = tcsIn.get(i);
				taskPre = tc.getPrePoint().getTask();
				taskPost = tc.getPostPoint().getTask();
				
				if (taskPre != null)
				{				
					indexOfPre = subtasks.indexOf(taskPre);
					tc.getPrePoint().setTask(subtasksofBinded.get(indexOfPre));
				}
			    
				if (taskPost != null)
				{
					indexOfPost = subtasks.indexOf(taskPost);
					tc.getPostPoint().setTask(subtasksofBinded.get(indexOfPost));
				}
			}	
		}
		
	    //-- get the time constraint set for binded task atoms, the task atoms is binded;
		Vector<TimeConstraint> tcsQualitive=new Vector<TimeConstraint>();	
		getTimeConstraintsFromTl(tlBinded, tcsQualitive);
		
		delAdd[0] = new Vector();
		delAdd[1] = new Vector();
		delAdd[2] = new Vector();
		delAdd[3] = new Vector();
		delAdd[4] = new Vector();
		delAdd[5] = new Vector();
		
        //-- store the time constraint matrix using delAdd[0];
		int size = stn.getNumberOfPoints();
        double[][] tcMatrixStore;
        tcMatrixStore = new double[size][size];
        stn.getTcMatrix(tcMatrixStore);
        
        for(int i=0; i < size; i++)
        	for(int j=0; j < size; j++)
        		delAdd[0].add(tcMatrixStore[i][j]);       
		
		//-- store the time points except the time point defined on the task atom
		//-- to be decomposed, before adding the subtasks; 
		Vector<TimePoint> timePointsOld = new Vector<TimePoint>();
		TimePoint tpOld;
		
		for(int i=0; i< stn.getNumberOfPoints();i++)
		{
			tpOld = stn.getKnownPoints().get(i);
		    timePointsOld.add(new TimePoint(tpOld));
		}
					
		//-- get the index of this task to be decomposed;
		int index = tasks.indexOf(t);
		index += 1;
		//-- add the subtask atoms of it to the task net, the position of it is after the task atom t;
		for(int i=0;i<subtasksofBinded.size();i++)
		{
		   addTask(subtasksofBinded.get(i), index);
		   index += 1;
		   //-- delAdd[1] stores the added subtasks 
		   delAdd[1].add(subtasksofBinded.get(i));
		}		

		//-- add the time constraint defined on the start time point and end time point of the subtask;
		//-- [0 <= endTpSub - startTpSub < max]
		for(int i=0;i<subtasksofBinded.size();i++)
		{
	    	TimePoint startTpSub, endTpSub;
	    	startTpSub = new TimePoint(subtasksofBinded.get(i), true);
	    	endTpSub = new TimePoint(subtasksofBinded.get(i), false);
	    	
			//-- add the time constraint defined on these two time points
			double[] value;
			value = new double[2];
	    	stn.addTimeConstraint(new TimeConstraint(endTpSub, startTpSub, 0, Double.MAX_VALUE), value);
		}
		
		//-- replace the time point of the start and end time point in the relevant time constraints
		//-- by the following codes;
		TimePoint startTp = new TimePoint(t, true);
		TimePoint endTp = new TimePoint(t, false);
		
		//-- get time constraint list, the post time point of which is the start time point of the task
		//-- atom to be decomposed; 
		Vector<TimeConstraint>  startPostTcList, endPostTcList;
		startPostTcList = new Vector<TimeConstraint>();
		endPostTcList = new Vector<TimeConstraint>();
		
		TimeConstraint startPostTc, endPostTc;		
		TimePoint tp;
		
 	    for(int i=0; i< timePointsOld.size(); i++)
 	    {
 	    	tp = timePointsOld.get(i);
 	    	
    		//-- get the time constraints (min < tp - startTp < max);
 	    	startPostTc = stn.getTimeConstraint(startTp, tp); 	 	    	
 	    	//-- get the time constraint (min < tp - endTp < max)
 	    	endPostTc = stn.getTimeConstraint(endTp, tp);
 	    		
 	    	//-- store the time constraint list
 	    	startPostTcList.add(startPostTc);
 	 	    endPostTcList.add(endPostTc); 	 	    	   			    	
 	    }
		
 	    //-- delete the task atom having been decomposed, the time constraints defined on the start time
 	    //-- point and end time point are deleted from the time point net;
 	    int position = tasks.indexOf(t);
        if(!(deleteTask(t)))
        	return false;
        else 
        {
        	//-- store the deleted task atom that has been decomposed;
        	delAdd[2].add(t);
        	//-- store the position of task atom in the task net;
        	delAdd[3].add(position);    	
        }	
        
		//-- for the time constraints, whose post time point is the start time point;
        //-- replace it with the start time point of the subtasks;
 	    TimePoint subStartTp;
 	    TimeConstraint subStartPostTc;
 	    for(int i=0; i < startPostTcList.size(); i++)
 	    {
 	    	startPostTc = startPostTcList.get(i);	    	
 	    	
 	    	if (!(startPostTc.getPrePoint().equals(startTp)))
 	    	{
 	 	 	    for (int j=0; j<subtasksofBinded.size(); j++)
 	 	 		{    
 	 	 		    //-- get the start time point of the task atom in the subtasks
 	 	 			subStartTp = new TimePoint(subtasksofBinded.get(j),true);

 	 	 			if (startPostTc.getPrePoint().equals(endTp))
 	 	 				subStartPostTc = new TimeConstraint(new TimePoint(subtasksofBinded.get(j),false),
 	 	 				                        subStartTp, startPostTc.getMin(), startPostTc.getMax());
 	 	 			else
 	 	 				subStartPostTc = new TimeConstraint(startPostTc.getPrePoint(), subStartTp, startPostTc.getMin(), startPostTc.getMax());		  
 	 	 			 	   
 	 	 			double[] value;
 	 	 			value = new double[2];
 	 	 		    stn.addTimeConstraint(subStartPostTc, value);
 	 	 		}	
 	    	}
 	    }
 	    
 	    //-- for time constraint, the post time point of which is the end time point of the task atom,
		//-- replace it with the end time point of the task atoms in the subtasks
		TimeConstraint subEndPostTc;
		TimePoint subEndTp;
 	    for(int i=0; i< endPostTcList.size(); i++)
 	    {
 	    	endPostTc = endPostTcList.get(i);
 	    	
 	    	if((!(endPostTc.getPrePoint().equals(startTp)))&&(!(endPostTc.getPrePoint().equals(endTp))))
 	    	{
 	 	    	for (int j=0;j<subtasksofBinded.size();j++)
 	 	    	{
 	  			    //--get the end time point of the task atom in the subtasks
 	  				subEndTp = new TimePoint(subtasksofBinded.get(j), false);
 	  				subEndPostTc = new TimeConstraint(endPostTc.getPrePoint(), subEndTp, endPostTc.getMin(), endPostTc.getMax());		  

 	 				//-- add the time constraint, the  time constraint is not be stored;
 	  				double[] value;
 	  				value = new double[2];
 	  				stn.addTimeConstraint(subEndPostTc, value);
 	 	    	} 
 	    	}
   		
 	    }
		
		//-- add the qualitative time constraint list defined on the subtasks; 
		//-- delAdd[4] stores the qualitative time constraint and the value list
		if(!(stn.addTimeConstraintSet(tcsQualitive, delAdd[4])))
		    return false;
		
		//-- add the quantitative time constraint list defined on the subtasks;
		//-- delAdd[5] stores the quantitative time constraint list;
		if(!(stn.addTimeConstraintSet(tcsIn, delAdd[5])))
			return false;
        
		//--finally, return true, and the task atom is decomposed
        return true;
	}
	
	/** This function undoes the decomposition of a task atom to a task net
	 *  in case of a backtrack over the decision to decompose the task.
	 *  @param  delAdd 
	 *          a array of size 8 to store the task, time constraints to be deleted and added 
	 *          from the current task network
	 */

	public boolean undo(Vector[] delAdd)
	{
		  TaskAtom t;
		  if (delAdd[2].size() >0)
			  t = (TaskAtom) delAdd[2].get(0);
		  else 
			  return false;
		  
		  Integer position;
		  if (delAdd[3].size() >0)
		     position = (Integer)delAdd[3].get(0);
		  else 
			  return false;
		  
		  //-- add the deleted task atom haven been decomposed to the task net;
		  addTask(t, position);	  
		  
		  //-- delete the added subtasks;
		  Iterator e;
	      e = delAdd[1].iterator();
	      while (e.hasNext())
	    	  deleteTask((TaskAtom)e);
	      
	      
	      //-- refresh the time constraint matrix;
	      int size = stn.getNumberOfPoints();
	      double[][] tcMatrix;
	      tcMatrix = new double[size][size];
	      
	      //-- change the list of value to the time constraint matrix;
	      int sizeOfList = delAdd[0].size();
	      double value;
	      int m, n;
	      for(int i=0; i< sizeOfList; i++)
	      {
		      value = (Double)delAdd[0].get(i);
		      
		      m = (int)(i / size);
		      n = i - size*m;
		      tcMatrix[m][n] = value;
	      }

	      stn.setTcMatrix(tcMatrix);
	      
	      return true;
	}
}
