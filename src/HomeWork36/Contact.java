package HomeWork36;

class Contact {
    private int id;
    private String name;
    private String surname;
    private String phone;
    private int age;

    public Contact(int id, String name, String surname, String phone, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + surname + " " + phone + " " + age;
    }
}
