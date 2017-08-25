<#import "layout/default.ftl" as layout>
<#import "/spring.ftl" as spring/>
<@layout.default >

<#include "modul/navigation.ftl">

<div class="main">
    <div class="container">

        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="überschrift">
                <h3 class="text-center">Veranstaltungen</h3>
            </div>
            <div class="panel-body">

                <link rel="stylesheet" type="text/css" href="//my.raceresult.com/RREvents/style.css">
                <div class="EventTable" id="tEventTable">
                <div><div>&nbsp;</div><div>&nbsp;</div><div>Stadt</div><div>Veranstaltung</div><div>Datum</div></div>
                </div>
                <script type="text/javascript" src="//my.raceresult.com/RREvents/jquery-latest.min.js"></script>
                <script type="text/javascript" src="//my.raceresult.com/RREvents/RREvents.js"></script>
                <script type="text/javascript">
                <!--
                    var options= { dateFormat : 'dd.mm.yyyy' };
                    var rre=new RREvents(document.getElementById("tEventTable"), null, 'de', options);
                    rre.server="//my.raceresult.com";
                    rre.user=34087;
                    //rre.year=2017;
                    //rre.group=1234;
                    //rre.eventlink="http://your.webseite.com/events/show?eventid=[eventid]";
                    //rre.openInNewWindow=false;
                    rre.loadEvents(function(resultSize) { return true; });
                -->
                </script>
                <style type="text/css"> @import url("/css/raceresult_customize.css"); </style>


            </div>
        </div>


        <#include "/modul/sponsorList.ftl" />

</@layout.default>