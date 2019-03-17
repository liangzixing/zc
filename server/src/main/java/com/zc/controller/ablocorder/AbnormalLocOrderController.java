package com.zc.controller.ablocorder;

import com.alibaba.fastjson.JSON;
import com.zc.biz.logistics.domain.model.AblLocOrderOperateLog;
import com.zc.biz.logistics.domain.model.AbnormalLocOrder;
import com.zc.biz.logistics.service.AbLocOrderOperateLogReadService;
import com.zc.biz.logistics.service.AbnormalLocOrderReadService;
import com.zc.biz.logistics.service.AbnormalLocOrderWriteService;
import com.zc.biz.logistics.service.param.AbLocOrderOPLogQueryParam;
import com.zc.biz.logistics.service.param.AbnormalLocOrderCreateParam;
import com.zc.biz.logistics.service.param.AbnormalLocOrderQueryParam;
import com.zc.biz.logistics.service.param.AbnormalLocOrderUpdateParam;
import com.zc.controller.BaseController;
import com.zc.controller.ablocorder.param.AbLocOrderCreateParamVO;
import com.zc.controller.ablocorder.param.AbLocOrderQueryParamVO;
import com.zc.controller.ablocorder.param.AbLocOrderUpdateParamVO;
import com.zc.controller.ablocorder.vo.AbnormalLocOrderVO;
import com.zc.controller.dto.AjaxResult;
import com.zc.controller.dto.GridAjaxResult;
import com.zc.result.PagedResult;
import com.zc.utils.DateUtil;
import com.zc.utils.NumberUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/abnormal/loc/order")
public class AbnormalLocOrderController extends BaseController {

    @Resource
    private AbnormalLocOrderWriteService abnormalLocOrderWriteService;

    @Resource
    private AbnormalLocOrderReadService abnormalLocOrderReadService;

    @Resource
    private AbLocOrderOperateLogReadService abLocOrderOperateLogReadService;

    @RequestMapping("/list")
    public String list() {
        return "abLocOrder/listPage";
    }

