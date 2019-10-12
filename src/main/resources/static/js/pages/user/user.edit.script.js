/**
 * 
 */
function edit(val) {
	$.ajax({
	    type: "GET",
	    url: "/@m!n/mainmovi/getmainmovibyid?id="+val,
//	    data:{"data":"check"},
	    contentType: "application/json",
        dataType: "json",
	    success: function(data) {
	        if (data) {
	        	var	mainmoviEdit  = '<script type="text/javascript">'
	        		+ '$("#optionMovi").val("'+data.moviTypeId+'"); '
		        	+ '$("#optionMovi").trigger("change");'
		        	+ '$("#optionType").val("'+data.typeId+'"); '
		        	+ '$("#optionType").trigger("change");'
	        		+ '</script>'
	        		
	        		+ '<form>'
	        		// start form
	        		
	        		// start row
	        		+ '<div class="form-row">'
	        		+ '<div class="form-group col-md-6"> ' 
	            		+ '<label for="inputEmail4">Title</label>'
	            		+ '<input type="text" class="form-control" id="inputEmail4" placeholder="Email" value="'+data.title+'">'
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
	            		+ '<textarea class="form-control is-invalid" id="validationTextarea" placeholder="Required example textarea" required value="'+data.description+'"></textarea>'
	        		+ '</div>'
	        		
	        		+ '</div>'
	        		// end row
	        		
	        		// end form
	        		+ '</form>';
	        		

	        	
	        	BootstrapDialog.show({
	                title: 'Edit Main Movi',
	                message: mainmoviEdit,
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
	        	
	        	
	        	
	        }
	        else {
	            console.log(data);
	        }
	    }, error: function(data){
            console.log(data);
        },
	});
	
}