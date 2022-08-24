/** 时间戳转换 */
function renderTimestamp(value, pattern) {
    if (value == undefined) {
        return "";
    }
    if (!pattern) {
        pattern = "yyyy-MM-dd HH:mm:ss";
    }
    return formatDate(new Date(parseInt(value)), pattern);
};

function renderDate(value) {
    if (value == undefined) {
        return "";
    }
    var JsonDateValue = new Date(value.time);
    return formatDate(JsonDateValue, "yyyy-MM-dd");
};
/**
 * 转换日期
 * @param value java2json date object
 * @param pattern yyyy-MM-dd HH:mm:ss
 * @return
 */
function renderDateTime(value, pattern) {
    if (value == undefined) {
        return "";
    }
    var JsonDateValue = new Date(value.time);
    //若传入pattern或者pattern为空
    if (typeof pattern == "string") {
        if ($.trim(pattern) == "") {
            return formatDate(JsonDateValue, "yyyy-MM-dd HH:mm");
        }
        return formatDate(JsonDateValue, pattern);
    }
    return formatDate(JsonDateValue, "yyyy-MM-dd HH:mm");
};

/**
 * 对给定的日期date增加指定的月数
 * @param date
 * @param day
 */
function addMonthToDate(d, month) {
    var m = d.getMonth();
    m = m + month;
    d.setMonth(m);
    return d;
}

/**
 * 对给定的日期date增加指定的天数
 * @param date
 * @param day
 */
function addDayToDate(date, day) {
    var d = date.getDate();
    d = d + day;
    date.setDate(d);
    return date;
}

/**
 * 对给定的日期date增加指定的分钟
 * @param date
 * @param day
 */
function addMinutesToDate(date, m) {
    var d = date.getMinutes();
    d = d + m;
    date.setMinutes(d);
    return date;
}

//获取完全的时间
function renderIntegralTime(value, pattern) {
    if (value == undefined) {
        return "";
    }
    var JsonDateValue = new Date(value.time);
    //若传入pattern或者pattern为空
    if (typeof pattern == "string") {
        if ($.trim(pattern) == "") {
            return formatDate(JsonDateValue, "yyyy-MM-dd HH:mm:ss");
        }
        return formatDate(JsonDateValue, pattern);
    }
    return formatDate(JsonDateValue, "yyyy-MM-dd HH:mm:ss");
};

var MONTH_NAMES = new Array('一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月', 'Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec');
var DAY_NAMES = new Array('星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六', '周日', '周一', '周二', '周三', '周四', '周五', '周六');
function LZ(x) {
    return (x < 0 || x > 9 ? "" : "0") + x;
}
//------------------------------------------------------------------
//formatDate (date_object, format)
//Returns a date in the output format specified.
//The format string uses the same abbreviations as in getDateFromFormat()
//------------------------------------------------------------------
function formatDate(date, format) {
    format = format + "";
    var result = "";
    var i_format = 0;
    var c = "";
    var token = "";
    var y = date.getYear() + "";
    var M = date.getMonth() + 1;
    var d = date.getDate();
    var E = date.getDay();
    var H = date.getHours();
    var m = date.getMinutes();
    var s = date.getSeconds();
    var yyyy, yy, MMM, MM, dd, hh, h, mm, ss, ampm, HH, H, KK, K, kk, k;
    // Convert real date parts into formatted versions
    var value = new Object();
    if (y.length < 4) {
        y = "" + (y - 0 + 1900);
    }
    value["y"] = "" + y;
    value["yyyy"] = y;
    value["yy"] = y.substring(2, 4);
    value["M"] = M;
    value["MM"] = LZ(M);
    value["MMM"] = MONTH_NAMES[M - 1];
    value["NNN"] = MONTH_NAMES[M + 11];
    value["d"] = d;
    value["dd"] = LZ(d);
    value["E"] = DAY_NAMES[E + 7];
    value["EE"] = DAY_NAMES[E];
    value["H"] = H;
    value["HH"] = LZ(H);
    if (H == 0) {
        value["h"] = 12;
    }
    else if (H > 12) {
        value["h"] = H - 12;
    }
    else {
        value["h"] = H;
    }
    value["hh"] = LZ(value["h"]);
    if (H > 11) {
        value["K"] = H - 12;
    } else {
        value["K"] = H;
    }
    value["k"] = H + 1;
    value["KK"] = LZ(value["K"]);
    value["kk"] = LZ(value["k"]);
    if (H > 11) {
        value["a"] = "PM";
    }
    else {
        value["a"] = "AM";
    }
    value["m"] = m;
    value["mm"] = LZ(m);
    value["s"] = s;
    value["ss"] = LZ(s);
    while (i_format < format.length) {
        c = format.charAt(i_format);
        token = "";
        while ((format.charAt(i_format) == c) && (i_format < format.length)) {
            token += format.charAt(i_format++);
        }
        if (value[token] != null) {
            result = result + value[token];
        }
        else {
            result = result + token;
        }
    }
    return result;
}


function splitDate(d, isZero) {
    var yyyy, MM, dd, hh, mm, ss;
    if (isZero) {
        yyyy = d.getFullYear();
        MM = (d.getMonth() + 1) < 10 ? "0" + (d.getMonth() + 1) : d.getMonth() + 1;
        dd = d.getDate() < 10 ? "0" + d.getDate() : d.getDate();
        hh = d.getHours() < 10 ? "0" + d.getHours() : d.getHours();
        mm = d.getMinutes() < 10 ? "0" + d.getMinutes() : d.getMinutes();
        ss = d.getSeconds() < 10 ? "0" + d.getSeconds() : d.getSeconds();
    } else {
        yyyy = d.getFullYear();
        MM = d.getMonth() + 1;
        dd = d.getDate();
        hh = d.getHours();
        mm = d.getMinutes();
        ss = d.getSeconds();
    }
    return {"yyyy": yyyy, "MM": MM, "dd": dd, "hh": hh, "mm": mm, "ss": ss};
}


/**
 * 得到某年得月最后一天
 * @param year
 * @param month
 * @returns
 */
function getLastDay(year, month) {
    var new_year = year;    //取当前的年份
    var new_month = month++;//取下一个月的第一天，方便计算（最后一天不固定）
    if (month > 12)            //如果当前大于12月，则年份转到下一年
    {
        new_month -= 12;        //月份减
        new_year++;            //年份增
    }
    var newnew_date = new Date(new_year, new_month, 1);                //取当年当月中的第一天
    return (new Date(newnew_date.getTime() - 1000 * 60 * 60 * 24)).getDate();//获取当月最后一天日期
}

/**
 * 字符串传换成date类型
 * @str {string}字符串格式表示的日期，格式为：yyyy-mm-dd
 * @return {Date}由str转换得到的Date对象
 */
function str2date(str) {
    var re = /^(\d{4})\S(\d{1,2})\S(\d{1,2})$/;
    var dt;
    if (re.test(str)) {
        dt = new Date(RegExp.$1, RegExp.$2 - 1, RegExp.$3);
    }
    return dt;
}

/**
 * 获取当月的最后一天
 */
function getLastDay(year, month) {
    var new_year = year;    //取当前的年份
    var new_month = ++month;//取下一个月的第一天，方便计算（最后一天不固定）
    if (month > 12) {           //如果当前大于12月，则年份转到下一年
        new_month -= 12;        //月份减
        new_year++;            //年份增
    }
    var new_date = new Date(new_year, new_month, 1);                //取当年当月中的第一天
    return (new Date(new_date.getTime() - 1000 * 60 * 60 * 24));//获取当月最后一天日期
}
