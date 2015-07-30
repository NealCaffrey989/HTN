package JSHOP2;
import java.util.Vector;

class Precondition1 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition1(Term[] unifier)
	{
		p = new Precondition[7];
		p[1] = new PreconditionAtomic(new Predicate(3, 4, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier);
		p[2] = new PreconditionAtomic(new Predicate(6, 4, new TermList(TermVariable.getVariable(1), TermList.NIL)), unifier);
		p[3] = new PreconditionAtomic(new Predicate(7, 4, new TermList(TermVariable.getVariable(2), TermList.NIL)), unifier);
		p[4] = new PreconditionAtomic(new Predicate(4, 4, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier);
		p[5] = new PreconditionAtomic(new Predicate(4, 4, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier);
		p[6] = new PreconditionAtomic(new Predicate(8, 4, new TermList(TermVariable.getVariable(3), TermList.NIL)), unifier);
		b = new Term[7][];
		b[0] = unifier;
		b[0] = Term.merge( b, 1 );

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		b[0] = binding;
		b[0] = Term.merge( b, 1 );
		p[1].bind(binding);
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
		b[6] = null;
	}

	protected Term[] nextBindingHelper()
	{
		while (b[6] == null)
		{
			boolean b5changed = false;
			while (b[5] == null)
			{
				boolean b4changed = false;
				while (b[4] == null)
				{
					boolean b3changed = false;
					while (b[3] == null)
					{
						boolean b2changed = false;
						while (b[2] == null)
						{
							boolean b1changed = false;
							while (b[1] == null)
							{
								b[1] = p[1].nextBinding();
								if (b[1] == null)
									return null;
								b1changed = true;
							}
							if ( b1changed ) {
								p[2].reset();
								p[2].bind(Term.merge(b, 2));
							}
							b[2] = p[2].nextBinding();
							if (b[2] == null) b[1] = null;
							b2changed = true;
						}
						if ( b2changed ) {
							p[3].reset();
							p[3].bind(Term.merge(b, 3));
						}
						b[3] = p[3].nextBinding();
						if (b[3] == null) b[2] = null;
						b3changed = true;
					}
					if ( b3changed ) {
						p[4].reset();
						p[4].bind(Term.merge(b, 4));
					}
					b[4] = p[4].nextBinding();
					if (b[4] == null) b[3] = null;
					b4changed = true;
				}
				if ( b4changed ) {
					p[5].reset();
					p[5].bind(Term.merge(b, 5));
				}
				b[5] = p[5].nextBinding();
				if (b[5] == null) b[4] = null;
				b5changed = true;
			}
			if ( b5changed ) {
				p[6].reset();
				p[6].bind(Term.merge(b, 6));
			}
			b[6] = p[6].nextBinding();
			if (b[6] == null) b[5] = null;
		}

		Term[] retVal = Term.merge(b, 7);
		b[6] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		p[3].reset();
		p[4].reset();
		p[5].reset();
		p[6].reset();
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
		b[6] = null;
	}
}

class Operator0 extends Operator
{
	public Operator0()
	{
		super(new Predicate(0, 4, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))), -1, -1, 
			TermVariable.getVariable(3),new TermNumber(0.0010));


		DelAddElement[] instantDelIn = new DelAddElement[1];
		instantDelIn[0] = new DelAddAtomic(new Predicate(4, 4, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), TermList.NIL))));

		setInstantDel(instantDelIn);

		DelAddElement[] instantAddIn = new DelAddElement[0];

		setInstantAdd(instantAddIn);



		Event[] delayedDelIn = new Event[0];

		setDelayedDel(delayedDelIn);

		Event[] delayedAddIn = new Event[1];
		delayedAddIn[0] = new Event (new Predicate(9, 4, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))),true,TermVariable.getVariable(3) );

		setDelayedAdd(delayedAddIn);


	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		p = (new Precondition1(unifier)).setComparator(null);
		p.reset();

		return p;
	}
}

class Precondition2 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition2(Term[] unifier)
	{
		p = new Precondition[7];
		p[1] = new PreconditionAtomic(new Predicate(3, 4, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier);
		p[2] = new PreconditionAtomic(new Predicate(6, 4, new TermList(TermVariable.getVariable(1), TermList.NIL)), unifier);
		p[3] = new PreconditionAtomic(new Predicate(7, 4, new TermList(TermVariable.getVariable(2), TermList.NIL)), unifier);
		p[4] = new PreconditionAtomic(new Predicate(4, 4, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier);
		p[5] = new PreconditionAtomic(new Predicate(9, 4, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))), unifier);
		p[6] = new PreconditionAtomic(new Predicate(10, 4, new TermList(TermVariable.getVariable(3), TermList.NIL)), unifier);
		b = new Term[7][];
		b[0] = unifier;
		b[0] = Term.merge( b, 1 );

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		b[0] = binding;
		b[0] = Term.merge( b, 1 );
		p[1].bind(binding);
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
		b[6] = null;
	}

	protected Term[] nextBindingHelper()
	{
		while (b[6] == null)
		{
			boolean b5changed = false;
			while (b[5] == null)
			{
				boolean b4changed = false;
				while (b[4] == null)
				{
					boolean b3changed = false;
					while (b[3] == null)
					{
						boolean b2changed = false;
						while (b[2] == null)
						{
							boolean b1changed = false;
							while (b[1] == null)
							{
								b[1] = p[1].nextBinding();
								if (b[1] == null)
									return null;
								b1changed = true;
							}
							if ( b1changed ) {
								p[2].reset();
								p[2].bind(Term.merge(b, 2));
							}
							b[2] = p[2].nextBinding();
							if (b[2] == null) b[1] = null;
							b2changed = true;
						}
						if ( b2changed ) {
							p[3].reset();
							p[3].bind(Term.merge(b, 3));
						}
						b[3] = p[3].nextBinding();
						if (b[3] == null) b[2] = null;
						b3changed = true;
					}
					if ( b3changed ) {
						p[4].reset();
						p[4].bind(Term.merge(b, 4));
					}
					b[4] = p[4].nextBinding();
					if (b[4] == null) b[3] = null;
					b4changed = true;
				}
				if ( b4changed ) {
					p[5].reset();
					p[5].bind(Term.merge(b, 5));
				}
				b[5] = p[5].nextBinding();
				if (b[5] == null) b[4] = null;
				b5changed = true;
			}
			if ( b5changed ) {
				p[6].reset();
				p[6].bind(Term.merge(b, 6));
			}
			b[6] = p[6].nextBinding();
			if (b[6] == null) b[5] = null;
		}

		Term[] retVal = Term.merge(b, 7);
		b[6] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		p[3].reset();
		p[4].reset();
		p[5].reset();
		p[6].reset();
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
		b[6] = null;
	}
}

class Operator1 extends Operator
{
	public Operator1()
	{
		super(new Predicate(1, 4, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))), -1, -1, 
			TermVariable.getVariable(3),new TermNumber(0.0010));


		DelAddElement[] instantDelIn = new DelAddElement[1];
		instantDelIn[0] = new DelAddAtomic(new Predicate(9, 4, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))));

		setInstantDel(instantDelIn);

		DelAddElement[] instantAddIn = new DelAddElement[0];

		setInstantAdd(instantAddIn);



		Event[] delayedDelIn = new Event[0];

		setDelayedDel(delayedDelIn);

		Event[] delayedAddIn = new Event[1];
		delayedAddIn[0] = new Event (new Predicate(4, 4, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), TermList.NIL))),true,TermVariable.getVariable(3) );

		setDelayedAdd(delayedAddIn);


	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		p = (new Precondition2(unifier)).setComparator(null);
		p.reset();

		return p;
	}
}

class Precondition3 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition3(Term[] unifier)
	{
		p = new Precondition[9];
		p[1] = new PreconditionAtomic(new Predicate(6, 6, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier);
		p[2] = new PreconditionAtomic(new Predicate(7, 6, new TermList(TermVariable.getVariable(1), TermList.NIL)), unifier);
		p[3] = new PreconditionAtomic(new Predicate(4, 6, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))), unifier);
		p[4] = new PreconditionAtomic(new Predicate(11, 6, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier);
		p[5] = new PreconditionAtomic(new Predicate(12, 6, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(3), TermList.NIL))), unifier);
		p[6] = new PreconditionAtomic(new Predicate(13, 6, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier);
		p[7] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(2), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
		p[8] = new PreconditionAssign(new TermCall(new List(new TermCall(new List(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(2), TermList.NIL)), StdLib.minus, "StdLib.minus"), new TermList(TermVariable.getVariable(4), TermList.NIL)), StdLib.div, "StdLib.div"), unifier, 5);
		b = new Term[9][];
		b[0] = unifier;
		b[0] = Term.merge( b, 1 );

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		b[0] = binding;
		b[0] = Term.merge( b, 1 );
		p[1].bind(binding);
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
		b[6] = null;
		b[7] = null;
		b[8] = null;
	}

	protected Term[] nextBindingHelper()
	{
		while (b[8] == null)
		{
			boolean b7changed = false;
			while (b[7] == null)
			{
				boolean b6changed = false;
				while (b[6] == null)
				{
					boolean b5changed = false;
					while (b[5] == null)
					{
						boolean b4changed = false;
						while (b[4] == null)
						{
							boolean b3changed = false;
							while (b[3] == null)
							{
								boolean b2changed = false;
								while (b[2] == null)
								{
									boolean b1changed = false;
									while (b[1] == null)
									{
										b[1] = p[1].nextBinding();
										if (b[1] == null)
											return null;
										b1changed = true;
									}
									if ( b1changed ) {
										p[2].reset();
										p[2].bind(Term.merge(b, 2));
									}
									b[2] = p[2].nextBinding();
									if (b[2] == null) b[1] = null;
									b2changed = true;
								}
								if ( b2changed ) {
									p[3].reset();
									p[3].bind(Term.merge(b, 3));
								}
								b[3] = p[3].nextBinding();
								if (b[3] == null) b[2] = null;
								b3changed = true;
							}
							if ( b3changed ) {
								p[4].reset();
								p[4].bind(Term.merge(b, 4));
							}
							b[4] = p[4].nextBinding();
							if (b[4] == null) b[3] = null;
							b4changed = true;
						}
						if ( b4changed ) {
							p[5].reset();
							p[5].bind(Term.merge(b, 5));
						}
						b[5] = p[5].nextBinding();
						if (b[5] == null) b[4] = null;
						b5changed = true;
					}
					if ( b5changed ) {
						p[6].reset();
						p[6].bind(Term.merge(b, 6));
					}
					b[6] = p[6].nextBinding();
					if (b[6] == null) b[5] = null;
					b6changed = true;
				}
				if ( b6changed ) {
					p[7].reset();
					p[7].bind(Term.merge(b, 7));
				}
				b[7] = p[7].nextBinding();
				if (b[7] == null) b[6] = null;
				b7changed = true;
			}
			if ( b7changed ) {
				p[8].reset();
				p[8].bind(Term.merge(b, 8));
			}
			b[8] = p[8].nextBinding();
			if (b[8] == null) b[7] = null;
		}

		Term[] retVal = Term.merge(b, 9);
		b[8] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		p[3].reset();
		p[4].reset();
		p[5].reset();
		p[6].reset();
		p[7].reset();
		p[8].reset();
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
		b[6] = null;
		b[7] = null;
		b[8] = null;
	}
}

