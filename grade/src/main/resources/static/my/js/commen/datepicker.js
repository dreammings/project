//页面加载事件
$(document).ready(function(e) {
    //日期控件初始化
    fillDatepicker();
})
//获取当前日期
function show(){
    var mydate = new Date();
    var str = mydate.getFullYear() + "-" + (mydate.getMonth()+1) + "-" + mydate.getDate();
    return str;
}
//日期控件
function fillDatepicker() {
    $(".exam-time").datepicker({//添加日期选择功能
        numberOfMonths:1,//显示几个月
        showButtonPanel:true,//是否显示按钮面板
        dateFormat: 'yy-mm-dd',//日期格式
        clearText:"清除",//清除日期的按钮名称
        closeText:"关闭",//关闭选择框的按钮名称
        yearSuffix: '年', //年的后缀
        showMonthAfterYear:true,//是否把月放在年的后面
        defaultDate: show(),//默认日期
        minDate:'1970-01-01',//最小日期
        maxDate: show(),//最大日期
        monthNames: ['01月','02月','03月','04月','05月','06月','07月','08月','09月','10月','11月','12月'],
        dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],
        dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],
        dayNamesMin: ['日','一','二','三','四','五','六'],
    });
}