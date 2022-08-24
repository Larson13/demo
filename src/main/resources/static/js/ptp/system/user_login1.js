
var login = {
    // 主要定义对象中的函数
    module: {
        userLogin: function () {
            // 获取页面上用户输入的数据
           var form_data =  $("#user_login").serialize();
            // 调用服务端登录接口，将数据传入到服务端
            $.ajax({
                //请求地址
                url: "/sys/user/api/login",
                //请求方式
                type: "post",
                // 发送数据
                data: form_data,
                // 同步还是异步（true：异步，false：同步）
                async: false,
                // 请求成功的处理逻辑
                success: function (result) {
                    if (result.code = 200){
                        // 跳转到首页
                        window.location.href = "http://" + window.location.host + "/sys/user/page/index";
                    }else {
                        alert(result.msg);
                    }
                },
                // 请求失败的处理逻辑
                error: function (e) {
                    alert(e);
                }
            });

        },

        userRegister: function () {
            var array = $("#user_register").serializeArray();
            var formObj = $.serializeObject(array);

            $.ajax({
                //请求地址
                url: "/sys/user/api/register",
                //请求方式
                type: "post",
                //请求的媒体类型
                contentType: "application/json;charset=UTF-8",
                // 发送数据
                data: JSON.stringify(formObj),
                // 同步还是异步（true：异步，false：同步）
                async: false,
                // 请求成功的处理逻辑
                success: function (result) {
                    if (result.code == 200){
                        // 跳转到登录页
                        window.location.href = "http://" + window.location.host + "/sys/user/page/login";
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