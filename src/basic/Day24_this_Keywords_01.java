package basic;

public class Day24_this_Keywords_01 {
    private  int i = 10;
    Day24_this_Keywords_01 increament() {
        i++;
        return  this;

    }

    void print() {
        System.out.println(" i = " + i);

    }

    public static void main(String[] args) {
        Day24_this_Keywords_01 a = new Day24_this_Keywords_01();
        a.increament().increament().increament().print();

    }


}
