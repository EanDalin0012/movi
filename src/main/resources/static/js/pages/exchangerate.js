var buying = "buy";
var selling = "sell";
var note = "buy";
var sRateVal1 = "";
var sRateVal2 = "";
var index1;
var index2;
var rateval1 = 0.00;
var rateval2 = 0.00;
var final = 0;
var selectChange1;
var selectChange2;

var items = [
    {
        buying: 4100,
        code: "KHR",
        selling: 4089
    }
    ,{
        buying: 0.9027,
        code: "EUR",
        selling: 0.8807
    }
    ,{
        buying: 106.91,
        code: "JPY",
        selling: 104.81
    }
    ,{
        buying: 31.03,
        code: "THB",
        selling: 30.64
    }
    ,{
        buying: 1.40,
        code: "SGD",
        selling: 1.37
    }
    ,{
        buying: 1233.87,
        code: "KRW",
        selling: 1205.87
    }
    ,{
        buying: 7.23,
        code: "CNY",
        selling: 6.90
    }
    ,{
        buying: 23857,
        code: "VND",
        selling: 22757
    },{
        buying: 1.00,
        code: "USD",
        selling: 1.00
    }
];

console.log(items);
$(function () {
    var length = items.length;
    for (var i = 0 ; i < length; i++) {
        $("#selectChange1").append('<option value="'+items[i].code+'">'+items[i].code+'</option>');
        $("#selectChange2").append('<option value="'+items[i].code+'">'+items[i].code+'</option>');
    }

    $("#selectChange2").val("USD");
    $("#selectChange2").trigger("change");

    $("#selectChange1").val("KHR");
    $("#selectChange1").trigger("change");

    $("#rate1").val(rateval1);
    $("#rate2").val(rateval2);


    $("#btnBuy").click(function () {

        note = "buy";
       selectChange1 = $("#selectChange1").val();
       selectChange2 = $("#selectChange2").val();

       rateval1 = $("#rate1").val();

       for (var i = 0; i < items.length; i++) {
           if (items[i].code === selectChange1) {
               final = items[i].buying;
           }
       }

       for (var i = 0; i < items.length; i++) {
           if (items[i].code === selectChange2 ) {
             rateval2 = Math.round( items[i].buying * rateval1 / final * 100) / 100;
             $("#rate2").val(rateval2);
           }
       }

    });
    $("#btnSell").click(function () {
        note = "sell";
        selectChange1 = $("#selectChange1").val();
        selectChange2 = $("#selectChange2").val();
        rateval1 = $("#rate1").val();
        
        for ( var i = 0; i < items.length; i++ ) {
            if (items[i].code === selectChange1) {
                final = items[i].selling;
            }
        }

        for (var i = 0; i < items.length; i++ ) {
            if (items[i].code === selectChange2 ) {
                rateval2 = Math.round( items[i].selling * rateval1 / final * 100) / 100;
                $("#rate2").val(rateval2);
            }
        }
    });

    // rate1 key up
    $("#rate1").keyup( function (event) {
        console.log(note);
        if (items === null || items.length === 0 ){
            return;
        } else {
            if (note === "buy") {
                rateval1 = $("#rate1").val();
                selectChange1 = $("#selectChange1").val();
                selectChange2 = $("#selectChange2").val();
                console.log('rate', rateval1);
                console.log('select change 1 ', selectChange1, 'select change 1', selectChange2);

                for (var i = 0; i < items.length; i++) {
                    if (items[i].code === selectChange1){
                        final = items[i].buying;
                    }
                }
                for (var i = 0; i < items.length; i++ ) {
                    if (items[i].code === selectChange2 ) {
                        rateval2 = Math.round( items[i].buying * rateval1 / final * 100) / 100;
                        $("#rate2").val(rateval2);
                    }
                }
            } else if ( note === "sell") {
                var selectChage1 = $("#selectChange1").val();
                var selectChage2 = $("#selectChange2").val();
                rateval1 = $("#rate1").val();

                for (var i = 0; i < items.length; i++) {
                    if (items[i].code === selectChage1){
                        final = items[i].selling;
                    }
                }
                for (var i =0 ; i < items.length; i++) {
                    if (items[i].code === selectChage2 ) {
                        rateval2 = Math.round( items[i].selling * rateval1 / final * 100) / 100;
                        $("#rate2").val(rateval2);
                    }
                }
            }
        }
    });
    // rate2 key up
    $("#rate2").keyup(function () {
        if (items === null || items.length === 0 ) {
            return;
        } else  {
            if (note === "buy") {
                rateval2 = $("#rate2").val();
                selectChange1 = $("#selectChange1").val();
                selectChange2 = $("#selectChange2").val();
                
                for (var i = 0; i < items.length; i++) {
                    if (items[i].code === selectChange2) {
                        final = items[i].buying;
                    }
                } 
                
                for (var i = 0; i < items.length; i++){
                    if (items[i].code === selectChange1) {
                        rateval1 = Math.round( items[i].buying * rateval2 / final * 100) / 100;
                        $("#rate1").val(rateval1);
                    }
                } 

            } else  if (note === "sell") {
                var selectChage1 = $("#selectChange1").val();
                var selectChage2 = $("#selectChange2").val();
                rateval2 = $("#rate2").val();

                for (var i = 0; i < items.length; i++) {
                    if (items[i].code === selectChage2){
                        final = items[i].selling;
                    }
                }
                for (var i =0 ; i < items.length; i++) {
                    if (items[i].code === selectChage1 ) {
                        rateval1 = Math.round( items[i].selling * rateval2 / final * 100) / 100;
                        $("#rate1").val(rateval1);
                    }
                }
            }
        }
    });

});

