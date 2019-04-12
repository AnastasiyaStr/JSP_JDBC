package com.softserve.academy.servlets;

import com.softserve.academy.dao.impl.GuideDaoImpl;
import com.softserve.academy.entity.GuideEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        PrintWriter writer = resp.getWriter();
        //writer.println("Method GET from AddServlet");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("delete.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GuideDaoImpl model = new GuideDaoImpl();
        List<GuideEntity> guides = model.readAllGuides();
        req.setAttribute("userNames", guides);
        String idstr = req.getParameter("id");
        int id = Integer.parseInt(idstr);
        model.deleteGuide(id);

    }
}
