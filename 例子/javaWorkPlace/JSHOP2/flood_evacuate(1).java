import JSHOP2.*;

class Precondition0 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition0(Term[] unifier)
	{
		p = new Precondition[14];
		p[1] = new PreconditionAtomic(new Predicate(2, 15, new TermList(TermVariable.getVariable(4), TermList.NIL)), unifier);
		p[2] = new PreconditionAtomic(new Predicate(3, 15, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(5), TermList.NIL))), unifier);
		p[3] = new PreconditionAtomic(new Predicate(4, 15, new TermList(TermVariable.getVariable(6), TermList.NIL)), unifier);
		p[4] = new PreconditionAtomic(new Predicate(6, 15, new TermList(TermConstant.getConstant(5), new TermList(TermVariable.getVariable(7), TermList.NIL))), unifier);
		p[5] = new PreconditionAtomic(new Predicate(5, 15, new TermList(TermVariable.getVariable(8), new TermList(TermVariable.getVariable(9), TermList.NIL))), unifier);
		p[6] = new PreconditionAtomic(new Predicate(7, 15, new TermList(TermVariable.getVariable(8), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier);
		p[7] = new PreconditionAtomic(new Predicate(8, 15, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier);
		p[8] = new PreconditionAtomic(new Predicate(9, 15, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(10), TermList.NIL)))), unifier);
		p[9] = new PreconditionAtomic(new Predicate(10, 15, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(11), TermList.NIL))), unifier);
		p[10] = new PreconditionAtomic(new Predicate(11, 15, new TermList(TermConstant.getConstant(5), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(12), TermList.NIL)))), unifier);
		p[11] = new PreconditionAssign(new TermCall(new List(TermVariable.getVariable(10), new TermList(TermVariable.getVariable(11), TermList.NIL)), StdLib.div, "StdLib.div"), unifier, 13);
		p[12] = new PreconditionAssign(new TermCall(new List(TermVariable.getVariable(12), new TermList(TermVariable.getVariable(10), TermList.NIL)), StdLib.mult, "StdLib.mult"), unifier, 14);
		p[13] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(9), new TermList(TermVariable.getVariable(14), TermList.NIL)), StdLib.moreEq, "StdLib.moreEq"), unifier);
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

class Operator0 extends Operator
{
	public Operator0()
	{
		super(new Predicate(0, 15, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL))))), -1, -1, new TermNumber(1.0));


		DelAddElement[] delIn = new DelAddElement[6];
		delIn[0] = new DelAddAtomic(new Predicate(2, 15, new TermList(TermVariable.getVariable(4), TermList.NIL)));
		delIn[1] = new DelAddAtomic(new Predicate(3, 15, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(5), TermList.NIL))));
		delIn[2] = new DelAddAtomic(new Predicate(4, 15, new TermList(TermVariable.getVariable(6), TermList.NIL)));
		delIn[3] = new DelAddAtomic(new Predicate(6, 15, new TermList(TermConstant.getConstant(5), new TermList(TermVariable.getVariable(7), TermList.NIL))));
		delIn[4] = new DelAddAtomic(new Predicate(5, 15, new TermList(TermVariable.getVariable(8), new TermList(TermVariable.getVariable(9), TermList.NIL))));
		delIn[5] = new DelAddAtomic(new Predicate(8, 15, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL))));

		setDel(delIn);

		DelAddElement[] addIn = new DelAddElement[6];
		addIn[0] = new DelAddAtomic(new Predicate(2, 15, new TermList(TermVariable.getVariable(0), TermList.NIL)));
		addIn[1] = new DelAddAtomic(new Predicate(3, 15, new TermList(TermVariable.getVariable(1), new TermList(new TermCall(new List(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(13), TermList.NIL)), StdLib.plus, "StdLib.plus"), TermList.NIL))));
		addIn[2] = new DelAddAtomic(new Predicate(4, 15, new TermList(TermVariable.getVariable(13), TermList.NIL)));
		addIn[3] = new DelAddAtomic(new Predicate(6, 15, new TermList(TermConstant.getConstant(5), new TermList(new TermCall(new List(TermVariable.getVariable(7), new TermList(TermVariable.getVariable(14), TermList.NIL)), StdLib.plus, "StdLib.plus"), TermList.NIL))));
		addIn[4] = new DelAddAtomic(new Predicate(5, 15, new TermList(TermVariable.getVariable(8), new TermList(new TermCall(new List(TermVariable.getVariable(9), new TermList(TermVariable.getVariable(14), TermList.NIL)), StdLib.minus, "StdLib.minus"), TermList.NIL))));
		addIn[5] = new DelAddAtomic(new Predicate(8, 15, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(3), TermList.NIL))));

		setAdd(addIn);
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		p = (new Precondition0(unifier)).setComparator(null);
		p.reset();

		return p;
	}
}

class Precondition1 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition1(Term[] unifier)
	{
		p = new Precondition[10];
		p[1] = new PreconditionAtomic(new Predicate(2, 11, new TermList(TermVariable.getVariable(3), TermList.NIL)), unifier);
		p[2] = new PreconditionAtomic(new Predicate(3, 11, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier);
		p[3] = new PreconditionAtomic(new Predicate(4, 11, new TermList(TermVariable.getVariable(5), TermList.NIL)), unifier);
		p[4] = new PreconditionAtomic(new Predicate(12, 11, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(6), TermList.NIL))), unifier);
		p[5] = new PreconditionAtomic(new Predicate(13, 11, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(7), TermList.NIL))), unifier);
		p[6] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(7), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
		p[7] = new PreconditionAtomic(new Predicate(14, 11, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(8), TermList.NIL))), unifier);
		p[8] = new PreconditionAssign(new TermNumber(0.1), unifier, 9);
		p[9] = new PreconditionAssign(new TermCall(new List(TermVariable.getVariable(6), new TermList(TermVariable.getVariable(7), TermList.NIL)), UserDefineCall.min, "UserDefineCall.min"), unifier, 10);
		b = new Term[10][];
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
	}

	protected Term[] nextBindingHelper()
	{
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
		}

		Term[] retVal = Term.merge(b, 10);
		b[9] = null;
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
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
		b[6] = null;
		b[7] = null;
		b[8] = null;
		b[9] = null;
	}
}

