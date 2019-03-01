package rpcbase;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 服务信息
 * @author 邱润泽
 */
@Getter
@Setter
public class BaseService implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String name;

	private String impl;

	private String ref;
	
	private String version;

	private int weight;

	private String applicationName;

	private String ip;

	private int port;


	@Override
	public String toString() {
		return "BaseService [id=" + id + ", name=" + name + ", impl=" + impl + ", ref=" + ref + ", version=" + version
				+ ", weight=" + weight + ", applicationName=" + applicationName + ", ip=" + ip + ", port=" + port + "]";
	}
}
