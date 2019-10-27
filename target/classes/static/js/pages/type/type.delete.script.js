/**
 *
 */
function deleteType(val){

    BootstrapDialog.show({
        title: 'Delete Type!',
        message: "<h3>Do you want to delete type?</h3>",
        cssClass: 'delete-dialog',
        closable: true,
        closeByBackdrop: false,
        closeByKeyboard: false,
        buttons: [
            {
                icon: 'glyphicon glyphicon-send',
                label: 'Delete',
                cssClass: 'btn-save bg-aqua',
                action: function (dialogRef) {
                    toDoDeleteType(val,dialogRef);
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
}

function toDoDeleteType(id, dialogRef) {
    $.ajax({
        type: "Post",
        url: "/@m!n/api/type/delete?id="+id,
        //	    data:{"data":"check"},
        contentType: "application/json",
        dataType: "json",
        success: function(data) {
            if (data.status == true && data.setStatus == "YDeleted"){
                Swal.fire({
                    type: 'success',
                    title: data.description,
                    showConfirmButton: false,
                    timer: 2500
                }).then((result)=> {
                    result.dismiss === Swal.DismissReason.timer;
                    console.log(result);
                    dialogRef.close();
            });
            }
        }
    });
}
