window.exam_type = 0;
//选择考试类型
function selectExamType() {
    exam_type = $(this).index();
    var text= $(this).children("a").text();
    $("#exam-type").text(text);
}
//表单验证
function verifyDate() {
    var flag = true;
    if(exam_type==0){
        flag = false;
        $(".btn-group").next().removeClass("hide");
        return false;
    }else{
        $(".btn-group").next().addClass("hide");
        flag = true;
    }
    $(".input-sm").each(function () {
        var input = $(this).val();
        if(input==""){
            flag = false;
            $(this).next().removeClass("hide");
            return false;
        }else{
            $(this).next().addClass("hide");
            var type = $(this).attr("type");
            if(type=="number" && (input<0 || input>200)){
                $(this).next().next().removeClass("hide");
                flag = false;
                return false;
            }else{
                $(this).next().next().addClass("hide");
                flag = true;
            }
        }
    });
    return flag;
}
//成绩添加
function addScore() {
    var flag = verifyDate();
    if(!flag){
        return ;
    }
    //考试类型
    var type = exam_type;
    //考试时间
    var time = $("#exam-time").val();
    //语文
    var chinese = $("#chinese").val();
    //数学
    var maths = $("#maths").val();
    //英语
    var english = $("#english").val();
    //政治
    var politics = $("#politics").val();
    //历史
    var history = $("#history").val();
    //地理
    var geography = $("#geography").val();
    //请求后台
    $.ajax({
        url: "insert",
        type: "GET", // 默认为GET,你可以根据需要更改
        cache: true, // 默认为true,但对于script,jsonp类型为false,可以自行设置
        data: {// 将请求参数放这里.
            type: type, time: time,
            chinese: chinese, maths: maths,
            english: english, politics: politics,
            history: history, geography: geography,
        },
        dataType: "json", // 指定想要的数据类型
        // jsonp: "callback", // 指定回调处理JSONP类型的请求
        // statusCode: { // 如果你想处理各状态的错误的话
        //     404: handler404,
        //     500: handler500
        // },
        success: function (data) {
            var code = data.code;
            var msg = data.msg;
            alert(msg);
            //对返回值进行判断
            if (code == 200) {
                $("#iframeid", window.parent.document).attr("src", "show_page");
            }
        }
    })
}
//提交按钮点击事件
$(function () {
    $("#commit").click(addScore);
})
//下拉菜单选择事件
$(function () {
    $("#exam-type-menu li").click(selectExamType);
})