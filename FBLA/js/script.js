var navstatus = true;

$(document).ready(function() {

    $('.link-button').click(function() {
        $('#splash').fadeOut("slow");
    });

    if($(".navbar").offset().top > 0 && navstatus) {
        $('.navbar .wow').each(function(){
            $(this).addClass('menu-fix');
            $(this).removeClass('bounceInUp');
            navstatus = false;
        });
    }

});

$(function () {
  $(document).scroll(function () {
    var $nav = $(".navbar-fixed-top");
    $nav.toggleClass('scrolled', $(this).scrollTop() > $nav.height());
  });
});