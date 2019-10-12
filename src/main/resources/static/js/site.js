var selectedIndex = 0;
$(function () {
    var arrActiveSet = [
        "#dashboard"
        ,"#setting"
    ];
    var index = arrActiveSet.length;
    for (var i = 0; i<index; i++){
        $( ""+arrActiveSet[i]+"").removeClass( "active" );
    }
    $(""+arrActiveSet[selectedIndex]+"").addClass( "active" );
});

