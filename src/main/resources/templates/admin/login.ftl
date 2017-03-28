<#import "../layout/default.ftl" as layout>
<#import "/spring.ftl" as spring/>
<@layout.default >

<div class="main">
    <div class="container">


        <div class="col-lg-10 col-lg-offset-1">

            <form role="form" action="/login" class="form-horizontal" method="post">

                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="überschrift">
                        <h3 class="text-center">Anmeldung Adminbereich</h3>
                    </div>

                    <div class="panel-body">
                        <#if RequestParameters.error??>
                            <div class="alert alert-danger">
                                Benutzername oder Passwort ist falsch.
                            </div>
                        </#if>

                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>


                        <div class="form-group">
                            <label class="control-label col-sm-2" for="username">Benutzername</label>
                            <div class="col-sm-10">
                                <input type="username" name="username" id="username" required autofocus>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="password">Passwort</label>
                            <div class="col-sm-10"><input type="password" name="password" id="password" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="remember-me">Remember me</label>
                            <div class="col-sm-10"><input type="checkbox" name="remember-me" id="remember-me">
                            </div>
                        </div>
                        <button class="btn btn-primary btn-filsum" type="submit">Anmelden</button>
                    </div>
                </div>


            </form>
        </div>

    </div>
</div>

</@layout.default>