$(document).ready(function() {

    $('.link-button').click(function() {
        $('#splash').fadeOut("slow");
    });

    if($(".navbar").offset().top > 0) {
        $('.navbar .wow').each(function(){
            $(this).addClass('menu-fix');
        });
    }

});

$(function () {
  $(document).scroll(function () {
    var $nav = $(".navbar-fixed-top");
    $nav.toggleClass('scrolled', $(this).scrollTop() > $nav.height());
  });
});