package JSHOP2;

import java.util.Vector;

/** Each operator at run time is represented as a class derived from this
 *  abstract class.
 *
 *  @author Okhtay Ilghami
 *  @author <a href="http://www.cs.umd.edu/~okhtay">http://www.cs.umd.edu/~okhtay</a>
 *  @version 1.0.3
*/
public abstract class Operator extends DomainElement
{
  /** Represents the add list of instantaneous effects in case it is a real list and not a variable.
  */
   private DelAddElement[] instantAdd;
  
  /** Represents the delete list in case it is a real list and not a variable.
   */
   private DelAddElement[] instantDel;
   
  /** Represents the delete list in case it is a variable (The integer value
   *  represents variable's index), otherwise it is -1.
   */
   private int delVarIdx;

  /** Represents the add list in case it is a variable (The integer value
   *  represents variable's index), otherwise it is -1.
   */
   private int addVarIdx;
  
  /** Represents the delete list of events for the delayed effects in case it is a real list and not a variable.
   */
   private Event[] delayedDel;
   
  /** Represents the add list of events for the delayed effects in case it is a real list and not a variable.
   */
   private Event[] delayedAdd;
   
  /** the duration of this operator.
   */
   private Term duration; 
  
  /** Cost of this operator.
  */
   private Term cost;
   

