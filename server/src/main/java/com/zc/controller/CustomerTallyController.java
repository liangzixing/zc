/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.google.common.io.Files;
import java.util.List;
import com.zc.biz.customer.domain.model.CustomerTally;
import com.zc.biz.customer.domain.service.CustomerTallyDomainService;
import com.zc.biz.customer.domain.service.param.CustomerTallyQueryCondition;
import com.zc.biz.customer.service.CustomerTallyService;
import com.zc.controller.dto.AjaxResult;
import com.zc.controller.dto.CustomerTallyDTO;
import com.zc.controller.dto.GridAjaxResult;
import com.zc.controller.dto.converter.CustomerTallyDTOConverter;
import com.zc.controller.param.CustomerTallyEditDTO;
import com.zc.exception.BusinessException;
import com.zc.result.PagedResult;
import com.zc.utils.DateUtil;
import com.zc.utils.MD5Util;
import com.zc.utils.NumberUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/16 15:19 1.0.0
 */
@Controller
@RequestMapping("/customerTally")
public class CustomerTallyController extends BaseController {

    @Resource
    private CustomerTallyService customerTallyService;

    @Resource
    private CustomerTallyDomainService customerTallyDomainService;

    @Value("${image.save.root.path}")
    public String imgSaveRootPath;

    @RequestMapping("/addPage")
    public String addPage() {
        return "/customerTally/addPage";
    }

    @RequestMapping("/editPage")
    public String editPage(@RequestParam Integer id, Model model) {

        CustomerTally customerTally = customerTallyDomainService.queryById(id);

        model.addAttribute("customerTallyDTO", CustomerTallyDTOConverter.toDTO(customerTally));

        return "/customerTally/editPage";
    }

    @RequestMapping("/listPage")
    public String listPage() {
        return "/customerTally/listPage";
    }

    @ResponseBody
    @RequestMapping("/pagedQuery")
    public GridAjaxResult<CustomerTallyDTO> pagedQuery(@Valid CustomerTallyQueryCondition condition,
                                                       BindingResult bindingResult) {

        CustomerTallyQueryCondition customerTallyQueryCondition = new CustomerTallyQueryCondition();

        customerTallyQueryCondition.setCustomerId(condition.getCustomerId());
        customerTallyQueryCondition.setIds(condition.getIds());
        customerTallyQueryCondition.setReportDateBegin(condition.getReportDateBegin());
        customerTallyQueryCondition.setReportDateEnd(condition.getReportDateEnd());

        PagedResult<CustomerTally> queryResult = customerTallyDomainService.pagedQuery(customerTallyQueryCondition);

        return GridAjaxResult.success(queryResult.getTotal(), CustomerTallyDTOConverter.toDTOs(queryResult.getData()));
    }

    @ResponseBody
    @RequestMapping("/add")
    public AjaxResult<Boolean> add(@Valid CustomerTallyEditDTO customerTallyEditDTO, BindingResult bindingResult) {

        String imageUrl = saveImage(customerTallyEditDTO.getCustomerId(), customerTallyEditDTO.getFile());

        CustomerTally customerTally = new CustomerTally();

        customerTally.setCustomerId(customerTallyEditDTO.getCustomerId());
        customerTally.setAmount(customerTallyEditDTO.getAmount());
        customerTally.setFromAccountType(customerTallyEditDTO.getFromAccountType());
        customerTally.setFromAccount(customerTallyEditDTO.getFromAccount());
        customerTally.setToAccountType(customerTallyEditDTO.getToAccountType());
        customerTally.setToAccount(customerTallyEditDTO.getToAccount());
        customerTally.setCredentialsImgUrl(imageUrl);
        customerTally.setReporterName(getLoginUserName());
        customerTally.setReportDate(new Date());
        customerTally.setReporterId(getLoginUserId());
        customerTally.setDescription(customerTallyEditDTO.getDescription());

        customerTally.setType(customerTallyEditDTO.getType());
        customerTally.setDisplay("normal");

        int id = customerTallyService.insert(customerTally, getLoginUserName());

        return AjaxResult.success(id > 0);
    }

    private String saveImage(Integer customerId, MultipartFile file) {
        if (file == null || file.isEmpty() || NumberUtil.isNotPositive(customerId)) {
            return null;
        }

        String filePath = new StringBuffer("/customerTally")
            .append(File.separator)
            .append(customerId)
            .append(File.separator)
            .append(DateUtil.format(new Date(), DateUtil.DATA_PATTON_YYYYMMDD))
            .append(File.separator)
            .append(MD5Util.getMD5to16(Files.getNameWithoutExtension(file.getOriginalFilename())))
            .append(".")
            .append(Files.getFileExtension(file.getOriginalFilename()))
            .toString();

        String fileSavePath = imgSaveRootPath + File.separator + filePath;

        File dest = new File(fileSavePath);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
            return filePath;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("SAVE IMAGE ERROR, PLEASE TRY AGAIN");
        }
    }

    @ResponseBody
    @RequestMapping("/edit")
    public AjaxResult<Boolean> edit(@Valid CustomerTallyEditDTO customerTallyEditDTO, BindingResult bindingResult) {

        String imageUrl = saveImage(customerTallyEditDTO.getCustomerId(), customerTallyEditDTO.getFile());

        CustomerTally customerTally = new CustomerTally();

        customerTally.setId(customerTallyEditDTO.getId());
        customerTally.setFromAccountType(customerTallyEditDTO.getFromAccountType());
        customerTally.setFromAccount(customerTallyEditDTO.getFromAccount());
        customerTally.setToAccountType(customerTallyEditDTO.getToAccountType());
        customerTally.setToAccount(customerTallyEditDTO.getToAccount());
        customerTally.setCredentialsImgUrl(imageUrl);
        customerTally.setDescription(customerTallyEditDTO.getDescription());

        int updateCount = customerTallyDomainService.update(customerTally, getLoginUserName());

        return AjaxResult.success(updateCount > 0);
    }

    @ResponseBody
    @RequestMapping("/export")
    public void export(@Valid CustomerTallyQueryCondition condition,
                       BindingResult bindingResult, HttpServletResponse response) throws IOException {

        condition.setCurrentPage(1);
        condition.setPageSize(1000);

        GridAjaxResult<CustomerTallyDTO> result = pagedQuery(condition, bindingResult);

        List<CustomerTallyDTO> customerTallyDTOS = result.getRows();

        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // 下载文件的默认名称
        response.setHeader("Content-Disposition", "attachment;filename=tally.xls");

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), CustomerTallyDTO.class, customerTallyDTOS);
        workbook.write(response.getOutputStream());
    }

}
