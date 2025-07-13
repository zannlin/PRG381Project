package controller;

import dao.FeedbackDAO;
import model.Feedback;

import java.util.List;

public class FeedbackController {

    // Create a Feedback (Add)
    public static void submitFeedback(String student, int rating, String comments) {
        Feedback f = new Feedback(0, student, rating, comments);
        FeedbackDAO.addFeedback(f);
    }

    // Read all Feedback (Get all)
    public static List<Feedback> getAllFeedback() {
        return FeedbackDAO.getAllFeedback();
    }

    // Update Feedback
    public static void updateFeedback(int id, String student, int rating, String comments) {
        Feedback f = new Feedback(id, student, rating, comments);
        FeedbackDAO.updateFeedback(f);
    }

    // Delete Feedback
    public static void deleteFeedback(int id) {
        FeedbackDAO.deleteFeedback(id);
    }
}