class Operator2 extends Operator
{
	public Operator2()
	{
		super(new Predicate(2, 6, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))), -1, -1, 
			TermVariable.getVariable(5),new TermNumber(0.0010));


		DelAddElement[] instantDelIn = new DelAddElement[1];
		instantDelIn[0] = new DelAddAtomic(new Predicate(11, 6, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), TermList.NIL))));

		setInstantDel(instantDelIn);

		DelAddElement[] instantAddIn = new DelAddElement[0];

		setInstantAdd(instantAddIn);



		Event[] delayedDelIn = new Event[0];

		setDelayedDel(delayedDelIn);

		Event[] delayedAddIn = new Event[1];
		delayedAddIn[0] = new Event (new Predicate(11, 6, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(3), TermList.NIL))),true,TermVariable.getVariable(5) );

		setDelayedAdd(delayedAddIn);


	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		p = (new Precondition3(unifier)).setComparator(null);
		p.reset();

		return p;
	}
}

class Precondition4 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition4(Term[] unifier)
	{
		p = new Precondition[14];
		p[1] = new PreconditionAtomic(new Predicate(6, 11, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier);
		p[2] = new PreconditionAtomic(new Predicate(7, 11, new TermList(TermVariable.getVariable(1), TermList.NIL)), unifier);
		p[3] = new PreconditionAtomic(new Predicate(7, 11, new TermList(TermVariable.getVariable(2), TermList.NIL)), unifier);
		p[4] = new PreconditionAtomic(new Predicate(4, 11, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))), unifier);
		p[5] = new PreconditionAtomic(new Predicate(14, 11, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL)))), unifier);
		p[6] = new PreconditionAtomic(new Predicate(15, 11, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier);
		p[7] = new PreconditionAtomic(new Predicate(16, 11, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(5), TermList.NIL))), unifier);
		p[8] = new PreconditionAtomic(new Predicate(11, 11, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(6), TermList.NIL))), unifier);
		p[9] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(6), new TermList(new TermCall(new List(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(5), TermList.NIL)), StdLib.mult, "StdLib.mult"), TermList.NIL)), StdLib.moreEq, "StdLib.moreEq"), unifier);
		p[10] = new PreconditionAtomic(new Predicate(17, 11, new TermList(TermVariable.getVariable(7), TermList.NIL)), unifier);
		p[11] = new PreconditionAssign(new TermCall(new List(TermVariable.getVariable(7), new TermList(new TermCall(new List(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(5), TermList.NIL)), StdLib.mult, "StdLib.mult"), TermList.NIL)), StdLib.plus, "StdLib.plus"), unifier, 8);
		p[12] = new PreconditionAssign(new TermCall(new List(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(4), TermList.NIL)), StdLib.div, "StdLib.div"), unifier, 9);
		p[13] = new PreconditionAssign(new TermCall(new List(TermVariable.getVariable(6), new TermList(new TermCall(new List(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(5), TermList.NIL)), StdLib.mult, "StdLib.mult"), TermList.NIL)), StdLib.minus, "StdLib.minus"), unifier, 10);
		b = new Term[14][];
		b[0] = unifier;
		b[0] = Term.merge( b, 1 );

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		b[0] = binding;
		b[0] = Term.merge( b, 1 );
		p[1].bind(binding);
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
		b[6] = null;
		b[7] = null;
		b[8] = null;
		b[9] = null;
		b[10] = null;
		b[11] = null;
		b[12] = null;
		b[13] = null;
	}

	protected Term[] nextBindingHelper()
	{
		while (b[13] == null)
		{
			boolean b12changed = false;
			while (b[12] == null)
			{
				boolean b11changed = false;
				while (b[11] == null)
				{
					boolean b10changed = false;
					while (b[10] == null)
					{
						boolean b9changed = false;
						while (b[9] == null)
						{
							boolean b8changed = false;
							while (b[8] == null)
							{
								boolean b7changed = false;
								while (b[7] == null)
								{
									boolean b6changed = false;
									while (b[6] == null)
									{
										boolean b5changed = false;
										while (b[5] == null)
										{
											boolean b4changed = false;
											while (b[4] == null)
											{
												boolean b3changed = false;
												while (b[3] == null)
												{
													boolean b2changed = false;
													while (b[2] == null)
													{
														boolean b1changed = false;
														while (b[1] == null)
														{
															b[1] = p[1].nextBinding();
															if (b[1] == null)
																return null;
															b1changed = true;
														}
														if ( b1changed ) {
															p[2].reset();
															p[2].bind(Term.merge(b, 2));
														}
														b[2] = p[2].nextBinding();
														if (b[2] == null) b[1] = null;
														b2changed = true;
													}
													if ( b2changed ) {
														p[3].reset();
														p[3].bind(Term.merge(b, 3));
													}
													b[3] = p[3].nextBinding();
													if (b[3] == null) b[2] = null;
													b3changed = true;
												}
												if ( b3changed ) {
													p[4].reset();
													p[4].bind(Term.merge(b, 4));
												}
												b[4] = p[4].nextBinding();
												if (b[4] == null) b[3] = null;
												b4changed = true;
											}
											if ( b4changed ) {
												p[5].reset();
												p[5].bind(Term.merge(b, 5));
											}
											b[5] = p[5].nextBinding();
											if (b[5] == null) b[4] = null;
											b5changed = true;
										}
										if ( b5changed ) {
											p[6].reset();
											p[6].bind(Term.merge(b, 6));
										}
										b[6] = p[6].nextBinding();
										if (b[6] == null) b[5] = null;
										b6changed = true;
									}
									if ( b6changed ) {
										p[7].reset();
										p[7].bind(Term.merge(b, 7));
									}
									b[7] = p[7].nextBinding();
									if (b[7] == null) b[6] = null;
									b7changed = true;
								}
								if ( b7changed ) {
									p[8].reset();
									p[8].bind(Term.merge(b, 8));
								}
								b[8] = p[8].nextBinding();
								if (b[8] == null) b[7] = null;
								b8changed = true;
							}
							if ( b8changed ) {
								p[9].reset();
								p[9].bind(Term.merge(b, 9));
							}
							b[9] = p[9].nextBinding();
							if (b[9] == null) b[8] = null;
							b9changed = true;
						}
						if ( b9changed ) {
							p[10].reset();
							p[10].bind(Term.merge(b, 10));
						}
						b[10] = p[10].nextBinding();
						if (b[10] == null) b[9] = null;
						b10changed = true;
					}
					if ( b10changed ) {
						p[11].reset();
						p[11].bind(Term.merge(b, 11));
					}
					b[11] = p[11].nextBinding();
					if (b[11] == null) b[10] = null;
					b11changed = true;
				}
				if ( b11changed ) {
					p[12].reset();
					p[12].bind(Term.merge(b, 12));
				}
				b[12] = p[12].nextBinding();
				if (b[12] == null) b[11] = null;
				b12changed = true;
			}
			if ( b12changed ) {
				p[13].reset();
				p[13].bind(Term.merge(b, 13));
			}
			b[13] = p[13].nextBinding();
			if (b[13] == null) b[12] = null;
		}

		Term[] retVal = Term.merge(b, 14);
		b[13] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		p[3].reset();
		p[4].reset();
		p[5].reset();
		p[6].reset();
		p[7].reset();
		p[8].reset();
		p[9].reset();
		p[10].reset();
		p[11].reset();
		p[12].reset();
		p[13].reset();
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
		b[6] = null;
		b[7] = null;
		b[8] = null;
		b[9] = null;
		b[10] = null;
		b[11] = null;
		b[12] = null;
		b[13] = null;
	}
}

class Operator3 extends Operator
{
	public Operator3()
	{
		super(new Predicate(3, 11, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))), -1, -1, 
			TermVariable.getVariable(9),new TermNumber(0.0010));


		DelAddElement[] instantDelIn = new DelAddElement[3];
		instantDelIn[0] = new DelAddAtomic(new Predicate(4, 11, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))));
		instantDelIn[1] = new DelAddAtomic(new Predicate(17, 11, new TermList(TermVariable.getVariable(7), TermList.NIL)));
		instantDelIn[2] = new DelAddAtomic(new Predicate(11, 11, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(6), TermList.NIL))));

		setInstantDel(instantDelIn);

		DelAddElement[] instantAddIn = new DelAddElement[1];
		instantAddIn[0] = new DelAddAtomic(new Predicate(17, 11, new TermList(TermVariable.getVariable(8), TermList.NIL)));

		setInstantAdd(instantAddIn);



		Event[] delayedDelIn = new Event[0];

		setDelayedDel(delayedDelIn);

		Event[] delayedAddIn = new Event[2];
		delayedAddIn[0] = new Event (new Predicate(4, 11, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), TermList.NIL))),true,TermVariable.getVariable(9) );
		delayedAddIn[1] = new Event (new Predicate(11, 11, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(10), TermList.NIL))),true,TermVariable.getVariable(9) );

		setDelayedAdd(delayedAddIn);


	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		p = (new Precondition4(unifier)).setComparator(null);
		p.reset();

		return p;
	}
}

