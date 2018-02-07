package com.lhl.test.thrifttest.client;

import com.lhl.test.thrifttest.Hello;
import javafx.application.Preloader;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by liuhonglin on 2016/9/18.
 */
public class ThriftClient {

    public static final String SERVER_IP = "localhost";
    public static final int SERVER_PORT = 9090;
    public static final int TIMEOUT = 30000;

    public void startClient(String name) {
        TTransport transport = null;
        try {
            transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);

            TProtocol protocol = new TBinaryProtocol(transport);

            Hello.Client client = new Hello.Client(protocol);
            transport.open();

           String str = client.helloString(name);

            System.out.println(str);
        }
        catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            if(transport != null) {
                transport.close();
            }
        }
    }

    public static void main(String... args) {
        ThriftClient client = new ThriftClient();
        client.startClient("小明");
    }
}
