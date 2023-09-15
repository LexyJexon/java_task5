import java.util.*;

public class PhoneBook {
    private Map<String, Set<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    // Добавить номер телефона для имени
    public void addPhoneNumber(String name, String phoneNumber) {
        phoneBook.computeIfAbsent(name, k -> new HashSet<>()).add(phoneNumber);
    }

    // Получить все номера телефона для имени
    public Set<String> getPhoneNumbers(String name) {
        return phoneBook.getOrDefault(name, new HashSet<>());
    }

    // Получить список всех имен в телефонной книге, отсортированный по убыванию числа номеров телефона
    public List<String> getAllNamesByPhoneNumberCount() {
        List<Map.Entry<String, Set<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        // Сортируем записи по убыванию числа номеров телефона
        entries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        // Создаем список имен
        List<String> names = new ArrayList<>();
        for (Map.Entry<String, Set<String>> entry : entries) {
            names.add(entry.getKey());
        }

        return names;
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addPhoneNumber("Антон", "123-456-7890");
        phoneBook.addPhoneNumber("Сергей", "987-654-3210");
        phoneBook.addPhoneNumber("Лариса", "555-555-5555");
        phoneBook.addPhoneNumber("Мария", "888-555-5445");
        phoneBook.addPhoneNumber("Лариса", "888-888-8888");

        // Получаем все номера телефона для имени "John"
        Set<String> johnPhoneNumbers = phoneBook.getPhoneNumbers("John");
        System.out.println("Phone numbers for John: " + johnPhoneNumbers);

        // Получаем список всех имен по убыванию числа номеров телефона
        List<String> sortedNames = phoneBook.getAllNamesByPhoneNumberCount();
        System.out.println("Names sorted by phone number count: " + sortedNames);
    }
}
