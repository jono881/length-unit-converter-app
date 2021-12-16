package au.edu.unsw.infs3634.unitconverter;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Converter {

    // receive the intended units from the Main Activity
    private String unit1;
    private String unit2;

    // receive user's input and conduct calculations for output value
    private double inputValue;
    private double outputValue;

    // converting constant value from 1 by default to the desired value between units
    private double constant;

    DecimalFormat df = new DecimalFormat("###.####");


    public Converter(){

    }

    public Converter(double inputValue, String unit1, String unit2){
        this.inputValue = inputValue;
        this.unit1 = unit1;
        this.unit2 = unit2;
    }

    // setter and getter methods
    public String getUnit1() {
        return unit1;
    }

    public void setUnit1(String unit1) {
        this.unit1 = unit1;
    }

    public String getUnit2() {
        return unit2;
    }

    public void setUnit2(String unit2) {
        this.unit2 = unit2;
    }

    public double getInputValue() {
        return inputValue;
    }

    // record inputValue from Main Activity
    public void setInputValue(double inputValue) {
        // adding condition if there's no input
         this.inputValue = inputValue;
    }

    // will eventually use this method in Convertion Activity class
    public double getOutputValue() {
        return outputValue;
    }

    // method to set the output value by multiplying input value by the constant from setConstant()
    public void setOutputValue(double inputValue) {
        this.outputValue = this.inputValue * getConstant();
    }

    public double getConstant() {
        return constant;
    }

    // Crucial method that determines multiplier for input value to output value
    public void setConstant(String unit1, String unit2) {
        this.constant = 1;
        switch(unit1){
            // convert from mm
            case "millimetres":
                switch(unit2){
                    case "millimetres":
                        this.constant = 1;
                        break;
                    case "centimetres":
                        this.constant = 0.1;
                        break;
                    case "metres":
                        this.constant = 0.001;
                        break;
                    case "kilometres":
                        this.constant = 1e-6;
                        break;
                    case "inches":
                        this.constant = 1/25.4;
                        break;
                    case "feet":
                        this.constant = 0.00328084;
                        break;
                    case "yards":
                        this.constant = 0.00109361;
                        break;
                    case "miles":
                        this.constant = 6.2137e-7;
                        break;
                }
                break;
            // convert from cm
            case "centimetres":
                switch(unit2){
                    case "millimetres":
                        this.constant = 10;
                        break;
                    case "centimetres":
                        this.constant = 1;
                        break;
                    case "metres":
                        this.constant = 0.01;
                        break;
                    case "kilometres":
                        this.constant = 1e-5;
                        break;
                    case "inches":
                        this.constant = 1/2.54;
                        break;
                    case "feet":
                        this.constant = 1/30.4;
                        break;
                    case "yards":
                        this.constant = 1/91.44;
                        break;
                    case "miles":
                        this.constant = 6.2137e-6;
                        break;
                }
                break;
            // convert from m
            case "metres":
                switch(unit2){
                    case "millimetres":
                        this.constant = 1000;
                        break;
                    case "centimetres":
                        this.constant = 100;
                        break;
                    case "metres":
                        this.constant = 1;
                        break;
                    case "kilometres":
                        this.constant = 0.001;
                        break;
                    case "inches":
                        this.constant = 39.3701;
                        break;
                    case "feet":
                        this.constant = 3.28084;
                        break;
                    case "yards":
                        this.constant = 1.09361;
                        break;
                    case "miles":
                        this.constant = 0.000621371;
                        break;
                }
                break;
            // convert from km
            case "kilometres":
                switch(unit2){
                    case "millimetres":
                        this.constant = 1e+6;
                        break;
                    case "centimetres":
                        this.constant = 100000;
                        break;
                    case "metres":
                        this.constant = 1000;
                        break;
                    case "kilometres":
                        this.constant = 1;
                        break;
                    case "inches":
                        this.constant = 39370.1;
                        break;
                    case "feet":
                        this.constant = 3280.84;
                        break;
                    case "yards":
                        this.constant = 1093.61;
                        break;
                    case "miles":
                        this.constant = 0.621371;
                        break;
                }
                break;
            // convert from in
            case "inches":
                switch(unit2){
                    case "millimetres":
                        this.constant = 25.4;
                        break;
                    case "centimetres":
                        this.constant = 2.54;
                        break;
                    case "metres":
                        this.constant = 0.0254;
                        break;
                    case "kilometres":
                        this.constant = 2.54e-5;
                        break;
                    case "inches":
                        this.constant = 1;
                        break;
                    case "feet":
                        this.constant = 1/12;
                        break;
                    case "yards":
                        this.constant = 1/36;
                        break;
                    case "miles":
                        this.constant = 1/63360;
                        break;
                }
                break;
            // convert from ft
            case "feet":
                switch(unit2){
                    case "millimetres":
                        this.constant = 304.8;
                        break;
                    case "centimetres":
                        this.constant = 30.48;
                        break;
                    case "metres":
                        this.constant = 0.3048;
                        break;
                    case "kilometres":
                        this.constant = 0.0003048;
                        break;
                    case "inches":
                        this.constant = 12;
                        break;
                    case "feet":
                        this.constant = 1;
                        break;
                    case "yards":
                        this.constant = 1/3;
                        break;
                    case "miles":
                        this.constant = 1/5280;
                        break;
                }
                break;
            // convert from yd
            case "yards":
                switch(unit2){
                    case "millimetres":
                        this.constant = 914.4;
                        break;
                    case "centimetres":
                        this.constant = 91.44;
                        break;
                    case "metres":
                        this.constant = 0.9144;
                        break;
                    case "kilometres":
                        this.constant = 0.0009144;
                        break;
                    case "inches":
                        this.constant = 36;
                        break;
                    case "feet":
                        this.constant = 3;
                        break;
                    case "yards":
                        this.constant = 1;
                        break;
                    case "miles":
                        this.constant = 1/1760;
                        break;
                }
                break;
            // convert from mi
            case "miles":
                switch(unit2){
                    case "millimetres":
                        this.constant = 1.609e+6;
                        break;
                    case "centimetres":
                        this.constant = 160934;
                        break;
                    case "metres":
                        this.constant = 1609.34;
                        break;
                    case "kilometres":
                        this.constant = 1.60934;
                        break;
                    case "inches":
                        this.constant = 63360;
                        break;
                    case "feet":
                        this.constant = 5280;
                        break;
                    case "yards":
                        this.constant = 1760;
                        break;
                    case "miles":
                        this.constant = 1;
                        break;
                }
                break;
        }
    }
}
