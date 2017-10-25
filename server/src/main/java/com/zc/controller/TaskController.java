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

import com.zc.biz.customer.domain.model.Customer;
import com.zc.biz.customer.domain.service.param.CustomerQueryCondition;
import com.zc.biz.customer.service.CustomerService;
import com.zc.controller.dto.AjaxResult;
import com.zc.controller.dto.CustomerOperateTaskDTO;
import com.zc.controller.dto.GridAjaxResult;
import com.zc.controller.dto.converter.CustomerOperateTaskConverter;
import com.zc.controller.param.CustomerOperateTaskQueryParam;
import com.zc.utils.ListUtil;
import com.zc.workflow.model.ProcessFlow;
import com.zc.workflow.model.UserTask;
import com.zc.workflow.service.WorkflowService;
import com.zc.workflow.service.param.TaskQueryCondition;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
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

    @RequestMapping("/pendingTasks")
    public String pendingTasks() {
        return "/task/pendingTasks";
    }

    @ResponseBody
    @RequestMapping("/deleteTasks")
    public AjaxResult<Boolean> deleteTasks(@RequestParam(value = "taskIds[]") String[] taskIds) {

        if (taskIds == null || taskIds.length == 0) {
            return AjaxResult.unSuccess("ILLEGAL_PARAM");
        }

        return AjaxResult.success(workflowService.deleteTasks(Arrays.asList(taskIds)));
    }

    @ResponseBody
    @RequestMapping("/completeTasks")
    public AjaxResult<Boolean> completeTasks(@RequestParam(value = "taskIds[]") String[] taskIds) {
        if (taskIds == null || taskIds.length == 0) {
            return AjaxResult.unSuccess("ILLEGAL_PARAM");
        }

        Arrays.stream(taskIds).forEach(x -> {

            UserTask userTask = workflowService.getById(x);

            if (userTask == null){
                return;
            }

            int customerId = userTask.getBizData() == null || userTask.getBizData().get("customerId") == null ?
                0 : Integer.valueOf(userTask.getBizData().get("customerId").toString());

            if (customerId < 0){
                return;
            }

            Customer customer = customerService.queryById(customerId);

            if (customer == null){
                return;
            }

            workflowService.completeTask(x, new HashMap() {{
                put("amountSnapshotForTask", customer.getBalance());
            }});
        });

        return AjaxResult.success(true);
    }

    @ResponseBody
    @RequestMapping("/updateGoal")
    public AjaxResult<Boolean> updateGoal(@RequestParam(value = "taskIds[]") String[] taskIds, String goal) {
        if (taskIds == null || taskIds.length == 0 || StringUtils.isBlank(goal)) {
            return AjaxResult.unSuccess("ILLEGAL_PARAM");
        }

        Arrays.stream(taskIds).forEach(taskId -> {
            workflowService.updateTaskLocalBizData(taskId, new HashMap() {{
                put("goal", goal);
            }});
        });

        return AjaxResult.success(true);
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

        if (param.getCustomerId() > 0){
            condition.setBizDataSearchCondition(new HashMap(){{
                put("customerId", param.getCustomerId());
            }});
        }

        List<UserTask> tasks = workflowService.pageQueryTaskBy(condition);

        Long count = workflowService.countTask(condition);

        return GridAjaxResult.success(count, ListUtil.convert(tasks, CustomerOperateTaskConverter::toDTO));
    }

    @ResponseBody
    @RequestMapping("/pagedQueryAll")
    public GridAjaxResult<CustomerOperateTaskDTO> pagedQueryAll(@Valid CustomerOperateTaskQueryParam param,
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

        if (param.getCustomerId() > 0){
            condition.setBizDataSearchCondition(new HashMap(){{
                put("customerId", param.getCustomerId());
            }});
        }

        List<UserTask> tasks = workflowService.pageQueryHistoryTaskBy(condition);

        Long count = workflowService.countHistoryTask(condition);

        return GridAjaxResult.success(count, ListUtil.convert(tasks, CustomerOperateTaskConverter::toDTO));
    }

    @ResponseBody
    @RequestMapping("/addCustomerOperateTask")
    public AjaxResult<Boolean> addCustomerOperateTask(@RequestParam(value = "customerIds[]") Integer[] customerIds,
                                                      String goal) {

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

            bizData.put("taskType", "customerOperate");
            bizData.put("customerId", c.getId());
            bizData.put("company", c.getCompany());
            bizData.put("amountSnapshot", c.getBalance());

            Map<String, Object> taskBizData = new HashMap<>();
            taskBizData.put("goal", goal);
            taskBizData.put("status", "PENDING");

            // 更新业务数据
            taskIds.parallelStream().forEach(id -> {
                workflowService.updateTaskBizData(id, bizData);
                workflowService.updateTaskLocalBizData(id, taskBizData);
            });
        });

        return AjaxResult.success(Boolean.TRUE);
    }

}