class Operator1 extends Operator
{
	public Operator1()
	{
		super(new Predicate(1, 11, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))), -1, -1, new TermNumber(1.0));


		DelAddElement[] delIn = new DelAddElement[6];
		delIn[0] = new DelAddAtomic(new Predicate(2, 11, new TermList(TermVariable.getVariable(3), TermList.NIL)));
		delIn[1] = new DelAddAtomic(new Predicate(3, 11, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(4), TermList.NIL))));
		delIn[2] = new DelAddAtomic(new Predicate(4, 11, new TermList(TermVariable.getVariable(5), TermList.NIL)));
		delIn[3] = new DelAddAtomic(new Predicate(12, 11, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(6), TermList.NIL))));
		delIn[4] = new DelAddAtomic(new Predicate(13, 11, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(7), TermList.NIL))));
		delIn[5] = new DelAddAtomic(new Predicate(14, 11, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(8), TermList.NIL))));

		setDel(delIn);

		DelAddElement[] addIn = new DelAddElement[6];
		addIn[0] = new DelAddAtomic(new Predicate(2, 11, new TermList(TermVariable.getVariable(0), TermList.NIL)));
		addIn[1] = new DelAddAtomic(new Predicate(3, 11, new TermList(TermVariable.getVariable(1), new TermList(new TermCall(new List(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(9), TermList.NIL)), StdLib.plus, "StdLib.plus"), TermList.NIL))));
		addIn[2] = new DelAddAtomic(new Predicate(4, 11, new TermList(TermVariable.getVariable(9), TermList.NIL)));
		addIn[3] = new DelAddAtomic(new Predicate(12, 11, new TermList(TermVariable.getVariable(2), new TermList(new TermCall(new List(TermVariable.getVariable(6), new TermList(TermVariable.getVariable(10), TermList.NIL)), StdLib.minus, "StdLib.minus"), TermList.NIL))));
		addIn[4] = new DelAddAtomic(new Predicate(13, 11, new TermList(TermVariable.getVariable(1), new TermList(new TermCall(new List(TermVariable.getVariable(7), new TermList(TermVariable.getVariable(10), TermList.NIL)), StdLib.minus, "StdLib.minus"), TermList.NIL))));
		addIn[5] = new DelAddAtomic(new Predicate(14, 11, new TermList(TermVariable.getVariable(1), new TermList(new TermCall(new List(TermVariable.getVariable(8), new TermList(TermVariable.getVariable(10), TermList.NIL)), StdLib.plus, "StdLib.plus"), TermList.NIL))));

		setAdd(addIn);
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
		p = new Precondition[10];
		p[1] = new PreconditionAtomic(new Predicate(2, 11, new TermList(TermVariable.getVariable(3), TermList.NIL)), unifier);
		p[2] = new PreconditionAtomic(new Predicate(3, 11, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier);
		p[3] = new PreconditionAtomic(new Predicate(4, 11, new TermList(TermVariable.getVariable(5), TermList.NIL)), unifier);
		p[4] = new PreconditionAtomic(new Predicate(15, 11, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(6), TermList.NIL))), unifier);
		p[5] = new PreconditionAtomic(new Predicate(13, 11, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(7), TermList.NIL))), unifier);
		p[6] = new PreconditionAtomic(new Predicate(14, 11, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(8), TermList.NIL))), unifier);
		p[7] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(8), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
		p[8] = new PreconditionAssign(new TermNumber(0.1), unifier, 9);
		p[9] = new PreconditionAssign(new TermCall(new List(TermVariable.getVariable(8), new TermList(TermVariable.getVariable(6), TermList.NIL)), UserDefineCall.min, "UserDefineCall.min"), unifier, 10);
		b = new Term[10][];
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
	}

	protected Term[] nextBindingHelper()
	{
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
		}

		Term[] retVal = Term.merge(b, 10);
		b[9] = null;
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
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
		b[6] = null;
		b[7] = null;
		b[8] = null;
		b[9] = null;
	}
}

class Operator2 extends Operator
{
	public Operator2()
	{
		super(new Predicate(2, 11, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))), -1, -1, new TermNumber(1.0));


		DelAddElement[] delIn = new DelAddElement[6];
		delIn[0] = new DelAddAtomic(new Predicate(2, 11, new TermList(TermVariable.getVariable(3), TermList.NIL)));
		delIn[1] = new DelAddAtomic(new Predicate(3, 11, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(4), TermList.NIL))));
		delIn[2] = new DelAddAtomic(new Predicate(4, 11, new TermList(TermVariable.getVariable(5), TermList.NIL)));
		delIn[3] = new DelAddAtomic(new Predicate(15, 11, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(6), TermList.NIL))));
		delIn[4] = new DelAddAtomic(new Predicate(14, 11, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(8), TermList.NIL))));
		delIn[5] = new DelAddAtomic(new Predicate(13, 11, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(7), TermList.NIL))));

		setDel(delIn);

		DelAddElement[] addIn = new DelAddElement[6];
		addIn[0] = new DelAddAtomic(new Predicate(2, 11, new TermList(TermVariable.getVariable(0), TermList.NIL)));
		addIn[1] = new DelAddAtomic(new Predicate(3, 11, new TermList(TermVariable.getVariable(1), new TermList(new TermCall(new List(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(9), TermList.NIL)), StdLib.plus, "StdLib.plus"), TermList.NIL))));
		addIn[2] = new DelAddAtomic(new Predicate(4, 11, new TermList(TermVariable.getVariable(9), TermList.NIL)));
		addIn[3] = new DelAddAtomic(new Predicate(15, 11, new TermList(TermVariable.getVariable(2), new TermList(new TermCall(new List(TermVariable.getVariable(6), new TermList(TermVariable.getVariable(10), TermList.NIL)), StdLib.minus, "StdLib.minus"), TermList.NIL))));
		addIn[4] = new DelAddAtomic(new Predicate(13, 11, new TermList(TermVariable.getVariable(1), new TermList(new TermCall(new List(TermVariable.getVariable(7), new TermList(TermVariable.getVariable(10), TermList.NIL)), StdLib.plus, "StdLib.plus"), TermList.NIL))));
		addIn[5] = new DelAddAtomic(new Predicate(14, 11, new TermList(TermVariable.getVariable(1), new TermList(new TermCall(new List(TermVariable.getVariable(8), new TermList(TermVariable.getVariable(10), TermList.NIL)), StdLib.minus, "StdLib.minus"), TermList.NIL))));

		setAdd(addIn);
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
		p = new Precondition[10];
		p[1] = new PreconditionAtomic(new Predicate(2, 10, new TermList(TermVariable.getVariable(2), TermList.NIL)), unifier);
		p[2] = new PreconditionAtomic(new Predicate(3, 10, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(3), TermList.NIL))), unifier);
		p[3] = new PreconditionAtomic(new Predicate(4, 10, new TermList(TermVariable.getVariable(4), TermList.NIL)), unifier);
		p[4] = new PreconditionAtomic(new Predicate(13, 10, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(5), TermList.NIL))), unifier);
		p[5] = new PreconditionAtomic(new Predicate(14, 10, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(6), TermList.NIL))), unifier);
		p[6] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(6), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
		p[7] = new PreconditionAssign(new TermNumber(0.1), unifier, 7);
		p[8] = new PreconditionAssign(TermVariable.getVariable(6), unifier, 8);
		p[9] = new PreconditionAtomic(new Predicate(17, 10, new TermList(TermConstant.getConstant(16), new TermList(TermVariable.getVariable(9), TermList.NIL))), unifier);
		b = new Term[10][];
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
	}

	protected Term[] nextBindingHelper()
	{
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
		}

		Term[] retVal = Term.merge(b, 10);
		b[9] = null;
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
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
		b[6] = null;
		b[7] = null;
		b[8] = null;
		b[9] = null;
	}
}

