<#import "../layout/default.ftl" as layout>
<#import "/spring.ftl" as spring/>
<@layout.default >

    <#include "modul/navigation.ftl">

<div class="main">
    <div class="container">

        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="überschrift">
                <h3 class="text-center">Registrierungsliste</h3>
            </div>
            <div class="panel-body">

                <#if success??>
                    <div class="alert alert-success">
                        Die Daten wurden erfolgreich gespeichert.
                    </div>
                </#if>

                <form name="participantsFormData" class="form-horizontal" action="/admin/change" role="form"
                      method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>


                    <div class="row">
                        <div class="col-lg-12">
                            <div class="table-responsive">
                                <table id="registerTable"
                                       class="table table-striped table-hover tablesorter table-responsive table-condensed">
                                    <thead>
                                    <tr>
                                        <th></th>
                                        <th data-sorter="false" class="col-sm-1">ID</th>
                                        <th>Bezahlt</th>
                                        <th width="15%">Vorname</th>
                                        <th data-placeholder="Tippe deinen Nachnamen ein..." width="15%">Nachname</th>
                                        <th width="8%">Verein</th>
                                        <th data-placeholder="Tippe m/w" width="5%">Geschlecht</th>
                                        <th width="8%">Jahrgang</th>
                                        <th width="8%">E-Mail</th>
                                        <th width="8%">Shirt</th>
                                    </thead>
                                    <tbody>
                                        <#list participantsFormData.participants as participant>

                                        <tr>
                                            <@spring.bind path="participantsFormData.participants[${participant_index}].participationId" />
                                            <input name="${spring.status.expression}" type="hidden" value="${participant.participationId}"/>

                                            <@spring.bind path="participantsFormData.participants[${participant_index}].hasPaid" />
                                            <td><input name="${spring.status.expression}" type="checkbox"/></td>
                                            <td>${participant.participationId}</td>
                                            <td>${participant.paid?string("ja", "nein")}</td>
                                            <td>${participant.runner.forename}</td>
                                            <td>${participant.runner.surname}</td>
                                            <td>${participant.runner.club}</td>
                                            <td>${participant.runner.gender}</td>
                                            <td>${participant.runner.birthyear?c}</td>
                                            <td>${participant.runner.email!""}</td>
                                            <td>${participant.runner.shirt!""}</td>

                                        </tr>
                                        </#list>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-2">
                            <button type="submit" name="pay" value="pay" class="btn btn-primary btn-filsum">Bezahlt</button>
                        </div>
                        <div class="col-sm-offset-3 col-sm-2">
                            <button type="submit" name="delete" value="delete" class="btn btn-primary btn-filsum">Löschen</button>
                        </div>
                    </div>

                </form>
            </div>
        </div>

    </div>
</div>
</@layout.default>