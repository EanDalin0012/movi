/**
 * 
 */
var selectOptionMovi ='';

$(function() {
	$.ajax({
	    type: "GET",
	    url: "/@m!n/movitype/getlistmovitype",
//	    data:{"data":"check"},
	    contentType: "application/json",
        dataType: "json",
	    success: function(data) {
	        if (data) {
	        	var datalength = data.length;
	        	var option = '<select class="form-control" id ="optionMovi">';
	        	
	        	for(var i= 0; i<datalength; i++) {
	        		option += '<option value = "'+data[i].id+'">'+data[i].name+'</option>';
	        	}
	        	
	        	selectOptionMovi = option +'</select>';
	        }
	        else {
	            console.log(data);
	        }
	    }, error: function(data){
            console.log(data);
        },
	});
	
});