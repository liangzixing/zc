/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.workflow.service.impl;

import java.util.List;
import java.util.Map;

import com.zc.utils.ListUtil;
import com.zc.utils.NumberUtil;
import com.zc.workflow.model.ProcessFlow;
import com.zc.workflow.model.UserTask;
import com.zc.workflow.service.WorkflowService;
import com.zc.workflow.service.param.TaskQueryCondition;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/10/17 22:39 1.0.0
 */
@Service
public class WorkFlowServiceImpl implements WorkflowService {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Override
    public ProcessFlow startProcessFlow(String processName) {

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processName);

        ProcessFlow processFlow = new ProcessFlow();

        processFlow.setId(processInstance.getId());
        processFlow.setName(processInstance.getBusinessKey());

        return processFlow;
    }

    @Override
    public List<UserTask> pageQueryTaskBy(TaskQueryCondition taskQueryCondition) {
        TaskQuery taskQuery = buildTaskQuery(taskQueryCondition);

        int start = (taskQueryCondition.getPageStart() - 1)*taskQueryCondition.getPageSize();

        return ListUtil.skipNullConvert(taskQuery.listPage(start,
            start + taskQueryCondition.getPageSize() -1),
            this::convertToUserTask);
    }

    @Override
    public long countTask(TaskQueryCondition taskQueryCondition) {
        TaskQuery taskQuery = buildTaskQuery(taskQueryCondition);
        return taskQuery.count();
    }

    @Override
    public List<UserTask> queryTaskBy(TaskQueryCondition taskQueryCondition) {

        TaskQuery taskQuery = buildTaskQuery(taskQueryCondition);

        return ListUtil.skipNullConvert(taskQuery.list(), this::convertToUserTask);
    }

    private TaskQuery buildTaskQuery(TaskQueryCondition taskQueryCondition) {
        TaskQuery taskQuery = taskService.createTaskQuery();

        taskQuery.orderByTaskCreateTime().desc();

        taskQuery.includeProcessVariables();

        if (StringUtils.isNotBlank(taskQueryCondition.getProcessFlowId())) {
            taskQuery.processInstanceId(taskQueryCondition.getProcessFlowId());
        }

        if (NumberUtil.isPositive(taskQueryCondition.getUserId())) {
            taskQuery.taskAssignee(String.valueOf(taskQueryCondition.getUserId()));
        }

        if (taskQueryCondition.getCreateDateBegin() != null){
            taskQuery.taskCreatedBefore(taskQueryCondition.getCreateDateBegin());
        }

        if (taskQueryCondition.getCreateDateEnd() != null){
            taskQuery.taskCreatedAfter(taskQueryCondition.getCreateDateEnd());
        }

        return taskQuery;
    }

    private UserTask convertToUserTask(Task t) {
        UserTask userTask = new UserTask();

        userTask.setTaskId(t.getId());

        userTask.setBizData(t.getProcessVariables());

        userTask.setLocalBizData(t.getTaskLocalVariables());

        return userTask;
    }

    @Override
    public boolean completeTask(String taskId) {

        taskService.complete(taskId);

        return true;
    }

    @Override
    public boolean updateTaskBizData(String taskId, Map<String, Object> bizData) {

        taskService.setVariables(taskId, bizData);

        return true;
    }

    @Override
    public boolean claimTask(String taskId, int userId) {
        taskService.claim(taskId, String.valueOf(userId));
        return true;
    }

    @Override
    public boolean batchClaimTask(List<String> taskIds, int userId) {
        taskIds.parallelStream().forEach(x -> taskService.claim(x, String.valueOf(userId)));
        return true;
    }

    @Override
    public boolean deleteTasks(List<String> taskIds) {

        taskService.deleteTasks(taskIds);

        return true;
    }
}