class Operator3 extends Operator
{
	public Operator3()
	{
		super(new Predicate(3, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))), -1, -1, new TermNumber(1.0));


		DelAddElement[] delIn = new DelAddElement[6];
		delIn[0] = new DelAddAtomic(new Predicate(2, 10, new TermList(TermVariable.getVariable(2), TermList.NIL)));
		delIn[1] = new DelAddAtomic(new Predicate(3, 10, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(3), TermList.NIL))));
		delIn[2] = new DelAddAtomic(new Predicate(4, 10, new TermList(TermVariable.getVariable(4), TermList.NIL)));
		delIn[3] = new DelAddAtomic(new Predicate(14, 10, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(6), TermList.NIL))));
		delIn[4] = new DelAddAtomic(new Predicate(13, 10, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(5), TermList.NIL))));
		delIn[5] = new DelAddAtomic(new Predicate(17, 10, new TermList(TermConstant.getConstant(16), new TermList(TermVariable.getVariable(9), TermList.NIL))));

		setDel(delIn);

		DelAddElement[] addIn = new DelAddElement[6];
		addIn[0] = new DelAddAtomic(new Predicate(2, 10, new TermList(TermVariable.getVariable(0), TermList.NIL)));
		addIn[1] = new DelAddAtomic(new Predicate(3, 10, new TermList(TermVariable.getVariable(1), new TermList(new TermCall(new List(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(7), TermList.NIL)), StdLib.plus, "StdLib.plus"), TermList.NIL))));
		addIn[2] = new DelAddAtomic(new Predicate(4, 10, new TermList(TermVariable.getVariable(7), TermList.NIL)));
		addIn[3] = new DelAddAtomic(new Predicate(13, 10, new TermList(TermVariable.getVariable(1), new TermList(new TermCall(new List(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(8), TermList.NIL)), StdLib.plus, "StdLib.plus"), TermList.NIL))));
		addIn[4] = new DelAddAtomic(new Predicate(14, 10, new TermList(TermVariable.getVariable(1), new TermList(new TermCall(new List(TermVariable.getVariable(6), new TermList(TermVariable.getVariable(8), TermList.NIL)), StdLib.minus, "StdLib.minus"), TermList.NIL))));
		addIn[5] = new DelAddAtomic(new Predicate(17, 10, new TermList(TermConstant.getConstant(16), new TermList(new TermCall(new List(TermVariable.getVariable(9), new TermList(TermVariable.getVariable(8), TermList.NIL)), StdLib.plus, "StdLib.plus"), TermList.NIL))));

		setAdd(addIn);
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
		p[1] = new PreconditionAtomic(new Predicate(2, 16, new TermList(TermVariable.getVariable(4), TermList.NIL)), unifier);
		p[2] = new PreconditionAtomic(new Predicate(3, 16, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(5), TermList.NIL))), unifier);
		p[3] = new PreconditionAtomic(new Predicate(4, 16, new TermList(TermVariable.getVariable(6), TermList.NIL)), unifier);
		p[4] = new PreconditionAtomic(new Predicate(6, 16, new TermList(TermConstant.getConstant(5), new TermList(TermVariable.getVariable(7), TermList.NIL))), unifier);
		p[5] = new PreconditionAtomic(new Predicate(5, 16, new TermList(TermVariable.getVariable(8), new TermList(TermVariable.getVariable(9), TermList.NIL))), unifier);
		p[6] = new PreconditionAtomic(new Predicate(7, 16, new TermList(TermVariable.getVariable(8), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier);
		p[7] = new PreconditionAtomic(new Predicate(18, 16, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier);
		p[8] = new PreconditionAtomic(new Predicate(9, 16, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(10), TermList.NIL)))), unifier);
		p[9] = new PreconditionAtomic(new Predicate(10, 16, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(11), TermList.NIL))), unifier);
		p[10] = new PreconditionAtomic(new Predicate(19, 16, new TermList(TermConstant.getConstant(5), new TermList(TermVariable.getVariable(12), new TermList(TermVariable.getVariable(13), TermList.NIL)))), unifier);
		p[11] = new PreconditionAssign(new TermCall(new List(TermVariable.getVariable(10), new TermList(TermVariable.getVariable(11), TermList.NIL)), StdLib.div, "StdLib.div"), unifier, 14);
		p[12] = new PreconditionAssign(new TermCall(new List(TermVariable.getVariable(13), new TermList(TermVariable.getVariable(10), TermList.NIL)), StdLib.mult, "StdLib.mult"), unifier, 15);
		p[13] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(9), new TermList(TermVariable.getVariable(15), TermList.NIL)), StdLib.moreEq, "StdLib.moreEq"), unifier);
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
		super(new Predicate(4, 16, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL))))), -1, -1, new TermNumber(1.0));


		DelAddElement[] delIn = new DelAddElement[6];
		delIn[0] = new DelAddAtomic(new Predicate(2, 16, new TermList(TermVariable.getVariable(4), TermList.NIL)));
		delIn[1] = new DelAddAtomic(new Predicate(3, 16, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(5), TermList.NIL))));
		delIn[2] = new DelAddAtomic(new Predicate(4, 16, new TermList(TermVariable.getVariable(6), TermList.NIL)));
		delIn[3] = new DelAddAtomic(new Predicate(6, 16, new TermList(TermConstant.getConstant(5), new TermList(TermVariable.getVariable(7), TermList.NIL))));
		delIn[4] = new DelAddAtomic(new Predicate(5, 16, new TermList(TermVariable.getVariable(8), new TermList(TermVariable.getVariable(9), TermList.NIL))));
		delIn[5] = new DelAddAtomic(new Predicate(18, 16, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL))));

		setDel(delIn);

		DelAddElement[] addIn = new DelAddElement[6];
		addIn[0] = new DelAddAtomic(new Predicate(2, 16, new TermList(TermVariable.getVariable(0), TermList.NIL)));
		addIn[1] = new DelAddAtomic(new Predicate(3, 16, new TermList(TermVariable.getVariable(1), new TermList(new TermCall(new List(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(14), TermList.NIL)), StdLib.plus, "StdLib.plus"), TermList.NIL))));
		addIn[2] = new DelAddAtomic(new Predicate(4, 16, new TermList(TermVariable.getVariable(14), TermList.NIL)));
		addIn[3] = new DelAddAtomic(new Predicate(6, 16, new TermList(TermConstant.getConstant(5), new TermList(new TermCall(new List(TermVariable.getVariable(7), new TermList(TermVariable.getVariable(15), TermList.NIL)), StdLib.plus, "StdLib.plus"), TermList.NIL))));
		addIn[4] = new DelAddAtomic(new Predicate(5, 16, new TermList(TermVariable.getVariable(8), new TermList(new TermCall(new List(TermVariable.getVariable(9), new TermList(TermVariable.getVariable(15), TermList.NIL)), StdLib.minus, "StdLib.minus"), TermList.NIL))));
		addIn[5] = new DelAddAtomic(new Predicate(18, 16, new TermList(TermVariable.getVariable(12), new TermList(TermVariable.getVariable(3), TermList.NIL))));

		setAdd(addIn);
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
		p = new Precondition[10];
		p[1] = new PreconditionAtomic(new Predicate(2, 11, new TermList(TermVariable.getVariable(3), TermList.NIL)), unifier);
		p[2] = new PreconditionAtomic(new Predicate(3, 11, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier);
		p[3] = new PreconditionAtomic(new Predicate(4, 11, new TermList(TermVariable.getVariable(5), TermList.NIL)), unifier);
		p[4] = new PreconditionAtomic(new Predicate(20, 11, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(6), TermList.NIL))), unifier);
		p[5] = new PreconditionAtomic(new Predicate(13, 11, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(7), TermList.NIL))), unifier);
		p[6] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(7), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
		p[7] = new PreconditionAtomic(new Predicate(21, 11, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(8), TermList.NIL))), unifier);
		p[8] = new PreconditionAssign(new TermNumber(0.1), unifier, 9);
		p[9] = new PreconditionAssign(new TermCall(new List(TermVariable.getVariable(6), new TermList(TermVariable.getVariable(7), TermList.NIL)), UserDefineCall.min, "UserDefineCall.min"), unifier, 10);
		b = new Term[10][];
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
	}

	protected Term[] nextBindingHelper()
	{
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
		}

		Term[] retVal = Term.merge(b, 10);
		b[9] = null;
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
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
		b[6] = null;
		b[7] = null;
		b[8] = null;
		b[9] = null;
	}
}

class Operator5 extends Operator
{
	public Operator5()
	{
		super(new Predicate(5, 11, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))), -1, -1, new TermNumber(1.0));


		DelAddElement[] delIn = new DelAddElement[6];
		delIn[0] = new DelAddAtomic(new Predicate(2, 11, new TermList(TermVariable.getVariable(3), TermList.NIL)));
		delIn[1] = new DelAddAtomic(new Predicate(3, 11, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(4), TermList.NIL))));
		delIn[2] = new DelAddAtomic(new Predicate(4, 11, new TermList(TermVariable.getVariable(5), TermList.NIL)));
		delIn[3] = new DelAddAtomic(new Predicate(20, 11, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(6), TermList.NIL))));
		delIn[4] = new DelAddAtomic(new Predicate(13, 11, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(7), TermList.NIL))));
		delIn[5] = new DelAddAtomic(new Predicate(21, 11, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(8), TermList.NIL))));

		setDel(delIn);

		DelAddElement[] addIn = new DelAddElement[6];
		addIn[0] = new DelAddAtomic(new Predicate(2, 11, new TermList(TermVariable.getVariable(0), TermList.NIL)));
		addIn[1] = new DelAddAtomic(new Predicate(3, 11, new TermList(TermVariable.getVariable(1), new TermList(new TermCall(new List(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(9), TermList.NIL)), StdLib.plus, "StdLib.plus"), TermList.NIL))));
		addIn[2] = new DelAddAtomic(new Predicate(4, 11, new TermList(TermVariable.getVariable(9), TermList.NIL)));
		addIn[3] = new DelAddAtomic(new Predicate(20, 11, new TermList(TermVariable.getVariable(2), new TermList(new TermCall(new List(TermVariable.getVariable(6), new TermList(TermVariable.getVariable(10), TermList.NIL)), StdLib.minus, "StdLib.minus"), TermList.NIL))));
		addIn[4] = new DelAddAtomic(new Predicate(13, 11, new TermList(TermVariable.getVariable(1), new TermList(new TermCall(new List(TermVariable.getVariable(7), new TermList(TermVariable.getVariable(10), TermList.NIL)), StdLib.minus, "StdLib.minus"), TermList.NIL))));
		addIn[5] = new DelAddAtomic(new Predicate(21, 11, new TermList(TermVariable.getVariable(1), new TermList(new TermCall(new List(TermVariable.getVariable(8), new TermList(TermVariable.getVariable(10), TermList.NIL)), StdLib.plus, "StdLib.plus"), TermList.NIL))));

		setAdd(addIn);
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		p = (new Precondition5(unifier)).setComparator(null);
		p.reset();

		return p;
	}
}

