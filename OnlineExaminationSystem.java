import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Question {
    private String questionText;
    private String correctAnswer;
    private List<String> options;

    public Question(String questionText, String correctAnswer, List<String> options) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.options = options;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean checkAnswer(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }

    @Override
    public String toString() {
        return questionText + "\n" + String.join("\n", options);
    }
}

class Student {
    private String id;
    private String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class Exam {
    private List<Question> questions;

    public Exam() {
        questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestions() {
        return questions;
    }
}

class OnlineExaminationSystem {
    private Map<String, Student> students;
    private Exam exam;
    private Scanner scanner;

    public OnlineExaminationSystem() {
        students = new HashMap<>();
        exam = new Exam();
        scanner = new Scanner(System.in);
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public boolean authenticateStudent(String id) {
        return students.containsKey(id);
    }

    public void addQuestion(String questionText, String correctAnswer, List<String> options) {
        exam.addQuestion(new Question(questionText, correctAnswer, options));
    }

    public void takeExam() {
        System.out.println("Starting exam...\n");
        int score = 0;
        for (Question question : exam.getQuestions()) {
            System.out.println(question);
            System.out.print("Enter your answer: ");
            String answer = scanner.nextLine();
            if (question.checkAnswer(answer)) {
                score++;
                System.out.println("Correct!\n");
            } else {
                System.out.println("Incorrect. The correct answer was: " + question.getCorrectAnswer() + "\n");
            }
        }
        System.out.println("Exam finished. Your score is: " + score + "/" + exam.getQuestions().size());
    }
}

public class Main {
    private static OnlineExaminationSystem system = new OnlineExaminationSystem();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Add some questions
        system.addQuestion("What is the capital of France?", "Paris", List.of("Paris", "London", "Berlin", "Rome"));
        system.addQuestion("What is 2 + 2?", "4", List.of("3", "4", "5", "6"));

        // Add some students
        system.addStudent(new Student("1", "Alice"));
        system.addStudent(new Student("2", "Bob"));

        while (true) {
            System.out.println("Welcome to the Online Examination System");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    login();
                    break;
                case 2:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void login() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        if (system.authenticateStudent(id)) {
            System.out.println("Login successful. Welcome!");
            system.takeExam();
        } else {
            System.out.println("Invalid student ID. Please try again.");
        }
    }
}
