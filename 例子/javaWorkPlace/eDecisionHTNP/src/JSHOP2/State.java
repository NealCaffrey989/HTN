package JSHOP2;

import java.util.Iterator;
import java.util.Vector;
import java.util.ArrayList;

/** This class is used to represent the current state of the world.
 *
 *  @author Okhtay Ilghami
 *  @author <a href="http://www.cs.umd.edu/~okhtay">http://www.cs.umd.edu/~okhtay</a>
 *  @version 1.0.3
*/
public class State
{
  /** The atoms in the current state of the world as an array of
   *  <code>Vector</code>s. The array is indexed by the possible heads (i.e.,
   *  the constant symbol that comes first) of the possible predicates.
  */
  private Vector<Term>[] atoms;

  /** The axioms in the domain description as a two-dimensional array. The
   *  array is indexed first by the head of the predicates each axiom can prove
   *  and second by the axioms themselves.
  */
  private Axiom[][] axioms;
  

  /** The protections in the current state of the world as an array of
   *  <code>Vector</code>s. The array is indexed by the heads of protected
   *  predicates.
  */
  private Vector<NumberedPredicate>[] protections;
  
  /**the event queue of the state, the event of the state is sorted by the time stamp
   * of the event, from little to more;
   * if the events with the same time stamp, the event representing the delete list of
   * the delayed effects is before the event representing the add list of the delayed effects 
  */
  private Vector<Event> eventQueue = new Vector<Event>();
  
  /**
   * the time stamp of the state
   */
  private double time;
  
  /** The atoms in the current state of the world as an array of
   *  <code>Vector</code>s. The array is indexed by the possible heads (i.e.,
   *  the constant symbol that comes first) of the possible predicates.
  */

  /** To initialize the state of the world.
   *
   *  @param size
   *          the number of possible heads of predicates (i.e., the number of
   *          constant symbols that can come first in a predicate).
   *  @param axiomsIn
   *          the axioms in the domain description as a two-dimensional array.
   *          The array is indexed first by the head of the predicates each
   *          axiom can prove and second by the axioms themselves.
  */

  public State(int size, Axiom[][] axiomsIn, Vector<Event> eventListIn, double timeIn)
  {
    //-- Initialize the arrays that represent the atoms and protections in the
    //-- current state of the world.
    atoms = new Vector[size];

    protections = new Vector[size];

    for (int i = 0; i < size; i++)
    {
      atoms[i] = new Vector<Term>();
      protections[i] = new Vector<NumberedPredicate>();
    }

    axioms = axiomsIn;
    
    eventQueue = eventListIn;
       
    time=timeIn;
    
  }

  /** To add a predicate to the current state of the world.
   *
   *  @param p
   *          the predicate to be added.
   *  @return
   *          <code>true</code> if the predicate was added (i.e., it was not
   *          already in the current state of the world), <code>false</code>
   *          otherwise.
  */
  public boolean addPredicate(Predicate p)
  {
    //-- Find the right Vector to add this predicate to.
    
    //-- First look for the predicate in the Vector. If it is already there,
    //-- do nothing and return false.
    for (Term t : atoms[p.getHead()]) {
      if (p.equalParams(t))
        return false;
    }

    //-- Add the predicate and return true.
    atoms[p.getHead()].add(p.getParam());

    return true;
  }

