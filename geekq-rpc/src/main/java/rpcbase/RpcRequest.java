package rpcbase;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 邱润泽 bullock
 */
@Setter
@Getter
public class RpcRequest implements Serializable {
    //唯一键
    private String uuid;
    //服务名称
    private String className;
    //方法名称
    private String methodName;
    //参数类型
    private String[] types;
    //参数
    private Object[] args;
    //隐式参数
    private Map<String, Object> shadowParameterMap = new HashMap<>();
    //客户端应用名称
    private String clientApplicationName;
    //客户端ip
    private String clientIp;
    //是否泛化调用，服务端判断泛化，结果转json
    private boolean isGeneral;
}
