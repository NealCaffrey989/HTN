package JSHOP2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

/** This class represents all the variables that JSHOP2 needs every time it
 *  calls itself recursively. The reason all these variables are bundled
 *  together in one class rather than having them locally defined is to save
 *  stack space. Right now, the only thing that is stored in the stack is a
 *  pointer to this class in each recursion, and the actual data is stored in
 *  heap memory, while if these variables were just locally defined, all of
 *  them would be stored in the stack, resulting in very fast stack overflow
 *  errors.
 *
 *  @author Okhtay Ilghami
 *  @author <a href="http://www.cs.umd.edu/~okhtay">http://www.cs.umd.edu/~okhtay</a>
 *  @version 1.0.3
*/
class InternalVars
{
  /** The binding that unifies the head of a method or an operator with the
   *  task being achieved.
  */
  Term[] binding;

  /**An array of size 4 to store the task, time constraint deleted and added to the time constraint
   * set of the task network
   */
  Vector[] delAddDecompose;

/** An array of size 6 to store the atoms of the instantaneous effects, protections,
   *  and the delayed effects that are being deleted or added to the current state of
   *  the world as a result of application of an operator, to be used in case of a 
   *  backtrack over that operator.
  */
  Vector[] delAddOperator;
  
  /**An array of size 2 to store the atoms deleted and added to the current state of
   * the world after triggering the events in the event queue 
   * 
   */
  Vector[] delAddEvent;
  
  /** The iterator iterating over the <code>LinkedList</code> of the task atoms
   *  that we have the option to achieve right now.
  */
  //-- Iterator<TaskAtom> e;

  /** Whether or not at least one satisfier has been found for the current
   *  branch of the current method. As soon as it becomes <code>true</code>,
   *  further branches of the method will not be considered.
  */
  boolean found;

  /** The index of the method or operator being considered.
  */
  int j;

  /** The index of the branch of the current method being considered.
  */
  int k;

  /** An array of methods that can achieve the compound task being
   *  considered.
  */
  Method[] m;

  /** Next binding that satisfies the precondition of the current method or
   *  operator.
  */
  Term[] nextB;

  /** An array of operators that can achieve the primitive task being
   *  considered.
  */
  Operator[] o;
   

  /** An iterator over the bindings that can satisfy the precondition of the
   *  current method or operator.
  */
  Precondition p;

  /** The task atom chosen to be achieved next.
  */
  TaskAtom t;

  /** The linked list for the tasks having no predecessors and having not been tried.
   * 
   */
  LinkedList<TaskAtom> tasksList; 
  
  /** The iterator iterating over the <code>LinkedList</code> of the task atoms
   *  that we have no predecessors and have not been tried.
  */
  Iterator<TaskAtom> e;
  
  /** The task list that represents the task list of the decomposition  for 
   *  the method;
   */
  TaskList tlm;
  
  /**The time constraint list that represents the time constraint set of the
   * decomposition for the method  
   */
  Vector<TimeConstraint> tcm;
  
  /** The position for the task atom in the firstTasks; 
   */
  int position;
  
  /** To store the task list having no predecessors. 
   */
  Vector<TaskAtom> storedFirstTasks;  
  
  Vector<Boolean> storedFlags;
}


/** This class is the implementation of the JSHOP2 algorithm.
 *
 *  @author Okhtay Ilghami
 *  @author <a href="http://www.cs.umd.edu/~okhtay">http://www.cs.umd.edu/~okhtay</a>
 *  @version 1.0.3
*/
public class JSHOP2
{
  /** The plan currently being constructed.
  */
  private static Plan currentPlan;

  /** The domain description for the planning problem.
  */
  private static Domain domain;

  /** The maximum number of plans to be returned.
  */
  private static int planNo;

  /** The plans are stored in this variable as a list of type
   *  <code>Plan</code>.
  */
  private static LinkedList<Plan> plans;

  /** The current state of the world.
  */
  private static State state;
   
  /** The task list to be achieved.
  */
  private static TaskNet tn;
  
  /** The tasks having no predecessors in the task net;
   */
  private static LinkedList<TaskAtom> firstTasks = new LinkedList<TaskAtom>();
  
  /** The flag list representing whether the task in the above task list is tried.   
   *  If the flag is equal to false, the task atom is not been tried, else the task is tried.
   */
  private static LinkedList<Boolean> flags = new LinkedList<Boolean>();
  
  /** The flag representing whether some operator is applied.
   */
  private static boolean flagOperator = false;  

