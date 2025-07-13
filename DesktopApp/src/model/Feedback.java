package model;

public class Feedback {
    private int id;
    private String student;
    private int rating; //Ratings are between 1 and 5
    private String comments;

    public Feedback(int Id, String Student, int Rating, String Comments) {
        this.id = Id;
        this.student = Student;
        this.rating = Rating;
        this.comments = Comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
