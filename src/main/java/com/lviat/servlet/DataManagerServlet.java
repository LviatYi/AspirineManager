package com.lviat.servlet;

import com.alibaba.fastjson.JSON;
import com.lviat.model.*;
import com.lviat.service.*;
import com.lviat.util.constant.text.MethodText;
import com.lviat.util.constant.text.RelationText;
import com.lviat.util.constant.text.UrlText;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 数据管理后台.
 * 管理员权限.
 *
 * @author LviatYi
 * @version 1.0
 * @className DateManagerServlet
 * @date 2021/8/26
 */
@WebServlet(name = "SalesManagerServlet", urlPatterns = UrlText.DATA_MANAGER + ".do")
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
        User newUser = JSON.parseObject(req.getParameter(RelationText.WEB_USER), User.class);
        userService.addUser(newUser);
    }

    private void delUser(HttpServletRequest req, HttpServletResponse resp) {
        long userId = Long.parseLong(req.getParameter(RelationText.WEB_USER_ID));
        userService.delUser(userId);
    }

    private void modifyUser(HttpServletRequest req, HttpServletResponse resp) {
        User user = JSON.parseObject(req.getParameter(RelationText.WEB_USER), User.class);
        userService.modifyUser(user);
    }

    private void addMedicine(HttpServletRequest req, HttpServletResponse resp) {
        Medicine newMedicine = JSON.parseObject(req.getParameter(RelationText.WEB_MEDICINE), Medicine.class);
        medicineService.addMedicine(newMedicine);
    }

    private void delMedicine(HttpServletRequest req, HttpServletResponse resp) {
        long medicineId = Long.parseLong(req.getParameter(RelationText.WEB_MEDICINE_ID));

        medicineService.delMedicine(medicineId);
    }

    private void modifyMedicine(HttpServletRequest req, HttpServletResponse resp) {
        Medicine medicine = JSON.parseObject(req.getParameter(RelationText.WEB_MEDICINE), Medicine.class);
        medicineService.modifyMedicine(medicine);
    }

    private void addMedicineType(HttpServletRequest req, HttpServletResponse resp) {
        MedicineType newMedicineType = JSON.parseObject(req.getParameter(RelationText.WEB_MEDICINE_TYPE), MedicineType.class);
        medicineTypeService.addMedicineType(newMedicineType);
    }

    private void delMedicineType(HttpServletRequest req, HttpServletResponse resp) {
        long newMedicineTypeId = Long.parseLong(req.getParameter(RelationText.WEB_MEDICINE_TYPE_ID));
        medicineTypeService.delMedicineType(newMedicineTypeId);
    }

    private void modifyMedicineType(HttpServletRequest req, HttpServletResponse resp) {
        MedicineType medicineType = JSON.parseObject(req.getParameter(RelationText.WEB_MEDICINE_TYPE), MedicineType.class);
        medicineTypeService.modifyMedicineType(medicineType);
    }

}
