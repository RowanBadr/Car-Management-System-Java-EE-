package com.example.carmangamentsystem;

import com.example.carmangamentsystem.Car;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@WebServlet("/car2")
public class CarServlet2 extends HttpServlet {
    // Simulated database using HashMap
    private static Map<String, Car> carDatabase = new HashMap<>();
    // Handles GET requests: displays the form
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward the request to carForm.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("carForm.jsp");
        dispatcher.forward(request, response);
    }
    // Handles POST requests: processes the form submission
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form parameters
        String id = request.getParameter("id");
        String model = request.getParameter("model");
        String make = request.getParameter("make");
        String yearStr = request.getParameter("year");
        int year = Integer.parseInt(yearStr);
        // Create a new Car object
        Car car = new Car(id, model, make, year);
        // Store the car in our database
        carDatabase.put(id, car);
        // Prepare success message
        String message = "Car with ID " + id + " added successfully!";
        request.setAttribute("message", message);
        // Forward to success page
        RequestDispatcher dispatcher = request.getRequestDispatcher("carSuccess.jsp");
        dispatcher.forward(request, response);
    }
}
