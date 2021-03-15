package br.edu.ifpb.sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.*;
import java.io.File;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Set;

public class Servidor {

    public static void main(String[] args) throws IOException {
        System.out.println("== Servidor ==");

        // Configurando o socket
        ServerSocket serverSocket = new ServerSocket(7001);
        Socket socket = serverSocket.accept();

        // pegando uma referência do canal de saída do socket. Ao escrever nesse canal, está se enviando dados para o
        // servidor
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        // pegando uma referência do canal de entrada do socket. Ao ler deste canal, está se recebendo os dados
        // enviados pelo servidor
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        //path inicial

        // laço infinito do servidor
        while (true) {
            String HOME = System.getProperty("user.home");
            System.out.println("gdg " + HOME);

            System.out.println("Cliente: " + socket.getInetAddress());

            String mensagem = dis.readUTF();
            String[] m = mensagem.split(",");
            System.out.println(m[0] + " " + m[1]);
            switch (m[0]) {
                case "1": {
                    Set<String> me = listFilesUsingJavaIO(HOME + "/Desktop/IFPB/Distribuida/");
                    System.out.println(me);
                }
                case "2": {

                }
                case "3": {
                    createTxt(m[1]);
                    System.out.println("Arquivo Criado");
                }
                case "4": {

                }
            }

            dos.writeUTF("Li sua mensagem: " + mensagem);
        }
        /*
         * Observe o while acima. Perceba que primeiro se lê a mensagem vinda do cliente (linha 29, depois se escreve
         * (linha 32) no canal de saída do socket. Isso ocorre da forma inversa do que ocorre no while do Cliente2,
         * pois, de outra forma, daria deadlock (se ambos quiserem ler da entrada ao mesmo tempo, por exemplo,
         * ninguém evoluiria, já que todos estariam aguardando.
         */
    }
    public static Set<String> listFilesUsingJavaIO(String dir) {
        return Stream.of(new File(dir).listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());
    }
    public static void createTxt(String txt) {
        String fileName = "myfile_" + txt + ".txt";
        Path p = Paths.get(HOME + "/Desktop/IFPB/Distribuida"+ "/" + fileName);
        assertFalse(Files.exists(p));
        Files.createFile(p);
        assertTrue(Files.exists(p));
    }
}