  /** To protect a given predicate in the current state of the world.
   *
   *  @param p
   *          the predicate to be protected.
   *  @return
   *          this function always returns <code>true</code>.
  */
  public boolean addProtection(Predicate p)
  {
    // -- First, find the appropriate Vector to add the protection to.

    // -- If the predicate is already protected, just increase the protection
    // -- counter.
    for (NumberedPredicate np : protections[p.getHead()]) {
      if (p.equals(np.getParam())) {
        np.inc();
        return true;
      }
    }

    // -- If this is the first time this predicate is being protected, add it
    //-- to the Vector.
    protections[p.getHead()].add(new NumberedPredicate(p));
    return true;
  }
  
 
 /** trigger all the event with the lowest time stamp in the current state.
  *
  *  @return
  *          <code>true</code> if the events of the lowest time stamp was triggered , 
  *          <code>false</code>
  *          otherwise.
  */ 
  public boolean triggerNextEvents(Vector[] delAdd)
  {
	 //-- Initialze the 'delAddEvent' array.
	//--store the predicate and the position where the predicate is deleted
     delAdd[0] = new Vector();
	 delAdd[1] = new Vector();  
	 delAdd[2] = new Vector();
	 delAdd[3] = new Vector();
	 delAdd[4] = new Vector();
	 
	 //--get the latest time of events, which is used to advance the state 
	 double advancedTime = 0;
	 
	 if (eventQueue.size()>0)
	    advancedTime = eventQueue.get(0).getTime();
	 
	 Event e;
	 
	 while (eventQueue.size() > 0)
	 {
		 e = eventQueue.firstElement();
		 
		 if (e.getTime() <= advancedTime)
		 {
			 //--the delAdd[0] store the deleted atom and the position where it is deleted;
			 //--the delAdd[1] store the added atom.
			 
			 //-- if there a event cannot be triggered;
			 //-- the event is triggered to delete a predicate;
			 if (e.getFlag() == false)
			 {
				 int index = delPredicate(e.getAtom());
				 //-- the atom cannot be deleted;
				 if (index == (-1))
					 return false;
				 //-- the event can be triggered in the current state;
				 else 
				 {
					 //-- delete the event from the event queue
					 eventQueue.remove(e);
					 //-- delAdd[0] stores the triggered event
					 delAdd[0].add(e);
					 delAdd[1].add(new NumberedPredicate(e.getAtom(), index));
				 }
             }
			 //-- the event, when it is triggered, is to add a predicate;
			 else
			 {
				 if(addPredicate(e.getAtom()))
				 {
					 eventQueue.remove(e);
					 //-- delAdd[2] stores the trigger event; 
					 delAdd[2].add(e);
					 delAdd[3].add(e.getAtom());
				 } 
			 }

		 }
		 else 
			 break ;
	 }
	 
	 //-- advance the time stamp of the state;
	 time += advancedTime;
	 delAdd[4].add(advancedTime);
	 
	 //-- modify the time stamp of each event in the resulted event queue;
	 for(int index=0; index< eventQueue.size(); index++)
	 { 
		 e = eventQueue.get(index);
		 e.setTime(e.getTime() - advancedTime);
	 }
	 
	 //-- all the event with the advanced time stamp can be triggered;
	 return true;
  }
  

  /** To empty the world state.
  */
  public void clear()
  {
    for (int i = 0; i < atoms.length; i++)
    {
      atoms[i].clear();
      protections[i].clear();
    }
  }

  /** To delete a predicate from the current state of the world.
   *
   *  @param p
   *          the predicate to be deleted.
   *  @return
   *          the index of the predicate that was deleted in the
   *          <code>Vector</code> if the predicate was deleted (i.e., it
   *          existed in the current state of the world), -1 otherwise. This
   *          index is used in case of a backtrack to undo this deletion by
   *          inserting the deleted predicate right back where it used to be.
  */
  public int delPredicate(Predicate p)
  {
    Term t;

    //-- Find the right Vector to delete this predicate from.
    Vector<Term> vec = atoms[p.getHead()];

    //-- If predicate is found, delete it and return its index.
    for (int i = 0; i < vec.size(); i++)
    {
      t = (Term)vec.get(i);

      if (p.equalParams(t))
      {
        vec.remove(i);
        return i;
      }
    }

    //-- There was nothing to delete, so return -1.
    return -1;
  }