function selectionChange1(event){
    index1 = 1;
    index2 = 0;
    var selectChage1 = $("#selectChange1").val();
    var selectChage2 = $("#selectChange2").val();
    rateval2 = $("#rate2").val();
    console.log('select Change rate 1', selectChage1, 'rate 2', selectChage2);

    if (items === null || items.length === 0 ){
        return
    } else {
        if ( note === "buy") {
            for (var i = 0; i < items.length; i++ ) {
                if (items[i].code === selectChage2) {
                    final = items[i].buying;
                    console.log('final', final);
                }
            }

            for (var i = 0; i < items.length; i++) {
                if (items[i].code == selectChage1){
                    rateval1 = Math.round( items[i].buying * rateval2 / final * 100) /100;
                    $("#rate1").val(rateval1);
                }
            }

        } else  if (note === "sell") {

            for (var i = 0; i < items.length; i++) {
                if (items[i].code === selectChage1){
                    final = items[i].selling;
                }
            }
            for (var i =0 ; i < items.length; i++) {
                if (items[i].code === selectChage2 ) {
                    rateval2 = Math.round( items[i].selling * rateval1 / final * 100) / 100;
                    $("#rate2").val(rateval2);
                }
            }
        }
    }
    console.log(selectChage1, selectChage2)
}


function selectionChange2(event){
    index1 = 0;
    index2 = 1;

    var selectChage1 = $("#selectChange1").val();
    var selectChage2 = $("#selectChange2").val();
    rateval1 = $("#rate1").val();
    rateval2 = $("#rate2").val();

    console.log('rate 1', selectChage1, 'rate 2', selectChage2, 'value 1', rateval1)
    if (items === null || items.length === 0 ) {
        return;
    } else {
        if (note === "buy") {
            for (var i = 0; i < items.length; i++) {
                if (items[i].code === selectChage1){
                    final = items[i].buying;
                } 
            } 
            
            for (var i = 0; i < items.length; i++) {
                if (items[i].code === selectChage2 ) {
                    rateval2 = Math.round( items[i].buying * rateval1 / final * 100) / 100;
                    $("#rate2").val(rateval2);
                    console.log(rateval2);
                }
            } 
        } else if (note === "sell"){

            for (var i = 0; i < items.length; i++) {
                if (items[i].code === selectChage2){
                    final = items[i].selling;
                }
            }
            for (var i =0 ; i < items.length; i++) {
                if (items[i].code === selectChage1 ) {
                    rateval1 = Math.round( items[i].selling * rateval2 / final * 100) / 100;
                    $("#rate1").val(rateval1);
                }
            }
        }
    }

}