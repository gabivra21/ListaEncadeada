import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada(23);

        lista.add(89);
        lista.add(88);
        lista.add(56);
        System.out.println(lista.isEmpty());
        lista.addPos(2,87);
        lista.remove(2);
        lista.remove(1);
        lista.getNodePos(3);

    }
}
