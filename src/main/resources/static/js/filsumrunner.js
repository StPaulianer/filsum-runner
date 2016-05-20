$(document).ready(function()
    {
        $("#resultTable").tablesorter({
            // this will apply the bootstrap theme if "uitheme" widget is included
            // the widgetOptions.uitheme is no longer required to be set
            theme: "bootstrap",

            widthFixed: true,

            dateFormat: "ddmmyyyy",

            headerTemplate: '{content} {icon}', // new in v2.7. Needed to add the bootstrap icon!

            // widget code contained in the tablesorter.widgets.js file
            // use the zebra stripe widget if you plan on hiding any rows (filter widget)
            widgets: [ "uitheme", "filter", "zebra", "stickyHeaders" ],

            // storage function works with a fixed url (for all license/copy, license/edit urls...)
            fixedUrl: "resultTable",

            // sort on the first column and third column, order asc
            sortList: [[7,0]],

            widgetOptions: {
                // using the default zebra striping class name, so it actually isn't included in the theme variable above
                // this is ONLY needed for bootstrap theming if you are using the filter widget, because rows are hidden
                zebra: ["even", "odd"],

                // reset filters button
                filter_reset: ".reset",

                // offset for sticky headers
                stickyHeaders_offset : '.navbar-fixed-top'

            }
        });

        $("#particpantTable").tablesorter({
            // this will apply the bootstrap theme if "uitheme" widget is included
            // the widgetOptions.uitheme is no longer required to be set
            theme: "bootstrap",

            widthFixed: true,

            dateFormat: "ddmmyyyy",

            headerTemplate: '{content} {icon}', // new in v2.7. Needed to add the bootstrap icon!

            // widget code contained in the tablesorter.widgets.js file
            // use the zebra stripe widget if you plan on hiding any rows (filter widget)
            widgets: [ "uitheme", "filter", "zebra", "stickyHeaders" ],

            // storage function works with a fixed url (for all license/copy, license/edit urls...)
            fixedUrl: "particpantTable",

            widgetOptions: {
                // using the default zebra striping class name, so it actually isn't included in the theme variable above
                // this is ONLY needed for bootstrap theming if you are using the filter widget, because rows are hidden
                zebra: ["even", "odd"],

                // reset filters button
                filter_reset: ".reset",

                // offset for sticky headers
                stickyHeaders_offset : '.navbar-fixed-top'

            }
        });

        // activate elements in main-nav
        var url = window.location.pathname.toLowerCase();
        var elements = url.split("/");
        var className = elements[1];
        if($('.' + className).length > 0){
            $('.' + className).addClass('active');
        }
    }

);

$(function () {

    // click hidden href link to retoure cover path (by clicking the button)
    $(document).on("click", '#actualRun', function (e) {
        var runId = e.target.getAttribute("data-runid");
        $('#selectedRun').val(runId);

        // disable tshirt
        var actualRunText = $(e.target).text();
        if(actualRunText.indexOf("ambini") >= 0){
            $('.selectedShirt').attr('disabled', 'disabled');
        } else {
            $('.selectedShirt').removeAttr('disabled');
        }

    });

    // click run in result view
    $(document).on("click", '#actualResultRun', function (e) {
        var runId = e.target.getAttribute("data-runid");
        window.location.href = "/results/" + runId;
    });

    var table = $("#resultTable");
    numberResultTable(table);
    table.bind("sortEnd",function() {
        numberResultTable(table);
    });

    table.bind("filterEnd",function() {
        numberResultTable(table);
    });

    var parTable = $("#particpantTable");
    numberResultTable(parTable);
    parTable.bind("sortEnd",function() {
        numberResultTable(parTable);
    });

    parTable.bind("filterEnd",function() {
        numberResultTable(parTable);
    });


});

function numberResultTable(changeTable){
    var i = 1;
    changeTable.find("tr:gt(0)").each(function() {
            if(!($(this).hasClass('tablesorter-ignoreRow')) && !($(this).hasClass('filtered')) ) {
                $(this).find("td:eq(0)").text(i);
                i++;
            }
    });
}

var href = window.location.href;
var last = href.substring(href.lastIndexOf("/") + 1, href.length);
$('.runList').each(function(i, obj) {
    var runIdList = obj.getAttribute("data-runid");
    if(runIdList == last){
        $(obj).addClass("active");
    }
});
