function getExamTypeName(index) {
    var name = "未知";
    switch (index){
    case 1:name = '周测';break;
    case 2:name = '月考';break;
    case 3:name = '模考';break;
    }
    return name;
}