package JSHOP2;

import java.util.LinkedList;

/** This class represent a plan as a <code>LinkedList</code> of ground
 *  instances of operators.
 *
 *  @author Okhtay Ilghami
 *  @author <a href="http://www.cs.umd.edu/~okhtay">http://www.cs.umd.edu/~okhtay</a>
 *  @version 1.0.3
*/
/**
 * the plan element is consisted of the start time and the name of the operator
 */
class PlanElement
{
	double startTime;
	
	double duration;
	
	Predicate op;
	
	/**construct a plan element
	 * @param opIn
	 *        the operator of the plan element;
	 * @param startTime
	 *        the time when the operator start to be executed
	*/
	public PlanElement(Predicate opIn, double startTimeIn, double durationIn)
	{
		op=opIn;
		startTime = startTimeIn;
		duration = durationIn;
	}
}

public class Plan
{
  /** The cost of the plan. */
  private double cost;

  /** The new line character in the platform JSHOP2 is running on.
  */
  final static String endl = System.getProperty("line.separator");

  /** The plan as a <code>LinkedList</code> of ground instances of operators.
  */
  private LinkedList<PlanElement> planElements;
  

  /** To initialize the plan to an empty list.
  */
  public Plan()
  {
    planElements = new LinkedList<PlanElement>();
    cost = 0;
  }

  /** This function is used by objects of this class to clone themselves.
   *
   *  @param planElementsIn
   *          the plan elements in the plan.
   *  @param costIn
   *          the cost of the plan.
  */
  private Plan(LinkedList<PlanElement> planElementsIn, double costIn)
  {
	planElements = planElementsIn;
    cost = costIn;
  }

  /** To add an operator instance to the end of the plan.
   *
   *  @param op
   *          the operator the instance of which is being added.
   *  @param binding
   *          the binding to instantiate the operator.
   *  @return
   *          the cost of the operator instance being added.
  */
  public double addPlanElement(Operator op, Term[] binding, double startTimeIn)
  {
	double durationIn;
	durationIn = op.getDuration(binding);
	
    planElements.addLast(new PlanElement(op.getHead().applySubstitution(binding),startTimeIn, durationIn));
    cost += op.getCost(binding);

    return op.getCost(binding);
  }

  /** To clone an object of this class.
  */
  public Object clone()
  {
    return new Plan(new LinkedList<PlanElement>(planElements), cost);
  }

  /** To get the sequence of plan elements represented by this object.
   *
   *  @return
   *          A <code>LinkedList</code> of operator instances in this plan.
  */
  public LinkedList<PlanElement> getPlanElements()
  {
    return planElements;
  }

  /** To remove the operator instance at the end of the plan.
   *
   *  @param opCost
   *          the cost of the operator instance to be removed.
  */
  public void removePlanElement(double opCost)
  {
    planElements.removeLast();
    cost -= opCost;
  }

  /** This function returns a printable <code>String</code> representation of
   *  this plan.
   *
   *  @return
   *          the <code>String</code> representation of this plan.
  */
  public String toString()
  {
    //-- The value to be returned.
    String retVal = "Plan cost: " + cost + endl ;

    //-- Get the names of the operators in this domain.
    String[] primitiveTasks = JSHOP2.getDomain().getPrimitiveTasks();

    //-- Iterate over the operator instances in the plan and print them.
    for (PlanElement p : planElements)
      retVal += "[Op:"+ p.op.toString(primitiveTasks) + ",\t" + "StartTime:" 
      + p.startTime +",\t" + "Duration:" + p.duration + "]" + endl;

    return retVal;
  }
}
