/**
 *
 */


	var id ;
	var imageId = 0;
    function onEditeMovie(val) {
        var mainmoviadd = "";
        var uri = "";
        var uriName = "";
        $.ajax({
            type: "GET",
            url: "/@m!n/api/movi/getvaluebyid?id="+val,
            //	    data:{"data":"check"},
            contentType: "application/json",
            dataType: "json",
            success: function(data) {
				console.log('data',data)
				id = data.id;
				var length = data.imagesDTO.length;
				if(length > 0){
                    for (var i = 0; i < length; i++ ) {
                        if (data.imagesDTO[i].status === 1 ) {
                            imageId = data.imagesDTO[i].id
                            uri     = data.imagesDTO[i].uri;
                            uriName = data.imagesDTO[i].name;
                        }
                    }
                }


                mainmoviadd = '<script src="/js/binding/uploadimg.script.js"></script>'

                    // start form

                    // start row
                    + '<div class="form-row">'

                    + '<div class="form-group col-md-6"> '
                    + '<label for="inputEmail4">Title</label>'
                    + '<input type="text" class="form-control" id="title" placeholder="Required title" value="'+data.title+'">'
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
                    + '<input type="text" class="form-control" id="order" placeholder="Please input Order" value="'+data.order+'">'
                    + '</div>'

                    + '</div>'
                    // end row

                    // start row
                    + '<div class="form-row">'
                    + '<div class="form-group col-md-12">'
                    + '<label for="inputPassword4">Description</label>'
                    + '<input type="text" class="form-control" id="validationTextarea" placeholder="Required example textarea" value="'+data.description+'">'
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
                    + '  <input type="text" id = "file-image" class="form-control image-preview-filename" disabled="disabled" placeholder="Required image" value="'+uriName+'"> '
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

                    + ' <div class="popover fade bottom in" role="tooltip" id="popover" style="top: 59.2px; left: 35%;; display: block;">'
                        + '<div class="arrow" style="left: 50%;"></div>'
                            + '<h3 class="popover-title"><strong>Preview</strong></h3>'
                            + '<div class="popover-content">'
                                + '<img id="dynamic" src="'+uri+'"> '
                        + ' </div> '
                    + ' </div>'

                    +  ' </div> '




                    + ' </form>'
                    + ' </div> ';
                // end row
                // end form

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

            }, error: function (e) {
                console.log("ERROR : ", e);
            }
        });
    };



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

        var movi_Edit = {}
        movi_Edit["id"] 		 = id;
        movi_Edit["title"] 		 = title;
        movi_Edit["typeId"] 		 = type;
        movi_Edit["moviTypeId"]  = movi;
        movi_Edit["order"] 		 = order;
        movi_Edit["imageId"] = imageId;
        movi_Edit["description"] = $("#validationTextarea").val();

        console.log(JSON.stringify(movi_Edit));

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/@m!n/api/movi/update?newImageId="+imgId,
            data: JSON.stringify(movi_Edit), // convert array to JSON
            dataType: 'json',
            cache: false,
            timeout: 100000,
            success: function (data) {
                if (data.status == true && data.setStatus == "YUpdated") {
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
