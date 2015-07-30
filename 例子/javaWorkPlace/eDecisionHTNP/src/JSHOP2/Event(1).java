package JSHOP2;

import java.util.Vector;

/**
 *   Event: Store the class that represent an event.
 *   Event occurs at some time instance and changes
 *   the value of some predicate (T/F) in the state.
 */
  public class Event {
	/* the atom which is deleted from the state or added to it 
	 **/
	private Predicate p;
	
   /** if the flag=true, then add the atom to the state when trigger the event;
	* else if the flag=false, then delete the atom from the state when trigger the event;  
	*/
	private boolean flag;
	
   /**
	* the time when the event occur after the time of the current state
	*/
	private Term time;
	
   /**
	* initialize the event 
	*/
	public Event (Predicate pIn, boolean flagIn, Term timeIn)
	{
	   p =  pIn;
	   flag = flagIn;
	   time = timeIn;
	}
	
	/**
	 * @param s 
	 *      the state of the world
	 * @param delAdd
	 *      An array of size 2 to store the atoms deleted and added to the current state of
     *  the world after triggering the events in the event queue 
	 * @return
	 *      <true>
	 *      the event can be applied; 
	 *      <false>
	 *      else the event cannot be applied; 
	 */
	public boolean applyEvent (State s, Vector[] delAdd)
	{
		//-- delete the predicate from the state;
		if(flag == false)
		{			
			//-- If the resulting atom is protected in the current state of the world,
		    //-- it can not be deleted, and therefore the operator associated with this
		    //-- atomic delete/add element can not be applied. Therefore, return false.
		    if (s.isProtected(p))
		      return false;

		    //-- To store the index of the deleted atom.
		    int index;

		    //-- Try to delete the atom from the current state of the world.
		    //-- The predicate exits, delete it 
		    if ((index = s.delPredicate(p)) != -1)
		    {
		      //-- If the atom was really deleted from the current state of the world
		      //-- (i.e., it was there before), add it to the list of deleted atoms
		      //-- so that in case of a backtrack it can be added back. Also keep track
		      //-- of where the atom was, so that it can be added back exactly where it
		      //-- was. This is important because new bindings are calculated as they
		      //-- are needed (as opposed to calculating all of them in advance and
		      //-- returning them one-by-one), and therefore if a backtrack happens,
		      //-- the data structures should look exactly as they were before the
		      //-- backtracked decision (to apply the operator this atomic delete/add
		      //-- element is associated with) was made.
		    	
		      //-- the delAdd[0] store the predicate and the position where it was deleted
		      delAdd[0].add(new NumberedPredicate(p, index));	
		      return true;
		    }
		    //-- the atom does not exit;
		    else
		    	return false;
		}
		//-- when triggering the event, add the atom to the state; 
		else
		{
		    //-- Try to add the atom to the current state of the world.
		    if (s.addPredicate(p))
		      //-- If the atom was really added to the current state of the world
		      //-- (i.e., it wasn't there before), add it to the list of added atoms
		      //-- so that in case of a backtrack it can be retracted.
		      delAdd[1].add(p);
		    return true;
		}	 
	}
	
	
	public void setAtom(Predicate pIn)
	{
		p = pIn;
	}
	
	public Predicate getAtom()
	{
		return p;
	}
	
    /** Whether this event is "negative" (delete the atom)
     *  or "positive" (add the atom) 
     * */
    public void setFlag(boolean b)
    {
	  flag = b;
    }

    public boolean getFlag() {
		return flag;
    }

    /* Set the (continuous) time instance at which this event occurs */
    public void setTime(double timeIn) {
		time = new TermNumber(timeIn);
    }

    public double getTime() {
    	double retVal;
    	retVal = ((TermNumber)time).getNumber();
		return retVal;
	}
    
    public Event applySubstitution(Term[] bindings)
    {
    	Predicate preIn;
    	Term timeIn;
    	preIn = p.applySubstitution(bindings);
        timeIn = time.bind(bindings);
        Event e = new Event(preIn, flag, timeIn);
        return e;
    }
    
    /** To set the number of variables in this atomic for the event.
     */
     public void setVarCount(int varCount)
     {
       p.setVarCount(varCount);
     }
    
    
    /** This function produces Java code to create this atomic delete/add
     *  element.
    */
    public String toCode()
    {
      String s = "";
      s = "new Event (" + p.toCode() + "," + flag + "," + time.toCode() + " )";       
      return s;
    }
	
	
	

}
