package entity;

public class UserExpenses {
    private User user1;
    private User user2;
    private Double amount;

    public UserExpenses(User user1, User user2, Double amount) {
        this.user1 = user1;
        this.user2 = user2;
        this.amount = amount;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
