package secondTest;

abstract class Cat {
    protected String catName;
    protected int age;
    protected String gender;
    protected double price;

    public Cat(String catName, int age, String gender, double price) {
        this.catName = catName;
        this.age = age;
        if (gender.equals("M") || gender.equals("F")) {
            this.gender = gender;
        }
        this.price = price;
    }

    public String getCatName() {
        return catName;
    }

    public int getAge() {
        return age;
    }


    public double getPrice() {
        return price;
    }


    public String getGender() {
        return gender;
    }


    public abstract String toString();


}

class OrangeCat extends Cat {
    private boolean isFat;

    public OrangeCat(String catName, int age, String gender, boolean isFat) {
        super(catName, age, gender, 200);
        this.isFat = isFat;
    }

    public boolean isFat() {
        return isFat;
    }

    public void setFat(boolean fat) {
        isFat = fat;
    }

    @Override
    public String toString() {

        return "OrangeCat:" + catName +
                "\nage:" + age +
                "\ngender:" + gender +
                "\nprice:" + price +
                "\nisFat:" + isFat + "\n";
    }
}

class BlackCat extends Cat {
    public BlackCat(String catName, int age, String gender) {
        super(catName, age, gender, 350);
    }


    @Override
    public String toString() {
        return "BlackCat:" + catName +
                "\nage:" + age +
                "\ngender:" + gender +
                "\nprice:" + price + "\n";

    }
}