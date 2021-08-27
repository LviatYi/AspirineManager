package com.lviat.servlet;

import com.alibaba.fastjson.JSON;
import com.lviat.model.SalesInfo;
import com.lviat.service.ConsumerService;
import com.lviat.service.ConsumerServiceImpl;
import com.lviat.service.SalesInfoService;
import com.lviat.service.SalesInfoServiceImpl;
import com.lviat.util.constant.text.MethodText;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Rooter
 * @version 1.0
 * @className SalesManagerServlet
 * @date 2021/8/26
 */
public class SalesManagerServlet extends HttpServlet {
    private ConsumerService consumerService;
    private SalesInfoService salesInfoService;

    public SalesManagerServlet() {
        this.consumerService = new ConsumerServiceImpl();
        this.salesInfoService = new SalesInfoServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getParameter(MethodText.METHOD)) {
            case MethodText.SALES_INFO_ADD:
                this.addSalesInfo(req,resp);
                break;
            case MethodText.SALES_INFO_DEL:
                this.delSalesInfo(req, resp);
                break;
            case MethodText.SALES_INFO_MODIFY:
                this.modifySalesInfo(req,resp);
                break;
            default:
                break;
        }
    }
    private void addSalesInfo(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        SalesInfo salesInfo = JSON.parseObject(req.getParameter("salesInfo"), SalesInfo.class);
        salesInfoService.addSalesInfo(salesInfo);
    }

    private void delSalesInfo(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        SalesInfo salesInfo = JSON.parseObject(req.getParameter("salesInfo"), SalesInfo.class);
        salesInfoService.delSalesInfo(salesInfo.getId());
    }

    private void modifySalesInfo(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        SalesInfo salesInfo = JSON.parseObject(req.getParameter("salesInfo"), SalesInfo.class);
        salesInfoService.modifySalesInfo(salesInfo);
    }
}