class Precondition6 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition6(Term[] unifier)
	{
		p = new Precondition[10];
		p[1] = new PreconditionAtomic(new Predicate(2, 11, new TermList(TermVariable.getVariable(3), TermList.NIL)), unifier);
		p[2] = new PreconditionAtomic(new Predicate(3, 11, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier);
		p[3] = new PreconditionAtomic(new Predicate(4, 11, new TermList(TermVariable.getVariable(5), TermList.NIL)), unifier);
		p[4] = new PreconditionAtomic(new Predicate(22, 11, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(6), TermList.NIL))), unifier);
		p[5] = new PreconditionAtomic(new Predicate(13, 11, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(7), TermList.NIL))), unifier);
		p[6] = new PreconditionAtomic(new Predicate(21, 11, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(8), TermList.NIL))), unifier);
		p[7] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(8), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
		p[8] = new PreconditionAssign(new TermNumber(0.1), unifier, 9);
		p[9] = new PreconditionAssign(new TermCall(new List(TermVariable.getVariable(8), new TermList(TermVariable.getVariable(6), TermList.NIL)), UserDefineCall.min, "UserDefineCall.min"), unifier, 10);
		b = new Term[10][];
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
	}

	protected Term[] nextBindingHelper()
	{
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
		}

		Term[] retVal = Term.merge(b, 10);
		b[9] = null;
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
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
		b[6] = null;
		b[7] = null;
		b[8] = null;
		b[9] = null;
	}
}

class Operator6 extends Operator
{
	public Operator6()
	{
		super(new Predicate(6, 11, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))), -1, -1, new TermNumber(1.0));


		DelAddElement[] delIn = new DelAddElement[6];
		delIn[0] = new DelAddAtomic(new Predicate(2, 11, new TermList(TermVariable.getVariable(3), TermList.NIL)));
		delIn[1] = new DelAddAtomic(new Predicate(3, 11, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(4), TermList.NIL))));
		delIn[2] = new DelAddAtomic(new Predicate(4, 11, new TermList(TermVariable.getVariable(5), TermList.NIL)));
		delIn[3] = new DelAddAtomic(new Predicate(22, 11, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(6), TermList.NIL))));
		delIn[4] = new DelAddAtomic(new Predicate(21, 11, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(8), TermList.NIL))));
		delIn[5] = new DelAddAtomic(new Predicate(13, 11, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(7), TermList.NIL))));

		setDel(delIn);

		DelAddElement[] addIn = new DelAddElement[6];
		addIn[0] = new DelAddAtomic(new Predicate(2, 11, new TermList(TermVariable.getVariable(0), TermList.NIL)));
		addIn[1] = new DelAddAtomic(new Predicate(3, 11, new TermList(TermVariable.getVariable(1), new TermList(new TermCall(new List(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(9), TermList.NIL)), StdLib.plus, "StdLib.plus"), TermList.NIL))));
		addIn[2] = new DelAddAtomic(new Predicate(4, 11, new TermList(TermVariable.getVariable(9), TermList.NIL)));
		addIn[3] = new DelAddAtomic(new Predicate(22, 11, new TermList(TermVariable.getVariable(2), new TermList(new TermCall(new List(TermVariable.getVariable(6), new TermList(TermVariable.getVariable(10), TermList.NIL)), StdLib.minus, "StdLib.minus"), TermList.NIL))));
		addIn[4] = new DelAddAtomic(new Predicate(13, 11, new TermList(TermVariable.getVariable(1), new TermList(new TermCall(new List(TermVariable.getVariable(7), new TermList(TermVariable.getVariable(10), TermList.NIL)), StdLib.plus, "StdLib.plus"), TermList.NIL))));
		addIn[5] = new DelAddAtomic(new Predicate(21, 11, new TermList(TermVariable.getVariable(1), new TermList(new TermCall(new List(TermVariable.getVariable(8), new TermList(TermVariable.getVariable(10), TermList.NIL)), StdLib.minus, "StdLib.minus"), TermList.NIL))));

		setAdd(addIn);
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		p = (new Precondition6(unifier)).setComparator(null);
		p.reset();

		return p;
	}
}

class Operator7 extends Operator
{
	public Operator7()
	{
		super(new Predicate(7, 3, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))), -1, -1, new TermNumber(1.0));


		DelAddElement[] delIn = new DelAddElement[1];
		delIn[0] = new DelAddAtomic(new Predicate(3, 3, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), TermList.NIL))));

		setDel(delIn);

		DelAddElement[] addIn = new DelAddElement[1];
		addIn[0] = new DelAddAtomic(new Predicate(3, 3, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))));

		setAdd(addIn);
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		p = (new PreconditionAtomic(new Predicate(3, 3, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier)).setComparator(null);
		p.reset();

		return p;
	}
}

class Operator8 extends Operator
{
	public Operator8()
	{
		super(new Predicate(8, 0, TermList.NIL), -1, -1, new TermNumber(1.0));


		DelAddElement[] delIn = new DelAddElement[0];

		setDel(delIn);

		DelAddElement[] addIn = new DelAddElement[0];

		setAdd(addIn);
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		p = (new PreconditionNil(0)).setComparator(null);
		p.reset();

		return p;
	}
}

class Precondition7 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition7(Term[] unifier)
	{
		p = new Precondition[8];
		p[1] = new PreconditionAtomic(new Predicate(12, 11, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier);
		p[2] = new PreconditionAtomic(new Predicate(15, 11, new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier);
		p[3] = new PreconditionAtomic(new Predicate(9, 11, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(5), TermList.NIL)))), unifier);
		p[4] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(2), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
		p[5] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(4), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
		p[6] = new PreconditionAtomic(new Predicate(8, 11, new TermList(TermVariable.getVariable(6), new TermList(TermVariable.getVariable(1), TermList.NIL))), unifier);
		p[7] = new PreconditionAtomic(new Predicate(3, 11, new TermList(TermVariable.getVariable(6), new TermList(TermVariable.getVariable(7), TermList.NIL))), unifier);
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

class Precondition8 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition8(Term[] unifier)
	{
		p = new Precondition[8];
		p[1] = new PreconditionAtomic(new Predicate(12, 11, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier);
		p[2] = new PreconditionAtomic(new Predicate(15, 11, new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier);
		p[3] = new PreconditionAtomic(new Predicate(9, 11, new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(5), TermList.NIL)))), unifier);
		p[4] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(2), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
		p[5] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(4), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
		p[6] = new PreconditionAtomic(new Predicate(8, 11, new TermList(TermVariable.getVariable(6), new TermList(TermVariable.getVariable(3), TermList.NIL))), unifier);
		p[7] = new PreconditionAtomic(new Predicate(3, 11, new TermList(TermVariable.getVariable(6), new TermList(TermVariable.getVariable(7), TermList.NIL))), unifier);
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

