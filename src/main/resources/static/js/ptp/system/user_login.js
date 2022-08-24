
var login = {
    // 主要定义对象中的函数
    module: {
        userLogin:function(){
            var user = $("#user_login").serializeArray();
            // var formobj = $.serializeObject(user);
            // alert(JSON.stringify(formobj));
            $.ajax(
                {
                    //请求地址
                    url: "/sys/user/api/login",
                    //请求方式
                    type: "post",

                    // 发送数据
                    data: user,
                    // 同步还是异步（true：异步，false：同步）
                    async: false,
                    // 请求成功的处理逻辑
                    success: function (result) {
                        if (result.code == 200){
                            // 跳转到登录页
                            window.location.href = "http://" + window.location.host + "/sys/user/page/index";
                        }else {
                            alert(result.msg)
                        }
                    },
                    // 请求失败的处理逻辑
                    error: function (e) {
                        alert(e);
                    }
                }
            );



        },
        userRegister: function () {
            var array = $("#user_register").serializeArray();
            var formObj = $.serializeObject(array);
           // alert(formObj.loginName);

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