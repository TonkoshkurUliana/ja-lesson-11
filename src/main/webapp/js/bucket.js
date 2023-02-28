
var bucket = null;

$.get("bucket", function (data) {
    if (data !== '') {
        bucket = data;
    }
}).done(function () {

    var tableContent = "";

    jQuery.each(bucket, function (i, value) {

        tableContent += "<tr>" +
            "<td>" + value.name + "</td>" +
            "<td>" + value.description + "</td>" +
            "<td>" + value.price + "</td>" +
            "<td>" + value.purchaseDate + "</td>" +
            "<td><button  class='btn btn-outline-secondary' onclick='deleteOrderFromBucket(" + value.bucketId + ")'>delete</button></td>" +
            "</tr>"
    });


    $('#table-bucket').html(tableContent);

});

function deleteOrderFromBucket(bucketId) {
    var customUrl = '';
    var urlContent = window.location.href.split('/');
    for (var i = 0; i < urlContent.length - 1; i++) {
        customUrl += urlContent[i] + '/'
    }
    customUrl += 'bucketController?bucketId=' + bucketId;

    $.ajax({
        url: customUrl,
        type: 'DELETE',
        success: function (data) {
            if (data == 'Success') {
                location.reload();
            }
        }
    });
}




