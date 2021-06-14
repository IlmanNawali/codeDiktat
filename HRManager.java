/**
 * 1972003 Ilman Nawali
 */

public class HRManager extends Employee {

    public void addEmployee(University university, Employee employee) {
        university.getEmployee().add(employee);
    }

    public void viewAllEmployee(University university) {
        System.out.printf("%-7s%-7s", "NIK", "NAMA");
        System.out.println();
        if (university.getEmployee().isEmpty()) {
            System.out.println("No data");
        } else {
            university.getEmployee().forEach(Employee -> {
                if (Employee instanceof Lecturer) {
                    System.out.println(((Lecturer) Employee).toString());
                } else {
                    System.out.println(((Employee) Employee).toString());
                }
            });
        }
    }

    public void viewAllLecturer(University university) {
        university.getEmployee().forEach(Employee -> {
            if (Employee instanceof Lecturer) {
                if (university.getEmployee().isEmpty() == true) {
                    System.out.println("No Data");
                } else {
                    System.out.println(((Lecturer) Employee).toString());
                }
            }
        });
    }
}



