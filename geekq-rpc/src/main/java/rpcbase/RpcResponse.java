package rpcbase;

import lombok.Getter;
import lombok.Setter;
import org.msgpack.annotation.Message;

import java.io.Serializable;

/**
 * rpc传输响应
 * @author 邱润泽
 */
@Message
@Setter
@Getter
public class RpcResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean isSuccess;//成功/异常

	private Object result;//结果

	private Throwable throwable;//异常信息

	@Override
	public String toString() {
		return "RpcResponse [isSuccess=" + isSuccess + ", result=" + result + ", throwable=" + throwable + "]";
	}
}