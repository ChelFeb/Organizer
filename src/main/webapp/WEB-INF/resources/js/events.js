$(document).ready(function () {

    var startTimeBlock = $("#startTime");
    var finishTimeBlock = $("#finishTime");
    var deadlineTimeBlock = $("#deadlineTime");

    startTimeBlock.hide();
    finishTimeBlock.hide();
    deadlineTimeBlock.hide();

    //get current time
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1; //January is 0!
    var yyyy = today.getFullYear();
    var hh = today.getHours();
    var ss = today.getSeconds();

    if (dd < 10) {
        dd = '0' + dd
    }

    if (mm < 10) {
        mm = '0' + mm
    }

    today = yyyy + "-" + mm + "-" + dd + " " + hh + ":" + ss;

    //setup datetime
    $('.form_datetime').datetimepicker({
//        language:  'ru',
        format: "dd/mm/yyyy hh:ii",
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 0,
        startDate: today,
        pickerPosition: "bottom-left"
    });


    //when user click on add Task
    $("#taskLi").click(function () {
        $("ul li").removeClass("active");
        $(this).addClass("active");

        startTimeBlock.hide();
        finishTimeBlock.hide();
        deadlineTimeBlock.hide();
    });

    //when user click on add Event
    $("#eventLi").click(function () {
        $("ul li").removeClass("active");
        $(this).addClass("active");

        startTimeBlock.show();
        finishTimeBlock.show();
        deadlineTimeBlock.hide();
    });

    //when user click on add Deadline event
    $("#dlEventLi").click(function () {
        $("ul li").removeClass("active");
        $(this).addClass("active");

        startTimeBlock.hide();
        finishTimeBlock.hide();
        deadlineTimeBlock.show();
    });

    $(function() {
        $('.nav').bind('click', function (e) {
            $('#type').val($('.active a').text());
        });
    });

});

