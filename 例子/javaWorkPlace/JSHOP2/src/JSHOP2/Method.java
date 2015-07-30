package JSHOP2;

/** Each method at run time is represented as a class derived from this
 *  abstract class.由领域知识的method类继承，实现这个虚类
 *
 *  @author Okhtay Ilghami
 *  @author <a href="http://www.cs.umd.edu/~okhtay">http://www.cs.umd.edu/~okhtay</a>
 *  @version 1.0.3
*/
public abstract class Method extends DomainElement
{
  /** An array of task lists to any of which this method can decompse
   *  its associated task given that the corresponding precondition is
   *  satisfied.
  */
  private TaskList[] subs;

  /** To initialize the method.
   *
   *  @param head
   *          head of the method.
  */
  public Method(Predicate head)
  {
    super(head);
  }

  /** To get the label of a given branch of this method.这个方法的分支
   *
   *  @param which
   *          the branch the label of which is to be returned.
   *  @return
   *          the label for that branch.
  */
  public abstract String getLabel(int which);

  /** To get the possible decompositions of this method.
   *
   *  @return
   *          an array of possible decompositions.
  */
  public TaskList[] getSubs()
  {
    return subs;
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
}
