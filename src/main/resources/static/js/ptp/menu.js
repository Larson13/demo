var menu = {

    module: {

        init: function () {
            $.ajax({
                //请求地址
                url: "/sys/menu/api/getMenuList",
                //请求方式
                type: "get",
                // 发送数据
                data: null,
                // 同步还是异步（true：异步，false：同步）
                async: false,
                // 请求成功的处理逻辑
                success: function (result) {
                    // 生成动态的菜单HTML
                    menu.module.generateMenuHtml(result.data);
                },
                // 请求失败的处理逻辑
                error: function (e) {
                    alert(e);
                }
            });
        },

        generateMenuHtml: function (menuList) {
            // 定义保存所有li的字符串变量
            var allLiHtmls = "";
            // 遍历menuList
            $.each(menuList, function (i, n) {
                // 动态生成一级菜单li
                var firstLiHtml = '<li><a><i class="fa fa-home"></i> '+ n.menuName +'<span class="fa fa-chevron-down"></span></a>';
                var ulHtml = '<ul class="nav child_menu">';
                // 遍历二级菜单，动态生成二级菜单li
                if (n.subMenuList != null){
                    $.each(n.subMenuList, function (ii, nn) {
                        var secondLiHtml = '<li><a href="'+ nn.locationUrl +'">'+ nn.menuName +'</a></li>';
                        ulHtml += secondLiHtml;
                    })
                }
                ulHtml += '</ul>';
                firstLiHtml += ulHtml + '</li>';
                allLiHtmls += firstLiHtml;
            })
            // 更新到页面中
            $("#subMenu").html(allLiHtmls);
        }
    }
}

menu.module.init();