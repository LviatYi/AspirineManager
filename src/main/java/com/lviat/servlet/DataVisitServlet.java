package com.lviat.servlet;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.IPage;
import com.lviat.model.Medicine;
import com.alibaba.fastjson.JSON;
import com.lviat.model.*;
import com.lviat.service.*;
import com.lviat.util.authentic.TokenUtil;
import com.lviat.util.constant.text.MethodText;
import com.lviat.util.constant.text.RelationText;
import com.lviat.util.constant.text.UrlText;


import com.sun.deploy.net.HttpResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;

/**
 * @author Titc
 */
public class DataVisitServlet extends HttpServlet {
    private UserService userService;
    private MedicineService medicineService;
    private MedicineTypeService medicineTypeService;
    private SalesInfoService salesInfoService;
    private ConsumerService consumerService;

    public DataVisitServlet() {
        this.userService = new UserServiceImpl();
        this.medicineService = new MedicineServiceImpl();
        this.medicineTypeService = new MedicineTypeServiceImpl();
        this.salesInfoService = new SalesInfoServiceImpl();
        this.consumerService = new ConsumerServiceImpl();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        switch (req.getParameter(MethodText.METHOD)) {
            case MethodText.USER_GET:
                this.getUser(req, resp);
                break;
            case MethodText.USER_GET_LIST:
                this.getUserList(req,resp);
                break;
            case MethodText.MEDICINE_GET:
                this.getMedicine(req, resp);
                break;
            case MethodText.MEDICINE_GET_LIST:
                this.getMedicineList(req,resp);
                break;
            case MethodText.MEDICINE_TYPE_GET_LIST:
                this.getMedicineTypeList(req, resp);
                break;
            case MethodText.CONSUMER_GET:
                this.getConsumer(req, resp);
                break;
            case MethodText.CONSUMER_GET_LIST:
                this.getConsumerList(req,resp);
                break;
            case MethodText.SALES_INFO_GET:
                this.getSalesInfo(req, resp);
            case MethodText.SALES_INFO_GET_LIST:
                this.getSalesInfoList(req,resp);
                break;
            default:
                break;

        }
    }

    private void getUser(HttpServletRequest req, HttpServletResponse resp) {
        long userId = Long.parseLong(req.getParameter(RelationText.WEB_USER_ID));
        User user = new User();
        userService.getUser(user, userId);
        req.setAttribute(RelationText.WEB_USER, user);
    }

    private void getUserList(HttpServletRequest req, HttpServletResponse resp) {
        int page = Integer.parseInt(req.getParameter("page"));
        List<User> users = new ArrayList<>();
        userService.getUser(users, page);
        req.setAttribute(RelationText.WEB_USER_LIST, users);
    }

    private void getMedicine(HttpServletRequest req, HttpServletResponse resp) {
        long medicineId = Long.parseLong(req.getParameter(RelationText.WEB_MEDICINE_ID));
        Medicine medicine = new Medicine();
        medicineService.getMedicine(medicine,medicineId);
    }
    private void  getMedicineList(HttpServletRequest req,HttpServletResponse resp)
    {
        int page = Integer.parseInt(req.getParameter("page"));
        List <Medicine> medicines = new ArrayList<>();
        medicineService.getMedicine(medicines,page);
        req.setAttribute(RelationText.WEB_MEDICINE_LIST,medicines);

    }
    private void getMedicineTypeList(HttpServletRequest req, HttpServletResponse resp) {


        int page = Integer.parseInt(req.getParameter("page"));
        List <MedicineType> medicinesTypes = new ArrayList<>();
        medicineTypeService.queryMedicineType(medicinesTypes,page);
        req.setAttribute(RelationText.WEB_MEDICINE_TYPE_LIST,medicinesTypes);
    }

    private void getConsumer(HttpServletRequest req, HttpServletResponse resp) {
        long consumerId = Long.parseLong(req.getParameter(RelationText.WEB_CONSUMER_ID));
        Consumer consumer = new Consumer();
        consumerService.getConsumer(consumer,consumerId);
    }
    private void getConsumerList(HttpServletRequest req,HttpServletResponse resp)
    {
        int page = Integer.parseInt(req.getParameter("page"));
        List <Consumer> consumers = new ArrayList<>();
        consumerService.getConsumer(consumers,page);
    }

    private void getSalesInfo(HttpServletRequest req, HttpServletResponse resp) {
      long salesInfoId = Long.parseLong(req.getParameter(RelationText.WEB_SALES_INFO_ID));
      SalesInfo salesInfo = new SalesInfo();
      salesInfoService.getSalesInfo(salesInfo,salesInfoId);
    }
    private void getSalesInfoList (HttpServletRequest req,HttpServletResponse resp)
    {
        int page = Integer.parseInt(req.getParameter("page"));
         List <SalesInfo> salesInfos = new ArrayList<>();
         salesInfoService.getSalesInfo(salesInfos,page);
    }
}


