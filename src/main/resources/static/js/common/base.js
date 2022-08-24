var bigdata_rest = "http://" + location.hostname + ":8089";
//var bigdata_web = "http://" + window.location.host;
var security_rest = "http://10.58.75.125:8085";
var web_topApiRequests = "/static/gentelella/production/api.html";

/** 获取chart类型数组极值 */
function searchExtremum(ratioArr) {
    var minIndex = 0;
    var maxIndex = 0;
    for (var j = 1; j < ratioArr.length; j++) {
        if (ratioArr[j][1] < ratioArr[minIndex][1]) {
            minIndex = j;
        } else if (ratioArr[j][1] >= ratioArr[maxIndex][1]) {// 取最后一个最大点(相等情况)
            maxIndex = j;
        }
    }
    return new Array(minIndex, maxIndex);
}

function getUrlParms() {
    var args = new Object();
    var query = location.search.substring(1);
    var pairs = query.split("&");
    for (var i = 0; i < pairs.length; i++) {
        var pos = pairs[i].indexOf('=');
        if (pos == -1)   continue;
        var argname = pairs[i].substring(0, pos);
        var value = pairs[i].substring(pos + 1);
        args[argname] = decodeURIComponent(value);
    }
    return args;
}

function loadFormData(jsonStr) {
    var obj = eval(jsonStr);
    var key, value, tagName, type, arr;
    for (x in obj) {
        key = x;
        value = obj[x];
        $("[name='" + key + "'],[name='" + key + "[]']").each(function () {
            tagName = $(this)[0].tagName;
            type = $(this).attr('type');
            if (tagName == 'INPUT') {
                if (type == 'radio') {
                    $(this).attr('checked', $(this).val() == value);
                } else if (type == 'checkbox') {
                    value = value + '';
                    arr = value.split(',');
                    for (var i = 0; i < arr.length; i++) {
                        if ($(this).val() == arr[i]) {
                            $(this).attr('checked', true);
                            break;
                        }
                    }
                } else {
                    $(this).val(value);
                }
            } else if (tagName == 'SELECT' || tagName == 'TEXTAREA') {
                $(this).val(value);
            } else {
                $(this).html(value);
            }
        });
    }
}
function datePickerUtil(selector,fn){
	var date_config={
			format:'YYYY-MM-DD HH:mm:ss', //(string) date/time格式
			separator:"到",// (string) 分隔符
			singleDatePicker: true,
			parentEl:'body',
			timePicker: true, //是否显示time选择
			timePickerIncrement: 1 ,//time选择递增数单位分钟
			timePicker12Hour: false, // (boolean) 是否12小时制
			opens: 'right' ,//(string: 'left'/'right') 显示在元素左边还是右边
			startDate:"" ,//(Date object, moment object or string) 起始时间
			endDate:"" ,//(Date object, moment object or string) 结束时间
			minDate:"" ,//(Date object, moment object or string) 可选最早时间
			maxDate:"",//(Date object, moment object or string) 可选最迟时间
	        buttonClasses: ['btn btn-default'],
	        applyClass: 'btn-small btn-primary',
	        cancelClass: 'btn-small',
	        ranges: {},
	        locale: {
	            applyLabel: '查询',
	            cancelLabel: '取消',
	            fromLabel: '开始',
	            toLabel: '结束',
	            customRangeLabel: '自定义',
	            daysOfWeek: ["日", "一", "二", "三", "四", "五", "六"],
	            monthNames: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
	            firstDay: 1
	        }
			
		}
	return {
		datePickerObj:$('#'+selector).data('daterangepicker'),
		datePickerInit:$('#'+selector).daterangepicker(date_config,fn),
	}
}