class Precondition9 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition9(Term[] unifier)
	{
		p = new Precondition[3];
		p[1] = new PreconditionAtomic(new Predicate(12, 11, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier);
		p[2] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(2), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
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

class Precondition10 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition10(Term[] unifier)
	{
		p = new Precondition[4];
		p[1] = new PreconditionNegation(new Precondition9(unifier), 11);
		p[2] = new PreconditionAtomic(new Predicate(3, 11, new TermList(TermVariable.getVariable(6), new TermList(TermVariable.getVariable(8), TermList.NIL))), unifier);
		p[3] = new PreconditionAtomic(new Predicate(11, 11, new TermList(TermVariable.getVariable(9), new TermList(TermVariable.getVariable(6), new TermList(TermVariable.getVariable(10), TermList.NIL)))), unifier);
		b = new Term[4][];
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
	}

	protected Term[] nextBindingHelper()
	{
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
		}

		Term[] retVal = Term.merge(b, 4);
		b[3] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		p[3].reset();
		b[1] = null;
		b[2] = null;
		b[3] = null;
	}
}

class Method0 extends Method
{
	public Method0()
	{
		super(new Predicate(0, 11, new TermList(TermVariable.getVariable(0), TermList.NIL)));
		TaskList[] subsIn = new TaskList[3];

		subsIn[0] = createTaskList0();
		subsIn[1] = createTaskList1();
		subsIn[2] = createTaskList2();

		setSubs(subsIn);
	}

	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(2, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(0, 11, new TermList(TermVariable.getVariable(7), new TermList(TermVariable.getVariable(6), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(3), TermList.NIL))))), false, false));
		retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(0, 11, new TermList(TermVariable.getVariable(0), TermList.NIL)), false, false));

		return retVal;
	}

	TaskList createTaskList1()
	{
		TaskList retVal;

		retVal = new TaskList(2, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(0, 11, new TermList(TermVariable.getVariable(7), new TermList(TermVariable.getVariable(6), new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(1), TermList.NIL))))), false, true));
		retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(0, 11, new TermList(TermVariable.getVariable(0), TermList.NIL)), false, false));

		return retVal;
	}

	TaskList createTaskList2()
	{
		TaskList retVal;

		retVal = new TaskList(2, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(7, 11, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(8), TermList.NIL))), false, true));
		retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(8, 11, TermList.NIL), false, true));

		return retVal;
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new Precondition7(unifier)).setComparator(new CompLess(5));
			break;
			case 1:
				p = (new Precondition8(unifier)).setComparator(new CompLess(5));
			break;
			case 2:
				p = (new Precondition10(unifier)).setComparator(new CompLess(8));
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
			case 1: return "Method0Branch1";
			case 2: return "Method0Branch2";
			default: return null;
		}
	}
}

class Precondition11 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition11(Term[] unifier)
	{
		p = new Precondition[6];
		p[1] = new PreconditionAtomic(new Predicate(12, 13, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL))), unifier);
		p[2] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(3), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
		p[3] = new PreconditionAtomic(new Predicate(8, 13, new TermList(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier);
		p[4] = new PreconditionAtomic(new Predicate(15, 13, new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(6), TermList.NIL))), unifier);
		p[5] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(6), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
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

class Precondition12 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition12(Term[] unifier)
	{
		p = new Precondition[8];
		p[1] = new PreconditionAtomic(new Predicate(12, 13, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL))), unifier);
		p[2] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(3), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
		p[3] = new PreconditionAtomic(new Predicate(15, 13, new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(6), TermList.NIL))), unifier);
		p[4] = new PreconditionAtomic(new Predicate(8, 13, new TermList(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(5), TermList.NIL))), unifier);
		p[5] = new PreconditionAtomic(new Predicate(15, 13, new TermList(TermVariable.getVariable(7), new TermList(TermVariable.getVariable(8), TermList.NIL))), unifier);
		p[6] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(8), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
		p[7] = new PreconditionNegation(new PreconditionAtomic(new Predicate(8, 13, new TermList(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier), 13);
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

class Precondition13 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition13(Term[] unifier)
	{
		p = new Precondition[3];
		p[1] = new PreconditionAtomic(new Predicate(12, 13, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL))), unifier);
		p[2] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(3), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
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

class Precondition14 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition14(Term[] unifier)
	{
		p = new Precondition[6];
		p[1] = new PreconditionNegation(new Precondition13(unifier), 13);
		p[2] = new PreconditionAtomic(new Predicate(15, 13, new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(6), TermList.NIL))), unifier);
		p[3] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(6), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.moreEq, "StdLib.moreEq"), unifier);
		p[4] = new PreconditionAtomic(new Predicate(3, 13, new TermList(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(9), TermList.NIL))), unifier);
		p[5] = new PreconditionAtomic(new Predicate(11, 13, new TermList(TermVariable.getVariable(10), new TermList(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(11), TermList.NIL)))), unifier);
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

class Precondition15 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition15(Term[] unifier)
	{
		p = new Precondition[3];
		p[1] = new PreconditionAtomic(new Predicate(15, 13, new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(6), TermList.NIL))), unifier);
		p[2] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(6), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
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

class Precondition16 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition16(Term[] unifier)
	{
		p = new Precondition[4];
		p[1] = new PreconditionAtomic(new Predicate(12, 13, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL))), unifier);
		p[2] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(3), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
		p[3] = new PreconditionNegation(new Precondition15(unifier), 13);
		b = new Term[4][];
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
	}

	protected Term[] nextBindingHelper()
	{
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
		}

		Term[] retVal = Term.merge(b, 4);
		b[3] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		p[3].reset();
		b[1] = null;
		b[2] = null;
		b[3] = null;
	}
}

class Method1 extends Method
{
	public Method1()
	{
		super(new Predicate(0, 13, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))));
		TaskList[] subsIn = new TaskList[4];

		subsIn[0] = createTaskList0();
		subsIn[1] = createTaskList1();
		subsIn[2] = createTaskList2();
		subsIn[3] = createTaskList3();

		setSubs(subsIn);
	}

	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(2, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(1, 13, new TermList(TermVariable.getVariable(2), TermList.NIL)), false, false));
		retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(0, 13, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))), false, false));

		return retVal;
	}

	TaskList createTaskList1()
	{
		TaskList retVal;

		retVal = new TaskList(2, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(2, 13, TermList.NIL), false, false));
		retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(0, 13, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))), false, false));

		return retVal;
	}

	TaskList createTaskList2()
	{
		TaskList retVal;

		retVal = new TaskList(1, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(7, 13, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(9), TermList.NIL))), false, true));

		return retVal;
	}

	TaskList createTaskList3()
	{
		TaskList retVal;

		retVal = new TaskList(1, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(3, 13, new TermList(TermVariable.getVariable(12), TermList.NIL)), false, false));

		return retVal;
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new Precondition11(unifier)).setComparator(null);
			break;
			case 1:
				p = (new Precondition12(unifier)).setComparator(null);
			break;
			case 2:
				p = (new Precondition14(unifier)).setComparator(new CompMore(9));
			break;
			case 3:
				p = (new Precondition16(unifier)).setComparator(null);
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
			case 1: return "Method1Branch1";
			case 2: return "Method1Branch2";
			case 3: return "Method1Branch3";
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
		p = new Precondition[9];
		p[1] = new PreconditionAtomic(new Predicate(12, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))), unifier);
		p[2] = new PreconditionAtomic(new Predicate(15, 10, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL))), unifier);
		p[3] = new PreconditionAtomic(new Predicate(9, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(4), TermList.NIL)))), unifier);
		p[4] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(3), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
		p[5] = new PreconditionAtomic(new Predicate(8, 10, new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(0), TermList.NIL))), unifier);
		p[6] = new PreconditionAtomic(new Predicate(13, 10, new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(6), TermList.NIL))), unifier);
		p[7] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(6), TermList.NIL)), StdLib.moreEq, "StdLib.moreEq"), unifier);
		p[8] = new PreconditionAtomic(new Predicate(3, 10, new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(7), TermList.NIL))), unifier);
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

