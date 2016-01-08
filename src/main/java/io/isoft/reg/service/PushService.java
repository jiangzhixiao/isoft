package io.isoft.reg.service;

/**
 * 预警消息管理器
 *
 */
public interface PushService {
	/**
	 * 开始指定用户的预警服务
	 * @param userCode
	 */
	void start(String userCode) throws RuntimeException;
	/**
	 * 停止指定用户的预警服务
	 * @param userCode
	 */
	void stop(String userCode);
}
