package com.trtjk.youzan.controller;

import com.trtjk.youzan.utils.YouZanAPI;
import com.youzan.cloud.open.sdk.gen.v4_0_0.model.YouzanTradesSoldGetResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/youzan")
@Slf4j
public class YouZanController {

    /**
     * 获取有赞的交易订单
     * @return
     */
    @GetMapping("/list")
    public YouzanTradesSoldGetResult getYouzan(){
       return YouZanAPI.tradeOrders();
    }
}
