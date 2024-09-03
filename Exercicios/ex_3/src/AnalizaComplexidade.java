    package ex_3.src;

    public class AnalizaComplexidade {
        public static void main(String[] args) {
            int v = 15;
            int result = sequenciaContagem (v);
            System.out.println("Número de sequências que somam exatamente " + v + ": " + result);
        }

        public static int sequenciaContagem(int v) {
            int count = 0;

            for (int start = 1; start <= v; start++) {
                int sum = 0;
                for (int i = start; i <= v; i++) {
                    sum += i;
                    if (sum == v) {
                        count++;
                        break;
                    } else if (sum > v) {
                        break;
                    }
                }
            }

            return count;
        }
    }