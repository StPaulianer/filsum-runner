<#import "layout/default.ftl" as layout>
<#import "/spring.ftl" as spring/>
<@layout.default >

<#include "modul/navigation.ftl">

<div class="main">
    <div class="container">

        <div class="row homecontainer">
            <div class=" col-xs-12">
                <img class="logo img-responsive center-block" src="../../images/logo_filsum_loeppt.gif">

            </div>
            <div class="col-xs-12">
                <h3 class="text-center">29. Juni 2018</h3>
                <p><a class="btn btn-primary btn-lg center-block btn-filsum" href="/register" role="button">Anmelden </a></p>
            </div>
        </div>

        <div class="logoRow">
            <#include "/modul/sponsorList.ftl" />
        </div>

    </div>
</div>

<script>
    setInterval(function() {
        window.location.reload();
    }, 12000000);
</script>
</@layout.default>