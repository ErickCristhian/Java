import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;


public class Consumidor {
    public static void main(String[] args) throws Exception{
        System.out.println("Consumidor");

        String NOME_FILA = "task_queue";

        //criando a fabrica de conexoes e criando uma conexao
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        Connection conexao = connectionFactory.newConnection();

        //criando um canal e declarando uma fila
        Channel canal = conexao.createChannel();
        boolean duravel = true;
        canal.queueDeclare(NOME_FILA, duravel, false, false, null);
        System.out.println ( "[*] Aguardando mensagens. Para sair pressione CTRL + C" );

        //Definindo a funcao callback
        canal.basicQos (1); // aceita apenas uma mensagem unacked (sem ack) de cada vez (veja abaixo)

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String mensagem = new String (delivery.getBody (), "UTF-8");

            System.out.println ("[x] Recebido '" + mensagem + "'");
            try {
                doWork (mensagem);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println ("[x] Feito");
                canal.basicAck(delivery.getEnvelope(). getDeliveryTag(), false);
            }
        };
        boolean autoAck = false;

        //Consome da fila
        canal.basicConsume(NOME_FILA, autoAck, deliverCallback, consumerTag -> {});
    }
    private static void doWork(String task) throws InterruptedException {
        for (char ch: task.toCharArray()) {
            if (ch == '.') {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException _ignored) {
                    Thread.currentThread().interrupt();
                }

            };
        }
    }
}

