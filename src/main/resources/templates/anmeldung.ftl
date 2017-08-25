<#import "layout/default.ftl" as layout>
<#import "/spring.ftl" as spring/>
<@layout.default >

<#include "modul/navigation.ftl">

<div class="main">
    <div class="container">

        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="überschrift">
                <h3 class="text-center">Anmeldung</h3>
            </div>
            <div class="panel-body">
            
                <div id="divRRRegStart" class="RRRegStart"></div>
                <script type="text/javascript" src="//my.raceresult.com/RRRegStart/load.js.php?lang=de"></script>
                <script type="text/javascript">
                    var rrp=new RRRegStart(document.getElementById("divRRRegStart"), 80786);
                </script> 
                <style type="text/css"> @import url("/css/raceresult_customize.css"); </style>

            </div>
        </div>


        <#include "/modul/sponsorList.ftl" />

</@layout.default>