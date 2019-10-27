/**
 * 
 */
$(function() {
    var mainmoviadd = "";

	$("#movi-add").click(function(){
    	 mainmoviadd = '<script src="/js/binding/uploadimg.script.js"></script>'

    		// start form
    		
    		// start row
    		+ '<div class="form-row">'
    		
    		+ '<div class="form-group col-md-6"> ' 
	    		+ '<label for="inputEmail4">Title</label>'
	    		+ '<input type="text" class="form-control" id="title" placeholder="Required title">'
			 	+ '<div class="error" id = "error-title">'

             	+ '</div>'
    		+ '</div>'
    		
    		+ '<div class="form-group col-md-6">'
	    		+ '<label for="inputPassword4">Movi</label>'
             + selectOptionMovi
             + '<div class="error"> </div>'

    		+ '</div>'
    		
    		+ '</div>'
    		// end row
    		
    		// start row
    		+ '<div class="form-row">'
    		
    		+ '<div class="form-group col-md-6"> ' 
	    		+ '<label for="inputEmail4">Type</label>'
             	+ selectOptionType
    		+ '</div>'

             + '<div class="form-group col-md-6"> '
             + '<label for="inputEmail4">Order</label>'
             + '<input type="text" class="form-control" id="order" placeholder="Please input Order">'
             + '</div>'
    		
    		+ '</div>'
    		// end row

             // start row
             + '<div class="form-row">'
             + '<div class="form-group col-md-12">'
             + '<label for="inputPassword4">Description</label>'
             + '<input type="text" class="form-control" id="validationTextarea" placeholder="Required example textarea" required>'
             + '</div>'

             + '</div>'
             // end row

    		// stat row
    		
    		+ ' <div class="form-row"> '
			 + ' <form method="POST" enctype="multipart/form-data" id="fileUploadForm">'
            	+ ' <div class="col-md-12" style= "margin-bottom: 15px;">'
            		//    <!-- image-preview-filename input [CUT FROM HERE]-->
            		+ '  <div class="input-group image-preview"> '
             			+ '<label for="inputPassword4">Image</label>'
	            		+ '  <input type="text" id = "file-image" class="form-control image-preview-filename" disabled="disabled" placeholder="Required image"> '
	            		+ '  <span class="input-group-btn"> '
		            		//     <!-- image-preview-clear button -->
		            		+ '  <button type="button" class="btn btn-default image-preview-clear" style="display:none;"> '
		            			+ ' <span class="glyphicon glyphicon-remove"></span> Clear '
		            		+ ' </button> '
		            		//             <!-- image-preview-input -->
		            		+ ' <div class="btn btn-default image-preview-input"> '
			            		+ ' <span class="glyphicon glyphicon-folder-open"></span> '
			            		+ '  <span class="image-preview-input-title">Browse</span> '
			            		+  ' <input type="file" accept="image/png, image/jpeg, image/gif" name="file"/>'
		            		+ ' </div> '
	            		+ ' </span> '
            		+ ' </div> '
				 + '<div class="error" id = "error-file-image">'
				 + '</div>'
	           +  ' </div> '
			 + ' </form>'
           + ' </div> '
        
    		// end row
    		
    		
    		// end form

    	var title =  '<button class="btn_add01" id ="movi-add" tabindex="-1" type="button"><span>Add New</span></button>';
    	BootstrapDialog.show({
            title: title,
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
                    	toDoPostDataMainMovi(dialogRef);
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

    $("#title").focusout(function(){
		alert();
    });
	
});

function toDoPostDataMainMovi(dialogRef) {
	var title 	= $("#title").val();
	var movi	= $("#select-movi").val();
	var type	= $("#select-type").val();
	var order	= $("#order").val();

	if (title === null || title === '') {
		var erText = 'Required title';
		$("#error-title").html('<i class="fa fa-warning"></i><span class="box-title">'+erText+'</span>');
		return;
	} else {
        $("#error-title").html('');
	}
    if ( $("#file-image").val() === null ||  $("#file-image").val() === '') {
        var erText = 'Required Image';
        $("#error-file-image").html('<i class="fa fa-warning"></i><span class="box-title">'+erText+'</span>');
        return;
    } else {
        $("#error-file-image").html('');
    }
	if (title !== null &&  $("#file-image").val() !== null ){

		var movi_add = {}
			movi_add["title"] 		 = title;
			movi_add["typeId"] 		 = type;
			movi_add["moviTypeId"]  = movi;
			movi_add["order"] 		 = order;
			movi_add["imageId"] = imgId;
			movi_add["description"] = $("#validationTextarea").val();


			console.log(JSON.stringify(movi_add));

		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "/@m!n/api/movi/save",
			data: JSON.stringify(movi_add), // convert array to JSON
			dataType: 'json',
			cache: false,
			timeout: 100000,
			success: function (data) {
                if (data.status == false && data.setStatus == "Duplicate"){
                    $("#error-title").html('<i class="fa fa-warning"></i><span class="box-title">'+data.description+'</span>');
                    return;
				} else {
                    $("#error-title").html('');
				}
				if (data.status == true && data.setStatus == "YSaved") {
                    Swal.fire({
                        type: 'success',
                        title: data.description,
                        showConfirmButton: false,
                        timer: 1500
                    }).then((result) => {
                        result.dismiss === Swal.DismissReason.timer;
                    dialogRef.close();
                	});
                }
                else {
                    console.log("SUCCESS : ", data);
				}


			},
			error: function (e) {

				console.log("ERROR : ", e);

			}
		});
    }

}
