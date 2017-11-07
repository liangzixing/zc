/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.workflow.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zc.utils.ListUtil;
import com.zc.utils.NumberUtil;
import com.zc.workflow.model.ProcessFlow;
import com.zc.workflow.model.UserTask;
import com.zc.workflow.service.WorkflowService;
import com.zc.workflow.service.param.TaskQueryCondition;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
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

    @Autowired
    private HistoryService historyService;

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

        int start = (taskQueryCondition.getPageStart() - 1) * taskQueryCondition.getPageSize();

        return ListUtil.skipNullConvert(taskQuery.listPage(start,
            start + taskQueryCondition.getPageSize() - 1),
            this::convertToUserTask);
    }

    @Override
    public long countTask(TaskQueryCondition taskQueryCondition) {
        TaskQuery taskQuery = buildTaskQuery(taskQueryCondition);
        return taskQuery.count();
    }

    @Override
    public UserTask getById(String taskId) {
        return this.convertToUserTask(taskService.createTaskQuery().taskId(taskId)
            .includeProcessVariables()
            .includeTaskLocalVariables()
            .singleResult());
    }

    @Override
    public List<UserTask> pageQueryHistoryTaskBy(TaskQueryCondition taskQueryCondition) {

        int start = (taskQueryCondition.getPageStart() - 1) * taskQueryCondition.getPageSize();

        List<HistoricTaskInstance> queryResult = buildHistoryTaskQuery(taskQueryCondition).listPage(start,
            start + taskQueryCondition.getPageSize() - 1);

        return ListUtil.convert(queryResult, this::convertToUserTask);
    }

    private HistoricTaskInstanceQuery buildHistoryTaskQuery(TaskQueryCondition taskQueryCondition) {

        HistoricTaskInstanceQuery taskQuery = historyService.createHistoricTaskInstanceQuery();

        taskQuery.orderByTaskCreateTime().desc();

        taskQuery.includeProcessVariables();
        taskQuery.includeTaskLocalVariables();

        if (StringUtils.isNotBlank(taskQueryCondition.getProcessFlowId())) {
            taskQuery.processInstanceId(taskQueryCondition.getProcessFlowId());
        }

        if (NumberUtil.isPositive(taskQueryCondition.getUserId())) {
            taskQuery.taskAssignee(String.valueOf(taskQueryCondition.getUserId()));
        }

        if (taskQueryCondition.getCreateDateEnd() != null) {
            taskQuery.taskCreatedBefore(taskQueryCondition.getCreateDateEnd());
        }

        if (taskQueryCondition.getCreateDateBegin() != null) {
            taskQuery.taskCreatedAfter(taskQueryCondition.getCreateDateBegin());
        }

        if (taskQueryCondition.getBizDataSearchCondition() != null
            && taskQueryCondition.getBizDataSearchCondition().size() > 0){
            taskQueryCondition.getBizDataSearchCondition().forEach((k, v) -> {
                taskQuery.processVariableValueEquals(k, v);
            });
        }

        if (taskQueryCondition.getLocalBizDataSearchCondition() != null
            && taskQueryCondition.getLocalBizDataSearchCondition().size() > 0){
            taskQueryCondition.getLocalBizDataSearchCondition().forEach((k, v) -> {
                taskQuery.taskVariableValueEquals(k, v);
            });
        }

        return taskQuery;
    }

    public UserTask convertToUserTask(HistoricTaskInstance historicTaskInstance) {
        if (historicTaskInstance == null){
            return null;
        }

        UserTask userTask = new UserTask();

        userTask.setCreateDate(historicTaskInstance.getCreateTime());
        userTask.setLocalBizData(historicTaskInstance.getTaskLocalVariables());
        userTask.setBizData(historicTaskInstance.getProcessVariables());
        userTask.setTaskId(historicTaskInstance.getId());

        userTask.setCompleteDate(historicTaskInstance.getEndTime());

        userTask.setStatus(historicTaskInstance.getTaskLocalVariables() != null ? String.valueOf(historicTaskInstance.getTaskLocalVariables().get("status")) : null);

        return userTask;
    }

    @Override
    public long countHistoryTask(TaskQueryCondition taskQueryCondition) {
        return buildHistoryTaskQuery(taskQueryCondition).count();
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

        taskQuery.includeTaskLocalVariables();

        if (StringUtils.isNotBlank(taskQueryCondition.getProcessFlowId())) {
            taskQuery.processInstanceId(taskQueryCondition.getProcessFlowId());
        }

        if (NumberUtil.isPositive(taskQueryCondition.getUserId())) {
            taskQuery.taskAssignee(String.valueOf(taskQueryCondition.getUserId()));
        }

        if (taskQueryCondition.getCreateDateEnd() != null) {
            taskQuery.taskCreatedBefore(taskQueryCondition.getCreateDateEnd());
        }

        if (taskQueryCondition.getCreateDateBegin() != null) {
            taskQuery.taskCreatedAfter(taskQueryCondition.getCreateDateBegin());
        }

        if (taskQueryCondition.getBizDataSearchCondition() != null
            && taskQueryCondition.getBizDataSearchCondition().size() > 0){
            taskQueryCondition.getBizDataSearchCondition().forEach((k, v) -> {
                taskQuery.processVariableValueEquals(k, v);
            });
        }

        if (taskQueryCondition.getLocalBizDataSearchCondition() != null
            && taskQueryCondition.getLocalBizDataSearchCondition().size() > 0){
            taskQueryCondition.getLocalBizDataSearchCondition().forEach((k, v) -> {
                taskQuery.taskVariableValueEquals(k, v);
            });
        }

        return taskQuery;
    }

    private UserTask convertToUserTask(Task t) {
        if (t == null){
            return null;
        }

        UserTask userTask = new UserTask();

        userTask.setTaskId(t.getId());
        userTask.setBizData(t.getProcessVariables());
        userTask.setLocalBizData(t.getTaskLocalVariables());
        userTask.setCreateDate(t.getClaimTime());
        userTask.setStatus(t.getTaskLocalVariables() != null ? String.valueOf(t.getTaskLocalVariables().get("status")) : null);

        return userTask;
    }

    private static  Map<String, Object> successStatus = new HashMap() {{
        put("status", "COMPLETE");
    }};

    @Override
    public boolean completeTask(String taskId, Map<String, Object> localBizData) {

        localBizData.putAll(successStatus);

        taskService.complete(taskId, localBizData, true);

        return true;
    }

    @Override
    public boolean updateTaskBizData(String taskId, Map<String, Object> bizData) {
        taskService.setVariables(taskId, bizData);
        return true;
    }

    @Override
    public boolean updateTaskLocalBizData(String taskId, Map<String, Object> localBizData) {
        taskService.setVariablesLocal(taskId, localBizData);
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

    private static  Map<String, Object> deleteStatus = new HashMap() {{
        put("status", "DELETE");
    }};

    @Override
    public boolean deleteTasks(List<String> taskIds) {

        taskIds.parallelStream().forEach(taskId ->
            taskService.complete(taskId, deleteStatus, true)
        );

        return true;
    }
}
