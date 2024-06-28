import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class GenealogyTree {
    private Node raiz;

    private static class Node {
        String elem;
        Node pai;
        List<Node> filhos;

        public Node(String valor) {
            this.elem = valor;
            this.pai = null;
            this.filhos = new ArrayList<>();
        }
    }

    public GenealogyTree(String elem) {
        this.raiz = new Node(elem);
    }

    public void inserir(String elem, String paiStr) {
        Node pai = pesquisa(paiStr, raiz);
        if (pai != null) {
            Node novo = new Node(elem);
            novo.pai = pai;
            pai.filhos.add(novo);
        }
    }

    private Node pesquisa(String e, Node r) {
        if (r.elem.equals(e))
            return r;
        for (Node f : r.filhos) {
            Node aux = pesquisa(e, f);
            if (aux != null) return aux;
        }
        return null;
    }

    public List<String> ascendentes(String elem) {
        List<String> result = new ArrayList<>();
        Node node = pesquisa(elem, raiz);
        while (node != null && node.pai != null) {
            result.add(node.pai.elem);
            node = node.pai;
        }
        return result;
    }

    public int contarDescendentes(String elem) {
        Node node = pesquisa(elem, raiz);
        return contarDescendentes(node);
    }

    private int contarDescendentes(Node node) {
        if (node == null) return 0;
        int count = node.filhos.size();
        for (Node f : node.filhos) {
            count += contarDescendentes(f);
        }
        return count;
    }

    public List<String> filhos(String elem) {
        List<String> result = new ArrayList<>();
        Node node = pesquisa(elem, raiz);
        if (node != null) {
            for (Node f : node.filhos) {
                result.add(f.elem);
            }
        }
        return result;
    }

    public List<String> netos(String elem) {
        List<String> result = new ArrayList<>();
        Node node = pesquisa(elem, raiz);
        if (node != null) {
            for (Node f : node.filhos) {
                for (Node n : f.filhos) {
                    result.add(n.elem);
                }
            }
        }
        return result;
    }

    public List<String> tios(String elem) {
        List<String> result = new ArrayList<>();
        Node node = pesquisa(elem, raiz);
        if (node != null && node.pai != null && node.pai.pai != null) {
            for (Node tio : node.pai.pai.filhos) {
                if (!tio.elem.equals(node.pai.elem)) {
                    result.add(tio.elem);
                }
            }
        }
        return result;
    }

    public List<String> primos(String elem) {
        List<String> result = new ArrayList<>();
        Node node = pesquisa(elem, raiz);
        if (node != null && node.pai != null && node.pai.pai != null) {
            for (Node tio : node.pai.pai.filhos) {
                if (!tio.elem.equals(node.pai.elem)) {
                    for (Node primo : tio.filhos) {
                        result.add(primo.elem);
                    }
                }
            }
        }
        return result;
    }

    public void mostrar(String elem, PrintWriter writer) {
        Node node = pesquisa(elem, raiz);
        if (node != null) {
            mostrar(node, 1, writer);
        } else {
            writer.println(elem + " não pertence à família");
        }
    }

    private void mostrar(Node node, int nivel, PrintWriter writer) {
        for (int i = 1; i < nivel; i++) {
            writer.print("  | ");
        }
        writer.println(node.elem);
        for (Node f : node.filhos) {
            mostrar(f, nivel + 1, writer);
        }
    }
}