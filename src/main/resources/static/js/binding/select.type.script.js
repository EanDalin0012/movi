/**
 * 
 */
var selectOptionType ='<select class="form-control" id ="select-type">';

$(function() {
	$.ajax({
	    type: "GET",
	    url: "/@m!n/api/type/getlist",
//	    data:{"data":"check"},
	    contentType: "application/json",
        dataType: "json",
	    success: function(data) {
	        if (data) {
	        	var datalength = data.length;
	        	var option = '';
	        	
	        	for(var i= 0; i<datalength; i++) {
	        		option += '<option value = "'+data[i].id+'">'+data[i].name+'</option>';
	        	}
	        	
	        	selectOptionType += option +'</select>';
	        }
	        else {
	            console.log(data);
	        }
	    }, error: function(data){
            console.log(data);
        },
	});
	
});