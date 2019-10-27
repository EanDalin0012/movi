/**
 * 
 */
var selectOptionMovi ='';
var selectOptionMoviList;
$(function() {
	$.ajax({
	    type: "GET",
	    url: "/@m!n/api/movitype/getmovitypelist",
//	    data:{"data":"check"},
	    contentType: "application/json",
        dataType: "json",
	    success: function(data) {
	    	console.log(data);
	        if (data) {
                selectOptionMoviList = data;
	        	var datalength = data.length;
	        	var option = '<select class="form-control" id ="select-movi">';
	        	
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