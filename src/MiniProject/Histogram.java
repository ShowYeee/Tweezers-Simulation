package MiniProject;


import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.chart.renderer.xy.GradientXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries; 
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleEdge;

import com.orsoncharts.Range;

public class Histogram {
	


	void show(int a[][] , int num) {
		
		System.out.println(a[0].length);
		
		double data[] = new double[a[0].length];
		
		for(int i = 0 ; i < a[0].length ; i++)data[i] = a[num-1][i];
		
		XYSeries series1 = new XYSeries("total");
		 for (int i = 0; i < a[0].length; i++) {
			    series1.add(i, data[i]);
		}
		 
		 
		 
		 final XYSeriesCollection dataset = new XYSeriesCollection(series1);
		 
		 
		 
		 PlotOrientation orientation = PlotOrientation.VERTICAL;
		 String title = "Distributed of " + num;
		 boolean show = false;
		 boolean toolTips = true;
		 boolean urls = false;
		 
		 JFreeChart chart = ChartFactory.createXYBarChart(title, "condiction", urls, "number", dataset, orientation, show,toolTips,urls);
		 
		 
		 XYPlot plot = (XYPlot) chart.getPlot();
		 
		 ValueAxis xAxis = plot.getDomainAxis();
		 xAxis.setRange(0,a[0].length);
		 
		 ValueAxis yAxis = plot.getRangeAxis();
		 yAxis.setRange(0,largest(data)+5);
		 
		 
		 plot.setBackgroundPaint(Color.white);
		 plot.setRangeGridlinesVisible(true);
		 plot.setDomainGridlinesVisible(true);
		 plot.setRangeGridlinePaint(Color.black);
		 plot.setDomainGridlinePaint(Color.black);
		
		   
		 
		 
		 
		 XYBarRenderer renderer = (XYBarRenderer) plot.getRenderer();
		 renderer.setBarPainter(createBarPainter());
		 renderer.setMargin(0.2);
		 renderer.setSeriesPaint( 1 ,  Color.BLACK);   
		 renderer.setBaseOutlinePaint(Color.BLACK);   
		 renderer.setBarPainter(createBarPainter());
		 
		 
 
		 
		 
		 ChartFrame pieFrame =  new  ChartFrame( "Distributed Chart\r\n" + "" , chart);  
	     pieFrame.pack();  
	     pieFrame.setVisible( true );

		
	}
	
	private GradientXYBarPainter createBarPainter() {
        return new GradientXYBarPainter() {

            private static final long serialVersionUID = -1997018568242678921L;

            @Override
            public void paintBar(Graphics2D g2, XYBarRenderer renderer, int row, int column,
                RectangularShape bar, RectangleEdge base) {
                double wCoeff = 0.8;
                double hCoeff = 1;
                double newWidth, deltaW, deltaX;

                Rectangle2D rect = bar.getFrame();
                newWidth = rect.getWidth() * wCoeff;
                deltaW = rect.getWidth() - newWidth;
                deltaX = deltaW / 2;
                rect.setRect(rect.getX() + deltaX, rect.getY(), newWidth, rect.getHeight() * hCoeff);
                bar.setFrame(rect);
                super.paintBar(g2, renderer, row, column, bar, base);
            }
        };
    }
	
	int largest(double[] data)
	  {
	     int max=(int) data[0];         
	     for(int i=0;i<data.length;i++)
	        if(max<data[i])
	        max=(int) data[i];
	     System.out.println("largest num = "+max);   
	     return max;
	  }

	

}
