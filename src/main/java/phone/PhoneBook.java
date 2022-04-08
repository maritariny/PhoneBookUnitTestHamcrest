package phone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    private Map<String, List<Contact>> groups = new HashMap<>();

    public void createGroup(String nameGroup) {
        if (groups.get(nameGroup) != null) {
            return;
        }
        groups.put(nameGroup, new ArrayList<Contact>());
    }

    public boolean addContactToGroup(Contact contact, String nameGroup) {

        List<Contact> group = groups.get(nameGroup);
        if (group == null) {
            return false;
        }

        return group.add(contact);
    }

    public String printGroup(String nameGroup) {

        List<Contact> group = groups.get(nameGroup);
        if (group == null) {
            return "";
        }

        return group.toString();
    }

    public Contact getContactByNumber(String number) {

        for (Map.Entry<String, List<Contact>> entry : groups.entrySet()) {
            List<Contact> currentList = entry.getValue();
            for (Contact contact : currentList) {
                if (contact.getNumber().equals(number)) {
                    return contact;
                }
            }
        }

        return null;
    }
}