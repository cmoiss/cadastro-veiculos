//Use enum para as bandeiras no identificador de bandeiras

import java.util.Scanner;

public class Pagamento {
    private String numeroCartao;   
    private static int[] vetorNumeroCartao = new int[16];

    //usuário entra com 16 dígito
    //retorna se é válido
    //retorna a bandeira

    private String solicitarCartao() {
        Scanner ler = new Scanner(System.in);     

        do {
            System.out.print("Digite o número do seu cartão: ");
            numeroCartao = ler.nextLine();

            if (numeroCartao.length() != 16) {
                System.out.println("Número inválido, por favor digite exatamente 16 dígitos.");
            }    
            
        } while (numeroCartao.length() != 16);
        
        return numeroCartao;
    }

    private void validarCartao() {
        // Solicita caso o número do cartão não tenha sido solicitado anteriormente
        if (numeroCartao == null) { 
            solicitarCartao();    
        } else
        
        //Converte char para inteiro
        for(int i = 0; i < 16; i++) { 
            vetorNumeroCartao[i] = numeroCartao.charAt(i) - 48;
        }

        //Teste saber se está preenchendo o vetor como inteiro
        //System.out.println(vetorNumeroCartao[0] + vetorNumeroCartao[1]);

        identificarBandeira();
    }

    private static void identificarBandeira() {
        //Armazena as bandeiras
        String[] bandeiras = {"Visa", "Mastercard", "American Express", "Maestro", "Outra bandeira"};
        int primeiroDigito = vetorNumeroCartao[0];
        int segundoDigito = vetorNumeroCartao[1];

        
        switch (primeiroDigito) {
            //American Express
            case 3:
                if (segundoDigito == 4 || segundoDigito == 7) {
                    mensagemBandeira(bandeiras[2]);
                }
                break;
            
            //Visa
            case 4:
                mensagemBandeira(bandeiras[0]);
                break;

            //Mastercard ou Maestro
            case 5: 
                if (segundoDigito >= 1 && segundoDigito <= 5) {
                    mensagemBandeira(bandeiras[1]);
                }

                if (segundoDigito == 0) {
                    mensagemBandeira(bandeiras[4]);
                } else if (segundoDigito >= 6 && segundoDigito <= 9) {
                    mensagemBandeira(bandeiras[4]);
                }
                break;
            
            //Maestro
            case 6:
                mensagemBandeira(bandeiras[4]);
                break;
        
            //Outra bandeira
            default:
                mensagemBandeira(bandeiras[5]);
                break;
        }
    }

    private static void mensagemBandeira(String bandeira) {
        System.out.println("Sua bandeira é " + bandeira);
    }

    public void getSolicitarCartao() {
        solicitarCartao();
    }

    public void getValidarCartao() {
        validarCartao();   
    }
}
