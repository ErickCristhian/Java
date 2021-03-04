package com.gugawag.so.ipc;


import java.io.*;
import java.net.*;

public class DateClient {
	public static void main(String[] args)  {
		try {
			// this could be changed to an IP name or address other than the localhost
			Socket sock = new Socket("192.168.23.161",6013);
			InputStream in = sock.getInputStream();
			BufferedReader bin = new BufferedReader(new InputStreamReader(in));

			System.out.println("=== Cliente iniciado ===\n");

			String line = bin.readLine();
			System.out.println("O servidor me disse:" + line);
				
			sock.close();
		}
		catch (IOException ioe) {
				System.err.println(ioe);
		}
	}
}
