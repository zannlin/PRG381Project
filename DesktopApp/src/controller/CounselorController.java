package controller;

import dao.CounselorDAO;
import model.Counselor;

import java.util.List;

public class CounselorController {

    // Create a counselor (Add)
    public static void addCounselor(String name, String specialization, String availability) {
        Counselor c = new Counselor(0, name, specialization, availability);
        CounselorDAO.addCounselor(c);
    }

    // Read all counselors (Get all)
    public static List<Counselor> getAllCounselors() {
        return CounselorDAO.getAllCounselors();
    }

    // Update counselor
    public static void updateCounselor(int id, String name, String specialization, String availability) {
        Counselor c = new Counselor(id, name, specialization, availability);
        CounselorDAO.updateCounselor(c);
    }

    // Delete counselor
    public static void deleteCounselor(int id) {
        CounselorDAO.deleteCounselor(id);
    }
}