class Precondition5 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition5(Term[] unifier)
	{
		p = new Precondition[14];
		p[1] = new PreconditionAtomic(new Predicate(6, 11, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier);
		p[2] = new PreconditionAtomic(new Predicate(7, 11, new TermList(TermVariable.getVariable(1), TermList.NIL)), unifier);
		p[3] = new PreconditionAtomic(new Predicate(7, 11, new TermList(TermVariable.getVariable(2), TermList.NIL)), unifier);
		p[4] = new PreconditionAtomic(new Predicate(4, 11, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))), unifier);
		p[5] = new PreconditionAtomic(new Predicate(14, 11, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL)))), unifier);
		p[6] = new PreconditionAtomic(new Predicate(18, 11, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier);
		p[7] = new PreconditionAtomic(new Predicate(19, 11, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(5), TermList.NIL))), unifier);
		p[8] = new PreconditionAtomic(new Predicate(11, 11, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(6), TermList.NIL))), unifier);
		p[9] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(6), new TermList(new TermCall(new List(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(4), TermList.NIL)), StdLib.mult, "StdLib.mult"), TermList.NIL)), StdLib.moreEq, "StdLib.moreEq"), unifier);
		p[10] = new PreconditionAtomic(new Predicate(17, 11, new TermList(TermVariable.getVariable(7), TermList.NIL)), unifier);
		p[11] = new PreconditionAssign(new TermCall(new List(TermVariable.getVariable(7), new TermList(new TermCall(new List(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(4), TermList.NIL)), StdLib.mult, "StdLib.mult"), TermList.NIL)), StdLib.plus, "StdLib.plus"), unifier, 8);
		p[12] = new PreconditionAssign(new TermCall(new List(TermVariable.getVariable(6), new TermList(new TermCall(new List(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(4), TermList.NIL)), StdLib.mult, "StdLib.mult"), TermList.NIL)), StdLib.minus, "StdLib.minus"), unifier, 9);
		p[13] = new PreconditionAssign(new TermCall(new List(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(5), TermList.NIL)), StdLib.div, "StdLib.div"), unifier, 10);
		b = new Term[14][];
		b[0] = unifier;
		b[0] = Term.merge( b, 1 );

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		b[0] = binding;
		b[0] = Term.merge( b, 1 );
		p[1].bind(binding);
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
		b[6] = null;
		b[7] = null;
		b[8] = null;
		b[9] = null;
		b[10] = null;
		b[11] = null;
		b[12] = null;
		b[13] = null;
	}

	protected Term[] nextBindingHelper()
	{
		while (b[13] == null)
		{
			boolean b12changed = false;
			while (b[12] == null)
			{
				boolean b11changed = false;
				while (b[11] == null)
				{
					boolean b10changed = false;
					while (b[10] == null)
					{
						boolean b9changed = false;
						while (b[9] == null)
						{
							boolean b8changed = false;
							while (b[8] == null)
							{
								boolean b7changed = false;
								while (b[7] == null)
								{
									boolean b6changed = false;
									while (b[6] == null)
									{
										boolean b5changed = false;
										while (b[5] == null)
										{
											boolean b4changed = false;
											while (b[4] == null)
											{
												boolean b3changed = false;
												while (b[3] == null)
												{
													boolean b2changed = false;
													while (b[2] == null)
													{
														boolean b1changed = false;
														while (b[1] == null)
														{
															b[1] = p[1].nextBinding();
															if (b[1] == null)
																return null;
															b1changed = true;
														}
														if ( b1changed ) {
															p[2].reset();
															p[2].bind(Term.merge(b, 2));
														}
														b[2] = p[2].nextBinding();
														if (b[2] == null) b[1] = null;
														b2changed = true;
													}
													if ( b2changed ) {
														p[3].reset();
														p[3].bind(Term.merge(b, 3));
													}
													b[3] = p[3].nextBinding();
													if (b[3] == null) b[2] = null;
													b3changed = true;
												}
												if ( b3changed ) {
													p[4].reset();
													p[4].bind(Term.merge(b, 4));
												}
												b[4] = p[4].nextBinding();
												if (b[4] == null) b[3] = null;
												b4changed = true;
											}
											if ( b4changed ) {
												p[5].reset();
												p[5].bind(Term.merge(b, 5));
											}
											b[5] = p[5].nextBinding();
											if (b[5] == null) b[4] = null;
											b5changed = true;
										}
										if ( b5changed ) {
											p[6].reset();
											p[6].bind(Term.merge(b, 6));
										}
										b[6] = p[6].nextBinding();
										if (b[6] == null) b[5] = null;
										b6changed = true;
									}
									if ( b6changed ) {
										p[7].reset();
										p[7].bind(Term.merge(b, 7));
									}
									b[7] = p[7].nextBinding();
									if (b[7] == null) b[6] = null;
									b7changed = true;
								}
								if ( b7changed ) {
									p[8].reset();
									p[8].bind(Term.merge(b, 8));
								}
								b[8] = p[8].nextBinding();
								if (b[8] == null) b[7] = null;
								b8changed = true;
							}
							if ( b8changed ) {
								p[9].reset();
								p[9].bind(Term.merge(b, 9));
							}
							b[9] = p[9].nextBinding();
							if (b[9] == null) b[8] = null;
							b9changed = true;
						}
						if ( b9changed ) {
							p[10].reset();
							p[10].bind(Term.merge(b, 10));
						}
						b[10] = p[10].nextBinding();
						if (b[10] == null) b[9] = null;
						b10changed = true;
					}
					if ( b10changed ) {
						p[11].reset();
						p[11].bind(Term.merge(b, 11));
					}
					b[11] = p[11].nextBinding();
					if (b[11] == null) b[10] = null;
					b11changed = true;
				}
				if ( b11changed ) {
					p[12].reset();
					p[12].bind(Term.merge(b, 12));
				}
				b[12] = p[12].nextBinding();
				if (b[12] == null) b[11] = null;
				b12changed = true;
			}
			if ( b12changed ) {
				p[13].reset();
				p[13].bind(Term.merge(b, 13));
			}
			b[13] = p[13].nextBinding();
			if (b[13] == null) b[12] = null;
		}

		Term[] retVal = Term.merge(b, 14);
		b[13] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		p[3].reset();
		p[4].reset();
		p[5].reset();
		p[6].reset();
		p[7].reset();
		p[8].reset();
		p[9].reset();
		p[10].reset();
		p[11].reset();
		p[12].reset();
		p[13].reset();
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
		b[6] = null;
		b[7] = null;
		b[8] = null;
		b[9] = null;
		b[10] = null;
		b[11] = null;
		b[12] = null;
		b[13] = null;
	}
}

class Operator4 extends Operator
{
	public Operator4()
	{
		super(new Predicate(4, 11, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))), -1, -1, 
			TermVariable.getVariable(10),new TermNumber(0.0010));


		DelAddElement[] instantDelIn = new DelAddElement[3];
		instantDelIn[0] = new DelAddAtomic(new Predicate(4, 11, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))));
		instantDelIn[1] = new DelAddAtomic(new Predicate(17, 11, new TermList(TermVariable.getVariable(7), TermList.NIL)));
		instantDelIn[2] = new DelAddAtomic(new Predicate(11, 11, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(6), TermList.NIL))));

		setInstantDel(instantDelIn);

		DelAddElement[] instantAddIn = new DelAddElement[1];
		instantAddIn[0] = new DelAddAtomic(new Predicate(17, 11, new TermList(TermVariable.getVariable(8), TermList.NIL)));

		setInstantAdd(instantAddIn);



		Event[] delayedDelIn = new Event[0];

		setDelayedDel(delayedDelIn);

		Event[] delayedAddIn = new Event[2];
		delayedAddIn[0] = new Event (new Predicate(4, 11, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), TermList.NIL))),true,TermVariable.getVariable(10) );
		delayedAddIn[1] = new Event (new Predicate(11, 11, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(9), TermList.NIL))),true,TermVariable.getVariable(10) );

		setDelayedAdd(delayedAddIn);


	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		p = (new Precondition5(unifier)).setComparator(null);
		p.reset();

		return p;
	}
}

class Operator5 extends Operator
{
	public Operator5()
	{
		super(new Predicate(5, 1, new TermList(TermVariable.getVariable(0), TermList.NIL)), -1, 0, 
			new TermNumber(0.0),new TermNumber(0.0));


		DelAddElement[] instantDelIn = new DelAddElement[0];

		setInstantDel(instantDelIn);

		Event[] delayedDelIn = new Event[0];

		setDelayedDel(delayedDelIn);

		Event[] delayedAddIn = new Event[0];

		setDelayedAdd(delayedAddIn);


	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		p = (new PreconditionNil(1)).setComparator(null);
		p.reset();

		return p;
	}
}

class Operator6 extends Operator
{
	public Operator6()
	{
		super(new Predicate(6, 2, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))), 0, 1, 
			new TermNumber(0.0),new TermNumber(0.0));


		Event[] delayedDelIn = new Event[0];

		setDelayedDel(delayedDelIn);

		Event[] delayedAddIn = new Event[0];

		setDelayedAdd(delayedAddIn);


	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		p = (new PreconditionNil(2)).setComparator(null);
		p.reset();

		return p;
	}
}

class Method0 extends Method
{
	public Method0()
	{
		super(new Predicate(0, 2, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))));
		TaskList[] subsIn = new TaskList[1];

		Vector<Vector<TimeConstraint>> subTcls = new Vector<Vector<TimeConstraint>>();


		subsIn[0] = TaskList.empty;


		subTcls.add(new Vector<TimeConstraint>());
		subTcls.set(0, null);


		setSubs(subsIn);
		setSubTcls(subTcls);
	}


	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new PreconditionAtomic(new Predicate(4, 2, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))), unifier)).setComparator(null);
			break;
			default:
				return null;
		}

		p.reset();

		return p;
	}

	public String getLabel(int which)
	{
		switch (which)
		{
			case 0: return "Method0Branch0";
			default: return null;
		}
	}
}

