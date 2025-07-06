public class Account {
    // Attributes
    private String id;
    private String name;
    private int balance;

    // Constructors
    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    // Methods
    public String debit(int amount) {
        if (this.getBalance() >= amount) {
            setBalance(this.getBalance() - amount);
            return "Debit successful";
        }
        return "Debit failed";
    }
    public String credit(int amount) {
        this.setBalance(this.getBalance() + amount);
        return "Credit successful";
    }
    public String transferTo(Account another, int amount) {
        if (this.getBalance() >= amount) {
            String result = this.debit(amount);
            // Make sure the update is transactional (if debit failed we don't credit)
            if (result.equals("Debit successful")) {
                another.credit(amount);
                return "Transfer from " + this.getName() + " to " + another.getName() + " successful";
            }
        }
        return "Transfer failed";
    }

    // Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    // toString
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
