$(function () {
    'use strict';

    $.ajaxSetup({
        headers: {
            'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
        }
    });
    
    $('.flash_message').fadeOut(5000);

    //Date picker
    $('.datepicker').datetimepicker({
        locale: 'en',
        allowInputToggle: true,
        format: 'DD/MM/YYYY'
    });
    
    //Date & time picker
    $('.datetimepicker').datetimepicker({
        allowInputToggle: true,
        sideBySide: true,
        icons: { time: 'far fa-clock' },
        format: 'DD/MM/YYYY HH:mm:ss'
    });

    $('.monthpicker').datetimepicker({
        allowInputToggle: true,
        viewMode: 'months',
        format: 'YYYY年MM月01日'
    });

    //Date & time picker
    $('.datepicker2').datetimepicker({
        allowInputToggle: true,
        format: 'YYYY年MM月DD日 (ddd)',
    });

    //Date & time picker
    $('.timepicker').datetimepicker({
        allowInputToggle: true,
        format: 'HH:mm:ss'
    });

    //increase z-index for open multi modal
    $(document).on('show.bs.modal', '.modal', function (event) {
        var zIndex = 1050 + (10 * $('.modal:visible').length);
        $(this).css('z-index', zIndex).css('padding-right', '17px');
        setTimeout(function () {
            $('.modal-backdrop').not('.modal-stack').css('z-index', zIndex - 1).addClass('modal-stack');
        }, 0);
    });
    
    //back to top
    var btn = $('#back-to-top');

    $(window).scroll(function () {
        if ($(window).scrollTop() > 300) {
            btn.addClass('show');
        } else {
            btn.removeClass('show');
        }
    });

    $(function () {
        $('[data-toggle="tooltip"]').tooltip({
            template : '<div class="tooltip" role="tooltip"><div class="arrow"></div><div class="tooltip-inner text-left"></div></div>'
        })
    })

    btn.on('click', function (e) {
        e.preventDefault();
        $('html, body').animate({scrollTop: 0}, '300');
    });
    
    //clickable row
    $(".clickable-row").click(function(e) {
        if (e.target.tagName != "INPUT") {
            //go to link
            window.location = $(this).data("href");
        } else {
            //do nothing
            //alert("Doing checkbox functionality");
        }
        
    });
});

function auto_grow(element)
{
    element.style.height = "5px";
    element.style.height = (element.scrollHeight)+"px";
}

function submitForm(btn) {
    btn.disabled = true;
    btn.form.submit();
}