  /** To initialize the operator.
   *
   *  @param head
   *          head of the operator.
   *  @param instantDelVarIdxIn
   *          the index of the delete list as a variable, -1 if the delete list
   *          is not a variable.
   *  @param instantAddVarIdxIn
   *          the index of the add list as a variable, -1 if the add list is
   *          not a variable.
   *  @param delayedDelVarIdxIn
   *          the index of the delete list as a variable, -1 if the delete list
   *          is not a variable.
   *  @param delayedAddVarIdxIn
   *          the index of the add list as a variable, -1 if the add list is
   *          not a variable.
   *  @param costIn
   *          the cost of the operator.
  */
  public Operator(Predicate head, int instantDelVarIdxIn, int instantAddVarIdxIn, Term durationIn,Term costIn)
  {
    super(head);

    delVarIdx = instantDelVarIdxIn;
    addVarIdx = instantAddVarIdxIn;
    
    duration = durationIn;
    cost = costIn;
  }

/** This function is used to apply this operator to a given state;
 * If the task can be applied, return true;
 * else return false;
   *
   *  @param binding
   *          the current binding.
   *  @param s
   *          current state of the world.
   *  @param delAdd
   *          a 6-member array of type <code>Vector</code> used to keep track
   *          of the atoms of the instantaneous effects, protections and the 
   *          delayed effects deleted from and added to the current state of
   *          the world as the result of applying this operator. This data can
   *          be used later in case of a backtrack to undo these changes.
   *  @return
   *          <code>true</code> if the operator was applicable,
   *          <code>false</code> otherwise. An operator is not applicable when
   *          at least one of the atoms it tries to delete is protected.
  */
  public boolean apply(Term[] binding, State s, TaskNet tn, TaskAtom t,  Vector[] delAdd)
  {
    //-- Initialze the 'delAdd' array.
    delAdd[0] = new Vector();
    delAdd[1] = new Vector(); //--store the predicate and the position where the predicate is deleted 
    delAdd[2] = new Vector();
    delAdd[3] = new Vector();
    delAdd[4] = new Vector();
    delAdd[5] = new Vector();   
    delAdd[6] = new Vector();

    //-- If the delete list of the instantaneous effects is a variable,
    if (delVarIdx != -1)
    {
      //-- Find what that variable is bound to.
      List l = ((TermList)binding[delVarIdx]).getList();

      //-- Iterate over the elements of the delete list.
      while (l != null)
      {
        //-- Each element of the list should be a Predicate. Make that
        //-- Predicate.
        Predicate p = ((TermList)l.getHead()).toPredicate(0);

        //-- If this atom is protected in the current state of the world, it
        //-- can not be deleted, and therefore this operator can not be
        //-- applied. Therefore, return false.
        if (s.isProtected(p))
          return false;

        //-- To store the index of the deleted atom.
        int index;

        //-- Try to delete the atom from the current state of the world.
        if ((index = s.delPredicate(p)) != -1)
          //-- If the atom was really deleted from the current state of the
          //-- world (i.e., it was there before), add it to the list of deleted
          //-- atoms so that in case of a backtrack it can be added back. Also
          //-- keep track of where the atom was, so that it can be added back
          //-- exactly where it was. This is important because new bindings are
          //-- calculated as they are needed (as opposed to calculating all of
          //-- them in advance and returning them one-by-one), and therefore if a
          //-- backtrack happens, the data strucutures should look exactly as
          //-- they were before the backtracked decision to apply this operator
          //-- was made.
          delAdd[0].add(new NumberedPredicate(p, index));

        l = l.getRest();
      }
    }
    
    //-- If the delete list of the instantaneous effects is a real list, delAdd[0] store the delete atoms;
    else
    {
      //-- For each delete/add element in the instantaneous delete list,
      //-- the delAdd store the predicate and the position where it is deleted
      for (int i = 0; i < instantDel.length; i++)
        //-- Try to delete the atom from the current state of the world.
        if (!instantDel[i].delInstantEffects(s, binding, delAdd))
          //-- If the atom can not be deleted (i.e., it is protected), return
          //-- false because this operator can not be applied.
            return false;
    }

    //-- If the add list of the of the instantaneous effects is a variable,
    if (addVarIdx != -1)
    {
      //-- Find what that variable is bound to.
      List l = ((TermList)binding[addVarIdx]).getList();

      //-- Iterate over the elements of the add list.
      while (l != null)
      {
        //-- Each element of the list should be a Predicate. Make that
        //-- Predicate.
        Predicate p = ((TermList)l.getHead()).toPredicate(0);

        //-- Try to add the resulting (presumably ground) atom to the current
        //-- state of the world.
        if (s.addPredicate(p))
          //-- If the atom was really added to the current state of the world
          //-- (i.e., it wasn't there before), add it to the list of the added
          //-- atoms so that in case of a backtrack it can be retracted.
          delAdd[1].add(p);

        l = l.getRest();
      }
    }
    
    //-- If the add list of the instantaneous effects is a real list,
    else
    {
      //-- For each delete/add element in the add list, delAdd[1]
      for (int i = 0; i < instantAdd.length; i++)
        //-- Add it to the current state of the world.
        instantAdd[i].addInstantEffects(s, binding, delAdd);
    }
    
	//--get the duration of the operator
	double dur= getDuration(binding); 
    

    //-- If the delete list of the delayed effects is a real list and is not null,
	//-- add it to the event queue of the state. the delAdd[2] is used.
	if (delayedDel != null)
    {
      //-- For each element in the delete list of the delayed effects,
      for (int i = 0; i < delayedDel.length; i++)
      {
          //-- initialize the event;
    	  Event e = ((Event) delayedDel[i]).applySubstitution(binding);
    	  //--add it to the event queue of the current state of the world.
    	  //-- the added events are stored using delAdd[2];
    	  if(s.addEvent(e))
    		delAdd[2].add(e);
      }
    }
    
    //-- If the  add list of the delayed effects is a real list and is not null;
	//-- add it to the event queue of the state. the delAdd[3] is used.
	if (delayedAdd != null)
    {
      //-- For each  element in the add list of the delayed effects,
      //-- The delAdd[3] is used.
      for (int i = 0; i < delayedAdd.length; i++)
      {
          //-- Add it to the event queue of the current state of the world.
    	  //-- the added events are stored using delAdd[3]
    	  Event e = ((Event) delayedAdd[i]).applySubstitution(binding);
    	  if (s.addEvent(e))
    		 delAdd[3].add(e);      
      }
    }
    
    //-- store the time constraint matrix using delAdd[4];
	//-- When the operator is not applicable, it is used to refresh the time constraint set;
	int size = tn.getStn().getNumberOfPoints();
    double[][] tcMatrixStore;
    tcMatrixStore = new double[size][size];
    tn.getStn().getTcMatrix(tcMatrixStore);
    
    for(int i=0; i < size; i++)
    	for(int j=0; j < size; j++)
    		delAdd[4].add(tcMatrixStore[i][j]);
		
	//-- check the consistency of the simple time network, after adding startTp = state.t
    //-- and endTp = state.t + duration; 
	TimePoint startTp, endTp, tp;
	TimeConstraint startPostTc, endPostTc;
	startTp = new TimePoint(t, true);
	endTp = new TimePoint(t, false);
		
	//-- the time constraint representing the start time of this operator;
	TimeConstraint startTc, endTc;
	startTc = new TimeConstraint(startTp, TimePoint.referenceTimePoint , s.getTime(), s.getTime());
	endTc = new TimeConstraint(endTp,TimePoint.referenceTimePoint, s.getTime()+ dur, s.getTime() + dur);
	
	double[] value;	
	//-- the time constraint for start time point cannot be added;
	value = new double[2];
	if (!(tn.getStn().addTimeConstraint(startTc, value)))
		return false;
	
	value = new double[2];
	if(!(tn.getStn().addTimeConstraint(endTc, value)))
		return false;
	
	//-- delete the primitive task atom from the task net, but do not delete the time constraints defined on 
	//-- the start time point and end time point, 
    //-- store the deleted task using delAdd[5], and its position using delAdd[6];
	//-- get the position of the primitive task atom
	int position = tn.getTasks().indexOf(t);
	if (tn.getTasks().remove(t))
	{
		//-- store the task atom
		delAdd[5].add(t);
		//-- store the index of this task atom is the tasks for the task net;
		delAdd[6].add(position);
	}
	else
		return false;
	
	//-- at last, return true;
    return true;
  }
   

