<#import "../layout/default.ftl" as layout>
<#import "/spring.ftl" as spring/>
<@layout.default >

    <#include "../modul/navigation.ftl">

<div class="main">
    <div class="container">


        <div class="col-lg-10 col-lg-offset-1">
            <form name="runnerData" class="form-horizontal" action="/register/add" role="form"
                  method="post">

                <div class="panel panel-default">
                    <div class="panel-body">


                        <#if runs?size=0>
                            <p>Aktuell sind keine Online-Anmeldungen möglich.</p>

                            <p>Bitte drucke folgendes PDF für eine Nachanmeldung aus und nehme es ausgefüllt mit zum Lauf.</p>

                            <p><a target="_blank" href="images/Nachmeldung.pdf">Nachmeldung</a></p>
                        <#else>

                            <@spring.bind path="runnerData.selectedRun" />
                            <#list spring.status.errorMessages as error>
                                <div class="alert alert-danger">
                                ${error}
                                </div>
                            </#list>

                            <@spring.bind "runnerData" />



                            <div class="panel-group">
                                <div class="panel panel-default">
                                    <div class="panel-heading" role="tab" id="überschrift">
                                        <h3 class="col-sm-offset-2">Anmeldung</h3>
                                        <h4 class="panel-title col-sm-offset-2">Hauptläufer
                                        </h4>
                                    </div>
                                    <div class="panel-collapse">
                                        <div class="panel-body">

                                            <div class="form-group">

                                                <label class="control-label col-sm-2" for="runs">Strecke*:</label>

                                                <div class="col-sm-10">


                                                    <ul name="runs" id="runs" class="nav nav-pills registration">
                                                        <#list runs as run>
                                                            <li class="">
                                                                <a id="actualRun" href="#run${run.runId}" data-runid="${run.runId}"
                                                                   data-toggle="tab">
                                                                ${run.name}
                                                                </a>
                                                            </li>
                                                        </#list>
                                                    </ul>
                                                    <@spring.bind path="runnerData.selectedRun" />
                                                    <input id="selectedRun" name="selectedRun" type="hidden" value="">
                                                </div>

                                            </div>

                                            <div class="form-group">
                                                <@spring.bind path="runnerData.runner.gender" />

                                                <div class="col-lg-8 col-md-offset-2">
                                                    <label class="radio-inline">
                                                        <input class="radio-row" type="radio" name="${spring.status.expression}"
                                                               value="w" checked/> weiblich

                                                    </label>
                                                    <label class="radio-inline">
                                                        <input class="radio-row" name="${spring.status.expression}" type="radio"
                                                               value="m"> männlich
                                                    </label>
                                                </div>

                                            </div>

                                            <div class="form-group">
                                                <@spring.bind path="runnerData.runner.forename" />

                                                <label class="control-label col-sm-2" for="forename">Vorname*:</label>

                                                <div class="col-sm-10">
                                                    <input type="forename" class="form-control" name="${spring.status.expression}"
                                                           id="${spring.status.expression}" placeholder="Eingabe Vorname" required>
                                                </div>
                                            </div>

                                            <div class="form-group">

                                                <@spring.bind path="runnerData.runner.surname" />

                                                <label class="control-label col-sm-2" for="name">Name*:</label>

                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" name="${spring.status.expression}"
                                                           id="${spring.status.expression}" placeholder="Eingabe Name" required>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <@spring.bind path="runnerData.runner.birthyear" />

                                                <label class="control-label col-sm-2" for="birthyear">Geburtsjahr*:</label>

                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" name="${spring.status.expression}"
                                                           id="${spring.status.expression}" placeholder="1984" min="1900" max="2020"
                                                           required>

                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <@spring.bind path="runnerData.runner.street" />

                                                <label class="control-label col-sm-2" for="postalAddress">Straße:</label>

                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" name="${spring.status.expression}"
                                                           id="${spring.status.expression}" placeholder="Eingabe Straße">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <@spring.bind path="runnerData.runner.streetNumber" />

                                                <label class="control-label col-sm-2" for="streetnumber">Hausnummer:</label>

                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" name="${spring.status.expression}"
                                                           id="${spring.status.expression}" placeholder="Eingabe Hausnummer">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <@spring.bind path="runnerData.runner.zip" />

                                                <label class="control-label col-sm-2" for="ZipCode">Postleitzahl:</label>

                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" name="${spring.status.expression}"
                                                           id="${spring.status.expression}" placeholder="Eingabe Postleitzahl">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <@spring.bind path="runnerData.runner.city" />

                                                <label class="control-label col-sm-2" for="city">Stadt:</label>

                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" name="${spring.status.expression}"
                                                           id="${spring.status.expression}" placeholder="Eingabe Stadt">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <@spring.bind path="runnerData.runner.club" />

                                                <label class="control-label col-sm-2" for="city">Verein:</label>

                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" name="${spring.status.expression}"
                                                           id="${spring.status.expression}" placeholder="Eingabe Verein">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <@spring.bind path="runnerData.runner.shirt" />

                                                <label class="control-label col-sm-2" for="selectShirt">T-Shirt-Größe:</label>

                                                <div class="col-sm-10">
                                                    <@spring.bind "availShirts" />
                                                    <@spring.formSingleSelect "runnerData.runner.shirt", availShirts, "class='form-control selectedShirt'" />

                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <@spring.bind path="runnerData.runner.email" />

                                                <label class="control-label col-sm-2" for="email">E-Mail*:</label>

                                                <div class="col-sm-10">
                                                    <input type="email" class="form-control" name="${spring.status.expression}"
                                                           id="${spring.status.expression}" placeholder="Eingabe E-Mail" required>
                                                </div>
                                            </div>

                                            <div class="form-group">

                                                <label class="control-label col-sm-2" for="inputCheck"></label>

                                                <div class="col-sm-10">

                                                    <input name="" id="inputCheck" type="checkbox" required/>

                                                    <label for="inputCheck"> Mit einer Anmeldung erkennt der Teilnehmer den
                                                        Haftungsausschluss des Veranstalters für Schäden jeglicher Art an.
                                                        Nach Anmeldung erhalten Sie eine Anmeldebestätigung per Email mit allen
                                                        Meldedaten und einer Zahlungsaufforderung.
                                                        Erst nach Zahlungseingang auf das dort genannte Konto erfolgt eine Aufnahme
                                                        in die Teilnehmerliste.
                                                    </label>


                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- further runner data -->

                            <#list runnerData.furtherRunners as item>
                            <#assign actualRunnerId>runnerData.furtherRunners[${item_index}].runnerId</#assign>
                            <@spring.bind actualRunnerId />

                            <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                                <div class="panel panel-default">
                                    <div class="panel-heading" role="tab" id="überschriftEins">
                                        <h4 class="panel-title">
                                            <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse${item_index}"
                                               aria-expanded="false" aria-controls"collapse${item_index}">
                                            Weiteren Läufer für den Bambini-Lauf anmelden
                                            </a>
                                        </h4>
                                    </div>
                                    <div id="collapse${item_index}" class="panel-collapse collapse" role="tabpanel"
                                         aria-labelledby="überschrift${item_index}">
                                        <div class="panel-body">

                                            <div class="form-group">
                                                <@spring.bind path="runnerData.furtherRunners[${item_index}].gender" />

                                                <div class="col-lg-8 col-md-offset-2">
                                                    <label class="radio-inline">
                                                        <input class="radio-row" type="radio" name="${spring.status.expression}"
                                                               value="w" checked/> weiblich

                                                    </label>
                                                    <label class="radio-inline">
                                                        <input class="radio-row" name="${spring.status.expression}" type="radio"
                                                               value="m"> männlich
                                                    </label>
                                                </div>

                                            </div>

                                            <div class="form-group">
                                                <@spring.bind path="runnerData.furtherRunners[${item_index}].forename" />

                                                <label class="control-label col-sm-2" for="forename">Vorname*:</label>

                                                <div class="col-sm-10">
                                                    <input type="forename" class="form-control" name="${spring.status.expression}"
                                                           id="${spring.status.expression}" placeholder="Eingabe Vorname">
                                                </div>
                                            </div>

                                            <div class="form-group">

                                                <@spring.bind path="runnerData.furtherRunners[${item_index}].surname" />

                                                <label class="control-label col-sm-2" for="name">Name*:</label>

                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" name="${spring.status.expression}"
                                                           id="${spring.status.expression}" placeholder="Eingabe Name">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <@spring.bind path="runnerData.furtherRunners[${item_index}].birthyear" />

                                                <label class="control-label col-sm-2" for="birthyear">Geburtsjahr*:</label>

                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" name="${spring.status.expression}"
                                                           id="${spring.status.expression}" placeholder="1984" min="1900" max="2020">

                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <@spring.bind path="runnerData.furtherRunners[${item_index}].club" />

                                                <label class="control-label col-sm-2" for="city">Verein:</label>

                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" name="${spring.status.expression}"
                                                           id="${spring.status.expression}" placeholder="Eingabe Verein">
                                                </div>
                                            </div>


                                        </div>
                                    </div>
                                </div>
                            </div>

                            </#list>

                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" class="btn btn-primary btn-filsum">Verbindlich Anmelden</button>
                                </div>
                            </div>
                        </#if>
                    </div>
                </div>
            </form>
        </div>

    </div>
</div>

</@layout.default>