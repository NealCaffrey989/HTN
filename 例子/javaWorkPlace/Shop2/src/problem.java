import java.util.LinkedList;
import JSHOP2.*;

class problem
{
	private static String[] defineConstants()
	{
		String[] problemConstants = new String[4];

		problemConstants[0] = "b1";
		problemConstants[1] = "b2";
		problemConstants[2] = "a1";
		problemConstants[3] = "a2";

		return problemConstants;
	}

	private static void createState0(State s)	{
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(2), new TermList(TermConstant.getConstant(6), new TermList(new TermNumber(200.0), new TermList(new TermNumber(0.0), TermList.NIL))))));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(2), new TermList(TermConstant.getConstant(7), new TermList(new TermNumber(500.0), new TermList(new TermNumber(0.0), TermList.NIL))))));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(4), new TermList(TermConstant.getConstant(6), new TermList(new TermNumber(4000.0), new TermList(new TermNumber(0.0), TermList.NIL))))));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(4), new TermList(TermConstant.getConstant(7), new TermList(new TermNumber(2000.0), new TermList(new TermNumber(0.0), TermList.NIL))))));
	}

	public static LinkedList<Plan> getPlans()
	{
		LinkedList<Plan> returnedPlans = new LinkedList<Plan>();
		TermConstant.initialize(10);

		Domain d = new projectrescue();

		d.setProblemConstants(defineConstants());

		State s = new State(6, d.getAxioms());

		JSHOP2.initialize(d, s);

		TaskList tl;
		SolverThread thread;

		createState0(s);

		tl = new TaskList(2, false);
		tl.subtasks[0] = new TaskList(new TaskAtom(new Predicate(1, 0, new TermList(TermConstant.getConstant(8), new TermList(new TermNumber(1.0), TermList.NIL))), false, false));
		tl.subtasks[1] = new TaskList(new TaskAtom(new Predicate(1, 0, new TermList(TermConstant.getConstant(9), new TermList(new TermNumber(2.0), TermList.NIL))), false, false));

		thread = new SolverThread(tl, 1);
		thread.start();

		try {
			while (thread.isAlive())
				Thread.sleep(500);
		} catch (InterruptedException e) {
		}

		returnedPlans.addAll( thread.getPlans() );

		return returnedPlans;
	}

	public static LinkedList<Predicate> getFirstPlanOps() {
		return getPlans().getFirst().getOps();
	}
}