/**
 * 
 */
$(function() {
	
	$("#mainmoviadd").click(function(){
    	var mainmoviadd = '<script src="/js/binding/uploadimg.script.js"></script>'
    		+ '<form>'
    		// start form
    		
    		// start row
    		+ '<div class="form-row">'
    		
    		+ '<div class="form-group col-md-6"> ' 
	    		+ '<label for="inputEmail4">Title</label>'
	    		+ '<input type="text" class="form-control" id="title" placeholder="Email">'
    		+ '</div>'
    		
    		+ '<div class="form-group col-md-6">'
	    		+ '<label for="inputPassword4">Type</label>'
	    		+ selectOptionType
    		+ '</div>'
    		
    		+ '</div>'
    		// end row
    		
    		// start row
    		+ '<div class="form-row">'
    		
    		+ '<div class="form-group col-md-6"> ' 
	    		+ '<label for="inputEmail4">Movie</label>'
	    		+ selectOptionMovi
    		+ '</div>'
    		
    		+ '<div class="form-group col-md-6">'
	    		+ '<label for="inputPassword4">Description</label>'
	    		+ '<textarea class="form-control is-invalid" id="validationTextarea" placeholder="Required example textarea" required></textarea>'
    		+ '</div>'
    		
    		+ '</div>'
    		// end row
    		// stat row
    		
    		+ ' <div class="form-row"> '    
            	+ ' <div class="col-md-12" style= "margin-bottom: 15px;">  '
            		//    <!-- image-preview-filename input [CUT FROM HERE]-->
            		+ '  <div class="input-group image-preview"> '
	            		+ '  <input type="text" class="form-control image-preview-filename" disabled="disabled"> '
	            		+ '  <span class="input-group-btn"> '
		            		//     <!-- image-preview-clear button -->
		            		+ '  <button type="button" class="btn btn-default image-preview-clear" style="display:none;"> '
		            			+ ' <span class="glyphicon glyphicon-remove"></span> Clear '
		            		+ ' </button> '
		            		//             <!-- image-preview-input -->
		            		+ ' <div class="btn btn-default image-preview-input"> '
			            		+ ' <span class="glyphicon glyphicon-folder-open"></span> '
			            		+ '  <span class="image-preview-input-title">Browse</span> '
			            		+  ' <input type="file" accept="image/png, image/jpeg, image/gif" name="input-file-preview"/>'
		            		+ ' </div> '
	            		+ ' </span> '
            		+ ' </div> '
	           +  ' </div> '
           + ' </div> '
        
    		// end row
    		
    		
    		// end form
    		+ '</form>';
    	
    	BootstrapDialog.show({
            title: 'Add Main Movies',
            message: mainmoviadd,
            closable: true,
            closeByBackdrop: false,
            closeByKeyboard: false,
            buttons: [
            	{
            		icon: 'glyphicon glyphicon-download-alt',
                    label: 'Save',
                    cssClass: 'btn-save bg-aqua',
                    action: function(dialogRef){
                    	toDoPostDataMainMovi();
                    }
            	},{
            	icon: 'glyphicon glyphicon-ban-circle',
                label: 'Close',
                cssClass: 'btn-close bg-red',
                action: function(dialogRef){
                    dialogRef.close();
                	}
            	}
            ]
        });
    	
	});
	
});

function toDoPostDataMainMovi() {
	
	var addmainmovi = {}
	addmainmovi["title"] = $("#title").val();
	addmainmovi["title"] = $("#optionMovi").val();
	addmainmovi["title"] = $("#optionType").val();
	addmainmovi["description"] = $("#validationTextarea").val();

	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/api/search",
		data: JSON.stringify(addmainmovi), // convert array to JSON
		dataType: 'json',
		cache: false,
		timeout: 100000,
		success: function (data) {

			console.log("SUCCESS : ", data);

		},
		error: function (e) {

			console.log("ERROR : ", e);

		}
	});
	
}
