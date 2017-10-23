/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.view;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.context.Context;
import org.apache.velocity.tools.Scope;
import org.apache.velocity.tools.ToolboxFactory;
import org.apache.velocity.tools.config.ToolboxConfiguration;
import org.apache.velocity.tools.config.XmlFactoryConfiguration;
import org.apache.velocity.tools.view.ViewToolContext;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.view.velocity.VelocityLayoutView;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/18 13:44 1.0.0
 */
public class VelocityLayoutToolboxView extends VelocityLayoutView {

    private VelocityLayoutToolboxView() {}

    /**
     * 加载velocitytool。能加载上特别的不容易
     */
    @Override
    protected Context createVelocityContext(Map<String, Object> model, HttpServletRequest request,
                                            HttpServletResponse response) throws Exception {
        ViewToolContext ctx = new ViewToolContext(this.getVelocityEngine(), request, response,
            this.getServletContext());
        if (this.getToolboxConfigLocation() != null) {
            XmlFactoryConfiguration factory = new XmlFactoryConfiguration();
            factory.read(ResourceUtils.getURL(this.getToolboxConfigLocation()).openStream());// 这个地方和配置中心的缺一不可、
            ToolboxFactory toolboxFactory = factory.createFactory();
            toolboxFactory.configure(factory);
            Collection<ToolboxConfiguration> toolboxes = factory.getToolboxes();
            for (ToolboxConfiguration tc : toolboxes) {
                ctx.addToolbox(toolboxFactory.createToolbox(tc.getScope()));// 这样操作后就可以用工具里面的东西了。
            }

            if (!toolboxFactory.hasTools(Scope.REQUEST)) {
                ctx.addToolbox(toolboxFactory.createToolbox(
                    Scope.REQUEST));
            }
            if (!toolboxFactory.hasTools(Scope.APPLICATION)) {
                ctx.addToolbox(toolboxFactory.createToolbox(
                    Scope.APPLICATION));
            }
            if (!toolboxFactory.hasTools(Scope.SESSION)) {
                ctx.addToolbox(toolboxFactory.createToolbox(
                    Scope.SESSION));
            }
        }
        if (model != null && !model.isEmpty()) {
            ctx.putAll(model);
        }

        return ctx;
    }

}
