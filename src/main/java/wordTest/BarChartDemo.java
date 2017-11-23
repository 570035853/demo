package wordTest;

import java.awt.Font;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import sun.misc.BASE64Encoder;

public class BarChartDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {

        JFreeChart chart = ChartFactory.createBarChart("统计", "", "种类",
                getDataSet());

        // 从这里开始
        CategoryPlot plot = chart.getCategoryPlot();// 获取图表区域对象
        CategoryAxis domainAxis = plot.getDomainAxis(); // 水平底部列表
        domainAxis.setLabelFont(new Font("黑体", Font.BOLD, 14)); // 水平底部标题
        domainAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 12)); // 垂直标题
        ValueAxis rangeAxis = plot.getRangeAxis();// 获取柱状
        rangeAxis.setLabelFont(new Font("黑体", Font.BOLD, 15));
        chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
        chart.getTitle().setFont(new Font("宋体", Font.BOLD, 20));// 设置标题字体

        System.out.println("image:" + getBase64StrFromChart(chart));

        ChartPanel chartPanel = new ChartPanel(chart, true); // 这里也可以用chartFrame,可以直接生成一个独立的Frame
        JFrame frame=new JFrame("Java数据统计图");
        frame.add(chartPanel);           //添加柱形图
        frame.setBounds(50, 50, 900, 600);
        frame.setVisible(true);
        frame.show();

    }

    private static CategoryDataset getDataSet() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(7114, "月度融资额", "1月");
        dataset.addValue(3737, "月度还款额", "1月");
        dataset.addValue(7257, "月度融资额", "2月");
        dataset.addValue(1855, "月度还款额", "2月");
        dataset.addValue(3381, "月度融资额", "3月");
        dataset.addValue(5225, "月度还款额", "3月");
        dataset.addValue(8726, "月度融资额", "4月");
        dataset.addValue(6532, "月度还款额", "4月");
        dataset.addValue(7039, "月度融资额", "5月");
        dataset.addValue(7451, "月度还款额", "5月");
        return dataset;
    }

    public static String getBase64StrFromChart(JFreeChart chart){
        BASE64Encoder base64Encoder = new BASE64Encoder();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ChartUtilities.writeChartAsJPEG(byteArrayOutputStream, 1.0f, chart, 400, 300, null);
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
        }catch (IOException e){

        }

        byte[] byteArray = byteArrayOutputStream.toByteArray();
//        try {
//            InputStream inputStream = new ByteArrayInputStream(byteArray);
//            byteArray = new byte[inputStream.available()];
//            inputStream.read(byteArray);
//            inputStream.close();
//        }catch (Exception e){
//
//        }
        return base64Encoder.encode(byteArray);


    }


}