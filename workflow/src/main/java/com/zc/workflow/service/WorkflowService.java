package com.zc.workflow.service;

import com.zc.workflow.model.*;
import com.zc.workflow.service.param.TaskQueryCondition;

import java.util.List;
import java.util.Map;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/10/17 22:31 1.0.0
 */
public interface WorkflowService {

    ProcessFlow startProcessFlow(String processName);

    List<UserTask> queryTaskBy(TaskQueryCondition taskQueryCondition);

    List<UserTask> pageQueryTaskBy(TaskQueryCondition taskQueryCondition);

    long countTask(TaskQueryCondition taskQueryCondition);

    boolean completeTask(String taskId);

    boolean updateTaskBizData(String taskId, Map<String, Object> bizData);

    boolean claimTask(String taskId, int userId);

    boolean batchClaimTask(List<String> taskIds, int userId);

    boolean deleteTasks(List<String> taskIds);

}