class Precondition6 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition6(Term[] unifier)
	{
		p = new Precondition[6];
		p[1] = new PreconditionAtomic(new Predicate(4, 5, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier);
		p[2] = new PreconditionAtomic(new Predicate(4, 5, new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier);
		p[3] = new PreconditionAtomic(new Predicate(6, 5, new TermList(TermVariable.getVariable(3), TermList.NIL)), unifier);
		p[4] = new PreconditionAtomic(new Predicate(13, 5, new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier);
		p[5] = new PreconditionNegation(new PreconditionAtomic(new Predicate(20, 5, new TermList(TermVariable.getVariable(3), TermList.NIL)), unifier), 5);
		b = new Term[6][];
		b[0] = unifier;
		b[0] = Term.merge( b, 1 );

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		b[0] = binding;
		b[0] = Term.merge( b, 1 );
		p[1].bind(binding);
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
	}

	protected Term[] nextBindingHelper()
	{
		while (b[5] == null)
		{
			boolean b4changed = false;
			while (b[4] == null)
			{
				boolean b3changed = false;
				while (b[3] == null)
				{
					boolean b2changed = false;
					while (b[2] == null)
					{
						boolean b1changed = false;
						while (b[1] == null)
						{
							b[1] = p[1].nextBinding();
							if (b[1] == null)
								return null;
							b1changed = true;
						}
						if ( b1changed ) {
							p[2].reset();
							p[2].bind(Term.merge(b, 2));
						}
						b[2] = p[2].nextBinding();
						if (b[2] == null) b[1] = null;
						b2changed = true;
					}
					if ( b2changed ) {
						p[3].reset();
						p[3].bind(Term.merge(b, 3));
					}
					b[3] = p[3].nextBinding();
					if (b[3] == null) b[2] = null;
					b3changed = true;
				}
				if ( b3changed ) {
					p[4].reset();
					p[4].bind(Term.merge(b, 4));
				}
				b[4] = p[4].nextBinding();
				if (b[4] == null) b[3] = null;
				b4changed = true;
			}
			if ( b4changed ) {
				p[5].reset();
				p[5].bind(Term.merge(b, 5));
			}
			b[5] = p[5].nextBinding();
			if (b[5] == null) b[4] = null;
		}

		Term[] retVal = Term.merge(b, 6);
		b[5] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		p[3].reset();
		p[4].reset();
		p[5].reset();
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
	}
}

class Method1 extends Method
{
	public Method1()
	{
		super(new Predicate(0, 5, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))));
		TaskList[] subsIn = new TaskList[1];

		Vector<Vector<TimeConstraint>> subTcls = new Vector<Vector<TimeConstraint>>();


		subsIn[0] = createTaskList0();


		subTcls.add(new Vector<TimeConstraint>());
		subTcls.set(0, null);


		setSubs(subsIn);
		setSubTcls(subTcls);
	}
	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(5, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(5, 5, new TermList(new TermList(new TermList(TermConstant.getConstant(20), new TermList(TermVariable.getVariable(3), TermList.NIL)), TermList.NIL), TermList.NIL)), false, true, new TermNumber(1.0)));
		retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(0, 5, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(2), TermList.NIL)))), false, true, new TermNumber(1.0)));
		retVal.subtasks[2] = new TaskList(new TaskAtom(new Predicate(1, 5, new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(1), TermList.NIL))), false, false, new TermNumber(1.0)));
		retVal.subtasks[3] = new TaskList(new TaskAtom(new Predicate(1, 5, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(1), TermList.NIL)))), false, true, new TermNumber(1.0)));
		retVal.subtasks[4] = new TaskList(new TaskAtom(new Predicate(6, 5, new TermList(new TermList(new TermList(TermConstant.getConstant(20), new TermList(TermVariable.getVariable(3), TermList.NIL)), TermList.NIL), new TermList(TermList.NIL, TermList.NIL))), false, true, new TermNumber(1.0)));

		return retVal;
	}



	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new Precondition6(unifier)).setComparator(new CompMore(4));
			break;
			default:
				return null;
		}

		p.reset();

		return p;
	}

	public String getLabel(int which)
	{
		switch (which)
		{
			case 0: return "Method1Branch0";
			default: return null;
		}
	}
}

class Precondition7 extends Precondition
{
	Precondition[] p;
	Term[] b;
	int whichClause;

	public Precondition7(Term[] unifier)
	{
		p = new Precondition[2];
		p[0] = new PreconditionNegation(new PreconditionAtomic(new Predicate(1, 8, new TermList(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier), 8);

		p[1] = new PreconditionNegation(new PreconditionAtomic(new Predicate(2, 8, new TermList(TermVariable.getVariable(4), TermList.NIL)), unifier), 8);

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		p[0].bind(binding);
		p[1].bind(binding);
	}

	protected Term[] nextBindingHelper()
	{
		while (whichClause < 2)
		{
			b = p[whichClause].nextBinding();
			if (b != null)
				 return b;
			whichClause++;
		}

		return null;
	}

	protected void resetHelper()
	{
		p[0].reset();
		p[1].reset();
		whichClause = 0;
	}
}

class Precondition8 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition8(Term[] unifier)
	{
		p = new Precondition[9];
		p[1] = new PreconditionAtomic(new Predicate(4, 8, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier);
		p[2] = new PreconditionAtomic(new Predicate(6, 8, new TermList(TermVariable.getVariable(3), TermList.NIL)), unifier);
		p[3] = new PreconditionAtomic(new Predicate(4, 8, new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier);
		p[4] = new PreconditionNegation(new PreconditionAtomic(new Predicate(20, 8, new TermList(TermVariable.getVariable(3), TermList.NIL)), unifier), 8);
		p[5] = new PreconditionAtomic(new Predicate(1, 8, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier);
		p[6] = new PreconditionForAll(new PreconditionAtomic(new Predicate(21, 8, new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(5), TermList.NIL))), unifier), new PreconditionAtomic(new Predicate(0, 8, new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier), 8);
		p[7] = new Precondition7(unifier);
		p[8] = new PreconditionAtomic(new Predicate(22, 8, new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(6), new TermList(TermVariable.getVariable(7), TermList.NIL)))))), unifier);
		b = new Term[9][];
		b[0] = unifier;
		b[0] = Term.merge( b, 1 );

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		b[0] = binding;
		b[0] = Term.merge( b, 1 );
		p[1].bind(binding);
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
		b[6] = null;
		b[7] = null;
		b[8] = null;
	}

	protected Term[] nextBindingHelper()
	{
		while (b[8] == null)
		{
			boolean b7changed = false;
			while (b[7] == null)
			{
				boolean b6changed = false;
				while (b[6] == null)
				{
					boolean b5changed = false;
					while (b[5] == null)
					{
						boolean b4changed = false;
						while (b[4] == null)
						{
							boolean b3changed = false;
							while (b[3] == null)
							{
								boolean b2changed = false;
								while (b[2] == null)
								{
									boolean b1changed = false;
									while (b[1] == null)
									{
										b[1] = p[1].nextBinding();
										if (b[1] == null)
											return null;
										b1changed = true;
									}
									if ( b1changed ) {
										p[2].reset();
										p[2].bind(Term.merge(b, 2));
									}
									b[2] = p[2].nextBinding();
									if (b[2] == null) b[1] = null;
									b2changed = true;
								}
								if ( b2changed ) {
									p[3].reset();
									p[3].bind(Term.merge(b, 3));
								}
								b[3] = p[3].nextBinding();
								if (b[3] == null) b[2] = null;
								b3changed = true;
							}
							if ( b3changed ) {
								p[4].reset();
								p[4].bind(Term.merge(b, 4));
							}
							b[4] = p[4].nextBinding();
							if (b[4] == null) b[3] = null;
							b4changed = true;
						}
						if ( b4changed ) {
							p[5].reset();
							p[5].bind(Term.merge(b, 5));
						}
						b[5] = p[5].nextBinding();
						if (b[5] == null) b[4] = null;
						b5changed = true;
					}
					if ( b5changed ) {
						p[6].reset();
						p[6].bind(Term.merge(b, 6));
					}
					b[6] = p[6].nextBinding();
					if (b[6] == null) b[5] = null;
					b6changed = true;
				}
				if ( b6changed ) {
					p[7].reset();
					p[7].bind(Term.merge(b, 7));
				}
				b[7] = p[7].nextBinding();
				if (b[7] == null) b[6] = null;
				b7changed = true;
			}
			if ( b7changed ) {
				p[8].reset();
				p[8].bind(Term.merge(b, 8));
			}
			b[8] = p[8].nextBinding();
			if (b[8] == null) b[7] = null;
		}

		Term[] retVal = Term.merge(b, 9);
		b[8] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		p[3].reset();
		p[4].reset();
		p[5].reset();
		p[6].reset();
		p[7].reset();
		p[8].reset();
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
		b[6] = null;
		b[7] = null;
		b[8] = null;
	}
}

class Method2 extends Method
{
	public Method2()
	{
		super(new Predicate(0, 8, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))));
		TaskList[] subsIn = new TaskList[1];

		Vector<Vector<TimeConstraint>> subTcls = new Vector<Vector<TimeConstraint>>();


		subsIn[0] = createTaskList0();


		subTcls.add(new Vector<TimeConstraint>());
		subTcls.set(0, null);


		setSubs(subsIn);
		setSubTcls(subTcls);
	}
	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(6, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(5, 8, new TermList(new TermList(new TermList(TermConstant.getConstant(20), new TermList(TermVariable.getVariable(3), TermList.NIL)), TermList.NIL), TermList.NIL)), false, true, new TermNumber(1.0)));
		retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(2, 8, new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(7), TermList.NIL)))), false, false, new TermNumber(1.0)));
		retVal.subtasks[2] = new TaskList(new TaskAtom(new Predicate(0, 8, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(2), TermList.NIL)))), false, true, new TermNumber(1.0)));
		retVal.subtasks[3] = new TaskList(new TaskAtom(new Predicate(1, 8, new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(1), TermList.NIL))), false, false, new TermNumber(1.0)));
		retVal.subtasks[4] = new TaskList(new TaskAtom(new Predicate(1, 8, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(1), TermList.NIL)))), false, true, new TermNumber(1.0)));
		retVal.subtasks[5] = new TaskList(new TaskAtom(new Predicate(6, 8, new TermList(new TermList(new TermList(TermConstant.getConstant(20), new TermList(TermVariable.getVariable(3), TermList.NIL)), TermList.NIL), new TermList(TermList.NIL, TermList.NIL))), false, true, new TermNumber(1.0)));

		return retVal;
	}



	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new Precondition8(unifier)).setComparator(new CompLess(6));
			break;
			default:
				return null;
		}

		p.reset();

		return p;
	}

	public String getLabel(int which)
	{
		switch (which)
		{
			case 0: return "Method2Branch0";
			default: return null;
		}
	}
}

