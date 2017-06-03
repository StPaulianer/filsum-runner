<#import "../layout/default.ftl" as layout>
<#import "/spring.ftl" as spring/>
<@layout.default >

    <#include "modul/navigation.ftl">

<div class="main">
    <div class="container">

        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="überschrift">
                <h3 class="text-center">Import</h3>
            </div>
            <div class="panel-body">

                <#if success??>
                    <div class="alert alert-success">
                        Die Daten wurden erfolgreich gespeichert.
                    </div>
                </#if>

                <#if message??>
                    <div class="alert alert-success">
                        Bitte wähle eine Datei aus.
                    </div>

                </#if>

                <#if problems??>
                    <div class="alert alert-danger">
                        ${problems}
                    </div>

                </#if>

                <form method="POST" action="/admin/import" enctype="multipart/form-data">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    <input type="file" name="file" /><br/><br/>


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