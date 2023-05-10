package com.brandon.vectorcalculator;

import android.app.Activity;
import android.content.Context;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.util.YailList;
import com.google.appinventor.components.runtime.EventDispatcher;

@DesignerComponent(
        version = 1,
        description = "",
        category = ComponentCategory.EXTENSION,
        nonVisible = true,
        iconName = "https://allmyassets.files.wordpress.com/2023/04/vector-calculator.png")

@SimpleObject(external = true)
//Libraries
@UsesLibraries(libraries = "")
//Permissions
@UsesPermissions(permissionNames = "")

public class VectorCalculator extends AndroidNonvisibleComponent {
    private int vectorCount = 0;

    //Activity and Context
    private Context context;
    private Activity activity;

    public VectorCalculator(ComponentContainer container){
        super(container.$form());
        this.activity = container.$context();
        this.context = container.$context();
    }

    @SimpleFunction(description = "Adds two vectors together.")
    public double AddVectors(double x1, double y1, double x2, double y2) {
        return x1 + x2 + y1 + y2;
    }

    @SimpleFunction(description = "Subtracts one vector from another.")
    public double SubtractVectors(double x1, double y1, double x2, double y2) {
        return x1 - x2 + y1 - y2;
    }

    @SimpleFunction(description = "Calculates the dot product of two vectors.")
    public double DotProduct(double x1, double y1, double x2, double y2) {
        return x1 * x2 + y1 * y2;
    }

    @SimpleFunction(description = "Calculates the magnitude of a vector.")
    public double VectorMagnitude(double x, double y) {
        return Math.sqrt(x * x + y * y);
    }

    @SimpleEvent(description = "Fires when a vector calculation is completed.")
    public void VectorCalculationComplete(double result) {
        EventDispatcher.dispatchEvent(this, "VectorCalculationComplete", result);
    }

    @SimpleEvent(description = "Fires when an error occurs during a vector calculation.")
    public void VectorCalculationError(String errorMessage) {
        EventDispatcher.dispatchEvent(this, "VectorCalculationError", errorMessage);
    }

    @SimpleProperty(description = "Gets or sets the number of vectors used in calculations.")
    public int VectorCount() {
        return vectorCount;
    }

    @SimpleProperty(description = "Gets or sets the number of vectors used in calculations.")
    public void VectorCount(int count) {
        vectorCount = count;
    }
}
