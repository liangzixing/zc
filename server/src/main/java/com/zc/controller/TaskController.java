/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.alibaba.fastjson.JSON;

import com.zc.biz.customer.domain.model.Customer;
import com.zc.biz.customer.domain.service.param.CustomerQueryCondition;
import com.zc.biz.customer.service.CustomerService;
import com.zc.controller.dto.AjaxResult;
import com.zc.controller.dto.CustomerOperateTaskDTO;
import com.zc.controller.dto.GridAjaxResult;
import com.zc.controller.dto.converter.CustomerOperateTaskConverter;
import com.zc.controller.param.CustomerOperateTaskAddDTO;
import com.zc.controller.param.CustomerOperateTaskQueryParam;
import com.zc.utils.ListUtil;
import com.zc.workflow.model.ProcessFlow;
import com.zc.workflow.model.UserTask;
import com.zc.workflow.service.WorkflowService;
import com.zc.workflow.service.param.TaskQueryCondition;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/10/17 22:27 1.0.0
 */
@RequestMapping("/task")
@Controller
public class TaskController extends BaseController {

    @Resource
    private WorkflowService workflowService;

    @Resource
    private CustomerService customerService;

    @RequestMapping("/myTasks")
    public String myTasks() {
        return "/task/myTasks";
    }

    @ResponseBody
    @RequestMapping("/pagedQuery")
    public GridAjaxResult<CustomerOperateTaskDTO> pagedQuery(@Valid CustomerOperateTaskQueryParam param,
                                                             BindingResult bindingResult) {

        TaskQueryCondition condition = new TaskQueryCondition();

        if (param.getUserId() > 0) {
            condition.setUserId(param.getUserId());
        } else {
            condition.setUserId(getLoginUserId());
        }

        condition.setPageStart(param.getCurrentPage());
        condition.setPageSize(param.getPageSize());
        condition.setCreateDateBegin(param.getTaskCreateBegin());
        condition.setCreateDateEnd(param.getTaskCreateEnd());

        List<UserTask> tasks = workflowService.pageQueryTaskBy(condition);

        Long count = workflowService.countTask(condition);

        return GridAjaxResult.success(count, ListUtil.convert(tasks, CustomerOperateTaskConverter::toDTO));
    }

    @ResponseBody
    @RequestMapping("/addCustomerOperateTask")
    public AjaxResult<Boolean> addCustomerOperateTask(@RequestParam(value = "customerIds[]")Integer[] customerIds, String goal) {

        CustomerQueryCondition queryCondition = new CustomerQueryCondition();
        queryCondition.setIds(Arrays.asList(customerIds));

        List<Customer> customers = customerService.query(queryCondition);

        int userId = getLoginUserId();

        customers.parallelStream().forEach(c -> {

            // 创建流程
            ProcessFlow flow = workflowService.startProcessFlow("consumerOperateProcess");

            TaskQueryCondition condition = new TaskQueryCondition();
            condition.setProcessFlowId(flow.getId());

            // 依据流程 id 查询任务
            List<UserTask> tasks = workflowService.queryTaskBy(condition);

            List<String> taskIds = ListUtil.collect(tasks, UserTask::getTaskId);

            // 设定处理人
            workflowService.batchClaimTask(ListUtil.collect(tasks, UserTask::getTaskId), userId);

            Map<String, Object> bizData = new HashMap<>();

            bizData.put("customerId", c.getId());
            bizData.put("company", c.getCompany());
            bizData.put("amountSnapshot", c.getBalance());

            bizData.put("goal", goal);

            // 更新业务数据
            taskIds.parallelStream().forEach(id -> workflowService.updateTaskBizData(id, bizData));
        });

        return AjaxResult.success(Boolean.TRUE);
    }

}
