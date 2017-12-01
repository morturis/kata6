package view;

import java.awt.Dimension;
import javax.swing.JPanel;
import model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay<T> extends ApplicationFrame{
    private final  Histogram<T> histogram;
    private final String ejeX;

    public HistogramDisplay(Histogram<T> histogram, String ejeX) {
        super("HISTOGRAMA");
        this.histogram = histogram;
        this.ejeX = ejeX;
        setContentPane(createPanel());
        pack();
    }
    
    public void execute(){
        setVisible(true);
    }
    private JPanel createPanel(){
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(500, 400));
        return chartPanel;
    }
    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        JFreeChart chart = ChartFactory.createBarChart("HISTOGRAMA JFreeChart", ejeX, 
                "Nº emails", dataSet, PlotOrientation.VERTICAL, 
                false, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
        return chart;        
    }
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (T e : histogram.keySet()) {
            dataset.addValue(histogram.get(e), "",(Comparable) e);
        }
        return dataset;
    }
}