  /** An <code>ArrayList</code> that represents the steps taken to find every plan.
  */
  private static ArrayList<PlanStepInfo> planStepList;

  /** Incremented whenever a plan is found. Passed to JSHOP2GUI.
  */
  private static int numPlans;


/** This function finds plan(s) for a given initial task list.
   *
   *  @param tasksIn
   *          the initial task net to be achieved.
   *  @param planNoIn
   *          the maximum number of plans to be returned.
   *  @return
   *          0 or more plans that achieve the given task list.
  */
  public static LinkedList<Plan> findPlans(TaskNet tasksIn, int planNoIn)
  {
    //-- Initialize the plan list to an empty one.
    plans = new LinkedList<Plan>();

    //-- Initialize the current plan to an empty one.
    currentPlan = new Plan();

    //-- Initialize the current task list to be achieved.
    tn = tasksIn;
    
    //-- Initialize the task list having no predecessors.
    firstTasks = tn.getFirst(tn.getTasks());
    
    //-- Initialize the flag list associating to the above task list.
    for (int i=0; i < firstTasks.size(); i++)
    	flags.add(i, new Boolean(false));
        
    //-- Initialize the list of steps taken to find all plans
    planStepList = new ArrayList<PlanStepInfo>();

    //-- Initialize the number of plans found to 0
    numPlans = 0;

    planNo = planNoIn;

    PlanStepInfo newStep = new PlanStepInfo();
    newStep.action = "SETGOALTASKS";
    planStepList.add(newStep);
    
    //-- Call the helper function.
    findPlanHelper(tn);

    //-- Return the found plan(s).
    System.out.print(plans);
    
    return plans;
  }

