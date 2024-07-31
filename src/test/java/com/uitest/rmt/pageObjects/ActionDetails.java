package com.uitest.rmt.pageObjects;

public class ActionDetails {
	private String comparatorType;
	private String attributeName;
	private String stringToCompare;
	private String actionType;

	public ActionDetails(String comparatorType, String attributeName, String stringToCompare, String actionType) {
		this.comparatorType = comparatorType;
		this.attributeName = attributeName;
		this.stringToCompare = stringToCompare;
		this.actionType = actionType;
	}

	public String getComparatorType() {
        return comparatorType;
    }

    public void setComparatorType(String comparatorType) {
        this.comparatorType = comparatorType;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getStringToCompare() {
        return stringToCompare;
    }

    public void setStringToCompare(String stringToCompare) {
        this.stringToCompare = stringToCompare;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }
}
