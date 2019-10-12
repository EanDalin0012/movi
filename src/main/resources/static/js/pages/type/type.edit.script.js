/**
 *
 */
var id;
function edit(val){

        $.ajax({
            type: "GET",
            url: "/@m!n/api/type/getvaluebyid?id="+val,
    //	    data:{"data":"check"},
            contentType: "application/json",
            dataType: "json",
            success: function(data) {
                id = data.id;
                var add = '<form>'
                    // start form

                    // start row
                    + '<div class="form-row">'

                    + '<div class="form-group col-md-6"> '
                    + '<label for="inputEmail4">Name</label>'
                    + '<input type="text" class="form-control" id="name" placeholder="Email" value="'+data.name+'">'
                    + '</div>'

                    + '<div class="form-group col-md-6">'
                    + '<label for="inputPassword4">Description</label>'
                    + '<textarea class="form-control is-invalid" id="validationTextarea" placeholder="Required example textarea" required>'+data.description+'</textarea>'
                    + '</div>'

                    + '</div>'

                    // end form
                    + '</form>';
                BootstrapDialog.show({
                    message: 'Hi Apple!',
                    message: add,
                    closable: true,
                    closeByBackdrop: false,
                    closeByKeyboard: false,
                    buttons: [
                        {
                            icon: 'glyphicon glyphicon glyphicon-copy',
                            label: 'Update',
                            cssClass: 'btn-save bg-aqua',
                            action: function (dialogRef) {
                                toDoUpdate(dialogRef);
                            }
                        }, {

                            icon: 'glyphicon glyphicon-ban-circle',
                            label: 'Close',
                            cssClass: 'btn-close bg-red',
                            action: function (dialogRef) {
                                dialogRef.close();
                            }
                        }
                    ]
                });
            }, error: function (e) {
                console.log("ERROR : ", e);
            }
        });
}

function toDoUpdate(dialogRef) {
    var updateApiType = {}
    updateApiType["id"] = id;
    updateApiType["name"] = $("#name").val();
    updateApiType["description"] = $("#validationTextarea").val();

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/@m!n/api/type/update",
        data: JSON.stringify(updateApiType), // convert array to JSON
        dataType: 'json',
        cache: false,
        timeout: 100000,
        success: function (data) {
            if (data.status == true && data.setStatus == "YUpdated"){
                Swal.fire({
                    type: 'success',
                    title: data.description,
                    showConfirmButton: false,
                    timer: 2500
                }).then((result)=> {
                    result.dismiss === Swal.DismissReason.timer;
                    dialogRef.close();
                });
            }

        },error: function (e) {
            console.log("ERROR : ", e);
        }
    });
}
