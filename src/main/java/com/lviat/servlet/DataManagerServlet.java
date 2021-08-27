package com.lviat.servlet;

import com.alibaba.fastjson.JSON;
import com.lviat.model.*;
import com.lviat.service.*;
import com.lviat.util.constant.text.MethodText;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 数据管理后台.
 * 管理员权限.
 *
 * @author LviatYi
 * @version 0.1
 * @className DateManagerServlet
 * @date 2021/8/26
 */
public class DataManagerServlet extends HttpServlet {
    private UserService userService;
    private MedicineService medicineService;
    private MedicineTypeService medicineTypeService;

    public DataManagerServlet() {
        this.userService = new UserServiceImpl();
        this.medicineService = new MedicineServiceImpl();
        this.medicineTypeService = new MedicineTypeServiceImpl();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getParameter(MethodText.METHOD)) {
            case MethodText.USER_ADD:
                this.addUser(req, resp);
                break;
            case MethodText.USER_DEL:
                this.delUser(req, resp);
                break;
            case MethodText.USER_MODIFY:
                this.modifyUser(req, resp);
                break;
            case MethodText.MEDICINE_ADD:
                this.addMedicine(req, resp);
                break;
            case MethodText.MEDICINE_DEL:
                this.delMedicine(req, resp);
                break;
            case MethodText.MEDICINE_MODIFY:
                this.modifyMedicine(req, resp);
                break;
            case MethodText.MEDICINE_TYPE_ADD:
                this.addMedicineType(req, resp);
                break;
            case MethodText.MEDICINE_TYPE_DEL:
                this.delMedicineType(req, resp);
                break;
            case MethodText.MEDICINE_TYPE_MODIFY:
                this.modifyMedicineType(req, resp);
                break;
            default:
                break;
        }
    }

    private void addUser(HttpServletRequest req, HttpServletResponse resp) {
        User newUser = JSON.parseObject(req.getParameter("user"), User.class);
        userService.addUser(newUser);
    }

    private void delUser(HttpServletRequest req, HttpServletResponse resp) {
        User newUser = JSON.parseObject(req.getParameter("user"), User.class);
        userService.delUser(newUser.getId());

    }

    private void modifyUser(HttpServletRequest req, HttpServletResponse resp) {
        User newUser = JSON.parseObject(req.getParameter("user"), User.class);
        userService.modifyUser(newUser);

    }

    private void addMedicine(HttpServletRequest req, HttpServletResponse resp) {
        Medicine newMedicine = JSON.parseObject(req.getParameter("medicine"), Medicine.class);

        medicineService.addMedicine(newMedicine);
    }

    private void delMedicine(HttpServletRequest req, HttpServletResponse resp) {
        Medicine newMedicine = JSON.parseObject(req.getParameter("medicine"), Medicine.class);

        medicineService.delMedicine(newMedicine.getId());
    }

    private void modifyMedicine(HttpServletRequest req, HttpServletResponse resp) {
        Medicine newMedicine = JSON.parseObject(req.getParameter("medicine"), Medicine.class);

        medicineService.modifyMedicine(newMedicine);
    }

    private void addMedicineType(HttpServletRequest req, HttpServletResponse resp) {
        MedicineType newMedicineType = JSON.parseObject(req.getParameter("medicineType"), MedicineType.class);

        medicineTypeService.addMedicineType(newMedicineType);
    }

    private void delMedicineType(HttpServletRequest req, HttpServletResponse resp) {

        MedicineType newMedicineType = JSON.parseObject(req.getParameter("medicineType"), MedicineType.class);
        medicineTypeService.delMedicineType(newMedicineType.getTypeId());
    }

    private void modifyMedicineType(HttpServletRequest req, HttpServletResponse resp) {
        MedicineType newMedicineType = JSON.parseObject(req.getParameter("medicineType"), MedicineType.class);
        medicineTypeService.modifyMedicineType(newMedicineType);

    }

}
