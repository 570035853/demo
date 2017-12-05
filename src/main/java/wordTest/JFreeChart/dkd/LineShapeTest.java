package wordTest.JFreeChart.dkd;

import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;

import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


import java.awt.*;

/**
 * Created by zoujialei on 17/11/29.
 */
public class LineShapeTest{

    public LineShapeTest()
    {

    }

    public static void main(String[] args) {
        StandardChartTheme mChartTheme = new StandardChartTheme("CN");
        mChartTheme.setLargeFont(new Font("黑体", Font.BOLD, 20));
        mChartTheme.setExtraLargeFont(new Font("宋体", Font.PLAIN, 15));
        mChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 15));
        ChartFactory.setChartTheme(mChartTheme);
        CategoryDataset mDataset = GetDataset();
        JFreeChart mChart = ChartFactory.createLineChart(
                "",//图名字
                "",//横坐标
                "",//纵坐标
                mDataset,//数据集
                PlotOrientation.VERTICAL,
                false, // 显示图例（设置为不显示）
                true, // 采用标准生成器
                false);// 是否生成超链接

        CategoryPlot mPlot = (CategoryPlot)mChart.getPlot();
        mPlot.setBackgroundPaint(Color.WHITE);
        mPlot.setRangeGridlinePaint(Color.LIGHT_GRAY);//背景底部横虚线
        mPlot.setOutlinePaint(Color.BLACK);//

        //设置Y轴值显示整数
        NumberAxis numberAxis = (NumberAxis)mPlot.getRangeAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        //控制线条颜色、粗细等
        LineAndShapeRenderer renderer = (LineAndShapeRenderer)mPlot.getRenderer();
        renderer.setBaseShapesVisible(true); // series 点（即数据点）可见
        renderer.setSeriesStroke(0, new BasicStroke(4.0f));
        renderer.setSeriesPaint(0, Color.BLUE);
//        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setSeriesItemLabelsVisible(0, true);


        //坐标轴倾斜45度和字体设置
        // 取得横轴
        CategoryAxis categoryAxis = mPlot.getDomainAxis();
//        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        categoryAxis.setTickLabelFont(new Font("黑体", Font.BOLD, 18));

        ChartFrame mChartFrame = new ChartFrame("折线图", mChart);
        mChartFrame.pack();
        mChartFrame.setVisible(true);

    }
    public static CategoryDataset GetDataset()
    {
        DefaultCategoryDataset mDataset = new DefaultCategoryDataset();
        mDataset.addValue(2, "", "第一周");
        mDataset.addValue(1.1, "", "第二周");
        mDataset.addValue(2, "", "第三周");
        mDataset.addValue(3.5, "", "第四周");

        return mDataset;
    }


}