  /** To get the duration of this operator.
  *
  *  @param binding
  *          the binding to be applied to the duration term.
  *  @return
  *          the duration of applying this operator.
  */
  public double getDuration(Term[] binding)
  {
    return ((TermNumber)duration.bind(binding)).getNumber();
   }
 
  
  /** To get the cost of this operator.
   *
   *  @param binding
   *          the binding to be applied to the cost term.
   *  @return
   *          the cost of applying this operator.
  */
  public double getCost(Term[] binding)
  {
    return ((TermNumber)cost.bind(binding)).getNumber();
   }

  
  /** To set the add list of the instantaneous effects.
   *
   *  @param instantAddIn
   *          the add list of the instantaneous effects.
  */
  public void setInstantAdd(DelAddElement[] instantAddIn)
  {
    instantAdd = instantAddIn;
  }

  /** If add list of the instantaneous effects is a variable, 
   *  to set it. 
  *
  *  @param addVarIdxIn
  *         the index of the variable for the add list of the instantaneous effects.
  */
  public void setAddVarIdx(int addVarIdxIn)
  {
     addVarIdx = addVarIdxIn;
  }
   
  /** To set the delete list of the instantaneous effects.
   *
   *  @param instantDelIn
   *          the delete list of the instantaneous effects.
  */
  public void setInstantDel(DelAddElement[] instantDelIn)
  {
    instantDel = instantDelIn;
  }
  
  /** If delete list of the instantaneous effects is a variable, 
  *  to set it. 
  *
  *  @param delVarIdxIn
  *         the index of the variable for the delete list of the instantaneous effects.
  */
  public void setDelVarIdx(int delVarIdxIn)
  {
    delVarIdx = delVarIdxIn;
  }  
  
  /** To set the add list of events for the delayed effects.
   *
   *  @param delayedAddIn
   *          the add list of the delayed effects.
  */
   public void setDelayedAdd(Event[] delayedAddIn)
   {
    delayedAdd = delayedAddIn;
   }

   /** To set the delete list of events for the delayed effects.
    *
    *  @param delayedDelIn
    *          the delete list of the delayed effects.
    */
   public void setDelayedDel(Event[] delayedDelIn)
   {
     delayedDel = delayedDelIn;
   }   
}