class Precondition18 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition18(Term[] unifier)
	{
		p = new Precondition[9];
		p[1] = new PreconditionAtomic(new Predicate(12, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))), unifier);
		p[2] = new PreconditionAtomic(new Predicate(12, 10, new TermList(TermVariable.getVariable(8), new TermList(TermVariable.getVariable(9), TermList.NIL))), unifier);
		p[3] = new PreconditionAtomic(new Predicate(9, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(8), new TermList(TermVariable.getVariable(4), TermList.NIL)))), unifier);
		p[4] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(9), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
		p[5] = new PreconditionAtomic(new Predicate(8, 10, new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(0), TermList.NIL))), unifier);
		p[6] = new PreconditionAtomic(new Predicate(13, 10, new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(6), TermList.NIL))), unifier);
		p[7] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(6), TermList.NIL)), StdLib.less, "StdLib.less"), unifier);
		p[8] = new PreconditionAtomic(new Predicate(3, 10, new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(7), TermList.NIL))), unifier);
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

class Precondition19 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition19(Term[] unifier)
	{
		p = new Precondition[4];
		p[1] = new PreconditionAtomic(new Predicate(12, 10, new TermList(TermVariable.getVariable(8), new TermList(TermVariable.getVariable(9), TermList.NIL))), unifier);
		p[2] = new PreconditionNegation(new PreconditionAtomic(new Predicate(0, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(8), TermList.NIL))), unifier), 10);
		p[3] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(9), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
		b = new Term[4][];
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
	}

	protected Term[] nextBindingHelper()
	{
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
		}

		Term[] retVal = Term.merge(b, 4);
		b[3] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		p[3].reset();
		b[1] = null;
		b[2] = null;
		b[3] = null;
	}
}

class Precondition20 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition20(Term[] unifier)
	{
		p = new Precondition[8];
		p[1] = new PreconditionNegation(new Precondition19(unifier), 10);
		p[2] = new PreconditionAtomic(new Predicate(12, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))), unifier);
		p[3] = new PreconditionAtomic(new Predicate(15, 10, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL))), unifier);
		p[4] = new PreconditionAtomic(new Predicate(9, 10, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(4), TermList.NIL)))), unifier);
		p[5] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(3), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
		p[6] = new PreconditionAtomic(new Predicate(8, 10, new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(0), TermList.NIL))), unifier);
		p[7] = new PreconditionAtomic(new Predicate(3, 10, new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(7), TermList.NIL))), unifier);
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

class Method2 extends Method
{
	public Method2()
	{
		super(new Predicate(1, 10, new TermList(TermVariable.getVariable(0), TermList.NIL)));
		TaskList[] subsIn = new TaskList[3];

		subsIn[0] = createTaskList0();
		subsIn[1] = createTaskList1();
		subsIn[2] = createTaskList2();

		setSubs(subsIn);
	}

	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(1, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(0, 10, new TermList(TermVariable.getVariable(7), new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), TermList.NIL))))), false, false));

		return retVal;
	}

	TaskList createTaskList1()
	{
		TaskList retVal;

		retVal = new TaskList(2, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(1, 10, new TermList(TermVariable.getVariable(7), new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(0), TermList.NIL)))), false, true));
		retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(4, 10, new TermList(TermVariable.getVariable(7), new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(8), TermList.NIL))))), false, false));

		return retVal;
	}

	TaskList createTaskList2()
	{
		TaskList retVal;

		retVal = new TaskList(1, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(0, 10, new TermList(TermVariable.getVariable(7), new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), TermList.NIL))))), false, false));

		return retVal;
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new Precondition17(unifier)).setComparator(new CompLess(4));
			break;
			case 1:
				p = (new Precondition18(unifier)).setComparator(new CompLess(4));
			break;
			case 2:
				p = (new Precondition20(unifier)).setComparator(new CompLess(4));
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
			case 1: return "Method2Branch1";
			case 2: return "Method2Branch2";
			default: return null;
		}
	}
}

class Precondition21 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition21(Term[] unifier)
	{
		p = new Precondition[5];
		p[1] = new PreconditionAtomic(new Predicate(14, 9, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(3), TermList.NIL))), unifier);
		p[2] = new PreconditionAtomic(new Predicate(15, 9, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier);
		p[3] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(3), TermList.NIL)), StdLib.moreEq, "StdLib.moreEq"), unifier);
		p[4] = new PreconditionAtomic(new Predicate(3, 9, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(5), TermList.NIL))), unifier);
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

class Precondition22 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition22(Term[] unifier)
	{
		p = new Precondition[9];
		p[1] = new PreconditionAtomic(new Predicate(14, 9, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(3), TermList.NIL))), unifier);
		p[2] = new PreconditionAtomic(new Predicate(15, 9, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier);
		p[3] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(3), TermList.NIL)), StdLib.less, "StdLib.less"), unifier);
		p[4] = new PreconditionAtomic(new Predicate(15, 9, new TermList(TermVariable.getVariable(6), new TermList(TermVariable.getVariable(7), TermList.NIL))), unifier);
		p[5] = new PreconditionNegation(new PreconditionAtomic(new Predicate(0, 9, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(6), TermList.NIL))), unifier), 9);
		p[6] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(4), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
		p[7] = new PreconditionAtomic(new Predicate(9, 9, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(6), new TermList(TermVariable.getVariable(8), TermList.NIL)))), unifier);
		p[8] = new PreconditionAtomic(new Predicate(3, 9, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(5), TermList.NIL))), unifier);
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

class Precondition23 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition23(Term[] unifier)
	{
		p = new Precondition[4];
		p[1] = new PreconditionAtomic(new Predicate(15, 9, new TermList(TermVariable.getVariable(6), new TermList(TermVariable.getVariable(7), TermList.NIL))), unifier);
		p[2] = new PreconditionNegation(new PreconditionAtomic(new Predicate(0, 9, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(6), TermList.NIL))), unifier), 9);
		p[3] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(4), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
		b = new Term[4][];
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
	}

	protected Term[] nextBindingHelper()
	{
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
		}

		Term[] retVal = Term.merge(b, 4);
		b[3] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		p[3].reset();
		b[1] = null;
		b[2] = null;
		b[3] = null;
	}
}

class Precondition24 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition24(Term[] unifier)
	{
		p = new Precondition[4];
		p[1] = new PreconditionNegation(new Precondition23(unifier), 9);
		p[2] = new PreconditionAtomic(new Predicate(3, 9, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(5), TermList.NIL))), unifier);
		p[3] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(3), TermList.NIL)), StdLib.less, "StdLib.less"), unifier);
		b = new Term[4][];
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
	}

	protected Term[] nextBindingHelper()
	{
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
		}

		Term[] retVal = Term.merge(b, 4);
		b[3] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		p[3].reset();
		b[1] = null;
		b[2] = null;
		b[3] = null;
	}
}

class Method3 extends Method
{
	public Method3()
	{
		super(new Predicate(6, 9, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))));
		TaskList[] subsIn = new TaskList[3];

		subsIn[0] = createTaskList0();
		subsIn[1] = createTaskList1();
		subsIn[2] = createTaskList2();

		setSubs(subsIn);
	}

	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(1, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(2, 9, new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))), false, true));

		return retVal;
	}

	TaskList createTaskList1()
	{
		TaskList retVal;

		retVal = new TaskList(3, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(2, 9, new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))), false, true));
		retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(4, 9, new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(6), TermList.NIL))))), false, false));
		retVal.subtasks[2] = new TaskList(new TaskAtom(new Predicate(5, 9, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(6), TermList.NIL)))), false, false));

		return retVal;
	}

	TaskList createTaskList2()
	{
		TaskList retVal;

		retVal = new TaskList(2, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(2, 9, new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))), false, true));
		retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(3, 9, new TermList(TermVariable.getVariable(5), TermList.NIL)), false, false));

		return retVal;
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new Precondition21(unifier)).setComparator(null);
			break;
			case 1:
				p = (new Precondition22(unifier)).setComparator(new CompLess(8));
			break;
			case 2:
				p = (new Precondition24(unifier)).setComparator(null);
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
			case 0: return "Method3Branch0";
			case 1: return "Method3Branch1";
			case 2: return "Method3Branch2";
			default: return null;
		}
	}
}

