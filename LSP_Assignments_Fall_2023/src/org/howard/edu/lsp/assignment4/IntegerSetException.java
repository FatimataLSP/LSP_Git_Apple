package org.howard.edu.lsp.assignment4;

public class IntegerSetException extends Exception {
/** 
* This class represents an exception specific to the IntegerSet class. 
* It is used to handle conditions or errors that may occur during the
* execution of operations in the IntegerSet class. It includes a custom error message
* for more clear error handling.
*
* @author Fatimata Niang
*/

	private static final long serialVersionUID = 1L;
	
	/**
     * This constructs a new IntegerSetException with a customized error message
     *
     * @param errorMsg is a user defined error message that describes the condition for the exception
     */
	public IntegerSetException(String errorMsg){		
		super(errorMsg);
	}
	

}


