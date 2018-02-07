package com.lhl.test.thrifttest;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;

/**
 * Created by liuhonglin on 2016/9/18.
 */
public class HelloServer {

    public static final int SERVER_PORT = 9090;

    public void startServer() {
        try {
            System.out.println("HelloService start....");

            TProcessor tProcessor = new Hello.Processor<Hello.Iface>(new HelloImpl());

            TServerSocket serverTransport = new TServerSocket(SERVER_PORT);
            TBinaryProtocol.Factory portFactory = new TBinaryProtocol.Factory();

            TServer.Args tArgs = new TServer.Args(serverTransport);
            tArgs.processor(tProcessor);
            tArgs.protocolFactory(portFactory);

            TServer server = new TSimpleServer(tArgs);
            server.serve();

        }
        catch (Exception e) {
            System.out.print("HelloServer start error!");
        }
    }

    public static void main(String[] args) {
        HelloServer server = new HelloServer();
        server.startServer();
    }
}
