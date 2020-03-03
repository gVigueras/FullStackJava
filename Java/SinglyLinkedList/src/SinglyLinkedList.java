public class SinglyLinkedList {
    public Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    // Los metodos de la SLL van aqui. Al principio, les mostraremos cómo agregar
    // nodos a la lista.
    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while (runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }

    public void remove() {
        Node aux = null;
        if (head != null) {
            Node runner = head;
            while (runner.next != null) {
                aux = runner;
                runner = runner.next;
            }
            aux.next = null;
            runner = null;
        }
    }

    public void printValues() {
        if (head != null) {
            Node runner = head;
            System.out.println(runner.value);
            while (runner.next != null) {
                runner = runner.next;
                System.out.println(runner.value);
            }
        }
    }

    public Node find(int value) {
        Node runner = head;
        while (runner.next != null) {
            if (runner.value == value)
                return runner;
            runner = runner.next;
        }
        return null;
    }

    public void removeAt(int pos) {
        Node aux = null;
        if (head != null) {
            if (pos == 0) {
                head = head.next;
                return;
            }
            Node runner = head;
            for (int i = 0; i < pos; i++) {
                aux = runner;
                if (runner.next != null)
                    runner = runner.next;
                else
                    return;
            }
            aux.next = runner.next;
            runner = null;
        } else {
            System.out.println("Imposible borrar de lista sin elementos");
        }
    }
}