    @ResponseBody
    @RequestMapping("/createAbLocOrder")
    public AjaxResult<Long> createAbLocOrder(AbLocOrderCreateParamVO createParamVO) {
        if (createParamVO == null || StringUtils.isBlank(createParamVO.getOutBizOrderNO())
            || StringUtils.isBlank(createParamVO.getAbnormalType())) {
            return AjaxResult.unSuccess("ILLEGAL_PARAM");
        }

        try {

            AbnormalLocOrderCreateParam param = new AbnormalLocOrderCreateParam();

            BeanUtils.copyProperties(createParamVO, param);

            param.setOutBizType("ALIPAY_TMALL_ORDER");
            param.setOutLocCompany("YUAN_TONG");
            param.setOperatorId(getLoginUserId());
            param.setOperatorName(getLoginUserName());

            return AjaxResult.success(abnormalLocOrderWriteService.createOrder(param));

        } catch (Exception e) {
            log.error("CREATE_ABNORMAL_LOC_ORDER_ERROR|{}", JSON.toJSONString(createParamVO), e);
            return AjaxResult.unSuccess(e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping("/updateAbLocOrder")
    public AjaxResult<Boolean> updateAbLocOrder(AbLocOrderUpdateParamVO updateParamVO) {
        if (updateParamVO == null || NumberUtil.isNotPositive(updateParamVO.getId())) {
            return AjaxResult.unSuccess("ILLEGAL_PARAM");
        }

        try {

            AbnormalLocOrderUpdateParam param = new AbnormalLocOrderUpdateParam();

            BeanUtils.copyProperties(updateParamVO, param);

            param.setOutLocCompany("YUAN_TONG");
            param.setCurrentUserId(getLoginUserId());
            param.setCurrentUserName(getLoginUserName());

            return AjaxResult.success(abnormalLocOrderWriteService.updateCreateOrder(param));

        } catch (Exception e) {
            log.error("UPDATE_ABNORMAL_LOC_ORDER_ERROR|{}", JSON.toJSONString(updateParamVO), e);
            return AjaxResult.unSuccess(e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping("/deleteAbLocOrder")
    public AjaxResult<Boolean> deleteAbLocOrder(Long locOrderId) {
        if (NumberUtil.isNotPositive(locOrderId)) {
            return AjaxResult.unSuccess("ILLEGAL_PARAM");
        }

        try {

            return AjaxResult.success(abnormalLocOrderWriteService.deleteUpdateOrder(locOrderId, getLoginUserName()));

        } catch (Exception e) {
            log.error("DELETE_ABNORMAL_LOC_ORDER_ERROR|{}", locOrderId, e);
            return AjaxResult.unSuccess(e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping("/pagedQueryAbLocOrder")
    public GridAjaxResult<AbnormalLocOrder> pagedQueryAbLocOrder(AbLocOrderQueryParamVO queryParamVO) {

        AbnormalLocOrderQueryParam param = new AbnormalLocOrderQueryParam();

        BeanUtils.copyProperties(queryParamVO, param);

        if (NumberUtil.isPositive(queryParamVO.getCreateDateBegin())) {
            param.setCreateDateBegin(new Date(queryParamVO.getCreateDateBegin()));
        }

        if (NumberUtil.isPositive(queryParamVO.getCreateDateEnd())) {
            param.setCreateDateEnd(new Date(queryParamVO.getCreateDateEnd()));
        }

        PagedResult<AbnormalLocOrder> result = abnormalLocOrderReadService.pagedQuery(param);

        return GridAjaxResult.success(result.getTotal(), result.getData());
    }

    @RequestMapping("/exportAbLocOrder")
    public void exportAbLocOrder(AbLocOrderQueryParamVO queryParamVO, HttpServletResponse response) throws IOException {

        AbnormalLocOrderQueryParam param = new AbnormalLocOrderQueryParam();

        BeanUtils.copyProperties(queryParamVO, param);

        if (NumberUtil.isPositive(queryParamVO.getCreateDateBegin())) {
            param.setCreateDateBegin(new Date(queryParamVO.getCreateDateBegin()));
        }

        if (NumberUtil.isPositive(queryParamVO.getCreateDateEnd())) {
            param.setCreateDateEnd(new Date(queryParamVO.getCreateDateEnd()));
        }

        List<AbnormalLocOrder> orders = abnormalLocOrderReadService.batchQuery(param);

        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // 下载文件的默认名称
        response.setHeader("Content-Disposition",
            "attachment;filename= " + DateUtil.getCurrentDateStr() + "-abnormal-loc-order.xls");

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), AbnormalLocOrderVO.class, orders);

        workbook.write(response.getOutputStream());
    }

    @ResponseBody
    @RequestMapping("/pagedQueryAbLocOrderOPLog")
    public GridAjaxResult<AblLocOrderOperateLog> pagedQueryAbLocOrderOPLog(Long locOrderId, int currentPage,
                                                                           int pageSize) {
        if (NumberUtil.isNotPositive(locOrderId)) {
            return GridAjaxResult.unSuccess("ILLEGAL_PARAM");
        }

        AbLocOrderOPLogQueryParam param = new AbLocOrderOPLogQueryParam();

        param.setAbLocOrderId(locOrderId);
        param.setCurrentPage(currentPage);
        param.setPageSize(pageSize);

        PagedResult<AblLocOrderOperateLog> result = abLocOrderOperateLogReadService.pagedQuery(param);

        return GridAjaxResult.success(result.getTotal(), result.getData());
    }

    @ResponseBody
    @RequestMapping("/queryAbLocOrderOPLog")
    public AjaxResult<List<AblLocOrderOperateLog>> queryAbLocOrderOPLog(Long locOrderId) {
        if (NumberUtil.isNotPositive(locOrderId)) {
            return AjaxResult.unSuccess("ILLEGAL_PARAM");
        }

        AbLocOrderOPLogQueryParam param = new AbLocOrderOPLogQueryParam();

        param.setAbLocOrderId(locOrderId);

        List<AblLocOrderOperateLog> result = abLocOrderOperateLogReadService.batchQuery(param);

        return AjaxResult.success(result);
    }

}
