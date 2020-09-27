package com.example.demo.controller;

import com.example.demo.bo.DeviceInfoBo;
import com.example.demo.entity.BusinessResult;
import com.example.demo.entity.ControllerResult;
import com.example.demo.entity.DeviceInfo;
import com.example.demo.service.DeviceinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>类描述：。</p>
 *
 * @author 沈伟 [shenwei]。
 * @version v1.0.0.1。
 * @since JDK1.8。
 * <p>创建日期：2020/9/24 0024 14:53。</p>
 */
@RequestMapping("device")
@RestController
public class DeviceInfoController {

    @Autowired
    private DeviceinfoService deviceinfoService;


    @RequestMapping("queryList")
    public Object queryList(DeviceInfoBo deviceInfoBo){
        List<DeviceInfoBo> resultList = deviceinfoService.queryList(deviceInfoBo);
        return new BusinessResult(resultList);
    }

    @RequestMapping("queryPage")
    public Object queryPage(DeviceInfoBo deviceInfoBo){
        ControllerResult result = deviceinfoService.queryPage(deviceInfoBo);
        return result;
    }



    @RequestMapping("insert")
    public Object insert(@RequestBody DeviceInfo deviceInfo){

        this.deviceinfoService.insert(deviceInfo);
        return new BusinessResult();
    }
}
