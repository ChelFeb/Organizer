//hash code from String
String.prototype.hashCode = function () {
    var hash = 0, i, chr, len;
    if (this.length == 0) return hash;
    len = 5;
    for (i = 0, len = this.length; i < len; i++) {
        chr = this.charCodeAt(i);
        hash = ((hash << 5) - hash) + chr;
        hash |= 0; // Convert to 32bit integer
    }
    return hash;
};


$(document).ready(function () {

    // class
    function MyEvent(eventName, timeStart, timeFinish) {
        this.eventName = eventName;
        this.timeStart = timeStart;
        this.timeFinish = timeFinish;
        this.getEventStartHour = function () {
            return parseInt(timeStart.toString().substring(11, 13));
        }
        this.getEventFinishHour = function () {
            return parseInt(timeFinish.toString().substring(11, 13));
        }
    }

    var event1 = new MyEvent("Test event", 12, 20);

    var eventsByDay = $('.eventByDay');

    var arrOfEventsByDay = [];

    Array.prototype.forEach.call(eventsByDay, function (el, index) {
        arrOfEventsByDay.push(new MyEvent($(el).find('.subject').attr('value'),
            $(el).find('.dateStart').attr('value'),
            $(el).find('.dateEnd').attr('value')));
    });


    //generate table by Day and Week
    function generateTable() {
        var tDayBody1 = "<tr><td class='shortField'>";
        var tDayBody2 = "</td><td class='descriptionField'></td><tr>";

        var tWeekBody1 = "<tr><td class='shortField'>";
        var tWeekBOdy2 = "</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><tr>";

        for (var i = 0; i <= 23; i++) {
            if (i < 10) {
                $('#tableOfEventsByDay tbody').append(tDayBody1 + "0" + i + ":00" + tDayBody2);
                $('#tableOfEventsByWeek tbody').append(tWeekBody1 + "0" + i + ":00" + tWeekBOdy2);
            } else {
                $('#tableOfEventsByDay tbody').append(tDayBody1 + i + ":00" + tDayBody2);
                $('#tableOfEventsByWeek tbody').append(tWeekBody1 + i + ":00" + tWeekBOdy2);
            }
        }
        $('#tableOfEventsByDay tbody').append(tDayBody1 + "00:00" + tDayBody2);
        $('#tableOfEventsByWeek tbody').append(tWeekBody1 + "00:00" + tWeekBOdy2);
    }

    generateTable();


    var shortTd = $('#tableOfEventsByDay .shortField');

    // set Id for each td with Time
    Array.prototype.forEach.call(shortTd, function (el, index) {
        $(el).attr('id', 'cell' + index);
    });


    function drawEvent(start, finish, name) {

        var fullName = name;
        name = name.substring(0, 7);
        if (fullName > name) {
            name += '..';
        }

        //generate color by hash code of Subject
        var hashOfName = (name).hashCode();
        var hashToHex = (hashOfName).toString(16);
        var color = hashToHex.substr(1, 6);
        while (color.length < 6) {
            color += 'f';
        }

        // элемент ивента
        var element = "<div style='color:#ffffff; padding: 2px ;height: 100%;float:left; background-color:#" + color + ";  width: 10%; margin: 1 %; margin-left: 4 %; cursor: pointer; margin-left: 1%' unselectable='on'>" + name + "</div>";
        var ground = "<div style=' height: 25px; float:left; background-color:#" + color + "; width: 10%; margin: 1 %; margin-left: 4 %; cursor: pointer; margin-left: 1%; opacity: 0.14' unselectable='on'></div>";

        var invisibleBlock = "<div style='height: 25px; float:left; background-color:#ffffff; width: 10%; margin: 1 %; margin-left: 4 %; margin-left: 1%; opacity: 0.0;' unselectable='on'></div>";

        Array.prototype.forEach.call($('#tableOfEventsByDay .shortField'), function (el, index) {
            if (index == start) {
                var description = $(el).next();
                description.append(element);
                var inc = 0;
                while ((index + inc) < finish) {
                    var nextDescription = $('#cell' + (start + inc + 1)).next();
                    nextDescription.append(ground);
                    inc++;
                }
            } else if (index > finish || index < start) {
                $(el).next().append(invisibleBlock);
            }
        });
    };


    //draw all event per day
    for (var i = 0; i < arrOfEventsByDay.length; i++) {
        drawEvent(arrOfEventsByDay[i].getEventStartHour(),
            arrOfEventsByDay[i].getEventFinishHour(),
            arrOfEventsByDay[i].eventName);
    }


    var tableOfEventsByDay = $("#tableOfEventsByDay");
    var tableOfEventsByWeek = $("#tableOfEventsByWeek");

    tableOfEventsByDay.show();
    tableOfEventsByWeek.hide();

    //when user click on task by day
    $("#dayLi").click(function () {
        $("ul li").removeClass("active");
        $(this).addClass("active");
        tableOfEventsByWeek.hide();
        tableOfEventsByDay.show();
    });

    //when user click on task by week
    $("#weekLi").click(function () {
        $("ul li").removeClass("active");
        $(this).addClass("active");
        tableOfEventsByDay.hide();
        tableOfEventsByWeek.show();
    });

    //when user click on task by month
    $("#monthLi").click(function () {
        $("ul li").removeClass("active");
        $(this).addClass("active");
        tableOfEventsByDay.hide();
        tableOfEventsByWeek.hide();
    });


});
