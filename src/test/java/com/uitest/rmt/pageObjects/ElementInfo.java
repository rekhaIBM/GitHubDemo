package com.uitest.rmt.pageObjects;

import org.openqa.selenium.WebElement;

public class ElementInfo {
    private String fieldValue;
    private WebElement element;
    private String fieldName;

    public ElementInfo(String fieldValue, WebElement element, String fieldName) {
        this.fieldValue = fieldValue;
        this.element = element;
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public WebElement getElement() {
        return element;
    }

    public void setElement(WebElement element) {
        this.element = element;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
