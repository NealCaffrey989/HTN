package JSHOP2;

/** Each method at run time is represented as a class derived from this
 *  abstract class.
 *
 *  @author Okhtay Ilghami
 *  @author <a href="http://www.cs.umd.edu/~okhtay">http://www.cs.umd.edu/~okhtay</a>
 *  @version 1.0.3
*/
import java.util.Vector;

public abstract class Method extends DomainElement
{
  /** An array of task lists to any of which this method can decompose
   *  its associated task given that the corresponding precondition is
   *  satisfied.
  */
  private TaskList[] subs;
    
  /** An array of time constraints associated with the subtasks
    */
  private Vector<Vector<TimeConstraint>> tcls;

  /** To initialize the method.
   *
   *  @param head
   *          head of the method.
  */
  public Method(Predicate head)
  {
    super(head);
  }

  /** To get the label of a given branch of this method.
   *
   *  @param which
   *          the branch the label of which is to be returned.
   *  @return
   *          the label for that branch.
  */
  public abstract String getLabel(int which);

  /** To get the possible subtasks of the decompositions for this method.
   *
   *  @return
   *          an array subtasks of possible decompositions.
  */
  public TaskList[] getSubs()
  {  
    return subs;
  }

  /** To get the possible time constraints of the decomposition for this method.
   * 
   *  @return 
   *         a array time constraints of possible decompositions 
   */
  public Vector<Vector<TimeConstraint>> getTcls()
  {
	  return tcls; 
  }
  
  /** To set the possible decompositions of this method.
   *
   *  @param subsIn
   *          an array of possible decompositions.
  */
  public void setSubs(TaskList[] subsIn)
  {
      subs = subsIn;
  }
  
  /** To set the time constraint set of the possible decompositions for this method.
   *
   *  @param subsIn
   *          an array of possible decompositions.
  */
  public void setSubTcls(Vector<Vector<TimeConstraint>> tclsIn)
  {
	  tcls = tclsIn;
  }  
}
