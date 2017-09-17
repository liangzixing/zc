/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.controller;

import com.zc.controller.dto.AjaxResult;
import com.zc.controller.dto.CustomerTallyDTO;
import com.zc.controller.dto.GridAjaxResult;
import com.zc.controller.param.CustomerEditDTO;
import com.zc.controller.param.CustomerQueryParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/16 15:19 1.0.0
 */
@Controller
@RequestMapping("/customerTally")
public class CustomerTallyController {

    @RequestMapping("/addPage")
    public String addPage() {
        return "/customerTally/editPage";
    }

    @RequestMapping("/listPage")
    public String listPage() {
        return "/customerTally/listPage";
    }

    @ResponseBody
    @RequestMapping("/pagedQuery")
    public GridAjaxResult<CustomerTallyDTO> pagedQuery(CustomerQueryParam condition) {

        return null;
    }

    @ResponseBody
    @RequestMapping("/add")
    public AjaxResult<Boolean> add(CustomerEditDTO customerEditDTO) {

        return null;
    }

    @ResponseBody
    @RequestMapping("/delete")
    public AjaxResult<Boolean> delete(Integer id) {

        return null;
    }

    public String export() {

        return null;
    }

}