class Method3 extends Method
{
	public Method3()
	{
		super(new Predicate(2, 4, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))));
		TaskList[] subsIn = new TaskList[2];

		Vector<Vector<TimeConstraint>> subTcls = new Vector<Vector<TimeConstraint>>();


		subsIn[0] = TaskList.empty;
		subsIn[1] = createTaskList1();


		subTcls.add(new Vector<TimeConstraint>());
		subTcls.set(0, null);
		subTcls.add(new Vector<TimeConstraint>());
		subTcls.set(1, null);


		setSubs(subsIn);
		setSubTcls(subTcls);
	}
	TaskList createTaskList1()
	{
		TaskList retVal;

		retVal = new TaskList(1, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(3, 4, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL))))), false, false, new TermNumber(1.0)));

		return retVal;
	}



	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new PreconditionAtomic(new Predicate(4, 4, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))), unifier)).setComparator(null);
			break;
			case 1:
				p = (new PreconditionAtomic(new Predicate(4, 4, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(3), TermList.NIL))), unifier)).setComparator(null);
			break;
			default:
				return null;
		}

		p.reset();

		return p;
	}

	public String getLabel(int which)
	{
		switch (which)
		{
			case 0: return "Case1";
			case 1: return "Case2";
			default: return null;
		}
	}
}

class Precondition9 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition9(Term[] unifier)
	{
		p = new Precondition[3];
		p[1] = new PreconditionAtomic(new Predicate(4, 5, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier);
		p[2] = new PreconditionAtomic(new Predicate(22, 5, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(4), TermList.NIL)))))), unifier);
		b = new Term[3][];
		b[0] = unifier;
		b[0] = Term.merge( b, 1 );

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		b[0] = binding;
		b[0] = Term.merge( b, 1 );
		p[1].bind(binding);
		b[1] = null;
		b[2] = null;
	}

	protected Term[] nextBindingHelper()
	{
		while (b[2] == null)
		{
			boolean b1changed = false;
			while (b[1] == null)
			{
				b[1] = p[1].nextBinding();
				if (b[1] == null)
					return null;
				b1changed = true;
			}
			if ( b1changed ) {
				p[2].reset();
				p[2].bind(Term.merge(b, 2));
			}
			b[2] = p[2].nextBinding();
			if (b[2] == null) b[1] = null;
		}

		Term[] retVal = Term.merge(b, 3);
		b[2] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		b[1] = null;
		b[2] = null;
	}
}

class Method4 extends Method
{
	public Method4()
	{
		super(new Predicate(1, 5, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))));
		TaskList[] subsIn = new TaskList[2];

		Vector<Vector<TimeConstraint>> subTcls = new Vector<Vector<TimeConstraint>>();


		subsIn[0] = TaskList.empty;
		subsIn[1] = createTaskList1();


		subTcls.add(new Vector<TimeConstraint>());
		subTcls.set(0, null);
		subTcls.add(new Vector<TimeConstraint>());
		subTcls.set(1, null);


		setSubs(subsIn);
		setSubTcls(subTcls);
	}
	TaskList createTaskList1()
	{
		TaskList retVal;

		retVal = new TaskList(1, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(3, 5, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(4), TermList.NIL))))), false, false, new TermNumber(1.0)));

		return retVal;
	}



	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new PreconditionAtomic(new Predicate(4, 5, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))), unifier)).setComparator(null);
			break;
			case 1:
				p = (new Precondition9(unifier)).setComparator(new CompLess(3));
			break;
			default:
				return null;
		}

		p.reset();

		return p;
	}

	public String getLabel(int which)
	{
		switch (which)
		{
			case 0: return "Case1";
			case 1: return "Case2";
			default: return null;
		}
	}
}

class Precondition16 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition16(Term[] unifier)
	{
		p = new Precondition[5];
		p[1] = new PreconditionAtomic(new Predicate(14, 6, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL)))), unifier);
		p[2] = new PreconditionAtomic(new Predicate(18, 6, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier);
		p[3] = new PreconditionAtomic(new Predicate(11, 6, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(5), TermList.NIL))), unifier);
		p[4] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(5), new TermList(new TermCall(new List(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(4), TermList.NIL)), StdLib.mult, "StdLib.mult"), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
		b = new Term[5][];
		b[0] = unifier;
		b[0] = Term.merge( b, 1 );

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		b[0] = binding;
		b[0] = Term.merge( b, 1 );
		p[1].bind(binding);
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
	}

	protected Term[] nextBindingHelper()
	{
		while (b[4] == null)
		{
			boolean b3changed = false;
			while (b[3] == null)
			{
				boolean b2changed = false;
				while (b[2] == null)
				{
					boolean b1changed = false;
					while (b[1] == null)
					{
						b[1] = p[1].nextBinding();
						if (b[1] == null)
							return null;
						b1changed = true;
					}
					if ( b1changed ) {
						p[2].reset();
						p[2].bind(Term.merge(b, 2));
					}
					b[2] = p[2].nextBinding();
					if (b[2] == null) b[1] = null;
					b2changed = true;
				}
				if ( b2changed ) {
					p[3].reset();
					p[3].bind(Term.merge(b, 3));
				}
				b[3] = p[3].nextBinding();
				if (b[3] == null) b[2] = null;
				b3changed = true;
			}
			if ( b3changed ) {
				p[4].reset();
				p[4].bind(Term.merge(b, 4));
			}
			b[4] = p[4].nextBinding();
			if (b[4] == null) b[3] = null;
		}

		Term[] retVal = Term.merge(b, 5);
		b[4] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		p[3].reset();
		p[4].reset();
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
	}
}

class Method5 extends Method
{
	public Method5()
	{
		super(new Predicate(3, 6, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermConstant.getConstant(23), TermList.NIL))))));
		TaskList[] subsIn = new TaskList[2];

		Vector<Vector<TimeConstraint>> subTcls = new Vector<Vector<TimeConstraint>>();


		subsIn[0] = createTaskList0();
		subsIn[1] = createTaskList1();


		subTcls.add(new Vector<TimeConstraint>());
		subTcls.set(0, null);
		subTcls.add(new Vector<TimeConstraint>());
		subTcls.set(1, null);


		setSubs(subsIn);
		setSubTcls(subTcls);
	}
	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(1, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(4, 6, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))), false, true, new TermNumber(1.0)));

		return retVal;
	}

	TaskList createTaskList1()
	{
		TaskList retVal;

		retVal = new TaskList(2, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(2, 6, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))), false, true, new TermNumber(1.0)));
		retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(4, 6, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))), false, true, new TermNumber(1.0)));

		return retVal;
	}



	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new Precondition16(unifier)).setComparator(null);
			break;
			case 1:
				p = (new PreconditionNil(6)).setComparator(null);
			break;
			default:
				return null;
		}

		p.reset();

		return p;
	}

	public String getLabel(int which)
	{
		switch (which)
		{
			case 0: return "Method5Branch0";
			case 1: return "Method5Branch1";
			default: return null;
		}
	}
}

class Precondition17 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition17(Term[] unifier)
	{
		p = new Precondition[5];
		p[1] = new PreconditionAtomic(new Predicate(14, 6, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL)))), unifier);
		p[2] = new PreconditionAtomic(new Predicate(16, 6, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier);
		p[3] = new PreconditionAtomic(new Predicate(11, 6, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(5), TermList.NIL))), unifier);
		p[4] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(5), new TermList(new TermCall(new List(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(4), TermList.NIL)), StdLib.mult, "StdLib.mult"), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
		b = new Term[5][];
		b[0] = unifier;
		b[0] = Term.merge( b, 1 );

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		b[0] = binding;
		b[0] = Term.merge( b, 1 );
		p[1].bind(binding);
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
	}

	protected Term[] nextBindingHelper()
	{
		while (b[4] == null)
		{
			boolean b3changed = false;
			while (b[3] == null)
			{
				boolean b2changed = false;
				while (b[2] == null)
				{
					boolean b1changed = false;
					while (b[1] == null)
					{
						b[1] = p[1].nextBinding();
						if (b[1] == null)
							return null;
						b1changed = true;
					}
					if ( b1changed ) {
						p[2].reset();
						p[2].bind(Term.merge(b, 2));
					}
					b[2] = p[2].nextBinding();
					if (b[2] == null) b[1] = null;
					b2changed = true;
				}
				if ( b2changed ) {
					p[3].reset();
					p[3].bind(Term.merge(b, 3));
				}
				b[3] = p[3].nextBinding();
				if (b[3] == null) b[2] = null;
				b3changed = true;
			}
			if ( b3changed ) {
				p[4].reset();
				p[4].bind(Term.merge(b, 4));
			}
			b[4] = p[4].nextBinding();
			if (b[4] == null) b[3] = null;
		}

		Term[] retVal = Term.merge(b, 5);
		b[4] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		p[3].reset();
		p[4].reset();
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
	}
}

class Method6 extends Method
{
	public Method6()
	{
		super(new Predicate(3, 6, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermConstant.getConstant(24), TermList.NIL))))));
		TaskList[] subsIn = new TaskList[2];

		Vector<Vector<TimeConstraint>> subTcls = new Vector<Vector<TimeConstraint>>();


		subsIn[0] = createTaskList0();
		subsIn[1] = createTaskList1();


		subTcls.add(new Vector<TimeConstraint>());
		subTcls.set(0, null);
		subTcls.add(new Vector<TimeConstraint>());
		subTcls.set(1, null);


		setSubs(subsIn);
		setSubTcls(subTcls);
	}
	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(1, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(3, 6, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))), false, true, new TermNumber(1.0)));

		return retVal;
	}

	TaskList createTaskList1()
	{
		TaskList retVal;

		retVal = new TaskList(2, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(2, 6, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))), false, true, new TermNumber(1.0)));
		retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(3, 6, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))), false, true, new TermNumber(1.0)));

		return retVal;
	}



	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new Precondition17(unifier)).setComparator(null);
			break;
			case 1:
				p = (new PreconditionNil(6)).setComparator(null);
			break;
			default:
				return null;
		}

		p.reset();

		return p;
	}

	public String getLabel(int which)
	{
		switch (which)
		{
			case 0: return "Method6Branch0";
			case 1: return "Method6Branch1";
			default: return null;
		}
	}
}

