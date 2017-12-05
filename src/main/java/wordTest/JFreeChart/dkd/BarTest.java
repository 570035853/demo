package wordTest.JFreeChart.dkd;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import wordTest.JFreeChart.ChartUtils;
import wordTest.JFreeChart.Serie;

import java.awt.*;
import java.util.Vector;

/**
 * Created by zoujialei on 17/11/30.
 */
public class BarTest {

    public static void main(String[] args) {

        CategoryDataset mDataset = GetDataset();

        JFreeChart chart = ChartFactory.createBarChart("未来几个月待还金额（万元）", "", "", mDataset);


        CategoryPlot mPlot = (CategoryPlot)chart.getPlot();
        mPlot.setBackgroundPaint(Color.WHITE);
        mPlot.setRangeGridlinePaint(Color.LIGHT_GRAY);//背景底部横虚线
        mPlot.setOutlinePaint(Color.BLACK);//

        //设置Y轴值显示整数
        NumberAxis numberAxis = (NumberAxis)mPlot.getRangeAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        chart.getLegend().setVisible(false);
        //坐标轴倾斜45度和字体设置
        // 取得横轴
        CategoryAxis categoryAxis = mPlot.getDomainAxis();
//        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        categoryAxis.setTickLabelFont(new Font("黑体", Font.BOLD, 12));
        ChartUtils.setBarRenderer(mPlot, true);

        //设置柱状图颜色
        BarRenderer barRenderer = (BarRenderer)mPlot.getRenderer();
        barRenderer.setSeriesPaint(0, new Color(255,100,1));
        barRenderer.setDrawBarOutline(false);
        barRenderer.setBarPainter(new StandardBarPainter());// 设置柱状图渲染

        ChartFrame mChartFrame = new ChartFrame("柱状图", chart);
        mChartFrame.pack();
        mChartFrame.setVisible(true);

    }
    public static CategoryDataset GetDataset()
    {
        DefaultCategoryDataset mDataset = new DefaultCategoryDataset();
        mDataset.addValue(5530.0, "Test", "2017-11");
        mDataset.addValue(3635.0, "Test", "2017-12");
        mDataset.addValue(5755.0, "Test", "2018-01");
        mDataset.addValue(6757.0, "Test", "2018-02");
        mDataset.addValue(4085.0, "Test", "2018-03");
        return mDataset;
    }
}
