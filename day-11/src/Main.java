public class Main {
    public static void main(String[] args) {
        // Account Question
        System.out.println("========== ACCOUNT QUESTION ==========");
        System.out.println();

        System.out.println("===== Initializing Accounts =====");
        Account a1 = new Account("1", "Faisal", 100);
        Account a2 = new Account("2", "Khaled");
        // instantiate 3 more objects (per requirement 5, but I'll only use 2)
        Account a3 = new Account("3", "Abdullah");
        Account a4 = new Account("4", "Ramy", 4500);
        Account a5 = new Account("5", "Nasser", 990);
        System.out.println(a1.toString()); // Or I can just call print the obj without toString()
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);
        System.out.println(a5);

        System.out.println();

        System.out.println("===== Transferring 50SR from Faisal to Khaled =====");
        System.out.println(a1.getName() + "'s Balance before: " + a1.getBalance());
        System.out.println(a2.getName() + "'s Balance before: " + a2.getBalance());
        System.out.println(a1.transferTo(a2, 50));
        System.out.println(a1.getName() + "'s Balance after: " + a1.getBalance());
        System.out.println(a2.getName() + "'s Balance after: " + a2.getBalance());

        System.out.println();

        System.out.println("===== Crediting Faisal 20SR =====");
        System.out.println(a1.getName() + "'s  Balance before: " + a1.getBalance());
        System.out.println(a1.credit(20));
        System.out.println(a1.getName() + "'s  Balance after: " + a1.getBalance());

        System.out.println();

        System.out.println("===== Debiting Khaled 20SR =====");
        System.out.println(a2.getName() + "'s Balance before: " + a2.getBalance());
        System.out.println(a2.debit(20));
        System.out.println(a2.getName() + "'s Balance after: " + a2.getBalance());

        System.out.println();

        System.out.println("===== Misc ====="); // things I haven't used
        System.out.println(a1.getName() + "'s ID: " + a1.getId()); // getId

        a1.setId("9"); // setId
        System.out.println("a1.setId(\"9\"); -> " + a1.getId());

        a1.setName("Abdulaziz"); // setName
        System.out.println("a1.setName(\"Abdulaziz\"); -> " + a1.getName());

        System.out.println();

        System.out.println("========== EMPLOYEE QUESTION ==========");
        System.out.println();

        System.out.println("===== Initializing Employees =====");
        Employee e1 = new Employee("1", "Ahmad", 10000);
        Employee e2 = new Employee("2", "Sultan", 5000);
        // instantiate 3 more objects (per requirement 5, but I'll only use 2)
        Employee e3 = new Employee("4", "Tariq", 13000);
        Employee e4 = new Employee("5", "Rayan", 24000);
        Employee e5 = new Employee("6", "Yasser", 9000);
        System.out.println(e1.toString()); // Or I can just call print the obj without toString()
        System.out.println(e2);
        System.out.println(e3);
        System.out.println(e4);
        System.out.println(e5);

        System.out.println();

        System.out.println("===== Getting Ahmad's and Sultan's Annual Salaries =====");
        System.out.println(e1.getName() + "'s Annual salary: " + e1.getAnnualSalary());
        System.out.println(e2.getName() + "'s Annual salary: " + e2.getAnnualSalary());

        System.out.println();

        System.out.println("===== Raising Ahmad's and Sultan's Salary by 10% =====");
        System.out.println(e1.getName() + "'s Salary before: " + e1.getSalary());
        System.out.println(e1.getName() + "'s Salary after: " + e1.raisedSalary(10));
        System.out.println(e2.getName() + "'s Salary before: " + e2.getSalary());
        System.out.println(e2.getName() + "'s Salary after: " + e2.raisedSalary(10));

        System.out.println();

        System.out.println("===== Misc ====="); // things I haven't used
        System.out.println(e1.getName() + "'s ID: " + e1.getId()); // getId

        e1.setId("9"); // setId
        System.out.println("e1.setId(\"9\"); -> " + e1.getId());

        e1.setName("Abdulaziz"); // setName
        System.out.println("a1.setName(\"Abdulaziz\"); -> " + e1.getName());

        System.out.println();
    }
}