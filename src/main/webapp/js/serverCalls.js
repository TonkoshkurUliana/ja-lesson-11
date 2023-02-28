$("#createProduct")
    .click(
        function () {

            var name = $("#msform input.productName").val();
            var information = $("#msform input.productDescription").val();
            var price = $("#msform input.productPrice").val();

            var product = {
                name: name,
                information: information,
                price: price
            };

            $.post("productController", product,
                function (data) {
                    if (data == 'Success') {
                        $('input[type="text"]').val('');
                        alert('Success');
                    }
                });

        });

$("#buy-product").click(function () {
    var productId = jQuery(this).attr("product-id");

    $.post("bucketController", {'magazineId': productId},
        function (data) {
            if (data == 'Success') {
                $("[data-dismiss=modal]").trigger({type: "click"});
                alert('Success');
            }
        })
});
