package JSHOP2;
import java.util.LinkedList;
import JSHOP2.*;

import java.util.Vector;

public class problem
{
	private static String[] defineConstants()
	{
		String[] problemConstants = new String[16];

		problemConstants[0] = "plane1";
		problemConstants[1] = "plane2";
		problemConstants[2] = "plane3";
		problemConstants[3] = "person1";
		problemConstants[4] = "person2";
		problemConstants[5] = "person3";
		problemConstants[6] = "person4";
		problemConstants[7] = "person5";
		problemConstants[8] = "person6";
		problemConstants[9] = "person7";
		problemConstants[10] = "person8";
		problemConstants[11] = "city0";
		problemConstants[12] = "city1";
		problemConstants[13] = "city3";
		problemConstants[14] = "city4";
		problemConstants[15] = "city2";

		return problemConstants;
	}

	private static void createStatePredicates0(State s)	{
		s.addPredicate(new Predicate(6, 0, new TermList(TermConstant.getConstant(25), TermList.NIL)));
		s.addPredicate(new Predicate(6, 0, new TermList(TermConstant.getConstant(26), TermList.NIL)));
		s.addPredicate(new Predicate(6, 0, new TermList(TermConstant.getConstant(27), TermList.NIL)));
		s.addPredicate(new Predicate(3, 0, new TermList(TermConstant.getConstant(28), TermList.NIL)));
		s.addPredicate(new Predicate(3, 0, new TermList(TermConstant.getConstant(29), TermList.NIL)));
		s.addPredicate(new Predicate(3, 0, new TermList(TermConstant.getConstant(30), TermList.NIL)));
		s.addPredicate(new Predicate(3, 0, new TermList(TermConstant.getConstant(31), TermList.NIL)));
		s.addPredicate(new Predicate(3, 0, new TermList(TermConstant.getConstant(32), TermList.NIL)));
		s.addPredicate(new Predicate(3, 0, new TermList(TermConstant.getConstant(33), TermList.NIL)));
		s.addPredicate(new Predicate(3, 0, new TermList(TermConstant.getConstant(34), TermList.NIL)));
		s.addPredicate(new Predicate(3, 0, new TermList(TermConstant.getConstant(35), TermList.NIL)));
		s.addPredicate(new Predicate(7, 0, new TermList(TermConstant.getConstant(36), TermList.NIL)));
		s.addPredicate(new Predicate(7, 0, new TermList(TermConstant.getConstant(37), TermList.NIL)));
		s.addPredicate(new Predicate(7, 0, new TermList(TermConstant.getConstant(38), TermList.NIL)));
		s.addPredicate(new Predicate(7, 0, new TermList(TermConstant.getConstant(39), TermList.NIL)));
		s.addPredicate(new Predicate(4, 0, new TermList(TermConstant.getConstant(25), new TermList(TermConstant.getConstant(36), TermList.NIL))));
		s.addPredicate(new Predicate(19, 0, new TermList(TermConstant.getConstant(25), new TermList(new TermNumber(159.0), TermList.NIL))));
		s.addPredicate(new Predicate(15, 0, new TermList(TermConstant.getConstant(25), new TermList(new TermNumber(274.0), TermList.NIL))));
		s.addPredicate(new Predicate(12, 0, new TermList(TermConstant.getConstant(25), new TermList(new TermNumber(15412.0), TermList.NIL))));
		s.addPredicate(new Predicate(11, 0, new TermList(TermConstant.getConstant(25), new TermList(new TermNumber(1458.0), TermList.NIL))));
		s.addPredicate(new Predicate(18, 0, new TermList(TermConstant.getConstant(25), new TermList(new TermNumber(5.0), TermList.NIL))));
		s.addPredicate(new Predicate(16, 0, new TermList(TermConstant.getConstant(25), new TermList(new TermNumber(14.0), TermList.NIL))));
		s.addPredicate(new Predicate(13, 0, new TermList(TermConstant.getConstant(25), new TermList(new TermNumber(2618.0), TermList.NIL))));
		s.addPredicate(new Predicate(4, 0, new TermList(TermConstant.getConstant(26), new TermList(TermConstant.getConstant(39), TermList.NIL))));
		s.addPredicate(new Predicate(19, 0, new TermList(TermConstant.getConstant(26), new TermList(new TermNumber(142.0), TermList.NIL))));
		s.addPredicate(new Predicate(15, 0, new TermList(TermConstant.getConstant(26), new TermList(new TermNumber(360.0), TermList.NIL))));
		s.addPredicate(new Predicate(12, 0, new TermList(TermConstant.getConstant(26), new TermList(new TermNumber(9628.0), TermList.NIL))));
		s.addPredicate(new Predicate(11, 0, new TermList(TermConstant.getConstant(26), new TermList(new TermNumber(2728.0), TermList.NIL))));
		s.addPredicate(new Predicate(18, 0, new TermList(TermConstant.getConstant(26), new TermList(new TermNumber(4.0), TermList.NIL))));
		s.addPredicate(new Predicate(16, 0, new TermList(TermConstant.getConstant(26), new TermList(new TermNumber(13.0), TermList.NIL))));
		s.addPredicate(new Predicate(13, 0, new TermList(TermConstant.getConstant(26), new TermList(new TermNumber(5700.0), TermList.NIL))));
		s.addPredicate(new Predicate(4, 0, new TermList(TermConstant.getConstant(27), new TermList(TermConstant.getConstant(40), TermList.NIL))));
		s.addPredicate(new Predicate(19, 0, new TermList(TermConstant.getConstant(27), new TermList(new TermNumber(169.0), TermList.NIL))));
		s.addPredicate(new Predicate(15, 0, new TermList(TermConstant.getConstant(27), new TermList(new TermNumber(362.0), TermList.NIL))));
		s.addPredicate(new Predicate(12, 0, new TermList(TermConstant.getConstant(27), new TermList(new TermNumber(9038.0), TermList.NIL))));
		s.addPredicate(new Predicate(11, 0, new TermList(TermConstant.getConstant(27), new TermList(new TermNumber(667.0), TermList.NIL))));
		s.addPredicate(new Predicate(18, 0, new TermList(TermConstant.getConstant(27), new TermList(new TermNumber(4.0), TermList.NIL))));
		s.addPredicate(new Predicate(16, 0, new TermList(TermConstant.getConstant(27), new TermList(new TermNumber(8.0), TermList.NIL))));
		s.addPredicate(new Predicate(13, 0, new TermList(TermConstant.getConstant(27), new TermList(new TermNumber(6138.0), TermList.NIL))));
		s.addPredicate(new Predicate(4, 0, new TermList(TermConstant.getConstant(28), new TermList(TermConstant.getConstant(38), TermList.NIL))));
		s.addPredicate(new Predicate(4, 0, new TermList(TermConstant.getConstant(29), new TermList(TermConstant.getConstant(38), TermList.NIL))));
		s.addPredicate(new Predicate(4, 0, new TermList(TermConstant.getConstant(30), new TermList(TermConstant.getConstant(39), TermList.NIL))));
		s.addPredicate(new Predicate(4, 0, new TermList(TermConstant.getConstant(31), new TermList(TermConstant.getConstant(39), TermList.NIL))));
		s.addPredicate(new Predicate(4, 0, new TermList(TermConstant.getConstant(32), new TermList(TermConstant.getConstant(37), TermList.NIL))));
		s.addPredicate(new Predicate(4, 0, new TermList(TermConstant.getConstant(33), new TermList(TermConstant.getConstant(36), TermList.NIL))));
		s.addPredicate(new Predicate(4, 0, new TermList(TermConstant.getConstant(34), new TermList(TermConstant.getConstant(37), TermList.NIL))));
		s.addPredicate(new Predicate(4, 0, new TermList(TermConstant.getConstant(35), new TermList(TermConstant.getConstant(36), TermList.NIL))));
		s.addPredicate(new Predicate(14, 0, new TermList(TermConstant.getConstant(36), new TermList(TermConstant.getConstant(36), new TermList(new TermNumber(0.0), TermList.NIL)))));
		s.addPredicate(new Predicate(14, 0, new TermList(TermConstant.getConstant(36), new TermList(TermConstant.getConstant(37), new TermList(new TermNumber(808.0), TermList.NIL)))));
		s.addPredicate(new Predicate(14, 0, new TermList(TermConstant.getConstant(36), new TermList(TermConstant.getConstant(40), new TermList(new TermNumber(932.0), TermList.NIL)))));
		s.addPredicate(new Predicate(14, 0, new TermList(TermConstant.getConstant(36), new TermList(TermConstant.getConstant(38), new TermList(new TermNumber(760.0), TermList.NIL)))));
		s.addPredicate(new Predicate(14, 0, new TermList(TermConstant.getConstant(36), new TermList(TermConstant.getConstant(39), new TermList(new TermNumber(697.0), TermList.NIL)))));
		s.addPredicate(new Predicate(14, 0, new TermList(TermConstant.getConstant(37), new TermList(TermConstant.getConstant(36), new TermList(new TermNumber(808.0), TermList.NIL)))));
		s.addPredicate(new Predicate(14, 0, new TermList(TermConstant.getConstant(37), new TermList(TermConstant.getConstant(37), new TermList(new TermNumber(0.0), TermList.NIL)))));
		s.addPredicate(new Predicate(14, 0, new TermList(TermConstant.getConstant(37), new TermList(TermConstant.getConstant(40), new TermList(new TermNumber(559.0), TermList.NIL)))));
		s.addPredicate(new Predicate(14, 0, new TermList(TermConstant.getConstant(37), new TermList(TermConstant.getConstant(38), new TermList(new TermNumber(673.0), TermList.NIL)))));
		s.addPredicate(new Predicate(14, 0, new TermList(TermConstant.getConstant(37), new TermList(TermConstant.getConstant(39), new TermList(new TermNumber(742.0), TermList.NIL)))));
		s.addPredicate(new Predicate(14, 0, new TermList(TermConstant.getConstant(40), new TermList(TermConstant.getConstant(36), new TermList(new TermNumber(932.0), TermList.NIL)))));
		s.addPredicate(new Predicate(14, 0, new TermList(TermConstant.getConstant(40), new TermList(TermConstant.getConstant(37), new TermList(new TermNumber(559.0), TermList.NIL)))));
		s.addPredicate(new Predicate(14, 0, new TermList(TermConstant.getConstant(40), new TermList(TermConstant.getConstant(40), new TermList(new TermNumber(0.0), TermList.NIL)))));
		s.addPredicate(new Predicate(14, 0, new TermList(TermConstant.getConstant(40), new TermList(TermConstant.getConstant(38), new TermList(new TermNumber(938.0), TermList.NIL)))));
		s.addPredicate(new Predicate(14, 0, new TermList(TermConstant.getConstant(40), new TermList(TermConstant.getConstant(39), new TermList(new TermNumber(978.0), TermList.NIL)))));
		s.addPredicate(new Predicate(14, 0, new TermList(TermConstant.getConstant(38), new TermList(TermConstant.getConstant(36), new TermList(new TermNumber(760.0), TermList.NIL)))));
		s.addPredicate(new Predicate(14, 0, new TermList(TermConstant.getConstant(38), new TermList(TermConstant.getConstant(37), new TermList(new TermNumber(673.0), TermList.NIL)))));
		s.addPredicate(new Predicate(14, 0, new TermList(TermConstant.getConstant(38), new TermList(TermConstant.getConstant(40), new TermList(new TermNumber(938.0), TermList.NIL)))));
		s.addPredicate(new Predicate(14, 0, new TermList(TermConstant.getConstant(38), new TermList(TermConstant.getConstant(38), new TermList(new TermNumber(0.0), TermList.NIL)))));
		s.addPredicate(new Predicate(14, 0, new TermList(TermConstant.getConstant(38), new TermList(TermConstant.getConstant(39), new TermList(new TermNumber(803.0), TermList.NIL)))));
		s.addPredicate(new Predicate(14, 0, new TermList(TermConstant.getConstant(39), new TermList(TermConstant.getConstant(36), new TermList(new TermNumber(697.0), TermList.NIL)))));
		s.addPredicate(new Predicate(14, 0, new TermList(TermConstant.getConstant(39), new TermList(TermConstant.getConstant(37), new TermList(new TermNumber(742.0), TermList.NIL)))));
		s.addPredicate(new Predicate(14, 0, new TermList(TermConstant.getConstant(39), new TermList(TermConstant.getConstant(40), new TermList(new TermNumber(978.0), TermList.NIL)))));
		s.addPredicate(new Predicate(14, 0, new TermList(TermConstant.getConstant(39), new TermList(TermConstant.getConstant(38), new TermList(new TermNumber(803.0), TermList.NIL)))));
		s.addPredicate(new Predicate(14, 0, new TermList(TermConstant.getConstant(39), new TermList(TermConstant.getConstant(39), new TermList(new TermNumber(0.0), TermList.NIL)))));
		s.addPredicate(new Predicate(17, 0, new TermList(new TermNumber(0.0), TermList.NIL)));
		s.addPredicate(new Predicate(8, 0, new TermList(new TermNumber(0.3), TermList.NIL)));
		s.addPredicate(new Predicate(10, 0, new TermList(new TermNumber(0.6), TermList.NIL)));
	}