/**
 * 相关属性参照
 * public JFreeChart drawLineChart2D(DefaultCategoryDataset dataset,
 String title, String scope) {
 JFreeChart chart = ChartFactory.createLineChart(title, null, "数量",
 dataset, PlotOrientation.VERTICAL, // 图表方向垂直
 true, true, true);
 chart.addSubtitle(new TextTitle(scope));
 LegendTitle legend = chart.getLegend(); // 设置图例的字体
 legend.setItemFont(new Font("宋体", Font.BOLD, 16));
 // 获取折线图plot对象
 CategoryPlot plot = (CategoryPlot) chart.getPlot();
 // 设置背景颜色
 plot.setBackgroundPaint(Color.WHITE);
 // 设置网格竖线颜色
 plot.setDomainGridlinePaint(Color.pink);
 // 设置网格横线颜色
 plot.setRangeGridlinePaint(Color.pink);
 plot.setNoDataMessage("暂无数据显示！");// 没有数据显示的时候显示这个提示
 // 取得横轴
 CategoryAxis categoryAxis = plot.getDomainAxis();
 // 设置横轴的字体
 categoryAxis.setLabelFont(new Font("宋体", Font.BOLD, 16));
 // 设置分类标签以45度倾斜
 categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.STANDARD);//
 // 设置分类标签字体
 categoryAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 18));
 // 取得纵轴
 NumberAxis numberAxis = (NumberAxis) plot.getRangeAxis();
 numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
 // 设置纵轴的字体
 numberAxis.setLabelFont(new Font("黑体", Font.PLAIN, 18));
 numberAxis.setUpperMargin(0.15);//设置最高数据显示与顶端的距离
 numberAxis.setLowerMargin(2);//设置最低的一个值与图片底端的距离
 // 设置背景透明度（0~1）
 plot.setBackgroundAlpha(1f);
 // 设置前景色透明度（0~1）
 plot.setForegroundAlpha(1f);
 // 获取显示线条的对象
 LineAndShapeRenderer lasp = (LineAndShapeRenderer) plot.getRenderer();
 // 设置拐点是否可见/是否显示拐点
 lasp.setBaseShapesVisible(true);
 // 设置拐点不同用不同的形状
 lasp.setDrawOutlines(true);
 // 设置线条是否被显示填充颜色
 lasp.setUseFillPaint(true);
 // 设置拐点颜色
 lasp.setBaseFillPaint(Color.blue);//蓝色
 // 设置折线加粗
 //lasp.setSeriesStroke(0, new BasicStroke(3F));
 lasp.setSeriesOutlineStroke(0, new BasicStroke(4.5F));//设置折点的大小
 lasp.setSeriesOutlineStroke(1, new BasicStroke(4.5F));
 lasp.setSeriesOutlineStroke(2, new BasicStroke(4.5F));
 lasp.setSeriesOutlineStroke(3, new BasicStroke(4.5F));
 lasp.setSeriesOutlineStroke(4, new BasicStroke(4.5F));
 lasp.setSeriesOutlineStroke(5, new BasicStroke(4.5F));
 lasp.setSeriesOutlineStroke(6, new BasicStroke(4.5F));
 lasp.setSeriesOutlineStroke(7, new BasicStroke(4.5F));
 lasp.setSeriesOutlineStroke(8, new BasicStroke(4.5F));
 lasp.setSeriesOutlineStroke(9, new BasicStroke(4.5F));
 lasp.setSeriesOutlineStroke(10, new BasicStroke(4.5F));
 // 设置折线拐点

 // lasp.setSeriesShape(0, new java.awt.geom.Ellipse2D.Double(-5D, -5D,
 // 10D, 10D));
 // lasp.setSeriesShape(1, new java.awt.geom.Ellipse2D.Double(-1D, -2D,
 // 10D, 10D));
 // lasp.setSeriesShape(2, new java.awt.geom.Ellipse2D.Double(-5D, -5D,
 // 10D, 10D));
 // lasp.setSeriesShape(3, new java.awt.geom.Ellipse2D.Double(-5D, -5D,
 // 10D, 10D));
 // lasp.setSeriesShape(4, new java.awt.geom.Ellipse2D.Double(-5D, -5D,
 // 10D, 10D));
 // lasp.setSeriesShape(5, new java.awt.geom.Ellipse2D.Double(-5D, -5D,
 // 10D, 10D));
 // lasp.setSeriesShape(6, new java.awt.geom.Ellipse2D.Double(-5D, -5D,
 // 10D, 10D));
 // lasp.setSeriesShape(7, new java.awt.geom.Ellipse2D.Double(-5D, -5D,
 // 10D, 10D));
 // lasp.setSeriesShape(8, new java.awt.geom.Ellipse2D.Double(-5D, -5D,
 // 10D, 10D));
 // lasp.setSeriesShape(9, new java.awt.geom.Ellipse2D.Double(-5D, -5D,
 // 10D, 10D));
 // lasp.setSeriesShape(10, new java.awt.geom.Ellipse2D.Double(-5D, -5D,
 // 10D, 10D));
 plot.setNoDataMessage("没有相关统计数据");
 LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot
 .getRenderer();// 设置样式


 // 设置每个地区所包含的平行柱的之间距离
 renderer
 .setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
 renderer.setItemLabelsVisible(true);// 显示每个点上的数据值的提示工具,数据标签是否可见
 renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
 ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
 renderer.setItemLabelFont(new Font("黑体", Font.PLAIN, 14));// 设置数字的字体大小
 renderer.setItemLabelAnchorOffset(2D);
 // // 设置颜色-----------------------------------------------------------
 renderer.setSeriesStroke(0, new BasicStroke(4.0F));//设置折线大小
 // renderer.setSeriesPaint(0, Color.RED);//红色
 renderer.setSeriesStroke(1, new BasicStroke(4.0F));
 // renderer.setSeriesPaint(1, Color.GREEN);//绿色
 renderer.setSeriesStroke(2, new BasicStroke(4.0F));
 // renderer.setSeriesPaint(2, Color.ORANGE);//c橙色
 renderer.setSeriesStroke(3, new BasicStroke(4.0F));
 // renderer.setSeriesPaint(3, Color.BLUE);//蓝色
 renderer.setSeriesStroke(4, new BasicStroke(4.0F));
 // renderer.setSeriesPaint(4, Color.BLACK);//黑色
 renderer.setSeriesStroke(5, new BasicStroke(4.0F));
 // renderer.setSeriesPaint(5, Color.CYAN);
 renderer.setSeriesStroke(6, new BasicStroke(4.0F));
 renderer.setSeriesStroke(7, new BasicStroke(4.0F));
 renderer.setSeriesStroke(8, new BasicStroke(4.0F));
 renderer.setSeriesStroke(9, new BasicStroke(4.0F));
 renderer.setSeriesStroke(10, new BasicStroke(4.0F));
 plot.setRenderer(renderer);// 使用我们设计的效果F
 return chart;
 }
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */



