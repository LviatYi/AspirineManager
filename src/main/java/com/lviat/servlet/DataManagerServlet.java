package com.lviat.servlet;

import com.alibaba.fastjson.JSON;
import com.lviat.model.*;
import com.lviat.service.*;
import com.lviat.util.authentic.TokenUtil;
import com.lviat.util.constant.text.RelationText;
import com.lviat.util.constant.text.UrlText;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
    private SalesInfoService salesInfoService;
    private MedicineTypeService medicineTypeService;
    private ConsumerService consumerService;

    public DataManagerServlet() {
        this.userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User newUser = JSON.parseObject(req.getParameter("user"), User.class);
        Medicine newMedicine  = JSON.parseObject(req.getParameter("medicine"),Medicine.class);
        MedicineType newMedicineType = JSON.parseObject(req.getParameter("medicineType"),MedicineType.class);
        switch (req.getParameter("method")) {
            case "user-add":
                userService.addUser(newUser);
                break;
            case "user-del":
                userService.delUser(newUser.getId());
                break;
            case "user-modify":
                userService.modifyUser(newUser);
                break;

            case "medicine-add":
                medicineService.addMedicine(newMedicine);
                break;
            case "medicine-del":
                medicineService.delMedicine(newMedicine.getId());
                break;
            case "medicine-modify":
                medicineService.modifyMedicine(newMedicine);
                break;

            case "medicineType-add":
                medicineTypeService.addMedicineType(newMedicineType);
                break;
            case "medicineType-del":
                medicineTypeService.delMedicineType(newMedicineType.getTypeId());
                break;
            case "medicineType-modify":
                medicineTypeService.modifyMedicineType(newMedicineType);
                break;
            default:
                break;
        }
    }
}
