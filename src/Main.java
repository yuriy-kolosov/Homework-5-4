import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Домашнее задание 5-4 - Билет 13 - Задача");
        System.out.println();
//      Дан класс User, который содержит поля с именем и возрастом. Необходимо реализовать следующий метод:
//
//      На входе коллекция пользователей.
//      Необходимо удалить все дубли (одинаковое имя и возраст).
//      Отсортировать по возрасту и имени.
//      Вернуть самого старого пользователя.
//
//      _____________________________________________
//      Решение
//
//      Пример коллекции пользователей
//
        User user01 = new User("Ivan", 25);
        User user02 = new User("Anna", 19);
        User user03 = new User("Anna", 19);
        User user04 = new User("Petr", 55);
        User user05 = new User("Elena", 43);
        User user06 = new User("Boris", 55);
        User user07 = new User("Sidor", 25);
        User user08 = new User("Sidor", 25);
        User user09 = new User("Sidor", 25);
        User user10 = new User("Sidor", 25);
        User user11 = new User("Igor", 36);
        User user12 = new User("Denis", 51);
        User user13 = new User("Denis", 51);
        User user14 = new User("Fedor", 55);
        User user15 = new User("Alex", 43);
        User user16 = new User("Alex", 43);

        List<User> users = List.of(user01, user02, user03, user04
                , user05, user06, user07, user08
                , user09, user10, user11, user12
                , user13, user14, user15, user16);
//
//      Пример пустой коллекции пользователей
//
        List<User> usersEmpty = Collections.emptyList();
//
//      Проверка работоспособности трех методов на непустой коллекции
//
        User userOldestFoundBySorting = getOldestUserBySorting(users);
        System.out.println(userOldestFoundBySorting);
        System.out.println();

        User userOldestFoundWithoutSorting = getOldestUserWithoutSorting(users);
        System.out.println(userOldestFoundWithoutSorting);
        System.out.println();

        List<User> usersOldestFound = findAllOldestUsers(users);
        System.out.println(usersOldestFound);
        System.out.println();
//
//      Проверка работоспособности трех методов на пустой коллекции
//
        User userOldestFoundBySortingEmpty = getOldestUserBySorting(usersEmpty);
        System.out.println(userOldestFoundBySortingEmpty);
        System.out.println();

        User userOldestFoundWithoutSortingEmpty = getOldestUserWithoutSorting(usersEmpty);
        System.out.println(userOldestFoundWithoutSortingEmpty);
        System.out.println();

        List<User> usersOldestFoundEmpty = findAllOldestUsers(usersEmpty);
        System.out.println(usersOldestFoundEmpty);
        System.out.println();
    }

    /**
     * Поиск одного из самых старых пользователей
     * с удалением дублей
     * и сортировкой коллекции
     */
    public static User getOldestUserBySorting(List<User> users) {
        return users.stream()
                .distinct()
                .sorted(Comparator.comparingInt(User::getAge).reversed().thenComparing(User::getName))
                .findFirst()
                .orElse(null);
    }

    /**
     * Поиск одного из самых старых пользователей
     * без сортировки коллекции
     */
    public static User getOldestUserWithoutSorting(List<User> users) {
        return users.stream()
                .max(Comparator.comparingInt(User::getAge))
                .orElse(null);
    }

    /**
     * Поиск всех самых старых пользователей
     */
    public static List<User> findAllOldestUsers(List<User> users) {
        return users.stream()
                .distinct()
                .sorted(Comparator.comparingInt(User::getAge).reversed().thenComparing(User::getName))
                .collect(Collectors.groupingBy(User::getAge, LinkedHashMap::new, Collectors.toList()))
                .values().stream()
                .findFirst()
                .orElse(Collections.emptyList());
    }

}
