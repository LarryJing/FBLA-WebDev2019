$(document).ready(function() {

    $('.link-button').click(function() {
        $('#splash').fadeOut("slow");
    });

});

$(function () {
  $(document).scroll(function () {
    var $nav = $(".navbar-fixed-top");
    $nav.toggleClass('scrolled', $(this).scrollTop() > $nav.height());
  });
});