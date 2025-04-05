package HomeWork36;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UpdateContact {
    public static void updateContactByName(List<Contact> userContactList, String name) {
        Scanner scanner = new Scanner(System.in);
        int contactCount = SearchContact.searchContactByName(userContactList, name);
        if (contactCount == 1) {
            System.out.print("Введите новое имя: ");
            String newName = scanner.nextLine().trim();
            for (Contact contact : userContactList) {
                if (contact.getName().equals(name)) {
                    contact.setName(newName);
                }
            }
            System.out.println("Запись обновлена");
        } else if (contactCount > 1) {
            System.out.println("Найдено несколько записей с именем \"" + name + "\"");
            try {
                System.out.print("Введите id для изменения имени: ");
                int contactId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Введите новое имя: ");
                String newName = scanner.nextLine().trim();
                updateById(userContactList, contactId, 1, newName);
                System.out.println("Запись обновлена");
            } catch (InputMismatchException e) {
                System.out.println("Некорректное значение id");
                System.out.println();
                scanner.nextLine();
            }
        } else {
            System.out.println("Не удалось изменить контакт: Контакт не найден по имени \"" + name + "\"");
        }

    }

    public static void updateContactBySurname(List<Contact> userContactList, String surname) {
        Scanner scanner = new Scanner(System.in);
        int contactCount = SearchContact.searchContactBySurname(userContactList, surname);
        if (contactCount == 1) {
            System.out.print("Введите новую фамилию: ");
            String newSurname = scanner.nextLine().trim();
            for (Contact contact : userContactList) {
                if (contact.getSurname().equals(surname)) {
                    contact.setSurname(newSurname);
                }
            }
            System.out.println("Запись обновлена");
        } else if (contactCount > 1) {
            System.out.println("Найдено несколько записей с фамилией \"" + surname + "\"");
            try {
                System.out.print("Введите id для изменения фамилии: ");
                int contactId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Введите новую фамилию: ");
                String newSurname = scanner.nextLine().trim();
                updateById(userContactList, contactId, 2, newSurname);
                System.out.println("Запись обновлена");
            } catch (InputMismatchException e) {
                System.out.println("Некорректное значение id");
                System.out.println();
                scanner.nextLine();
            }
        } else {
            System.out.println("Не удалось изменить контакт: Контакт не найден по фамилии");
        }
    }

    public static void updateContactByPhone(List<Contact> userContactList, String phone) {
        Scanner scanner = new Scanner(System.in);
        int contactCount = SearchContact.searchContactByPhone(userContactList, phone);
        if (contactCount == 1) {
            System.out.print("Введите новый номер телефона: ");
            String newPhone = scanner.nextLine().trim();
            for (Contact contact : userContactList) {
                if (contact.getPhone().equals(phone)) {
                    contact.setPhone(newPhone);
                }
            }
            System.out.println("Запись обновлена");
        } else if (contactCount > 1) {
            System.out.println("Найдено несколько записей с номером \"" + phone + "\"");
            try {
                System.out.print("Введите id для изменения номера телефона: ");
                int contactId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Введите новый номер телефона: ");
                String newPhone = scanner.nextLine().trim();
                updateById(userContactList, contactId, 3, newPhone);
                System.out.println("Запись обновлена");
            } catch (InputMismatchException e) {
                System.out.println("Некорректное значение id");
                System.out.println();
                scanner.nextLine();
            }
        } else {
            System.out.println("Не удалось изменить контакт: Контакт не найден по номеру телефона");
        }
    }

    public static void updateContactByAge(List<Contact> userContactList, int age) {
        Scanner scanner = new Scanner(System.in);
        int contactCount = SearchContact.searchContactByAge(userContactList, age);
        if (contactCount == 1) {
            System.out.print("Введите новый возраст: ");
            int newAge = scanner.nextInt();
            for (Contact contact : userContactList) {
                if (contact.getAge() == age) {
                    contact.setAge(newAge);
                }
            }
            System.out.println("Запись обновлена");
        } else if (contactCount > 1) {
            System.out.println("Найдено несколько записей с возрастом \"" + age + "\"");
            try {
                System.out.print("Введите id для изменения возраста: ");
                int contactId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Введите новый возраст: ");
                int newAge = scanner.nextInt();
                scanner.nextLine();
                updateById(userContactList, contactId, 4, String.valueOf(newAge));
                System.out.println("Запись обновлена");
            } catch (InputMismatchException e) {
                System.out.println("Некорректное значение id");
                System.out.println();
                scanner.nextLine();
            }
        } else {
            System.out.println("Не удалось изменить контакт: Контакт не найден по возрасту");
        }
    }

    public static void updateById(List<Contact> userContactList, int id, int updateFieldNumber, String newValue) {
        if (updateFieldNumber == 1) {
            for (Contact contact : userContactList) {
                if (contact.getId() == id) {
                    contact.setName(newValue);
                }
            }
            return;
        }
        if (updateFieldNumber == 2) {
            for (Contact contact : userContactList) {
                if (contact.getId() == id) {
                    contact.setSurname(newValue);
                }
            }
            return;
        }
        if (updateFieldNumber == 3) {
            for (Contact contact : userContactList) {
                if (contact.getId() == id) {
                    contact.setPhone(newValue);
                }
            }
            return;
        }
        if (updateFieldNumber == 4) {
            try {
                for (Contact contact : userContactList) {
                    if (contact.getId() == id) {
                        contact.setAge(Integer.parseInt(newValue));
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка. Некорректное значение возраста");
            }
        }
    }
}
