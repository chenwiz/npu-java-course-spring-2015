/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

import java.util.Observable;

/**
 * The model class of the calculator application.
 */

public class Calculator extends Observable {
    private String mShow = "", mOneNumber = "", mOperator = "",mAns = "",a;
    
    
    /**
     * The available operators of the calculator.
     */
    public enum Operator {
        CLEAR,       // C
        CLEAR_ENTRY, // CE
        BACKSPACE,   // ⌫
        EQUAL,       // =
        PLUS,        // +
        MINUS,       // -
        TIMES,       // ×
        OVER,        // ⁄
        PLUS_MINUS,  // ±
        RECIPROCAL,  // 1/x
        PERCENT,     // %
        SQRT,        // √
        MEM_CLEAR,   // MC
        MEM_SET,     // MS
        MEM_PLUS,    // M+
        MEM_MINUS,   // M-
        MEM_RECALL   // MR
    }
    
    public void appendDigit(int digit) {
        // TODO code application logic here
        mShow += Integer.toString(digit);
        setChanged();
        notifyObservers();
        
    }
    
    public void appendDot() {
        // TODO code application logic here     
       
    }
    
    public void performOperation(Operator operator) {
           // TODO code application logic here
        if(operator == Operator.PLUS){
            mOperator = "+";
            mOneNumber = mShow;
            mShow= "";   
        }
        if(operator == Operator.MINUS){
            mOperator = "-";
            mOneNumber = mShow;
            mShow = ""; 
        }
        if(operator == Operator.TIMES){
            mOperator = "*";
            mOneNumber = mShow;
            mShow = "";
        }
        if(operator == Operator.OVER){
            mOperator = "/";
            mOneNumber = mShow;
            mShow = "";  
        }
        if(operator == Operator.CLEAR)
        {
            mShow = "0";
        }
        if(operator == Operator.BACKSPACE){
            mShow = mShow.substring(0, mShow.length() - 1);
        }
        
        switch (operator) {
            case EQUAL:                
                switch (mOperator) {
                    case "+":
                        mShow = String.valueOf(Float.parseFloat(mOneNumber) + Float.parseFloat(mShow));
                        break;
                    case "-":
                        mShow = String.valueOf(Float.parseFloat(mOneNumber) - Float.parseFloat(mShow));
                        break;
                    case "*":
                        mShow = String.valueOf(Float.parseFloat(mOneNumber) * Float.parseFloat(mShow));
                        break;
                    case "/":
                        mShow = String.valueOf(Float.parseFloat(mOneNumber) / Float.parseFloat(mShow));
                        break;
                    case "":
                        return;
                }
                break;           
        }
        setChanged();
        notifyObservers();
    }

    public String getDisplay() {
        mAns= mShow + mOperator;
        return mAns;
    }
  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ComputerForm().setVisible(true);
            }
        });
    }
}
