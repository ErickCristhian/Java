import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class Produtor {
    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        //localizacao do gestor da fila (Queue Manager)
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);

        String NOME_FILA = "task_queue";
        try (
                //criacao de uma coneccao
                Connection connection = connectionFactory.newConnection();
                //criando um canal na conexao
                Channel channel = connection.createChannel()) {
            //Esse corpo especifica o envio da mensagem para a fila

            //Declaracao da fila. Se nao existir ainda no queue manager, serah criada. Se jah existir, e foi criada com
            // os mesmos parametros, pega a referencia da fila. Se foi criada com parametros diferentes, lanca excecao
            boolean duravel = true;
            channel.queueDeclare(NOME_FILA, duravel, false, false, null);

            String mensagem = String.join ( "" , args);
            mensagem += "\nErick Cristhian Moura da Silva";

            channel.basicPublish ( "" , NOME_FILA , MessageProperties.PERSISTENT_TEXT_PLAIN , mensagem.getBytes ());
            channel.basicPublish ( "" , NOME_FILA , MessageProperties.PERSISTENT_TEXT_PLAIN , "mensagem 1".getBytes ());
            channel.basicPublish ( "" , NOME_FILA , MessageProperties.PERSISTENT_TEXT_PLAIN , "mensagem 2".getBytes ());
            System.out.println ( "[x] Enviado '" + mensagem + "'" );
        }
    }
}
