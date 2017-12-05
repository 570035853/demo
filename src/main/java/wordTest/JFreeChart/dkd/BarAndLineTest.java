package wordTest.JFreeChart.dkd;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import wordTest.JFreeChart.ChartUtils;
import wordTest.JFreeChart.Serie;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Vector;

/**
 * Created by zoujialei on 17/11/30.
 */
public class BarAndLineTest {

    public ChartPanel createChart() {
        String[] categories = { "11月", "12月", "1月", "2月", "3月", "4月", "5月", "6月", "7月",
                "8月", "9月", "10月" };
        Vector<Serie> seriesNetProfit = new Vector<Serie>();
        // 月度融资额
        Object[] loanAmt = { 7114, 7257, 3381, 8726,7039, 3029, 8530, 13280, 570, 5530,10871, 9361 };
        // 月度融资额
        Object[] returnAmt = { "3737", "1855", "5220", "6532","7451", "3186", "8530", "7039", "3029", "8530","13850", "0" };
        seriesNetProfit.add(new Serie("月度融资额", loanAmt));
        seriesNetProfit.add(new Serie("月度还款额", returnAmt));

        DefaultCategoryDataset barDataset = ChartUtils.createDefaultCategoryDataset(seriesNetProfit, categories);

        Object[] usedRatio = { 0.68, 0.95, 0.85, 0.96, 0.94, 0.94, 0.92, 1.24, 1.12, 0.97, 0.82, 1.29 };
        Vector<Serie> seriesPayoutRatio = new Vector<Serie>();
        seriesPayoutRatio.add(new Serie("占授信额度比例", usedRatio));
        DefaultCategoryDataset lineDataset = ChartUtils.createDefaultCategoryDataset(seriesPayoutRatio, categories);

        JFreeChart chart = ChartFactory.createBarChart("", "", "金额(万元)", barDataset);

        ChartUtils.setBarRenderer(chart.getCategoryPlot(), true);
        // 设置坐标轴
        ChartUtils.setXAixs(chart.getCategoryPlot());
        ChartUtils.setYAixs(chart.getCategoryPlot());

        CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();

        //左侧Y轴
        NumberAxis numberAxis = (NumberAxis) categoryplot.getRangeAxis();
//        numberAxis.setAutoRangeMinimumSize(25000);
        numberAxis.setMinorTickMarksVisible(true);
        numberAxis.setLowerBound(0);


        // linechart
        categoryplot.setDataset(1, lineDataset);
        categoryplot.mapDatasetToRangeAxis(1, 1);
        // X轴刻度
//        CategoryAxis categoryaxis = categoryplot.getDomainAxis();
//        categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        // 右侧Y轴
        NumberAxis numberaxis = new NumberAxis("占授信额度比例(%)");
        categoryplot.setRangeAxis(1, numberaxis);
        // 隐藏Y刻度
        numberaxis.setAxisLineVisible(false);
        numberaxis.setTickMarksVisible(false);
        numberaxis.setNumberFormatOverride(NumberFormat.getPercentInstance());


        //设置柱状图颜色
        BarRenderer barRenderer = (BarRenderer) categoryplot.getRenderer();
        barRenderer.setSeriesPaint(0, new Color(200, 30, 30));
        barRenderer.setSeriesPaint(1, new Color(0, 200, 0));
        barRenderer.setItemMargin(0.0);
        barRenderer.setBaseItemLabelsVisible(true);
        barRenderer.setSeriesItemLabelPaint(0, new Color(200, 30, 30));
        barRenderer.setSeriesItemLabelPaint(1, new Color(0, 200, 0));
        barRenderer.setSeriesItemLabelFont(0, new Font("宋体", Font.PLAIN, 10));
        barRenderer.setSeriesItemLabelFont(1, new Font("宋体", Font.PLAIN, 10));


        // 设置折线图样式
        LineAndShapeRenderer lineRenderer = new LineAndShapeRenderer();
        lineRenderer.setSeriesPaint(0, new Color(255, 185, 1));
        lineRenderer.setBaseShapesVisible(true);// 数据点绘制形状
        lineRenderer.setBaseItemLabelsVisible(true);
//        lineRenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", new DecimalFormat("0%")));
        lineRenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", NumberFormat.getPercentInstance()));

        categoryplot.setRenderer(1, lineRenderer);

        ValueMarker marker = new ValueMarker(20000);//这个应该就是。
        categoryplot.addRangeMarker(marker);

        categoryplot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);// 绘制Z-index, 将折线图在前面
//        chart.getLegend().setPosition(RectangleEdge.TOP);//标注在顶部
        chart.getLegend().setFrame(new BlockBorder(Color.WHITE));
        ChartPanel chartPanel = new ChartPanel(chart);
        return chartPanel;
    }

    public static void main(String[] args) {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024, 420);
        frame.setLocationRelativeTo(null);

        SwingUtilities.invokeLater(new Runnable() {
            //			@Override
            public void run() {
                // 创建图形
                ChartPanel chartPanel = new BarAndLineTest().createChart();
                frame.getContentPane().add(chartPanel);
                frame.setVisible(true);
            }
        });

    }



}
