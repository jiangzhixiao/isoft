package io.isoft.base.filter;

import java.io.Serializable;
import java.util.ArrayList;

public class MyFilter implements Serializable {

	/**
	 * This is the Flexicious MyFilter object that is bound to the client
	 * grid. This is sent to us from flex.
	 */
	private static final long serialVersionUID = 5863566635427977672L;
	public int pageSize;
	public int pageIndex;
	public int pageCount;
	public int recordCount;
    public ArrayList<MyFilterExpression> arguments;
    public ArrayList<MyFilterSort> sorts;
}
