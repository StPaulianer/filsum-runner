<#import "layout/default.ftl" as layout>
<#import "/spring.ftl" as spring/>
<@layout.default >

    <#include "modul/navigation.ftl">

<div class="main">
    <div class="container">

        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="überschrift">
                <h3 class="text-center">Informationen zum 4. Filsum löppt</h3>
            </div>
            <div class="panel-body">

                <div class="col-xs-3">Termin / Ausrichter:</div>
                <div class="col-xs-7"> 24.06.2016, <a target="_blank" href="http://www.bwfilsum.de">SV Blau-Weiss Filsum e.V</a></div>

                <div class="col-xs-3">Meldungen:</div>
                <div class="col-xs-7">Onlineanmeldung <a href="/register">hier</a></div>

                <div class="col-xs-3">Meldeschluss:</div>
                <div class="col-xs-7">Sonntag, 19.06.2016</div>

                <div class="col-xs-3">Strecken / Startzeiten:</div>
                <div class="col-xs-7">18:30 Uhr: Bambinilauf ca. 750m <br/>
                    19:00 Uhr: Gemeinsamer Start 5 km, 10km, 5km Walking
                </div>

                <div class="col-xs-3">Startgebühren:</div>
                <div class="col-xs-7">Bambinis: kostenlos <br/>
                    5km / 10km / 5 km Walker: 8,00 Euro
                </div>

                <div class="col-xs-3">Nachmeldungen:</div>
                <div class="col-xs-7">Nachmeldungen am Wettkampftag sind bis 60 Minuten vor dem Start möglich. Die Nachmeldegebühr beträgt pro Nachmeldung 2,00 Euro (Nachmeldung zum Bambinilauf je 1,00 Euro).

                </div>

                <div class="col-xs-3">Abmeldungen:</div>
                <div class="col-xs-7">Bei Nichtantreten oder vorheriger Absage erfolgt keine Erstattung der
                    Startgebühr.
                </div>

                <div class="col-xs-3">Ausgabe Startunterlagen:</div>
                <div class="col-xs-7">Ausgabe der Startunterlagen erfolgt ausschließlich am Wettkampftag ab 17:00 Uhr, Sportplatz Filsum</div>

                <div class="col-xs-3">Auszeichnungen:</div>
                <div class="col-xs-7">Medaillen und Urkunden für alle Bambinis <br/>
                    Pokale für die Laufsieger (männlich / weiblich) des 5 km und des 10 km Laufs. Alle Teilnehmer des 5 km, 10 km und 5 km Walking Laufs erhalten ein T-Shirt. Größenwünsche können hierbei nur bis zum 12.06.2016 berücksichtigt werden.
                </div>

                <div class="col-xs-3">Verpflegung:</div>
                <div class="col-xs-7">Getränkestände auf der Laufstrecke, Tee und Obst im Zielbereich.
                </div>

                <div class="col-xs-3">Ergebnisliste:</div>
                <div class="col-xs-7">Die Platzierungen werden
                    im Internet unter <a href="/results">Ergebnisse</a> veröffentlicht. Jeder Teilnehmer kann sich dort seine Urkunde ausdrucken. Ergebnislisten und
                    Urkunden werden nicht vor Ort ausgegeben und/oder nachgesendet.
                </div>

                <div class="col-xs-3">Umkleide/ Duschen:</div>
                <div class="col-xs-7">Umkleiden und Duschen stehen im Start-/ Zielbereich zur Verfügung.</div>

                <div class="col-xs-3">Teilnahmebedingungen:</div>
                <div class="col-xs-7">Mit der Teilnahme an der Veranstaltung "Filsum löppt", erkennt der Teilnehmer den
                    Haftungsausschluss des Veranstalters für Personen- oder Sachschäden jeder Art an. Der Teilnehmer wird weder
                    gegen
                    den Veranstalter, noch gegen Sponsoren Ansprüche erheben, sollte durch seine Teilnahme an der Veranstaltung
                    Schäden oder Verletzungen entstehen.
                    Der Haftungsausschluss gilt auch für Begleitpersonen.
                    Der Teilnehmer erklärt gesund und in einem ausreichenden Trainingszustand zu sein.
                </div>

                <div class="col-xs-3">Datenschutz:</div>
                <div class="col-xs-7">Der Teilnehmer erklärt sich damit einverstanden, dass in der Meldung angegebene personenbezogene Daten und die im Zusammenhang mit der Veranstaltung "Filsum löppt" gemachten Fotos und Filmaufnahmen ohne Vergütungsanspruch des Teilnehmers genutzt und an die Sponsoren und Partner der Veranstaltung weitergegeben werden dürfen.
                </div>

                <div class="col-xs-3">Hinweis laut Datenschutzgesetz:
                </div>
                <div class="col-xs-7">Daten werden maschinell gespeichert.
                </div>

                <div class="col-xs-3">Anmeldung:
                </div>
                <div class="col-xs-7">Die Veranstaltung ist beim Niedersächsischen Leichtathletik-Verband (NLV) angemeldet.
                 </div>

                <div class="col-xs-3">Allgemeines:
                </div>
                <div class="col-xs-7">Um den Organisationsaufwand am Wettkampftag gering zu halten, bitten wir darum die
                    Möglichkeit der Onlineanmeldung zu nutzen.
                </div>

                <div class="col-xs-3">Flyer:
                </div>
                <div class="col-xs-7">Download <a href="images/Flyer.pdf">Flyer Filsum</a>
                </div>

            </div>

        </div>

        <#include "/modul/sponsorList.ftl" />

    </div>
</div>

</@layout.default>