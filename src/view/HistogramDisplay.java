package view;

import model.Histogram;
import java.awt.Dimension;
import javax.swing.JPanel;
import model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame{
    public Histogram<String> histogram;

    public HistogramDisplay(Histogram param) {
        super("HISTOGRAMA");        
        this.histogram = param;
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
        JFreeChart chart = ChartFactory.createBarChart("HISTOGRAMA JFreeChart", "Dominios", 
                "Nº emails", dataSet, PlotOrientation.VERTICAL, 
                false, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
        return chart;        
    }
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String e : histogram.keySet()) {
            dataset.addValue(histogram.get(e), "", e);
        }
        return dataset;
    }
}