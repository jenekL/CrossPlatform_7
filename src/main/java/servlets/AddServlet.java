package servlets;

import data.Klients;
import data.Prodaja;
import data.TableData;
import data.Zakupka;
import mdatabase.MDataBase;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        List<Klients> klientData = MDataBase.getInstance().createClientsEntity();
        List<Zakupka> zakupkaData = MDataBase.getInstance().createZakupkaEntity();


        List<Integer> idsKlients = klientData.stream().map(Klients::getId).collect(Collectors.toList());
        List<Integer> idsZakupkas = zakupkaData.stream().map(Zakupka::getId).collect(Collectors.toList());


        List<String> firms = klientData.stream().map(Klients::getFirm).collect(Collectors.toList());
        List<String> names = zakupkaData.stream().map(Zakupka::getName).collect(Collectors.toList());


        req.setAttribute("names", names);
        req.setAttribute("firms", firms);
        req.setAttribute("idsKlients", idsKlients);
        req.setAttribute("idsZakupkas", idsZakupkas);
        req.getServletContext().getRequestDispatcher("/addpage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);

        String[] data = new String[4];
        data[0] = req.getParameter("date");
        data[1] = req.getParameter("quantity");
        data[3] = req.getParameter("addClient");
        data[2] = req.getParameter("addZakupka");

        try {
            MDataBase.getInstance().addRow("тпродажа", data);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        doGet(req, resp);
    }
}
