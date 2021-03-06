<#import "layout/default.ftl" as layout>
<#import "/spring.ftl" as spring/>
<@layout.default >

    <#include "modul/navigation.ftl">

<div class="main">
    <div class="container">

        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="überschrift">
                <h3 class="text-center">Teilnehmerliste zum 5. Filsum löppt</h3>
            </div>
            <div class="panel-body">



                <div class="row">
                    <div class="col-lg-12">
                        <div class="table-responsive">
                        <table id="particpantTable"
                               class="table table-striped table-hover tablesorter table-responsive table-condensed">
                            <thead>
                            <tr>
                                <th width="10%" data-sorter="false" class="col-sm-1">lfd. Nr.</th>
                                <th width="15%">Vorname</th>
                                <th data-placeholder="Tippe deinen Nachnamen ein..." width="15%">Nachname</th>
                                <th width="20%">Verein</th>
                                <th data-placeholder="Tippe m/w" width="10%">Geschlecht</th>
                                <th width="10%">Jahrgang</th>
                                <th data-placeholder="Tippe 10 km oder 5 km..." width="15%">Strecke</th>
                            </thead>
                            <tbody>
                                <#list participants as participant>
                                <tr>
                                    <td> </td>
                                    <td>${participant.runner.forename}</td>
                                    <td>${participant.runner.surname}</td>
                                    <td>${participant.runner.club}</td>
                                    <td>${participant.runner.gender}</td>
                                    <td>${participant.runner.birthyear?c}</td>
                                    <td>${participant.run.name}</td>


                                </tr>
                                </#list>
                            </tbody>
                        </table>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <#include "modul/sponsorList.ftl" />

    </div>
</div>
</@layout.default>