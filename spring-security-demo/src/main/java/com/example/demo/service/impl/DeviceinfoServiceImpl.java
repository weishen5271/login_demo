package com.example.demo.service.impl;

import com.example.demo.bo.DeviceInfoBo;
import com.example.demo.dao.DeviceInfoMapper;
import com.example.demo.entity.ControllerResult;
import com.example.demo.entity.DeviceInfo;
import com.example.demo.service.DeviceinfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <p>类描述：。</p>
 *
 * @author 沈伟 [shenwei]。
 * @version v1.0.0.1。
 * @since JDK1.8。
 * <p>创建日期：2020/9/24 0024 14:54。</p>
 */
@Service
@Transactional
public class DeviceinfoServiceImpl implements DeviceinfoService {

    @Autowired
    private DeviceInfoMapper deviceInfoMapper;

    @Override
    public List<DeviceInfoBo> queryList(DeviceInfoBo deviceInfoBo) {
        return deviceInfoMapper.queryList(deviceInfoBo);
    }

    @Override
    public ControllerResult queryPage(DeviceInfoBo deviceInfoBo) {
        PageHelper.startPage(deviceInfoBo.getStartIndex(), deviceInfoBo.getPageSize());
        List<DeviceInfoBo> deviceInfoList = deviceInfoMapper.queryList(deviceInfoBo);
        PageInfo<DeviceInfoBo> pageInfo = new PageInfo<DeviceInfoBo>(deviceInfoList);
        ControllerResult pageResult = new ControllerResult((int) pageInfo.getTotal(), pageInfo.getPages(),
                pageInfo.getPageSize(), pageInfo.getPageNum(), pageInfo.getPageNum() == 1,
                pageInfo.getPageNum() == pageInfo.getPages(), pageInfo.getList());
        return pageResult;
    }

    @Override
    public void insert(DeviceInfo deviceInfo) {
        deviceInfo.setEventId(UUID.randomUUID().toString());
        deviceInfoMapper.insert(deviceInfo);
    }

    @Override
    public void update(DeviceInfo deviceInfo) {

        deviceInfo.setModifyDate(new Date());
        deviceInfoMapper.update(deviceInfo);
    }

    @Override
    public void delete(String eventId) {
        deviceInfoMapper.delete(eventId);
    }

    @Override
    public DeviceInfo queryByEventId(String eventId) {
        return deviceInfoMapper.queryByEventId(eventId);
    }


}
