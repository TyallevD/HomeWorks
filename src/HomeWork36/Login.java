package HomeWork36;

import java.util.Objects;

class Login {
    private String name;
    private String surname;
    private String login;
    private String password;
    private String loginContactsPath;

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

    public String getLoginContactsPath() {
        return ProgrammPaths.CONTACTS_DIR + "/" + this.login.concat("Contacts.txt");
    }

    public static String generateLogin(String name, String surname) {
        return name.substring(0, 2).concat("-").concat(surname);
    }

    public static Login parseLogin(String line) {
        String[] parts = line.split(" ");
        return new Login(parts[0], parts[1], parts[2], parts[3]);
    }


    @Override
    public String toString() {
        return name + " " + surname + " " + login + " " + password;
    }
}