class Method7 extends Method
{
	public Method7()
	{
		super(new Predicate(4, 2, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))));
		TaskList[] subsIn = new TaskList[1];

		Vector<Vector<TimeConstraint>> subTcls = new Vector<Vector<TimeConstraint>>();


		subsIn[0] = createTaskList0();


		subTcls.add(new Vector<TimeConstraint>());
		subTcls.set(0, null);


		setSubs(subsIn);
		setSubTcls(subTcls);
	}
	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(3, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(5, 2, new TermList(new TermList(new TermList(TermConstant.getConstant(20), new TermList(TermVariable.getVariable(0), TermList.NIL)), TermList.NIL), TermList.NIL)), false, true, new TermNumber(1.0)));
		retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(1, 2, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))), false, false, new TermNumber(1.0)));
		retVal.subtasks[2] = new TaskList(new TaskAtom(new Predicate(6, 2, new TermList(new TermList(new TermList(TermConstant.getConstant(20), new TermList(TermVariable.getVariable(0), TermList.NIL)), TermList.NIL), new TermList(TermList.NIL, TermList.NIL))), false, true, new TermNumber(1.0)));

		return retVal;
	}



	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new PreconditionNegation(new PreconditionAtomic(new Predicate(20, 2, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier), 2)).setComparator(null);
			break;
			default:
				return null;
		}

		p.reset();

		return p;
	}

	public String getLabel(int which)
	{
		switch (which)
		{
			case 0: return "Method7Branch0";
			default: return null;
		}
	}
}

class Axiom0 extends Axiom
{
	public Axiom0()
	{
		super(new Predicate(0, 1, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(0), TermList.NIL))), 1);
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new PreconditionNil(1)).setComparator(null);
			break;
			default:
				return null;
		}

		p.reset();

		return p;
	}

	public String getLabel(int which)
	{
		switch (which)
		{
			case 0: return "Axiom0Branch0";
			default: return null;
		}
	}
}

class Axiom1 extends Axiom
{
	public Axiom1()
	{
		super(new Predicate(1, 2, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))), 1);
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new PreconditionNegation(new PreconditionAtomic(new Predicate(0, 2, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))), unifier), 2)).setComparator(null);
			break;
			default:
				return null;
		}

		p.reset();

		return p;
	}

	public String getLabel(int which)
	{
		switch (which)
		{
			case 0: return "Axiom1Branch0";
			default: return null;
		}
	}
}

class Precondition0 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition0(Term[] unifier)
	{
		p = new Precondition[5];
		p[1] = new PreconditionAtomic(new Predicate(3, 3, new TermList(TermVariable.getVariable(1), TermList.NIL)), unifier);
		p[2] = new PreconditionAtomic(new Predicate(4, 3, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(0), TermList.NIL))), unifier);
		p[3] = new PreconditionAtomic(new Predicate(5, 3, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier);
		p[4] = new PreconditionAtomic(new Predicate(1, 3, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(0), TermList.NIL))), unifier);
		b = new Term[5][];
		b[0] = unifier;
		b[0] = Term.merge( b, 1 );

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		b[0] = binding;
		b[0] = Term.merge( b, 1 );
		p[1].bind(binding);
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
	}

	protected Term[] nextBindingHelper()
	{
		while (b[4] == null)
		{
			boolean b3changed = false;
			while (b[3] == null)
			{
				boolean b2changed = false;
				while (b[2] == null)
				{
					boolean b1changed = false;
					while (b[1] == null)
					{
						b[1] = p[1].nextBinding();
						if (b[1] == null)
							return null;
						b1changed = true;
					}
					if ( b1changed ) {
						p[2].reset();
						p[2].bind(Term.merge(b, 2));
					}
					b[2] = p[2].nextBinding();
					if (b[2] == null) b[1] = null;
					b2changed = true;
				}
				if ( b2changed ) {
					p[3].reset();
					p[3].bind(Term.merge(b, 3));
				}
				b[3] = p[3].nextBinding();
				if (b[3] == null) b[2] = null;
				b3changed = true;
			}
			if ( b3changed ) {
				p[4].reset();
				p[4].bind(Term.merge(b, 4));
			}
			b[4] = p[4].nextBinding();
			if (b[4] == null) b[3] = null;
		}

		Term[] retVal = Term.merge(b, 5);
		b[4] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		p[3].reset();
		p[4].reset();
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
	}
}

class Axiom2 extends Axiom
{
	public Axiom2()
	{
		super(new Predicate(2, 3, new TermList(TermVariable.getVariable(0), TermList.NIL)), 1);
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new Precondition0(unifier)).setComparator(null);
			break;
			default:
				return null;
		}

		p.reset();

		return p;
	}

	public String getLabel(int which)
	{
		switch (which)
		{
			case 0: return "Axiom2Branch0";
			default: return null;
		}
	}
}

class Precondition10 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition10(Term[] unifier)
	{
		p = new Precondition[6];
		p[1] = new PreconditionAtomic(new Predicate(12, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier);
		p[2] = new PreconditionAtomic(new Predicate(14, 10, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(5), TermList.NIL)))), unifier);
		p[3] = new PreconditionAtomic(new Predicate(18, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(6), TermList.NIL))), unifier);
		p[4] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(4), new TermList(new TermCall(new List(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(6), TermList.NIL)), StdLib.mult, "StdLib.mult"), TermList.NIL)), StdLib.less, "StdLib.less"), unifier);
		p[5] = new PreconditionAssign(new TermCall(new List(new TermCall(new List(new TermNumber(2.0), new TermList(new TermNumber(23.0), TermList.NIL)), StdLib.power, "StdLib.power"), new TermList(new TermNumber(1.0), TermList.NIL)), StdLib.minus, "StdLib.minus"), unifier, 3);
		b = new Term[6][];
		b[0] = unifier;
		b[0] = Term.merge( b, 1 );

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		b[0] = binding;
		b[0] = Term.merge( b, 1 );
		p[1].bind(binding);
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
	}

	protected Term[] nextBindingHelper()
	{
		while (b[5] == null)
		{
			boolean b4changed = false;
			while (b[4] == null)
			{
				boolean b3changed = false;
				while (b[3] == null)
				{
					boolean b2changed = false;
					while (b[2] == null)
					{
						boolean b1changed = false;
						while (b[1] == null)
						{
							b[1] = p[1].nextBinding();
							if (b[1] == null)
								return null;
							b1changed = true;
						}
						if ( b1changed ) {
							p[2].reset();
							p[2].bind(Term.merge(b, 2));
						}
						b[2] = p[2].nextBinding();
						if (b[2] == null) b[1] = null;
						b2changed = true;
					}
					if ( b2changed ) {
						p[3].reset();
						p[3].bind(Term.merge(b, 3));
					}
					b[3] = p[3].nextBinding();
					if (b[3] == null) b[2] = null;
					b3changed = true;
				}
				if ( b3changed ) {
					p[4].reset();
					p[4].bind(Term.merge(b, 4));
				}
				b[4] = p[4].nextBinding();
				if (b[4] == null) b[3] = null;
				b4changed = true;
			}
			if ( b4changed ) {
				p[5].reset();
				p[5].bind(Term.merge(b, 5));
			}
			b[5] = p[5].nextBinding();
			if (b[5] == null) b[4] = null;
		}

		Term[] retVal = Term.merge(b, 6);
		b[5] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		p[3].reset();
		p[4].reset();
		p[5].reset();
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
	}
}

class Precondition11 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition11(Term[] unifier)
	{
		p = new Precondition[8];
		p[1] = new PreconditionAtomic(new Predicate(14, 10, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(5), TermList.NIL)))), unifier);
		p[2] = new PreconditionAtomic(new Predicate(11, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(7), TermList.NIL))), unifier);
		p[3] = new PreconditionAtomic(new Predicate(13, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(8), TermList.NIL))), unifier);
		p[4] = new PreconditionAtomic(new Predicate(18, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(6), TermList.NIL))), unifier);
		p[5] = new PreconditionAtomic(new Predicate(19, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(9), TermList.NIL))), unifier);
		p[6] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(7), new TermList(new TermCall(new List(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(6), TermList.NIL)), StdLib.mult, "StdLib.mult"), TermList.NIL)), StdLib.moreEq, "StdLib.moreEq"), unifier);
		p[7] = new PreconditionAssign(new TermCall(new List(new TermCall(new List(new TermCall(new List(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(9), TermList.NIL)), StdLib.div, "StdLib.div"), new TermList(new TermCall(new List(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(6), TermList.NIL)), StdLib.mult, "StdLib.mult"), TermList.NIL)), StdLib.plus, "StdLib.plus"), new TermList(TermVariable.getVariable(8), TermList.NIL)), StdLib.div, "StdLib.div"), unifier, 3);
		b = new Term[8][];
		b[0] = unifier;
		b[0] = Term.merge( b, 1 );

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		b[0] = binding;
		b[0] = Term.merge( b, 1 );
		p[1].bind(binding);
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
		b[6] = null;
		b[7] = null;
	}

	protected Term[] nextBindingHelper()
	{
		while (b[7] == null)
		{
			boolean b6changed = false;
			while (b[6] == null)
			{
				boolean b5changed = false;
				while (b[5] == null)
				{
					boolean b4changed = false;
					while (b[4] == null)
					{
						boolean b3changed = false;
						while (b[3] == null)
						{
							boolean b2changed = false;
							while (b[2] == null)
							{
								boolean b1changed = false;
								while (b[1] == null)
								{
									b[1] = p[1].nextBinding();
									if (b[1] == null)
										return null;
									b1changed = true;
								}
								if ( b1changed ) {
									p[2].reset();
									p[2].bind(Term.merge(b, 2));
								}
								b[2] = p[2].nextBinding();
								if (b[2] == null) b[1] = null;
								b2changed = true;
							}
							if ( b2changed ) {
								p[3].reset();
								p[3].bind(Term.merge(b, 3));
							}
							b[3] = p[3].nextBinding();
							if (b[3] == null) b[2] = null;
							b3changed = true;
						}
						if ( b3changed ) {
							p[4].reset();
							p[4].bind(Term.merge(b, 4));
						}
						b[4] = p[4].nextBinding();
						if (b[4] == null) b[3] = null;
						b4changed = true;
					}
					if ( b4changed ) {
						p[5].reset();
						p[5].bind(Term.merge(b, 5));
					}
					b[5] = p[5].nextBinding();
					if (b[5] == null) b[4] = null;
					b5changed = true;
				}
				if ( b5changed ) {
					p[6].reset();
					p[6].bind(Term.merge(b, 6));
				}
				b[6] = p[6].nextBinding();
				if (b[6] == null) b[5] = null;
				b6changed = true;
			}
			if ( b6changed ) {
				p[7].reset();
				p[7].bind(Term.merge(b, 7));
			}
			b[7] = p[7].nextBinding();
			if (b[7] == null) b[6] = null;
		}

		Term[] retVal = Term.merge(b, 8);
		b[7] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		p[3].reset();
		p[4].reset();
		p[5].reset();
		p[6].reset();
		p[7].reset();
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
		b[6] = null;
		b[7] = null;
	}
}

