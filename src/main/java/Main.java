import phone.Contact;
import phone.PhoneBook;

class Main {
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.createGroup("Друзья");
        phoneBook.createGroup("Работа");

        Contact contact1 = new Contact("Лермонтов", "+79110001111");
        Contact contact2 = new Contact("Пушкин", "+79212221111");

        phoneBook.addContactToGroup(contact1, "Друзья");
        phoneBook.addContactToGroup(contact2, "Друзья");

        phoneBook.addContactToGroup(contact1, "Работа");

        System.out.println("Состав группы Друзья " + phoneBook.printGroup("Друзья"));
        System.out.println("Состав группы Работа " + phoneBook.printGroup("Работа"));

        System.out.println("Результат поиска контакта по номеру = " + phoneBook.getContactByNumber("+79110001111"));
        System.out.println("Результат поиска контакта по несуществующему номеру = " + phoneBook.getContactByNumber("112"));
    }
}
