package com.lviat.servlet;

import com.alibaba.fastjson.JSON;
import com.lviat.model.Consumer;
import com.lviat.model.SalesInfo;
import com.lviat.service.ConsumerService;
import com.lviat.service.ConsumerServiceImpl;
import com.lviat.service.SalesInfoService;
import com.lviat.service.SalesInfoServiceImpl;
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
        Consumer newConsumer = JSON.parseObject(req.getParameter("consumer"), Consumer.class);
        SalesInfo salesInfo  = JSON.parseObject(req.getParameter("salesInfo"),SalesInfo.class);
        switch (req.getParameter("method")) {
            case "consumer-add":
                consumerService.addConsumer(newConsumer);
                break;
            case "consumer-del":
                consumerService.delConsumer(newConsumer.getId());
                break;
            case "consumer-modify":
                consumerService.modifyConsumer(newConsumer);
                break;

            case "salesInfo-add":
                salesInfoService.addSalesInfo(salesInfo);
                break;
            case "salesInfo-del":
                salesInfoService.delSalesInfo(salesInfo.getId());
                break;
            case "salesInfo-modify":
                salesInfoService.modifySalesInfo(salesInfo);
                break;
            default:
                break;
        }
    }
}
