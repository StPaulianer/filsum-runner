<#import "layout/mail.ftl" as layout>

<@layout.mail "Test Mail">

<p>Moin,</p>
<p>
Vielen Dank, dass du an unserer Veranstaltung „Filsum löppt“ am 30.06.2017 teilnehmen möchtest.
Bitte überprüfe zunächst, ob deine Anmeldedaten korrekt sind:  </p>

<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <td>Strecke:</td>
        <td>${run.name!""}	</td>
    </tr>
    <tr>
        <td>Name:</td>
        <td>${runner.forename!""} ${runner.surname!""} </td>
    </tr>
    <tr>
        <td>Jahrgang:</td>
        <td>${runner.birthyear?c}</td>
    </tr>
    <tr>
        <td>Verein:</td>
        <td>${runner.club!""}</td>
    </tr>
    <tr>
        <td>T-Shirt: </td>
        <td> ${runner.shirt!""}</td>
    </tr>
</table>

<#if bambinis?has_content>
<p>Und folgende Bambinis wurden angemeldet:</p>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <td>Name:</td>
        <td>Jahrgang:</td>
        <td>Verein:</td>
    </tr>

    <#list bambinis as bambini>
    <tr>
        <td>${bambini.runner.forename!""} ${bambini.runner.surname!""} </td>
        <td>${bambini.runner.birthyear?c}</td>
        <td>${bambini.runner.club!""}</td>
    </tr>
    </#list>
</table>
</#if>

<p>
Solltest du Änderungen in den Anmeldedaten wünschen, dann schicke uns bitte eine E-Mail an: filsumloeppt@gmail.com unter Angabe deines Namens und den gewünschten Anpassungen.
Sind alle Anmeldedaten nach deinen Wünschen, dann überweise bitte den Betrag von ${run.charge!""} Euro auf folgendes Konto:  </p>

<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <td>Empfänger:</td>
        <td>Sportverein Blau Weiss Filsum e.V. 	</td>
    </tr>
    <tr>
        <td>Bank:</td>
        <td>Raiffeisen-Volksbank eG </td>
    </tr>
    <tr>
        <td>IBAN:</td>
        <td>DE77 285 62297 7200 58 6601 </td>
    </tr>
    <tr>
        <td>BIC:</td>
        <td>GENODEF1UPL</td>
    </tr>
    <tr>
        <td>Betrag:</td>
        <td>  ${run.charge!""} Euro</td>
    </tr>
    <tr>
        <td>Verwendungszweck: </td>
        <td> Filsum loeppt, ${runner.surname!""} ${runner.forename!""}</td>
    </tr>
</table>

<p>
Sobald Deine Zahlung bei uns eingegangen ist, werden wir dich in unsere Starterliste auf unserer Homepage <a href="http://www.filsumloeppt.de">www.filsumloeppt.de</a> aufnehmen. Erst dann ist der Anmeldevorgang vollständig abgeschlossen. Wir bitten Dich hierbei um Verständnis, dass die Aufnahme in die Starterliste 2-3 Werktage in Anspruch nehmen kann.
Es werden nur Anmeldungen berücksichtigt, deren Zahlungseingang vor dem 29.06.2017 erfolgt ist.
</p>

<p>Sportliche Grüße,    </p>
Euer Orga-Team von Filsum löppt

</@layout.mail>