class Precondition12 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition12(Term[] unifier)
	{
		p = new Precondition[8];
		p[1] = new PreconditionAtomic(new Predicate(12, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier);
		p[2] = new PreconditionAtomic(new Predicate(14, 10, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(5), TermList.NIL)))), unifier);
		p[3] = new PreconditionAtomic(new Predicate(11, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(7), TermList.NIL))), unifier);
		p[4] = new PreconditionAtomic(new Predicate(18, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(6), TermList.NIL))), unifier);
		p[5] = new PreconditionAtomic(new Predicate(19, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(9), TermList.NIL))), unifier);
		p[6] = new PreconditionAtomic(new Predicate(13, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(8), TermList.NIL))), unifier);
		p[7] = new PreconditionAssign(new TermCall(new List(new TermCall(new List(new TermCall(new List(new TermCall(new List(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(9), TermList.NIL)), StdLib.div, "StdLib.div"), new TermList(new TermCall(new List(new TermCall(new List(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(7), TermList.NIL)), StdLib.minus, "StdLib.minus"), new TermList(TermVariable.getVariable(8), TermList.NIL)), StdLib.div, "StdLib.div"), TermList.NIL)), StdLib.plus, "StdLib.plus"), new TermList(new TermCall(new List(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(6), TermList.NIL)), StdLib.mult, "StdLib.mult"), TermList.NIL)), StdLib.plus, "StdLib.plus"), new TermList(TermVariable.getVariable(8), TermList.NIL)), StdLib.div, "StdLib.div"), unifier, 3);
		b = new Term[8][];
		b[0] = unifier;
		b[0] = Term.merge( b, 1 );

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		b[0] = binding;
		b[0] = Term.merge( b, 1 );
		p[1].bind(binding);
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
		b[6] = null;
		b[7] = null;
	}

	protected Term[] nextBindingHelper()
	{
		while (b[7] == null)
		{
			boolean b6changed = false;
			while (b[6] == null)
			{
				boolean b5changed = false;
				while (b[5] == null)
				{
					boolean b4changed = false;
					while (b[4] == null)
					{
						boolean b3changed = false;
						while (b[3] == null)
						{
							boolean b2changed = false;
							while (b[2] == null)
							{
								boolean b1changed = false;
								while (b[1] == null)
								{
									b[1] = p[1].nextBinding();
									if (b[1] == null)
										return null;
									b1changed = true;
								}
								if ( b1changed ) {
									p[2].reset();
									p[2].bind(Term.merge(b, 2));
								}
								b[2] = p[2].nextBinding();
								if (b[2] == null) b[1] = null;
								b2changed = true;
							}
							if ( b2changed ) {
								p[3].reset();
								p[3].bind(Term.merge(b, 3));
							}
							b[3] = p[3].nextBinding();
							if (b[3] == null) b[2] = null;
							b3changed = true;
						}
						if ( b3changed ) {
							p[4].reset();
							p[4].bind(Term.merge(b, 4));
						}
						b[4] = p[4].nextBinding();
						if (b[4] == null) b[3] = null;
						b4changed = true;
					}
					if ( b4changed ) {
						p[5].reset();
						p[5].bind(Term.merge(b, 5));
					}
					b[5] = p[5].nextBinding();
					if (b[5] == null) b[4] = null;
					b5changed = true;
				}
				if ( b5changed ) {
					p[6].reset();
					p[6].bind(Term.merge(b, 6));
				}
				b[6] = p[6].nextBinding();
				if (b[6] == null) b[5] = null;
				b6changed = true;
			}
			if ( b6changed ) {
				p[7].reset();
				p[7].bind(Term.merge(b, 7));
			}
			b[7] = p[7].nextBinding();
			if (b[7] == null) b[6] = null;
		}

		Term[] retVal = Term.merge(b, 8);
		b[7] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		p[3].reset();
		p[4].reset();
		p[5].reset();
		p[6].reset();
		p[7].reset();
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
		b[6] = null;
		b[7] = null;
	}
}

class Axiom3 extends Axiom
{
	public Axiom3()
	{
		super(new Predicate(22, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), new TermList(TermConstant.getConstant(23), TermList.NIL)))))), 3);
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new Precondition10(unifier)).setComparator(null);
			break;
			case 1:
				p = (new Precondition11(unifier)).setComparator(null);
			break;
			case 2:
				p = (new Precondition12(unifier)).setComparator(null);
			break;
			default:
				return null;
		}

		p.reset();

		return p;
	}

	public String getLabel(int which)
	{
		switch (which)
		{
			case 0: return "CASE1";
			case 1: return "CASE2";
			case 2: return "CASE3";
			default: return null;
		}
	}
}

class Precondition13 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition13(Term[] unifier)
	{
		p = new Precondition[6];
		p[1] = new PreconditionAtomic(new Predicate(12, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier);
		p[2] = new PreconditionAtomic(new Predicate(14, 10, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(5), TermList.NIL)))), unifier);
		p[3] = new PreconditionAtomic(new Predicate(16, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(6), TermList.NIL))), unifier);
		p[4] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(4), new TermList(new TermCall(new List(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(6), TermList.NIL)), StdLib.mult, "StdLib.mult"), TermList.NIL)), StdLib.less, "StdLib.less"), unifier);
		p[5] = new PreconditionAssign(new TermCall(new List(new TermCall(new List(new TermNumber(2.0), new TermList(new TermNumber(23.0), TermList.NIL)), StdLib.power, "StdLib.power"), new TermList(new TermNumber(1.0), TermList.NIL)), StdLib.minus, "StdLib.minus"), unifier, 3);
		b = new Term[6][];
		b[0] = unifier;
		b[0] = Term.merge( b, 1 );

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		b[0] = binding;
		b[0] = Term.merge( b, 1 );
		p[1].bind(binding);
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
	}

	protected Term[] nextBindingHelper()
	{
		while (b[5] == null)
		{
			boolean b4changed = false;
			while (b[4] == null)
			{
				boolean b3changed = false;
				while (b[3] == null)
				{
					boolean b2changed = false;
					while (b[2] == null)
					{
						boolean b1changed = false;
						while (b[1] == null)
						{
							b[1] = p[1].nextBinding();
							if (b[1] == null)
								return null;
							b1changed = true;
						}
						if ( b1changed ) {
							p[2].reset();
							p[2].bind(Term.merge(b, 2));
						}
						b[2] = p[2].nextBinding();
						if (b[2] == null) b[1] = null;
						b2changed = true;
					}
					if ( b2changed ) {
						p[3].reset();
						p[3].bind(Term.merge(b, 3));
					}
					b[3] = p[3].nextBinding();
					if (b[3] == null) b[2] = null;
					b3changed = true;
				}
				if ( b3changed ) {
					p[4].reset();
					p[4].bind(Term.merge(b, 4));
				}
				b[4] = p[4].nextBinding();
				if (b[4] == null) b[3] = null;
				b4changed = true;
			}
			if ( b4changed ) {
				p[5].reset();
				p[5].bind(Term.merge(b, 5));
			}
			b[5] = p[5].nextBinding();
			if (b[5] == null) b[4] = null;
		}

		Term[] retVal = Term.merge(b, 6);
		b[5] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		p[3].reset();
		p[4].reset();
		p[5].reset();
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
	}
}

class Precondition14 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition14(Term[] unifier)
	{
		p = new Precondition[8];
		p[1] = new PreconditionAtomic(new Predicate(14, 10, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(5), TermList.NIL)))), unifier);
		p[2] = new PreconditionAtomic(new Predicate(11, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(7), TermList.NIL))), unifier);
		p[3] = new PreconditionAtomic(new Predicate(13, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(8), TermList.NIL))), unifier);
		p[4] = new PreconditionAtomic(new Predicate(16, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(6), TermList.NIL))), unifier);
		p[5] = new PreconditionAtomic(new Predicate(15, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(9), TermList.NIL))), unifier);
		p[6] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(7), new TermList(new TermCall(new List(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(6), TermList.NIL)), StdLib.mult, "StdLib.mult"), TermList.NIL)), StdLib.moreEq, "StdLib.moreEq"), unifier);
		p[7] = new PreconditionAssign(new TermCall(new List(new TermCall(new List(new TermCall(new List(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(9), TermList.NIL)), StdLib.div, "StdLib.div"), new TermList(new TermCall(new List(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(6), TermList.NIL)), StdLib.mult, "StdLib.mult"), TermList.NIL)), StdLib.plus, "StdLib.plus"), new TermList(TermVariable.getVariable(8), TermList.NIL)), StdLib.div, "StdLib.div"), unifier, 3);
		b = new Term[8][];
		b[0] = unifier;
		b[0] = Term.merge( b, 1 );

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		b[0] = binding;
		b[0] = Term.merge( b, 1 );
		p[1].bind(binding);
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
		b[6] = null;
		b[7] = null;
	}

	protected Term[] nextBindingHelper()
	{
		while (b[7] == null)
		{
			boolean b6changed = false;
			while (b[6] == null)
			{
				boolean b5changed = false;
				while (b[5] == null)
				{
					boolean b4changed = false;
					while (b[4] == null)
					{
						boolean b3changed = false;
						while (b[3] == null)
						{
							boolean b2changed = false;
							while (b[2] == null)
							{
								boolean b1changed = false;
								while (b[1] == null)
								{
									b[1] = p[1].nextBinding();
									if (b[1] == null)
										return null;
									b1changed = true;
								}
								if ( b1changed ) {
									p[2].reset();
									p[2].bind(Term.merge(b, 2));
								}
								b[2] = p[2].nextBinding();
								if (b[2] == null) b[1] = null;
								b2changed = true;
							}
							if ( b2changed ) {
								p[3].reset();
								p[3].bind(Term.merge(b, 3));
							}
							b[3] = p[3].nextBinding();
							if (b[3] == null) b[2] = null;
							b3changed = true;
						}
						if ( b3changed ) {
							p[4].reset();
							p[4].bind(Term.merge(b, 4));
						}
						b[4] = p[4].nextBinding();
						if (b[4] == null) b[3] = null;
						b4changed = true;
					}
					if ( b4changed ) {
						p[5].reset();
						p[5].bind(Term.merge(b, 5));
					}
					b[5] = p[5].nextBinding();
					if (b[5] == null) b[4] = null;
					b5changed = true;
				}
				if ( b5changed ) {
					p[6].reset();
					p[6].bind(Term.merge(b, 6));
				}
				b[6] = p[6].nextBinding();
				if (b[6] == null) b[5] = null;
				b6changed = true;
			}
			if ( b6changed ) {
				p[7].reset();
				p[7].bind(Term.merge(b, 7));
			}
			b[7] = p[7].nextBinding();
			if (b[7] == null) b[6] = null;
		}

		Term[] retVal = Term.merge(b, 8);
		b[7] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		p[3].reset();
		p[4].reset();
		p[5].reset();
		p[6].reset();
		p[7].reset();
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
		b[6] = null;
		b[7] = null;
	}
}

