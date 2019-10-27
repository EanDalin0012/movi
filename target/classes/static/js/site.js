var selectedIndex = 0;
var erText = 'Required';
var er = '<i class="fa fa-warning"></i><span class="box-title">'+erText+'</span>';
$(function () {
    var arrActiveSet = [
        "#dashboard"
        ,"#setting"
        ,"#movi"
    ];
    var index = arrActiveSet.length;
    for (var i = 0; i<index; i++){
        $( ""+arrActiveSet[i]+"").removeClass( "active" );
    }
    $(""+arrActiveSet[selectedIndex]+"").addClass( "active" );

    $('.top').find("input[type=search]")
        {
            if (!$(this).val()) {
                $(this).attr("placeholder", "Type your answer here");
            }
        }
});


$(function () {
    $("#movi").click( function () {
        window.location.href = "/@m!n/movi/";
    });
})