  /** To unprotect a given predicate.
   *
   *  @param p
   *          the predicate to be unprotected.
   *  @return
   *          <code>true</code> if the protected is unprotected successfully,
   *          <code>false</code> otherwise (i.e., when the predicate was not
   *          protected before).
  */
  public boolean delProtection(Predicate p)
  {
    NumberedPredicate np;

    //-- First, find the appropriate Vector to delete the protection from.
    Iterator<NumberedPredicate> e = protections[p.getHead()].iterator();

    //-- Look for the protection.
    while (e.hasNext())
    {
      np = e.next();

      //-- If it is found,
      if (p.equals(np.getParam()))
      {
        //-- Decrease the protection counter for this predicate.
        if (!np.dec())
          //-- If the counter drops to zero, remove the protection completely.
          e.remove();

        return true;
      }
    }

    //-- Nothing was there to delete, so return false.
    return false;
  }
  
  /**add the event representing the delete list of the delayed effects to
   * the event queue of current state.
   * @param e
   * the event representing the delete list of the delayed effects
   * @return true
   */
  public boolean addEvent(Event eIn)
  {	 
	if (eventQueue.size() == 0 )
	{
		eventQueue.add(eIn);
	    return true;
	}  
	    
    //-- Find the right position to add this event representing a deleted atom.
	//-- the new event is enqueued to the tail of the events with the same time stamp
	Event e;
	
	//-- if the event representing to delete a atom, add it to the last deleted event with the same time stamp;
	if (eIn.getFlag() == false)
	{
	    for (int i=0; i<eventQueue.size(); i++)
	    {
	    	e = eventQueue.get(i);
	     	   if(((e.getTime() == eIn.getTime())&&(e.getFlag()==true))
	     	 		  ||(e.getTime() > eIn.getTime()))
	     	 	   {
	     	 		  eventQueue.add(i, eIn);
	     	 		  return true;
	     	 	   }
	    }	    
	    eventQueue.add(eIn);
	    return true;
	}
	//-- the event representing to add a atom, add it to the end of the added event with the same time stamp;
	else
	{   int i;
	    for ( i=0; i<eventQueue.size(); i++)
	    {
	    	e = eventQueue.get(i);
	     	   if(e.getTime() > eIn.getTime())
	     	 	   {
	     	 		  eventQueue.add(i, eIn);
	     	 		  return true;
	     	 	   }
	    }	
	    
	    eventQueue.add(eIn);
	    return true;
	}
  }
    
  
  /** To check if a predicate is protected.
   *
   *  @param p
   *          the predicate to be checked.
   *  @return
   *          <code>true</code> if the predicate is protected,
   *          <code>false</code> otherwise.
  */
  public boolean isProtected(Predicate p)
  {
    //-- First, find the appropriate Vector to look for the protection.
    //-- Iterate over the Vector to find the protection.
    for (NumberedPredicate np : protections[p.getHead()])
    {
      if (p.equals(np.getParam()))
        return true;
    }

    return false;
  }

  /** To initialize and return the appropriate iterator when looking
   *  for ways to satisfy a given predicate.
   *
   *  @param head
   *          the index of the constant symbol that is the head of the
   *          predicate (i.e., that comes first in the predicate).
   *  @return
   *          the iterator to be used to find the satisfiers for this
   *          predicate.
  */
  public MyIterator iterator(int head)
  {
    return new MyIterator(atoms[head]);
  }

