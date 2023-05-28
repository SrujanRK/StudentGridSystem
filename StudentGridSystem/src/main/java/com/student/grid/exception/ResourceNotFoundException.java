package com.student.grid.exception;

public class ResourceNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String resourceName;
	String fieldName;
	int fieldValue;
	
	public ResourceNotFoundException(String resourceName, String fieldName, int fieldValue) {
		super(resourceName+" not found "+fieldName+" on "+fieldValue);
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	

}
