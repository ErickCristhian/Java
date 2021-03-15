package br.edu.ifpb.sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.nio.file.*;

public class Cliente {

    public static void main(String[] args) throws IOException {
        System.out.println("== Cliente ==");

        // configurando o socket
        Socket socket = new Socket("127.0.0.1", 7001);
        // pegando uma referência do canal de saída do socket. Ao escrever nesse canal, está se enviando dados para o
        // servidor
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        // pegando uma referência do canal de entrada do socket. Ao ler deste canal, está se recebendo os dados
        // enviados pelo servidor
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        menu();
        Scanner entrada = new Scanner(System.in);
        int opcao = entrada.nextInt();
        // laço infinito do cliente
        while (opcao != 9) {

            switch (opcao) {
                case 1: {
                    Scanner teclado = new Scanner(System.in);
                    System.out.println("Qual diretório quer ler?");
                    dos.writeUTF("1," + teclado.nextLine());// escrevendo para o servidor)

                    // lendo o que o servidor enviou
                    String mensagem = dis.readUTF();
                    System.out.println("Servidor falou: " + mensagem);
                    break;
                }
                case 2: {
                    System.out.println("vim aqui");
                    break;
                }

                case 3: {
                    Scanner teclado = new Scanner(System.in);
                    System.out.println("Qual nome quer no arquivo?");
                    // escrevendo para o servidor
                    dos.writeUTF("3," + teclado.nextLine());

                    // lendo o que o servidor enviou
                    String mensagem = dis.readUTF();
                    System.out.println("Servidor falou: " + mensagem);
                    break;
                }
                case 4: {
                    Scanner teclado = new Scanner(System.in);
                    System.out.println("Qual arquivo quer remover?");
                    // escrevendo para o servidor
                    dos.writeUTF("4," + teclado.nextLine());

                    // lendo o que o servidor enviou
                    String mensagem = dis.readUTF();
                    System.out.println("Servidor falou: " + mensagem);
                    break;
                }
            }
            menu();
            opcao = entrada.nextInt();

        }
        /*
         * Observe o while acima. Perceba que primeiro se escreve para o servidor (linha 27), depois se lê do canal de
         * entrada (linha 30), vindo do servidor. Agora observe o código while do Servidor2. Lá, primeiro se lê,
         * depois se escreve. De outra forma, haveria um deadlock.
         */
    }
    public static void menu() {
        System.out.println("\n -- Erick Cristhian -- ");
        System.out.println("\n=== Sockets em Ação ===");
        System.out.println("1 - Conteúdo do Diretório");
        System.out.println("2 - Renomear Arquivo");
        System.out.println("3 - Criar Arquivo");
        System.out.println("4 - Remover Arquivo");
        System.out.println("9 - Sair");
    }

}