class Precondition25 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition25(Term[] unifier)
	{
		p = new Precondition[4];
		p[1] = new PreconditionAtomic(new Predicate(3, 8, new TermList(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(5), TermList.NIL))), unifier);
		p[2] = new PreconditionAtomic(new Predicate(8, 8, new TermList(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(6), TermList.NIL))), unifier);
		p[3] = new PreconditionAtomic(new Predicate(15, 8, new TermList(TermVariable.getVariable(6), new TermList(TermVariable.getVariable(7), TermList.NIL))), unifier);
		b = new Term[4][];
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
	}

	protected Term[] nextBindingHelper()
	{
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
		}

		Term[] retVal = Term.merge(b, 4);
		b[3] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		p[3].reset();
		b[1] = null;
		b[2] = null;
		b[3] = null;
	}
}

class Precondition26 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition26(Term[] unifier)
	{
		p = new Precondition[5];
		p[1] = new PreconditionAtomic(new Predicate(3, 8, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))), unifier);
		p[2] = new PreconditionAtomic(new Predicate(8, 8, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier);
		p[3] = new PreconditionAtomic(new Predicate(15, 8, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL))), unifier);
		p[4] = new PreconditionForAll(new Precondition25(unifier), new PreconditionCall(new TermCall(new List(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(1), TermList.NIL)), StdLib.moreEq, "StdLib.moreEq"), unifier), 8);
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

class Method4 extends Method
{
	public Method4()
	{
		super(new Predicate(2, 8, TermList.NIL));
		TaskList[] subsIn = new TaskList[1];

		subsIn[0] = createTaskList0();

		setSubs(subsIn);
	}

	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(1, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(7, 8, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))), false, false));

		return retVal;
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new Precondition26(unifier)).setComparator(null);
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
			case 0: return "Method4Branch0";
			default: return null;
		}
	}
}

class Precondition27 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition27(Term[] unifier)
	{
		p = new Precondition[5];
		p[1] = new PreconditionAtomic(new Predicate(8, 6, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier);
		p[2] = new PreconditionAtomic(new Predicate(12, 6, new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier);
		p[3] = new PreconditionAtomic(new Predicate(9, 6, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(5), TermList.NIL)))), unifier);
		p[4] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(4), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
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
		super(new Predicate(7, 6, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))));
		TaskList[] subsIn = new TaskList[1];

		subsIn[0] = createTaskList0();

		setSubs(subsIn);
	}

	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(1, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(0, 6, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL))))), false, true));

		return retVal;
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new Precondition27(unifier)).setComparator(new CompLess(5));
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
			default: return null;
		}
	}
}

class Precondition28 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition28(Term[] unifier)
	{
		p = new Precondition[7];
		p[1] = new PreconditionAtomic(new Predicate(15, 8, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier);
		p[2] = new PreconditionAtomic(new Predicate(9, 8, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(3), TermList.NIL)))), unifier);
		p[3] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(4), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
		p[4] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(2), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
		p[5] = new PreconditionAtomic(new Predicate(8, 8, new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(1), TermList.NIL))), unifier);
		p[6] = new PreconditionAtomic(new Predicate(3, 8, new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(6), TermList.NIL))), unifier);
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

class Method6 extends Method
{
	public Method6()
	{
		super(new Predicate(7, 8, new TermList(TermVariable.getVariable(0), TermList.NIL)));
		TaskList[] subsIn = new TaskList[1];

		subsIn[0] = createTaskList0();

		setSubs(subsIn);
	}

	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(1, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(0, 8, new TermList(TermVariable.getVariable(6), new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(7), TermList.NIL))))), false, true));

		return retVal;
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new Precondition28(unifier)).setComparator(new CompLess(3));
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
			default: return null;
		}
	}
}

class Method7 extends Method
{
	public Method7()
	{
		super(new Predicate(0, 4, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL))))));
		TaskList[] subsIn = new TaskList[1];

		subsIn[0] = createTaskList0();

		setSubs(subsIn);
	}

	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(3, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(1, 4, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))), false, true));
		retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(4, 4, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL))))), false, false));
		retVal.subtasks[2] = new TaskList(new TaskAtom(new Predicate(6, 4, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(3), TermList.NIL)))), false, false));

		return retVal;
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new PreconditionNil(4)).setComparator(null);
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

class Method8 extends Method
{
	public Method8()
	{
		super(new Predicate(4, 5, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL))))));
		TaskList[] subsIn = new TaskList[1];

		subsIn[0] = createTaskList0();

		setSubs(subsIn);
	}

	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(1, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(0, 5, new TermList(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL))))), false, true));

		return retVal;
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new PreconditionAtomic(new Predicate(3, 5, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier)).setComparator(null);
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
			case 0: return "Method8Branch0";
			default: return null;
		}
	}
}

class Method9 extends Method
{
	public Method9()
	{
		super(new Predicate(5, 4, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))));
		TaskList[] subsIn = new TaskList[1];

		subsIn[0] = createTaskList0();

		setSubs(subsIn);
	}

	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(1, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(2, 4, new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))), false, true));

		return retVal;
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new PreconditionAtomic(new Predicate(3, 4, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(3), TermList.NIL))), unifier)).setComparator(null);
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
			case 0: return "Method9Branch0";
			default: return null;
		}
	}
}

class Precondition29 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition29(Term[] unifier)
	{
		p = new Precondition[4];
		p[1] = new PreconditionAtomic(new Predicate(14, 3, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier);
		p[2] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(2), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
		p[3] = new PreconditionAtomic(new Predicate(3, 3, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(0), TermList.NIL))), unifier);
		b = new Term[4][];
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
	}

	protected Term[] nextBindingHelper()
	{
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
		}

		Term[] retVal = Term.merge(b, 4);
		b[3] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		p[3].reset();
		b[1] = null;
		b[2] = null;
		b[3] = null;
	}
}

class Precondition30 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition30(Term[] unifier)
	{
		p = new Precondition[3];
		p[1] = new PreconditionAtomic(new Predicate(14, 3, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier);
		p[2] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(2), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
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

class Method10 extends Method
{
	public Method10()
	{
		super(new Predicate(3, 3, new TermList(TermVariable.getVariable(0), TermList.NIL)));
		TaskList[] subsIn = new TaskList[2];

		subsIn[0] = createTaskList0();
		subsIn[1] = createTaskList1();

		setSubs(subsIn);
	}

	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(2, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(3, 3, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))), false, true));
		retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(3, 3, new TermList(TermVariable.getVariable(0), TermList.NIL)), false, false));

		return retVal;
	}

	TaskList createTaskList1()
	{
		TaskList retVal;

		retVal = new TaskList(1, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(8, 3, TermList.NIL), false, true));

		return retVal;
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new Precondition29(unifier)).setComparator(null);
			break;
			case 1:
				p = (new PreconditionNegation(new Precondition30(unifier), 3)).setComparator(null);
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
			case 0: return "Method10Branch0";
			case 1: return "Method10Branch1";
			default: return null;
		}
	}
}

class Precondition31 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition31(Term[] unifier)
	{
		p = new Precondition[7];
		p[1] = new PreconditionAtomic(new Predicate(20, 12, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL))), unifier);
		p[2] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(3), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
		p[3] = new PreconditionAtomic(new Predicate(18, 12, new TermList(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier);
		p[4] = new PreconditionAtomic(new Predicate(22, 12, new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(6), TermList.NIL))), unifier);
		p[5] = new PreconditionAtomic(new Predicate(9, 12, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(7), TermList.NIL)))), unifier);
		p[6] = new PreconditionAtomic(new Predicate(3, 12, new TermList(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(8), TermList.NIL))), unifier);
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

