package HomeWork36;

class Login {
    private String name;
    private String surname;
    private String login;
    private String password;

    public Login(String name, String surname, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
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

    public String getLogin() {
        return login;
    }

    public static String generateLogin(String name, String surname) {
        return name.substring(0, 2).concat(surname);
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + login + " " + password;
    }
}
