import rpcbase.RpcServer;

/**
 * @author 邱润泽 bullock
 */
public class Test {


    public static void main(String[] args) {

        new RpcServer(10101).start();
    }
}
