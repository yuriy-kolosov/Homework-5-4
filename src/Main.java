import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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

        User user01 = new User("Ivan", 25);
        User user02 = new User("Anna", 19);
        User user03 = new User("Anna", 19);
        User user04 = new User("Petr", 55);
        User user05 = new User("Elena", 43);
        User user06 = new User("Sidor", 25);
        User user07 = new User("Sidor", 25);
        User user08 = new User("Sidor", 25);
        User user09 = new User("Igor", 36);
        User user10 = new User("Denis", 51);
        User user11 = new User("Alex", 43);
        User user12 = new User("Alex", 43);

        List<User> users = List.of(user01, user02, user03, user04, user05, user06
                , user07, user08, user09, user10, user11, user12);

        List<User> usersSorted = usersSortedWithoutDoubles(users).orElseThrow();
        System.out.println(usersSorted);
        System.out.println();

        User userOldest = userOld(users).orElseThrow();
        System.out.println(userOldest);
        System.out.println();

    }

    public static Optional<List<User>> usersSortedWithoutDoubles(List<User> users) {
        return Optional.of(users.stream()
                .distinct()
                .sorted(Comparator.comparing(User::getAge)
                        .thenComparing(User::getName))
                .toList());
    }

    public static Optional<User> userOld(List<User> users) {
        return users.stream()
                .max(Comparator.comparing(User::getAge));
    }

}
