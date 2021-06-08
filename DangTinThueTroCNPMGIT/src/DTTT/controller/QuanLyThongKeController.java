package DTTT.controller;

import DTTT.bean.LoaiPhongBean;
import DTTT.bean.TinBean;
import DTTT.service.ThongKeService;
import DTTT.service.ThongKeServiceImpl;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class QuanLyThongKeController {

    private ThongKeService thongKeService = null;

    public QuanLyThongKeController() {
        this.thongKeService = new ThongKeServiceImpl();
    }

    public void setDataToChart1(JPanel jpnItem) {
        List<TinBean> listItem = thongKeService.getListByTin();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (listItem != null) {
            for (TinBean item : listItem) {
                dataset.addValue(item.getSoLuongTin(), "Tin Đăng", item.getNgayDangTin());
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ thống kê số lượng tin cho thuê được đăng".toUpperCase(),
                "Thời gian", "Số lượng",
                dataset, PlotOrientation.VERTICAL, false, true, false);
        
        
        
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));
        
        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }
    
    public void setDataToChart2(JPanel jpnItem) {
        List<LoaiPhongBean> listItem = thongKeService.getListByLoaiPhong();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (listItem != null) {
            for (LoaiPhongBean item : listItem) {
                dataset.addValue(item.getSoLuongPhong(), "Loại Phòng", item.getTenLoaiPhong());
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ thống kê số lượng loại phòng được đăng".toUpperCase(),
                "Loại phòng", "Số lượng",
                dataset, PlotOrientation.VERTICAL, false, true, false);
        
        
        
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));
        
        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }

   
}