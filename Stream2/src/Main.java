import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Main {


    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        long stream = persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.print("Количество несовершенно летних составило " + stream);


        List<String> stream1 = persons.stream()
                .filter(person -> Sex.MAN == person.getSex())
                .filter(person -> person.getAge() <= 27 && person.getAge() >= 18)
                .map(person -> String.valueOf(person.getFamily()))
                .collect(Collectors.toList());
        System.out.println(stream1);


        System.out.println();
        List<String> stream2 = persons.stream()
                .filter(person -> person.getEducation() == Education.HIGHER)
                .filter(person -> person.getAge() >= 18 && (person.getSex() == Sex.WOMAN && person.getAge() < 60) || (person.getSex() == Sex.MAN && person.getAge() < 65))
                .map(Person::getName)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());


    }

}
