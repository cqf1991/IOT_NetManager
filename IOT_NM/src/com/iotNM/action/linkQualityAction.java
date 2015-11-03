package com.iotNM.action;

import com.iotNM.common.RegressionLine;
import com.iotNM.common.Struts2Utils;
import com.iotNM.entity.DataPoint;
import com.opensymphony.xwork2.ActionSupport;

public class linkQualityAction extends ActionSupport {
	private float[] DataX;
	private float[] DataY;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
	
	public void linearReg()
	{
		 RegressionLine line = new RegressionLine();
		 for(int i=0;i<DataX.length;i++)
		 {
			 line.addDataPoint(new DataPoint(DataX[i], DataY[i]));//LQI-RSSi
		 }
		 
		 Struts2Utils.renderJson(line.getA1()+","+line.getA0()+","+line.getR());
		   printSums(line);  
	       printLine(line);
		 
	}

	public float[] getDataY() {
		return DataY;
	}

	public void setDataY(float[] dataY) {
		DataY = dataY;
	}

	public float[] getDataX() {
		return DataX;
	}

	public void setDataX(float[] dataX) {
		DataX = dataX;
	}
	 /** 
     * Print the computed sums. 
     *  
     * @param line 
     *            the regression line 
     */  
    private static void printSums(RegressionLine line) {  
        System.out.println("\n数据点个数 n = " + line.getDataPointCount());  
        System.out.println("\nSum x  = " + line.getSumX());  
        System.out.println("Sum y  = " + line.getSumY());  
        System.out.println("Sum xx = " + line.getSumXX());  
        System.out.println("Sum xy = " + line.getSumXY());  
        System.out.println("Sum yy = " + line.getSumYY());  
  
    }  
  
    /** 
     * Print the regression line function. 
     *  
     * @param line 
     *            the regression line 
     */  
    private static void printLine(RegressionLine line) {  
        System.out.println("\n回归线公式:  y = " + line.getA1() + "x + "  
                + line.getA0());  
        System.out.println("误差：     R^2 = " + line.getR());  
    }  

}
