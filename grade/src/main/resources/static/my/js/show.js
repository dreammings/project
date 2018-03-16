window.page = 1;//第一页
window.per_page = 10;//每页10条
window.exam_type = 0;//全部类型
window.sequence = 2;//倒序
// jQuery(function($) {
//     var oTable1 = $('#sample-table-2').dataTable( {
//         "aoColumns": [
//             { "bSortable": false },
//             null, null,null, null, null,
//             { "bSortable": false }
//         ] } );
//
//
//     $('table th input:checkbox').on('click' , function(){
//         var that = this;
//         $(this).closest('table').find('tr > td:first-child input:checkbox')
//             .each(function(){
//                 this.checked = that.checked;
//                 $(this).closest('tr').toggleClass('selected');
//             });
//
//     });
//
//
//     $('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});
//     function tooltip_placement(context, source) {
//         var $source = $(source);
//         var $parent = $source.closest('table')
//         var off1 = $parent.offset();
//         var w1 = $parent.width();
//
//         var off2 = $source.offset();
//         var w2 = $source.width();
//
//         if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
//         return 'left';
//     }
// })
function getScoreList() {
    var type = exam_type;
    // 请求后台
    $.ajax({
        url: "show",
        type: "GET", // 默认为GET,你可以根据需要更改
        cache: true, // 默认为true,但对于script,jsonp类型为false,可以自行设置
        data: {// 将请求参数放这里.
            type: type,
            // sort: sort_where, start_time: start_time, end_time: end_time,
            sequence: sequence, page: page, per_page: per_page
        },
        dataType: "json", // 指定想要的数据类型
        // jsonp: "callback", // 指定回调处理JSONP类型的请求
        // statusCode: { // 如果你想处理各状态的错误的话
        //     404: handler404,
        //     500: handler500
        // },
        success:function (data) {
            var code = data.code;
            var tbBody = ""
            //对返回值进行判断
            if(code != 200){
                alert(data.msg);
            }else{
                var scoreList = data.data.list;
                $.each(scoreList, function(i, score) {
                    tbBody += "<tr>"
                        // + "<td class='center'>"
                        //     + "<label>"
                        //         +"<input type='checkbox' class='ace'/>"
                        //         +"<span class='lbl'>" + "</span>"
                        //     + "</label>"
                        // + "</td>"
                        + "<td>" + getExamTypeName(score.type) + "</td>"
                        + "<td>" + score.date + "</td>"
                        + "<td>" + score.chinese + "</td>"
                        + "<td>" + score.maths + "</td>"
                        + "<td>" + score.english + "</td>"
                        + "<td>" + score.politics + "</td>"
                        + "<td>" + score.history + "</td>"
                        + "<td>" + score.geography + "</td>"
                        + "<td>" + score.synthesize + "</td>"
                        + "<td>" + score.total_points + "</td>"
                        + "</tr>";
                    // $("#iframeid").attr("src","show");
                    // alert(tbBody);
                });
                $("#score-list").html(tbBody);
                $("#page_total").text("总条数："+ data.data.total);
            }
        }
    });
}
// $(document).ready(function(e) {
//     getScoreList();
// });
$(document).ready(function(e) {
    getScoreList();
    // $("#per_page ul li").click();
});

$("#per_page ul li").click(function () {
    var i = $(this).index();
    var t_page = $("#per_page ul li").eq(1).children("a");
    if(i==0){
        page = page-1;
        if(page<1){
            page = 1;
        }
    }else if(i==2){
        page = page+1;
    }
    // var text= t_page.text();
    t_page.text(page);
    getScoreList();
})
