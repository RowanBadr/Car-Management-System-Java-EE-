package com.example.carmangamentsystem;

import com.example.carmangamentsystem.Car;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class CarServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    private Map<String, Car> carDatabase = new HashMap<>(); // Simulated DB

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");

        if (id == null || id.isEmpty()) {
            out.print("{\"message\":\"Please provide a car ID\"}");
            return;
        }

        Car car = carDatabase.get(id);

        if (car == null) {
            out.print("{\"message\":\"Car not found\"}");
        } else {
            String json = objectMapper.writeValueAsString(car);
            out.print(json);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

// Convert JSON → Car object
        Car car = objectMapper.readValue(request.getInputStream(), Car.class);

        carDatabase.put(car.getId(), car);

        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", "Car added successfully");
        responseBody.put("car", car);

        out.print(objectMapper.writeValueAsString(responseBody));
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");

        if (id == null || id.isEmpty()) {
            out.print("{\"message\":\"Please provide a car ID\"}");
            return;
        }

        Car removed = carDatabase.remove(id);

        if (removed == null) {
            out.print("{\"message\":\"Car not found\"}");
        } else {
            out.print("{\"message\":\"Car deleted successfully\"}");
        }
    }
}