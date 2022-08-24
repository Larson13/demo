var project = {

    module: {
        addOrUpdate: function () {
            var accessLoadtestContent = $("#accessLoadtestContent").val();
            var accessOnlineContent = $("#accessOnlineContent").val();
            if ($.isNullObj(accessLoadtestContent) && $.isNullObj(accessOnlineContent)) {
                alert("压测环境地址/线上环境地址至少配置一个");
                return;
            }
            var fromArray = $("#form").serializeArray();
            var data = $.serializeObject(fromArray);
            var accessParams= [];

            if(!$.isNullObj(accessLoadtestContent)){
                var onloadObj = {};
                onloadObj["accessEnv"] = 1
                onloadObj["accessContent"] = accessLoadtestContent;
                accessParams.push(onloadObj);
            }
            if(!$.isNullObj(accessOnlineContent)){
                var onlineObj = {};
                onlineObj["accessEnv"] = 1
                onlineObj["accessContent"] = accessOnlineContent;
                accessParams.push(onlineObj);
            }
            data.accessParams =JSON.stringify(accessParams);
            $.ajax({
                //请求地址
                url: "/basic/project/api/addOrUpdate",
                //请求方式
                type: "post",
                //请求的媒体类型
                contentType: "application/json;charset=UTF-8",
                // 发送数据
                data: JSON.stringify(data),
                // 同步还是异步（true：异步，false：同步）
                async: false,
                // 请求成功的处理逻辑
                success: function (result) {
                    if (result.code == 200){
                        // 跳转到登录页
                        alert("保存成功")
                       $("#projectModal").modal('hide');
                    }else {
                        alert(result.msg)
                    }
                },
                // 请求失败的处理逻辑
                error: function (e) {
                    alert(e);
                }
            });

        }
    }

}