  /** This function returns the bindings that can satisfy a given precondition
   *  one-by-one.
   *
   *  @param p
   *          the predicate to be satisfied.
   *  @param me
   *          the iterator that keeps track of where we are with the satisfiers
   *          so that the next time this function is called, we can take off
   *          where we stopped last time.
   *  @return
   *          the next binding as an array of terms indexed by the indeices of
   *          the variable symbols in the given predicate.
  */
  public Term[] nextBinding(Predicate p, MyIterator me)
  {
    Term[] nextB;

    Term[] retVal;

    Term t;

    //-- If we are still looking into the atoms to prove the predicate (i.e.,
    //-- we have not started looking into the axioms),
    if (me.whichAxiom == -1)
    {
      //-- Iterate over the appropriate Vector to find atoms that can satisfy
      //-- the given predicate.
      while (me.index < me.vec.size())
      {
        t = (Term)me.vec.get(me.index++);
        retVal = p.findUnifier(t);

        //-- If this atom can satisfy the given predicate, return the binding
        //-- that unifies the two.
        if (retVal != null)
          return retVal;
      }

      //-- We have already looked at all the atoms that could possibly satisfy
      //-- the predicate. From now on, we will look at the axioms only.
      me.whichAxiom = 0;
    }

    while (true)
    {
      //-- If we need to look at a new axiom,
      while (me.ax == null)
      {
        //-- If there are no more axioms to be looked at, return null.
        if (me.whichAxiom == axioms[p.getHead()].length)
          return null;

        //-- Try the next axiom whose head matches the head of the given
        //-- predicate.
        me.ax = axioms[p.getHead()][me.whichAxiom++];

        //-- Try to unify the axiom's head with the predicate.
        me.binding = me.ax.unify(p);

        //-- If the two can not be unified,
        if (me.binding == null)
          //-- Try to look for the next axiom.
          me.ax = null;
        else
        {
          //-- Start with the first branch of this axiom.
          me.index = 0;
          //-- No branch has been satisfied yet, so set this variable to false.
          me.found = false;
        }
      }

      //-- Iterate on all the branches of this axiom.
      for (; me.index < me.ax.getBranchSize(); me.index++)
      {
        //-- If this is the first time this branch is considered, get the
        //-- iterator for the precondition of this branch.
        if (me.pre == null)
          me.pre = me.ax.getIterator(me.binding, me.index);

        //-- Try the next satisfier for the precondition of this branch of this
        //-- axiom. If there is a next satisfier,
        while ((nextB = me.pre.nextBinding()) != null)
        {
          //-- Merge the two bindings.
          Term.merge(nextB, me.binding);

          //-- Calculate the instance of the axiom we are using.
          Predicate groundAxiomHead = me.ax.getHead().applySubstitution(nextB);

          //-- Try to unify the axiom and the predicate.
          retVal = p.findUnifier(groundAxiomHead.getParam());

          //-- If there is such unifier, return it.
          if (retVal != null)
          {
            //-- The further branches of this axiom must NOT be considered even
            //-- if this branch fails because there has been at least one
            //-- satisfier for this branch of the axiom. Set this variable to
            //-- true to prevent the further branches of this axiom from being
            //-- considered.
            me.found = true;

            return retVal;
          }
        }

        //-- Try the next branch of this axiom.
        me.pre = null;

        //-- According to the semantics of the axiom branches in JSHOP2, second
        //-- branch is considered only when there is no binding for the first
        //-- branch, the third branch is considered only when there is no
        //-- binding for the first and second branches, etc. Therefore, if one
        //-- of the branches of this axiom has already returned a satisfier,
        //-- the other branches should be ignored.
        if (me.found)
          break;
      }

      //-- Try the next axiom.
      me.ax = null;
    }
  }

  /** This function is used to print the current state of the world.
  */
  public void print()
  {
    for (int i = 0; i < atoms.length; i++)
    {
      for (Term t : atoms[i]) 
      {
        (new Predicate(i, 0, t)).print();
      }

      System.out.println();
    }

    System.out.println("------");
  }


  /**
   * Returns an ArrayList of strings that represents the state.  Used
   * in conjunction with JSHOP2GUI
   * (Added 5/28/06)
   * @return
   *    - An ArrayList<String> representing the state
   */
  public ArrayList<String> getState() {
    ArrayList<String> retval = new ArrayList<String>();
    for (int i = 0; i < atoms.length; i++) 
    {
      for (Term t : atoms[i]) 
      {
        retval.add((new Predicate(i, 0, t)).toString());
      }
    }
    return retval;
  }


