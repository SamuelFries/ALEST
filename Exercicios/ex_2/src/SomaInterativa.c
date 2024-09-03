#include <stdio.h>

int main() {
    int n;
    int soma = 0;

    printf("Digite um número inteiro positivo: ");
    scanf("%d", &n);

    if (n <= 0) {
        printf("Por favor, insira um número inteiro positivo.\n");
        return 1;
    }

    for (int i = 1; i <= n; i++) {
        soma += i;
    }

    printf("A soma de 1 até %d é: %d\n", n, soma);

    return 0;
}