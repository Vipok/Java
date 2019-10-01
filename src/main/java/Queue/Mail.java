package Queue;

public class Mail {
    public static void main(String[] args) {
        MailQueue<Person> queue = new MailQueue();
        Person person1 = new Person("Bob", 14);
        Person person2 = new Person("Jack", 42);
        Person person3 = new Person("Bill", 33);
        Person person4 = new Person("Scarlett", 30);
        Person person5 = new Person("May", 70);

        queue.push(person1);
        queue.push(person2);
        queue.push(person3);
        queue.push(person4);
        queue.push(person5);

        while (queue.size() > 0) {
            Person s = queue.pull();
            System.out.println(s);
            System.out.println("Queue size: " + queue.size());
        }
    }
}
