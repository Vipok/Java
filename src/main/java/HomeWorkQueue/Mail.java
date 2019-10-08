package HomeWorkQueue;

public class Mail {
    private static MailQueue<Person> queue = new MailQueue();
    public static void main(String[] args) {

        Person person1 = new Person("Bob", 14);
        Person person2 = new Person("Jack", 42);
        Person person3 = new Person("Bill", 33);
        Person person4 = new Person("May", 70);
        Person person5 = new Person("Scarlett", 30);
        Person person6 = new Person("Babulya", 90);

        addMailQueue(person1);
        addMailQueue(person2);
        addMailQueue(person3);
        addMailQueue(person4);
        addMailQueue(person5);
        addMailQueue(person6);

        while (queue.size() > 0) {
            Person s = queue.pull();
            System.out.println(s);
            System.out.println("Queue size: " + queue.size());
        }

        queue.push(person3);
        System.out.println(queue.get(0));
    }

    //доработка очереди для льготников
    public static void addMailQueue(Person person){
        if(person.getAge()>=60){
            queue.pushPriority(person);
        }else if (person.getAge()>0){
            queue.push(person);
        }else {
            System.out.println("Who are you???");
        }
    }
}