	private static void createStateEventList0(State s)	{
	}

	public static LinkedList<Plan> getPlans()
	{
		LinkedList<Plan> returnedPlans = new LinkedList<Plan>();
		TermConstant.initialize(41);

		Domain d = new zenotravel();

		d.setProblemConstants(defineConstants());

		Vector<Event> initialEventIn = new Vector<Event>();

		double initialTimeIn;
		initialTimeIn = 0.0;

		State s = new State(25, d.getAxioms() ,initialEventIn, initialTimeIn);

		JSHOP2.initialize(d, s);

		TaskNet tn;
		TaskList tl;
		Vector<TimeConstraint> tcl = new Vector<TimeConstraint>();
		SolverThread thread;


		s.clear();
		createStatePredicates0(s);
		createStateEventList0(s);

		tl = new TaskList(2, true);
		tl.subtasks[0] = new TaskList(8, false);
		tl.subtasks[0].subtasks[0] = new TaskList(new TaskAtom(new Predicate(0, 0, new TermList(TermConstant.getConstant(28), new TermList(TermConstant.getConstant(37), TermList.NIL))), false, false, new TermNumber(1.0)));
		tl.subtasks[0].subtasks[1] = new TaskList(new TaskAtom(new Predicate(0, 0, new TermList(TermConstant.getConstant(29), new TermList(TermConstant.getConstant(40), TermList.NIL))), false, false, new TermNumber(1.0)));
		tl.subtasks[0].subtasks[2] = new TaskList(new TaskAtom(new Predicate(0, 0, new TermList(TermConstant.getConstant(30), new TermList(TermConstant.getConstant(38), TermList.NIL))), false, false, new TermNumber(1.0)));
		tl.subtasks[0].subtasks[3] = new TaskList(new TaskAtom(new Predicate(0, 0, new TermList(TermConstant.getConstant(31), new TermList(TermConstant.getConstant(37), TermList.NIL))), false, false, new TermNumber(1.0)));
		tl.subtasks[0].subtasks[4] = new TaskList(new TaskAtom(new Predicate(0, 0, new TermList(TermConstant.getConstant(32), new TermList(TermConstant.getConstant(36), TermList.NIL))), false, false, new TermNumber(1.0)));
		tl.subtasks[0].subtasks[5] = new TaskList(new TaskAtom(new Predicate(0, 0, new TermList(TermConstant.getConstant(33), new TermList(TermConstant.getConstant(38), TermList.NIL))), false, false, new TermNumber(1.0)));
		tl.subtasks[0].subtasks[6] = new TaskList(new TaskAtom(new Predicate(0, 0, new TermList(TermConstant.getConstant(34), new TermList(TermConstant.getConstant(39), TermList.NIL))), false, false, new TermNumber(1.0)));
		tl.subtasks[0].subtasks[7] = new TaskList(new TaskAtom(new Predicate(0, 0, new TermList(TermConstant.getConstant(35), new TermList(TermConstant.getConstant(38), TermList.NIL))), false, false, new TermNumber(1.0)));
		tl.subtasks[1] = new TaskList(new TaskAtom(new Predicate(4, 0, new TermList(TermConstant.getConstant(25), new TermList(TermConstant.getConstant(40), TermList.NIL))), false, false, new TermNumber(1.0)));


		tn=new TaskNet(tl,tcl);
		thread = new SolverThread(tn, 1);
		thread.start();

		try {
			while (thread.isAlive())
				Thread.sleep(500);
		} catch (InterruptedException e) {
		}

		returnedPlans.addAll( thread.getPlans() );

		return returnedPlans;
	}

	public static LinkedList<PlanElement> getFirstPlanElements() {
		return getPlans().getFirst().getPlanElements();
	}
}