package com.example.demo.service;

import com.example.demo.bo.DeviceInfoBo;
import com.example.demo.entity.ControllerResult;
import com.example.demo.entity.DeviceInfo;

import java.util.List;

/**
 * <p>类描述：。</p>
 *
 * @author 沈伟 [shenwei]。
 * @version v1.0.0.1。
 * @since JDK1.8。
 * <p>创建日期：2020/9/24 0024 14:53。</p>
 */
public interface DeviceinfoService {

    List<DeviceInfoBo> queryList(DeviceInfoBo deviceInfo);

    ControllerResult queryPage(DeviceInfoBo deviceInfoBo);

    void insert(DeviceInfo deviceInfo);
}
