package servlets;

import data.Prodaja;
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

@WebServlet("/table")
public class MainServlet extends HttpServlet {
    ArrayList<Prodaja> tableData;
    List<Integer> ids;


    @Override
    public void init() throws ServletException {
        super.init();


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if(tableData!=null && ids != null){
            tableData.clear();
            ids.clear();
        }
        tableData = MDataBase.getInstance().createEntity();
        ids = tableData.stream().map(Prodaja::getId).collect(Collectors.toList());

        req.setAttribute("ids", ids);
        req.setAttribute("tableData", tableData);

        req.getServletContext().getRequestDispatcher("/mypage.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        int select = Integer.parseInt(req.getParameter("deletable"));
////        try {
////            MDataBase.getInstance().deleteRow("тпродажа", select);
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////        tableData.clear();
////        ids.clear();
        doGet(req, resp);
    }
}