
$(function() {

    var row =[];
    $('#example').DataTable( {
        //dom: 'Bfrtip',
        language: {
            // search: "_INPUT_",
            searchPlaceholder: "Search..."
        },
        buttons: [
            'copyHtml5'
        ],
        dom: '<"top"f>Bt<"bottom"lip>',

        "pageLength": 10,
        ajax:{
            url : "/@m!n/api/movi/getlistmovi",
            buttons: [
                {
                    text: 'My button',
                    action: function ( e, dt, node, config ) {
                        alert( 'Button activated' );
                    }
                }
            ],
            type : "get",
            dataType: 'json',
            contentType: "application/json",
            dataType: "json",
            "dataSrc": "",
            error: function(data){
                alert();
            },
        },
        columns: [

            {"data": "id"},
            {"data": "title"},
            {"data": false,
                "render": function (data, type, row) {
                    var uri = "";
                    data = "";
                     if (row.imagesDTO.length > 0){
                         for (var i = 0; i < row.imagesDTO.length; i++){
                             if (row.imagesDTO[i].status === 1) {
                                 uri = row.imagesDTO[i].uri;
                                 data = '<div class="text-center"><img style="width: 100px;" src="'+uri+'" class="rounded" alt="200 X 200"></div>';

                             }
                         }
                    }
                    return data;
                }
            },
            {"data": "typeName"},
            {"data": "moviTypeName"},
            {"data": "createDate",
                "render": function (data, type, row) {
                    data = moment(row.createDate).format('DD/MM/YYYY');
                    return data;
                }
            },
            {"data": "createBy"},
            {"data": "modifyDate",
                "render": function (data, type, row) {
                    data = moment(row.modifyDate).format('DD/MM/YYYY');
                    return data;
                }
            },
            {"data": "modifyBy"},
            {
                "data":null,
                "searchable": false,
                "sortable": false,
                "order": false,
                "class": "dt-body-center",
                "render": function (data, type, row) {
                    return  ' <div class="input-group-btn text-center">'
                        + ' <button type="button" class="btn btn-default image-preview-input" data-toggle="dropdown">Action '
                        + ' <span class="fa fa-caret-down"></span></button> '
                        + ' <ul class="dropdown-menu"> '
                        + ' <li onclick="onEditeMovie('+row.id+')"><a>Edit</a></li> '
                        + ' <li onclick="deleteType('+row.id+')"><a>Delete</a></li> '
                        + ' </ul> '
                        + ' </div>';
                }
            }
        ],

        columnDefs: [
            { className: "text-center text-left", "targets": [0,5,7] },
            // { className: "text-right", "targets": [2] },
        ]

    });

});


    	   