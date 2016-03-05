<#import "layout/default.ftl" as layout>
<#import "/spring.ftl" as spring/>
<@layout.default >

    <#include "modul/navigation.ftl">

<div class="main">
    <div class="container">

        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="überschrift">
                <h3 class="col-xs-offset-5">Ergebnisse</h3>
            </div>

            <div class="panel-body">




                <ul name="runs" id="runs" class="nav nav-pills registration">
                    <#list runs as run>
                        <li class="runList" data-runid="${run.runId}">
                            <a id="actualResultRun" href="results/${run.runId}#run${run.runId}" data-runid="${run.runId}"
                               data-toggle="tab">
                            ${run.name}
                            </a>
                        </li>

                    </#list>
                </ul>
                <br/>
                <br/>

                <#if participants?size=0>
                    <p>Aktuell liegen noch keine Ergebnisse vor.</p>
                <#else>


                    <div class="row col-lg-12">
                        <div class="table-responsive">
                            <table id="resultTable"
                                   class="table table-striped table-hover tablesorter  table-condensed">
                                <thead>
                                <tr>
                                    <th data-sorter="false" class="col-sm-1">Platz*</th>
                                    <th class="col-sm-1">Startnummer</th>
                                    <th class="filter-select col-sm-1">Altersklasse</th>
                                    <th class="col-sm-2">Vorname</th>
                                    <th data-placeholder="Tippe deinen Nachnamen ein..." class="col-sm-2">Nachname</th>
                                    <th class="col-sm-1">Jahrgang</th>
                                    <th data-placeholder="Tippe deinen Verein ein..." class="col-sm-2">Verein</th>
                                    <th class="col-sm-2">Zeit</th>
                                    <th class="col-sm-1"></th>
                                </thead>
                                <tbody>
                                    <#list participants as participant>
                                    <tr>
                                        <td></td>
                                        <td>${participant.startnumber!""}</td>
                                        <td>${participant.runner.calculateAgeGroup}</td>
                                        <td>${participant.runner.forename}</td>
                                        <td>${participant.runner.surname}</td>
                                        <td>${participant.runner.birthyear?c}</td>
                                        <td>${participant.runner.club}</td>
                                        <td>${participant.runtime}</td>
                                        <td>
                                            <a href="https://www.dropbox.com/sh/8ckwnaxg2ayu0kz/AAAi7PHnKNkGX_ovWWrEzgg1a?dl=0">Urkunde</a>
                                        </td>
                                    </tr>
                                    </#list>
                                </tbody>
                            </table>
                        </div>
                    </div>

                </#if>
            </div>


            <#if participants?has_content>
                <div class="panel-footer">
                    * Die Platzierung wird abhängig von der gewählten Sortierung und Filterung der Tabelle berechnet.
                </div>
            </#if>
        </div>

        <#include "/modul/sponsorList.ftl" />

    </div>
    </div>

</@layout.default>