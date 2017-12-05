package wordTest.JFreeChart.dkd;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleEdge;
import wordTest.JFreeChart.ChartUtils;

import javax.swing.*;
import java.awt.*;

/**
 * Created by zoujialei on 17/11/30.
 */
public class PeiTest {

    public DefaultPieDataset createDataset() {
        String[] categories = { "三个月", "四个月", "五个月" };
        Object[] datas = { 87, 2, 11 };
        DefaultPieDataset dataset = ChartUtils.createDefaultPieDataset(categories, datas);
        return dataset;
    }

    public ChartPanel createChart() {
        // 2：创建Chart[创建不同图形]
        JFreeChart chart = ChartFactory.createPieChart("", createDataset());
        // 4:对柱子进行渲染[创建不同图形]
        ChartUtils.setPieRender(chart.getPlot());
        // 设置标注无边框
        chart.getLegend().setFrame(new BlockBorder(Color.WHITE));
        // 标注位于右侧
        chart.getLegend().setPosition(RectangleEdge.RIGHT);
        Font font = new Font("黑体", Font.BOLD, 20);
        chart.setTitle(new TextTitle("不同期限项目占比", font));
        // 6:使用chartPanel接收
        ChartPanel chartPanel = new ChartPanel(chart);
        return chartPanel;
    }

    public static void main(String[] args) {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLocationRelativeTo(null);

        SwingUtilities.invokeLater(new Runnable() {
            //			@Override
            public void run() {
                // 创建图形
                ChartPanel chartPanel = new PeiTest().createChart();
                frame.getContentPane().add(chartPanel);
                frame.setVisible(true);
            }
        });

    }


}