  /** get the task atom list, which doesn't been tried, in the task list having no predecessor.
   * 
   * @return
   */
  private static LinkedList<TaskAtom> getFirstNewTasks()
  {
	  LinkedList<TaskAtom> newTl = new LinkedList<TaskAtom>();
	  
	  int i;
	  Boolean flag;
	  if(flags.size()>0)
	  {
		  for(i=0; i<flags.size(); i++)
		  {
			  flag = flags.get(i);
			  if (flag.booleanValue() == false)
				  newTl.add(firstTasks.get(i));
		  }
	  }
	  return newTl;
  }

  
  /** This is the helper function that finds a plan.
   *
   *  @param chosenTask
   *          the task list chosen to look for the next task atom to achieve.
   *          This variable is usually set to the whole task network unless
   *          there is a method that is chosen to decomopose a task, and the
   *          decomposition of that task has not gone all the way down to an
   *          operator. In that case, this variable will be set to the task
   *          decomposed by that method.
   *  @return
   *          <code>true</code> if a plan is found, <code>false</code>
   *          otherwise.
  */
  private static boolean findPlanHelper(TaskNet chosenTask)
  {
    //-- The local variables we need every time this function is called.
    InternalVars v = new InternalVars();
         
    //-- If there is not tasks left in the task net.
    if (tn.getTasks().size()==0)
    {
      //-- Otherwise, add the current plan to the list of the plans for the
      //-- given task network. Note that in the case where we are looking for
      //-- more than one plan, we add a clone of the current plan to the list
      //-- rather than the current plan+ itself since the current plan will be
      //-- changed during the look for other plans.
      if (planNo != 1) 
         plans.addLast((Plan)currentPlan.clone()); 
      else 
         plans.addLast(currentPlan);
      
      //-- create the planInfo step
      PlanStepInfo newStep = new PlanStepInfo();
      newStep.planFound = true;
      planStepList.add(newStep);
      numPlans++;

      return true;
    }

    //-- This array of size 7 will store the atoms of the instantaneous effects, the delayed
    //-- effects that are deleted from and added to the current state of the world as a result
    //-- of an operator being applied. 
    v.delAddOperator = new Vector[7];
    
    //-- This array of the size 5 will store the atoms deleted and added to the state
    //-- of the current world, after triggering the events
    v.delAddEvent = new Vector[5];   
    
    //--This array of the size 6 will store the time constraint deleted and added to the
    //--time constraints of the current task network
    v.delAddDecompose=new Vector[6];
    
    v.storedFirstTasks = new Vector<TaskAtom>();
    v.storedFlags = new Vector<Boolean>();    
                 
    double cost = 1.0;
    
    //-- get the task list having no predecessors and having not been tried.
    v.tasksList = getFirstNewTasks();
    
    //-- get the iterator of the task atom list, having not been tried, in the task list having no predecessors.	
    v.e = v.tasksList.iterator();      
      
    //-- for each task in the task list having no predecessor, and it has not been tried; 
    while (v.e.hasNext())
    {
    	//-- get the task atom having not been tried, in the task list having no predecessors.
    	v.t = v.e.next();
    	  
        //-- get the index of the task atom in the task list having no predecessor.
        v.position = firstTasks.indexOf(v.t);
        flags.set(v.position, new Boolean(true));
      
        //-- Create a TRYING step for the list of plan steps
        PlanStepInfo newStep = new PlanStepInfo();
        newStep.action = "TRYING";
        //-- newStep.state = state.getState();
        newStep.taskAtom = v.t;
        planStepList.add(newStep);

        //-- If this task atom is primitive,
        if(v.t.isPrimitive())
        {          
          //-- Find all the operators that achieve this primitive task.
          v.o = domain.ops[v.t.getHead().getHead()];   
          
          //-- For each of these operators,
          for (v.j = 0; v.j < v.o.length; v.j++)
          {
              //-- Find the binding that unifies the head of the operator with the task.
              v.binding = v.o[v.j].unify(v.t.getHead());
              
              //-- If there is such bindings,
              if (v.binding != null)
              {
                 //-- Get the iterator that iterates over all the bindings that can
                 //-- satisfy the precondition for this operator.
                 v.p = v.o[v.j].getIterator(v.binding, 0);

                 //-- For each such binding,
                 while ((v.nextB = v.p.nextBinding()) != null)
                 {
                      //-- Merge the two bindings.
                      Term.merge(v.nextB, v.binding);

                      //-- if the operator instance is applicable, apply it to change the state and delete the primitive task atom;
                      if (v.o[v.j].apply(v.nextB, state, tn, v.t, v.delAddOperator))
                      {
                        //-- store the tasks list having no predecessors;
                        Iterator<TaskAtom> i1 = firstTasks.iterator();
                        while (i1.hasNext())
                            v.storedFirstTasks.add((TaskAtom)i1.next());
                            
                        //-- store the flags list associating to the above task list  
                        Iterator<Boolean> i2 = flags.iterator();
                        while (i2.hasNext())
                        	v.storedFlags.add((Boolean)i2.next());  
                    	  
                        //-- remove the simple task atom at the specified position from the tasks list having no predecessor; 
                    	firstTasks.remove(v.position);
                    	flags.remove(v.position); 
                      	                      	  
                      	//-- Add the instance of the operator that achieved this task
                        //-- to the beginning of the plan, remembering how much it cost.
                        cost = currentPlan.addPlanElement(v.o[v.j], v.nextB, state.getTime());
                        
                        //-- set the flag for this operator to true.
                        flagOperator = true;
                                 
                        //-- Create a STATECHANGED step for the list of plan steps
                        newStep = new PlanStepInfo();
                        newStep.action = "STATECHANGED";
                        newStep.taskAtom = v.t;
                        newStep.delAdd = v.delAddOperator;
                        newStep.operatorInstance = v.o[v.j].getHead().applySubstitution(v.nextB).toString(JSHOP2.getDomain().getPrimitiveTasks());
                        planStepList.add(newStep); 
                        
                        //-- Recursively call the same function to achieve the remaining tasks. If a plan is found for the 
                        //-- remaining tasks and we have found the maximum number of plans we are allowed, return true
                        if(findPlanHelper(tn) && plans.size() >= planNo)
                           return true;
                        
                        //-- Remove the operator from the current plan, recurse and find a new plan.
                        currentPlan.removePlanElement(cost);
                        
                        //-- Undo the changes of the task list and its associating flag list by applying this task.
                        firstTasks.clear();
                        flags.clear();
                        if (v.storedFirstTasks.size() > 0)
                        {
                        	for (int m=0; m < v.storedFirstTasks.size(); m++)
                      	        firstTasks.add(v.storedFirstTasks.get(m));
                        }	
                        if (v.storedFlags.size() > 0)
                        {
                            for (int n=0; n < v.storedFlags.size();n++)
                            	  flags.add(v.storedFlags.get(n));
                        }
                      }
                      //-- if the operator instance cannot be applied, undo the changes defined on state and task net. 
                      state.undoOperator(tn, v.delAddOperator);
                    } //-- while
                  }  //-- if binding
                }  //-- operators     
        }           
        //-- if this task is compound task atom,
        else
        {
          //-- Find all the methods that decompose this compound task.
          v.m = domain.methods[v.t.getHead().getHead()];

          //-- For each of these methods,
          for (v.j = 0; v.j < v.m.length; v.j++)
          {
            //-- Find the binding that unifies the head of the method with the task.
            v.binding = v.m[v.j].unify(v.t.getHead());

            //-- If there is such binding,
            if (v.binding != null)
            {
              //-- Initially, precondition of no branch of this method has
              //-- already been satisfied, so set this variable to false.
              v.found = false;

              //-- Iterate on all the branches of this method. note the use of
              //-- 'v.found' in the condition for the 'for' loop. It is there
              //-- because of the semantics of the method branches in JSHOP2:
              //-- Second branch is considered only when there is no binding for
              //-- the first branch, the third branch is considered only when
              //-- there is no binding for the first and second branches, etc.
              for (v.k = 0;(v.k < v.m[v.j].getSubs().length) && !v.found; v.k++)
              {
                //-- Get the iterator that iterates over all the bindings that
                //-- can satisfy the precondition for this branch of this method.
                v.p = v.m[v.j].getIterator(v.binding, v.k);

                //-- For each such binding,
                while ((v.nextB = v.p.nextBinding()) != null)
                {
                   //-- Merge the two bindings.
                   Term.merge(v.nextB, v.binding);

                   //-- get the subtask list of the decomposition for this method 
                   //-- the task atom is not be binded;
                   v.tlm=v.m[v.j].getSubs()[v.k];
                
                   //--get the time constraint list associated to the subtasks of
                   //--the decomposition [v.k] for this method 
                   v.tcm=v.m[v.j].getTcls().get(v.k);
                               
                   //--change the current task net by the method;
                   //--Replace the decomposed task in the task list of the task net with the
                   //--decomposition of the method according to this branch of this method.  
                   if(tn.taskDecompose(v.t, v.tlm, v.tcm, v.nextB, v.delAddDecompose))
                   {
                      //-- store the tasks list having no predecessors.
                      Iterator<TaskAtom> i1 = firstTasks.iterator();
                      while (i1.hasNext())
                           v.storedFirstTasks.add((TaskAtom)i1.next());
                    
                      //-- store the flags list associating to the above task list.
                      Iterator<Boolean> i2 = flags.iterator();
                      while (i2.hasNext())
                  	       v.storedFlags.add((Boolean)i2.next());  
                	
                      //-- remove the compound task atom from the tasks list having no 
                      //-- predecessor and its associated flag list. 
                      firstTasks.remove(v.position);
                      flags.remove(v.position);               
                	
                      //-- refresh the task list having no predecessors, because this compound task is decomposed.  
        		      Iterator<TaskAtom> e;
        		      Vector<TaskAtom> subtasks = new Vector<TaskAtom>();
        	          e = v.delAddDecompose[1].iterator();
        	          while (e.hasNext())
        	      	       subtasks.add((TaskAtom)e.next());
        	              	      
        	          //-- get the tasks having no predecessor for the subtasks of this compound task. 
        	          LinkedList<TaskAtom> firstSubTaskSet = tn.getFirst(subtasks);
        	      
        	          //-- add the new first task to the specified position of the task list having no predecessors. 
        	          TaskAtom t;
                      for (int m=0; m < firstSubTaskSet.size();m ++)
                      {
                	     t = firstSubTaskSet.get(m);
                	     firstTasks.add(v.position, t);
                	     //-- representing the added task has not been tried.
                	     flags.add(v.position, new Boolean(false)); 
                	     ++ v.position; 
                      }
                  	
                      //--if the compound task can be decomposed by this branch of this method, create a REDUCED step for it.
                      newStep = new PlanStepInfo();
                      newStep.action = "REDUCED";
                      newStep.taskAtom = v.t;
                      newStep.children = v.tlm;
                      newStep.ordered = v.tlm.isOrdered();
                      newStep.method = v.m[v.j].getLabel(v.k);
                      planStepList.add(newStep);
                  
                      //-- The further branches of this method must NOT be considered even if this branch fails because
                      //-- there has been at least one satisfier for this branch of the method. Set this variable to true 
                      //-- to prevent the further branches of this method from being considered.
                      v.found = true;  
                  
                      //-- Recursively call the same function to achieve the remaining tasks, but make the function
                      if (findPlanHelper(tn) && plans.size() >= planNo)
                         return true;

                      //-- Undo the changes of the firstTasks and flag list by decomposing the task.
                      firstTasks.clear();
                      flags.clear();
                      for (int m=0; m < v.storedFirstTasks.size(); m++)
                   	     firstTasks.add(v.storedFirstTasks.get(m));
                      for (int n=0; n < v.storedFlags.size();n++)
                	     flags.add(v.storedFlags.get(n));   
                  } 
                  //-- If the compound task cannot be decomposed successfully, undo the changes of the task net.
                  tn.undo(v.delAddDecompose);
              }//--while next binding for the compound task.
            }//--for the branch of the methods.
          }//--if
        }//--for the each method model.
      }//-- else the task atom is a compound task.
          
    }
    
    //-- After all the task atom in the tasks list having no predecessors is tried in the current state;
    //-- if (firstTasks.size() == 0)
    if (flagOperator == true)
    {  
    	//-- store the task having no predecessors for backtracking the planning process.
        Iterator<TaskAtom> i = firstTasks.iterator();
        while (i.hasNext())
      	    v.storedFirstTasks.add((TaskAtom)i.next());
        
        //-- store the flag list associating to the above task list.
        Iterator<Boolean> e = flags.iterator();
        while (e.hasNext())
        	v.storedFlags.add((Boolean)e.next());
    	
    	//-- get the all the tasks having no predecessors in the current task net; 
        LinkedList<TaskAtom> newFirstTasks = new LinkedList<TaskAtom>();
        newFirstTasks= tn.getFirst(tn.getTasks());
        
        //-- set the flag of the task in the tasks list having no predecessors.
        for (int n=0; n < firstTasks.size(); n++)
            flags.set(n, new Boolean(false));	
        
        //-- add the new tasks which have no precedences
        for(int m=0; m< newFirstTasks.size(); m++)
        {
        	TaskAtom t1 = newFirstTasks.get(m);
     	    if (!(firstTasks.contains(t1)))
     	    {
     	    	firstTasks.add(t1);
     	    	flags.add(new Boolean(false));
     	    }
        }

        //-- set the flag for operators to be false, and begin a new planning process.
        flagOperator = false;
                
        //-- start the planning process, using the new tasks list having predecessors. 
        if (findPlanHelper(tn) && plans.size() >= planNo)
            //-- A full plan is found, return true.
            return true;
        
        //-- backtracking the planning process and refresh the task list having no predecessor and its
        //-- associating flag list.
        firstTasks.clear();
        flags.clear();
        for (int m=0; m < v.storedFirstTasks.size(); m++)
        {
        	firstTasks.add(v.storedFirstTasks.get(m));
        	flags.add(v.storedFlags.get(m));
        } 
    }

    //-- All the task atoms in the task list having no predecessors is tried and can not be reduced in the current state.
    if (firstTasks.size()>0) 
    {
        //-- when all the applicable operator is applied, trigger the event set with the little time stamp 
        state.triggerNextEvents(v.delAddEvent);
        
        //-- store the flag list associating to the task atoms having no predecessor.
        Vector<Boolean> storedFlags = new Vector<Boolean>();
        Iterator<Boolean> e = flags.iterator();
        while (e.hasNext())
        	storedFlags.add((Boolean)e.next());
        
        //-- try each task atom in the new state.
        for(int i=0; i< flags.size(); i++)
        	flags.set(i, new Boolean(false));
        
        //-- set the flag for the operators.
        flagOperator = false;
        
        //-- Recursively call the same function to achieve the remaining tasks. If a plan is found for the
        //-- remaining tasks and we have found the maximum number of plans we are allowed, return true
        if (findPlanHelper(tn) && plans.size()>= planNo)
           return true;

        //-- backtrack when cannot get a plan;     
        state.undoEvent(v.delAddEvent);
        
        flags.clear();
        for (int m=0; m < storedFlags.size(); m++)
        	flags.add(storedFlags.get(m));
    }
 
    //-- At last, return false because all the options were tried and none worked.
    return false;
  }

  
  /** This function returns the planning domain.
   *
   *  @return
   *          the current planning domain.
  */
  public static Domain getDomain()
  {
    return domain;
  }

/** This function returns the current state of the world.
   *
   *  @return
   *          the current state of the world.
  */
  public static State getState()
  {
    return state;
  }

  /** This function is used to initialize the planning algorithm.
   *
   *  @param domainIn
   *          the planning domain.
   *  @param stateIn
   *          the initial state of the world.
  */
  public static void initialize(Domain domainIn, State stateIn)
  {
    domain = domainIn;
    state = stateIn;
  }
}