class Precondition32 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition32(Term[] unifier)
	{
		p = new Precondition[8];
		p[1] = new PreconditionAtomic(new Predicate(20, 12, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL))), unifier);
		p[2] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(3), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
		p[3] = new PreconditionNegation(new PreconditionAtomic(new Predicate(18, 12, new TermList(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier), 12);
		p[4] = new PreconditionAtomic(new Predicate(22, 12, new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(6), TermList.NIL))), unifier);
		p[5] = new PreconditionAtomic(new Predicate(18, 12, new TermList(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(5), TermList.NIL))), unifier);
		p[6] = new PreconditionAtomic(new Predicate(9, 12, new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(7), TermList.NIL)))), unifier);
		p[7] = new PreconditionAtomic(new Predicate(3, 12, new TermList(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(8), TermList.NIL))), unifier);
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

class Precondition33 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition33(Term[] unifier)
	{
		p = new Precondition[3];
		p[1] = new PreconditionAtomic(new Predicate(20, 12, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL))), unifier);
		p[2] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(3), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.more, "StdLib.more"), unifier);
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

class Precondition34 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition34(Term[] unifier)
	{
		p = new Precondition[6];
		p[1] = new PreconditionNegation(new Precondition33(unifier), 12);
		p[2] = new PreconditionAtomic(new Predicate(22, 12, new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(6), TermList.NIL))), unifier);
		p[3] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(6), new TermList(new TermNumber(0.0), TermList.NIL)), StdLib.moreEq, "StdLib.moreEq"), unifier);
		p[4] = new PreconditionAtomic(new Predicate(3, 12, new TermList(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(9), TermList.NIL))), unifier);
		p[5] = new PreconditionAtomic(new Predicate(19, 12, new TermList(TermVariable.getVariable(10), new TermList(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(11), TermList.NIL)))), unifier);
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

class Method11 extends Method
{
	public Method11()
	{
		super(new Predicate(10, 12, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))));
		TaskList[] subsIn = new TaskList[3];

		subsIn[0] = createTaskList0();
		subsIn[1] = createTaskList1();
		subsIn[2] = createTaskList2();

		setSubs(subsIn);
	}

	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(4, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(5, 12, new TermList(TermVariable.getVariable(8), new TermList(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(2), TermList.NIL)))), false, true));
		retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(8, 12, new TermList(TermVariable.getVariable(8), new TermList(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(5), TermList.NIL))))), false, false));
		retVal.subtasks[2] = new TaskList(new TaskAtom(new Predicate(9, 12, new TermList(TermVariable.getVariable(8), new TermList(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(5), TermList.NIL)))), false, false));
		retVal.subtasks[3] = new TaskList(new TaskAtom(new Predicate(10, 12, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(8), TermList.NIL))), false, false));

		return retVal;
	}

	TaskList createTaskList1()
	{
		TaskList retVal;

		retVal = new TaskList(2, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(4, 12, new TermList(TermVariable.getVariable(8), new TermList(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(2), TermList.NIL))))), false, true));
		retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(10, 12, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(8), TermList.NIL))), false, false));

		return retVal;
	}

	TaskList createTaskList2()
	{
		TaskList retVal;

		retVal = new TaskList(1, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(7, 12, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(9), TermList.NIL))), false, true));

		return retVal;
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new Precondition31(unifier)).setComparator(new CompLess(7));
			break;
			case 1:
				p = (new Precondition32(unifier)).setComparator(new CompLess(7));
			break;
			case 2:
				p = (new Precondition34(unifier)).setComparator(new CompMore(9));
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
			case 0: return "Method11Branch0";
			case 1: return "Method11Branch1";
			case 2: return "Method11Branch2";
			default: return null;
		}
	}
}

class Method12 extends Method
{
	public Method12()
	{
		super(new Predicate(8, 5, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL))))));
		TaskList[] subsIn = new TaskList[1];

		subsIn[0] = createTaskList0();

		setSubs(subsIn);
	}

	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(1, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(4, 5, new TermList(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL))))), false, true));

		return retVal;
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new PreconditionAtomic(new Predicate(3, 5, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier)).setComparator(null);
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
			case 0: return "Method12Branch0";
			default: return null;
		}
	}
}

class Method13 extends Method
{
	public Method13()
	{
		super(new Predicate(9, 4, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))));
		TaskList[] subsIn = new TaskList[1];

		subsIn[0] = createTaskList0();

		setSubs(subsIn);
	}

	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(1, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(6, 4, new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))), false, true));

		return retVal;
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new PreconditionAtomic(new Predicate(3, 4, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(3), TermList.NIL))), unifier)).setComparator(null);
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
			case 0: return "Method13Branch0";
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

class flood_evacuate extends Domain
{
	public flood_evacuate()
	{
		TermVariable.initialize(16);

		constants = new String[23];
		constants[0] = "same";
		constants[1] = "different";
		constants[2] = "starttime";
		constants[3] = "end-time";
		constants[4] = "duration";
		constants[5] = "res-gas";
		constants[6] = "cost-resource";
		constants[7] = "owner-at";
		constants[8] = "bus-at-loc";
		constants[9] = "distance-between";
		constants[10] = "speed-of";
		constants[11] = "bus-mile-spend";
		constants[12] = "person-of";
		constants[13] = "carry-ability";
		constants[14] = "carryed-person";
		constants[15] = "capacity-of";
		constants[16] = "c";
		constants[17] = "number-of";
		constants[18] = "track-at-loc";
		constants[19] = "track-mile-spend";
		constants[20] = "goods-of";
		constants[21] = "carryed-goods";
		constants[22] = "capacity-of-goods";

		compoundTasks = new String[11];
		compoundTasks[0] = "evacuation-people";
		compoundTasks[1] = "leave-flood-area";
		compoundTasks[2] = "to-flood-area-1";
		compoundTasks[3] = "use-extent-area";
		compoundTasks[4] = "move-people";
		compoundTasks[5] = "unload-people";
		compoundTasks[6] = "unload-people-mult";
		compoundTasks[7] = "to-flood-area";
		compoundTasks[8] = "move-goods";
		compoundTasks[9] = "unload-goods";
		compoundTasks[10] = "evacuation-goods";

		primitiveTasks = new String[9];
		primitiveTasks[0] = "!bus-move";
		primitiveTasks[1] = "!bus-carry";
		primitiveTasks[2] = "!bus-unload";
		primitiveTasks[3] = "!use-extend-area";
		primitiveTasks[4] = "!track-move";
		primitiveTasks[5] = "!track-carry";
		primitiveTasks[6] = "!track-unload";
		primitiveTasks[7] = "!!save-method";
		primitiveTasks[8] = "!!return-back";

		methods = new Method[11][];

		methods[0] = new Method[3];
		methods[0][0] = new Method0();
		methods[0][1] = new Method1();
		methods[0][2] = new Method7();

		methods[1] = new Method[1];
		methods[1][0] = new Method2();

		methods[2] = new Method[1];
		methods[2][0] = new Method4();

		methods[3] = new Method[1];
		methods[3][0] = new Method10();

		methods[4] = new Method[1];
		methods[4][0] = new Method8();

		methods[5] = new Method[1];
		methods[5][0] = new Method9();

		methods[6] = new Method[1];
		methods[6][0] = new Method3();

		methods[7] = new Method[2];
		methods[7][0] = new Method5();
		methods[7][1] = new Method6();

		methods[8] = new Method[1];
		methods[8][0] = new Method12();

		methods[9] = new Method[1];
		methods[9][0] = new Method13();

		methods[10] = new Method[1];
		methods[10][0] = new Method11();


		ops = new Operator[9][];

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

		ops[7] = new Operator[1];
		ops[7][0] = new Operator7();

		ops[8] = new Operator[1];
		ops[8][0] = new Operator8();

		axioms = new Axiom[23][];

		axioms[0] = new Axiom[1];
		axioms[0][0] = new Axiom0();

		axioms[1] = new Axiom[1];
		axioms[1][0] = new Axiom1();

		axioms[2] = new Axiom[0];

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

		axioms[22] = new Axiom[0];

	}
}