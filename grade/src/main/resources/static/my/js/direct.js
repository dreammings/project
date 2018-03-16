$(function () {
    // alert("haha");
    var height=$(".sidebar").height();
    // alert(height);
    // var height=$("#iframeId").contents().find("body").height() + 30;
    // alert(height);
    $("#iframeid").height(height-100);
    // $("#iframeId").load(function () {
    //     alert("haha");
    //     var mainheight = $(this).contents().find("body").height() + 30;
    //     $(this).height(mainheight);
    // });
})

$(function () {
    $("#nav-list li").click(function(){
        var i = $(this).index();
        $("#nav-list").each(function (index) {
            // alert($(this).attr("class"));
            if ($(this).index()!=i){
                $(this).removeClass("active");
                // alert($(this).attr("class"));
            }else{
                $(this).addClass("active");
                // alert($(this).attr("class"));
            }
        })
        if(i==0){
            // alert($("#iframeid").attr("src"));
            $("#iframeid").attr("src","scanner_page");
            // alert($("#iframeid").attr("src"));
            // $("#iframeid").attr("src","tables")
        }
        if(i==1){
            // $("#iframeid").attr("src","show");
            $("#iframeid").attr("src","show_page");
            // var getDate = getScoreList();
        }
        if(i==2){
            $("#iframeid").attr("src","statistics_page");
        }
        var address= $(this).children("a").text();
        $(".breadcrumb li").eq(1).html(address);
        // $("nav nav-list li").removeClass("class名字，多个class用空格分开");
        // $(this).addClass("class名字，多个class用空格分开");
        // if($(this).index()!=0){
        //     $("#submenu").hide();
        // }else{
        //     $("#submenu").show();
        // }
    })
})

$(function () {
})