  /**
   * This function is used, in case of a backtrack, to undo the changes that
   * were made to the current state of the world because of the backtracked
   * decision, when apply an operator
   * 
   * @param delAdd
   *          a 9-member array of type <code>Vector</code>. These six
   *          members are the deleted atoms, the added atoms, the deleted
   *          protections, the added protections, the delete list of the delayed effects
   *          and the add list of the delayed effects respectively.
   */
  public boolean undoOperator(TaskNet tn, Vector[] delAdd)
  {  
	  //-- add the primitive task associating to the operator, which has been delete;
      TaskAtom t;
      Integer position;
      if (delAdd[6].size() >0)
      {
    	  position = (Integer)delAdd[6].get(0);
          if (delAdd[5].size() > 0)
          {
              t = (TaskAtom) delAdd[5].get(0);
              tn.addTask(t, position);
          }
      }
 
      //-- refresh the time constraint matrix;
      int size = tn.getStn().getNumberOfPoints();
      double[][] tcMatrix;
      tcMatrix = new double[size][size];
      
      //-- change the list of value to the time constraint matrix;
      int sizeOfList = delAdd[4].size();
      double value;
      int m, n;
      for(int i=0; i< sizeOfList; i++)
      {
	      value = (Double)delAdd[4].get(i);
	      
	      m = (int)(i / size);
	      n = i - size*m;
	      tcMatrix[m][n] = value;
      }
      tn.getStn().setTcMatrix(tcMatrix);	
      

      //-- refresh the state using the following code;
      Iterator e;
      //-- delete the event list which is the add list representing the delayed effects;
      e = delAdd[3].iterator();
      while (e.hasNext())
    	  eventQueue.remove((Event)e.next());
    
      //-- delete the event list which is the delete list representing the delayed effects;
      e = delAdd[2].iterator();
      while (e.hasNext())
       	  eventQueue.remove((Event)e.next());
    
      //-- Since when an operator is applied, first the predicates in its delete
      //-- list are deleted and then the predicates in its add list are added,
      //-- when that application is undone, first the added predicates should be
      //-- deleted and then the deleted predicates should be added.

      //-- Deleting the added predicates.
      e = delAdd[1].iterator();
      while (e.hasNext())
          if (delPredicate((Predicate)e.next()) == -1)
    	     return false;


      //-- Adding the deleted predicates, exactly where they were deleted from.
      NumberedPredicate np;
      for (int i = delAdd[0].size() - 1; i >= 0; i--)
      {
          np = (NumberedPredicate)delAdd[0].get(i);
          //-- add the deleted predicates, to the position where they deleted from the vector
          atoms[np.getHead()].add(np.getNumber(), np.getParam());
      }
    
      //-- the change by the apply operator is undo, at last return true;
      return true;
  }
  
  /**
   * This function is used, in case of a backtrack, to undo the changes that
   * were made to the current state of the world because of the backtracked
   * decision, when trigger the next event in the event queue 
   * 
   * @param delAdd
   *          a 2-member array of type <code>Vector</code>. These two
   *          members are the deleted atoms and the added atoms of the delayed
   *          delete effects respectively.
   */
  public void undoEvent(Vector[] delAdd)
  { 
	  // -- undo the advanced time for the remained event list;
      Event event;
      double advancedTime = (Double)(delAdd[4].get(0));
	  for(int i=0; i < eventQueue.size(); i++)
	  {
		  event = eventQueue.get(i);
		  event.setTime(event.getTime() + advancedTime);
	  }
	  
	  Iterator e;
	  NumberedPredicate np;
	  
	  //--  for the event, representing adding a predicate when triggering it;
	  //-- Deleting the added predicates.
	  Predicate p;
	  for (int i=delAdd[3].size()-1; i>=0; i--)
	  {
		  p = (Predicate)delAdd[3].get(i);
		  event = (Event)delAdd[2].get(i);
		  //-- delete the predicate, which has been 
		  delPredicate(p);
		  addEvent(event);
	  }
	  
	  
	  //-- Adding the deleted predicates result of triggering the event,
	  //-- exactly where they were deleted from.
	  for (int i = delAdd[1].size() - 1; i >= 0; i--)
	  {
	     np = (NumberedPredicate)delAdd[1].get(i);
	     atoms[np.getHead()].add(np.getNumber(), np.getParam());
	     
	     event = (Event)delAdd[0].get(i);
	     addEvent(event);
	  }  
  }
  
  /**
   * get the time stamp of the state
   * @return time stamp
   */
  public double getTime()
  {
	  return time;
  }
  
}
