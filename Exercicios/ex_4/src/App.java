package ex_4.src;

public class App {

    public static void main(String[] args) {
        ListArrayOfInteger lista = new ListArrayOfInteger();
        lista.add(2);
        lista.add(4);
        lista.add(6);
        lista.add(8);
        lista.add(10);
        lista.add(12);
        System.out.println(lista);

        System.out.println("Elemento armazenado na " + "primeira posicao da lista: " + lista.get(0));

    }
}

