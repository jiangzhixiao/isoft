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

package io.isoft.blood.controller;

import io.isoft.base.filter.MyFilter;
import io.isoft.base.filter.MyFilterResult;
import io.isoft.base.filter.MyPrintExportFilter;
import io.isoft.blood.service.RdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.remoting.RemotingInclude;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Handles requests for the application home page.
 * 
 * @author Roy Clarkson
 */
@Controller
@RequestMapping("/blood")
@RemotingDestination(value="rdController", channels="my-amf")
public class RdController {
	private static final Logger logger = LoggerFactory.getLogger(RdController.class);
	@Autowired
	private RdService rdService;
	@RemotingInclude
	@RequestMapping(value = "masters",method = RequestMethod.GET,produces = "application/json")
	public  @ResponseBody MyFilterResult fetchRds(MyFilter filter) {
		logger.info("fetching MyFilterResult from staff dict");
		MyFilterResult filterResult = rdService.findByFilter(filter);
		return filterResult;
	}

	@RemotingInclude
	@RequestMapping(value = "masters/export",method = RequestMethod.GET,produces = "application/json")
	public  @ResponseBody MyFilterResult fetchRds(MyPrintExportFilter filter) {
		logger.info("fetching MyFilterResult from staff dict");
		MyFilterResult filterResult = rdService.findByFilter(filter);
		return filterResult;
	}

}
