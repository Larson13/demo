var menu = {

    module: {

        init: function () {
            $.ajax({
                //请求地址
                url: "/sys/menu/api/list",
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
            // 定义保存所有li的字符串变量
            var allLiHtmls = "";
            $.each(menuList, function (i, n) {
                var fistHtml = '<li><a><i class="fa fa-home"></i> ' + n.menuName + '<span class="fa fa-chevron-down"></span></a>';
                var uHtml = '<ul class="nav child_menu">';
                $.each(n.subMenuList, function (j, k) {
                    var subHtml = '  <li><a href="' + k.locationUrl + '" >' + k.menuName + '</a></li>';
                    uHtml+= subHtml
                })
                uHtml += '</ul>';
                fistHtml += uHtml + '</li>';
                allLiHtmls += fistHtml;
            })
            // alert(allLiHtmls);
            // 更新到页面中
            $("#subMenu").html(allLiHtmls);
        }
    }
}

menu.module.init();