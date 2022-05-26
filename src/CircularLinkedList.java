/**
 * <h1>Creeaza o lista simplu inlantuita</h1>
 * Clasa CircularLinkedList pastreaza inceputul
 * si sfarsitul listei in variabilele head respectiv tail.
 *
 * @author Dicu Catalin
 * @version 1.0
 * @since 2022-05-17
 */

public class CircularLinkedList {
    private Node head = null;
    private Node tail = null;

    /**
     * Metoda adauga un nod nou in lista. Daca lista este goala,
     * acesta va fi adaugat la inceputul listei.
     * @param value Aceasta este valoarea din noul nod adaugat
     */
    public void addNode(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }

        tail = newNode;
        tail.nextNode = head;
    }

    /**
     * Verifica daca o anumita valoare se afla in lista.
     * Daca lista nu este goala, este verificat fiecare nod pana la ultimul.
     * @param searchValue Aceasta este valoarea cautata in lista
     * @return Intoarce true daca valoarea este gasita, altfel false.
     */
    public boolean containsNode(int searchValue) {
        Node currentNode = head;

        if (head == null) {
            return false;
        } else {
            do {
                if (currentNode.value == searchValue) {
                    return true;
                }
                currentNode = currentNode.nextNode;
            } while (currentNode != head);
            return false;
        }
    }

    /**
     * Cauta o valoare in lista, iar daca aceasta este gasita nodul care
     * o contine va fi sters din lista.
     * @param valueToDelete Aceasta este valoarea care trebuie stearsa.
     */

    public void deleteNode(int valueToDelete) {
        Node currentNode = head;
        if (head == null) {
            return;
        }
        do {
            Node nextNode = currentNode.nextNode;
            if (nextNode.value == valueToDelete) {
                if (tail == head) {
                    head = null;
                    tail = null;
                } else {
                    currentNode.nextNode = nextNode.nextNode;
                    if (head == nextNode) {
                        head = head.nextNode;
                    }
                    if (tail == nextNode) {
                        tail = currentNode;
                    }
                }
                break;
            }
            currentNode = nextNode;
        } while (currentNode != head);
    }

    /**
     * Cauta in lista nodul cu aceeasi valoare ca si nodul primit ca
     * parametru si il intoarce.
     * @param currentNode Nodul care trebuie cautat.
     * @return Intoarce nodul cu aceeasi valoare ca nodul primit ca parametru
     */
    public Node getNode(Node currentNode) {
        Node p = head;

        if (head == null) {
            return null;
        } else {
            do {
                if (currentNode.value == p.value) {
                    return p;
                }
                currentNode = currentNode.nextNode;
            } while (currentNode != head);
            return null;
        }
    }
}