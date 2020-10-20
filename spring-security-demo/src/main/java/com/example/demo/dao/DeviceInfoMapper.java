package com.example.demo.dao;

import com.example.demo.bo.DeviceInfoBo;
import com.example.demo.entity.DeviceInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>类描述：。</p>
 *
 * @author 沈伟 [shenwei]。
 * @version v1.0.0.1。
 * @since JDK1.8。
 * <p>创建日期：2020/9/24 0024 14:50。</p>
 */
@Mapper
public interface DeviceInfoMapper  {

    List<DeviceInfoBo> queryList(DeviceInfoBo deviceInfoBo);

    void insert(DeviceInfo deviceInfo);

    void delete(String eventId);

    void update(DeviceInfo deviceInfo);

    DeviceInfo queryByEventId(String eventId);

}
