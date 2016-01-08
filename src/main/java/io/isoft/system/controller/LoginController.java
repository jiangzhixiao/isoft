/*
 * Copyright 2010-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.isoft.system.controller;

import io.isoft.base.filter.MyFilter;
import io.isoft.base.filter.MyFilterResult;
import io.isoft.reg.domain.MonitorUsersConfig;
import io.isoft.reg.service.PushService;
import io.isoft.reg.service.UserCfgService;
import io.isoft.reg.service.WarnService;
import io.isoft.system.domain.SysUser;
import io.isoft.system.service.NoticeService;
import io.isoft.system.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.remoting.RemotingInclude;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


/**
 * @author jzx
 */
@Controller
@RequestMapping("/login")
@RemotingDestination(value = "loginController", channels = "my-amf")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);


    @Autowired
    private NoticeService noticeService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private UserCfgService userCfgService;
    @Autowired
    private WarnService warnService;
    @Autowired
    private PushService pushService;


    @RemotingInclude
    @RequestMapping(value = "users", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    MyFilterResult findSysUsers(MyFilter filter) {
        logger.info("fetching MyFilterResult from staff dict");
        MyFilterResult filterResult = sysUserService.getSysUsers(filter);
        return filterResult;
    }

    /**
     * 用户登录，用户名失去焦点、点击登录按钮时调用该方法
     * @param params
     * @return
     */
    @RemotingInclude
    @RequestMapping(value = "user/{userCode}/{password}", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    SysUser login(@PathVariable Map<String, String> params) {
        SysUser u = sysUserService.getSysUser(params);
        return u;
    }


    @RemotingInclude
    @RequestMapping(value = "notice/{userCode}", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    MyFilterResult findNotice(@PathVariable MyFilter filter) {
        MyFilterResult u = noticeService.findNotices(filter);
        return u;
    }

//	SysUser login(@PathVariable Map<String,String> params) {
//		String userCode = params.get("userCode");
//		SysUser u = sysUserService.getSysUser(params);
//		if(u!=null){
//			//
//			String application = params.get("application");
//
//			try {
//				pushService.start(userCode);
//			} catch (RuntimeException e) {
//				logger.error(e.getMessage());
//			}
//		}
//		return u;
//	}


    @RemotingInclude
    @RequestMapping(value = "user/stop", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    void logOut(String userCode) {

        try {
            pushService.stop(userCode);
        } catch (RuntimeException e) {
            logger.error(e.getMessage());
        }
    }

    @RemotingInclude
    @RequestMapping(value = "msg/config/add", method = RequestMethod.POST, produces = "application/json")
    public
    @ResponseBody
    MonitorUsersConfig addUsersConfig(MonitorUsersConfig config) {
        return userCfgService.addUserCfg(config);
    }

    @RemotingInclude
    @RequestMapping(value = "msg/configs", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    MyFilterResult findUsesConfigs(MyFilter filter) {
        return userCfgService.getUserCfg(filter);
    }


    @RemotingInclude
    @RequestMapping(value = "msg/warnMaster", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    MyFilterResult findWarnMasters(MyFilter filter) {
        return warnService.getWarnMaster(filter);
    }

    @RemotingInclude
    @RequestMapping(value = "msg/warnDetails", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    MyFilterResult findWarnDetails(MyFilter filter) {
        return warnService.getWarnDetail(filter);
    }


}
