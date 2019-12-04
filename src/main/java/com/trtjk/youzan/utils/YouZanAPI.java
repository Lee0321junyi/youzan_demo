package com.trtjk.youzan.utils;

import com.trtjk.youzan.config.YouZanConfig;
import com.youzan.cloud.open.sdk.api.API;
import com.youzan.cloud.open.sdk.core.client.auth.Auth;
import com.youzan.cloud.open.sdk.core.client.core.DefaultYZClient;
import com.youzan.cloud.open.sdk.core.client.core.YouZanClient;
import com.youzan.cloud.open.sdk.core.oauth.token.TokenParameter;
import com.youzan.cloud.open.sdk.gen.v4_0_0.api.YouzanTradesSoldGet;
import com.youzan.cloud.open.sdk.gen.v4_0_0.model.YouzanTradesSoldGetParams;
import com.youzan.cloud.open.sdk.gen.v4_0_0.model.YouzanTradesSoldGetResult;
import com.youzan.cloud.open.sdk.core.client.auth.Token;

public class YouZanAPI {
    /**
     * 获取有赞商铺订单的接口
     * @return
     */
    public static YouzanTradesSoldGetResult tradeOrders(){
        //查询订单的条件
        YouzanTradesSoldGetParams youzanTradesSoldGetParams = new YouzanTradesSoldGetParams();
        youzanTradesSoldGetParams.setPageNo(2);

        //请求查询订单的url地址
        API api = new YouzanTradesSoldGet();
        //将查询条件加入到请求地址
        api.setAPIParams(youzanTradesSoldGetParams);

        //查询的订单结果
        YouzanTradesSoldGetResult result = null;
        try {
            TokenParameter tokenParameter = TokenParameter.self().clientId(YouZanConfig.client_id)
                    .clientSecret(YouZanConfig.client_secret)
                    .grantId(YouZanConfig.grant_id).build();

            YouZanClient client = new DefaultYZClient();
            Auth auth = new Token(client.getOAuthToken(tokenParameter).getAccessToken());
            result = client.invoke(api,auth,YouzanTradesSoldGetResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
