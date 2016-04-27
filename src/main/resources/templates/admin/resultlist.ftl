<#import "../layout/default.ftl" as layout>
<#import "/spring.ftl" as spring/>
<@layout.default >

    <#include "modul/navigation.ftl">

<div class="main">
    <div class="container">

        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="überschrift">
                <h3 class="text-center">Ergebnisliste</h3>
            </div>
            <div class="panel-body">

                <#if success??>
                    <div class="alert alert-success">
                        Die Daten wurden erfolgreich gespeichert.
                    </div>
                </#if>

                <form name="resultFormData" class="form-horizontal" action="/admin/result" role="form"
                      method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>


                    <div class="row">
                        <div class="col-lg-12">
                            <div class="table-responsive">
                                <table id="resultTable"
                                       class="table table-striped table-hover tablesorter  table-condensed">
                                    <thead>
                                    <tr>
                                        <th data-sorter="false" class="col-sm-1">Platz*</th>
                                        <th class="col-sm-1">Strecke</th>
                                        <th class="filter-select col-sm-1">Altersklasse</th>
                                        <th class="col-sm-2">Vorname</th>
                                        <th data-placeholder="Tippe deinen Nachnamen ein..." class="col-sm-2">Nachname</th>
                                        <th class="col-sm-1">Jahrgang</th>
                                        <th data-placeholder="Tippe deinen Verein ein..." class="col-sm-1">Verein</th>
                                        <th class="col-sm-1">Startnummer</th>
                                        <th class="col-sm-2">Zeit</th>


                                    </thead>
                                    <tbody>
                                        <#list resultFormData.participants as participant>
                                        <tr>
                                            <@spring.bind path="resultFormData.participants[${participant_index}].participationId" />
                                            <input name="${spring.status.expression}" type="hidden" value="${participant.participationId}"/>

                                            <td></td>
                                            <td>${participant.run.name}</td>
                                            <td>${participant.runner.calculateAgeGroup}</td>
                                            <td>${participant.runner.forename}</td>
                                            <td>${participant.runner.surname}</td>
                                            <td>${participant.runner.birthyear?c}</td>
                                            <td>${participant.runner.club}</td>
                                            <@spring.bind path="resultFormData.participants[${participant_index}].startnumber" />
                                            <td><input type="text" id="${spring.status.expression}" name="${spring.status.expression}" value="${spring.status.value!""}"/></td>

                                            <@spring.bind path="resultFormData.participants[${participant_index}].runtime" />
                                            <td><input type="text" id="${spring.status.expression}" name="${spring.status.expression}" value="${spring.status.value!""}"/></td>

                                        </tr>
                                        </#list>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-2">
                            <button type="submit" name="speichern" class="btn btn-primary btn-filsum">Speichern</button>
                        </div>
                    </div>

                </form>
            </div>
        </div>

    </div>
</div>
</@layout.default>