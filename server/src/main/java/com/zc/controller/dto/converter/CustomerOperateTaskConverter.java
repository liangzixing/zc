/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.controller.dto.converter;

import com.zc.controller.dto.CustomerOperateTaskDTO;
import com.zc.utils.DateUtil;
import com.zc.workflow.model.UserTask;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/10/21 13:40 1.0.0
 */
public class CustomerOperateTaskConverter {

    public static CustomerOperateTaskDTO toDTO(UserTask userTask){

        CustomerOperateTaskDTO customerOperateTaskDTO = new CustomerOperateTaskDTO();

        customerOperateTaskDTO.setTaskId(userTask.getTaskId());

        customerOperateTaskDTO.setGmtCreate(userTask.getCreateDate());
        customerOperateTaskDTO.setGmtCreateStr(DateUtil.formatTime(userTask.getCreateDate()));

        customerOperateTaskDTO.setStatus(userTask.getStatus());

        customerOperateTaskDTO.setCompleteDate(userTask.getCompleteDate());
        customerOperateTaskDTO.setCompleteDateStr(DateUtil.formatTime(userTask.getCompleteDate()));

        if (userTask.getBizData() != null && userTask.getBizData().size() > 0){

            customerOperateTaskDTO.setCustomerId(Integer.valueOf(userTask.getBizData().get("customerId").toString()));
            customerOperateTaskDTO.setCompany(userTask.getBizData().get("company").toString());

            customerOperateTaskDTO.setCustomerAmountWhenTaskCreate(Long.valueOf(userTask.getBizData().get("amountSnapshot").toString()));
        }

        if (userTask.getLocalBizData() != null && userTask.getLocalBizData().size() > 0){

            if (userTask.getLocalBizData().get("goal")!= null){
                customerOperateTaskDTO.setGoal(userTask.getLocalBizData().get("goal").toString());
            }

            if (userTask.getLocalBizData().get("amountSnapshotForTask")!= null){
                customerOperateTaskDTO.setCustomerAmountWhenTaskComplete(Long.valueOf(userTask.getLocalBizData().get("amountSnapshotForTask").toString()));
            }
        }

        return customerOperateTaskDTO;
    }
}
