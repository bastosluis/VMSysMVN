# VMSysMVN
A simple vending machine implementation for the 2nd assignment of Técnicas de Programação 2 - 2023.1 course

# Adições ao VMSys:
NeutralFundsException (addCoin() não trata adição com valores negativos)

vend() checava se getCount era >= 0, e não <= 0; também checava se itemPrice < coinsDeposited, porém era pra checar > coinsDeposited.

vend() estava incorretamente incrementando o valor das moedas depositadas do preço do item, porém o correto seria decrementar.

vend() chama o método decCount(), porém a quantidade em estoque de um item está indo para valores negativos.

os metodos de item decCount e incCount estavam incrementando e decrementando, respectivamente.

Criada novas excessões DecrementCountZeroException, NullItemException

Após testes mutantes, foi observado que 1 mutante sobreviveu. Logo foi mudado que itemPrice <= coinsDeposited (agora é possível que existam itens gratuitos)

Porém, o mutante não foi eliminado.