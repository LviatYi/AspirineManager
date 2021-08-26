package com.lviat.servlet;

import com.lviat.model.Medicine;
import com.lviat.model.PageModel;
import com.lviat.model.User;
import com.lviat.service.*;
import com.lviat.util.authentic.TokenUtil;
import com.lviat.util.constant.text.RelationText;
import com.lviat.util.constant.text.UrlText;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import java.util.List;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
/**
 * @author Titc
 */
public class DataVisitServlet extends HttpServlet{
        @Override
        protected  void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
                doPost(req, resp);
        }

        @Override
        protected  void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
                req.setCharacterEncoding("utf-8");
                String path = req.getServletPath();
                switch (path){
                        case "selectByPage.medicine":
                                //分页查询
                                selectByPage(req,resp);
                                break;
                        default:
                                break;

                }
        }

        private void selectByPage(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{

                PageModel pageModel =new PageModel();
                int pageNo = Integer.parseInt(req.getParameter("pageNo"));
                String likeValue = req.getParameter("likeValue");
                pageModel.setPageNo(pageNo);
                pageModel.setLikeValue(likeValue);

                /*
                分页有问题，先吃饭去了233
                 */
               // List<Medicine> medicines =selectByPage(pageModel);
//                pageModel.setRecordList(medicines);
//                req.setAttribute("pageModel",pageModel);
//                req.getRequestDispatcher("/Drug/Drug_selectByPage.jsp").forward(req,resp);
//                resp.sendRedirect(req.getContextPath()+"selectByPage.medicine");
//
             }
}


