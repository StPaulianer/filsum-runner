<#import "layout/default.ftl" as layout>
<#import "/spring.ftl" as spring/>
<@layout.default >

<#include "modul/navigation.ftl">

<div class="main">
    <div class="container">

        <div class="panel panel-default">
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-7">
                        <iframe src="https://www.google.com/maps/d/embed?mid=zxdSeBnwgT94.ktKGkeC2PZ-E" class="mapFrame"></iframe>
                    </div>
                    <div class="col-md-5">
                        <h3>Streckenplan</h3>
                        Gelaufen wird ein 5 Kilometer Rundkurs, der beim 10 Kilometerlauf zweimal zu durchlaufen ist. Start und Ziel befindet sich auf dem Filsumer Sportplatz.    <br/>
                        Für Navigationsgeräte geben Sie bitte folgende Adresse ein:<br/> Osterende 21, 26849 Filsum     <br/>
                        Zusätzlich zu den im Start- und Zielbereich vorhandenen Parkplätzen bestehen weitere Parkmöglichkeiten in 400m Entfernung beim Filsumer Rathaus im Rathausring 8, 26849 Filsum.

                    </div>
                </div>
            </div>
        </div>

        <#include "/modul/sponsorList.ftl" />

    </div>
</div>

</@layout.default>