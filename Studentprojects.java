import java.util.List;

public class StudentProjects {
    static class Project {
        String studentName;
        int dueDate;
        int completionDate;

        Project(String name, int due, int complete) {
            studentName = name;
            dueDate = due;
            completionDate = complete;
        }

        boolean isOnTime() {
            return completionDate == dueDate;
        }

        boolean isEarly() {
            return completionDate < dueDate;
        }

        boolean isLate() {
            return completionDate > dueDate;
        }

        int completionTime() {
            return Math.abs(completionDate - dueDate);
        }
    }

    public static void analyzeProjects(List<Project> projects) {
        int onTime = 0, early = 0, late = 0, totalTime = 0;
        for (Project p : projects) {
            if (p.isOnTime()) onTime++;
            if (p.isEarly()) early++;
            if (p.isLate()) late++;
            totalTime += p.completionTime();
        }
        double averageTime = projects.isEmpty() ? 0 : (double) totalTime / projects.size();
        System.out.println("On Time: " + onTime + ", Early: " + early + ", Late: " + late);
        System.out.println("Average Completion Time: " + averageTime);
    }
}
