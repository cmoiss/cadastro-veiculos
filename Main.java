public class Main {
    public static void main(String[] args) {
        Pagamento pagamento = new Pagamento();
    
        mensagemBoasVindas();
        pagamento.getSolicitarCartao();        
        pagamento.getValidarCartao();
    }

    private static void mensagemBoasVindas() {
        System.out.println("Bem-vindo ao sistema de cadastro de veículos da SegPOO!");
    }


}