class Precondition15 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition15(Term[] unifier)
	{
		p = new Precondition[8];
		p[1] = new PreconditionAtomic(new Predicate(12, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier);
		p[2] = new PreconditionAtomic(new Predicate(14, 10, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(5), TermList.NIL)))), unifier);
		p[3] = new PreconditionAtomic(new Predicate(11, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(7), TermList.NIL))), unifier);
		p[4] = new PreconditionAtomic(new Predicate(16, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(6), TermList.NIL))), unifier);
		p[5] = new PreconditionAtomic(new Predicate(15, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(9), TermList.NIL))), unifier);
		p[6] = new PreconditionAtomic(new Predicate(13, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(8), TermList.NIL))), unifier);
		p[7] = new PreconditionAssign(new TermCall(new List(new TermCall(new List(new TermCall(new List(new TermCall(new List(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(9), TermList.NIL)), StdLib.div, "StdLib.div"), new TermList(new TermCall(new List(new TermCall(new List(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(7), TermList.NIL)), StdLib.minus, "StdLib.minus"), new TermList(TermVariable.getVariable(8), TermList.NIL)), StdLib.div, "StdLib.div"), TermList.NIL)), StdLib.plus, "StdLib.plus"), new TermList(new TermCall(new List(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(6), TermList.NIL)), StdLib.mult, "StdLib.mult"), TermList.NIL)), StdLib.plus, "StdLib.plus"), new TermList(TermVariable.getVariable(8), TermList.NIL)), StdLib.div, "StdLib.div"), unifier, 3);
		b = new Term[8][];
		b[0] = unifier;
		b[0] = Term.merge( b, 1 );

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		b[0] = binding;
		b[0] = Term.merge( b, 1 );
		p[1].bind(binding);
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
		b[6] = null;
		b[7] = null;
	}

	protected Term[] nextBindingHelper()
	{
		while (b[7] == null)
		{
			boolean b6changed = false;
			while (b[6] == null)
			{
				boolean b5changed = false;
				while (b[5] == null)
				{
					boolean b4changed = false;
					while (b[4] == null)
					{
						boolean b3changed = false;
						while (b[3] == null)
						{
							boolean b2changed = false;
							while (b[2] == null)
							{
								boolean b1changed = false;
								while (b[1] == null)
								{
									b[1] = p[1].nextBinding();
									if (b[1] == null)
										return null;
									b1changed = true;
								}
								if ( b1changed ) {
									p[2].reset();
									p[2].bind(Term.merge(b, 2));
								}
								b[2] = p[2].nextBinding();
								if (b[2] == null) b[1] = null;
								b2changed = true;
							}
							if ( b2changed ) {
								p[3].reset();
								p[3].bind(Term.merge(b, 3));
							}
							b[3] = p[3].nextBinding();
							if (b[3] == null) b[2] = null;
							b3changed = true;
						}
						if ( b3changed ) {
							p[4].reset();
							p[4].bind(Term.merge(b, 4));
						}
						b[4] = p[4].nextBinding();
						if (b[4] == null) b[3] = null;
						b4changed = true;
					}
					if ( b4changed ) {
						p[5].reset();
						p[5].bind(Term.merge(b, 5));
					}
					b[5] = p[5].nextBinding();
					if (b[5] == null) b[4] = null;
					b5changed = true;
				}
				if ( b5changed ) {
					p[6].reset();
					p[6].bind(Term.merge(b, 6));
				}
				b[6] = p[6].nextBinding();
				if (b[6] == null) b[5] = null;
				b6changed = true;
			}
			if ( b6changed ) {
				p[7].reset();
				p[7].bind(Term.merge(b, 7));
			}
			b[7] = p[7].nextBinding();
			if (b[7] == null) b[6] = null;
		}

		Term[] retVal = Term.merge(b, 8);
		b[7] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		p[3].reset();
		p[4].reset();
		p[5].reset();
		p[6].reset();
		p[7].reset();
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
		b[6] = null;
		b[7] = null;
	}
}

class Axiom4 extends Axiom
{
	public Axiom4()
	{
		super(new Predicate(22, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), new TermList(TermConstant.getConstant(24), TermList.NIL)))))), 3);
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new Precondition13(unifier)).setComparator(null);
			break;
			case 1:
				p = (new Precondition14(unifier)).setComparator(null);
			break;
			case 2:
				p = (new Precondition15(unifier)).setComparator(null);
			break;
			default:
				return null;
		}

		p.reset();

		return p;
	}

	public String getLabel(int which)
	{
		switch (which)
		{
			case 0: return "CASE1";
			case 1: return "CASE2";
			case 2: return "CASE3";
			default: return null;
		}
	}
}

public class zenotravel extends Domain
{
	public zenotravel()
	{
		TermVariable.initialize(11);

		constants = new String[25];
		constants[0] = "same";
		constants[1] = "different";
		constants[2] = "possible-person-in";
		constants[3] = "person";
		constants[4] = "at";
		constants[5] = "goal";
		constants[6] = "aircraft";
		constants[7] = "city";
		constants[8] = "boarding-time";
		constants[9] = "in";
		constants[10] = "debarking-time";
		constants[11] = "fuel";
		constants[12] = "capacity";
		constants[13] = "refuel-rate";
		constants[14] = "distance";
		constants[15] = "fast-speed";
		constants[16] = "fast-burn";
		constants[17] = "total-fuel-used";
		constants[18] = "slow-burn";
		constants[19] = "slow-speed";
		constants[20] = "in-use";
		constants[21] = "dest";
		constants[22] = "travel-cost-info";
		constants[23] = "slow";
		constants[24] = "fast";

		compoundTasks = new String[5];
		compoundTasks[0] = "transport-person";
		compoundTasks[1] = "upper-move-aircraft-no-style";
		compoundTasks[2] = "upper-move-aircraft";
		compoundTasks[3] = "move-aircraft";
		compoundTasks[4] = "transport-aircraft";

		primitiveTasks = new String[7];
		primitiveTasks[0] = "!board";
		primitiveTasks[1] = "!debark";
		primitiveTasks[2] = "!refuel";
		primitiveTasks[3] = "!zoom";
		primitiveTasks[4] = "!fly";
		primitiveTasks[5] = "!!assert";
		primitiveTasks[6] = "!!ra";

		methods = new Method[5][];

		methods[0] = new Method[3];
		methods[0][0] = new Method0();
		methods[0][1] = new Method1();
		methods[0][2] = new Method2();

		methods[1] = new Method[1];
		methods[1][0] = new Method4();

		methods[2] = new Method[1];
		methods[2][0] = new Method3();

		methods[3] = new Method[2];
		methods[3][0] = new Method5();
		methods[3][1] = new Method6();

		methods[4] = new Method[1];
		methods[4][0] = new Method7();


		ops = new Operator[7][];

		ops[0] = new Operator[1];
		ops[0][0] = new Operator0();

		ops[1] = new Operator[1];
		ops[1][0] = new Operator1();

		ops[2] = new Operator[1];
		ops[2][0] = new Operator2();

		ops[3] = new Operator[1];
		ops[3][0] = new Operator3();

		ops[4] = new Operator[1];
		ops[4][0] = new Operator4();

		ops[5] = new Operator[1];
		ops[5][0] = new Operator5();

		ops[6] = new Operator[1];
		ops[6][0] = new Operator6();

		axioms = new Axiom[25][];

		axioms[0] = new Axiom[1];
		axioms[0][0] = new Axiom0();

		axioms[1] = new Axiom[1];
		axioms[1][0] = new Axiom1();

		axioms[2] = new Axiom[1];
		axioms[2][0] = new Axiom2();

		axioms[3] = new Axiom[0];

		axioms[4] = new Axiom[0];

		axioms[5] = new Axiom[0];

		axioms[6] = new Axiom[0];

		axioms[7] = new Axiom[0];

		axioms[8] = new Axiom[0];

		axioms[9] = new Axiom[0];

		axioms[10] = new Axiom[0];

		axioms[11] = new Axiom[0];

		axioms[12] = new Axiom[0];

		axioms[13] = new Axiom[0];

		axioms[14] = new Axiom[0];

		axioms[15] = new Axiom[0];

		axioms[16] = new Axiom[0];

		axioms[17] = new Axiom[0];

		axioms[18] = new Axiom[0];

		axioms[19] = new Axiom[0];

		axioms[20] = new Axiom[0];

		axioms[21] = new Axiom[0];

		axioms[22] = new Axiom[2];
		axioms[22][0] = new Axiom3();
		axioms[22][1] = new Axiom4();

		axioms[23] = new Axiom[0];

		axioms[24] = new Axiom[0];

	}
}