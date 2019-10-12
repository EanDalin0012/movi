var buying = "buy";
var selling = "sell";
var note = "buy";
var sRateVal1 = "";
var sRateVal2 = "";

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

$(function () {
    var length = items.length;
    for (var i = 0 ; i < length; i++) {
        $("#selectRate1").append('<option value="'+items[i].code+'">'+items[i].code+'</option>');
        $("#selectRate2").append('<option value="'+items[i].code+'">'+items[i].code+'</option>');
    }

    $("#selectRate1").val("USD");
    $("#selectRate1").trigger("change");

    $("#selectRate2").val("KHR");
    $("#selectRate2").trigger("change");
    $("#amount1").html(1);
    $("#btnBuy").click(function () {
        sRateVal1 = $("#selectRate1").val();
        sRateVal2 = $("#selectRate2").val();
    });

    $("#btnBuy").click(function () {
       note = "buy";
       CalRate1();
    });
    $("#btnSell").click(function () {
        note = "sell";
        CalRate1();
    });

    $("#amount1").keyup(function () {
        CalRate1();
    });

    $("#amount1").keyup(function () {
        CalRate2();
    });
});

function CalRate1() {
    var input1 = $("#amount1").val();
    var input2 = $("#amount2").val();

    var total = 0;
    var final = 0;
    if (note == "buy") {
        if (sRateVal1 === "USD") {

            for (var i = 0; i <items.length; i++){
                if (items[i].code === sRateVal1) {
                    final = items[i].buying;
                }
            }

            for (var i = 0; i < items.length; i++) {
                if (items[i].code === sRateVal2) {
                    total = Math.round(items[i].buying * input1 * 100) / 100;
                    $("#amount2").val(total);
                    console.log(final);
                }
            }

        } else if (sRateVal2 === "USD") {

            for (var i = 0; i < items.length; i++) {
               if(items[i].code === sRateVal2) {
                   final = items[i].buying;
                   console.log("final", final);
               }
            }

            for (var i = 0; i < items.length; i++) {
                if(items[i].code === sRateVal1) {
                    total = Math.round(items[i].buying * input1 / final * 100) /100;
                    $("#amount2").val(total);
                    console.log('sRate val 2 usd jkllk', total, final, items[i].buying, input1);
                }
            }

        }

    } else if (note == "sell") {

        console.log( typeof $("#selectRate2").val());
        console.log('sell');
        if ($("#selectRate1").val() == "USD") {

            for (var i = 0; i < items.length; i++) {
                if (items[i].code === sRateVal2) {
                    final = items[i].selling;
                    var amount1 = $("#amount1").val();
                    var total = Math.round(final * amount1 * 100) / 100;
                    $("#amount2").val(total);
                    console.log(final);
                }
            }

        }

    } else if ( $("#selectRate2").val() == "USD" ) {

        console.log('dkla', $("#selectRate2").val());
        for (var i = 0; i < items.length; i++) {
            if (items[i].code === sRateVal1) {
                final = items[i].selling;
                var amount1 = $("#amount1").val();
                var total = Math.round( final * amount1 * 100) / 100;
                $("#amount1").val(total);
                console.log(final, total);
            }
        }

    }
    console.log(sRateVal1, sRateVal2, items)
}

function  CalRate2() {
    
}
