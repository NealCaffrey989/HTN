import java.util.LinkedList;
import JSHOP2.*;

class problem
{
	private static String[] defineConstants()
	{
		String[] problemConstants = new String[23];

		problemConstants[0] = "bus-1";
		problemConstants[1] = "bus-2";
		problemConstants[2] = "bus-3";
		problemConstants[3] = "bus-4";
		problemConstants[4] = "bus-5";
		problemConstants[5] = "this";
		problemConstants[6] = "this-1";
		problemConstants[7] = "a1";
		problemConstants[8] = "oa1";
		problemConstants[9] = "b1";
		problemConstants[10] = "b2";
		problemConstants[11] = "b3";
		problemConstants[12] = "a2";
		problemConstants[13] = "oa2";
		problemConstants[14] = "ob1";
		problemConstants[15] = "ob2";
		problemConstants[16] = "ob3";
		problemConstants[17] = "track-1";
		problemConstants[18] = "track-2";
		problemConstants[19] = "a3";
		problemConstants[20] = "oa3";
		problemConstants[21] = "e";
		problemConstants[22] = "oe1";

		return problemConstants;
	}

	private static void createState0(State s)	{
		s.add(new Predicate(2, 0, new TermList(new TermNumber(0.0), TermList.NIL)));
		s.add(new Predicate(4, 0, new TermList(new TermNumber(0.0), TermList.NIL)));
		s.add(new Predicate(3, 0, new TermList(TermConstant.getConstant(23), new TermList(new TermNumber(0.0), TermList.NIL))));
		s.add(new Predicate(3, 0, new TermList(TermConstant.getConstant(24), new TermList(new TermNumber(0.0), TermList.NIL))));
		s.add(new Predicate(3, 0, new TermList(TermConstant.getConstant(25), new TermList(new TermNumber(0.0), TermList.NIL))));
		s.add(new Predicate(3, 0, new TermList(TermConstant.getConstant(26), new TermList(new TermNumber(0.0), TermList.NIL))));
		s.add(new Predicate(3, 0, new TermList(TermConstant.getConstant(27), new TermList(new TermNumber(0.0), TermList.NIL))));
		s.add(new Predicate(3, 0, new TermList(TermConstant.getConstant(28), new TermList(new TermNumber(0.0), TermList.NIL))));
		s.add(new Predicate(3, 0, new TermList(TermConstant.getConstant(29), new TermList(new TermNumber(0.0), TermList.NIL))));
		s.add(new Predicate(6, 0, new TermList(TermConstant.getConstant(5), new TermList(new TermNumber(0.0), TermList.NIL))));
		s.add(new Predicate(12, 0, new TermList(TermConstant.getConstant(30), new TermList(new TermNumber(6000.0), TermList.NIL))));
		s.add(new Predicate(7, 0, new TermList(TermConstant.getConstant(31), new TermList(TermConstant.getConstant(30), TermList.NIL))));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(31), new TermList(new TermNumber(5000.0), TermList.NIL))));
		s.add(new Predicate(9, 0, new TermList(TermConstant.getConstant(30), new TermList(TermConstant.getConstant(32), new TermList(new TermNumber(50.0), TermList.NIL)))));
		s.add(new Predicate(9, 0, new TermList(TermConstant.getConstant(30), new TermList(TermConstant.getConstant(33), new TermList(new TermNumber(45.0), TermList.NIL)))));
		s.add(new Predicate(9, 0, new TermList(TermConstant.getConstant(30), new TermList(TermConstant.getConstant(34), new TermList(new TermNumber(60.0), TermList.NIL)))));
		s.add(new Predicate(9, 0, new TermList(TermConstant.getConstant(30), new TermList(TermConstant.getConstant(35), new TermList(new TermNumber(40.0), TermList.NIL)))));
		s.add(new Predicate(12, 0, new TermList(TermConstant.getConstant(35), new TermList(new TermNumber(4000.0), TermList.NIL))));
		s.add(new Predicate(7, 0, new TermList(TermConstant.getConstant(36), new TermList(TermConstant.getConstant(35), TermList.NIL))));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(36), new TermList(new TermNumber(5000.0), TermList.NIL))));
		s.add(new Predicate(9, 0, new TermList(TermConstant.getConstant(35), new TermList(TermConstant.getConstant(32), new TermList(new TermNumber(60.0), TermList.NIL)))));
		s.add(new Predicate(9, 0, new TermList(TermConstant.getConstant(35), new TermList(TermConstant.getConstant(33), new TermList(new TermNumber(45.0), TermList.NIL)))));
		s.add(new Predicate(9, 0, new TermList(TermConstant.getConstant(35), new TermList(TermConstant.getConstant(34), new TermList(new TermNumber(50.0), TermList.NIL)))));
		s.add(new Predicate(9, 0, new TermList(TermConstant.getConstant(35), new TermList(TermConstant.getConstant(30), new TermList(new TermNumber(40.0), TermList.NIL)))));
		s.add(new Predicate(15, 0, new TermList(TermConstant.getConstant(32), new TermList(new TermNumber(4000.0), TermList.NIL))));
		s.add(new Predicate(7, 0, new TermList(TermConstant.getConstant(37), new TermList(TermConstant.getConstant(32), TermList.NIL))));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(37), new TermList(new TermNumber(5000.0), TermList.NIL))));
		s.add(new Predicate(9, 0, new TermList(TermConstant.getConstant(32), new TermList(TermConstant.getConstant(30), new TermList(new TermNumber(50.0), TermList.NIL)))));
		s.add(new Predicate(9, 0, new TermList(TermConstant.getConstant(32), new TermList(TermConstant.getConstant(35), new TermList(new TermNumber(60.0), TermList.NIL)))));
		s.add(new Predicate(9, 0, new TermList(TermConstant.getConstant(32), new TermList(TermConstant.getConstant(33), new TermList(new TermNumber(20.0), TermList.NIL)))));
		s.add(new Predicate(9, 0, new TermList(TermConstant.getConstant(32), new TermList(TermConstant.getConstant(34), new TermList(new TermNumber(30.0), TermList.NIL)))));
		s.add(new Predicate(15, 0, new TermList(TermConstant.getConstant(33), new TermList(new TermNumber(3000.0), TermList.NIL))));
		s.add(new Predicate(7, 0, new TermList(TermConstant.getConstant(38), new TermList(TermConstant.getConstant(33), TermList.NIL))));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(38), new TermList(new TermNumber(5000.0), TermList.NIL))));
		s.add(new Predicate(9, 0, new TermList(TermConstant.getConstant(33), new TermList(TermConstant.getConstant(30), new TermList(new TermNumber(45.0), TermList.NIL)))));
		s.add(new Predicate(9, 0, new TermList(TermConstant.getConstant(33), new TermList(TermConstant.getConstant(35), new TermList(new TermNumber(45.0), TermList.NIL)))));
		s.add(new Predicate(9, 0, new TermList(TermConstant.getConstant(33), new TermList(TermConstant.getConstant(32), new TermList(new TermNumber(20.0), TermList.NIL)))));
		s.add(new Predicate(9, 0, new TermList(TermConstant.getConstant(33), new TermList(TermConstant.getConstant(34), new TermList(new TermNumber(15.0), TermList.NIL)))));
		s.add(new Predicate(15, 0, new TermList(TermConstant.getConstant(34), new TermList(new TermNumber(5000.0), TermList.NIL))));
		s.add(new Predicate(7, 0, new TermList(TermConstant.getConstant(39), new TermList(TermConstant.getConstant(34), TermList.NIL))));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(39), new TermList(new TermNumber(5000.0), TermList.NIL))));
		s.add(new Predicate(9, 0, new TermList(TermConstant.getConstant(34), new TermList(TermConstant.getConstant(30), new TermList(new TermNumber(60.0), TermList.NIL)))));
		s.add(new Predicate(9, 0, new TermList(TermConstant.getConstant(34), new TermList(TermConstant.getConstant(35), new TermList(new TermNumber(50.0), TermList.NIL)))));
		s.add(new Predicate(9, 0, new TermList(TermConstant.getConstant(34), new TermList(TermConstant.getConstant(32), new TermList(new TermNumber(30.0), TermList.NIL)))));
		s.add(new Predicate(9, 0, new TermList(TermConstant.getConstant(34), new TermList(TermConstant.getConstant(33), new TermList(new TermNumber(15.0), TermList.NIL)))));
		s.add(new Predicate(17, 0, new TermList(TermConstant.getConstant(16), new TermList(new TermNumber(0.0), TermList.NIL))));
		s.add(new Predicate(8, 0, new TermList(TermConstant.getConstant(23), new TermList(TermConstant.getConstant(30), TermList.NIL))));
		s.add(new Predicate(13, 0, new TermList(TermConstant.getConstant(23), new TermList(new TermNumber(500.0), TermList.NIL))));
		s.add(new Predicate(14, 0, new TermList(TermConstant.getConstant(23), new TermList(new TermNumber(0.0), TermList.NIL))));
		s.add(new Predicate(10, 0, new TermList(TermConstant.getConstant(23), new TermList(new TermNumber(50.0), TermList.NIL))));
		s.add(new Predicate(11, 0, new TermList(TermConstant.getConstant(5), new TermList(TermConstant.getConstant(23), new TermList(new TermNumber(0.5), TermList.NIL)))));
		s.add(new Predicate(8, 0, new TermList(TermConstant.getConstant(24), new TermList(TermConstant.getConstant(30), TermList.NIL))));
		s.add(new Predicate(13, 0, new TermList(TermConstant.getConstant(24), new TermList(new TermNumber(500.0), TermList.NIL))));
		s.add(new Predicate(14, 0, new TermList(TermConstant.getConstant(24), new TermList(new TermNumber(0.0), TermList.NIL))));
		s.add(new Predicate(10, 0, new TermList(TermConstant.getConstant(24), new TermList(new TermNumber(50.0), TermList.NIL))));
		s.add(new Predicate(11, 0, new TermList(TermConstant.getConstant(5), new TermList(TermConstant.getConstant(24), new TermList(new TermNumber(0.5), TermList.NIL)))));
		s.add(new Predicate(8, 0, new TermList(TermConstant.getConstant(25), new TermList(TermConstant.getConstant(30), TermList.NIL))));
		s.add(new Predicate(13, 0, new TermList(TermConstant.getConstant(25), new TermList(new TermNumber(500.0), TermList.NIL))));
		s.add(new Predicate(14, 0, new TermList(TermConstant.getConstant(25), new TermList(new TermNumber(0.0), TermList.NIL))));
		s.add(new Predicate(10, 0, new TermList(TermConstant.getConstant(25), new TermList(new TermNumber(50.0), TermList.NIL))));
		s.add(new Predicate(11, 0, new TermList(TermConstant.getConstant(5), new TermList(TermConstant.getConstant(25), new TermList(new TermNumber(0.5), TermList.NIL)))));
		s.add(new Predicate(8, 0, new TermList(TermConstant.getConstant(26), new TermList(TermConstant.getConstant(35), TermList.NIL))));
		s.add(new Predicate(13, 0, new TermList(TermConstant.getConstant(26), new TermList(new TermNumber(400.0), TermList.NIL))));
		s.add(new Predicate(14, 0, new TermList(TermConstant.getConstant(26), new TermList(new TermNumber(0.0), TermList.NIL))));
		s.add(new Predicate(10, 0, new TermList(TermConstant.getConstant(26), new TermList(new TermNumber(60.0), TermList.NIL))));
		s.add(new Predicate(11, 0, new TermList(TermConstant.getConstant(5), new TermList(TermConstant.getConstant(26), new TermList(new TermNumber(0.5), TermList.NIL)))));
		s.add(new Predicate(8, 0, new TermList(TermConstant.getConstant(27), new TermList(TermConstant.getConstant(35), TermList.NIL))));
		s.add(new Predicate(13, 0, new TermList(TermConstant.getConstant(27), new TermList(new TermNumber(400.0), TermList.NIL))));
		s.add(new Predicate(14, 0, new TermList(TermConstant.getConstant(27), new TermList(new TermNumber(0.0), TermList.NIL))));
		s.add(new Predicate(10, 0, new TermList(TermConstant.getConstant(27), new TermList(new TermNumber(60.0), TermList.NIL))));
		s.add(new Predicate(11, 0, new TermList(TermConstant.getConstant(5), new TermList(TermConstant.getConstant(27), new TermList(new TermNumber(0.5), TermList.NIL)))));
		s.add(new Predicate(3, 0, new TermList(TermConstant.getConstant(40), new TermList(new TermNumber(0.0), TermList.NIL))));
		s.add(new Predicate(3, 0, new TermList(TermConstant.getConstant(41), new TermList(new TermNumber(0.0), TermList.NIL))));
		s.add(new Predicate(20, 0, new TermList(TermConstant.getConstant(42), new TermList(new TermNumber(1000.0), TermList.NIL))));
		s.add(new Predicate(7, 0, new TermList(TermConstant.getConstant(43), new TermList(TermConstant.getConstant(42), TermList.NIL))));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(43), new TermList(new TermNumber(5000.0), TermList.NIL))));
		s.add(new Predicate(9, 0, new TermList(TermConstant.getConstant(42), new TermList(TermConstant.getConstant(44), new TermList(new TermNumber(70.0), TermList.NIL)))));
		s.add(new Predicate(22, 0, new TermList(TermConstant.getConstant(44), new TermList(new TermNumber(5000.0), TermList.NIL))));
		s.add(new Predicate(7, 0, new TermList(TermConstant.getConstant(45), new TermList(TermConstant.getConstant(44), TermList.NIL))));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(45), new TermList(new TermNumber(5000.0), TermList.NIL))));
		s.add(new Predicate(9, 0, new TermList(TermConstant.getConstant(44), new TermList(TermConstant.getConstant(42), new TermList(new TermNumber(70.0), TermList.NIL)))));
		s.add(new Predicate(18, 0, new TermList(TermConstant.getConstant(40), new TermList(TermConstant.getConstant(42), TermList.NIL))));
		s.add(new Predicate(13, 0, new TermList(TermConstant.getConstant(40), new TermList(new TermNumber(48.0), TermList.NIL))));
		s.add(new Predicate(21, 0, new TermList(TermConstant.getConstant(40), new TermList(new TermNumber(0.0), TermList.NIL))));
		s.add(new Predicate(10, 0, new TermList(TermConstant.getConstant(40), new TermList(new TermNumber(50.0), TermList.NIL))));
		s.add(new Predicate(19, 0, new TermList(TermConstant.getConstant(5), new TermList(TermConstant.getConstant(40), new TermList(new TermNumber(1.0), TermList.NIL)))));
		s.add(new Predicate(18, 0, new TermList(TermConstant.getConstant(41), new TermList(TermConstant.getConstant(42), TermList.NIL))));
		s.add(new Predicate(13, 0, new TermList(TermConstant.getConstant(41), new TermList(new TermNumber(40.0), TermList.NIL))));
		s.add(new Predicate(21, 0, new TermList(TermConstant.getConstant(41), new TermList(new TermNumber(0.0), TermList.NIL))));
		s.add(new Predicate(10, 0, new TermList(TermConstant.getConstant(41), new TermList(new TermNumber(40.0), TermList.NIL))));
		s.add(new Predicate(19, 0, new TermList(TermConstant.getConstant(5), new TermList(TermConstant.getConstant(41), new TermList(new TermNumber(1.0), TermList.NIL)))));
	}

	public static LinkedList<Plan> getPlans()
	{
		LinkedList<Plan> returnedPlans = new LinkedList<Plan>();
		TermConstant.initialize(46);

		Domain d = new flood_evacuate();

		d.setProblemConstants(defineConstants());

		State s = new State(23, d.getAxioms());

		JSHOP2.initialize(d, s);

		TaskList tl;
		SolverThread thread;

		createState0(s);

		tl = new TaskList(1, false);
		tl.subtasks[0] = new TaskList(new TaskAtom(new Predicate(0, 0, new TermList(TermConstant.getConstant(28), new TermList(new TermNumber(0.0), TermList.NIL))), false, false));

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