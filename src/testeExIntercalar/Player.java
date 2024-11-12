package testeExIntercalar;

public class Player {
    //name number age
    private String name;
    private int number;
    private int age;

    public Player(String name, int number, int age) {
        this.name = name;
        this.number = number;
        this.age = age;
    }

    String getName() {
        return name;
    }
    int getNumber() {
        return number;
    }
    int getAge() {
        return age;
    }

}
