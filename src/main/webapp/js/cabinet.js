var products = null;

$.get("products", function(data) {
    if (data !== '') {
        products = data;
    }
}).done(function() {

    var cardsContent = "";

    jQuery.each(products, function(i, value) {

        cardsContent+= "<div class='goods-card'>"+
        "<img src = 'style/img/magazine.png' alt = '' >"+
        "<h6 class='card-subtitle mb-2 text-muted' style='text-align: center'> "+ value.name +"</h6>" +
        "<p>"+ value.price + "$"+"</p>"+
            "<a class='productCardElement buy'  href='productController?id=" + value.id + "' class='card-link'>more</a></div>"
    });

    $('#productCards').html(cardsContent);

}).done(function() {
    $.get("userRole", function(data) {
        if (data !== '') {
            userRole = data;
        }
    }).done(function() {
        if(userRole === 'ADMIN'){
            $('a.productCardElement').hide();
        }
    });
});