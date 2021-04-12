package com.jchen.community.controller;

import com.jchen.community.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * 统计网站数据的表现层
 * @Auther: jchen
 * @Date: 2021/04/03/15:16
 */
@Controller
public class DataController {

    @Autowired
    private DataService dataService;

    // 统计页面
    @RequestMapping(path = "/data", method = {RequestMethod.GET, RequestMethod.POST})
    public String getDataPage() {
        return "/site/admin/data";
    }

    /**
     * 统计时间范围内的网站UV
     * @param start 开始时间
     * @param end 结束时间
     * @param model
     * @return 注意，此处要使用转发不能使用重定向，因为在data页面，
     * 统计了UV后我们还要统计DAU，所以要把request转发到data页面，如果重定向，那么其他的逻辑不能复用request。
     */
    @RequestMapping(path = "/data/uv", method = RequestMethod.POST)
    public String getUV(@DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
                        @DateTimeFormat(pattern = "yyyy-MM-dd") Date end, Model model) {
        long uv = dataService.calculateUV(start, end);
        model.addAttribute("uvResult", uv);
        model.addAttribute("uvStartDate", start);
        model.addAttribute("uvEndDate", end);

        //return "site/admin/data";  这个是返回模板

        //这个是声明当前的方法只请求一半，还有另外个方法处理其他的一半，就是说可以复用其他的逻辑
        //所以前面的path = "/data"，这个方法就得支持两种post和get请求，这里post请求才能用forward
        return "forward:/data";
    }

    /**
     * 统计时间范围内的活跃用户
     * @param start
     * @param end
     * @param model
     * @return
     */
    @RequestMapping(path = "/data/dau", method = RequestMethod.POST)
    public String getDAU(@DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
                         @DateTimeFormat(pattern = "yyyy-MM-dd") Date end, Model model) {
        long dau = dataService.calculateDAU(start, end);
        model.addAttribute("dauResult", dau);
        model.addAttribute("dauStartDate", start);
        model.addAttribute("dauEndDate", end);
        return "forward:/data";
    }

}