$('.logout').click(function() {

    $.get("logout", function (data) {
        if (data !== '') {
            var customUrl = '';
            var urlContent = window.location.href.split('/');
            for (var i = 0; i < urlContent.length - 1; i++) {
                customUrl += urlContent[i] + '/'
            }
            customUrl += data;
            window.location = customUrl;
        }
    })
});

$(document).ready(function() {
    $.get("userRole", function(data) {
        if (data !== '') {
            userRole = data;
        }
    }).done(function() {
        if (userRole === 'ADMIN') {
            $('a.user-bucket-option').hide();
        } else {
            $('a.create-product-option').hide();
        }
    });
});
