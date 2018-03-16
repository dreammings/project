window.subject_type = 'total_points';
window.exam_type = 0;
function fillEcharts(result) {
    var date = result.date;
    var subject = result.subject;
    // 基于准备好的dom，初始化echarts实例
    // var myChart = echarts.init(${"echarts-statistics"}});
    var myChart = echarts.init(document.getElementById('echarts-statistics'));
    // 指定图表的配置项和数据
    option = {
        //表头
        title: {
            text: '成绩走势图',
            subtext: '分数'
        },
        tooltip: {
            trigger: 'axis'
        },
        //说明
        // legend: {
        //     data:['最高气温','最低气温']
        // },
        //工具栏
        toolbox: {
            show: true,
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                dataView: {readOnly: false},
                magicType: {type: ['line', 'bar']},
                restore: {},
                saveAsImage: {}
            }
        },
        //横坐标
        xAxis:  {
            type: 'category',
            boundaryGap: false,
            // data: ['周一','周二','周三','周四','周五','周六','周日']
            data: date
        },
        //纵坐标
        yAxis: {
            type: 'value',
            axisLabel: {
                formatter: '{value}'
            }
        },
        series: [
            {
                // name:'最高分',
                type:'line',
                // data:[11, 11, 15, 13, 12, 13, 10],
                data:subject,
                markPoint: {
                    data: [
                        {type: 'max', name: '最大值'},
                        {type: 'min', name: '最小值'}
                    ]
                },
                markLine: {
                    data: [
                        {type: 'average', name: '平均值'}
                    ]
                }
            }
        ]
    };


    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}

//选择考试类型
function selectExamType() {
    exam_type = $(this).index();
    var text= $(this).children("a").text();
    $("#exam-type").text(text);
}
function getStatistic() {
    //统计科目
    var subject = subject_type;
    //开始时间
    var start_time = $("#begin_date").val();
    //结束时间
    var end_time = $("#end_date").val();
    // 请求后台
    $.ajax({
        url: "statistics",
        type: "GET", // 默认为GET,你可以根据需要更改
        cache: true, // 默认为true,但对于script,jsonp类型为false,可以自行设置
        data: {// 将请求参数放这里.
            type: exam_type,subject:subject,start_time: start_time, end_time: end_time
        },
        dataType: "json", // 指定想要的数据类型
        // jsonp: "callback", // 指定回调处理JSONP类型的请求
        // statusCode: { // 如果你想处理各状态的错误的话
        //     404: handler404,
        //     500: handler500
        // },
        success:function (data) {
            var code = data.code;
            //对返回值进行判断
            if(code != 200){
                alert(data.msg);
            }else{
                fillEcharts(data.data)
            }
        }
    });
}
$(document).ready(function(e) {
    $("#search").click();
});

$("#search").click(function () {
    getStatistic();
})
$(function () {
    $("#subject-type-menu li").click(function () {
        subject_type = $(this).attr("name");
        var text= $(this).children("a").text();
        $("#subject-type").text(text);
    })
})
//下拉菜单选择事件
$(function () {
    $("#exam-type-menu li").click(selectExamType);
})