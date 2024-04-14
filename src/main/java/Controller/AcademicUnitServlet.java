package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.AcademicUnitDao;
import domain.AcademicUnit;
import domain.AcademicUnit.UnityType;

@WebServlet("/AcademicUnit")
public class AcademicUnitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list"; 
        }

        switch (action) {
            case "list":
                listAcademicUnits(request, response);
                break;
            case "delete":
                deleteAcademicUnit(request, response);
                break;
            default:
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            addAcademicUnit(request, response);
        }
    }

    private void listAcademicUnits(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AcademicUnitDao academicDao = new AcademicUnitDao();
        List<AcademicUnit> academicUnits = academicDao.selectAllAcademicUnit();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        if (academicUnits != null) {
            out.print("[");
            for (int i = 0; i < academicUnits.size(); i++) {
                AcademicUnit academicUnit = academicUnits.get(i);
                out.print("{");
                out.print("\"id\": " + academicUnit.getId() + ",");
                out.print("\"code\": \"" + academicUnit.getCode() + "\",");
                out.print("\"name\": \"" + academicUnit.getName() + "\",");
                out.print("\"unityType\": \"" + academicUnit.getUnityType() + "\",");
                out.print("\"parentUnitId\": " + academicUnit.getParentUnit());
                out.print("}");
                if (i < academicUnits.size() - 1) {
                    out.print(",");
                }
            }
            out.print("]");
        } else {
           
            out.print("[]");
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        out.flush();
    }


    private void deleteAcademicUnit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        AcademicUnitDao academicDao = new AcademicUnitDao();
        academicDao.deleteAcademicUnit(id);
        response.setStatus(HttpServletResponse.SC_OK);
    }
    

    private void addAcademicUnit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String code = request.getParameter("code");
            String name = request.getParameter("name");
            String unityTypeString = request.getParameter("unityType");
            int parentUnitId = Integer.parseInt(request.getParameter("parentUnitId"));

            // Check if the provided unityTypeString is a valid UnityType
            UnityType unityType = null;
            try {
                unityType = UnityType.valueOf(unityTypeString);
            } catch (IllegalArgumentException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }

            AcademicUnit academicUnit = new AcademicUnit();
            academicUnit.setCode(code);
            academicUnit.setName(name);
            academicUnit.setUnityType(unityType);

            AcademicUnitDao academicUnitDao = new AcademicUnitDao();
            AcademicUnit parentUnit = academicUnitDao.selectAcademicUnit(parentUnitId);

            if (parentUnit != null) {
                academicUnit.setParentUnit(parentUnit);
                academicUnitDao.createAcademic(academicUnit);
                response.setStatus(HttpServletResponse.SC_CREATED);
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST); 
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); 
        }
    }
    }
