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
        User newUser = JSON.parseObject(req.getParameter("user"), User.class);
        Medicine newMedicine = JSON.parseObject(req.getParameter("medicine"), Medicine.class);
        MedicineType newMedicineType = JSON.parseObject(req.getParameter("medicineType"), MedicineType.class);
        switch (req.getParameter("method")) {
            case MethodText
                    .USER_ADD:
                userService.addUser(newUser);
                break;
            case MethodText.USER_DEL:
                userService.delUser(newUser.getId());
                break;
            case MethodText.USER_MODIFY:
                userService.modifyUser(newUser);
                break;
            case MethodText.MEDICINE_ADD:
                medicineService.addMedicine(newMedicine);
                break;
            case MethodText.MEDICINE_DEL:
                medicineService.delMedicine(newMedicine.getId());
                break;
            case MethodText.MEDICINE_MODIFY:
                medicineService.modifyMedicine(newMedicine);
                break;
            case MethodText.MEDICINE_TYPE_ADD:
                medicineTypeService.addMedicineType(newMedicineType);
                break;
            case MethodText.MEDICINE_TYPE_DEL:
                medicineTypeService.delMedicineType(newMedicineType.getTypeId());
                break;
            case MethodText.MEDICINE_TYPE_MODIFY:
                medicineTypeService.modifyMedicineType(newMedicineType);
                break;
            default:
                break;
        }
    }
}
