package gz.itcast.c_server;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket服务器端程序
 */
public class Server {

    public static void main(String[] args) throws Exception {
        //1、创建ServeSocket
        ServerSocket server = new ServerSocket(8888);

        System.out.println("服务器已经启动成功....");


        //2.接收客户端的连接
        Socket socket = server.accept();

        //3.读取本地的test.html文件
        FileInputStream in = new FileInputStream(new File("d:/web/test.html"));

        //4.构建数据输出通道
        OutputStream out = socket.getOutputStream();

        //5.发送数据
        byte[] buf = new byte[1024];
        int len = 0;
        while( (len=in.read(buf))!=-1 ){
            out.write(buf, 0, len);
        }

        //6.关闭资源
        out.close();
        in.close();
        }
    }

