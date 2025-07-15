package controller;

import dao.AppointmentDAO;
import dao.CounselorDAO;
import model.Appointment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class AppointmentController {

    // Create a appointment (Add)
    public static void bookAppointment(String student, String counselor, LocalDate date, LocalTime time, String status) {
        Appointment a = new Appointment(0, student, counselor, date, time, status);
        AppointmentDAO.addAppointment(a);
    }

    // Read all appointments (Get all)
    public static List<Appointment> getAllAppointments() {
        return AppointmentDAO.getAllAppointments();
    }

    // Update appointment
    public static void updateAppointment(int id, String student, String counselor, LocalDate date, LocalTime time, String status) {
        Appointment a = new Appointment(id, student, counselor, date, time, status);
        AppointmentDAO.updateAppointment(a);
    }

    // Delete appointment (Cancel)
    public static void cancelAppointment(int id) {
        AppointmentDAO.deleteAppointment(id);
    }
    //Get all counselor names
    public java.util.List<String> getAllCounselorNames() {
        return CounselorDAO.getAllCounselorNames();
    }
}
